package com.google.accompanist.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.unit.Velocity;
import androidx.compose.p001ui.unit.VelocityKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import dev.chrisbanes.snapper.SnapperFlingBehavior;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Pager.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aÄ\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u000121\u0010\u001a\u001a-\u0012\u0004\u0012\u00020\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aÆ\u0001\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020$21\u0010\u001a\u001a-\u0012\u0004\u0012\u00020\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aÄ\u0001\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u000121\u0010\u001a\u001a-\u0012\u0004\u0012\u00020\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010*\u001a\u00020+*\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0005H\u0007\u001a&\u0010,\u001a\u00020-*\u00020-2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a&\u0010,\u001a\u000202*\u0002022\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00101\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, m195d2 = {"DebugLog", "", "HorizontalPager", "", "count", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/google/accompanist/pager/PagerState;", "reverseLayout", "itemSpacing", "Landroidx/compose/ui/unit/Dp;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "page", "", "userScrollEnabled", "content", "Lkotlin/Function2;", "Lcom/google/accompanist/pager/PagerScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-7SJ-wSw", "(ILandroidx/compose/ui/Modifier;Lcom/google/accompanist/pager/PagerState;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "Pager", "isVertical", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Pager-upBTbn8", "(ILandroidx/compose/ui/Modifier;Lcom/google/accompanist/pager/PagerState;ZFZLandroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "VerticalPager-7SJ-wSw", "(ILandroidx/compose/ui/Modifier;Lcom/google/accompanist/pager/PagerState;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "calculateCurrentOffsetForPage", "", "consume", "Landroidx/compose/ui/geometry/Offset;", "consumeHorizontal", "consumeVertical", "consume-9KIMszo", "(JZZ)J", "Landroidx/compose/ui/unit/Velocity;", "consume-BMRW4eQ", "pager_release"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Pager {
    public static final boolean DebugLog = false;

    @Deprecated(message = "\naccompanist/pager is deprecated.\nThe androidx.compose equivalent of HorizontalPager is androidx.compose.foundation.pager.HorizontalPager\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n", replaceWith = @ReplaceWith(expression = "HorizontalPager", imports = {"androidx.compose.foundation.pager.HorizontalPager"}))
    /* JADX INFO: renamed from: HorizontalPager-7SJ-wSw, reason: not valid java name */
    public static final void m7169HorizontalPager7SJwSw(final int count, Modifier modifier, PagerState state, boolean reverseLayout, float itemSpacing, PaddingValues contentPadding, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, Function1<? super Integer, ? extends Object> function1, boolean userScrollEnabled, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PagerState pagerState;
        boolean reverseLayout2;
        float f;
        Modifier modifier3;
        int $dirty;
        PagerState state2;
        PaddingValues contentPadding2;
        FlingBehavior flingBehavior2;
        boolean userScrollEnabled2;
        FlingBehavior flingBehavior3;
        float itemSpacing2;
        Alignment.Vertical verticalAlignment2;
        int $dirty2;
        Function1<? super Integer, ? extends Object> function2;
        boolean reverseLayout3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-131850087);
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(count) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                pagerState = state;
                int i3 = $composer3.changed(pagerState) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                pagerState = state;
            }
            $dirty3 |= i3;
        } else {
            pagerState = state;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty3 |= $composer3.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
            f = itemSpacing;
        } else if (($changed & 57344) == 0) {
            f = itemSpacing;
            $dirty3 |= $composer3.changed(f) ? 16384 : 8192;
        } else {
            f = itemSpacing;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(contentPadding) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changed(verticalAlignment) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty3 |= ((i & 128) == 0 && $composer3.changed(flingBehavior)) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(userScrollEnabled) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(content) ? 4 : 2;
        }
        int $dirty4 = $dirty1;
        if ((1533916891 & $dirty3) == 306783378 && ($dirty4 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            verticalAlignment2 = verticalAlignment;
            flingBehavior3 = flingBehavior;
            function2 = function1;
            userScrollEnabled2 = userScrollEnabled;
            itemSpacing2 = f;
            modifier3 = modifier2;
            state2 = pagerState;
            $composer2 = $composer3;
            reverseLayout3 = reverseLayout2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty = $dirty3 & (-897);
                    state2 = PagerStateKt.rememberPagerState(0, $composer3, 0, 1);
                } else {
                    $dirty = $dirty3;
                    state2 = pagerState;
                }
                if (i4 != 0) {
                    reverseLayout2 = false;
                }
                float itemSpacing3 = i5 != 0 ? C1979Dp.m6801constructorimpl(0) : f;
                contentPadding2 = i6 != 0 ? PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0)) : contentPadding;
                Alignment.Vertical verticalAlignment3 = i7 != 0 ? Alignment.INSTANCE.getCenterVertically() : verticalAlignment;
                if ((i & 128) != 0) {
                    flingBehavior2 = PagerDefaults.INSTANCE.m7176flingBehaviorjt2gSs(state2, null, null, PaddingKt.calculateEndPadding(contentPadding2, LayoutDirection.Ltr), $composer3, (($dirty >> 6) & 14) | CpioConstants.C_ISBLK, 6);
                    $dirty &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                Function1<? super Integer, ? extends Object> function3 = i8 != 0 ? null : function1;
                if (i9 != 0) {
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = true;
                    itemSpacing2 = itemSpacing3;
                    verticalAlignment2 = verticalAlignment3;
                    $dirty2 = $dirty;
                    function2 = function3;
                    reverseLayout3 = reverseLayout2;
                } else {
                    userScrollEnabled2 = userScrollEnabled;
                    flingBehavior3 = flingBehavior2;
                    itemSpacing2 = itemSpacing3;
                    verticalAlignment2 = verticalAlignment3;
                    $dirty2 = $dirty;
                    function2 = function3;
                    reverseLayout3 = reverseLayout2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                contentPadding2 = contentPadding;
                verticalAlignment2 = verticalAlignment;
                flingBehavior3 = flingBehavior;
                function2 = function1;
                userScrollEnabled2 = userScrollEnabled;
                $dirty2 = $dirty3;
                itemSpacing2 = f;
                modifier3 = modifier2;
                state2 = pagerState;
                reverseLayout3 = reverseLayout2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-131850087, $dirty2, $dirty4, "com.google.accompanist.pager.HorizontalPager (Pager.kt:284)");
            }
            $composer2 = $composer3;
            m7170PagerupBTbn8(count, modifier3, state2, reverseLayout3, itemSpacing2, false, flingBehavior3, function2, contentPadding2, userScrollEnabled2, verticalAlignment2, null, content, $composer2, ($dirty2 & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21 | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty2 >> 3) & 3670016) | (($dirty2 >> 3) & 29360128) | (($dirty2 << 9) & 234881024) | ($dirty2 & 1879048192), (($dirty2 >> 18) & 14) | (($dirty4 << 6) & 896), 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final PagerState pagerState2 = state2;
            final boolean z = reverseLayout3;
            final float f2 = itemSpacing2;
            final PaddingValues paddingValues = contentPadding2;
            final Alignment.Vertical vertical = verticalAlignment2;
            final FlingBehavior flingBehavior4 = flingBehavior3;
            final Function1<? super Integer, ? extends Object> function4 = function2;
            final boolean z2 = userScrollEnabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$HorizontalPager$1
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

                public final void invoke(Composer composer, int i10) {
                    Pager.m7169HorizontalPager7SJwSw(count, modifier4, pagerState2, z, f2, paddingValues, vertical, flingBehavior4, function4, z2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(message = "\naccompanist/pager is deprecated.\nThe androidx.compose equivalent of VerticalPager is androidx.compose.foundation.pager.VerticalPager.\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
    /* JADX INFO: renamed from: VerticalPager-7SJ-wSw, reason: not valid java name */
    public static final void m7171VerticalPager7SJwSw(final int count, Modifier modifier, PagerState state, boolean reverseLayout, float itemSpacing, PaddingValues contentPadding, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, Function1<? super Integer, ? extends Object> function1, boolean userScrollEnabled, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PagerState pagerState;
        boolean reverseLayout2;
        float f;
        Modifier modifier3;
        int $dirty;
        PagerState state2;
        FlingBehavior flingBehavior2;
        boolean userScrollEnabled2;
        Function1<? super Integer, ? extends Object> function2;
        PaddingValues contentPadding2;
        Alignment.Horizontal horizontalAlignment2;
        int $dirty2;
        FlingBehavior flingBehavior3;
        boolean reverseLayout3;
        float itemSpacing2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(323934645);
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(count) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                pagerState = state;
                int i3 = $composer3.changed(pagerState) ? 256 : 128;
                $dirty3 |= i3;
            } else {
                pagerState = state;
            }
            $dirty3 |= i3;
        } else {
            pagerState = state;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty3 |= $composer3.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
            f = itemSpacing;
        } else if (($changed & 57344) == 0) {
            f = itemSpacing;
            $dirty3 |= $composer3.changed(f) ? 16384 : 8192;
        } else {
            f = itemSpacing;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(contentPadding) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changed(horizontalAlignment) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            $dirty3 |= ((i & 128) == 0 && $composer3.changed(flingBehavior)) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(userScrollEnabled) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(content) ? 4 : 2;
        }
        int $dirty4 = $dirty1;
        if ((1533916891 & $dirty3) == 306783378 && ($dirty4 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            horizontalAlignment2 = horizontalAlignment;
            flingBehavior3 = flingBehavior;
            function2 = function1;
            userScrollEnabled2 = userScrollEnabled;
            itemSpacing2 = f;
            modifier3 = modifier2;
            state2 = pagerState;
            $composer2 = $composer3;
            reverseLayout3 = reverseLayout2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty = $dirty3 & (-897);
                    state2 = PagerStateKt.rememberPagerState(0, $composer3, 0, 1);
                } else {
                    $dirty = $dirty3;
                    state2 = pagerState;
                }
                if (i4 != 0) {
                    reverseLayout2 = false;
                }
                float itemSpacing3 = i5 != 0 ? C1979Dp.m6801constructorimpl(0) : f;
                PaddingValues contentPadding3 = i6 != 0 ? PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0)) : contentPadding;
                Alignment.Horizontal horizontalAlignment3 = i7 != 0 ? Alignment.INSTANCE.getCenterHorizontally() : horizontalAlignment;
                if ((i & 128) != 0) {
                    flingBehavior2 = PagerDefaults.INSTANCE.m7176flingBehaviorjt2gSs(state2, null, null, contentPadding3.getBottom(), $composer3, (($dirty >> 6) & 14) | CpioConstants.C_ISBLK, 6);
                    $dirty &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                Function1<? super Integer, ? extends Object> function3 = i8 != 0 ? null : function1;
                if (i9 != 0) {
                    function2 = function3;
                    userScrollEnabled2 = true;
                    contentPadding2 = contentPadding3;
                    horizontalAlignment2 = horizontalAlignment3;
                    $dirty2 = $dirty;
                    flingBehavior3 = flingBehavior2;
                    reverseLayout3 = reverseLayout2;
                    itemSpacing2 = itemSpacing3;
                } else {
                    userScrollEnabled2 = userScrollEnabled;
                    function2 = function3;
                    contentPadding2 = contentPadding3;
                    horizontalAlignment2 = horizontalAlignment3;
                    $dirty2 = $dirty;
                    flingBehavior3 = flingBehavior2;
                    reverseLayout3 = reverseLayout2;
                    itemSpacing2 = itemSpacing3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                contentPadding2 = contentPadding;
                horizontalAlignment2 = horizontalAlignment;
                flingBehavior3 = flingBehavior;
                function2 = function1;
                userScrollEnabled2 = userScrollEnabled;
                $dirty2 = $dirty3;
                itemSpacing2 = f;
                modifier3 = modifier2;
                state2 = pagerState;
                reverseLayout3 = reverseLayout2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(323934645, $dirty2, $dirty4, "com.google.accompanist.pager.VerticalPager (Pager.kt:346)");
            }
            $composer2 = $composer3;
            m7170PagerupBTbn8(count, modifier3, state2, reverseLayout3, itemSpacing2, true, flingBehavior3, function2, contentPadding2, userScrollEnabled2, null, horizontalAlignment2, content, $composer2, ($dirty2 & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21 | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty2 >> 3) & 3670016) | (($dirty2 >> 3) & 29360128) | (($dirty2 << 9) & 234881024) | ($dirty2 & 1879048192), (($dirty2 >> 15) & 112) | (($dirty4 << 6) & 896), 1024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final PagerState pagerState2 = state2;
            final boolean z = reverseLayout3;
            final float f2 = itemSpacing2;
            final PaddingValues paddingValues = contentPadding2;
            final Alignment.Horizontal horizontal = horizontalAlignment2;
            final FlingBehavior flingBehavior4 = flingBehavior3;
            final Function1<? super Integer, ? extends Object> function4 = function2;
            final boolean z2 = userScrollEnabled2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$VerticalPager$1
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

                public final void invoke(Composer composer, int i10) {
                    Pager.m7171VerticalPager7SJwSw(count, modifier4, pagerState2, z, f2, paddingValues, horizontal, flingBehavior4, function4, z2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0149  */
    /* JADX WARN: Code duplicated, block: B:102:0x014c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0151  */
    /* JADX WARN: Code duplicated, block: B:107:0x0157  */
    /* JADX WARN: Code duplicated, block: B:108:0x015c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0160  */
    /* JADX WARN: Code duplicated, block: B:112:0x0168  */
    /* JADX WARN: Code duplicated, block: B:114:0x016d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0173  */
    /* JADX WARN: Code duplicated, block: B:118:0x0178  */
    /* JADX WARN: Code duplicated, block: B:120:0x017c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0185  */
    /* JADX WARN: Code duplicated, block: B:125:0x018a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0190  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:131:0x0197  */
    /* JADX WARN: Code duplicated, block: B:133:0x019d  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:148:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:151:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:154:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:155:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:159:0x0204  */
    /* JADX WARN: Code duplicated, block: B:160:0x0206  */
    /* JADX WARN: Code duplicated, block: B:163:0x0214  */
    /* JADX WARN: Code duplicated, block: B:167:0x0221 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x024c  */
    /* JADX WARN: Code duplicated, block: B:172:0x024e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0256  */
    /* JADX WARN: Code duplicated, block: B:176:0x0258  */
    /* JADX WARN: Code duplicated, block: B:179:0x0265  */
    /* JADX WARN: Code duplicated, block: B:183:0x0274  */
    /* JADX WARN: Code duplicated, block: B:186:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:187:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:190:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:194:0x02bb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:198:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:199:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:202:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:206:0x0306 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:210:0x0358  */
    /* JADX WARN: Code duplicated, block: B:211:0x035a  */
    /* JADX WARN: Code duplicated, block: B:214:0x0364  */
    /* JADX WARN: Code duplicated, block: B:215:0x0366  */
    /* JADX WARN: Code duplicated, block: B:218:0x0374  */
    /* JADX WARN: Code duplicated, block: B:222:0x0383 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:226:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:227:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:230:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:234:0x03df A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:238:0x0402  */
    /* JADX WARN: Code duplicated, block: B:239:0x0404  */
    /* JADX WARN: Code duplicated, block: B:242:0x0410  */
    /* JADX WARN: Code duplicated, block: B:246:0x041f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:250:0x043e  */
    /* JADX WARN: Code duplicated, block: B:252:0x0460  */
    /* JADX WARN: Code duplicated, block: B:253:0x0462  */
    /* JADX WARN: Code duplicated, block: B:256:0x0469  */
    /* JADX WARN: Code duplicated, block: B:257:0x046b  */
    /* JADX WARN: Code duplicated, block: B:260:0x0478  */
    /* JADX WARN: Code duplicated, block: B:263:0x048e  */
    /* JADX WARN: Code duplicated, block: B:267:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:269:0x051e  */
    /* JADX WARN: Code duplicated, block: B:271:0x0552  */
    /* JADX WARN: Code duplicated, block: B:272:0x0554  */
    /* JADX WARN: Code duplicated, block: B:275:0x055b  */
    /* JADX WARN: Code duplicated, block: B:276:0x055d  */
    /* JADX WARN: Code duplicated, block: B:279:0x056e  */
    /* JADX WARN: Code duplicated, block: B:282:0x0586  */
    /* JADX WARN: Code duplicated, block: B:286:0x0599  */
    /* JADX WARN: Code duplicated, block: B:290:0x0607  */
    /* JADX WARN: Code duplicated, block: B:294:0x0612  */
    /* JADX WARN: Code duplicated, block: B:296:0x0645  */
    /* JADX WARN: Code duplicated, block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:76:0x0103  */
    /* JADX WARN: Code duplicated, block: B:78:0x0107  */
    /* JADX WARN: Code duplicated, block: B:80:0x010f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0112  */
    /* JADX WARN: Code duplicated, block: B:83:0x0117  */
    /* JADX WARN: Code duplicated, block: B:86:0x011d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0121  */
    /* JADX WARN: Code duplicated, block: B:90:0x0126  */
    /* JADX WARN: Code duplicated, block: B:92:0x012c  */
    /* JADX WARN: Code duplicated, block: B:93:0x012f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0136  */
    /* JADX WARN: Code duplicated, block: B:97:0x013c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0141  */
    /* JADX INFO: renamed from: Pager-upBTbn8, reason: not valid java name */
    public static final void m7170PagerupBTbn8(final int count, final Modifier modifier, final PagerState state, final boolean reverseLayout, final float itemSpacing, final boolean isVertical, final FlingBehavior flingBehavior, final Function1<? super Integer, ? extends Object> function1, final PaddingValues contentPadding, final boolean userScrollEnabled, Alignment.Vertical verticalAlignment, Alignment.Horizontal horizontalAlignment, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int $dirty1;
        Alignment.Vertical verticalAlignment2;
        Alignment.Horizontal horizontalAlignment2;
        boolean z;
        boolean invalid$iv;
        Alignment.Horizontal horizontalAlignment3;
        Object value$iv;
        boolean z2;
        Alignment.Vertical verticalAlignment3;
        boolean z3;
        boolean invalid$iv2;
        Pager$Pager$3$1 value$iv2;
        boolean invalid$iv3;
        Pager$Pager$4$1 value$iv3;
        boolean invalid$iv4;
        Pager$Pager$5$1 value$iv4;
        boolean z4;
        boolean z5;
        boolean invalid$iv5;
        Pager$Pager$6$1 value$iv5;
        int $dirty;
        boolean invalid$iv6;
        Object value$iv6;
        final PagerScopeImpl pagerScope;
        boolean invalid$iv7;
        Object value$iv7;
        final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection;
        boolean z6;
        boolean z7;
        boolean invalid$iv8;
        Object value$iv8;
        Alignment.Horizontal horizontalAlignment4;
        Composer $composer2;
        Alignment.Vertical verticalAlignment4;
        boolean z8;
        boolean z9;
        boolean invalid$iv9;
        Object value$iv9;
        final PagerScopeImpl pagerScope2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(-1072219707);
        int $dirty2 = $changed;
        int $dirty3 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(count) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(state) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(reverseLayout) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changed(itemSpacing) ? 16384 : 8192;
        }
        if ((i & 32) == 0) {
            if (($changed & 458752) == 0) {
                i2 = $composer3.changed(isVertical) ? 131072 : 65536;
            }
            if ((i & 64) != 0) {
                if (($changed & 3670016) == 0) {
                    if ($composer3.changed(flingBehavior)) {
                        i3 = 1048576;
                    } else {
                        i3 = 524288;
                    }
                }
                if ((i & 128) != 0) {
                    $dirty2 |= 12582912;
                } else if (($changed & 29360128) != 0) {
                    if ($composer3.changedInstance(function1)) {
                        i4 = 8388608;
                    } else {
                        i4 = 4194304;
                    }
                    $dirty2 |= i4;
                }
                if ((i & 256) != 0) {
                    if ((234881024 & $changed) == 0) {
                        if ($composer3.changed(contentPadding)) {
                            i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                        } else {
                            i5 = 33554432;
                        }
                    }
                    if ((i & 512) != 0) {
                        $dirty2 |= 805306368;
                    } else if ((1879048192 & $changed) != 0) {
                        if ($composer3.changed(userScrollEnabled)) {
                            i6 = 536870912;
                        } else {
                            i6 = 268435456;
                        }
                        $dirty2 |= i6;
                    }
                    i7 = i & 1024;
                    if (i7 != 0) {
                        $dirty3 |= 6;
                    } else if (($changed1 & 14) != 0) {
                        $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
                    }
                    i8 = i & 2048;
                    if (i8 != 0) {
                        $dirty3 |= 48;
                    } else if (($changed1 & 112) != 0) {
                        $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
                    }
                    if ((i & 4096) != 0) {
                        $dirty3 |= 384;
                    } else if (($changed1 & 896) == 0) {
                        $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
                    }
                    $dirty1 = $dirty3;
                    if ((1533916891 & $dirty2) != 306783378 && ($dirty1 & 731) == 146 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        verticalAlignment4 = verticalAlignment;
                        horizontalAlignment4 = horizontalAlignment;
                        $composer2 = $composer3;
                    } else {
                        if (i7 != 0) {
                            verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                        } else {
                            verticalAlignment2 = verticalAlignment;
                        }
                        if (i8 != 0) {
                            horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                        } else {
                            horizontalAlignment2 = horizontalAlignment;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                        }
                        if (count >= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            throw new IllegalArgumentException("pageCount must be >= 0".toString());
                        }
                        $composer3.startReplaceableGroup(-510390079);
                        if (($dirty2 & 3670016) == 1048576) {
                            invalid$iv = true;
                        } else {
                            invalid$iv = false;
                        }
                        horizontalAlignment3 = horizontalAlignment2;
                        Object it$iv = $composer3.rememberedValue();
                        if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Integer invoke() {
                                    FlingBehavior flingBehavior2 = flingBehavior;
                                    SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                                    if (snapperFlingBehavior != null) {
                                        return snapperFlingBehavior.getAnimationTarget();
                                    }
                                    return null;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer3.endReplaceableGroup();
                        state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                        Integer numValueOf = Integer.valueOf(count);
                        $composer3.startReplaceableGroup(-510389932);
                        if (($dirty2 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        verticalAlignment3 = verticalAlignment2;
                        if (($dirty2 & 14) == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        invalid$iv2 = z2 | z3;
                        Object it$iv2 = $composer3.rememberedValue();
                        if (!invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Pager$Pager$3$1(state, count, null);
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer3.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                        $composer3.startReplaceableGroup(-510389756);
                        if (($dirty2 & 896) == 256) {
                            invalid$iv3 = true;
                        } else {
                            invalid$iv3 = false;
                        }
                        Object it$iv3 = $composer3.rememberedValue();
                        if (!invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Pager$Pager$4$1(state, null);
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        $composer3.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                        $composer3.startReplaceableGroup(-510389361);
                        if (($dirty2 & 896) == 256) {
                            invalid$iv4 = true;
                        } else {
                            invalid$iv4 = false;
                        }
                        Object it$iv4 = $composer3.rememberedValue();
                        if (!invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Pager$Pager$5$1(state, null);
                            $composer3.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        $composer3.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density = (Density) objConsume;
                        C1979Dp c1979DpM6799boximpl = C1979Dp.m6799boximpl(itemSpacing);
                        $composer3.startReplaceableGroup(-510389095);
                        boolean zChanged = $composer3.changed(density);
                        if (($dirty2 & 896) == 256) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean z10 = zChanged | z4;
                        if ((57344 & $dirty2) == 16384) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        invalid$iv5 = z10 | z5;
                        Object it$iv5 = $composer3.rememberedValue();
                        if (!invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Pager$Pager$6$1(density, state, itemSpacing, null);
                            $composer3.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv5;
                        }
                        $composer3.endReplaceableGroup();
                        $dirty = $dirty2;
                        EffectsKt.LaunchedEffect(density, state, c1979DpM6799boximpl, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                        $composer3.startReplaceableGroup(-510388995);
                        if (($dirty & 896) == 256) {
                            invalid$iv6 = true;
                        } else {
                            invalid$iv6 = false;
                        }
                        Object it$iv6 = $composer3.rememberedValue();
                        if (!invalid$iv6 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                            value$iv6 = new PagerScopeImpl(state);
                            $composer3.updateRememberedValue(value$iv6);
                        } else {
                            value$iv6 = it$iv6;
                        }
                        pagerScope = (PagerScopeImpl) value$iv6;
                        $composer3.endReplaceableGroup();
                        $composer3.startReplaceableGroup(-510388795);
                        if (($dirty & 458752) == 131072) {
                            invalid$iv7 = true;
                        } else {
                            invalid$iv7 = false;
                        }
                        Object it$iv7 = $composer3.rememberedValue();
                        if (!invalid$iv7 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                            value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                            $composer3.updateRememberedValue(value$iv7);
                        } else {
                            value$iv7 = it$iv7;
                        }
                        consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                        $composer3.endReplaceableGroup();
                        if (isVertical) {
                            $composer3.startReplaceableGroup(-510388572);
                            LazyListState lazyListState = state.getLazyListState();
                            Arrangement.Vertical verticalM746spacedByD5KLDUw = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                            $composer3.startReplaceableGroup(-510388141);
                            if (($dirty & 14) == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (($dirty & 29360128) == 8388608) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                            value$iv9 = $composer3.rememberedValue();
                            if (!invalid$iv9 || value$iv9 == Composer.INSTANCE.getEmpty()) {
                                pagerScope2 = pagerScope;
                                value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                        invoke2(lazyListScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(LazyListScope LazyColumn) {
                                        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                        int i9 = count;
                                        Function1<Integer, Object> function2 = function1;
                                        final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                        final Function4<PagerScope, Integer, Composer, Integer, Unit> function4 = content;
                                        final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                        LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            @Override // kotlin.jvm.functions.Function4
                                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                                Function0<ComposeUiNode> function0;
                                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                                int $dirty4 = $changed2;
                                                if (($changed2 & 14) == 0) {
                                                    $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                                }
                                                if (($changed2 & 112) == 0) {
                                                    $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                                }
                                                if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                    }
                                                    Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                    Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                    PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                    $composer4.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                    int $changed$iv$iv = (0 << 3) & 112;
                                                    $composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                    if (!($composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer4.startReusableNode();
                                                    if ($composer4.getInserting()) {
                                                        function0 = constructor;
                                                        $composer4.createNode(function0);
                                                    } else {
                                                        function0 = constructor;
                                                        $composer4.useNode();
                                                    }
                                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                    }
                                                    function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                    $composer4.startReplaceableGroup(2058660585);
                                                    int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    int i11 = ((0 >> 6) & 112) | 6;
                                                    function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                                    $composer4.endReplaceableGroup();
                                                    $composer4.endNode();
                                                    $composer4.endReplaceableGroup();
                                                    $composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer4.skipToGroupEnd();
                                            }
                                        }), 4, null);
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv9);
                            } else {
                                pagerScope2 = pagerScope;
                            }
                            r5.endReplaceableGroup();
                            LazyDslKt.LazyColumn(modifier, lazyListState, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                            r5.endReplaceableGroup();
                            horizontalAlignment4 = horizontalAlignment3;
                            $composer2 = $composer3;
                        } else {
                            $composer3.startReplaceableGroup(-510387365);
                            LazyListState lazyListState2 = state.getLazyListState();
                            Arrangement.Horizontal horizontalM745spacedByD5KLDUw = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                            $composer3.startReplaceableGroup(-510386937);
                            if (($dirty & 14) == 4) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (($dirty & 29360128) == 8388608) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                            value$iv8 = $composer3.rememberedValue();
                            if (invalid$iv8 || value$iv8 == Composer.INSTANCE.getEmpty()) {
                                value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                        invoke2(lazyListScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(LazyListScope LazyRow) {
                                        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                        int i9 = count;
                                        Function1<Integer, Object> function2 = function1;
                                        final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                        final Function4<PagerScope, Integer, Composer, Integer, Unit> function4 = content;
                                        final PagerScopeImpl pagerScopeImpl = pagerScope;
                                        LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            @Override // kotlin.jvm.functions.Function4
                                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                                Function0<ComposeUiNode> function0;
                                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                                int $dirty4 = $changed2;
                                                if (($changed2 & 14) == 0) {
                                                    $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                                }
                                                if (($changed2 & 112) == 0) {
                                                    $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                                }
                                                if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                    }
                                                    Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                    Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                    PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                    $composer4.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                    int $changed$iv$iv = (0 << 3) & 112;
                                                    $composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                    int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                    if (!($composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    $composer4.startReusableNode();
                                                    if ($composer4.getInserting()) {
                                                        function0 = constructor;
                                                        $composer4.createNode(function0);
                                                    } else {
                                                        function0 = constructor;
                                                        $composer4.useNode();
                                                    }
                                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                    }
                                                    function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                    $composer4.startReplaceableGroup(2058660585);
                                                    int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    int i11 = ((0 >> 6) & 112) | 6;
                                                    function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                    ComposerKt.sourceInformationMarkerEnd($composer4);
                                                    $composer4.endReplaceableGroup();
                                                    $composer4.endNode();
                                                    $composer4.endReplaceableGroup();
                                                    $composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer4.skipToGroupEnd();
                                            }
                                        }), 4, null);
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv8);
                            }
                            $composer3.endReplaceableGroup();
                            horizontalAlignment4 = horizontalAlignment3;
                            $composer2 = $composer3;
                            LazyDslKt.LazyRow(modifier, lazyListState2, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                            $composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        verticalAlignment4 = verticalAlignment3;
                    }
                    scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Alignment.Vertical vertical = verticalAlignment4;
                        final Alignment.Horizontal horizontal = horizontalAlignment4;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                            public final void invoke(Composer composer, int i9) {
                                Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical, horizontal, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                            }
                        });
                    }
                }
                i5 = 100663296;
                $dirty2 |= i5;
                if ((i & 512) != 0) {
                    $dirty2 |= 805306368;
                } else if ((1879048192 & $changed) != 0) {
                    if ($composer3.changed(userScrollEnabled)) {
                        i6 = 536870912;
                    } else {
                        i6 = 268435456;
                    }
                    $dirty2 |= i6;
                }
                i7 = i & 1024;
                if (i7 != 0) {
                    $dirty3 |= 6;
                } else if (($changed1 & 14) != 0) {
                    $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
                }
                i8 = i & 2048;
                if (i8 != 0) {
                    $dirty3 |= 48;
                } else if (($changed1 & 112) != 0) {
                    $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
                }
                if ((i & 4096) != 0) {
                    $dirty3 |= 384;
                } else if (($changed1 & 896) == 0) {
                    $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
                }
                $dirty1 = $dirty3;
                if ((1533916891 & $dirty2) != 306783378) {
                    if (i7 != 0) {
                        verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        verticalAlignment2 = verticalAlignment;
                    }
                    if (i8 != 0) {
                        horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                    } else {
                        horizontalAlignment2 = horizontalAlignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                    }
                    if (count >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("pageCount must be >= 0".toString());
                    }
                    $composer3.startReplaceableGroup(-510390079);
                    if (($dirty2 & 3670016) == 1048576) {
                        invalid$iv = true;
                    } else {
                        invalid$iv = false;
                    }
                    horizontalAlignment3 = horizontalAlignment2;
                    Object it$iv8 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            FlingBehavior flingBehavior2 = flingBehavior;
                            SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                            if (snapperFlingBehavior != null) {
                                return snapperFlingBehavior.getAnimationTarget();
                            }
                            return null;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    $composer3.endReplaceableGroup();
                    state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                    Integer numValueOf2 = Integer.valueOf(count);
                    $composer3.startReplaceableGroup(-510389932);
                    if (($dirty2 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    verticalAlignment3 = verticalAlignment2;
                    if (($dirty2 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    invalid$iv2 = z2 | z3;
                    Object it$iv9 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(numValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                    $composer3.startReplaceableGroup(-510389756);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv3 = true;
                    } else {
                        invalid$iv3 = false;
                    }
                    Object it$iv10 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    value$iv3 = new Pager$Pager$4$1(state, null);
                    $composer3.updateRememberedValue(value$iv3);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                    $composer3.startReplaceableGroup(-510389361);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv4 = true;
                    } else {
                        invalid$iv4 = false;
                    }
                    Object it$iv11 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    value$iv4 = new Pager$Pager$5$1(state, null);
                    $composer3.updateRememberedValue(value$iv4);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer3.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density2 = (Density) objConsume2;
                    C1979Dp c1979DpM6799boximpl2 = C1979Dp.m6799boximpl(itemSpacing);
                    $composer3.startReplaceableGroup(-510389095);
                    boolean zChanged2 = $composer3.changed(density2);
                    if (($dirty2 & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z11 = zChanged2 | z4;
                    if ((57344 & $dirty2) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    invalid$iv5 = z11 | z5;
                    Object it$iv12 = $composer3.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv5 = new Pager$Pager$6$1(density2, state, itemSpacing, null);
                    $composer3.updateRememberedValue(value$iv5);
                    $composer3.endReplaceableGroup();
                    $dirty = $dirty2;
                    EffectsKt.LaunchedEffect(density2, state, c1979DpM6799boximpl2, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                    $composer3.startReplaceableGroup(-510388995);
                    if (($dirty & 896) == 256) {
                        invalid$iv6 = true;
                    } else {
                        invalid$iv6 = false;
                    }
                    Object it$iv13 = $composer3.rememberedValue();
                    if (invalid$iv6) {
                    }
                    value$iv6 = new PagerScopeImpl(state);
                    $composer3.updateRememberedValue(value$iv6);
                    pagerScope = (PagerScopeImpl) value$iv6;
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(-510388795);
                    if (($dirty & 458752) == 131072) {
                        invalid$iv7 = true;
                    } else {
                        invalid$iv7 = false;
                    }
                    Object it$iv14 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                    $composer3.updateRememberedValue(value$iv7);
                    consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                    $composer3.endReplaceableGroup();
                    if (isVertical) {
                        $composer3.startReplaceableGroup(-510388572);
                        LazyListState lazyListState3 = state.getLazyListState();
                        Arrangement.Vertical verticalM746spacedByD5KLDUw2 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                        $composer3.startReplaceableGroup(-510388141);
                        if (($dirty & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv9 = $composer3.rememberedValue();
                        if (invalid$iv9) {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        } else {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        }
                        r5.endReplaceableGroup();
                        LazyDslKt.LazyColumn(modifier, lazyListState3, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw2, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        r5.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceableGroup(-510387365);
                        LazyListState lazyListState4 = state.getLazyListState();
                        Arrangement.Horizontal horizontalM745spacedByD5KLDUw2 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                        $composer3.startReplaceableGroup(-510386937);
                        if (($dirty & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv8 = $composer3.rememberedValue();
                        if (invalid$iv8) {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        } else {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        }
                        $composer3.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                        LazyDslKt.LazyRow(modifier, lazyListState4, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw2, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        $composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    verticalAlignment4 = verticalAlignment3;
                } else {
                    if (i7 != 0) {
                        verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        verticalAlignment2 = verticalAlignment;
                    }
                    if (i8 != 0) {
                        horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                    } else {
                        horizontalAlignment2 = horizontalAlignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                    }
                    if (count >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("pageCount must be >= 0".toString());
                    }
                    $composer3.startReplaceableGroup(-510390079);
                    if (($dirty2 & 3670016) == 1048576) {
                        invalid$iv = true;
                    } else {
                        invalid$iv = false;
                    }
                    horizontalAlignment3 = horizontalAlignment2;
                    Object it$iv15 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            FlingBehavior flingBehavior2 = flingBehavior;
                            SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                            if (snapperFlingBehavior != null) {
                                return snapperFlingBehavior.getAnimationTarget();
                            }
                            return null;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    $composer3.endReplaceableGroup();
                    state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                    Integer numValueOf3 = Integer.valueOf(count);
                    $composer3.startReplaceableGroup(-510389932);
                    if (($dirty2 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    verticalAlignment3 = verticalAlignment2;
                    if (($dirty2 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    invalid$iv2 = z2 | z3;
                    Object it$iv16 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(numValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                    $composer3.startReplaceableGroup(-510389756);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv3 = true;
                    } else {
                        invalid$iv3 = false;
                    }
                    Object it$iv17 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    value$iv3 = new Pager$Pager$4$1(state, null);
                    $composer3.updateRememberedValue(value$iv3);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                    $composer3.startReplaceableGroup(-510389361);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv4 = true;
                    } else {
                        invalid$iv4 = false;
                    }
                    Object it$iv18 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    value$iv4 = new Pager$Pager$5$1(state, null);
                    $composer3.updateRememberedValue(value$iv4);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = $composer3.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density3 = (Density) objConsume3;
                    C1979Dp c1979DpM6799boximpl3 = C1979Dp.m6799boximpl(itemSpacing);
                    $composer3.startReplaceableGroup(-510389095);
                    boolean zChanged3 = $composer3.changed(density3);
                    if (($dirty2 & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z12 = zChanged3 | z4;
                    if ((57344 & $dirty2) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    invalid$iv5 = z12 | z5;
                    Object it$iv19 = $composer3.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv5 = new Pager$Pager$6$1(density3, state, itemSpacing, null);
                    $composer3.updateRememberedValue(value$iv5);
                    $composer3.endReplaceableGroup();
                    $dirty = $dirty2;
                    EffectsKt.LaunchedEffect(density3, state, c1979DpM6799boximpl3, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                    $composer3.startReplaceableGroup(-510388995);
                    if (($dirty & 896) == 256) {
                        invalid$iv6 = true;
                    } else {
                        invalid$iv6 = false;
                    }
                    Object it$iv110 = $composer3.rememberedValue();
                    if (invalid$iv6) {
                    }
                    value$iv6 = new PagerScopeImpl(state);
                    $composer3.updateRememberedValue(value$iv6);
                    pagerScope = (PagerScopeImpl) value$iv6;
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(-510388795);
                    if (($dirty & 458752) == 131072) {
                        invalid$iv7 = true;
                    } else {
                        invalid$iv7 = false;
                    }
                    Object it$iv111 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                    $composer3.updateRememberedValue(value$iv7);
                    consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                    $composer3.endReplaceableGroup();
                    if (isVertical) {
                        $composer3.startReplaceableGroup(-510388572);
                        LazyListState lazyListState5 = state.getLazyListState();
                        Arrangement.Vertical verticalM746spacedByD5KLDUw3 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                        $composer3.startReplaceableGroup(-510388141);
                        if (($dirty & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv9 = $composer3.rememberedValue();
                        if (invalid$iv9) {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        } else {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        }
                        r5.endReplaceableGroup();
                        LazyDslKt.LazyColumn(modifier, lazyListState5, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw3, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        r5.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceableGroup(-510387365);
                        LazyListState lazyListState6 = state.getLazyListState();
                        Arrangement.Horizontal horizontalM745spacedByD5KLDUw3 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                        $composer3.startReplaceableGroup(-510386937);
                        if (($dirty & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv8 = $composer3.rememberedValue();
                        if (invalid$iv8) {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        } else {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        }
                        $composer3.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                        LazyDslKt.LazyRow(modifier, lazyListState6, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw3, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        $composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    verticalAlignment4 = verticalAlignment3;
                }
                scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Alignment.Vertical vertical2 = verticalAlignment4;
                    final Alignment.Horizontal horizontal2 = horizontalAlignment4;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                        public final void invoke(Composer composer, int i9) {
                            Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical2, horizontal2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                        }
                    });
                }
            }
            i3 = 1572864;
            $dirty2 |= i3;
            if ((i & 128) != 0) {
                $dirty2 |= 12582912;
            } else if (($changed & 29360128) != 0) {
                if ($composer3.changedInstance(function1)) {
                    i4 = 8388608;
                } else {
                    i4 = 4194304;
                }
                $dirty2 |= i4;
            }
            if ((i & 256) != 0) {
                if ((234881024 & $changed) == 0) {
                    if ($composer3.changed(contentPadding)) {
                        i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    } else {
                        i5 = 33554432;
                    }
                }
                if ((i & 512) != 0) {
                    $dirty2 |= 805306368;
                } else if ((1879048192 & $changed) != 0) {
                    if ($composer3.changed(userScrollEnabled)) {
                        i6 = 536870912;
                    } else {
                        i6 = 268435456;
                    }
                    $dirty2 |= i6;
                }
                i7 = i & 1024;
                if (i7 != 0) {
                    $dirty3 |= 6;
                } else if (($changed1 & 14) != 0) {
                    $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
                }
                i8 = i & 2048;
                if (i8 != 0) {
                    $dirty3 |= 48;
                } else if (($changed1 & 112) != 0) {
                    $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
                }
                if ((i & 4096) != 0) {
                    $dirty3 |= 384;
                } else if (($changed1 & 896) == 0) {
                    $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
                }
                $dirty1 = $dirty3;
                if ((1533916891 & $dirty2) != 306783378) {
                    if (i7 != 0) {
                        verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        verticalAlignment2 = verticalAlignment;
                    }
                    if (i8 != 0) {
                        horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                    } else {
                        horizontalAlignment2 = horizontalAlignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                    }
                    if (count >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("pageCount must be >= 0".toString());
                    }
                    $composer3.startReplaceableGroup(-510390079);
                    if (($dirty2 & 3670016) == 1048576) {
                        invalid$iv = true;
                    } else {
                        invalid$iv = false;
                    }
                    horizontalAlignment3 = horizontalAlignment2;
                    Object it$iv112 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            FlingBehavior flingBehavior2 = flingBehavior;
                            SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                            if (snapperFlingBehavior != null) {
                                return snapperFlingBehavior.getAnimationTarget();
                            }
                            return null;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    $composer3.endReplaceableGroup();
                    state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                    Integer numValueOf4 = Integer.valueOf(count);
                    $composer3.startReplaceableGroup(-510389932);
                    if (($dirty2 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    verticalAlignment3 = verticalAlignment2;
                    if (($dirty2 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    invalid$iv2 = z2 | z3;
                    Object it$iv113 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(numValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                    $composer3.startReplaceableGroup(-510389756);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv3 = true;
                    } else {
                        invalid$iv3 = false;
                    }
                    Object it$iv114 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    value$iv3 = new Pager$Pager$4$1(state, null);
                    $composer3.updateRememberedValue(value$iv3);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                    $composer3.startReplaceableGroup(-510389361);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv4 = true;
                    } else {
                        invalid$iv4 = false;
                    }
                    Object it$iv115 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    value$iv4 = new Pager$Pager$5$1(state, null);
                    $composer3.updateRememberedValue(value$iv4);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = $composer3.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density4 = (Density) objConsume4;
                    C1979Dp c1979DpM6799boximpl4 = C1979Dp.m6799boximpl(itemSpacing);
                    $composer3.startReplaceableGroup(-510389095);
                    boolean zChanged4 = $composer3.changed(density4);
                    if (($dirty2 & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z13 = zChanged4 | z4;
                    if ((57344 & $dirty2) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    invalid$iv5 = z13 | z5;
                    Object it$iv116 = $composer3.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv5 = new Pager$Pager$6$1(density4, state, itemSpacing, null);
                    $composer3.updateRememberedValue(value$iv5);
                    $composer3.endReplaceableGroup();
                    $dirty = $dirty2;
                    EffectsKt.LaunchedEffect(density4, state, c1979DpM6799boximpl4, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                    $composer3.startReplaceableGroup(-510388995);
                    if (($dirty & 896) == 256) {
                        invalid$iv6 = true;
                    } else {
                        invalid$iv6 = false;
                    }
                    Object it$iv117 = $composer3.rememberedValue();
                    if (invalid$iv6) {
                    }
                    value$iv6 = new PagerScopeImpl(state);
                    $composer3.updateRememberedValue(value$iv6);
                    pagerScope = (PagerScopeImpl) value$iv6;
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(-510388795);
                    if (($dirty & 458752) == 131072) {
                        invalid$iv7 = true;
                    } else {
                        invalid$iv7 = false;
                    }
                    Object it$iv118 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                    $composer3.updateRememberedValue(value$iv7);
                    consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                    $composer3.endReplaceableGroup();
                    if (isVertical) {
                        $composer3.startReplaceableGroup(-510388572);
                        LazyListState lazyListState7 = state.getLazyListState();
                        Arrangement.Vertical verticalM746spacedByD5KLDUw4 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                        $composer3.startReplaceableGroup(-510388141);
                        if (($dirty & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv9 = $composer3.rememberedValue();
                        if (invalid$iv9) {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        } else {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        }
                        r5.endReplaceableGroup();
                        LazyDslKt.LazyColumn(modifier, lazyListState7, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw4, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        r5.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceableGroup(-510387365);
                        LazyListState lazyListState8 = state.getLazyListState();
                        Arrangement.Horizontal horizontalM745spacedByD5KLDUw4 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                        $composer3.startReplaceableGroup(-510386937);
                        if (($dirty & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv8 = $composer3.rememberedValue();
                        if (invalid$iv8) {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        } else {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        }
                        $composer3.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                        LazyDslKt.LazyRow(modifier, lazyListState8, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw4, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        $composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    verticalAlignment4 = verticalAlignment3;
                } else {
                    if (i7 != 0) {
                        verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        verticalAlignment2 = verticalAlignment;
                    }
                    if (i8 != 0) {
                        horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                    } else {
                        horizontalAlignment2 = horizontalAlignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                    }
                    if (count >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("pageCount must be >= 0".toString());
                    }
                    $composer3.startReplaceableGroup(-510390079);
                    if (($dirty2 & 3670016) == 1048576) {
                        invalid$iv = true;
                    } else {
                        invalid$iv = false;
                    }
                    horizontalAlignment3 = horizontalAlignment2;
                    Object it$iv119 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            FlingBehavior flingBehavior2 = flingBehavior;
                            SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                            if (snapperFlingBehavior != null) {
                                return snapperFlingBehavior.getAnimationTarget();
                            }
                            return null;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    $composer3.endReplaceableGroup();
                    state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                    Integer numValueOf5 = Integer.valueOf(count);
                    $composer3.startReplaceableGroup(-510389932);
                    if (($dirty2 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    verticalAlignment3 = verticalAlignment2;
                    if (($dirty2 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    invalid$iv2 = z2 | z3;
                    Object it$iv1110 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(numValueOf5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                    $composer3.startReplaceableGroup(-510389756);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv3 = true;
                    } else {
                        invalid$iv3 = false;
                    }
                    Object it$iv1111 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    value$iv3 = new Pager$Pager$4$1(state, null);
                    $composer3.updateRememberedValue(value$iv3);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                    $composer3.startReplaceableGroup(-510389361);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv4 = true;
                    } else {
                        invalid$iv4 = false;
                    }
                    Object it$iv1112 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    value$iv4 = new Pager$Pager$5$1(state, null);
                    $composer3.updateRememberedValue(value$iv4);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = $composer3.consume(localDensity5);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density5 = (Density) objConsume5;
                    C1979Dp c1979DpM6799boximpl5 = C1979Dp.m6799boximpl(itemSpacing);
                    $composer3.startReplaceableGroup(-510389095);
                    boolean zChanged5 = $composer3.changed(density5);
                    if (($dirty2 & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z14 = zChanged5 | z4;
                    if ((57344 & $dirty2) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    invalid$iv5 = z14 | z5;
                    Object it$iv1113 = $composer3.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv5 = new Pager$Pager$6$1(density5, state, itemSpacing, null);
                    $composer3.updateRememberedValue(value$iv5);
                    $composer3.endReplaceableGroup();
                    $dirty = $dirty2;
                    EffectsKt.LaunchedEffect(density5, state, c1979DpM6799boximpl5, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                    $composer3.startReplaceableGroup(-510388995);
                    if (($dirty & 896) == 256) {
                        invalid$iv6 = true;
                    } else {
                        invalid$iv6 = false;
                    }
                    Object it$iv1114 = $composer3.rememberedValue();
                    if (invalid$iv6) {
                    }
                    value$iv6 = new PagerScopeImpl(state);
                    $composer3.updateRememberedValue(value$iv6);
                    pagerScope = (PagerScopeImpl) value$iv6;
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(-510388795);
                    if (($dirty & 458752) == 131072) {
                        invalid$iv7 = true;
                    } else {
                        invalid$iv7 = false;
                    }
                    Object it$iv1115 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                    $composer3.updateRememberedValue(value$iv7);
                    consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                    $composer3.endReplaceableGroup();
                    if (isVertical) {
                        $composer3.startReplaceableGroup(-510388572);
                        LazyListState lazyListState9 = state.getLazyListState();
                        Arrangement.Vertical verticalM746spacedByD5KLDUw5 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                        $composer3.startReplaceableGroup(-510388141);
                        if (($dirty & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv9 = $composer3.rememberedValue();
                        if (invalid$iv9) {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        } else {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        }
                        r5.endReplaceableGroup();
                        LazyDslKt.LazyColumn(modifier, lazyListState9, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw5, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        r5.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceableGroup(-510387365);
                        LazyListState lazyListState10 = state.getLazyListState();
                        Arrangement.Horizontal horizontalM745spacedByD5KLDUw5 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                        $composer3.startReplaceableGroup(-510386937);
                        if (($dirty & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv8 = $composer3.rememberedValue();
                        if (invalid$iv8) {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        } else {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        }
                        $composer3.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                        LazyDslKt.LazyRow(modifier, lazyListState10, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw5, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        $composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    verticalAlignment4 = verticalAlignment3;
                }
                scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Alignment.Vertical vertical3 = verticalAlignment4;
                    final Alignment.Horizontal horizontal3 = horizontalAlignment4;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                        public final void invoke(Composer composer, int i9) {
                            Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical3, horizontal3, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                        }
                    });
                }
            }
            i5 = 100663296;
            $dirty2 |= i5;
            if ((i & 512) != 0) {
                $dirty2 |= 805306368;
            } else if ((1879048192 & $changed) != 0) {
                if ($composer3.changed(userScrollEnabled)) {
                    i6 = 536870912;
                } else {
                    i6 = 268435456;
                }
                $dirty2 |= i6;
            }
            i7 = i & 1024;
            if (i7 != 0) {
                $dirty3 |= 6;
            } else if (($changed1 & 14) != 0) {
                $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
            }
            i8 = i & 2048;
            if (i8 != 0) {
                $dirty3 |= 48;
            } else if (($changed1 & 112) != 0) {
                $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
            }
            if ((i & 4096) != 0) {
                $dirty3 |= 384;
            } else if (($changed1 & 896) == 0) {
                $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
            }
            $dirty1 = $dirty3;
            if ((1533916891 & $dirty2) != 306783378) {
                if (i7 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                } else {
                    verticalAlignment2 = verticalAlignment;
                }
                if (i8 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                } else {
                    horizontalAlignment2 = horizontalAlignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                }
                if (count >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("pageCount must be >= 0".toString());
                }
                $composer3.startReplaceableGroup(-510390079);
                if (($dirty2 & 3670016) == 1048576) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                horizontalAlignment3 = horizontalAlignment2;
                Object it$iv1116 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        FlingBehavior flingBehavior2 = flingBehavior;
                        SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                        if (snapperFlingBehavior != null) {
                            return snapperFlingBehavior.getAnimationTarget();
                        }
                        return null;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                $composer3.endReplaceableGroup();
                state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                Integer numValueOf6 = Integer.valueOf(count);
                $composer3.startReplaceableGroup(-510389932);
                if (($dirty2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                verticalAlignment3 = verticalAlignment2;
                if (($dirty2 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv2 = z2 | z3;
                Object it$iv1117 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                }
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(numValueOf6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                $composer3.startReplaceableGroup(-510389756);
                if (($dirty2 & 896) == 256) {
                    invalid$iv3 = true;
                } else {
                    invalid$iv3 = false;
                }
                Object it$iv1118 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv3 = new Pager$Pager$4$1(state, null);
                $composer3.updateRememberedValue(value$iv3);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                $composer3.startReplaceableGroup(-510389361);
                if (($dirty2 & 896) == 256) {
                    invalid$iv4 = true;
                } else {
                    invalid$iv4 = false;
                }
                Object it$iv1119 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv4 = new Pager$Pager$5$1(state, null);
                $composer3.updateRememberedValue(value$iv4);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume6 = $composer3.consume(localDensity6);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density6 = (Density) objConsume6;
                C1979Dp c1979DpM6799boximpl6 = C1979Dp.m6799boximpl(itemSpacing);
                $composer3.startReplaceableGroup(-510389095);
                boolean zChanged6 = $composer3.changed(density6);
                if (($dirty2 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z15 = zChanged6 | z4;
                if ((57344 & $dirty2) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                invalid$iv5 = z15 | z5;
                Object it$iv11110 = $composer3.rememberedValue();
                if (invalid$iv5) {
                }
                value$iv5 = new Pager$Pager$6$1(density6, state, itemSpacing, null);
                $composer3.updateRememberedValue(value$iv5);
                $composer3.endReplaceableGroup();
                $dirty = $dirty2;
                EffectsKt.LaunchedEffect(density6, state, c1979DpM6799boximpl6, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                $composer3.startReplaceableGroup(-510388995);
                if (($dirty & 896) == 256) {
                    invalid$iv6 = true;
                } else {
                    invalid$iv6 = false;
                }
                Object it$iv11111 = $composer3.rememberedValue();
                if (invalid$iv6) {
                }
                value$iv6 = new PagerScopeImpl(state);
                $composer3.updateRememberedValue(value$iv6);
                pagerScope = (PagerScopeImpl) value$iv6;
                $composer3.endReplaceableGroup();
                $composer3.startReplaceableGroup(-510388795);
                if (($dirty & 458752) == 131072) {
                    invalid$iv7 = true;
                } else {
                    invalid$iv7 = false;
                }
                Object it$iv11112 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                $composer3.updateRememberedValue(value$iv7);
                consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                $composer3.endReplaceableGroup();
                if (isVertical) {
                    $composer3.startReplaceableGroup(-510388572);
                    LazyListState lazyListState11 = state.getLazyListState();
                    Arrangement.Vertical verticalM746spacedByD5KLDUw6 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                    $composer3.startReplaceableGroup(-510388141);
                    if (($dirty & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv9 = $composer3.rememberedValue();
                    if (invalid$iv9) {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    } else {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    }
                    r5.endReplaceableGroup();
                    LazyDslKt.LazyColumn(modifier, lazyListState11, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw6, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    r5.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceableGroup(-510387365);
                    LazyListState lazyListState12 = state.getLazyListState();
                    Arrangement.Horizontal horizontalM745spacedByD5KLDUw6 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                    $composer3.startReplaceableGroup(-510386937);
                    if (($dirty & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv8 = $composer3.rememberedValue();
                    if (invalid$iv8) {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    } else {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    }
                    $composer3.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                    LazyDslKt.LazyRow(modifier, lazyListState12, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw6, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    $composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verticalAlignment4 = verticalAlignment3;
            } else {
                if (i7 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                } else {
                    verticalAlignment2 = verticalAlignment;
                }
                if (i8 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                } else {
                    horizontalAlignment2 = horizontalAlignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                }
                if (count >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("pageCount must be >= 0".toString());
                }
                $composer3.startReplaceableGroup(-510390079);
                if (($dirty2 & 3670016) == 1048576) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                horizontalAlignment3 = horizontalAlignment2;
                Object it$iv11113 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        FlingBehavior flingBehavior2 = flingBehavior;
                        SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                        if (snapperFlingBehavior != null) {
                            return snapperFlingBehavior.getAnimationTarget();
                        }
                        return null;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                $composer3.endReplaceableGroup();
                state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                Integer numValueOf7 = Integer.valueOf(count);
                $composer3.startReplaceableGroup(-510389932);
                if (($dirty2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                verticalAlignment3 = verticalAlignment2;
                if (($dirty2 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv2 = z2 | z3;
                Object it$iv11114 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                }
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(numValueOf7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                $composer3.startReplaceableGroup(-510389756);
                if (($dirty2 & 896) == 256) {
                    invalid$iv3 = true;
                } else {
                    invalid$iv3 = false;
                }
                Object it$iv11115 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv3 = new Pager$Pager$4$1(state, null);
                $composer3.updateRememberedValue(value$iv3);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                $composer3.startReplaceableGroup(-510389361);
                if (($dirty2 & 896) == 256) {
                    invalid$iv4 = true;
                } else {
                    invalid$iv4 = false;
                }
                Object it$iv11116 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv4 = new Pager$Pager$5$1(state, null);
                $composer3.updateRememberedValue(value$iv4);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume7 = $composer3.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density7 = (Density) objConsume7;
                C1979Dp c1979DpM6799boximpl7 = C1979Dp.m6799boximpl(itemSpacing);
                $composer3.startReplaceableGroup(-510389095);
                boolean zChanged7 = $composer3.changed(density7);
                if (($dirty2 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z16 = zChanged7 | z4;
                if ((57344 & $dirty2) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                invalid$iv5 = z16 | z5;
                Object it$iv11117 = $composer3.rememberedValue();
                if (invalid$iv5) {
                }
                value$iv5 = new Pager$Pager$6$1(density7, state, itemSpacing, null);
                $composer3.updateRememberedValue(value$iv5);
                $composer3.endReplaceableGroup();
                $dirty = $dirty2;
                EffectsKt.LaunchedEffect(density7, state, c1979DpM6799boximpl7, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                $composer3.startReplaceableGroup(-510388995);
                if (($dirty & 896) == 256) {
                    invalid$iv6 = true;
                } else {
                    invalid$iv6 = false;
                }
                Object it$iv11118 = $composer3.rememberedValue();
                if (invalid$iv6) {
                }
                value$iv6 = new PagerScopeImpl(state);
                $composer3.updateRememberedValue(value$iv6);
                pagerScope = (PagerScopeImpl) value$iv6;
                $composer3.endReplaceableGroup();
                $composer3.startReplaceableGroup(-510388795);
                if (($dirty & 458752) == 131072) {
                    invalid$iv7 = true;
                } else {
                    invalid$iv7 = false;
                }
                Object it$iv11119 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                $composer3.updateRememberedValue(value$iv7);
                consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                $composer3.endReplaceableGroup();
                if (isVertical) {
                    $composer3.startReplaceableGroup(-510388572);
                    LazyListState lazyListState13 = state.getLazyListState();
                    Arrangement.Vertical verticalM746spacedByD5KLDUw7 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                    $composer3.startReplaceableGroup(-510388141);
                    if (($dirty & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv9 = $composer3.rememberedValue();
                    if (invalid$iv9) {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    } else {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    }
                    r5.endReplaceableGroup();
                    LazyDslKt.LazyColumn(modifier, lazyListState13, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw7, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    r5.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceableGroup(-510387365);
                    LazyListState lazyListState14 = state.getLazyListState();
                    Arrangement.Horizontal horizontalM745spacedByD5KLDUw7 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                    $composer3.startReplaceableGroup(-510386937);
                    if (($dirty & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv8 = $composer3.rememberedValue();
                    if (invalid$iv8) {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    } else {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    }
                    $composer3.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                    LazyDslKt.LazyRow(modifier, lazyListState14, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw7, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    $composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verticalAlignment4 = verticalAlignment3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Alignment.Vertical vertical4 = verticalAlignment4;
                final Alignment.Horizontal horizontal4 = horizontalAlignment4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                    public final void invoke(Composer composer, int i9) {
                        Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical4, horizontal4, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                    }
                });
            }
        }
        i2 = ProfileVerifier.CompilationStatus.f245xf2722a21;
        $dirty2 |= i2;
        if ((i & 64) != 0) {
            if (($changed & 3670016) == 0) {
                if ($composer3.changed(flingBehavior)) {
                    i3 = 1048576;
                } else {
                    i3 = 524288;
                }
            }
            if ((i & 128) != 0) {
                $dirty2 |= 12582912;
            } else if (($changed & 29360128) != 0) {
                if ($composer3.changedInstance(function1)) {
                    i4 = 8388608;
                } else {
                    i4 = 4194304;
                }
                $dirty2 |= i4;
            }
            if ((i & 256) != 0) {
                if ((234881024 & $changed) == 0) {
                    if ($composer3.changed(contentPadding)) {
                        i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    } else {
                        i5 = 33554432;
                    }
                }
                if ((i & 512) != 0) {
                    $dirty2 |= 805306368;
                } else if ((1879048192 & $changed) != 0) {
                    if ($composer3.changed(userScrollEnabled)) {
                        i6 = 536870912;
                    } else {
                        i6 = 268435456;
                    }
                    $dirty2 |= i6;
                }
                i7 = i & 1024;
                if (i7 != 0) {
                    $dirty3 |= 6;
                } else if (($changed1 & 14) != 0) {
                    $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
                }
                i8 = i & 2048;
                if (i8 != 0) {
                    $dirty3 |= 48;
                } else if (($changed1 & 112) != 0) {
                    $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
                }
                if ((i & 4096) != 0) {
                    $dirty3 |= 384;
                } else if (($changed1 & 896) == 0) {
                    $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
                }
                $dirty1 = $dirty3;
                if ((1533916891 & $dirty2) != 306783378) {
                    if (i7 != 0) {
                        verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        verticalAlignment2 = verticalAlignment;
                    }
                    if (i8 != 0) {
                        horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                    } else {
                        horizontalAlignment2 = horizontalAlignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                    }
                    if (count >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("pageCount must be >= 0".toString());
                    }
                    $composer3.startReplaceableGroup(-510390079);
                    if (($dirty2 & 3670016) == 1048576) {
                        invalid$iv = true;
                    } else {
                        invalid$iv = false;
                    }
                    horizontalAlignment3 = horizontalAlignment2;
                    Object it$iv111110 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            FlingBehavior flingBehavior2 = flingBehavior;
                            SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                            if (snapperFlingBehavior != null) {
                                return snapperFlingBehavior.getAnimationTarget();
                            }
                            return null;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    $composer3.endReplaceableGroup();
                    state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                    Integer numValueOf8 = Integer.valueOf(count);
                    $composer3.startReplaceableGroup(-510389932);
                    if (($dirty2 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    verticalAlignment3 = verticalAlignment2;
                    if (($dirty2 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    invalid$iv2 = z2 | z3;
                    Object it$iv111111 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(numValueOf8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                    $composer3.startReplaceableGroup(-510389756);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv3 = true;
                    } else {
                        invalid$iv3 = false;
                    }
                    Object it$iv111112 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    value$iv3 = new Pager$Pager$4$1(state, null);
                    $composer3.updateRememberedValue(value$iv3);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                    $composer3.startReplaceableGroup(-510389361);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv4 = true;
                    } else {
                        invalid$iv4 = false;
                    }
                    Object it$iv111113 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    value$iv4 = new Pager$Pager$5$1(state, null);
                    $composer3.updateRememberedValue(value$iv4);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume8 = $composer3.consume(localDensity8);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density8 = (Density) objConsume8;
                    C1979Dp c1979DpM6799boximpl8 = C1979Dp.m6799boximpl(itemSpacing);
                    $composer3.startReplaceableGroup(-510389095);
                    boolean zChanged8 = $composer3.changed(density8);
                    if (($dirty2 & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z17 = zChanged8 | z4;
                    if ((57344 & $dirty2) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    invalid$iv5 = z17 | z5;
                    Object it$iv111114 = $composer3.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv5 = new Pager$Pager$6$1(density8, state, itemSpacing, null);
                    $composer3.updateRememberedValue(value$iv5);
                    $composer3.endReplaceableGroup();
                    $dirty = $dirty2;
                    EffectsKt.LaunchedEffect(density8, state, c1979DpM6799boximpl8, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                    $composer3.startReplaceableGroup(-510388995);
                    if (($dirty & 896) == 256) {
                        invalid$iv6 = true;
                    } else {
                        invalid$iv6 = false;
                    }
                    Object it$iv111115 = $composer3.rememberedValue();
                    if (invalid$iv6) {
                    }
                    value$iv6 = new PagerScopeImpl(state);
                    $composer3.updateRememberedValue(value$iv6);
                    pagerScope = (PagerScopeImpl) value$iv6;
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(-510388795);
                    if (($dirty & 458752) == 131072) {
                        invalid$iv7 = true;
                    } else {
                        invalid$iv7 = false;
                    }
                    Object it$iv111116 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                    $composer3.updateRememberedValue(value$iv7);
                    consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                    $composer3.endReplaceableGroup();
                    if (isVertical) {
                        $composer3.startReplaceableGroup(-510388572);
                        LazyListState lazyListState15 = state.getLazyListState();
                        Arrangement.Vertical verticalM746spacedByD5KLDUw8 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                        $composer3.startReplaceableGroup(-510388141);
                        if (($dirty & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv9 = $composer3.rememberedValue();
                        if (invalid$iv9) {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        } else {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        }
                        r5.endReplaceableGroup();
                        LazyDslKt.LazyColumn(modifier, lazyListState15, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw8, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        r5.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceableGroup(-510387365);
                        LazyListState lazyListState16 = state.getLazyListState();
                        Arrangement.Horizontal horizontalM745spacedByD5KLDUw8 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                        $composer3.startReplaceableGroup(-510386937);
                        if (($dirty & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv8 = $composer3.rememberedValue();
                        if (invalid$iv8) {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        } else {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        }
                        $composer3.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                        LazyDslKt.LazyRow(modifier, lazyListState16, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw8, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        $composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    verticalAlignment4 = verticalAlignment3;
                } else {
                    if (i7 != 0) {
                        verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        verticalAlignment2 = verticalAlignment;
                    }
                    if (i8 != 0) {
                        horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                    } else {
                        horizontalAlignment2 = horizontalAlignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                    }
                    if (count >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("pageCount must be >= 0".toString());
                    }
                    $composer3.startReplaceableGroup(-510390079);
                    if (($dirty2 & 3670016) == 1048576) {
                        invalid$iv = true;
                    } else {
                        invalid$iv = false;
                    }
                    horizontalAlignment3 = horizontalAlignment2;
                    Object it$iv111117 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            FlingBehavior flingBehavior2 = flingBehavior;
                            SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                            if (snapperFlingBehavior != null) {
                                return snapperFlingBehavior.getAnimationTarget();
                            }
                            return null;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    $composer3.endReplaceableGroup();
                    state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                    Integer numValueOf9 = Integer.valueOf(count);
                    $composer3.startReplaceableGroup(-510389932);
                    if (($dirty2 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    verticalAlignment3 = verticalAlignment2;
                    if (($dirty2 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    invalid$iv2 = z2 | z3;
                    Object it$iv111118 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = new Pager$Pager$3$1(state, count, null);
                        $composer3.updateRememberedValue(value$iv2);
                    }
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(numValueOf9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                    $composer3.startReplaceableGroup(-510389756);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv3 = true;
                    } else {
                        invalid$iv3 = false;
                    }
                    Object it$iv111119 = $composer3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    value$iv3 = new Pager$Pager$4$1(state, null);
                    $composer3.updateRememberedValue(value$iv3);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                    $composer3.startReplaceableGroup(-510389361);
                    if (($dirty2 & 896) == 256) {
                        invalid$iv4 = true;
                    } else {
                        invalid$iv4 = false;
                    }
                    Object it$iv1111110 = $composer3.rememberedValue();
                    if (invalid$iv4) {
                    }
                    value$iv4 = new Pager$Pager$5$1(state, null);
                    $composer3.updateRememberedValue(value$iv4);
                    $composer3.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                    ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume9 = $composer3.consume(localDensity9);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density9 = (Density) objConsume9;
                    C1979Dp c1979DpM6799boximpl9 = C1979Dp.m6799boximpl(itemSpacing);
                    $composer3.startReplaceableGroup(-510389095);
                    boolean zChanged9 = $composer3.changed(density9);
                    if (($dirty2 & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z18 = zChanged9 | z4;
                    if ((57344 & $dirty2) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    invalid$iv5 = z18 | z5;
                    Object it$iv1111111 = $composer3.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv5 = new Pager$Pager$6$1(density9, state, itemSpacing, null);
                    $composer3.updateRememberedValue(value$iv5);
                    $composer3.endReplaceableGroup();
                    $dirty = $dirty2;
                    EffectsKt.LaunchedEffect(density9, state, c1979DpM6799boximpl9, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                    $composer3.startReplaceableGroup(-510388995);
                    if (($dirty & 896) == 256) {
                        invalid$iv6 = true;
                    } else {
                        invalid$iv6 = false;
                    }
                    Object it$iv1111112 = $composer3.rememberedValue();
                    if (invalid$iv6) {
                    }
                    value$iv6 = new PagerScopeImpl(state);
                    $composer3.updateRememberedValue(value$iv6);
                    pagerScope = (PagerScopeImpl) value$iv6;
                    $composer3.endReplaceableGroup();
                    $composer3.startReplaceableGroup(-510388795);
                    if (($dirty & 458752) == 131072) {
                        invalid$iv7 = true;
                    } else {
                        invalid$iv7 = false;
                    }
                    Object it$iv1111113 = $composer3.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                    $composer3.updateRememberedValue(value$iv7);
                    consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                    $composer3.endReplaceableGroup();
                    if (isVertical) {
                        $composer3.startReplaceableGroup(-510388572);
                        LazyListState lazyListState17 = state.getLazyListState();
                        Arrangement.Vertical verticalM746spacedByD5KLDUw9 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                        $composer3.startReplaceableGroup(-510388141);
                        if (($dirty & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv9 = $composer3.rememberedValue();
                        if (invalid$iv9) {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        } else {
                            pagerScope2 = pagerScope;
                            value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyColumn) {
                                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                    LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv9);
                        }
                        r5.endReplaceableGroup();
                        LazyDslKt.LazyColumn(modifier, lazyListState17, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw9, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        r5.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                    } else {
                        $composer3.startReplaceableGroup(-510387365);
                        LazyListState lazyListState18 = state.getLazyListState();
                        Arrangement.Horizontal horizontalM745spacedByD5KLDUw9 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                        $composer3.startReplaceableGroup(-510386937);
                        if (($dirty & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (($dirty & 29360128) == 8388608) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                        value$iv8 = $composer3.rememberedValue();
                        if (invalid$iv8) {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        } else {
                            value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope LazyRow) {
                                    Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                    int i9 = count;
                                    Function1<Integer, Object> function2 = function1;
                                    final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                    final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                    final PagerScopeImpl pagerScopeImpl = pagerScope;
                                    LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                            Function0<ComposeUiNode> function0;
                                            Intrinsics.checkNotNullParameter(items, "$this$items");
                                            int $dirty4 = $changed2;
                                            if (($changed2 & 14) == 0) {
                                                $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                            }
                                            if (($changed2 & 112) == 0) {
                                                $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                            }
                                            if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                                }
                                                Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                                Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                                PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                                $composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                                int $changed$iv$iv = (0 << 3) & 112;
                                                $composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                                int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                                if (!($composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                $composer4.startReusableNode();
                                                if ($composer4.getInserting()) {
                                                    function0 = constructor;
                                                    $composer4.createNode(function0);
                                                } else {
                                                    function0 = constructor;
                                                    $composer4.useNode();
                                                }
                                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                                $composer4.startReplaceableGroup(2058660585);
                                                int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                int i11 = ((0 >> 6) & 112) | 6;
                                                function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                                $composer4.endReplaceableGroup();
                                                $composer4.endNode();
                                                $composer4.endReplaceableGroup();
                                                $composer4.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer4.skipToGroupEnd();
                                        }
                                    }), 4, null);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv8);
                        }
                        $composer3.endReplaceableGroup();
                        horizontalAlignment4 = horizontalAlignment3;
                        $composer2 = $composer3;
                        LazyDslKt.LazyRow(modifier, lazyListState18, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw9, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                        $composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    verticalAlignment4 = verticalAlignment3;
                }
                scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Alignment.Vertical vertical5 = verticalAlignment4;
                    final Alignment.Horizontal horizontal5 = horizontalAlignment4;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                        public final void invoke(Composer composer, int i9) {
                            Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical5, horizontal5, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                        }
                    });
                }
            }
            i5 = 100663296;
            $dirty2 |= i5;
            if ((i & 512) != 0) {
                $dirty2 |= 805306368;
            } else if ((1879048192 & $changed) != 0) {
                if ($composer3.changed(userScrollEnabled)) {
                    i6 = 536870912;
                } else {
                    i6 = 268435456;
                }
                $dirty2 |= i6;
            }
            i7 = i & 1024;
            if (i7 != 0) {
                $dirty3 |= 6;
            } else if (($changed1 & 14) != 0) {
                $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
            }
            i8 = i & 2048;
            if (i8 != 0) {
                $dirty3 |= 48;
            } else if (($changed1 & 112) != 0) {
                $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
            }
            if ((i & 4096) != 0) {
                $dirty3 |= 384;
            } else if (($changed1 & 896) == 0) {
                $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
            }
            $dirty1 = $dirty3;
            if ((1533916891 & $dirty2) != 306783378) {
                if (i7 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                } else {
                    verticalAlignment2 = verticalAlignment;
                }
                if (i8 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                } else {
                    horizontalAlignment2 = horizontalAlignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                }
                if (count >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("pageCount must be >= 0".toString());
                }
                $composer3.startReplaceableGroup(-510390079);
                if (($dirty2 & 3670016) == 1048576) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                horizontalAlignment3 = horizontalAlignment2;
                Object it$iv1111114 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        FlingBehavior flingBehavior2 = flingBehavior;
                        SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                        if (snapperFlingBehavior != null) {
                            return snapperFlingBehavior.getAnimationTarget();
                        }
                        return null;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                $composer3.endReplaceableGroup();
                state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                Integer numValueOf10 = Integer.valueOf(count);
                $composer3.startReplaceableGroup(-510389932);
                if (($dirty2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                verticalAlignment3 = verticalAlignment2;
                if (($dirty2 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv2 = z2 | z3;
                Object it$iv1111115 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                }
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(numValueOf10, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                $composer3.startReplaceableGroup(-510389756);
                if (($dirty2 & 896) == 256) {
                    invalid$iv3 = true;
                } else {
                    invalid$iv3 = false;
                }
                Object it$iv1111116 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv3 = new Pager$Pager$4$1(state, null);
                $composer3.updateRememberedValue(value$iv3);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                $composer3.startReplaceableGroup(-510389361);
                if (($dirty2 & 896) == 256) {
                    invalid$iv4 = true;
                } else {
                    invalid$iv4 = false;
                }
                Object it$iv1111117 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv4 = new Pager$Pager$5$1(state, null);
                $composer3.updateRememberedValue(value$iv4);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume10 = $composer3.consume(localDensity10);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density10 = (Density) objConsume10;
                C1979Dp c1979DpM6799boximpl10 = C1979Dp.m6799boximpl(itemSpacing);
                $composer3.startReplaceableGroup(-510389095);
                boolean zChanged10 = $composer3.changed(density10);
                if (($dirty2 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z19 = zChanged10 | z4;
                if ((57344 & $dirty2) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                invalid$iv5 = z19 | z5;
                Object it$iv1111118 = $composer3.rememberedValue();
                if (invalid$iv5) {
                }
                value$iv5 = new Pager$Pager$6$1(density10, state, itemSpacing, null);
                $composer3.updateRememberedValue(value$iv5);
                $composer3.endReplaceableGroup();
                $dirty = $dirty2;
                EffectsKt.LaunchedEffect(density10, state, c1979DpM6799boximpl10, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                $composer3.startReplaceableGroup(-510388995);
                if (($dirty & 896) == 256) {
                    invalid$iv6 = true;
                } else {
                    invalid$iv6 = false;
                }
                Object it$iv1111119 = $composer3.rememberedValue();
                if (invalid$iv6) {
                }
                value$iv6 = new PagerScopeImpl(state);
                $composer3.updateRememberedValue(value$iv6);
                pagerScope = (PagerScopeImpl) value$iv6;
                $composer3.endReplaceableGroup();
                $composer3.startReplaceableGroup(-510388795);
                if (($dirty & 458752) == 131072) {
                    invalid$iv7 = true;
                } else {
                    invalid$iv7 = false;
                }
                Object it$iv11111110 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                $composer3.updateRememberedValue(value$iv7);
                consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                $composer3.endReplaceableGroup();
                if (isVertical) {
                    $composer3.startReplaceableGroup(-510388572);
                    LazyListState lazyListState19 = state.getLazyListState();
                    Arrangement.Vertical verticalM746spacedByD5KLDUw10 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                    $composer3.startReplaceableGroup(-510388141);
                    if (($dirty & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv9 = $composer3.rememberedValue();
                    if (invalid$iv9) {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    } else {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    }
                    r5.endReplaceableGroup();
                    LazyDslKt.LazyColumn(modifier, lazyListState19, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw10, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    r5.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceableGroup(-510387365);
                    LazyListState lazyListState110 = state.getLazyListState();
                    Arrangement.Horizontal horizontalM745spacedByD5KLDUw10 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                    $composer3.startReplaceableGroup(-510386937);
                    if (($dirty & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv8 = $composer3.rememberedValue();
                    if (invalid$iv8) {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    } else {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    }
                    $composer3.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                    LazyDslKt.LazyRow(modifier, lazyListState110, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw10, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    $composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verticalAlignment4 = verticalAlignment3;
            } else {
                if (i7 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                } else {
                    verticalAlignment2 = verticalAlignment;
                }
                if (i8 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                } else {
                    horizontalAlignment2 = horizontalAlignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                }
                if (count >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("pageCount must be >= 0".toString());
                }
                $composer3.startReplaceableGroup(-510390079);
                if (($dirty2 & 3670016) == 1048576) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                horizontalAlignment3 = horizontalAlignment2;
                Object it$iv11111111 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        FlingBehavior flingBehavior2 = flingBehavior;
                        SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                        if (snapperFlingBehavior != null) {
                            return snapperFlingBehavior.getAnimationTarget();
                        }
                        return null;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                $composer3.endReplaceableGroup();
                state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                Integer numValueOf11 = Integer.valueOf(count);
                $composer3.startReplaceableGroup(-510389932);
                if (($dirty2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                verticalAlignment3 = verticalAlignment2;
                if (($dirty2 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv2 = z2 | z3;
                Object it$iv11111112 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                }
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(numValueOf11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                $composer3.startReplaceableGroup(-510389756);
                if (($dirty2 & 896) == 256) {
                    invalid$iv3 = true;
                } else {
                    invalid$iv3 = false;
                }
                Object it$iv11111113 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv3 = new Pager$Pager$4$1(state, null);
                $composer3.updateRememberedValue(value$iv3);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                $composer3.startReplaceableGroup(-510389361);
                if (($dirty2 & 896) == 256) {
                    invalid$iv4 = true;
                } else {
                    invalid$iv4 = false;
                }
                Object it$iv11111114 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv4 = new Pager$Pager$5$1(state, null);
                $composer3.updateRememberedValue(value$iv4);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11 = $composer3.consume(localDensity11);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density11 = (Density) objConsume11;
                C1979Dp c1979DpM6799boximpl11 = C1979Dp.m6799boximpl(itemSpacing);
                $composer3.startReplaceableGroup(-510389095);
                boolean zChanged11 = $composer3.changed(density11);
                if (($dirty2 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z110 = zChanged11 | z4;
                if ((57344 & $dirty2) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                invalid$iv5 = z110 | z5;
                Object it$iv11111115 = $composer3.rememberedValue();
                if (invalid$iv5) {
                }
                value$iv5 = new Pager$Pager$6$1(density11, state, itemSpacing, null);
                $composer3.updateRememberedValue(value$iv5);
                $composer3.endReplaceableGroup();
                $dirty = $dirty2;
                EffectsKt.LaunchedEffect(density11, state, c1979DpM6799boximpl11, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                $composer3.startReplaceableGroup(-510388995);
                if (($dirty & 896) == 256) {
                    invalid$iv6 = true;
                } else {
                    invalid$iv6 = false;
                }
                Object it$iv11111116 = $composer3.rememberedValue();
                if (invalid$iv6) {
                }
                value$iv6 = new PagerScopeImpl(state);
                $composer3.updateRememberedValue(value$iv6);
                pagerScope = (PagerScopeImpl) value$iv6;
                $composer3.endReplaceableGroup();
                $composer3.startReplaceableGroup(-510388795);
                if (($dirty & 458752) == 131072) {
                    invalid$iv7 = true;
                } else {
                    invalid$iv7 = false;
                }
                Object it$iv11111117 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                $composer3.updateRememberedValue(value$iv7);
                consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                $composer3.endReplaceableGroup();
                if (isVertical) {
                    $composer3.startReplaceableGroup(-510388572);
                    LazyListState lazyListState111 = state.getLazyListState();
                    Arrangement.Vertical verticalM746spacedByD5KLDUw11 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                    $composer3.startReplaceableGroup(-510388141);
                    if (($dirty & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv9 = $composer3.rememberedValue();
                    if (invalid$iv9) {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    } else {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    }
                    r5.endReplaceableGroup();
                    LazyDslKt.LazyColumn(modifier, lazyListState111, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw11, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    r5.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceableGroup(-510387365);
                    LazyListState lazyListState112 = state.getLazyListState();
                    Arrangement.Horizontal horizontalM745spacedByD5KLDUw11 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                    $composer3.startReplaceableGroup(-510386937);
                    if (($dirty & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv8 = $composer3.rememberedValue();
                    if (invalid$iv8) {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    } else {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    }
                    $composer3.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                    LazyDslKt.LazyRow(modifier, lazyListState112, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw11, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    $composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verticalAlignment4 = verticalAlignment3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Alignment.Vertical vertical6 = verticalAlignment4;
                final Alignment.Horizontal horizontal6 = horizontalAlignment4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                    public final void invoke(Composer composer, int i9) {
                        Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical6, horizontal6, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                    }
                });
            }
        }
        i3 = 1572864;
        $dirty2 |= i3;
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) != 0) {
            if ($composer3.changedInstance(function1)) {
                i4 = 8388608;
            } else {
                i4 = 4194304;
            }
            $dirty2 |= i4;
        }
        if ((i & 256) != 0) {
            if ((234881024 & $changed) == 0) {
                if ($composer3.changed(contentPadding)) {
                    i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i5 = 33554432;
                }
            }
            if ((i & 512) != 0) {
                $dirty2 |= 805306368;
            } else if ((1879048192 & $changed) != 0) {
                if ($composer3.changed(userScrollEnabled)) {
                    i6 = 536870912;
                } else {
                    i6 = 268435456;
                }
                $dirty2 |= i6;
            }
            i7 = i & 1024;
            if (i7 != 0) {
                $dirty3 |= 6;
            } else if (($changed1 & 14) != 0) {
                $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
            }
            i8 = i & 2048;
            if (i8 != 0) {
                $dirty3 |= 48;
            } else if (($changed1 & 112) != 0) {
                $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
            }
            if ((i & 4096) != 0) {
                $dirty3 |= 384;
            } else if (($changed1 & 896) == 0) {
                $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
            }
            $dirty1 = $dirty3;
            if ((1533916891 & $dirty2) != 306783378) {
                if (i7 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                } else {
                    verticalAlignment2 = verticalAlignment;
                }
                if (i8 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                } else {
                    horizontalAlignment2 = horizontalAlignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                }
                if (count >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("pageCount must be >= 0".toString());
                }
                $composer3.startReplaceableGroup(-510390079);
                if (($dirty2 & 3670016) == 1048576) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                horizontalAlignment3 = horizontalAlignment2;
                Object it$iv11111118 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        FlingBehavior flingBehavior2 = flingBehavior;
                        SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                        if (snapperFlingBehavior != null) {
                            return snapperFlingBehavior.getAnimationTarget();
                        }
                        return null;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                $composer3.endReplaceableGroup();
                state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                Integer numValueOf12 = Integer.valueOf(count);
                $composer3.startReplaceableGroup(-510389932);
                if (($dirty2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                verticalAlignment3 = verticalAlignment2;
                if (($dirty2 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv2 = z2 | z3;
                Object it$iv11111119 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                }
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(numValueOf12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                $composer3.startReplaceableGroup(-510389756);
                if (($dirty2 & 896) == 256) {
                    invalid$iv3 = true;
                } else {
                    invalid$iv3 = false;
                }
                Object it$iv111111110 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv3 = new Pager$Pager$4$1(state, null);
                $composer3.updateRememberedValue(value$iv3);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                $composer3.startReplaceableGroup(-510389361);
                if (($dirty2 & 896) == 256) {
                    invalid$iv4 = true;
                } else {
                    invalid$iv4 = false;
                }
                Object it$iv111111111 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv4 = new Pager$Pager$5$1(state, null);
                $composer3.updateRememberedValue(value$iv4);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume12 = $composer3.consume(localDensity12);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density12 = (Density) objConsume12;
                C1979Dp c1979DpM6799boximpl12 = C1979Dp.m6799boximpl(itemSpacing);
                $composer3.startReplaceableGroup(-510389095);
                boolean zChanged12 = $composer3.changed(density12);
                if (($dirty2 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z111 = zChanged12 | z4;
                if ((57344 & $dirty2) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                invalid$iv5 = z111 | z5;
                Object it$iv111111112 = $composer3.rememberedValue();
                if (invalid$iv5) {
                }
                value$iv5 = new Pager$Pager$6$1(density12, state, itemSpacing, null);
                $composer3.updateRememberedValue(value$iv5);
                $composer3.endReplaceableGroup();
                $dirty = $dirty2;
                EffectsKt.LaunchedEffect(density12, state, c1979DpM6799boximpl12, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                $composer3.startReplaceableGroup(-510388995);
                if (($dirty & 896) == 256) {
                    invalid$iv6 = true;
                } else {
                    invalid$iv6 = false;
                }
                Object it$iv111111113 = $composer3.rememberedValue();
                if (invalid$iv6) {
                }
                value$iv6 = new PagerScopeImpl(state);
                $composer3.updateRememberedValue(value$iv6);
                pagerScope = (PagerScopeImpl) value$iv6;
                $composer3.endReplaceableGroup();
                $composer3.startReplaceableGroup(-510388795);
                if (($dirty & 458752) == 131072) {
                    invalid$iv7 = true;
                } else {
                    invalid$iv7 = false;
                }
                Object it$iv111111114 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                $composer3.updateRememberedValue(value$iv7);
                consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                $composer3.endReplaceableGroup();
                if (isVertical) {
                    $composer3.startReplaceableGroup(-510388572);
                    LazyListState lazyListState113 = state.getLazyListState();
                    Arrangement.Vertical verticalM746spacedByD5KLDUw12 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                    $composer3.startReplaceableGroup(-510388141);
                    if (($dirty & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv9 = $composer3.rememberedValue();
                    if (invalid$iv9) {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    } else {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    }
                    r5.endReplaceableGroup();
                    LazyDslKt.LazyColumn(modifier, lazyListState113, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw12, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    r5.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceableGroup(-510387365);
                    LazyListState lazyListState114 = state.getLazyListState();
                    Arrangement.Horizontal horizontalM745spacedByD5KLDUw12 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                    $composer3.startReplaceableGroup(-510386937);
                    if (($dirty & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv8 = $composer3.rememberedValue();
                    if (invalid$iv8) {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    } else {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    }
                    $composer3.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                    LazyDslKt.LazyRow(modifier, lazyListState114, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw12, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    $composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verticalAlignment4 = verticalAlignment3;
            } else {
                if (i7 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                } else {
                    verticalAlignment2 = verticalAlignment;
                }
                if (i8 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                } else {
                    horizontalAlignment2 = horizontalAlignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
                }
                if (count >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("pageCount must be >= 0".toString());
                }
                $composer3.startReplaceableGroup(-510390079);
                if (($dirty2 & 3670016) == 1048576) {
                    invalid$iv = true;
                } else {
                    invalid$iv = false;
                }
                horizontalAlignment3 = horizontalAlignment2;
                Object it$iv111111115 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Integer invoke() {
                        FlingBehavior flingBehavior2 = flingBehavior;
                        SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                        if (snapperFlingBehavior != null) {
                            return snapperFlingBehavior.getAnimationTarget();
                        }
                        return null;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                $composer3.endReplaceableGroup();
                state.setFlingAnimationTarget$pager_release((Function0) value$iv);
                Integer numValueOf13 = Integer.valueOf(count);
                $composer3.startReplaceableGroup(-510389932);
                if (($dirty2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                verticalAlignment3 = verticalAlignment2;
                if (($dirty2 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv2 = z2 | z3;
                Object it$iv111111116 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = new Pager$Pager$3$1(state, count, null);
                    $composer3.updateRememberedValue(value$iv2);
                }
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(numValueOf13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
                $composer3.startReplaceableGroup(-510389756);
                if (($dirty2 & 896) == 256) {
                    invalid$iv3 = true;
                } else {
                    invalid$iv3 = false;
                }
                Object it$iv111111117 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv3 = new Pager$Pager$4$1(state, null);
                $composer3.updateRememberedValue(value$iv3);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
                $composer3.startReplaceableGroup(-510389361);
                if (($dirty2 & 896) == 256) {
                    invalid$iv4 = true;
                } else {
                    invalid$iv4 = false;
                }
                Object it$iv111111118 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                value$iv4 = new Pager$Pager$5$1(state, null);
                $composer3.updateRememberedValue(value$iv4);
                $composer3.endReplaceableGroup();
                EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
                ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume13 = $composer3.consume(localDensity13);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density13 = (Density) objConsume13;
                C1979Dp c1979DpM6799boximpl13 = C1979Dp.m6799boximpl(itemSpacing);
                $composer3.startReplaceableGroup(-510389095);
                boolean zChanged13 = $composer3.changed(density13);
                if (($dirty2 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z112 = zChanged13 | z4;
                if ((57344 & $dirty2) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                invalid$iv5 = z112 | z5;
                Object it$iv111111119 = $composer3.rememberedValue();
                if (invalid$iv5) {
                }
                value$iv5 = new Pager$Pager$6$1(density13, state, itemSpacing, null);
                $composer3.updateRememberedValue(value$iv5);
                $composer3.endReplaceableGroup();
                $dirty = $dirty2;
                EffectsKt.LaunchedEffect(density13, state, c1979DpM6799boximpl13, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
                $composer3.startReplaceableGroup(-510388995);
                if (($dirty & 896) == 256) {
                    invalid$iv6 = true;
                } else {
                    invalid$iv6 = false;
                }
                Object it$iv1111111110 = $composer3.rememberedValue();
                if (invalid$iv6) {
                }
                value$iv6 = new PagerScopeImpl(state);
                $composer3.updateRememberedValue(value$iv6);
                pagerScope = (PagerScopeImpl) value$iv6;
                $composer3.endReplaceableGroup();
                $composer3.startReplaceableGroup(-510388795);
                if (($dirty & 458752) == 131072) {
                    invalid$iv7 = true;
                } else {
                    invalid$iv7 = false;
                }
                Object it$iv1111111111 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
                $composer3.updateRememberedValue(value$iv7);
                consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
                $composer3.endReplaceableGroup();
                if (isVertical) {
                    $composer3.startReplaceableGroup(-510388572);
                    LazyListState lazyListState115 = state.getLazyListState();
                    Arrangement.Vertical verticalM746spacedByD5KLDUw13 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                    $composer3.startReplaceableGroup(-510388141);
                    if (($dirty & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv9 = $composer3.rememberedValue();
                    if (invalid$iv9) {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    } else {
                        pagerScope2 = pagerScope;
                        value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope2;
                                LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    }
                    r5.endReplaceableGroup();
                    LazyDslKt.LazyColumn(modifier, lazyListState115, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw13, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    r5.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceableGroup(-510387365);
                    LazyListState lazyListState116 = state.getLazyListState();
                    Arrangement.Horizontal horizontalM745spacedByD5KLDUw13 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                    $composer3.startReplaceableGroup(-510386937);
                    if (($dirty & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (($dirty & 29360128) == 8388608) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                    value$iv8 = $composer3.rememberedValue();
                    if (invalid$iv8) {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    } else {
                        value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyRow) {
                                Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                                int i9 = count;
                                Function1<Integer, Object> function2 = function1;
                                final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                                final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                                final PagerScopeImpl pagerScopeImpl = pagerScope;
                                LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                        Function0<ComposeUiNode> function0;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        int $dirty4 = $changed2;
                                        if (($changed2 & 14) == 0) {
                                            $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed2 & 112) == 0) {
                                            $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                        }
                                        if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                            }
                                            Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                            Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                            PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                            $composer4.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                function0 = constructor;
                                                $composer4.createNode(function0);
                                            } else {
                                                function0 = constructor;
                                                $composer4.useNode();
                                            }
                                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            int i11 = ((0 >> 6) & 112) | 6;
                                            function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    }
                    $composer3.endReplaceableGroup();
                    horizontalAlignment4 = horizontalAlignment3;
                    $composer2 = $composer3;
                    LazyDslKt.LazyRow(modifier, lazyListState116, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw13, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                    $composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verticalAlignment4 = verticalAlignment3;
            }
            scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Alignment.Vertical vertical7 = verticalAlignment4;
                final Alignment.Horizontal horizontal7 = horizontalAlignment4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                    public final void invoke(Composer composer, int i9) {
                        Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical7, horizontal7, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                    }
                });
            }
        }
        i5 = 100663296;
        $dirty2 |= i5;
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if ((1879048192 & $changed) != 0) {
            if ($composer3.changed(userScrollEnabled)) {
                i6 = 536870912;
            } else {
                i6 = 268435456;
            }
            $dirty2 |= i6;
        }
        i7 = i & 1024;
        if (i7 != 0) {
            $dirty3 |= 6;
        } else if (($changed1 & 14) != 0) {
            $dirty3 |= $composer3.changed(verticalAlignment) ? 4 : 2;
        }
        i8 = i & 2048;
        if (i8 != 0) {
            $dirty3 |= 48;
        } else if (($changed1 & 112) != 0) {
            $dirty3 |= $composer3.changed(horizontalAlignment) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty3 |= $composer3.changedInstance(content) ? 256 : 128;
        }
        $dirty1 = $dirty3;
        if ((1533916891 & $dirty2) != 306783378) {
            if (i7 != 0) {
                verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
            } else {
                verticalAlignment2 = verticalAlignment;
            }
            if (i8 != 0) {
                horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
            } else {
                horizontalAlignment2 = horizontalAlignment;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
            }
            if (count >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("pageCount must be >= 0".toString());
            }
            $composer3.startReplaceableGroup(-510390079);
            if (($dirty2 & 3670016) == 1048576) {
                invalid$iv = true;
            } else {
                invalid$iv = false;
            }
            horizontalAlignment3 = horizontalAlignment2;
            Object it$iv1111111112 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    FlingBehavior flingBehavior2 = flingBehavior;
                    SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                    if (snapperFlingBehavior != null) {
                        return snapperFlingBehavior.getAnimationTarget();
                    }
                    return null;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            $composer3.endReplaceableGroup();
            state.setFlingAnimationTarget$pager_release((Function0) value$iv);
            Integer numValueOf14 = Integer.valueOf(count);
            $composer3.startReplaceableGroup(-510389932);
            if (($dirty2 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            verticalAlignment3 = verticalAlignment2;
            if (($dirty2 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            invalid$iv2 = z2 | z3;
            Object it$iv1111111113 = $composer3.rememberedValue();
            if (invalid$iv2) {
                value$iv2 = new Pager$Pager$3$1(state, count, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = new Pager$Pager$3$1(state, count, null);
                $composer3.updateRememberedValue(value$iv2);
            }
            $composer3.endReplaceableGroup();
            EffectsKt.LaunchedEffect(numValueOf14, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
            $composer3.startReplaceableGroup(-510389756);
            if (($dirty2 & 896) == 256) {
                invalid$iv3 = true;
            } else {
                invalid$iv3 = false;
            }
            Object it$iv1111111114 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            value$iv3 = new Pager$Pager$4$1(state, null);
            $composer3.updateRememberedValue(value$iv3);
            $composer3.endReplaceableGroup();
            EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
            $composer3.startReplaceableGroup(-510389361);
            if (($dirty2 & 896) == 256) {
                invalid$iv4 = true;
            } else {
                invalid$iv4 = false;
            }
            Object it$iv1111111115 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            value$iv4 = new Pager$Pager$5$1(state, null);
            $composer3.updateRememberedValue(value$iv4);
            $composer3.endReplaceableGroup();
            EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
            ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume14 = $composer3.consume(localDensity14);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density14 = (Density) objConsume14;
            C1979Dp c1979DpM6799boximpl14 = C1979Dp.m6799boximpl(itemSpacing);
            $composer3.startReplaceableGroup(-510389095);
            boolean zChanged14 = $composer3.changed(density14);
            if (($dirty2 & 896) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z113 = zChanged14 | z4;
            if ((57344 & $dirty2) == 16384) {
                z5 = true;
            } else {
                z5 = false;
            }
            invalid$iv5 = z113 | z5;
            Object it$iv1111111116 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            value$iv5 = new Pager$Pager$6$1(density14, state, itemSpacing, null);
            $composer3.updateRememberedValue(value$iv5);
            $composer3.endReplaceableGroup();
            $dirty = $dirty2;
            EffectsKt.LaunchedEffect(density14, state, c1979DpM6799boximpl14, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
            $composer3.startReplaceableGroup(-510388995);
            if (($dirty & 896) == 256) {
                invalid$iv6 = true;
            } else {
                invalid$iv6 = false;
            }
            Object it$iv1111111117 = $composer3.rememberedValue();
            if (invalid$iv6) {
            }
            value$iv6 = new PagerScopeImpl(state);
            $composer3.updateRememberedValue(value$iv6);
            pagerScope = (PagerScopeImpl) value$iv6;
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-510388795);
            if (($dirty & 458752) == 131072) {
                invalid$iv7 = true;
            } else {
                invalid$iv7 = false;
            }
            Object it$iv1111111118 = $composer3.rememberedValue();
            if (invalid$iv7) {
            }
            value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
            $composer3.updateRememberedValue(value$iv7);
            consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
            $composer3.endReplaceableGroup();
            if (isVertical) {
                $composer3.startReplaceableGroup(-510388572);
                LazyListState lazyListState117 = state.getLazyListState();
                Arrangement.Vertical verticalM746spacedByD5KLDUw14 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                $composer3.startReplaceableGroup(-510388141);
                if (($dirty & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (($dirty & 29360128) == 8388608) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                value$iv9 = $composer3.rememberedValue();
                if (invalid$iv9) {
                    pagerScope2 = pagerScope;
                    value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope2;
                            LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                } else {
                    pagerScope2 = pagerScope;
                    value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope2;
                            LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                }
                r5.endReplaceableGroup();
                LazyDslKt.LazyColumn(modifier, lazyListState117, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw14, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                r5.endReplaceableGroup();
                horizontalAlignment4 = horizontalAlignment3;
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceableGroup(-510387365);
                LazyListState lazyListState118 = state.getLazyListState();
                Arrangement.Horizontal horizontalM745spacedByD5KLDUw14 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                $composer3.startReplaceableGroup(-510386937);
                if (($dirty & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (($dirty & 29360128) == 8388608) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                value$iv8 = $composer3.rememberedValue();
                if (invalid$iv8) {
                    value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyRow) {
                            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope;
                            LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyRow) {
                            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope;
                            LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                }
                $composer3.endReplaceableGroup();
                horizontalAlignment4 = horizontalAlignment3;
                $composer2 = $composer3;
                LazyDslKt.LazyRow(modifier, lazyListState118, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw14, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            verticalAlignment4 = verticalAlignment3;
        } else {
            if (i7 != 0) {
                verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
            } else {
                verticalAlignment2 = verticalAlignment;
            }
            if (i8 != 0) {
                horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
            } else {
                horizontalAlignment2 = horizontalAlignment;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1072219707, $dirty2, $dirty1, "com.google.accompanist.pager.Pager (Pager.kt:378)");
            }
            if (count >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("pageCount must be >= 0".toString());
            }
            $composer3.startReplaceableGroup(-510390079);
            if (($dirty2 & 3670016) == 1048576) {
                invalid$iv = true;
            } else {
                invalid$iv = false;
            }
            horizontalAlignment3 = horizontalAlignment2;
            Object it$iv1111111119 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = (Function0) new Function0<Integer>() { // from class: com.google.accompanist.pager.Pager$Pager$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    FlingBehavior flingBehavior2 = flingBehavior;
                    SnapperFlingBehavior snapperFlingBehavior = flingBehavior2 instanceof SnapperFlingBehavior ? (SnapperFlingBehavior) flingBehavior2 : null;
                    if (snapperFlingBehavior != null) {
                        return snapperFlingBehavior.getAnimationTarget();
                    }
                    return null;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            $composer3.endReplaceableGroup();
            state.setFlingAnimationTarget$pager_release((Function0) value$iv);
            Integer numValueOf15 = Integer.valueOf(count);
            $composer3.startReplaceableGroup(-510389932);
            if (($dirty2 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            verticalAlignment3 = verticalAlignment2;
            if (($dirty2 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            invalid$iv2 = z2 | z3;
            Object it$iv11111111110 = $composer3.rememberedValue();
            if (invalid$iv2) {
                value$iv2 = new Pager$Pager$3$1(state, count, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = new Pager$Pager$3$1(state, count, null);
                $composer3.updateRememberedValue(value$iv2);
            }
            $composer3.endReplaceableGroup();
            EffectsKt.LaunchedEffect(numValueOf15, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer3, ($dirty2 & 14) | 64);
            $composer3.startReplaceableGroup(-510389756);
            if (($dirty2 & 896) == 256) {
                invalid$iv3 = true;
            } else {
                invalid$iv3 = false;
            }
            Object it$iv11111111111 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            value$iv3 = new Pager$Pager$4$1(state, null);
            $composer3.updateRememberedValue(value$iv3);
            $composer3.endReplaceableGroup();
            EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer3, (($dirty2 >> 6) & 14) | 64);
            $composer3.startReplaceableGroup(-510389361);
            if (($dirty2 & 896) == 256) {
                invalid$iv4 = true;
            } else {
                invalid$iv4 = false;
            }
            Object it$iv11111111112 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            value$iv4 = new Pager$Pager$5$1(state, null);
            $composer3.updateRememberedValue(value$iv4);
            $composer3.endReplaceableGroup();
            EffectsKt.LaunchedEffect(state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer3, (($dirty2 >> 6) & 14) | 64);
            ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume15 = $composer3.consume(localDensity15);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density15 = (Density) objConsume15;
            C1979Dp c1979DpM6799boximpl15 = C1979Dp.m6799boximpl(itemSpacing);
            $composer3.startReplaceableGroup(-510389095);
            boolean zChanged15 = $composer3.changed(density15);
            if (($dirty2 & 896) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z114 = zChanged15 | z4;
            if ((57344 & $dirty2) == 16384) {
                z5 = true;
            } else {
                z5 = false;
            }
            invalid$iv5 = z114 | z5;
            Object it$iv11111111113 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            value$iv5 = new Pager$Pager$6$1(density15, state, itemSpacing, null);
            $composer3.updateRememberedValue(value$iv5);
            $composer3.endReplaceableGroup();
            $dirty = $dirty2;
            EffectsKt.LaunchedEffect(density15, state, c1979DpM6799boximpl15, (Function2) value$iv5, $composer3, (($dirty2 >> 6) & 896) | (($dirty2 >> 3) & 112) | 4096);
            $composer3.startReplaceableGroup(-510388995);
            if (($dirty & 896) == 256) {
                invalid$iv6 = true;
            } else {
                invalid$iv6 = false;
            }
            Object it$iv11111111114 = $composer3.rememberedValue();
            if (invalid$iv6) {
            }
            value$iv6 = new PagerScopeImpl(state);
            $composer3.updateRememberedValue(value$iv6);
            pagerScope = (PagerScopeImpl) value$iv6;
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-510388795);
            if (($dirty & 458752) == 131072) {
                invalid$iv7 = true;
            } else {
                invalid$iv7 = false;
            }
            Object it$iv11111111115 = $composer3.rememberedValue();
            if (invalid$iv7) {
            }
            value$iv7 = new ConsumeFlingNestedScrollConnection(!isVertical, isVertical, state);
            $composer3.updateRememberedValue(value$iv7);
            consumeFlingNestedScrollConnection = (ConsumeFlingNestedScrollConnection) value$iv7;
            $composer3.endReplaceableGroup();
            if (isVertical) {
                $composer3.startReplaceableGroup(-510388572);
                LazyListState lazyListState119 = state.getLazyListState();
                Arrangement.Vertical verticalM746spacedByD5KLDUw15 = Arrangement.INSTANCE.m746spacedByD5KLDUw(itemSpacing, verticalAlignment3);
                $composer3.startReplaceableGroup(-510388141);
                if (($dirty & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (($dirty & 29360128) == 8388608) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                invalid$iv9 = z8 | z9 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                value$iv9 = $composer3.rememberedValue();
                if (invalid$iv9) {
                    pagerScope2 = pagerScope;
                    value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope2;
                            LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                } else {
                    pagerScope2 = pagerScope;
                    value$iv9 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope2;
                            LazyListScope.CC.items$default(LazyColumn, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(1889356237, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$7$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1889356237, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:439)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxHeight$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                }
                r5.endReplaceableGroup();
                LazyDslKt.LazyColumn(modifier, lazyListState119, contentPadding, reverseLayout, verticalM746spacedByD5KLDUw15, horizontalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv9, r5, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 12) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                r5.endReplaceableGroup();
                horizontalAlignment4 = horizontalAlignment3;
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceableGroup(-510387365);
                LazyListState lazyListState1110 = state.getLazyListState();
                Arrangement.Horizontal horizontalM745spacedByD5KLDUw15 = Arrangement.INSTANCE.m745spacedByD5KLDUw(itemSpacing, horizontalAlignment3);
                $composer3.startReplaceableGroup(-510386937);
                if (($dirty & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (($dirty & 29360128) == 8388608) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                invalid$iv8 = z6 | z7 | $composer3.changed(consumeFlingNestedScrollConnection) | (($dirty1 & 896) == 256) | $composer3.changed(pagerScope);
                value$iv8 = $composer3.rememberedValue();
                if (invalid$iv8) {
                    value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyRow) {
                            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope;
                            LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = new Function1<LazyListScope, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyRow) {
                            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                            int i9 = count;
                            Function1<Integer, Object> function2 = function1;
                            final ConsumeFlingNestedScrollConnection consumeFlingNestedScrollConnection2 = consumeFlingNestedScrollConnection;
                            final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4 = content;
                            final PagerScopeImpl pagerScopeImpl = pagerScope;
                            LazyListScope.CC.items$default(LazyRow, i9, function2, null, ComposableLambdaKt.composableLambdaInstance(-70560628, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$8$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int page, Composer $composer4, int $changed2) {
                                    Function0<ComposeUiNode> function0;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    int $dirty4 = $changed2;
                                    if (($changed2 & 14) == 0) {
                                        $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                    }
                                    if (($changed2 & 112) == 0) {
                                        $dirty4 |= $composer4.changed(page) ? 32 : 16;
                                    }
                                    if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-70560628, $dirty4, -1, "com.google.accompanist.pager.Pager.<anonymous>.<anonymous>.<anonymous> (Pager.kt:468)");
                                        }
                                        Modifier modifier$iv = SizeKt.wrapContentSize$default(LazyItemScope.CC.fillParentMaxWidth$default(items, NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, consumeFlingNestedScrollConnection2, null, 2, null), 0.0f, 1, null), null, false, 3, null);
                                        Function4<PagerScope, Integer, Composer, Integer, Unit> function5 = function4;
                                        PagerScopeImpl pagerScopeImpl2 = pagerScopeImpl;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier$iv);
                                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            function0 = constructor;
                                            $composer4.createNode(function0);
                                        } else {
                                            function0 = constructor;
                                            $composer4.useNode();
                                        }
                                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer4);
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                        }
                                        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3786boximpl(SkippableUpdater.m3787constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i11 = ((0 >> 6) & 112) | 6;
                                        function5.invoke(pagerScopeImpl2, Integer.valueOf(page), $composer4, Integer.valueOf($dirty4 & 112));
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        $composer4.endReplaceableGroup();
                                        $composer4.endNode();
                                        $composer4.endReplaceableGroup();
                                        $composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer4.skipToGroupEnd();
                                }
                            }), 4, null);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                }
                $composer3.endReplaceableGroup();
                horizontalAlignment4 = horizontalAlignment3;
                $composer2 = $composer3;
                LazyDslKt.LazyRow(modifier, lazyListState1110, contentPadding, reverseLayout, horizontalM745spacedByD5KLDUw15, verticalAlignment3, flingBehavior, userScrollEnabled, (Function1) value$iv8, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 896) | ($dirty & 7168) | (($dirty1 << 15) & 458752) | ($dirty & 3670016) | (($dirty >> 6) & 29360128), 0);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            verticalAlignment4 = verticalAlignment3;
        }
        scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Alignment.Vertical vertical8 = verticalAlignment4;
            final Alignment.Horizontal horizontal8 = horizontalAlignment4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.Pager$Pager$9
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

                public final void invoke(Composer composer, int i9) {
                    Pager.m7170PagerupBTbn8(count, modifier, state, reverseLayout, itemSpacing, isVertical, flingBehavior, function1, contentPadding, userScrollEnabled, vertical8, horizontal8, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: consume-9KIMszo, reason: not valid java name */
    public static final long m7174consume9KIMszo(long $this$consume_u2d9KIMszo, boolean consumeHorizontal, boolean consumeVertical) {
        return OffsetKt.Offset(consumeHorizontal ? Offset.m4049getXimpl($this$consume_u2d9KIMszo) : 0.0f, consumeVertical ? Offset.m4050getYimpl($this$consume_u2d9KIMszo) : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: consume-BMRW4eQ, reason: not valid java name */
    public static final long m7175consumeBMRW4eQ(long $this$consume_u2dBMRW4eQ, boolean consumeHorizontal, boolean consumeVertical) {
        return VelocityKt.Velocity(consumeHorizontal ? Velocity.m7042getXimpl($this$consume_u2dBMRW4eQ) : 0.0f, consumeVertical ? Velocity.m7043getYimpl($this$consume_u2dBMRW4eQ) : 0.0f);
    }

    @Deprecated(message = "\naccompanist/pager is deprecated.\nThe androidx.compose equivalent of Pager is androidx.compose.foundation.pager.Pager.\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n")
    public static final float calculateCurrentOffsetForPage(PagerScope $this$calculateCurrentOffsetForPage, int page) {
        Intrinsics.checkNotNullParameter($this$calculateCurrentOffsetForPage, "<this>");
        return ($this$calculateCurrentOffsetForPage.getCurrentPage() - page) + $this$calculateCurrentOffsetForPage.getCurrentPageOffset();
    }
}
