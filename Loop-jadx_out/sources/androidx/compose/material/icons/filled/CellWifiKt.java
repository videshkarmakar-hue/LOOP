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

/* JADX INFO: compiled from: CellWifi.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_cellWifi", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CellWifi", "Landroidx/compose/material/icons/Icons$Filled;", "getCellWifi", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CellWifiKt {
    private static ImageVector _cellWifi;

    public static final ImageVector getCellWifi(Icons.Filled $this$CellWifi) {
        if (_cellWifi != null) {
            ImageVector imageVector = _cellWifi;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_CellWifi__u24lambda_u241 = new ImageVector.Builder("Filled.CellWifi", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(18.0f, 9.98f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.0f, 22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(5.97f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(18.0f, 9.98f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(20.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-7.22f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(5.22f, 7.22f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(3.93f, 5.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(3.9f, -3.91f, 10.24f, -3.91f, 14.15f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.29f, 1.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(13.6f, 4.03f, 8.41f, 4.03f, 5.22f, 7.22f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.93f, 11.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(11.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.93f, -1.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(10.14f, 10.01f, 11.86f, 10.01f, 12.93f, 11.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(14.22f, 9.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.78f, -1.77f, -4.66f, -1.77f, -6.43f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.5f, 8.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(2.48f, -2.48f, 6.52f, -2.48f, 9.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(14.22f, 9.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _cellWifi = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_CellWifi__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _cellWifi;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
