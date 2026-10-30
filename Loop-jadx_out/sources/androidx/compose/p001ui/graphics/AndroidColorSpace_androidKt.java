package androidx.compose.p001ui.graphics;

import android.graphics.ColorSpace;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidColorSpace.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007¨\u0006\u0004"}, m195d2 = {"toAndroidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "toComposeColorSpace", "ui-graphics_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidColorSpace_androidKt {
    public static final ColorSpace toAndroidColorSpace(androidx.compose.p001ui.graphics.colorspace.ColorSpace $this$toAndroidColorSpace) {
        ColorSpaceVerificationHelper colorSpaceVerificationHelper = ColorSpaceVerificationHelper.INSTANCE;
        return ColorSpaceVerificationHelper.androidColorSpace($this$toAndroidColorSpace);
    }

    public static final androidx.compose.p001ui.graphics.colorspace.ColorSpace toComposeColorSpace(ColorSpace $this$toComposeColorSpace) {
        ColorSpaceVerificationHelper colorSpaceVerificationHelper = ColorSpaceVerificationHelper.INSTANCE;
        return ColorSpaceVerificationHelper.composeColorSpace($this$toComposeColorSpace);
    }
}
