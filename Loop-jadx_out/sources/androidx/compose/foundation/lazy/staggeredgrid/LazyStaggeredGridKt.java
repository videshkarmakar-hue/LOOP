package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: LazyStaggeredGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m195d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyStaggeredGridKt {
    /* JADX INFO: renamed from: LazyStaggeredGrid-LJWHXA8, reason: not valid java name */
    public static final void m1067LazyStaggeredGridLJWHXA8(final LazyStaggeredGridState state, final Orientation orientation, final LazyGridStaggeredGridSlotsProvider slots, Modifier modifier, PaddingValues contentPadding, boolean reverseLayout, FlingBehavior flingBehavior, boolean userScrollEnabled, float mainAxisSpacing, float crossAxisSpacing, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        FlingBehavior flingBehavior2;
        float mainAxisSpacing2;
        float crossAxisSpacing2;
        Modifier modifier2;
        PaddingValues contentPadding2;
        boolean userScrollEnabled2;
        FlingBehavior flingBehavior3;
        int $dirty;
        boolean reverseLayout2;
        Composer $composer2;
        boolean reverseLayout3;
        Modifier modifier3;
        Composer $composer3 = $composer.startRestartGroup(288295126);
        ComposerKt.sourceInformation($composer3, "C(LazyStaggeredGrid)P(9,6,8,5,1,7,3,10,4:c#ui.unit.Dp,2:c#ui.unit.Dp)50@2313L15,60@2712L55,61@2793L24,62@2842L242,73@3109L60,79@3320L278,87@3668L57,90@3888L7,86@3612L385,94@4011L316,75@3175L1285:LazyStaggeredGrid.kt#fzvcnm");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(orientation) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= ($changed & 512) == 0 ? $composer3.changed(slots) : $composer3.changedInstance(slots) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changed(contentPadding) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer3.changed(reverseLayout) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer3.changed(flingBehavior)) ? 1048576 : 524288;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(userScrollEnabled) ? 8388608 : 4194304;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(mainAxisSpacing) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changed(crossAxisSpacing) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        int $dirty3 = $dirty1;
        if ((306783379 & $dirty2) == 306783378 && ($dirty3 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            contentPadding2 = contentPadding;
            reverseLayout3 = reverseLayout;
            flingBehavior3 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            mainAxisSpacing2 = mainAxisSpacing;
            crossAxisSpacing2 = crossAxisSpacing;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                PaddingValues contentPadding3 = i3 != 0 ? PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0)) : contentPadding;
                boolean reverseLayout4 = i4 != 0 ? false : reverseLayout;
                if ((i & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer3, 6);
                    $dirty2 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                boolean userScrollEnabled3 = i5 != 0 ? true : userScrollEnabled;
                float mainAxisSpacing3 = i6 != 0 ? C1979Dp.m6801constructorimpl(0) : mainAxisSpacing;
                if (i7 != 0) {
                    mainAxisSpacing2 = mainAxisSpacing3;
                    crossAxisSpacing2 = C1979Dp.m6801constructorimpl(0);
                    modifier2 = modifier4;
                    contentPadding2 = contentPadding3;
                    userScrollEnabled2 = userScrollEnabled3;
                    flingBehavior3 = flingBehavior2;
                    $dirty = $dirty2;
                    reverseLayout2 = reverseLayout4;
                } else {
                    mainAxisSpacing2 = mainAxisSpacing3;
                    crossAxisSpacing2 = crossAxisSpacing;
                    modifier2 = modifier4;
                    contentPadding2 = contentPadding3;
                    userScrollEnabled2 = userScrollEnabled3;
                    flingBehavior3 = flingBehavior2;
                    $dirty = $dirty2;
                    reverseLayout2 = reverseLayout4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    contentPadding2 = contentPadding;
                    reverseLayout2 = reverseLayout;
                    flingBehavior3 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    mainAxisSpacing2 = mainAxisSpacing;
                    crossAxisSpacing2 = crossAxisSpacing;
                    $dirty = (-3670017) & $dirty2;
                } else {
                    modifier2 = modifier;
                    contentPadding2 = contentPadding;
                    reverseLayout2 = reverseLayout;
                    flingBehavior3 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    mainAxisSpacing2 = mainAxisSpacing;
                    crossAxisSpacing2 = crossAxisSpacing;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(288295126, $dirty, $dirty3, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:59)");
            }
            Function0<LazyStaggeredGridItemProvider> function0RememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(state, function1, $composer3, ($dirty & 14) | (($dirty3 << 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv);
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int $dirty4 = $dirty;
            boolean reverseLayout5 = reverseLayout2;
            Modifier modifier5 = modifier2;
            $composer2 = $composer3;
            Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2M1077rememberStaggeredGridMeasurePolicy1tP8Re8 = LazyStaggeredGridMeasurePolicyKt.m1077rememberStaggeredGridMeasurePolicy1tP8Re8(state, function0RememberStaggeredGridItemProviderLambda, contentPadding2, reverseLayout2, orientation, mainAxisSpacing2, crossAxisSpacing2, coroutineScope, slots, $composer3, ($dirty & 14) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty << 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty << 18) & 234881024));
            LazyLayoutSemanticState semanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(state, reverseLayout5, $composer2, ($dirty4 & 14) | (($dirty4 >> 12) & 112));
            Modifier modifierLazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier5.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), function0RememberStaggeredGridItemProviderLambda, semanticState, orientation, userScrollEnabled2, reverseLayout5, $composer2, (($dirty4 << 6) & 7168) | (($dirty4 >> 9) & 57344) | ($dirty4 & 458752));
            LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsStateRememberLazyStaggeredGridBeyondBoundsState = LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(state, $composer2, $dirty4 & 14);
            LazyLayoutBeyondBoundsInfo beyondBoundsInfo = state.getBeyondBoundsInfo();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyLayoutKt.LazyLayout(function0RememberStaggeredGridItemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierLazyLayoutSemantics, lazyLayoutBeyondBoundsStateRememberLazyStaggeredGridBeyondBoundsState, beyondBoundsInfo, reverseLayout5, (LayoutDirection) objConsume, orientation, userScrollEnabled2, $composer2, (MutableVector.$stable << 6) | (($dirty4 >> 6) & 7168) | (($dirty4 << 12) & 458752) | (($dirty4 >> 3) & 3670016)), state, orientation, userScrollEnabled2, reverseLayout5, flingBehavior3, state.getMutableInteractionSource(), null, $composer2, (($dirty4 << 3) & 112) | (($dirty4 << 3) & 896) | (($dirty4 >> 12) & 7168) | (($dirty4 >> 3) & 57344) | (($dirty4 >> 3) & 458752), 64), state.getPrefetchState(), function2M1077rememberStaggeredGridMeasurePolicy1tP8Re8, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            reverseLayout3 = reverseLayout5;
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final PaddingValues paddingValues = contentPadding2;
            final boolean z = reverseLayout3;
            final FlingBehavior flingBehavior4 = flingBehavior3;
            final boolean z2 = userScrollEnabled2;
            final float f = mainAxisSpacing2;
            final float f2 = crossAxisSpacing2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
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
                    LazyStaggeredGridKt.m1067LazyStaggeredGridLJWHXA8(state, orientation, slots, modifier6, paddingValues, z, flingBehavior4, z2, f, f2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
