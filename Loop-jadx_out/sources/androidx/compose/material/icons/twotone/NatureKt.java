package androidx.compose.material.icons.twotone;

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

/* JADX INFO: compiled from: Nature.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_nature", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Nature", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNature", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NatureKt {
    private static ImageVector _nature;

    public static final ImageVector getNature(Icons.TwoTone $this$Nature) {
        if (_nature != null) {
            ImageVector imageVector = _nature;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Nature__u24lambda_u242 = new ImageVector.Builder("TwoTone.Nature", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.17f, 4.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-2.76f, 0.0f, -5.0f, 2.24f, -5.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(2.24f, 5.0f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(5.0f, -2.24f, 5.0f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(-2.25f, -5.0f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Nature__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 0.3f, null, 0.3f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(19.17f, 9.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -3.87f, -3.13f, -7.0f, -7.0f, -7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(-7.0f, 3.13f, -7.0f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, 3.47f, 2.52f, 6.34f, 5.83f, 6.89f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(11.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(5.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(-6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(-3.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(-0.03f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(3.49f, -0.4f, 6.2f, -3.36f, 6.2f, -6.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(12.17f, 14.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(2.24f, -5.0f, 5.0f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(-2.25f, 5.0f, -5.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        _nature = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Nature__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _nature;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
