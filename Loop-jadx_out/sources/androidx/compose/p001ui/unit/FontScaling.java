package androidx.compose.p001ui.unit;

import androidx.compose.p001ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.p001ui.unit.fontscaling.FontScaleConverterFactory;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: FontScaling.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/unit/FontScaling;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface FontScaling {
    float getFontScale();

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo562toDpGaN1DYA(long j);

    /* JADX INFO: renamed from: toSp-0xMU5do */
    long mo569toSp0xMU5do(float f);

    /* JADX INFO: renamed from: androidx.compose.ui.unit.FontScaling$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: FontScaling.android.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$toSp-0xMU5do, reason: not valid java name */
        public static long m6911$default$toSp0xMU5do(FontScaling _this, float $this$toSp_u2d0xMU5do) {
            if (!FontScaleConverterFactory.INSTANCE.isNonLinearFontScalingActive(_this.getFontScale())) {
                return TextUnitKt.getSp($this$toSp_u2d0xMU5do / _this.getFontScale());
            }
            FontScaleConverter converter = FontScaleConverterFactory.INSTANCE.forScale(_this.getFontScale());
            return TextUnitKt.getSp(converter != null ? converter.convertDpToSp($this$toSp_u2d0xMU5do) : $this$toSp_u2d0xMU5do / _this.getFontScale());
        }

        /* JADX INFO: renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m6910$default$toDpGaN1DYA(FontScaling _this, long $this$toDp_u2dGaN1DYA) {
            boolean value$iv = TextUnitType.m7026equalsimpl0(TextUnit.m6997getTypeUIouoOA($this$toDp_u2dGaN1DYA), TextUnitType.INSTANCE.m7031getSpUIouoOA());
            if (!value$iv) {
                InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
            }
            if (!FontScaleConverterFactory.INSTANCE.isNonLinearFontScalingActive(_this.getFontScale())) {
                return C1979Dp.m6801constructorimpl(TextUnit.m6998getValueimpl($this$toDp_u2dGaN1DYA) * _this.getFontScale());
            }
            FontScaleConverter converter = FontScaleConverterFactory.INSTANCE.forScale(_this.getFontScale());
            float fM6998getValueimpl = TextUnit.m6998getValueimpl($this$toDp_u2dGaN1DYA);
            return C1979Dp.m6801constructorimpl(converter == null ? fM6998getValueimpl * _this.getFontScale() : converter.convertSpToDp(fM6998getValueimpl));
        }
    }

    /* JADX INFO: compiled from: FontScaling.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6915toSp0xMU5do(FontScaling $this, float $receiver) {
            return CC.m6911$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6914toDpGaN1DYA(FontScaling $this, long $receiver) {
            return CC.m6910$default$toDpGaN1DYA($this, $receiver);
        }
    }
}
