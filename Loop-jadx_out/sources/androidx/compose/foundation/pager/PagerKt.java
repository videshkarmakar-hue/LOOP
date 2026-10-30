package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Pager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aâ\u0001\u0010'\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e21\u0010\u001f\u001a-\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\b#¢\u0006\u0002\b$H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010,\u001a\u00020\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0082\b\u001aL\u00100\u001a\u00020\u000b*\u00020\u001e2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000bH\u0000\u001a!\u00109\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010;\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, m195d2 = {"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerKt {
    /* JADX INFO: renamed from: HorizontalPager-oI3XNZo, reason: not valid java name */
    public static final void m1101HorizontalPageroI3XNZo(final PagerState state, Modifier modifier, PaddingValues contentPadding, PageSize pageSize, int beyondViewportPageCount, float pageSpacing, Alignment.Vertical verticalAlignment, TargetedFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection pageNestedScrollConnection, SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PageSize pageSize2;
        float f;
        Alignment.Vertical verticalAlignment2;
        TargetedFlingBehavior targetedFlingBehavior;
        int $dirty;
        TargetedFlingBehavior flingBehavior2;
        NestedScrollConnection pageNestedScrollConnection2;
        int $dirty1;
        SnapPosition snapPosition2;
        TargetedFlingBehavior flingBehavior3;
        boolean userScrollEnabled2;
        boolean reverseLayout2;
        Function1<? super Integer, ? extends Object> function2;
        int $dirty2;
        Alignment.Vertical verticalAlignment3;
        Modifier modifier3;
        PageSize pageSize3;
        int beyondViewportPageCount2;
        float pageSpacing2;
        int $dirty3;
        NestedScrollConnection pageNestedScrollConnection3;
        PaddingValues contentPadding2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1870896258);
        ComposerKt.sourceInformation($composer3, "C(HorizontalPager)P(11,4,1,7!1,8:c#ui.unit.Dp,13!1,12,9!1,6,10)113@6489L28,117@6705L79,124@6907L661:Pager.kt#g6yjnt");
        int $dirty4 = $changed;
        int $dirty5 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer3.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
            pageSize2 = pageSize;
        } else if (($changed & 3072) == 0) {
            pageSize2 = pageSize;
            $dirty4 |= $composer3.changed(pageSize2) ? 2048 : 1024;
        } else {
            pageSize2 = pageSize;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty4 |= $composer3.changed(beyondViewportPageCount) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = pageSpacing;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            f = pageSpacing;
            $dirty4 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = pageSpacing;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 1572864;
            verticalAlignment2 = verticalAlignment;
        } else if (($changed & 1572864) == 0) {
            verticalAlignment2 = verticalAlignment;
            $dirty4 |= $composer3.changed(verticalAlignment2) ? 1048576 : 524288;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                targetedFlingBehavior = flingBehavior;
                int i8 = $composer3.changed(targetedFlingBehavior) ? 8388608 : 4194304;
                $dirty4 |= i8;
            } else {
                targetedFlingBehavior = flingBehavior;
            }
            $dirty4 |= i8;
        } else {
            targetedFlingBehavior = flingBehavior;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty4 |= $composer3.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty = $dirty4 | 805306368;
            i10 = i10;
        } else {
            if (($changed & 805306368) == 0) {
                $dirty4 |= $composer3.changed(reverseLayout) ? 536870912 : 268435456;
            }
            $dirty = $dirty4;
        }
        int $dirty6 = i & 1024;
        if ($dirty6 != 0) {
            $dirty5 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty5 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty5 |= ((i & 2048) == 0 && $composer3.changedInstance(pageNestedScrollConnection)) ? 32 : 16;
        }
        int $dirty7 = i & 4096;
        if ($dirty7 != 0) {
            $dirty5 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty5 |= $composer3.changed(snapPosition) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty5 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty5 |= $composer3.changedInstance(function4) ? 2048 : 1024;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty5 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            beyondViewportPageCount2 = beyondViewportPageCount;
            userScrollEnabled2 = userScrollEnabled;
            reverseLayout2 = reverseLayout;
            function2 = function1;
            snapPosition2 = snapPosition;
            pageSize3 = pageSize2;
            pageSpacing2 = f;
            modifier3 = modifier2;
            flingBehavior3 = targetedFlingBehavior;
            $composer2 = $composer3;
            verticalAlignment3 = verticalAlignment2;
            pageNestedScrollConnection3 = pageNestedScrollConnection;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                PaddingValues contentPadding3 = i3 != 0 ? PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0)) : contentPadding;
                PageSize pageSize4 = i4 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                int beyondViewportPageCount3 = i5 != 0 ? 0 : beyondViewportPageCount;
                float pageSpacing3 = i6 != 0 ? C1979Dp.m6801constructorimpl(0) : f;
                if (i7 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getCenterVertically();
                }
                if ((i & 128) != 0) {
                    flingBehavior2 = PagerDefaults.INSTANCE.flingBehavior(state, null, null, null, 0.0f, $composer3, ($dirty & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
                    $dirty &= -29360129;
                } else {
                    flingBehavior2 = targetedFlingBehavior;
                }
                boolean userScrollEnabled3 = i9 != 0 ? true : userScrollEnabled;
                boolean reverseLayout3 = i10 != 0 ? false : reverseLayout;
                Function1<? super Integer, ? extends Object> function3 = $dirty6 != 0 ? null : function1;
                if ((i & 2048) != 0) {
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(state, Orientation.Horizontal, $composer3, ($dirty & 14) | 432);
                    $dirty1 = $dirty5 & (-113);
                } else {
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty5;
                }
                if ($dirty7 != 0) {
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    function2 = function3;
                    $dirty2 = $dirty1;
                    snapPosition2 = SnapPosition.Start.INSTANCE;
                    verticalAlignment3 = verticalAlignment2;
                    modifier3 = modifier4;
                    pageSize3 = pageSize4;
                    beyondViewportPageCount2 = beyondViewportPageCount3;
                    pageSpacing2 = pageSpacing3;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection2;
                    contentPadding2 = contentPadding3;
                } else {
                    snapPosition2 = snapPosition;
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    function2 = function3;
                    $dirty2 = $dirty1;
                    verticalAlignment3 = verticalAlignment2;
                    modifier3 = modifier4;
                    pageSize3 = pageSize4;
                    beyondViewportPageCount2 = beyondViewportPageCount3;
                    pageSpacing2 = pageSpacing3;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection2;
                    contentPadding2 = contentPadding3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 2048) != 0) {
                    contentPadding2 = contentPadding;
                    beyondViewportPageCount2 = beyondViewportPageCount;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    function2 = function1;
                    snapPosition2 = snapPosition;
                    pageSize3 = pageSize2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    flingBehavior3 = targetedFlingBehavior;
                    verticalAlignment3 = verticalAlignment2;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection;
                    $dirty2 = $dirty5 & (-113);
                } else {
                    contentPadding2 = contentPadding;
                    beyondViewportPageCount2 = beyondViewportPageCount;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    function2 = function1;
                    snapPosition2 = snapPosition;
                    pageSize3 = pageSize2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    flingBehavior3 = targetedFlingBehavior;
                    verticalAlignment3 = verticalAlignment2;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection;
                    $dirty2 = $dirty5;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1870896258, $dirty3, $dirty2, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:123)");
            }
            $composer2 = $composer3;
            LazyLayoutPagerKt.m1097PageruYRUAWA(modifier3, state, contentPadding2, reverseLayout2, Orientation.Horizontal, flingBehavior3, userScrollEnabled2, beyondViewportPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection3, function2, Alignment.INSTANCE.getCenterHorizontally(), verticalAlignment3, snapPosition2, function4, $composer2, (($dirty3 >> 3) & 14) | CpioConstants.C_ISBLK | (($dirty3 << 3) & 112) | ($dirty3 & 896) | (($dirty3 >> 18) & 7168) | (($dirty3 >> 6) & 458752) | (($dirty3 >> 6) & 3670016) | (($dirty3 << 9) & 29360128) | (($dirty3 << 9) & 234881024) | (($dirty3 << 18) & 1879048192), (($dirty2 >> 3) & 14) | 384 | (($dirty2 << 3) & 112) | (($dirty3 >> 9) & 7168) | (($dirty2 << 6) & 57344) | (458752 & ($dirty2 << 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final PaddingValues paddingValues = contentPadding2;
            final PageSize pageSize5 = pageSize3;
            final int i11 = beyondViewportPageCount2;
            final float f2 = pageSpacing2;
            final Alignment.Vertical vertical = verticalAlignment3;
            final TargetedFlingBehavior targetedFlingBehavior2 = flingBehavior3;
            final boolean z = userScrollEnabled2;
            final boolean z2 = reverseLayout2;
            final Function1<? super Integer, ? extends Object> function5 = function2;
            final NestedScrollConnection nestedScrollConnection = pageNestedScrollConnection3;
            final SnapPosition snapPosition3 = snapPosition2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$1
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

                public final void invoke(Composer composer, int i12) {
                    PagerKt.m1101HorizontalPageroI3XNZo(state, modifier5, paddingValues, pageSize5, i11, f2, vertical, targetedFlingBehavior2, z, z2, function5, nestedScrollConnection, snapPosition3, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: VerticalPager-oI3XNZo, reason: not valid java name */
    public static final void m1102VerticalPageroI3XNZo(final PagerState state, Modifier modifier, PaddingValues contentPadding, PageSize pageSize, int beyondViewportPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, TargetedFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection pageNestedScrollConnection, SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PageSize pageSize2;
        float f;
        Alignment.Horizontal horizontalAlignment2;
        TargetedFlingBehavior targetedFlingBehavior;
        int $dirty;
        TargetedFlingBehavior flingBehavior2;
        NestedScrollConnection pageNestedScrollConnection2;
        int $dirty1;
        SnapPosition snapPosition2;
        TargetedFlingBehavior flingBehavior3;
        boolean userScrollEnabled2;
        boolean reverseLayout2;
        Function1<? super Integer, ? extends Object> function2;
        int $dirty2;
        Alignment.Horizontal horizontalAlignment3;
        Modifier modifier3;
        PageSize pageSize3;
        int beyondViewportPageCount2;
        float pageSpacing2;
        int $dirty3;
        NestedScrollConnection pageNestedScrollConnection3;
        PaddingValues contentPadding2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(909160706);
        ComposerKt.sourceInformation($composer3, "C(VerticalPager)P(12,5,1,8!1,9:c#ui.unit.Dp,3!1,13,10!1,7,11)200@11496L28,204@11712L77,211@11912L659:Pager.kt#g6yjnt");
        int $dirty4 = $changed;
        int $dirty5 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer3.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
            pageSize2 = pageSize;
        } else if (($changed & 3072) == 0) {
            pageSize2 = pageSize;
            $dirty4 |= $composer3.changed(pageSize2) ? 2048 : 1024;
        } else {
            pageSize2 = pageSize;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty4 |= $composer3.changed(beyondViewportPageCount) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            f = pageSpacing;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            f = pageSpacing;
            $dirty4 |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = pageSpacing;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 1572864;
            horizontalAlignment2 = horizontalAlignment;
        } else if (($changed & 1572864) == 0) {
            horizontalAlignment2 = horizontalAlignment;
            $dirty4 |= $composer3.changed(horizontalAlignment2) ? 1048576 : 524288;
        } else {
            horizontalAlignment2 = horizontalAlignment;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                targetedFlingBehavior = flingBehavior;
                int i8 = $composer3.changed(targetedFlingBehavior) ? 8388608 : 4194304;
                $dirty4 |= i8;
            } else {
                targetedFlingBehavior = flingBehavior;
            }
            $dirty4 |= i8;
        } else {
            targetedFlingBehavior = flingBehavior;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty4 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty4 |= $composer3.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty = $dirty4 | 805306368;
            i10 = i10;
        } else {
            if (($changed & 805306368) == 0) {
                $dirty4 |= $composer3.changed(reverseLayout) ? 536870912 : 268435456;
            }
            $dirty = $dirty4;
        }
        int $dirty6 = i & 1024;
        if ($dirty6 != 0) {
            $dirty5 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty5 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty5 |= ((i & 2048) == 0 && $composer3.changedInstance(pageNestedScrollConnection)) ? 32 : 16;
        }
        int $dirty7 = i & 4096;
        if ($dirty7 != 0) {
            $dirty5 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty5 |= $composer3.changed(snapPosition) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty5 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty5 |= $composer3.changedInstance(function4) ? 2048 : 1024;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty5 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            beyondViewportPageCount2 = beyondViewportPageCount;
            userScrollEnabled2 = userScrollEnabled;
            reverseLayout2 = reverseLayout;
            function2 = function1;
            snapPosition2 = snapPosition;
            pageSize3 = pageSize2;
            pageSpacing2 = f;
            modifier3 = modifier2;
            flingBehavior3 = targetedFlingBehavior;
            $composer2 = $composer3;
            horizontalAlignment3 = horizontalAlignment2;
            pageNestedScrollConnection3 = pageNestedScrollConnection;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                PaddingValues contentPadding3 = i3 != 0 ? PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0)) : contentPadding;
                PageSize pageSize4 = i4 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                int beyondViewportPageCount3 = i5 != 0 ? 0 : beyondViewportPageCount;
                float pageSpacing3 = i6 != 0 ? C1979Dp.m6801constructorimpl(0) : f;
                if (i7 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getCenterHorizontally();
                }
                if ((i & 128) != 0) {
                    flingBehavior2 = PagerDefaults.INSTANCE.flingBehavior(state, null, null, null, 0.0f, $composer3, ($dirty & 14) | ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
                    $dirty &= -29360129;
                } else {
                    flingBehavior2 = targetedFlingBehavior;
                }
                boolean userScrollEnabled3 = i9 != 0 ? true : userScrollEnabled;
                boolean reverseLayout3 = i10 != 0 ? false : reverseLayout;
                Function1<? super Integer, ? extends Object> function3 = $dirty6 != 0 ? null : function1;
                if ((i & 2048) != 0) {
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(state, Orientation.Vertical, $composer3, ($dirty & 14) | 432);
                    $dirty1 = $dirty5 & (-113);
                } else {
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty5;
                }
                if ($dirty7 != 0) {
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    function2 = function3;
                    $dirty2 = $dirty1;
                    snapPosition2 = SnapPosition.Start.INSTANCE;
                    horizontalAlignment3 = horizontalAlignment2;
                    modifier3 = modifier4;
                    pageSize3 = pageSize4;
                    beyondViewportPageCount2 = beyondViewportPageCount3;
                    pageSpacing2 = pageSpacing3;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection2;
                    contentPadding2 = contentPadding3;
                } else {
                    snapPosition2 = snapPosition;
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    reverseLayout2 = reverseLayout3;
                    function2 = function3;
                    $dirty2 = $dirty1;
                    horizontalAlignment3 = horizontalAlignment2;
                    modifier3 = modifier4;
                    pageSize3 = pageSize4;
                    beyondViewportPageCount2 = beyondViewportPageCount3;
                    pageSpacing2 = pageSpacing3;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection2;
                    contentPadding2 = contentPadding3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 2048) != 0) {
                    contentPadding2 = contentPadding;
                    beyondViewportPageCount2 = beyondViewportPageCount;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    function2 = function1;
                    snapPosition2 = snapPosition;
                    pageSize3 = pageSize2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    flingBehavior3 = targetedFlingBehavior;
                    horizontalAlignment3 = horizontalAlignment2;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection;
                    $dirty2 = $dirty5 & (-113);
                } else {
                    contentPadding2 = contentPadding;
                    beyondViewportPageCount2 = beyondViewportPageCount;
                    userScrollEnabled2 = userScrollEnabled;
                    reverseLayout2 = reverseLayout;
                    function2 = function1;
                    snapPosition2 = snapPosition;
                    pageSize3 = pageSize2;
                    pageSpacing2 = f;
                    modifier3 = modifier2;
                    flingBehavior3 = targetedFlingBehavior;
                    horizontalAlignment3 = horizontalAlignment2;
                    $dirty3 = $dirty;
                    pageNestedScrollConnection3 = pageNestedScrollConnection;
                    $dirty2 = $dirty5;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(909160706, $dirty3, $dirty2, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:210)");
            }
            $composer2 = $composer3;
            LazyLayoutPagerKt.m1097PageruYRUAWA(modifier3, state, contentPadding2, reverseLayout2, Orientation.Vertical, flingBehavior3, userScrollEnabled2, beyondViewportPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection3, function2, horizontalAlignment3, Alignment.INSTANCE.getCenterVertically(), snapPosition2, function4, $composer2, (($dirty3 >> 3) & 14) | CpioConstants.C_ISBLK | (($dirty3 << 3) & 112) | ($dirty3 & 896) | (($dirty3 >> 18) & 7168) | (($dirty3 >> 6) & 458752) | (($dirty3 >> 6) & 3670016) | (($dirty3 << 9) & 29360128) | (($dirty3 << 9) & 234881024) | (($dirty3 << 18) & 1879048192), (($dirty2 >> 3) & 14) | 3072 | (($dirty2 << 3) & 112) | (($dirty3 >> 12) & 896) | (($dirty2 << 6) & 57344) | (458752 & ($dirty2 << 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final PaddingValues paddingValues = contentPadding2;
            final PageSize pageSize5 = pageSize3;
            final int i11 = beyondViewportPageCount2;
            final float f2 = pageSpacing2;
            final Alignment.Horizontal horizontal = horizontalAlignment3;
            final TargetedFlingBehavior targetedFlingBehavior2 = flingBehavior3;
            final boolean z = userScrollEnabled2;
            final boolean z2 = reverseLayout2;
            final Function1<? super Integer, ? extends Object> function5 = function2;
            final NestedScrollConnection nestedScrollConnection = pageNestedScrollConnection3;
            final SnapPosition snapPosition3 = snapPosition2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$1
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

                public final void invoke(Composer composer, int i12) {
                    PagerKt.m1102VerticalPageroI3XNZo(state, modifier5, paddingValues, pageSize5, i11, f2, horizontal, targetedFlingBehavior2, z, z2, function5, nestedScrollConnection, snapPosition3, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final int currentPageOffset(SnapPosition $this$currentPageOffset, int layoutSize, int pageSize, int spaceBetweenPages, int beforeContentPadding, int afterContentPadding, int currentPage, float currentPageOffsetFraction, int pageCount) {
        int snapOffset = $this$currentPageOffset.position(layoutSize, pageSize, beforeContentPadding, afterContentPadding, currentPage, pageCount);
        return MathKt.roundToInt(snapOffset - ((pageSize + spaceBetweenPages) * currentPageOffsetFraction));
    }

    public static final Modifier pagerSemantics(Modifier $this$pagerSemantics, final PagerState state, final boolean isVertical, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1509835088, "C(pagerSemantics)P(1)453@22639L24,476@23188L253:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, $changed, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:452)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, -723523240, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 628226821, "CC(remember):Pager.kt#9igjgp");
        boolean invalid$iv = (((($changed & 896) ^ 384) > 256 && $composer.changed(isVertical)) || ($changed & 384) == 256) | (((($changed & 112) ^ 48) > 32 && $composer.changed(state)) || ($changed & 48) == 32) | $composer.changedInstance(scope);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1$1
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
                    if (isVertical) {
                        final PagerState pagerState = state;
                        final CoroutineScope coroutineScope = scope;
                        SemanticsPropertiesKt.pageUp$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState, coroutineScope));
                            }
                        }, 1, null);
                        final PagerState pagerState2 = state;
                        final CoroutineScope coroutineScope2 = scope;
                        SemanticsPropertiesKt.pageDown$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState2, coroutineScope2));
                            }
                        }, 1, null);
                        return;
                    }
                    final PagerState pagerState3 = state;
                    final CoroutineScope coroutineScope3 = scope;
                    SemanticsPropertiesKt.pageLeft$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState3, coroutineScope3));
                        }
                    }, 1, null);
                    final PagerState pagerState4 = state;
                    final CoroutineScope coroutineScope4 = scope;
                    SemanticsPropertiesKt.pageRight$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState4, coroutineScope4));
                        }
                    }, 1, null);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifierThen = $this$pagerSemantics.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv, 1, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState $state, CoroutineScope scope) {
        if ($state.getCanScrollForward()) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1($state, null), 3, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState $state, CoroutineScope scope) {
        if ($state.getCanScrollBackward()) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1($state, null), 3, null);
            return true;
        }
        return false;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
