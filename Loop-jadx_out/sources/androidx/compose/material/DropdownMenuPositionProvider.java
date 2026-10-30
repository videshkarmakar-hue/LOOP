package androidx.compose.material;

import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.DpOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntRect;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.p001ui.window.PopupPositionProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\fJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003JC\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m195d2 = {"Landroidx/compose/material/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "copy", "copy-rOJDEFc", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;)Landroidx/compose/material/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "", "toString", "", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final long contentOffset;
    private final Density density;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-rOJDEFc$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m1688copyrOJDEFc$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        if ((i & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        if ((i & 4) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m1690copyrOJDEFc(j, density, function2);
    }

    /* JADX INFO: renamed from: component1-RKDOV3M, reason: not valid java name and from getter */
    public final long getContentOffset() {
        return this.contentOffset;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> component3() {
        return this.onPositionCalculated;
    }

    /* JADX INFO: renamed from: copy-rOJDEFc, reason: not valid java name */
    public final DropdownMenuPositionProvider m1690copyrOJDEFc(long contentOffset, Density density, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        return new DropdownMenuPositionProvider(contentOffset, density, onPositionCalculated, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) other;
        return DpOffset.m6861equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((DpOffset.m6866hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m6869toStringimpl(this.contentOffset)) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long contentOffset, Density density, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = contentOffset;
        this.density = density;
        this.onPositionCalculated = function2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Function2 function3;
        if ((i & 4) == 0) {
            function3 = function2;
        } else {
            function3 = new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.DropdownMenuPositionProvider.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                    invoke2(intRect, intRect2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IntRect intRect, IntRect intRect2) {
                }
            };
        }
        this(j, density, function3, null);
    }

    /* JADX INFO: renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m1691getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0169 A[LOOP:1: B:36:0x0138->B:48:0x0169, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0166 A[SYNTHETIC] */
    @Override // androidx.compose.p001ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo1463calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        Object obj;
        Object element$iv;
        Sequence $this$firstOrNull$iv;
        boolean z;
        int it;
        Density $this$calculatePosition_llwVHH4_u24lambda_u240 = this.density;
        int verticalMargin = $this$calculatePosition_llwVHH4_u24lambda_u240.mo561roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        Density $this$calculatePosition_llwVHH4_u24lambda_u241 = this.density;
        int contentOffsetX = $this$calculatePosition_llwVHH4_u24lambda_u241.mo561roundToPx0680j_4(DpOffset.m6862getXD9Ej5fM(this.contentOffset)) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1);
        Density $this$calculatePosition_llwVHH4_u24lambda_u242 = this.density;
        int contentOffsetY = $this$calculatePosition_llwVHH4_u24lambda_u242.mo561roundToPx0680j_4(DpOffset.m6864getYD9Ej5fM(this.contentOffset));
        int leftToAnchorLeft = anchorBounds.getLeft() + contentOffsetX;
        int rightToAnchorRight = (anchorBounds.getRight() - IntSize.m6975getWidthimpl(popupContentSize)) + contentOffsetX;
        int rightToWindowRight = IntSize.m6975getWidthimpl(windowSize) - IntSize.m6975getWidthimpl(popupContentSize);
        Iterator it2 = (layoutDirection == LayoutDirection.Ltr ? SequencesKt.sequenceOf(Integer.valueOf(leftToAnchorLeft), Integer.valueOf(rightToAnchorRight), Integer.valueOf(anchorBounds.getLeft() >= 0 ? rightToWindowRight : 0)) : SequencesKt.sequenceOf(Integer.valueOf(rightToAnchorRight), Integer.valueOf(leftToAnchorLeft), Integer.valueOf(anchorBounds.getRight() <= IntSize.m6975getWidthimpl(windowSize) ? 0 : rightToWindowRight))).iterator();
        do {
            obj = null;
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = ((Number) element$iv).intValue();
        } while (!(it >= 0 && it + IntSize.m6975getWidthimpl(popupContentSize) <= IntSize.m6975getWidthimpl(windowSize)));
        Integer num = (Integer) element$iv;
        int x = num != null ? num.intValue() : rightToAnchorRight;
        int topToAnchorBottom = Math.max(anchorBounds.getBottom() + contentOffsetY, verticalMargin);
        int bottomToAnchorTop = (anchorBounds.getTop() - IntSize.m6974getHeightimpl(popupContentSize)) + contentOffsetY;
        int centerToAnchorTop = (anchorBounds.getTop() - (IntSize.m6974getHeightimpl(popupContentSize) / 2)) + contentOffsetY;
        int bottomToWindowBottom = (IntSize.m6974getHeightimpl(windowSize) - IntSize.m6974getHeightimpl(popupContentSize)) - verticalMargin;
        Sequence $this$firstOrNull$iv2 = SequencesKt.sequenceOf(Integer.valueOf(topToAnchorBottom), Integer.valueOf(bottomToAnchorTop), Integer.valueOf(centerToAnchorTop), Integer.valueOf(bottomToWindowBottom));
        for (Object element$iv2 : $this$firstOrNull$iv2) {
            int it3 = ((Number) element$iv2).intValue();
            if (it3 >= verticalMargin) {
                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                z = it3 + IntSize.m6974getHeightimpl(popupContentSize) <= IntSize.m6974getHeightimpl(windowSize) - verticalMargin;
                if (z) {
                    obj = element$iv2;
                    break;
                }
                $this$firstOrNull$iv2 = $this$firstOrNull$iv;
            } else {
                $this$firstOrNull$iv = $this$firstOrNull$iv2;
            }
            if (z) {
                obj = element$iv2;
                break;
            }
            $this$firstOrNull$iv2 = $this$firstOrNull$iv;
        }
        Integer num2 = (Integer) obj;
        int y = num2 != null ? num2.intValue() : bottomToAnchorTop;
        this.onPositionCalculated.invoke(anchorBounds, new IntRect(x, y, x + IntSize.m6975getWidthimpl(popupContentSize), y + IntSize.m6974getHeightimpl(popupContentSize)));
        return IntOffsetKt.IntOffset(x, y);
    }
}
