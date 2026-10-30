package androidx.compose.material.icons.filled;

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

/* JADX INFO: compiled from: Support.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_support", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Support", "Landroidx/compose/material/icons/Icons$Filled;", "getSupport", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SupportKt {
    private static ImageVector _support;

    public static final ImageVector getSupport(Icons.Filled $this$Support) {
        if (_support != null) {
            ImageVector imageVector = _support;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Support__u24lambda_u241 = new ImageVector.Builder("Filled.Support", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 5.52f, 4.48f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.46f, 9.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.78f, 1.15f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.51f, -1.36f, -1.58f, -2.44f, -2.95f, -2.94f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.15f, -2.78f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(16.98f, 5.35f, 18.65f, 7.02f, 19.46f, 9.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.66f, 0.0f, -3.0f, -1.34f, -3.0f, -3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(1.34f, -3.0f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(3.0f, 1.34f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(13.66f, 15.0f, 12.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(9.13f, 4.54f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.17f, 2.78f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.38f, 0.5f, -2.47f, 1.59f, -2.98f, 2.97f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.54f, 9.13f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(5.35f, 7.02f, 7.02f, 5.35f, 9.13f, 4.54f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(4.54f, 14.87f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.78f, -1.15f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.51f, 1.38f, 1.59f, 2.46f, 2.97f, 2.96f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.17f, 2.78f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.02f, 18.65f, 5.35f, 16.98f, 4.54f, 14.87f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(14.88f, 19.46f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.15f, -2.78f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.37f, -0.51f, 2.45f, -1.59f, 2.95f, -2.97f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.78f, 1.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(18.65f, 16.98f, 16.98f, 18.65f, 14.88f, 19.46f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _support = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Support__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _support;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
