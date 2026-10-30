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

/* JADX INFO: compiled from: FastRewind.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_fastRewind", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FastRewind", "Landroidx/compose/material/icons/Icons$Rounded;", "getFastRewind", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FastRewindKt {
    private static ImageVector _fastRewind;

    public static final ImageVector getFastRewind(Icons.Rounded $this$FastRewind) {
        if (_fastRewind != null) {
            ImageVector imageVector = _fastRewind;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_FastRewind__u24lambda_u241 = new ImageVector.Builder("Rounded.FastRewind", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(11.0f, 16.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(11.0f, 7.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.81f, -0.91f, -1.28f, -1.58f, -0.82f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-5.77f, 4.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.56f, 0.4f, -0.56f, 1.24f, 0.0f, 1.63f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(5.77f, 4.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.67f, 0.47f, 1.58f, 0.0f, 1.58f, -0.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.66f, 12.82f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(5.77f, 4.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.66f, 0.47f, 1.58f, -0.01f, 1.58f, -0.82f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(20.01f, 7.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.81f, -0.91f, -1.28f, -1.58f, -0.82f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-5.77f, 4.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.57f, 0.4f, -0.57f, 1.24f, 0.0f, 1.64f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _fastRewind = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_FastRewind__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _fastRewind;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
