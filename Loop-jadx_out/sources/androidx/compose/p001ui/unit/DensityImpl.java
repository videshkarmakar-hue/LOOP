package androidx.compose.p001ui.unit;

import androidx.compose.p001ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m195d2 = {"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final /* data */ class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public static /* synthetic */ DensityImpl copy$default(DensityImpl densityImpl, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = densityImpl.density;
        }
        if ((i & 2) != 0) {
            f2 = densityImpl.fontScale;
        }
        return densityImpl.copy(f, f2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getFontScale() {
        return this.fontScale;
    }

    public final DensityImpl copy(float density, float fontScale) {
        return new DensityImpl(density, fontScale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DensityImpl)) {
            return false;
        }
        DensityImpl densityImpl = (DensityImpl) other;
        return Float.compare(this.density, densityImpl.density) == 0 && Float.compare(this.fontScale, densityImpl.fontScale) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.density) * 31) + Float.floatToIntBits(this.fontScale);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo560roundToPxR2X_6o(long j) {
        return Density.CC.m6765$default$roundToPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo561roundToPx0680j_4(float f) {
        return Density.CC.m6766$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo562toDpGaN1DYA(long j) {
        return FontScaling.CC.m6910$default$toDpGaN1DYA(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo563toDpu2uoSUM(float f) {
        return Density.CC.m6767$default$toDpu2uoSUM(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo564toDpu2uoSUM(int i) {
        return Density.CC.m6768$default$toDpu2uoSUM((Density) this, i);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo565toDpSizekrfVVM(long j) {
        return Density.CC.m6769$default$toDpSizekrfVVM(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo566toPxR2X_6o(long j) {
        return Density.CC.m6770$default$toPxR2X_6o(this, j);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo567toPx0680j_4(float f) {
        return Density.CC.m6771$default$toPx0680j_4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo568toSizeXkaWNTQ(long j) {
        return Density.CC.m6772$default$toSizeXkaWNTQ(this, j);
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo569toSp0xMU5do(float f) {
        return FontScaling.CC.m6911$default$toSp0xMU5do(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo570toSpkPz2Gy4(float f) {
        return Density.CC.m6773$default$toSpkPz2Gy4(this, f);
    }

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo571toSpkPz2Gy4(int i) {
        return Density.CC.m6774$default$toSpkPz2Gy4((Density) this, i);
    }

    public String toString() {
        return "DensityImpl(density=" + this.density + ", fontScale=" + this.fontScale + ')';
    }

    public DensityImpl(float density, float fontScale) {
        this.density = density;
        this.fontScale = fontScale;
    }

    @Override // androidx.compose.p001ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.p001ui.unit.FontScaling
    public float getFontScale() {
        return this.fontScale;
    }
}
