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

/* JADX INFO: compiled from: Church.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_church", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Church", "Landroidx/compose/material/icons/Icons$Rounded;", "getChurch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ChurchKt {
    private static ImageVector _church;

    public static final ImageVector getChurch(Icons.Rounded $this$Church) {
        if (_church != null) {
            ImageVector imageVector = _church;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Church__u24lambda_u241 = new ImageVector.Builder("Rounded.Church", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(18.0f, 12.22f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-1.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.76f, -0.43f, -1.45f, -1.11f, -1.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(13.0f, 6.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(9.45f, 3.0f, 9.0f, 3.45f, 9.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(7.11f, 8.45f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(6.43f, 8.79f, 6.0f, 9.48f, 6.0f, 10.24f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(1.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.81f, 1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(2.47f, 13.79f, 2.0f, 14.51f, 2.0f, 15.3f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.0f, -2.89f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -1.0f, 0.68f, -1.92f, 1.66f, -2.08f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(12.92f, 16.82f, 14.0f, 17.79f, 14.0f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-4.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.79f, -0.47f, -1.51f, -1.19f, -1.83f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(18.0f, 12.22f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 13.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(12.83f, 13.5f, 12.0f, 13.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _church = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Church__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _church;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
