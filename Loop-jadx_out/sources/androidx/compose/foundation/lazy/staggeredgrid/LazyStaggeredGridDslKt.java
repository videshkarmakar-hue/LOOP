package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0083\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010$\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00104\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052%\b\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\b\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\b\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00106\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0'2:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010;\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\b\u0000\u0010&*\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H&052:\b\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\b\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\b\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\b\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b3¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010<\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, m195d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "verticalItemSpacing", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "items", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyStaggeredGridDslKt {
    /* JADX INFO: renamed from: LazyVerticalStaggeredGrid-zadm560, reason: not valid java name */
    public static final void m1062LazyVerticalStaggeredGridzadm560(final StaggeredGridCells columns, Modifier modifier, LazyStaggeredGridState state, PaddingValues contentPadding, boolean reverseLayout, float verticalItemSpacing, Arrangement.Horizontal horizontalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        float verticalItemSpacing2;
        LazyStaggeredGridState state2;
        Arrangement.HorizontalOrVertical horizontalArrangement2;
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        int $dirty;
        boolean userScrollEnabled2;
        Modifier modifier3;
        boolean userScrollEnabled3;
        Arrangement.Horizontal horizontalArrangement3;
        LazyStaggeredGridState state3;
        FlingBehavior flingBehavior3;
        PaddingValues contentPadding3;
        boolean reverseLayout3;
        float verticalItemSpacing3;
        Composer $composer2 = $composer.startRestartGroup(1695323794);
        ComposerKt.sourceInformation($composer2, "C(LazyVerticalStaggeredGrid)P(!1,5,7,2,6,9:c#ui.unit.Dp,4,3,8)64@3068L32,69@3365L15,83@3878L67,73@3476L502:LazyStaggeredGridDsl.kt#fzvcnm");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(columns) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ((i & 4) == 0 && $composer2.changedInstance(state)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            contentPadding2 = contentPadding;
        } else if (($changed & 3072) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 2048 : 1024;
        } else {
            contentPadding2 = contentPadding;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            reverseLayout2 = reverseLayout;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 16384 : 8192;
        } else {
            reverseLayout2 = reverseLayout;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            verticalItemSpacing2 = verticalItemSpacing;
        } else if ((196608 & $changed) == 0) {
            verticalItemSpacing2 = verticalItemSpacing;
            $dirty2 |= $composer2.changed(verticalItemSpacing2) ? 131072 : 65536;
        } else {
            verticalItemSpacing2 = verticalItemSpacing;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(horizontalArrangement) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(flingBehavior)) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            state3 = state;
            horizontalArrangement3 = horizontalArrangement;
            flingBehavior3 = flingBehavior;
            userScrollEnabled3 = userScrollEnabled;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            verticalItemSpacing3 = verticalItemSpacing2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    state2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, $composer2, 0, 3);
                    $dirty2 &= -897;
                } else {
                    state2 = state;
                }
                if (i3 != 0) {
                    contentPadding2 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                }
                if (i4 != 0) {
                    reverseLayout2 = false;
                }
                if (i5 != 0) {
                    verticalItemSpacing2 = C1979Dp.m6801constructorimpl(0);
                }
                horizontalArrangement2 = i6 != 0 ? Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(0)) : horizontalArrangement;
                if ((i & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                    $dirty2 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    userScrollEnabled2 = true;
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    userScrollEnabled2 = userScrollEnabled;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 128) != 0) {
                    int i8 = $dirty2 & (-29360129);
                    state2 = state;
                    horizontalArrangement2 = horizontalArrangement;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    $dirty = i8;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    state2 = state;
                    horizontalArrangement2 = horizontalArrangement;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2;
                    userScrollEnabled2 = userScrollEnabled;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1695323794, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:72)");
            }
            LazyStaggeredGridKt.m1067LazyStaggeredGridLJWHXA8(state2, Orientation.Vertical, rememberColumnSlots(columns, horizontalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 15) & 112) | (($dirty >> 3) & 896)), modifier2, contentPadding2, reverseLayout2, flingBehavior2, userScrollEnabled2, verticalItemSpacing2, horizontalArrangement2.getSpacing(), function1, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 6) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty << 9) & 234881024), ($dirty >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            userScrollEnabled3 = userScrollEnabled2;
            horizontalArrangement3 = horizontalArrangement2;
            state3 = state2;
            flingBehavior3 = flingBehavior2;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            verticalItemSpacing3 = verticalItemSpacing2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final LazyStaggeredGridState lazyStaggeredGridState = state3;
            final PaddingValues paddingValues = contentPadding3;
            final boolean z = reverseLayout3;
            final float f = verticalItemSpacing3;
            final Arrangement.Horizontal horizontal = horizontalArrangement3;
            final FlingBehavior flingBehavior4 = flingBehavior3;
            final boolean z2 = userScrollEnabled3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1
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
                    LazyStaggeredGridDslKt.m1062LazyVerticalStaggeredGridzadm560(columns, modifier5, lazyStaggeredGridState, paddingValues, z, f, horizontal, flingBehavior4, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(final StaggeredGridCells columns, final Arrangement.Horizontal horizontalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1267076841, "C(rememberColumnSlots)P(!1,2)94@4216L1114:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1267076841, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:94)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -400688478, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(columns)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(horizontalArrangement)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(contentPadding)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new LazyStaggeredGridSlotCache(new Function2<Density, Constraints, LazyStaggeredGridSlots>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberColumnSlots$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridSlots invoke(Density density, Constraints constraints) {
                    return m1063invoke0kLqBqw(density, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridSlots m1063invoke0kLqBqw(Density $this$$receiver, long constraints) {
                    if (!(Constraints.m6744getMaxWidthimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingKt.calculateStartPadding(contentPadding, LayoutDirection.Ltr);
                    float other$iv = PaddingKt.calculateEndPadding(contentPadding, LayoutDirection.Ltr);
                    int gridWidth = Constraints.m6744getMaxWidthimpl(constraints) - $this$$receiver.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(arg0$iv + other$iv));
                    StaggeredGridCells $this$invoke_0kLqBqw_u24lambda_u243 = columns;
                    Arrangement.Horizontal $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = horizontalArrangement;
                    int[] sizes = $this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes($this$$receiver, gridWidth, $this$$receiver.mo561roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.getSpacing()));
                    int[] positions = new int[sizes.length];
                    $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($this$$receiver, gridWidth, sizes, LayoutDirection.Ltr, positions);
                    return new LazyStaggeredGridSlots(positions, sizes);
                }
            });
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX INFO: renamed from: LazyHorizontalStaggeredGrid-cJHQLPU, reason: not valid java name */
    public static final void m1061LazyHorizontalStaggeredGridcJHQLPU(final StaggeredGridCells rows, Modifier modifier, LazyStaggeredGridState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, float horizontalItemSpacing, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Vertical verticalArrangement2;
        LazyStaggeredGridState state2;
        float horizontalItemSpacing2;
        FlingBehavior flingBehavior2;
        Modifier modifier2;
        int $dirty;
        boolean userScrollEnabled2;
        Modifier modifier3;
        boolean userScrollEnabled3;
        float horizontalItemSpacing3;
        LazyStaggeredGridState state3;
        FlingBehavior flingBehavior3;
        PaddingValues contentPadding3;
        boolean reverseLayout3;
        Arrangement.Vertical verticalArrangement3;
        Composer $composer2 = $composer.startRestartGroup(-8666074);
        ComposerKt.sourceInformation($composer2, "C(LazyHorizontalStaggeredGrid)P(6,4,7,1,5,9,3:c#ui.unit.Dp,2,8)154@6993L32,159@7288L15,173@7803L59,163@7399L496:LazyStaggeredGridDsl.kt#fzvcnm");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(rows) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= ((i & 4) == 0 && $composer2.changedInstance(state)) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            contentPadding2 = contentPadding;
        } else if (($changed & 3072) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 2048 : 1024;
        } else {
            contentPadding2 = contentPadding;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            reverseLayout2 = reverseLayout;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer2.changed(reverseLayout2) ? 16384 : 8192;
        } else {
            reverseLayout2 = reverseLayout;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            verticalArrangement2 = verticalArrangement;
        } else if ((196608 & $changed) == 0) {
            verticalArrangement2 = verticalArrangement;
            $dirty2 |= $composer2.changed(verticalArrangement2) ? 131072 : 65536;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(horizontalItemSpacing) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 128) == 0 && $composer2.changed(flingBehavior)) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            state3 = state;
            horizontalItemSpacing3 = horizontalItemSpacing;
            flingBehavior3 = flingBehavior;
            userScrollEnabled3 = userScrollEnabled;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            verticalArrangement3 = verticalArrangement2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    state2 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, $composer2, 0, 3);
                    $dirty2 &= -897;
                } else {
                    state2 = state;
                }
                if (i3 != 0) {
                    contentPadding2 = PaddingKt.m861PaddingValues0680j_4(C1979Dp.m6801constructorimpl(0));
                }
                if (i4 != 0) {
                    reverseLayout2 = false;
                }
                if (i5 != 0) {
                    verticalArrangement2 = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(0));
                }
                horizontalItemSpacing2 = i6 != 0 ? C1979Dp.m6801constructorimpl(0) : horizontalItemSpacing;
                if ((i & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
                    $dirty2 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    userScrollEnabled2 = true;
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    userScrollEnabled2 = userScrollEnabled;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 128) != 0) {
                    int i8 = $dirty2 & (-29360129);
                    state2 = state;
                    horizontalItemSpacing2 = horizontalItemSpacing;
                    flingBehavior2 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    $dirty = i8;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    state2 = state;
                    horizontalItemSpacing2 = horizontalItemSpacing;
                    flingBehavior2 = flingBehavior;
                    $dirty = $dirty2;
                    userScrollEnabled2 = userScrollEnabled;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-8666074, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:162)");
            }
            LazyStaggeredGridKt.m1067LazyStaggeredGridLJWHXA8(state2, Orientation.Horizontal, rememberRowSlots(rows, verticalArrangement2, contentPadding2, $composer2, ($dirty & 14) | (($dirty >> 12) & 112) | (($dirty >> 3) & 896)), modifier2, contentPadding2, reverseLayout2, flingBehavior2, userScrollEnabled2, horizontalItemSpacing2, verticalArrangement2.getSpacing(), function1, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 6) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty >> 3) & 3670016) | (($dirty >> 3) & 29360128) | (($dirty << 6) & 234881024), ($dirty >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            userScrollEnabled3 = userScrollEnabled2;
            horizontalItemSpacing3 = horizontalItemSpacing2;
            state3 = state2;
            flingBehavior3 = flingBehavior2;
            contentPadding3 = contentPadding2;
            reverseLayout3 = reverseLayout2;
            verticalArrangement3 = verticalArrangement2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final LazyStaggeredGridState lazyStaggeredGridState = state3;
            final PaddingValues paddingValues = contentPadding3;
            final boolean z = reverseLayout3;
            final Arrangement.Vertical vertical = verticalArrangement3;
            final float f = horizontalItemSpacing3;
            final FlingBehavior flingBehavior4 = flingBehavior3;
            final boolean z2 = userScrollEnabled3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1
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
                    LazyStaggeredGridDslKt.m1061LazyHorizontalStaggeredGridcJHQLPU(rows, modifier5, lazyStaggeredGridState, paddingValues, z, vertical, f, flingBehavior4, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(final StaggeredGridCells rows, final Arrangement.Vertical verticalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1532383053, "C(rememberRowSlots)P(1,2)184@8120L940:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1532383053, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:184)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 586806388, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(rows)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(verticalArrangement)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(contentPadding)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new LazyStaggeredGridSlotCache(new Function2<Density, Constraints, LazyStaggeredGridSlots>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberRowSlots$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridSlots invoke(Density density, Constraints constraints) {
                    return m1064invoke0kLqBqw(density, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridSlots m1064invoke0kLqBqw(Density $this$$receiver, long constraints) {
                    if (!(Constraints.m6743getMaxHeightimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.".toString());
                    }
                    float arg0$iv = contentPadding.getTop();
                    float other$iv = contentPadding.getBottom();
                    int gridHeight = Constraints.m6743getMaxHeightimpl(constraints) - $this$$receiver.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(arg0$iv + other$iv));
                    StaggeredGridCells $this$invoke_0kLqBqw_u24lambda_u243 = rows;
                    Arrangement.Vertical $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = verticalArrangement;
                    int[] sizes = $this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes($this$$receiver, gridHeight, $this$$receiver.mo561roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.getSpacing()));
                    int[] positions = new int[sizes.length];
                    $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($this$$receiver, gridHeight, sizes, positions);
                    return new LazyStaggeredGridSlots(positions, sizes);
                }
            });
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        $this$items_u24default.items(items.size(), key != null ? new LazyStaggeredGridDslKt$items$2$1(key, items) : null, new C06403(contentType, items), span != null ? new LazyStaggeredGridDslKt$items$4$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new C06415(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$3 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "index", "", "invoke"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C06403 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06403(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$contentType = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke((T) this.$items.get(i));
        }
    }

    public static final <T> void items(LazyStaggeredGridScope $this$items, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function2, Function1<? super T, StaggeredGridItemSpan> function3, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Function1 it;
        LazyStaggeredGridDslKt$items$4$1 lazyStaggeredGridDslKt$items$4$1;
        int size = list.size();
        if (function1 == null) {
            it = null;
        } else {
            it = new LazyStaggeredGridDslKt$items$2$1(function1, list);
        }
        C06403 c06403 = new C06403(function2, list);
        if (function3 == null) {
            lazyStaggeredGridDslKt$items$4$1 = null;
        } else {
            lazyStaggeredGridDslKt$items$4$1 = new LazyStaggeredGridDslKt$items$4$1(function3, list);
        }
        $this$items.items(size, it, c06403, lazyStaggeredGridDslKt$items$4$1, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new C06415(function4, list)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$5 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "index", "", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C06415 extends Lambda implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyStaggeredGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06415(Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            super(4);
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            ComposerKt.sourceInformation(composer, "C342@15096L25:LazyStaggeredGridDsl.kt#fzvcnm");
            int i3 = i2;
            if ((i2 & 6) == 0) {
                i3 |= composer.changed(lazyStaggeredGridItemScope) ? 4 : 2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-886456479, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:342)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, (T) this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        $this$itemsIndexed_u24default.items(items.size(), key != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(key, items) : null, new C06463(contentType, items), span != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(284833944, true, new C06475(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$3 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "index", "", "invoke"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C06463 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06463(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$contentType = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function3, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function4, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        LazyStaggeredGridDslKt$itemsIndexed$2$1 lazyStaggeredGridDslKt$itemsIndexed$2$1;
        LazyStaggeredGridDslKt$itemsIndexed$4$1 lazyStaggeredGridDslKt$itemsIndexed$4$1;
        int size = list.size();
        if (function2 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$2$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$2$1 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list);
        }
        C06463 c06463 = new C06463(function3, list);
        if (function4 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$4$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$4$1 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(function4, list);
        }
        $this$itemsIndexed.items(size, lazyStaggeredGridDslKt$itemsIndexed$2$1, c06463, lazyStaggeredGridDslKt$itemsIndexed$4$1, ComposableLambdaKt.composableLambdaInstance(284833944, true, new C06475(function5, list)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$5 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "index", "", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C06475 extends Lambda implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyStaggeredGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06475(Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            super(4);
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            ComposerKt.sourceInformation(composer, "C381@16971L32:LazyStaggeredGridDsl.kt#fzvcnm");
            int i3 = i2;
            if ((i2 & 6) == 0) {
                i3 |= composer.changed(lazyStaggeredGridItemScope) ? 4 : 2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(284833944, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:381)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf((i3 & 14) | (i3 & 112)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        $this$items_u24default.items(items.length, key != null ? new LazyStaggeredGridDslKt$items$7$1(key, items) : null, new C06438(contentType, items), span != null ? new LazyStaggeredGridDslKt$items$9$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new C063910(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$8 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "index", "", "invoke"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C06438 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06438(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$contentType = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int index) {
            return this.$contentType.invoke(this.$items[index]);
        }
    }

    public static final <T> void items(LazyStaggeredGridScope $this$items, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function2, Function1<? super T, StaggeredGridItemSpan> function3, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Function1 it;
        LazyStaggeredGridDslKt$items$9$1 lazyStaggeredGridDslKt$items$9$1;
        int length = tArr.length;
        if (function1 == null) {
            it = null;
        } else {
            it = new LazyStaggeredGridDslKt$items$7$1(function1, tArr);
        }
        C06438 c06438 = new C06438(function2, tArr);
        if (function3 == null) {
            lazyStaggeredGridDslKt$items$9$1 = null;
        } else {
            lazyStaggeredGridDslKt$items$9$1 = new LazyStaggeredGridDslKt$items$9$1(function3, tArr);
        }
        $this$items.items(length, it, c06438, lazyStaggeredGridDslKt$items$9$1, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new C063910(function4, tArr)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$10 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "index", "", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C063910 extends Lambda implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyStaggeredGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C063910(Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            super(4);
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyStaggeredGridItemScope $this$items, int index, Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C420@18748L25:LazyStaggeredGridDsl.kt#fzvcnm");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed($this$items) ? 4 : 2;
            }
            if (($changed & 48) == 0) {
                $dirty |= $composer.changed(index) ? 32 : 16;
            }
            if (($dirty & 147) == 146 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2101296000, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:420)");
            }
            this.$itemContent.invoke($this$items, this.$items[index], $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        $this$itemsIndexed_u24default.items(items.length, key != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(key, items) : null, new C06498(contentType, items), span != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new C064510(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$8 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "index", "", "invoke"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C06498 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C06498(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$contentType = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int index) {
            return this.$contentType.invoke(Integer.valueOf(index), this.$items[index]);
        }
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function3, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function4, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        LazyStaggeredGridDslKt$itemsIndexed$7$1 lazyStaggeredGridDslKt$itemsIndexed$7$1;
        LazyStaggeredGridDslKt$itemsIndexed$9$1 lazyStaggeredGridDslKt$itemsIndexed$9$1;
        int length = tArr.length;
        if (function2 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$7$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$7$1 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, tArr);
        }
        C06498 c06498 = new C06498(function3, tArr);
        if (function4 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$9$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$9$1 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(function4, tArr);
        }
        $this$itemsIndexed.items(length, lazyStaggeredGridDslKt$itemsIndexed$7$1, c06498, lazyStaggeredGridDslKt$itemsIndexed$9$1, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new C064510(function5, tArr)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$10 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "index", "", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = 176)
    public static final class C064510 extends Lambda implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyStaggeredGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C064510(Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            super(4);
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyStaggeredGridItemScope $this$items, int index, Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C459@20627L32:LazyStaggeredGridDsl.kt#fzvcnm");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed($this$items) ? 4 : 2;
            }
            if (($changed & 48) == 0) {
                $dirty |= $composer.changed(index) ? 32 : 16;
            }
            if (($dirty & 147) == 146 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-804487775, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:459)");
            }
            this.$itemContent.invoke($this$items, Integer.valueOf(index), this.$items[index], $composer, Integer.valueOf(($dirty & 14) | ($dirty & 112)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
