package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.StrokeJoin;
import androidx.compose.p001ui.graphics.vector.ImageVector;
import androidx.compose.p001ui.graphics.vector.PathBuilder;
import androidx.compose.p001ui.graphics.vector.VectorKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PanoramaHorizontalSelect.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_panoramaHorizontalSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaHorizontalSelect", "Landroidx/compose/material/icons/Icons$Rounded;", "getPanoramaHorizontalSelect", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PanoramaHorizontalSelectKt {
    private static ImageVector _panoramaHorizontalSelect;

    public static final ImageVector getPanoramaHorizontalSelect(Icons.Rounded $this$PanoramaHorizontalSelect) {
        if (_panoramaHorizontalSelect != null) {
            ImageVector imageVector = _panoramaHorizontalSelect;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_PanoramaHorizontalSelect__u24lambda_u241 = new ImageVector.Builder("Rounded.PanoramaHorizontalSelect", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 5.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-3.89f, 0.0f, -6.95f, -0.84f, -8.69f, -1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(2.67f, 3.85f, 2.0f, 4.33f, 2.0f, 5.02f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.0f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.68f, 0.66f, 1.17f, 1.31f, 0.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(5.36f, 19.26f, 8.1f, 18.5f, 12.0f, 18.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(3.87f, 0.0f, 6.66f, 0.76f, 8.69f, 1.45f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(21.34f, 20.16f, 22.0f, 19.68f, 22.0f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.0f, -14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.68f, -0.66f, -1.17f, -1.31f, -0.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(18.66f, 4.73f, 15.86f, 5.5f, 12.0f, 5.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _panoramaHorizontalSelect = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_PanoramaHorizontalSelect__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _panoramaHorizontalSelect;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
