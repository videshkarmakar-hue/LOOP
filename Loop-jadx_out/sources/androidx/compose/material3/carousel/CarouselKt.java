package androidx.compose.material3.carousel;

import androidx.collection.IntIntMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ShapeDefaults;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.CornerRadiusKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.RoundRectKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.Outline;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Carousel.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000528\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u001421\u0010\u0015\u001a-\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0091\u0001\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0015\u001a-\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a}\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00122\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0015\u001a-\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0000\u001a \u0010*\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0000\u001a\u0018\u0010-\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0001\u001a \u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\bH\u0002\u001a\u0019\u00103\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00104\u001a\u0019\u00105\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00104\u001a4\u00106\u001a\u00020\u0011*\u00020\u00112\u0006\u00107\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020:H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, m195d2 = {"Carousel", "", "state", "Landroidx/compose/material3/carousel/CarouselState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "modifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "content", "Landroidx/compose/material3/carousel/CarouselScope;", "", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Carousel-eHTjO5g", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel", "preferredItemWidth", "minSmallItemWidth", "maxSmallItemWidth", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateBeyondViewportPageCount", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "calculateCurrentScrollOffset", "snapPositionMap", "Landroidx/collection/IntIntMap;", "calculateMaxScrollOffset", "getProgress", "before", "Landroidx/compose/material3/carousel/Keyline;", "after", "unadjustedOffset", "calculateAfterContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateBeforeContentPadding", "carouselItem", "index", "itemPositionMap", "isRtl", "", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CarouselKt {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: HorizontalMultiBrowseCarousel-zCIJ0Nk, reason: not valid java name */
    public static final void m2998HorizontalMultiBrowseCarouselzCIJ0Nk(final CarouselState state, final float preferredItemWidth, Modifier modifier, float itemSpacing, TargetedFlingBehavior flingBehavior, float minSmallItemWidth, float maxSmallItemWidth, PaddingValues contentPadding, final Function4<? super CarouselScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        float f;
        TargetedFlingBehavior flingBehavior2;
        float f2;
        float maxSmallItemWidth2;
        PaddingValues paddingValues;
        Modifier modifier2;
        float itemSpacing2;
        PaddingValues contentPadding2;
        TargetedFlingBehavior flingBehavior3;
        float maxSmallItemWidth3;
        int $dirty;
        float minSmallItemWidth2;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1825706865);
        ComposerKt.sourceInformation($composer2, "C(HorizontalMultiBrowseCarousel)P(8,7:c#ui.unit.Dp,6,3:c#ui.unit.Dp,2,5:c#ui.unit.Dp,4:c#ui.unit.Dp,1)110@5643L41,116@5968L7,120@6081L554,117@5980L832:Carousel.kt#dcf9yb");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(preferredItemWidth) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            f = itemSpacing;
        } else if (($changed & 3072) == 0) {
            f = itemSpacing;
            $dirty2 |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = itemSpacing;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                flingBehavior2 = flingBehavior;
                int i4 = $composer2.changed(flingBehavior2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                flingBehavior2 = flingBehavior;
            }
            $dirty2 |= i4;
        } else {
            flingBehavior2 = flingBehavior;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f2 = minSmallItemWidth;
        } else if ((196608 & $changed) == 0) {
            f2 = minSmallItemWidth;
            $dirty2 |= $composer2.changed(f2) ? 131072 : 65536;
        } else {
            f2 = minSmallItemWidth;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            maxSmallItemWidth2 = maxSmallItemWidth;
        } else if (($changed & 1572864) == 0) {
            maxSmallItemWidth2 = maxSmallItemWidth;
            $dirty2 |= $composer2.changed(maxSmallItemWidth2) ? 1048576 : 524288;
        } else {
            maxSmallItemWidth2 = maxSmallItemWidth;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
            paddingValues = contentPadding;
        } else if (($changed & 12582912) == 0) {
            paddingValues = contentPadding;
            $dirty2 |= $composer2.changed(paddingValues) ? 8388608 : 4194304;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            itemSpacing2 = f;
            contentPadding2 = paddingValues;
            flingBehavior3 = flingBehavior2;
            maxSmallItemWidth3 = maxSmallItemWidth2;
            minSmallItemWidth2 = f2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                itemSpacing2 = i3 != 0 ? C1979Dp.m6801constructorimpl(0) : f;
                if ((i & 16) != 0) {
                    TargetedFlingBehavior flingBehavior4 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(state, null, $composer2, ($dirty3 & 14) | 384, 2);
                    $dirty3 &= -57345;
                    flingBehavior2 = flingBehavior4;
                }
                float minSmallItemWidth3 = i5 != 0 ? CarouselDefaults.INSTANCE.m2996getMinSmallItemSizeD9Ej5fM$material3_release() : minSmallItemWidth;
                if (i6 != 0) {
                    maxSmallItemWidth2 = CarouselDefaults.INSTANCE.m2995getMaxSmallItemSizeD9Ej5fM$material3_release();
                }
                if (i7 != 0) {
                    contentPadding2 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                    flingBehavior3 = flingBehavior2;
                    maxSmallItemWidth3 = maxSmallItemWidth2;
                    $dirty = $dirty3;
                    minSmallItemWidth2 = minSmallItemWidth3;
                } else {
                    contentPadding2 = paddingValues;
                    flingBehavior3 = flingBehavior2;
                    maxSmallItemWidth3 = maxSmallItemWidth2;
                    $dirty = $dirty3;
                    minSmallItemWidth2 = minSmallItemWidth3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                modifier2 = modifier;
                itemSpacing2 = f;
                contentPadding2 = paddingValues;
                flingBehavior3 = flingBehavior2;
                maxSmallItemWidth3 = maxSmallItemWidth2;
                $dirty = $dirty3;
                minSmallItemWidth2 = f2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1825706865, $dirty, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:115)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) objConsume;
            Orientation orientation = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart($composer2, -1044018675, "CC(remember):Carousel.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(density) | (($dirty & 112) == 32) | $composer2.changedInstance(state) | (($dirty & 458752) == 131072) | ((3670016 & $dirty) == 1048576);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                final float f3 = minSmallItemWidth2;
                final float f4 = maxSmallItemWidth3;
                value$iv = new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ KeylineList invoke(Float f5, Float f6) {
                        return invoke(f5.floatValue(), f6.floatValue());
                    }

                    public final KeylineList invoke(float availableSpace, float itemSpacingPx) {
                        Density $this$invoke_u24lambda_u240 = density;
                        return KeylinesKt.multiBrowseKeylineList($this$invoke_u24lambda_u240, availableSpace, $this$invoke_u24lambda_u240.mo567toPx0680j_4(preferredItemWidth), itemSpacingPx, state.getItemCountState().getValue().invoke().intValue(), $this$invoke_u24lambda_u240.mo567toPx0680j_4(f3), $this$invoke_u24lambda_u240.mo567toPx0680j_4(f4));
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m2997CarouseleHTjO5g(state, orientation, (Function2) value$iv, contentPadding2, modifier2, itemSpacing2, flingBehavior3, function4, $composer2, ($dirty & 14) | 48 | (($dirty >> 12) & 7168) | (($dirty << 6) & 57344) | (458752 & ($dirty << 6)) | (3670016 & ($dirty << 6)) | (($dirty >> 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final float f5 = itemSpacing2;
            final TargetedFlingBehavior targetedFlingBehavior = flingBehavior3;
            final float f6 = minSmallItemWidth2;
            final float f7 = maxSmallItemWidth3;
            final PaddingValues paddingValues2 = contentPadding2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalMultiBrowseCarousel$2
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

                public final void invoke(Composer composer, int i8) {
                    CarouselKt.m2998HorizontalMultiBrowseCarouselzCIJ0Nk(state, preferredItemWidth, modifier3, f5, targetedFlingBehavior, f6, f7, paddingValues2, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: HorizontalUncontainedCarousel-9QcgTRs, reason: not valid java name */
    public static final void m2999HorizontalUncontainedCarousel9QcgTRs(final CarouselState state, final float itemWidth, Modifier modifier, float itemSpacing, TargetedFlingBehavior flingBehavior, PaddingValues contentPadding, final Function4<? super CarouselScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float itemSpacing2;
        TargetedFlingBehavior flingBehavior2;
        PaddingValues paddingValues;
        Modifier.Companion modifier3;
        PaddingValues contentPadding2;
        Object value$iv;
        Modifier modifier4;
        PaddingValues contentPadding3;
        float itemSpacing3;
        TargetedFlingBehavior flingBehavior3;
        Composer $composer2 = $composer.startRestartGroup(529322840);
        ComposerKt.sourceInformation($composer2, "C(HorizontalUncontainedCarousel)P(6,4:c#ui.unit.Dp,5,3:c#ui.unit.Dp,2,1)174@8522L21,178@8701L7,182@8814L337,179@8713L615:Carousel.kt#dcf9yb");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(itemWidth) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            itemSpacing2 = itemSpacing;
        } else if (($changed & 3072) == 0) {
            itemSpacing2 = itemSpacing;
            $dirty |= $composer2.changed(itemSpacing2) ? 2048 : 1024;
        } else {
            itemSpacing2 = itemSpacing;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                flingBehavior2 = flingBehavior;
                int i4 = $composer2.changed(flingBehavior2) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                flingBehavior2 = flingBehavior;
            }
            $dirty |= i4;
        } else {
            flingBehavior2 = flingBehavior;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            paddingValues = contentPadding;
        } else if ((196608 & $changed) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer2.changed(paddingValues) ? 131072 : 65536;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 1048576 : 524288;
        }
        if ((599187 & $dirty) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            flingBehavior3 = flingBehavior2;
            contentPadding3 = paddingValues;
            itemSpacing3 = itemSpacing2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    itemSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                int $this$dp$iv = i & 16;
                if ($this$dp$iv != 0) {
                    $dirty &= -57345;
                    flingBehavior2 = CarouselDefaults.INSTANCE.noSnapFlingBehavior($composer2, 6);
                }
                contentPadding2 = i5 != 0 ? PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0)) : paddingValues;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier3 = modifier2;
                contentPadding2 = paddingValues;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(529322840, $dirty, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:177)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) objConsume;
            Orientation orientation = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart($composer2, -493431357, "CC(remember):Carousel.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(density) | (($dirty & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function2) new Function2<Float, Float, KeylineList>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ KeylineList invoke(Float f, Float f2) {
                        return invoke(f.floatValue(), f2.floatValue());
                    }

                    public final KeylineList invoke(float availableSpace, float itemSpacingPx) {
                        Density $this$invoke_u24lambda_u240 = density;
                        return KeylinesKt.uncontainedKeylineList($this$invoke_u24lambda_u240, availableSpace, $this$invoke_u24lambda_u240.mo567toPx0680j_4(itemWidth), itemSpacingPx);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m2997CarouseleHTjO5g(state, orientation, (Function2) value$iv, contentPadding2, modifier3, itemSpacing2, flingBehavior2, function4, $composer2, ($dirty & 14) | 48 | (($dirty >> 6) & 7168) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752) | (($dirty << 6) & 3670016) | (($dirty << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            contentPadding3 = contentPadding2;
            itemSpacing3 = itemSpacing2;
            flingBehavior3 = flingBehavior2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final float f = itemSpacing3;
            final TargetedFlingBehavior targetedFlingBehavior = flingBehavior3;
            final PaddingValues paddingValues2 = contentPadding3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$HorizontalUncontainedCarousel$2
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

                public final void invoke(Composer composer, int i6) {
                    CarouselKt.m2999HorizontalUncontainedCarousel9QcgTRs(state, itemWidth, modifier5, f, targetedFlingBehavior, paddingValues2, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: Carousel-eHTjO5g, reason: not valid java name */
    public static final void m2997CarouseleHTjO5g(final CarouselState state, final Orientation orientation, final Function2<? super Float, ? super Float, KeylineList> function2, final PaddingValues contentPadding, Modifier modifier, float itemSpacing, TargetedFlingBehavior flingBehavior, final Function4<? super CarouselScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float itemSpacing2;
        TargetedFlingBehavior flingBehavior2;
        Modifier modifier3;
        TargetedFlingBehavior flingBehavior3;
        int $dirty;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        float itemSpacing3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-751446054);
        ComposerKt.sourceInformation($composer2, "C(Carousel)P(7,6,4,1,5,3:c#ui.unit.Dp,2)229@10962L41,232@11110L7,233@11187L42,234@11275L41,235@11336L110,239@11482L112,244@11664L166,250@11854L66:Carousel.kt#dcf9yb");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(orientation) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(contentPadding) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            modifier2 = modifier;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            itemSpacing2 = itemSpacing;
        } else if ((196608 & $changed) == 0) {
            itemSpacing2 = itemSpacing;
            $dirty2 |= $composer2.changed(itemSpacing2) ? 131072 : 65536;
        } else {
            itemSpacing2 = itemSpacing;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                flingBehavior2 = flingBehavior;
                int i4 = $composer2.changed(flingBehavior2) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                flingBehavior2 = flingBehavior;
            }
            $dirty2 |= i4;
        } else {
            flingBehavior2 = flingBehavior;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function4) ? 8388608 : 4194304;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            itemSpacing3 = itemSpacing2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                float itemSpacing4 = i3 != 0 ? C1979Dp.m6801constructorimpl(0) : itemSpacing2;
                if ((i & 64) != 0) {
                    flingBehavior3 = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(state, null, $composer2, ($dirty3 & 14) | 384, 2);
                    $dirty = $dirty3 & (-3670017);
                    itemSpacing2 = itemSpacing4;
                } else {
                    flingBehavior3 = flingBehavior2;
                    $dirty = $dirty3;
                    itemSpacing2 = itemSpacing4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                modifier3 = modifier2;
                flingBehavior3 = flingBehavior2;
                $dirty = $dirty3;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-751446054, $dirty, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:231)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final boolean isRtl = objConsume == LayoutDirection.Rtl;
            float beforeContentPadding = calculateBeforeContentPadding(contentPadding, orientation, $composer2, (($dirty >> 9) & 14) | ($dirty & 112));
            float afterContentPadding = calculateAfterContentPadding(contentPadding, orientation, $composer2, (($dirty >> 9) & 14) | ($dirty & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, 896637629, "CC(remember):Carousel.kt#9igjgp");
            boolean invalid$iv = ($dirty & 896) == 256;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new CarouselPageSize(function2, beforeContentPadding, afterContentPadding);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final CarouselPageSize pageSize = (CarouselPageSize) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float itemMainAxisSize$material3_release = pageSize.getStrategy().getItemMainAxisSize$material3_release();
            ComposerKt.sourceInformationMarkerStart($composer2, 896637775, "CC(remember):Carousel.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(itemMainAxisSize$material3_release);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = Integer.valueOf(calculateBeyondViewportPageCount(pageSize.getStrategy()));
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            int beyondViewportPageCount = ((Number) value$iv2).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CarouselScopeImpl carouselScope = CarouselScopeImpl.INSTANCE;
            float itemMainAxisSize$material3_release2 = pageSize.getStrategy().getItemMainAxisSize$material3_release();
            ComposerKt.sourceInformationMarkerStart($composer2, 896637957, "CC(remember):Carousel.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(itemMainAxisSize$material3_release2);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = KeylineSnapPositionKt.calculateSnapPositions(pageSize.getStrategy(), state.getItemCountState().getValue().invoke().intValue());
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final IntIntMap snapPositionMap = (IntIntMap) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 896638147, "CC(remember):Carousel.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(snapPositionMap);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = KeylineSnapPositionKt.KeylineSnapPosition(snapPositionMap);
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            SnapPosition snapPosition = (SnapPosition) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (orientation == Orientation.Horizontal) {
                $composer2.startReplaceGroup(896638272);
                ComposerKt.sourceInformation($composer2, "266@12576L386,253@11979L983");
                PagerKt.m1101HorizontalPageroI3XNZo(state.getPagerState(), modifier3, PaddingKt.m865PaddingValuesa9UjIt4$default(0.0f, contentPadding.getTop(), 0.0f, contentPadding.getBottom(), 5, null), pageSize, beyondViewportPageCount, itemSpacing2, null, flingBehavior3, false, false, null, null, snapPosition, ComposableLambdaKt.rememberComposableLambda(-1894608579, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer, Integer num2) {
                        invoke(pagerScope, num.intValue(), composer, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope $this$HorizontalPager, int page, Composer $composer3, int $changed2) {
                        Function0<ComposeUiNode> function0;
                        ComposerKt.sourceInformation($composer3, "C267@12598L354:Carousel.kt#dcf9yb");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1894608579, $changed2, -1, "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:267)");
                        }
                        Modifier modifier$iv = CarouselKt.carouselItem(Modifier.INSTANCE, page, state, pageSize.getStrategy(), snapPositionMap, isRtl);
                        Function4<CarouselScope, Integer, Composer, Integer, Unit> function5 = function4;
                        CarouselScopeImpl carouselScopeImpl = carouselScope;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i6 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -637948762, "C276@12925L13:Carousel.kt#dcf9yb");
                        function5.invoke(carouselScopeImpl, Integer.valueOf(page), $composer3, Integer.valueOf(($changed2 & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), $composer2, (($dirty >> 9) & 112) | (458752 & $dirty) | (($dirty << 3) & 29360128), 3072, 3904);
                $composer2.endReplaceGroup();
            } else if (orientation == Orientation.Vertical) {
                $composer2.startReplaceGroup(896639318);
                ComposerKt.sourceInformation($composer2, "284@13301L7,285@13389L7,293@13674L386,280@13025L1035");
                PagerState pagerState = state.getPagerState();
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer2.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                float fCalculateStartPadding = PaddingKt.calculateStartPadding(contentPadding, (LayoutDirection) objConsume2);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer2.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final boolean z = isRtl;
                PagerKt.m1102VerticalPageroI3XNZo(pagerState, modifier3, PaddingKt.m865PaddingValuesa9UjIt4$default(fCalculateStartPadding, 0.0f, PaddingKt.calculateEndPadding(contentPadding, (LayoutDirection) objConsume3), 0.0f, 10, null), pageSize, beyondViewportPageCount, itemSpacing2, null, flingBehavior3, false, false, null, null, snapPosition, ComposableLambdaKt.rememberComposableLambda(1874239046, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer, Integer num2) {
                        invoke(pagerScope, num.intValue(), composer, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope $this$VerticalPager, int page, Composer $composer3, int $changed2) {
                        Function0<ComposeUiNode> function0;
                        ComposerKt.sourceInformation($composer3, "C294@13696L354:Carousel.kt#dcf9yb");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1874239046, $changed2, -1, "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:294)");
                        }
                        Modifier modifier$iv = CarouselKt.carouselItem(Modifier.INSTANCE, page, state, pageSize.getStrategy(), snapPositionMap, z);
                        Function4<CarouselScope, Integer, Composer, Integer, Unit> function5 = function4;
                        CarouselScopeImpl carouselScopeImpl = carouselScope;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i5 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i6 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -637947664, "C303@14023L13:Carousel.kt#dcf9yb");
                        function5.invoke(carouselScopeImpl, Integer.valueOf(page), $composer3, Integer.valueOf(($changed2 & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), $composer2, (($dirty >> 9) & 112) | (458752 & $dirty) | (($dirty << 3) & 29360128), 3072, 3904);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(896640359);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            flingBehavior2 = flingBehavior3;
            itemSpacing3 = itemSpacing2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final float f = itemSpacing3;
            final TargetedFlingBehavior targetedFlingBehavior = flingBehavior2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$3
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
                    CarouselKt.m2997CarouseleHTjO5g(state, orientation, function2, contentPadding, modifier5, f, targetedFlingBehavior, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final float calculateBeforeContentPadding(PaddingValues $this$calculateBeforeContentPadding, Orientation orientation, Composer $composer, int $changed) {
        float dpValue;
        ComposerKt.sourceInformationMarkerStart($composer, 1896839347, "C(calculateBeforeContentPadding)*317@14373L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896839347, $changed, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:310)");
        }
        $composer.startReplaceGroup(286635773);
        ComposerKt.sourceInformation($composer, "314@14328L7");
        if (orientation == Orientation.Vertical) {
            dpValue = $this$calculateBeforeContentPadding.getTop();
        } else {
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer);
            dpValue = PaddingKt.calculateStartPadding($this$calculateBeforeContentPadding, (LayoutDirection) objConsume);
        }
        $composer.endReplaceGroup();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$calculateBeforeContentPadding_u24lambda_u246 = (Density) objConsume2;
        float fMo567toPx0680j_4 = $this$calculateBeforeContentPadding_u24lambda_u246.mo567toPx0680j_4(dpValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return fMo567toPx0680j_4;
    }

    private static final float calculateAfterContentPadding(PaddingValues $this$calculateAfterContentPadding, Orientation orientation, Composer $composer, int $changed) {
        float dpValue;
        ComposerKt.sourceInformationMarkerStart($composer, 1018496720, "C(calculateAfterContentPadding)*328@14707L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018496720, $changed, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:321)");
        }
        $composer.startReplaceGroup(119590115);
        ComposerKt.sourceInformation($composer, "325@14662L7");
        if (orientation == Orientation.Vertical) {
            dpValue = $this$calculateAfterContentPadding.getBottom();
        } else {
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer);
            dpValue = PaddingKt.calculateEndPadding($this$calculateAfterContentPadding, (LayoutDirection) objConsume);
        }
        $composer.endReplaceGroup();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$calculateAfterContentPadding_u24lambda_u247 = (Density) objConsume2;
        float fMo567toPx0680j_4 = $this$calculateAfterContentPadding_u24lambda_u247.mo567toPx0680j_4(dpValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return fMo567toPx0680j_4;
    }

    public static final int calculateBeyondViewportPageCount(Strategy strategy) {
        if (!strategy.isValid()) {
            return 0;
        }
        float totalKeylineSpace = 0.0f;
        int totalNonAnchorKeylines = 0;
        List $this$fastFilter$iv = strategy.getDefaultKeylines$material3_release();
        List target$iv = new ArrayList($this$fastFilter$iv.size());
        int size = $this$fastFilter$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Keyline keyline = $this$fastFilter$iv.get(index$iv$iv);
            Keyline it = keyline;
            if (!it.isAnchor()) {
                target$iv.add(keyline);
            }
        }
        List $this$fastForEach$iv = target$iv;
        int size2 = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Keyline it2 = (Keyline) item$iv;
            totalKeylineSpace += it2.getSize();
            totalNonAnchorKeylines++;
        }
        int itemsLoaded = (int) Math.ceil(totalKeylineSpace / strategy.getItemMainAxisSize$material3_release());
        int itemsToLoad = totalNonAnchorKeylines - itemsLoaded;
        return itemsToLoad + 1;
    }

    public static final Modifier carouselItem(Modifier $this$carouselItem, final int index, final CarouselState state, final Strategy strategy, final IntIntMap itemPositionMap, final boolean isRtl) {
        if (!strategy.isValid()) {
            return $this$carouselItem;
        }
        final boolean isVertical = state.getPagerState().getLayoutInfo().getOrientation() == Orientation.Vertical;
        final boolean z = isVertical;
        return GraphicsLayerModifierKt.graphicsLayer(LayoutModifierKt.layout($this$carouselItem, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m3000invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m3000invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                long itemConstraints;
                float mainAxisSize = strategy.getItemMainAxisSize$material3_release();
                if (isVertical) {
                    itemConstraints = Constraints.m6734copyZbe2FdA(constraints, Constraints.m6746getMinWidthimpl(constraints), Constraints.m6744getMaxWidthimpl(constraints), MathKt.roundToInt(mainAxisSize), MathKt.roundToInt(mainAxisSize));
                } else {
                    itemConstraints = Constraints.m6734copyZbe2FdA(constraints, MathKt.roundToInt(mainAxisSize), MathKt.roundToInt(mainAxisSize), Constraints.m6745getMinHeightimpl(constraints), Constraints.m6743getMaxHeightimpl(constraints));
                }
                final Placeable placeable = measurable.mo5644measureBRTryo0(itemConstraints);
                return MeasureScope.CC.layout$default($this$layout, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                        Placeable.PlacementScope.place$default($this$layout2, placeable, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        }), new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                float scrollOffset = CarouselKt.calculateCurrentScrollOffset(state, strategy, itemPositionMap);
                float maxScrollOffset = CarouselKt.calculateMaxScrollOffset(state, strategy);
                KeylineList keylines = Strategy.getKeylineListForScrollOffset$material3_release$default(strategy, scrollOffset, maxScrollOffset, false, 4, null);
                float itemSizeWithSpacing = strategy.getItemMainAxisSize$material3_release() + strategy.getItemSpacing();
                float unadjustedCenter = ((index * itemSizeWithSpacing) + (strategy.getItemMainAxisSize$material3_release() / 2.0f)) - scrollOffset;
                Keyline keylineBefore = keylines.getKeylineBefore(unadjustedCenter);
                Keyline keylineAfter = keylines.getKeylineAfter(unadjustedCenter);
                float progress = CarouselKt.getProgress(keylineBefore, keylineAfter, unadjustedCenter);
                final Keyline interpolatedKeyline = KeylineListKt.lerp(keylineBefore, keylineAfter, progress);
                boolean isOutOfKeylineBounds = Intrinsics.areEqual(keylineBefore, keylineAfter);
                $this$graphicsLayer.setClip(true);
                final boolean z2 = z;
                final Strategy strategy2 = strategy;
                $this$graphicsLayer.setShape(new Shape() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.2.1
                    private final RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape(ShapeDefaults.INSTANCE.getExtraLarge().getTopStart());

                    public final RoundedCornerShape getRoundedCornerShape() {
                        return this.roundedCornerShape;
                    }

                    @Override // androidx.compose.p001ui.graphics.Shape
                    /* JADX INFO: renamed from: createOutline-Pq9zytI */
                    public Outline mo502createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                        float centerX = (z2 ? Size.m4115getHeightimpl(size) : strategy2.getItemMainAxisSize$material3_release()) / 2.0f;
                        float centerY = (z2 ? strategy2.getItemMainAxisSize$material3_release() : Size.m4115getHeightimpl(size)) / 2.0f;
                        float halfMaskWidth = (z2 ? Size.m4118getWidthimpl(size) : interpolatedKeyline.getSize()) / 2.0f;
                        float halfMaskHeight = (z2 ? interpolatedKeyline.getSize() : Size.m4115getHeightimpl(size)) / 2.0f;
                        Rect rect = new Rect(centerX - halfMaskWidth, centerY - halfMaskHeight, centerX + halfMaskWidth, centerY + halfMaskHeight);
                        float cornerSize = this.roundedCornerShape.getTopStart().mo1137toPxTmRCtEA(SizeKt.Size(rect.getWidth(), rect.getHeight()), density);
                        long cornerRadius = CornerRadiusKt.CornerRadius$default(cornerSize, 0.0f, 2, null);
                        return new Outline.Rounded(RoundRectKt.m4101RoundRectZAM2FJo(rect, cornerRadius, cornerRadius, cornerRadius, cornerRadius));
                    }
                });
                float translation = interpolatedKeyline.getOffset() - unadjustedCenter;
                if (isOutOfKeylineBounds) {
                    float outOfBoundsOffset = (unadjustedCenter - interpolatedKeyline.getUnadjustedOffset()) / interpolatedKeyline.getSize();
                    translation += outOfBoundsOffset;
                }
                if (z) {
                    $this$graphicsLayer.setTranslationY(translation);
                } else {
                    $this$graphicsLayer.setTranslationX(isRtl ? -translation : translation);
                }
            }
        });
    }

    public static final float calculateCurrentScrollOffset(CarouselState state, Strategy strategy, IntIntMap snapPositionMap) {
        float itemSizeWithSpacing = strategy.getItemMainAxisSize$material3_release() + strategy.getItemSpacing();
        float currentItemScrollOffset = (state.getPagerState().getCurrentPage() * itemSizeWithSpacing) + (state.getPagerState().getCurrentPageOffsetFraction() * itemSizeWithSpacing);
        return currentItemScrollOffset - (snapPositionMap.get_size() > 0 ? snapPositionMap.get(state.getPagerState().getCurrentPage()) : 0);
    }

    public static final float calculateMaxScrollOffset(CarouselState state, Strategy strategy) {
        float itemCount = state.getPagerState().getPageCount();
        float maxScrollPossible = (strategy.getItemMainAxisSize$material3_release() * itemCount) + (strategy.getItemSpacing() * (itemCount - 1));
        return RangesKt.coerceAtLeast(maxScrollPossible - strategy.getAvailableSpace(), 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getProgress(Keyline before, Keyline after, float unadjustedOffset) {
        if (Intrinsics.areEqual(before, after)) {
            return 1.0f;
        }
        float total = after.getUnadjustedOffset() - before.getUnadjustedOffset();
        return (unadjustedOffset - before.getUnadjustedOffset()) / total;
    }
}
