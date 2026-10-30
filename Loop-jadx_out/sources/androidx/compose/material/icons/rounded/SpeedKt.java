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

/* JADX INFO: compiled from: Speed.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_speed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Speed", "Landroidx/compose/material/icons/Icons$Rounded;", "getSpeed", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SpeedKt {
    private static ImageVector _speed;

    public static final ImageVector getSpeed(Icons.Rounded $this$Speed) {
        if (_speed != null) {
            ImageVector imageVector = _speed;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Speed__u24lambda_u242 = new ImageVector.Builder("Rounded.Speed", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.46f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.07f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(7.55f, 7.55f, 0.0f, false, true, 0.52f, 1.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(8.0f, 8.0f, 0.0f, false, true, -0.69f, 4.73f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, false, true, -0.89f, 0.53f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(5.68f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, false, true, -0.89f, -0.54f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcTo(8.0f, 8.0f, 0.0f, false, true, 13.0f, 6.06f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(7.69f, 7.69f, 0.0f, false, true, 2.11f, 0.56f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.0f, -0.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.17f, -1.76f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcTo(10.0f, 10.0f, 0.0f, false, false, 3.35f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(2.0f, 2.0f, 0.0f, false, false, 1.72f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(13.85f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(2.0f, 2.0f, 0.0f, false, false, 1.74f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(10.0f, 10.0f, 0.0f, false, false, 0.55f, -8.89f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, false, false, -1.75f, -0.11f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Speed__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(10.59f, 12.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.arcToRelative(2.0f, 2.0f, 0.0f, false, false, 2.83f, 2.83f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(5.66f, -8.49f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        _speed = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Speed__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _speed;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
