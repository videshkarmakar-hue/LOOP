package androidx.compose.material.icons.sharp;

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

/* JADX INFO: compiled from: _7k.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"__7k", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_7k", "Landroidx/compose/material/icons/Icons$Sharp;", "get_7k", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class _7kKt {
    private static ImageVector __7k;

    public static final ImageVector get_7k(Icons.Sharp $this$_7k) {
        if (__7k != null) {
            ImageVector imageVector = __7k;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get__7k__u24lambda_u241 = new ImageVector.Builder("Sharp._7k", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(21.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(9.5f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(7.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.38f, -4.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(6.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(4.86f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(9.5f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(18.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-1.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.75f, -2.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(2.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(16.25f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.25f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(18.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        __7k = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get__7k__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = __7k;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
