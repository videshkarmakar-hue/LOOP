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

/* JADX INFO: compiled from: AlignHorizontalCenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_alignHorizontalCenter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlignHorizontalCenter", "Landroidx/compose/material/icons/Icons$Rounded;", "getAlignHorizontalCenter", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AlignHorizontalCenterKt {
    private static ImageVector _alignHorizontalCenter;

    public static final ImageVector getAlignHorizontalCenter(Icons.Rounded $this$AlignHorizontalCenter) {
        if (_alignHorizontalCenter != null) {
            ImageVector imageVector = _alignHorizontalCenter;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_AlignHorizontalCenter__u24lambda_u241 = new ImageVector.Builder("Rounded.AlignHorizontalCenter", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(6.5f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(20.33f, 7.0f, 21.0f, 7.67f, 21.0f, 8.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.83f, 0.0f, 1.5f, 0.67f, 1.5f, 1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(7.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(6.67f, 17.0f, 6.0f, 16.33f, 6.0f, 15.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(6.0f, 14.67f, 6.67f, 14.0f, 7.5f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(4.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(3.67f, 10.0f, 3.0f, 9.33f, 3.0f, 8.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(3.0f, 7.67f, 3.67f, 7.0f, 4.5f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.0f, -4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(11.0f, 2.45f, 11.45f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _alignHorizontalCenter = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_AlignHorizontalCenter__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _alignHorizontalCenter;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
