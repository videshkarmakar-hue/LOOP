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

/* JADX INFO: compiled from: HeatPump.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_heatPump", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HeatPump", "Landroidx/compose/material/icons/Icons$Rounded;", "getHeatPump", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HeatPumpKt {
    private static ImageVector _heatPump;

    public static final ImageVector getHeatPump(Icons.Rounded $this$HeatPump) {
        if (_heatPump != null) {
            ImageVector imageVector = _heatPump;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_HeatPump__u24lambda_u241 = new ImageVector.Builder("Rounded.HeatPump", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.75f, 7.08f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.82f, 0.12f, 1.57f, 0.44f, 2.2f, 0.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.2f, 2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(7.08f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(11.25f, 7.08f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(3.11f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.2f, -2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(9.68f, 7.52f, 10.43f, 7.2f, 11.25f, 7.08f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(7.99f, 9.05f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.2f, 2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(7.08f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.2f, 10.43f, 7.52f, 9.68f, 7.99f, 9.05f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(7.08f, 12.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(3.11f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.2f, 2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.52f, 14.32f, 7.2f, 13.57f, 7.08f, 12.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(11.25f, 16.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.82f, -0.12f, -1.57f, -0.44f, -2.2f, -0.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.2f, -2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(16.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(13.0f, 12.55f, 12.55f, 13.0f, 12.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.75f, 16.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-3.11f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.2f, 2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(14.32f, 16.48f, 13.57f, 16.8f, 12.75f, 16.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(16.01f, 14.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.2f, -2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(3.11f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(16.8f, 13.57f, 16.48f, 14.32f, 16.01f, 14.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(13.81f, 11.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.2f, -2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.47f, 0.64f, 0.79f, 1.39f, 0.91f, 2.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(13.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _heatPump = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_HeatPump__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _heatPump;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
