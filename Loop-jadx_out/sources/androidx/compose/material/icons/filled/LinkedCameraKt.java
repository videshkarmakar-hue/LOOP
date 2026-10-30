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

/* JADX INFO: compiled from: LinkedCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_linkedCamera", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LinkedCamera", "Landroidx/compose/material/icons/Icons$Filled;", "getLinkedCamera", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LinkedCameraKt {
    private static ImageVector _linkedCamera;

    public static final ImageVector getLinkedCamera(Icons.Filled $this$LinkedCamera) {
        if (_linkedCamera != null) {
            ImageVector imageVector = _linkedCamera;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_LinkedCamera__u24lambda_u243 = new ImageVector.Builder("Filled.LinkedCamera", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.moveToRelative(-3.2f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(3.2f, 3.2f, 0.0f, true, true, 6.4f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(3.2f, 3.2f, 0.0f, true, true, -6.4f, 0.0f);
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_LinkedCamera__u24lambda_u243, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(16.0f, 3.33f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(2.58f, 0.0f, 4.67f, 2.09f, 4.67f, 4.67f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineTo(22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -3.31f, -2.69f, -6.0f, -6.0f, -6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(1.33f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(16.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(1.11f, 0.0f, 2.0f, 0.89f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(1.33f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -1.84f, -1.49f, -3.33f, -3.33f, -3.33f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineTo(6.0f);
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_LinkedCamera__u24lambda_u243, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv3.moveTo(17.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(0.0f, -1.11f, -0.89f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.lineTo(15.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.lineTo(9.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.lineTo(7.17f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.lineTo(4.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.verticalLineToRelative(12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.lineTo(22.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.horizontalLineToRelative(-5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.close();
        $this$PathData_u24lambda_u240$iv$iv$iv3.moveTo(12.0f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.reflectiveCurveToRelative(2.24f, -5.0f, 5.0f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.reflectiveCurveToRelative(-2.24f, 5.0f, -5.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.close();
        _linkedCamera = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_LinkedCamera__u24lambda_u243, $this$PathData_u24lambda_u240$iv$iv$iv3.getNodes(), pathFillType$iv3, "", fill$iv$iv3, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv3, strokeLineJoin$iv$iv3, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _linkedCamera;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
