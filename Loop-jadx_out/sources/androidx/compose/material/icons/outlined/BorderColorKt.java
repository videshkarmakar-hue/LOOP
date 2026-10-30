package androidx.compose.material.icons.outlined;

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

/* JADX INFO: compiled from: BorderColor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_borderColor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BorderColor", "Landroidx/compose/material/icons/Icons$Outlined;", "getBorderColor", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BorderColorKt {
    private static ImageVector _borderColor;

    public static final ImageVector getBorderColor(Icons.Outlined $this$BorderColor) {
        if (_borderColor != null) {
            ImageVector imageVector = _borderColor;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_BorderColor__u24lambda_u243 = new ImageVector.Builder("Outlined.BorderColor", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(16.81f, 8.94f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-3.75f, -3.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.0f, 14.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(3.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(16.81f, 8.94f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(6.0f, 16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-0.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(7.06f, -7.06f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.92f, 0.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.92f, 16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_BorderColor__u24lambda_u243, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(19.71f, 6.04f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-2.34f, -2.34f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(17.17f, 2.09f, 16.92f, 2.0f, 16.66f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-0.25f, 0.0f, -0.51f, 0.1f, -0.7f, 0.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-1.83f, 1.83f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(3.75f, 3.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(19.71f, 6.04f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_BorderColor__u24lambda_u243, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv3.moveTo(2.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.horizontalLineToRelative(20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.horizontalLineToRelative(-20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.close();
        _borderColor = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_BorderColor__u24lambda_u243, $this$PathData_u24lambda_u240$iv$iv$iv3.getNodes(), pathFillType$iv3, "", fill$iv$iv3, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv3, strokeLineJoin$iv$iv3, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _borderColor;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
