package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidBlendMode.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0006H\u0001¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidBlendMode_androidKt {

    /* JADX INFO: compiled from: AndroidBlendMode.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[android.graphics.BlendMode.values().length];
            try {
                iArr[android.graphics.BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[android.graphics.BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[android.graphics.BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[android.graphics.BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[android.graphics.BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[android.graphics.BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[android.graphics.BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[android.graphics.BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[android.graphics.BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[android.graphics.BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[android.graphics.BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[android.graphics.BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[android.graphics.BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[android.graphics.BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[android.graphics.BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[android.graphics.BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[android.graphics.BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m3892isSupporteds9anfk8(int $this$isSupported_u2ds9anfk8) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m3954equalsimpl0($this$isSupported_u2ds9anfk8, BlendMode.INSTANCE.m3985getSrcOver0nO6VwU()) || m3894toPorterDuffModes9anfk8($this$isSupported_u2ds9anfk8) != PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m3894toPorterDuffModes9anfk8(int $this$toPorterDuffMode_u2ds9anfk8) {
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3958getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3981getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3964getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3985getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3968getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3983getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3966getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3984getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3967getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3982getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3965getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3986getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3977getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3979getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3976getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3962getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3972getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m3954equalsimpl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.INSTANCE.m3974getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m3893toAndroidBlendModes9anfk8(int $this$toAndroidBlendMode_u2ds9anfk8) {
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3958getClear0nO6VwU())) {
            return android.graphics.BlendMode.CLEAR;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3981getSrc0nO6VwU())) {
            return android.graphics.BlendMode.SRC;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3964getDst0nO6VwU())) {
            return android.graphics.BlendMode.DST;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3985getSrcOver0nO6VwU())) {
            return android.graphics.BlendMode.SRC_OVER;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3968getDstOver0nO6VwU())) {
            return android.graphics.BlendMode.DST_OVER;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3983getSrcIn0nO6VwU())) {
            return android.graphics.BlendMode.SRC_IN;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3966getDstIn0nO6VwU())) {
            return android.graphics.BlendMode.DST_IN;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3984getSrcOut0nO6VwU())) {
            return android.graphics.BlendMode.SRC_OUT;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3967getDstOut0nO6VwU())) {
            return android.graphics.BlendMode.DST_OUT;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3982getSrcAtop0nO6VwU())) {
            return android.graphics.BlendMode.SRC_ATOP;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3965getDstAtop0nO6VwU())) {
            return android.graphics.BlendMode.DST_ATOP;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3986getXor0nO6VwU())) {
            return android.graphics.BlendMode.XOR;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3977getPlus0nO6VwU())) {
            return android.graphics.BlendMode.PLUS;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3974getModulate0nO6VwU())) {
            return android.graphics.BlendMode.MODULATE;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3979getScreen0nO6VwU())) {
            return android.graphics.BlendMode.SCREEN;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3976getOverlay0nO6VwU())) {
            return android.graphics.BlendMode.OVERLAY;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3962getDarken0nO6VwU())) {
            return android.graphics.BlendMode.DARKEN;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3972getLighten0nO6VwU())) {
            return android.graphics.BlendMode.LIGHTEN;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3961getColorDodge0nO6VwU())) {
            return android.graphics.BlendMode.COLOR_DODGE;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3960getColorBurn0nO6VwU())) {
            return android.graphics.BlendMode.COLOR_BURN;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3970getHardlight0nO6VwU())) {
            return android.graphics.BlendMode.HARD_LIGHT;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3980getSoftlight0nO6VwU())) {
            return android.graphics.BlendMode.SOFT_LIGHT;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3963getDifference0nO6VwU())) {
            return android.graphics.BlendMode.DIFFERENCE;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3969getExclusion0nO6VwU())) {
            return android.graphics.BlendMode.EXCLUSION;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3975getMultiply0nO6VwU())) {
            return android.graphics.BlendMode.MULTIPLY;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3971getHue0nO6VwU())) {
            return android.graphics.BlendMode.HUE;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3978getSaturation0nO6VwU())) {
            return android.graphics.BlendMode.SATURATION;
        }
        if (BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3959getColor0nO6VwU())) {
            return android.graphics.BlendMode.COLOR;
        }
        return BlendMode.m3954equalsimpl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.INSTANCE.m3973getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(android.graphics.BlendMode $this$toComposeBlendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toComposeBlendMode.ordinal()]) {
            case 1:
                return BlendMode.INSTANCE.m3958getClear0nO6VwU();
            case 2:
                return BlendMode.INSTANCE.m3981getSrc0nO6VwU();
            case 3:
                return BlendMode.INSTANCE.m3964getDst0nO6VwU();
            case 4:
                return BlendMode.INSTANCE.m3985getSrcOver0nO6VwU();
            case 5:
                return BlendMode.INSTANCE.m3968getDstOver0nO6VwU();
            case 6:
                return BlendMode.INSTANCE.m3983getSrcIn0nO6VwU();
            case 7:
                return BlendMode.INSTANCE.m3966getDstIn0nO6VwU();
            case 8:
                return BlendMode.INSTANCE.m3984getSrcOut0nO6VwU();
            case 9:
                return BlendMode.INSTANCE.m3967getDstOut0nO6VwU();
            case 10:
                return BlendMode.INSTANCE.m3982getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.INSTANCE.m3965getDstAtop0nO6VwU();
            case 12:
                return BlendMode.INSTANCE.m3986getXor0nO6VwU();
            case 13:
                return BlendMode.INSTANCE.m3977getPlus0nO6VwU();
            case 14:
                return BlendMode.INSTANCE.m3974getModulate0nO6VwU();
            case 15:
                return BlendMode.INSTANCE.m3979getScreen0nO6VwU();
            case 16:
                return BlendMode.INSTANCE.m3976getOverlay0nO6VwU();
            case 17:
                return BlendMode.INSTANCE.m3962getDarken0nO6VwU();
            case 18:
                return BlendMode.INSTANCE.m3972getLighten0nO6VwU();
            case 19:
                return BlendMode.INSTANCE.m3961getColorDodge0nO6VwU();
            case 20:
                return BlendMode.INSTANCE.m3960getColorBurn0nO6VwU();
            case 21:
                return BlendMode.INSTANCE.m3970getHardlight0nO6VwU();
            case 22:
                return BlendMode.INSTANCE.m3980getSoftlight0nO6VwU();
            case 23:
                return BlendMode.INSTANCE.m3963getDifference0nO6VwU();
            case 24:
                return BlendMode.INSTANCE.m3969getExclusion0nO6VwU();
            case 25:
                return BlendMode.INSTANCE.m3975getMultiply0nO6VwU();
            case 26:
                return BlendMode.INSTANCE.m3971getHue0nO6VwU();
            case 27:
                return BlendMode.INSTANCE.m3978getSaturation0nO6VwU();
            case 28:
                return BlendMode.INSTANCE.m3959getColor0nO6VwU();
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                return BlendMode.INSTANCE.m3973getLuminosity0nO6VwU();
            default:
                return BlendMode.INSTANCE.m3985getSrcOver0nO6VwU();
        }
    }
}
