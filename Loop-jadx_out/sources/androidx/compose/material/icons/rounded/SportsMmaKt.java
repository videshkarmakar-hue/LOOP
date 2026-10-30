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

/* JADX INFO: compiled from: SportsMma.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_sportsMma", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsMma", "Landroidx/compose/material/icons/Icons$Rounded;", "getSportsMma", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SportsMmaKt {
    private static ImageVector _sportsMma;

    public static final ImageVector getSportsMma(Icons.Rounded $this$SportsMma) {
        if (_sportsMma != null) {
            ImageVector imageVector = _sportsMma;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SportsMma__u24lambda_u242 = new ImageVector.Builder("Rounded.SportsMma", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(7.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_SportsMma__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(18.0f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineTo(5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineTo(7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(5.9f, 3.0f, 5.0f, 3.9f, 5.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(5.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, 0.13f, 0.01f, 0.26f, 0.04f, 0.39f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(0.8f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.09f, 0.47f, 0.5f, 0.8f, 0.98f, 0.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(10.36f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.45f, 0.0f, 0.89f, -0.36f, 0.98f, -0.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(0.8f, -4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(18.99f, 11.06f, 19.0f, 10.93f, 19.0f, 10.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineTo(8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(19.0f, 7.45f, 18.55f, 7.0f, 18.0f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(14.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineTo(8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineTo(8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(15.0f, 9.55f, 14.55f, 10.0f, 14.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        _sportsMma = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_SportsMma__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _sportsMma;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
