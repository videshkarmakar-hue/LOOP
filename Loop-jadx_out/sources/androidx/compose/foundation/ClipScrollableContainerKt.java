package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Outline;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ClipScrollableContainer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m195d2 = {"HorizontalScrollableClipModifier", "Landroidx/compose/ui/Modifier;", "MaxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "getMaxSupportedElevation", "()F", "F", "VerticalScrollableClipModifier", "clipScrollableContainer", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ClipScrollableContainerKt {
    private static final float MaxSupportedElevation = C1979Dp.m6801constructorimpl(30);
    private static final Modifier HorizontalScrollableClipModifier = ClipKt.clip(Modifier.INSTANCE, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$HorizontalScrollableClipModifier$1
        @Override // androidx.compose.p001ui.graphics.Shape
        /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
        public Outline mo502createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
            float inflateSize = density.mo561roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
            return new Outline.Rectangle(new Rect(0.0f, -inflateSize, Size.m4118getWidthimpl(size), Size.m4115getHeightimpl(size) + inflateSize));
        }
    });
    private static final Modifier VerticalScrollableClipModifier = ClipKt.clip(Modifier.INSTANCE, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$VerticalScrollableClipModifier$1
        @Override // androidx.compose.p001ui.graphics.Shape
        /* JADX INFO: renamed from: createOutline-Pq9zytI */
        public Outline mo502createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
            float inflateSize = density.mo561roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
            return new Outline.Rectangle(new Rect(-inflateSize, 0.0f, Size.m4118getWidthimpl(size) + inflateSize, Size.m4115getHeightimpl(size)));
        }
    });

    public static final Modifier clipScrollableContainer(Modifier $this$clipScrollableContainer, Orientation orientation) {
        Modifier modifier;
        if (orientation == Orientation.Vertical) {
            modifier = VerticalScrollableClipModifier;
        } else {
            modifier = HorizontalScrollableClipModifier;
        }
        return $this$clipScrollableContainer.then(modifier);
    }

    public static final float getMaxSupportedElevation() {
        return MaxSupportedElevation;
    }
}
