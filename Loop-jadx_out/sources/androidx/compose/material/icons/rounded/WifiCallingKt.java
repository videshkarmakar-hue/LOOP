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

/* JADX INFO: compiled from: WifiCalling.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_wifiCalling", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WifiCalling", "Landroidx/compose/material/icons/Icons$Rounded;", "getWifiCalling", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WifiCallingKt {
    private static ImageVector _wifiCalling;

    public static final ImageVector getWifiCalling(Icons.Rounded $this$WifiCalling) {
        if (_wifiCalling != null) {
            ImageVector imageVector = _wifiCalling;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_WifiCalling__u24lambda_u242 = new ImageVector.Builder("Rounded.WifiCalling", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(22.0f, 4.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(21.79f, 4.78f, 19.67f, 3.0f, 16.5f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-3.18f, 0.0f, -5.29f, 1.78f, -5.5f, 1.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(16.5f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(22.0f, 4.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_WifiCalling__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(19.2f, 15.28f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-2.54f, -0.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-0.61f, -0.07f, -1.21f, 0.14f, -1.64f, 0.57f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-1.84f, 1.84f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-2.83f, -1.44f, -5.15f, -3.75f, -6.59f, -6.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(1.85f, -1.85f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.43f, -0.43f, 0.64f, -1.04f, 0.57f, -1.64f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(8.72f, 4.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(8.6f, 3.79f, 7.75f, 3.03f, 6.73f, 3.03f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineTo(5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-1.13f, 0.0f, -2.07f, 0.94f, -2.0f, 2.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(3.53f, 13.64f, 10.36f, 20.47f, 18.9f, 21.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(1.13f, 0.07f, 2.07f, -0.87f, 2.07f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(-1.73f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(20.97f, 16.25f, 20.21f, 15.4f, 19.2f, 15.28f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        _wifiCalling = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_WifiCalling__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _wifiCalling;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
