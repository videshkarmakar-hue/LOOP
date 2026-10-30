package androidx.compose.foundation.lazy.layout;

import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.DpKt;
import androidx.compose.p001ui.unit.DpSize;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.p001ui.unit.TextUnitType;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: LazyLayoutMeasureScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0016\u0010\u001b\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0001\u0001 ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "measure", "", "Landroidx/compose/ui/layout/Placeable;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface LazyLayoutMeasureScope extends MeasureScope {
    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    List<Placeable> mo1031measure0kLqBqw(int index, long constraints);

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo562toDpGaN1DYA(long j);

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo563toDpu2uoSUM(float f);

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo564toDpu2uoSUM(int i);

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo565toDpSizekrfVVM(long j);

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo568toSizeXkaWNTQ(long j);

    @Override // androidx.compose.p001ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    long mo569toSp0xMU5do(float f);

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo570toSpkPz2Gy4(float f);

    @Override // androidx.compose.p001ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo571toSpkPz2Gy4(int i);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutMeasureScope.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m1032$default$toDpGaN1DYA(LazyLayoutMeasureScope _this, long $this$toDp_u2dGaN1DYA) {
            if (TextUnitType.m7026equalsimpl0(TextUnit.m6997getTypeUIouoOA($this$toDp_u2dGaN1DYA), TextUnitType.INSTANCE.m7031getSpUIouoOA())) {
                return C1979Dp.m6801constructorimpl(TextUnit.m6998getValueimpl($this$toDp_u2dGaN1DYA) * _this.getFontScale());
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m1034$default$toDpu2uoSUM(LazyLayoutMeasureScope _this, int $this$toDp_u2du2uoSUM) {
            float $this$dp$iv = $this$toDp_u2du2uoSUM / _this.getDensity();
            return C1979Dp.m6801constructorimpl($this$dp$iv);
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m1033$default$toDpu2uoSUM(LazyLayoutMeasureScope _this, float $this$toDp_u2du2uoSUM) {
            float $this$dp$iv = $this$toDp_u2du2uoSUM / _this.getDensity();
            return C1979Dp.m6801constructorimpl($this$dp$iv);
        }

        /* JADX INFO: renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m1036$default$toSizeXkaWNTQ(LazyLayoutMeasureScope _this, long $this$toSize_u2dXkaWNTQ) {
            if ($this$toSize_u2dXkaWNTQ != 9205357640488583168L) {
                return SizeKt.Size(_this.mo567toPx0680j_4(DpSize.m6899getWidthD9Ej5fM($this$toSize_u2dXkaWNTQ)), _this.mo567toPx0680j_4(DpSize.m6897getHeightD9Ej5fM($this$toSize_u2dXkaWNTQ)));
            }
            return Size.INSTANCE.m4126getUnspecifiedNHjbRc();
        }

        /* JADX INFO: renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1035$default$toDpSizekrfVVM(LazyLayoutMeasureScope _this, long $this$toDpSize_u2dk_u2drfVVM) {
            if ($this$toDpSize_u2dk_u2drfVVM != 9205357640488583168L) {
                return DpKt.m6823DpSizeYgX7TsA(_this.mo563toDpu2uoSUM(Size.m4118getWidthimpl($this$toDpSize_u2dk_u2drfVVM)), _this.mo563toDpu2uoSUM(Size.m4115getHeightimpl($this$toDpSize_u2dk_u2drfVVM)));
            }
            return DpSize.INSTANCE.m6908getUnspecifiedMYxV2XQ();
        }
    }
}
