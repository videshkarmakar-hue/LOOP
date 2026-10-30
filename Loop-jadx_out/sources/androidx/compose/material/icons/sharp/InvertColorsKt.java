package androidx.compose.material.icons.sharp;

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

/* JADX INFO: compiled from: InvertColors.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_invertColors", "Landroidx/compose/ui/graphics/vector/ImageVector;", "InvertColors", "Landroidx/compose/material/icons/Icons$Sharp;", "getInvertColors", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InvertColorsKt {
    private static ImageVector _invertColors;

    public static final ImageVector getInvertColors(Icons.Sharp $this$InvertColors) {
        if (_invertColors != null) {
            ImageVector imageVector = _invertColors;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_InvertColors__u24lambda_u241 = new ImageVector.Builder("Sharp.InvertColors", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 4.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-3.31f, 0.0f, -6.0f, -2.63f, -6.0f, -5.87f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -1.56f, 0.62f, -3.03f, 1.75f, -4.14f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 4.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(6.35f, 7.56f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.35f, 7.56f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(4.9f, 8.99f, 4.0f, 10.96f, 4.0f, 13.13f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(4.0f, 17.48f, 7.58f, 21.0f, 12.0f, 21.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(4.42f, 0.0f, 8.0f, -3.52f, 8.0f, -7.87f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -2.17f, -0.9f, -4.14f, -2.35f, -5.57f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.35f, 7.56f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _invertColors = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_InvertColors__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _invertColors;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
