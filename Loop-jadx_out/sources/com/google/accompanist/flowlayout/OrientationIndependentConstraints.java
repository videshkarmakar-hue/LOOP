package com.google.accompanist.flowlayout;

import androidx.compose.p001ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Layout.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\bHÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, m195d2 = {"Lcom/google/accompanist/flowlayout/OrientationIndependentConstraints;", "", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Lcom/google/accompanist/flowlayout/LayoutOrientation;", "(JLcom/google/accompanist/flowlayout/LayoutOrientation;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "(IIII)V", "getCrossAxisMax", "()I", "getCrossAxisMin", "getMainAxisMax", "getMainAxisMin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "flowlayout_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class OrientationIndependentConstraints {
    public static final int $stable = 0;
    private final int crossAxisMax;
    private final int crossAxisMin;
    private final int mainAxisMax;
    private final int mainAxisMin;

    public /* synthetic */ OrientationIndependentConstraints(long j, LayoutOrientation layoutOrientation, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, layoutOrientation);
    }

    public static /* synthetic */ OrientationIndependentConstraints copy$default(OrientationIndependentConstraints orientationIndependentConstraints, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = orientationIndependentConstraints.mainAxisMin;
        }
        if ((i5 & 2) != 0) {
            i2 = orientationIndependentConstraints.mainAxisMax;
        }
        if ((i5 & 4) != 0) {
            i3 = orientationIndependentConstraints.crossAxisMin;
        }
        if ((i5 & 8) != 0) {
            i4 = orientationIndependentConstraints.crossAxisMax;
        }
        return orientationIndependentConstraints.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMainAxisMin() {
        return this.mainAxisMin;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMainAxisMax() {
        return this.mainAxisMax;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCrossAxisMin() {
        return this.crossAxisMin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCrossAxisMax() {
        return this.crossAxisMax;
    }

    public final OrientationIndependentConstraints copy(int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        return new OrientationIndependentConstraints(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrientationIndependentConstraints)) {
            return false;
        }
        OrientationIndependentConstraints orientationIndependentConstraints = (OrientationIndependentConstraints) other;
        return this.mainAxisMin == orientationIndependentConstraints.mainAxisMin && this.mainAxisMax == orientationIndependentConstraints.mainAxisMax && this.crossAxisMin == orientationIndependentConstraints.crossAxisMin && this.crossAxisMax == orientationIndependentConstraints.crossAxisMax;
    }

    public int hashCode() {
        return (((((this.mainAxisMin * 31) + this.mainAxisMax) * 31) + this.crossAxisMin) * 31) + this.crossAxisMax;
    }

    public String toString() {
        return "OrientationIndependentConstraints(mainAxisMin=" + this.mainAxisMin + ", mainAxisMax=" + this.mainAxisMax + ", crossAxisMin=" + this.crossAxisMin + ", crossAxisMax=" + this.crossAxisMax + ')';
    }

    public OrientationIndependentConstraints(int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        this.mainAxisMin = mainAxisMin;
        this.mainAxisMax = mainAxisMax;
        this.crossAxisMin = crossAxisMin;
        this.crossAxisMax = crossAxisMax;
    }

    public final int getMainAxisMin() {
        return this.mainAxisMin;
    }

    public final int getMainAxisMax() {
        return this.mainAxisMax;
    }

    public final int getCrossAxisMin() {
        return this.crossAxisMin;
    }

    public final int getCrossAxisMax() {
        return this.crossAxisMax;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private OrientationIndependentConstraints(long c, LayoutOrientation orientation) {
        this(orientation == LayoutOrientation.Horizontal ? Constraints.m6746getMinWidthimpl(c) : Constraints.m6745getMinHeightimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m6744getMaxWidthimpl(c) : Constraints.m6743getMaxHeightimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m6745getMinHeightimpl(c) : Constraints.m6746getMinWidthimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m6743getMaxHeightimpl(c) : Constraints.m6744getMaxWidthimpl(c));
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }
}
