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

/* JADX INFO: compiled from: FitnessCenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_fitnessCenter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FitnessCenter", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFitnessCenter", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FitnessCenterKt {
    private static ImageVector _fitnessCenter;

    public static final ImageVector getFitnessCenter(Icons.TwoTone $this$FitnessCenter) {
        if (_fitnessCenter != null) {
            ImageVector imageVector = _fitnessCenter;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_FitnessCenter__u24lambda_u241 = new ImageVector.Builder("TwoTone.FitnessCenter", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(20.57f, 14.86f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(22.0f, 13.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(20.57f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.0f, 15.57f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(8.43f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 3.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(10.57f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(9.14f, 3.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(7.71f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.57f, 4.14f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.14f, 2.71f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.71f, 4.14f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.43f, 1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.0f, 7.71f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.43f, 1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.0f, 10.57f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(3.43f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(7.0f, 8.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(15.57f, 17.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 20.57f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(13.43f, 22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.43f, -1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(16.29f, 22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.14f, -2.14f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.43f, 1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.43f, -1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.43f, -1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(22.0f, 16.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.43f, -1.43f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _fitnessCenter = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_FitnessCenter__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _fitnessCenter;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
