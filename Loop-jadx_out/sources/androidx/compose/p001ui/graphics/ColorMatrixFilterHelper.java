package androidx.compose.p001ui.graphics;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidColorFilter.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, m195d2 = {"Landroidx/compose/ui/graphics/ColorMatrixFilterHelper;", "", "()V", "getColorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "getColorMatrix-8unuwjk", "(Landroid/graphics/ColorMatrixColorFilter;)[F", "ui-graphics_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ColorMatrixFilterHelper {
    public static final ColorMatrixFilterHelper INSTANCE = new ColorMatrixFilterHelper();

    private ColorMatrixFilterHelper() {
    }

    /* JADX INFO: renamed from: getColorMatrix-8unuwjk, reason: not valid java name */
    public final float[] m4371getColorMatrix8unuwjk(ColorMatrixColorFilter colorFilter) {
        ColorMatrix androidColorMatrix = new ColorMatrix();
        colorFilter.getColorMatrix(androidColorMatrix);
        return ColorMatrix.m4347constructorimpl(androidColorMatrix.getArray());
    }
}
