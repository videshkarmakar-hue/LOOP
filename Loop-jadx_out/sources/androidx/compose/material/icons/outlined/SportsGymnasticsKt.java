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

/* JADX INFO: compiled from: SportsGymnastics.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_sportsGymnastics", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsGymnastics", "Landroidx/compose/material/icons/Icons$Outlined;", "getSportsGymnastics", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SportsGymnasticsKt {
    private static ImageVector _sportsGymnastics;

    public static final ImageVector getSportsGymnastics(Icons.Outlined $this$SportsGymnastics) {
        if (_sportsGymnastics != null) {
            ImageVector imageVector = _sportsGymnastics;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SportsGymnastics__u24lambda_u241 = new ImageVector.Builder("Outlined.SportsGymnastics", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(4.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -1.1f, 0.9f, -2.0f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(7.1f, 8.0f, 6.0f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(4.0f, 7.1f, 4.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(1.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(7.0f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.31f, 1.52f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(11.14f, 8.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(21.8f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(23.0f, 5.4f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(14.5f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(14.0f, 22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.5f, -10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(8.0f, 11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _sportsGymnastics = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_SportsGymnastics__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _sportsGymnastics;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
