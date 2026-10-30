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

/* JADX INFO: compiled from: Opacity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_opacity", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Opacity", "Landroidx/compose/material/icons/Icons$Sharp;", "getOpacity", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OpacityKt {
    private static ImageVector _opacity;

    public static final ImageVector getOpacity(Icons.Sharp $this$Opacity) {
        if (_opacity != null) {
            ImageVector imageVector = _opacity;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Opacity__u24lambda_u241 = new ImageVector.Builder("Sharp.Opacity", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(17.66f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 2.35f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.34f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(4.78f, 9.56f, 4.0f, 11.64f, 4.0f, 13.64f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(0.78f, 4.11f, 2.34f, 5.67f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(3.61f, 2.35f, 5.66f, 2.35f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(4.1f, -0.79f, 5.66f, -2.35f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(20.0f, 15.64f, 20.0f, 13.64f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(19.22f, 9.56f, 17.66f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(6.0f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.01f, -2.0f, 0.62f, -3.27f, 1.76f, -4.4f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 5.27f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(4.24f, 4.38f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(17.38f, 10.77f, 17.99f, 12.0f, 18.0f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _opacity = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Opacity__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _opacity;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
