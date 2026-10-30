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

/* JADX INFO: compiled from: PowerOff.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_powerOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PowerOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getPowerOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PowerOffKt {
    private static ImageVector _powerOff;

    public static final ImageVector getPowerOff(Icons.Outlined $this$PowerOff) {
        if (_powerOff != null) {
            ImageVector imageVector = _powerOff;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_PowerOff__u24lambda_u241 = new ImageVector.Builder("Outlined.PowerOff", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(10.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(8.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(1.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(16.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(3.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.8f, 1.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.2f, -0.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(18.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(16.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-3.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(16.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(4.12f, 3.84f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.71f, 5.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.0f, 8.54f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(5.96f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(9.5f, 18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.48f, -0.48f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(4.47f, 4.47f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.41f, -1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.12f, 3.84f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.5f, 17.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.5f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-1.83f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(8.0f, 13.65f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-3.11f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(5.57f, 5.57f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.07f, 1.06f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _powerOff = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_PowerOff__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _powerOff;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
