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

/* JADX INFO: compiled from: Rotate90DegreesCw.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_rotate90DegreesCw", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rotate90DegreesCw", "Landroidx/compose/material/icons/Icons$Filled;", "getRotate90DegreesCw", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Rotate90DegreesCwKt {
    private static ImageVector _rotate90DegreesCw;

    public static final ImageVector getRotate90DegreesCw(Icons.Filled $this$Rotate90DegreesCw) {
        if (_rotate90DegreesCw != null) {
            ImageVector imageVector = _rotate90DegreesCw;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Rotate90DegreesCw__u24lambda_u241 = new ImageVector.Builder("Filled.Rotate90DegreesCw", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(4.64f, 19.37f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(3.03f, 3.03f, 7.67f, 3.44f, 11.15f, 1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.46f, -1.46f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-2.66f, 1.43f, -6.04f, 1.03f, -8.28f, -1.21f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-2.73f, -2.73f, -2.73f, -7.17f, 0.0f, -9.9f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.42f, 6.69f, 9.21f, 6.03f, 11.0f, 6.03f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(4.0f, -4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-4.0f, -4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(3.01f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-2.3f, 0.0f, -4.61f, 0.87f, -6.36f, 2.63f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(1.12f, 10.15f, 1.12f, 15.85f, 4.64f, 19.37f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(11.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(6.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(6.0f, -6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-6.0f, -6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(11.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _rotate90DegreesCw = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Rotate90DegreesCw__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _rotate90DegreesCw;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
