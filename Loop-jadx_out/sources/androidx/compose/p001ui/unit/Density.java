package androidx.compose.p001ui.unit;

import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface Density extends FontScaling {
    float getDensity();

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    int mo560roundToPxR2X_6o(long j);

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    int mo561roundToPx0680j_4(float f);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo563toDpu2uoSUM(float f);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo564toDpu2uoSUM(int i);

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo565toDpSizekrfVVM(long j);

    /* JADX INFO: renamed from: toPx--R2X_6o */
    float mo566toPxR2X_6o(long j);

    /* JADX INFO: renamed from: toPx-0680j_4 */
    float mo567toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo568toSizeXkaWNTQ(long j);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo570toSpkPz2Gy4(float f);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo571toSpkPz2Gy4(int i);

    /* JADX INFO: renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: Density.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$toPx-0680j_4, reason: not valid java name */
        public static float m6771$default$toPx0680j_4(Density _this, float $this$toPx_u2d0680j_4) {
            return _this.getDensity() * $this$toPx_u2d0680j_4;
        }

        /* JADX INFO: renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m6766$default$roundToPx0680j_4(Density _this, float $this$roundToPx_u2d0680j_4) {
            float px = _this.mo567toPx0680j_4($this$roundToPx_u2d0680j_4);
            if (Float.isInfinite(px)) {
                return Integer.MAX_VALUE;
            }
            return Math.round(px);
        }

        /* JADX INFO: renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m6770$default$toPxR2X_6o(Density _this, long $this$toPx_u2d_u2dR2X_6o) {
            if (TextUnitType.m7026equalsimpl0(TextUnit.m6997getTypeUIouoOA($this$toPx_u2d_u2dR2X_6o), TextUnitType.INSTANCE.m7031getSpUIouoOA())) {
                return _this.mo567toPx0680j_4(_this.mo562toDpGaN1DYA($this$toPx_u2d_u2dR2X_6o));
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* JADX INFO: renamed from: $default$roundToPx--R2X_6o, reason: not valid java name */
        public static int m6765$default$roundToPxR2X_6o(Density _this, long $this$roundToPx_u2d_u2dR2X_6o) {
            float $this$fastRoundToInt$iv = _this.mo566toPxR2X_6o($this$roundToPx_u2d_u2dR2X_6o);
            return Math.round($this$fastRoundToInt$iv);
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m6768$default$toDpu2uoSUM(Density _this, int $this$toDp_u2du2uoSUM) {
            float $this$dp$iv = $this$toDp_u2du2uoSUM / _this.getDensity();
            return C1979Dp.m6801constructorimpl($this$dp$iv);
        }

        /* JADX INFO: renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m6774$default$toSpkPz2Gy4(Density _this, int $this$toSp_u2dkPz2Gy4) {
            return _this.mo569toSp0xMU5do(_this.mo564toDpu2uoSUM($this$toSp_u2dkPz2Gy4));
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m6767$default$toDpu2uoSUM(Density _this, float $this$toDp_u2du2uoSUM) {
            float $this$dp$iv = $this$toDp_u2du2uoSUM / _this.getDensity();
            return C1979Dp.m6801constructorimpl($this$dp$iv);
        }

        /* JADX INFO: renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m6773$default$toSpkPz2Gy4(Density _this, float $this$toSp_u2dkPz2Gy4) {
            return _this.mo569toSp0xMU5do(_this.mo563toDpu2uoSUM($this$toSp_u2dkPz2Gy4));
        }

        public static Rect $default$toRect(Density _this, DpRect $this$toRect) {
            return new Rect(_this.mo567toPx0680j_4($this$toRect.m6884getLeftD9Ej5fM()), _this.mo567toPx0680j_4($this$toRect.m6886getTopD9Ej5fM()), _this.mo567toPx0680j_4($this$toRect.m6885getRightD9Ej5fM()), _this.mo567toPx0680j_4($this$toRect.m6883getBottomD9Ej5fM()));
        }

        /* JADX INFO: renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m6772$default$toSizeXkaWNTQ(Density _this, long $this$toSize_u2dXkaWNTQ) {
            if ($this$toSize_u2dXkaWNTQ != 9205357640488583168L) {
                return SizeKt.Size(_this.mo567toPx0680j_4(DpSize.m6899getWidthD9Ej5fM($this$toSize_u2dXkaWNTQ)), _this.mo567toPx0680j_4(DpSize.m6897getHeightD9Ej5fM($this$toSize_u2dXkaWNTQ)));
            }
            return Size.INSTANCE.m4126getUnspecifiedNHjbRc();
        }

        /* JADX INFO: renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6769$default$toDpSizekrfVVM(Density _this, long $this$toDpSize_u2dk_u2drfVVM) {
            if ($this$toDpSize_u2dk_u2drfVVM != 9205357640488583168L) {
                return DpKt.m6823DpSizeYgX7TsA(_this.mo563toDpu2uoSUM(Size.m4118getWidthimpl($this$toDpSize_u2dk_u2drfVVM)), _this.mo563toDpu2uoSUM(Size.m4115getHeightimpl($this$toDpSize_u2dk_u2drfVVM)));
            }
            return DpSize.INSTANCE.m6908getUnspecifiedMYxV2XQ();
        }
    }

    /* JADX INFO: compiled from: Density.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6789toDpGaN1DYA(Density $this, long $receiver) {
            return FontScaling.CC.m6910$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6796toSp0xMU5do(Density $this, float $receiver) {
            return FontScaling.CC.m6911$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6794toPx0680j_4(Density $this, float $receiver) {
            return CC.m6771$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6788roundToPx0680j_4(Density $this, float $receiver) {
            return CC.m6766$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6793toPxR2X_6o(Density $this, long $receiver) {
            return CC.m6770$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6787roundToPxR2X_6o(Density $this, long $receiver) {
            return CC.m6765$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6791toDpu2uoSUM(Density $this, int $receiver) {
            return CC.m6768$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6798toSpkPz2Gy4(Density $this, int $receiver) {
            return CC.m6774$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6790toDpu2uoSUM(Density $this, float $receiver) {
            return CC.m6767$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6797toSpkPz2Gy4(Density $this, float $receiver) {
            return CC.m6773$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(Density $this, DpRect $receiver) {
            return CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6795toSizeXkaWNTQ(Density $this, long $receiver) {
            return CC.m6772$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6792toDpSizekrfVVM(Density $this, long $receiver) {
            return CC.m6769$default$toDpSizekrfVVM($this, $receiver);
        }
    }
}
