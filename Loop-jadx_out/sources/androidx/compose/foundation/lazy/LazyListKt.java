package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.GraphicsContext;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u0092\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\b\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0003¢\u0006\u0002\u0010)¨\u0006*"}, m195d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyListKt {
    public static final void LazyList(final Modifier modifier, final LazyListState state, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, final FlingBehavior flingBehavior, final boolean userScrollEnabled, int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Arrangement.Vertical verticalArrangement, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, final Function1<? super LazyListScope, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        Alignment.Horizontal horizontalAlignment2;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Vertical verticalAlignment2;
        Arrangement.Horizontal horizontalArrangement2;
        int $dirty;
        Composer $composer2;
        int beyondBoundsItemCount2;
        Composer $composer3 = $composer.startRestartGroup(620764179);
        ComposerKt.sourceInformation($composer3, "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)80@3794L50,82@3870L48,83@3944L24,84@4016L7,86@4049L341,106@4628L278,114@4976L153,120@5292L7,113@4920L481,125@5462L317,102@4483L1429:LazyList.kt#428nma");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(state) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(reverseLayout) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changed(isVertical) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer3.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(userScrollEnabled) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(beyondBoundsItemCount) ? 8388608 : 4194304;
        }
        int i3 = i & 256;
        if (i3 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(horizontalAlignment) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i4 = i & 512;
        if (i4 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changed(verticalArrangement) ? 536870912 : 268435456;
        }
        int i5 = i & 1024;
        if (i5 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(verticalAlignment) ? 4 : 2;
        }
        int i6 = i & 2048;
        if (i6 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changed(horizontalArrangement) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if ((306783379 & $dirty2) == 306783378 && ($dirty1 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            beyondBoundsItemCount2 = beyondBoundsItemCount;
            horizontalAlignment2 = horizontalAlignment;
            verticalArrangement2 = verticalArrangement;
            verticalAlignment2 = verticalAlignment;
            horizontalArrangement2 = horizontalArrangement;
            $composer2 = $composer3;
            $dirty = $dirty2;
        } else {
            int beyondBoundsItemCount3 = i2 != 0 ? 0 : beyondBoundsItemCount;
            horizontalAlignment2 = i3 != 0 ? null : horizontalAlignment;
            verticalArrangement2 = i4 != 0 ? null : verticalArrangement;
            verticalAlignment2 = i5 != 0 ? null : verticalAlignment;
            horizontalArrangement2 = i6 != 0 ? null : horizontalArrangement;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(620764179, $dirty2, $dirty1, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:79)");
            }
            Function0<LazyListItemProvider> function0RememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(state, function1, $composer3, (($dirty2 >> 3) & 14) | (($dirty1 >> 3) & 112));
            LazyLayoutSemanticState semanticState = LazyListSemanticsKt.rememberLazyListSemanticState(state, isVertical, $composer3, (($dirty2 >> 3) & 14) | (($dirty2 >> 9) & 112));
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
            ProvidableCompositionLocal<GraphicsContext> localGraphicsContext = CompositionLocalsKt.getLocalGraphicsContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localGraphicsContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            GraphicsContext graphicsContext = (GraphicsContext) objConsume;
            int $dirty3 = $dirty2;
            int beyondBoundsItemCount4 = beyondBoundsItemCount3;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2RememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(function0RememberLazyListItemProviderLambda, state, contentPadding, reverseLayout, isVertical, beyondBoundsItemCount3, horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2, coroutineScope, graphicsContext, $composer3, ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016) | (($dirty1 << 21) & 29360128) | (($dirty1 << 21) & 234881024) | (1879048192 & $dirty2), 0);
            Orientation orientation = isVertical ? Orientation.Vertical : Orientation.Horizontal;
            $dirty = $dirty3;
            Modifier modifierLazyLayoutSemantics = LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), function0RememberLazyListItemProviderLambda, semanticState, orientation, userScrollEnabled, reverseLayout, $composer3, (($dirty >> 6) & 57344) | (($dirty << 6) & 458752));
            $composer2 = $composer3;
            LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsStateRememberLazyListBeyondBoundsState = LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(state, beyondBoundsItemCount4, $composer2, (($dirty >> 3) & 14) | (($dirty >> 18) & 112));
            LazyLayoutBeyondBoundsInfo beyondBoundsInfo = state.getBeyondBoundsInfo();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyLayoutKt.LazyLayout(function0RememberLazyListItemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierLazyLayoutSemantics, lazyLayoutBeyondBoundsStateRememberLazyListBeyondBoundsState, beyondBoundsInfo, reverseLayout, (LayoutDirection) objConsume2, orientation, userScrollEnabled, $composer2, (MutableVector.$stable << 6) | ($dirty & 7168) | (3670016 & $dirty)).then(state.getItemAnimator().getModifier()), state, orientation, userScrollEnabled, reverseLayout, flingBehavior, state.getInternalInteractionSource(), null, $composer2, ($dirty & 112) | (($dirty >> 9) & 7168) | (($dirty << 3) & 57344) | ($dirty & 458752), 64), state.getPrefetchState(), function2RememberLazyListMeasurePolicy, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            beyondBoundsItemCount2 = beyondBoundsItemCount4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i7 = beyondBoundsItemCount2;
            final Alignment.Horizontal horizontal = horizontalAlignment2;
            final Arrangement.Vertical vertical = verticalArrangement2;
            final Alignment.Vertical vertical2 = verticalAlignment2;
            final Arrangement.Horizontal horizontal2 = horizontalArrangement2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.1
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
                    LazyListKt.LazyList(modifier, state, contentPadding, reverseLayout, isVertical, flingBehavior, userScrollEnabled, i7, horizontal, vertical, vertical2, horizontal2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:84:0x0103  */
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final Function0<? extends LazyListItemProvider> function0, final LazyListState state, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, final int beyondBoundsItemCount, final Alignment.Horizontal horizontalAlignment, final Alignment.Vertical verticalAlignment, final Arrangement.Horizontal horizontalArrangement, final Arrangement.Vertical verticalArrangement, final CoroutineScope coroutineScope, final GraphicsContext graphicsContext, Composer $composer, int $changed, int $changed1) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ComposerKt.sourceInformationMarkerStart($composer, -1962329526, "C(rememberLazyListMeasurePolicy)P(7,9,1,8,6!1,4,10,5,11)165@7036L8096:LazyList.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1962329526, $changed, $changed1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:165)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 434387083, "CC(remember):LazyList.kt#9igjgp");
        if ((($changed & 112) ^ 48) > 32 && $composer.changed(state)) {
            z = true;
        } else if (($changed & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        if ((($changed & 896) ^ 384) > 256 && $composer.changed(contentPadding)) {
            z2 = true;
        } else if (($changed & 384) == 256) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z9 = z | z2;
        if ((($changed & 7168) ^ 3072) > 2048 && $composer.changed(reverseLayout)) {
            z3 = true;
        } else if (($changed & 3072) == 2048) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z10 = z9 | z3;
        if (((57344 & $changed) ^ CpioConstants.C_ISBLK) > 16384 && $composer.changed(isVertical)) {
            z4 = true;
        } else if (($changed & CpioConstants.C_ISBLK) == 16384) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z11 = z10 | z4;
        if (((3670016 & $changed) ^ 1572864) > 1048576 && $composer.changed(horizontalAlignment)) {
            z5 = true;
        } else if (($changed & 1572864) == 1048576) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z12 = z11 | z5;
        if (((29360128 & $changed) ^ 12582912) > 8388608 && $composer.changed(verticalAlignment)) {
            z6 = true;
        } else if (($changed & 12582912) == 8388608) {
            z6 = true;
        } else {
            z6 = false;
        }
        boolean z13 = z12 | z6;
        if (((234881024 & $changed) ^ 100663296) > 67108864 && $composer.changed(horizontalArrangement)) {
            z7 = true;
        } else if (($changed & 100663296) == 67108864) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean z14 = z13 | z7;
        if (((1879048192 & $changed) ^ 805306368) <= 536870912 || !$composer.changed(verticalArrangement)) {
            z8 = (805306368 & $changed) == 536870912;
        }
        boolean invalid$iv = z14 | z8 | $composer.changed(graphicsContext);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m969invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyListMeasureResult m969invoke0kLqBqw(final LazyLayoutMeasureScope $this$null, final long containerConstraints) throws Throwable {
                    int i;
                    int i2;
                    int i3;
                    float spacing;
                    int iM6744getMaxWidthimpl;
                    final long visualItemOffset;
                    float scrollToBeConsumed;
                    Snapshot previous$iv$iv;
                    Snapshot this_$iv$iv;
                    ObservableScopeInvalidator.m1042attachToScopeimpl(state.m980getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    boolean hasLookaheadPassOccurred = state.getHasLookaheadPassOccurred() || $this$null.isLookingAhead();
                    CheckScrollableContainerConstraintsKt.m482checkScrollableContainerConstraintsK40F9xA(containerConstraints, isVertical ? Orientation.Vertical : Orientation.Horizontal);
                    if (isVertical) {
                        i = $this$null.mo561roundToPx0680j_4(contentPadding.mo819calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i = $this$null.mo561roundToPx0680j_4(PaddingKt.calculateStartPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int startPadding = i;
                    if (isVertical) {
                        i2 = $this$null.mo561roundToPx0680j_4(contentPadding.mo820calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i2 = $this$null.mo561roundToPx0680j_4(PaddingKt.calculateEndPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int endPadding = i2;
                    int topPadding = $this$null.mo561roundToPx0680j_4(contentPadding.getTop());
                    int bottomPadding = $this$null.mo561roundToPx0680j_4(contentPadding.getBottom());
                    final int totalVerticalPadding = topPadding + bottomPadding;
                    final int totalHorizontalPadding = startPadding + endPadding;
                    int totalMainAxisPadding = isVertical ? totalVerticalPadding : totalHorizontalPadding;
                    if (isVertical && !reverseLayout) {
                        i3 = topPadding;
                    } else if (isVertical && reverseLayout) {
                        i3 = bottomPadding;
                    } else {
                        i3 = (isVertical || reverseLayout) ? endPadding : startPadding;
                    }
                    final int beforeContentPadding = i3;
                    final int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
                    final long contentConstraints = ConstraintsKt.m6763offsetNN6EwU(containerConstraints, -totalHorizontalPadding, -totalVerticalPadding);
                    final LazyListItemProvider itemProvider = function0.invoke();
                    itemProvider.getItemScope().setMaxSize(Constraints.m6744getMaxWidthimpl(contentConstraints), Constraints.m6743getMaxHeightimpl(contentConstraints));
                    if (isVertical) {
                        Arrangement.Vertical vertical = verticalArrangement;
                        if (vertical == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                        }
                        spacing = vertical.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal = horizontalArrangement;
                        if (horizontal == null) {
                            throw new IllegalArgumentException("null horizontalAlignment when isVertical == false".toString());
                        }
                        spacing = horizontal.getSpacing();
                    }
                    float spaceBetweenItemsDp = spacing;
                    final int spaceBetweenItems = $this$null.mo561roundToPx0680j_4(spaceBetweenItemsDp);
                    final int itemsCount = itemProvider.getItemCount();
                    if (isVertical) {
                        iM6744getMaxWidthimpl = Constraints.m6743getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
                    } else {
                        iM6744getMaxWidthimpl = Constraints.m6744getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
                    }
                    int mainAxisAvailableSize = iM6744getMaxWidthimpl;
                    if (!reverseLayout || mainAxisAvailableSize > 0) {
                        visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
                    } else {
                        visualItemOffset = IntOffsetKt.IntOffset(isVertical ? startPadding : startPadding + mainAxisAvailableSize, isVertical ? topPadding + mainAxisAvailableSize : topPadding);
                    }
                    final boolean z15 = isVertical;
                    final Alignment.Horizontal horizontal2 = horizontalAlignment;
                    final Alignment.Vertical vertical2 = verticalAlignment;
                    final boolean z16 = reverseLayout;
                    final LazyListState lazyListState = state;
                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(contentConstraints, z15, itemProvider, $this$null, itemsCount, spaceBetweenItems, horizontal2, vertical2, z16, beforeContentPadding, afterContentPadding, visualItemOffset, lazyListState) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ int $itemsCount;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ int $spaceBetweenItems;
                        final /* synthetic */ LazyListState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                        final /* synthetic */ long $visualItemOffset;

                        {
                            this.$isVertical = z15;
                            this.$this_null = $this$null;
                            this.$itemsCount = itemsCount;
                            this.$spaceBetweenItems = spaceBetweenItems;
                            this.$horizontalAlignment = horizontal2;
                            this.$verticalAlignment = vertical2;
                            this.$reverseLayout = z16;
                            this.$beforeContentPadding = beforeContentPadding;
                            this.$afterContentPadding = afterContentPadding;
                            this.$visualItemOffset = visualItemOffset;
                            this.$state = lazyListState;
                        }

                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                        public LazyListMeasuredItem createItem(int index, Object key, Object contentType, List<? extends Placeable> placeables) {
                            int spacing2 = index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems;
                            return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, spacing2, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator(), null);
                        }
                    };
                    Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                    LazyListState lazyListState2 = state;
                    Snapshot previousSnapshot$iv = this_$iv.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = previousSnapshot$iv != null ? previousSnapshot$iv.getReadObserver() : null;
                    Snapshot newSnapshot$iv = this_$iv.makeCurrentNonObservable(previousSnapshot$iv);
                    try {
                        try {
                            int firstVisibleItemIndex = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider, lazyListState2.getFirstVisibleItemIndex());
                            try {
                                int firstVisibleScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
                                try {
                                    Unit unit = Unit.INSTANCE;
                                    this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                    List<Integer> listCalculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, state.getPinnedItems(), state.getBeyondBoundsInfo());
                                    if ($this$null.isLookingAhead() || !hasLookaheadPassOccurred) {
                                        scrollToBeConsumed = state.getScrollToBeConsumed();
                                    } else {
                                        scrollToBeConsumed = state.getScrollDeltaBetweenPasses$foundation_release();
                                    }
                                    Snapshot.Companion this_$iv2 = Snapshot.INSTANCE;
                                    boolean z17 = isVertical;
                                    Arrangement.Vertical vertical3 = verticalArrangement;
                                    Arrangement.Horizontal horizontal3 = horizontalArrangement;
                                    boolean z18 = reverseLayout;
                                    LazyListState lazyListState3 = state;
                                    int i4 = beyondBoundsItemCount;
                                    CoroutineScope coroutineScope2 = coroutineScope;
                                    GraphicsContext graphicsContext2 = graphicsContext;
                                    MutableSnapshot $this$withMutableSnapshot_u24lambda_u242$iv = Snapshot.Companion.takeMutableSnapshot$default(this_$iv2, null, null, 3, null);
                                    try {
                                        MutableSnapshot this_$iv$iv2 = $this$withMutableSnapshot_u24lambda_u242$iv;
                                        Snapshot previous$iv$iv2 = this_$iv$iv2.makeCurrent();
                                        try {
                                            try {
                                                previous$iv$iv = previous$iv$iv2;
                                                this_$iv$iv = this_$iv$iv2;
                                                try {
                                                    LazyListMeasureResult measureResult = LazyListMeasureKt.m974measureLazyListx0Ok8Vo(itemsCount, lazyListMeasuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenItems, firstVisibleItemIndex, firstVisibleScrollOffset, scrollToBeConsumed, contentConstraints, z17, itemProvider.getHeaderIndexes(), vertical3, horizontal3, z18, $this$null, lazyListState3.getItemAnimator(), i4, listCalculateLazyLayoutPinnedIndices, hasLookaheadPassOccurred, $this$null.isLookingAhead(), lazyListState3.getPostLookaheadLayoutInfo(), coroutineScope2, lazyListState3.m981getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext2, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                                        }

                                                        public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                            return $this$null.layout(ConstraintsKt.m6761constrainWidthK40F9xA(containerConstraints, totalHorizontalPadding + width), ConstraintsKt.m6760constrainHeightK40F9xA(containerConstraints, totalVerticalPadding + height), MapsKt.emptyMap(), function1);
                                                        }
                                                    });
                                                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                                                    $this$withMutableSnapshot_u24lambda_u242$iv.apply().check();
                                                    $this$withMutableSnapshot_u24lambda_u242$iv.dispose();
                                                    LazyListState.applyMeasureResult$foundation_release$default(state, measureResult, $this$null.isLookingAhead(), false, 4, null);
                                                    return measureResult;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                $this$withMutableSnapshot_u24lambda_u242$iv.dispose();
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            previous$iv$iv = previous$iv$iv2;
                                            this_$iv$iv = this_$iv$iv2;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    this_$iv.restoreNonObservable(previousSnapshot$iv, newSnapshot$iv, readObserver);
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
            };
            $composer.updateRememberedValue(value$iv);
        }
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return function2;
    }
}
