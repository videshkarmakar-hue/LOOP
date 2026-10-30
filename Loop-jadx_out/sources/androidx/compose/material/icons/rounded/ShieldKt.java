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

/* JADX INFO: compiled from: Shield.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_shield", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Shield", "Landroidx/compose/material/icons/Icons$Rounded;", "getShield", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ShieldKt {
    private static ImageVector _shield;

    public static final ImageVector getShield(Icons.Rounded $this$Shield) {
        if (_shield != null) {
            ImageVector imageVector = _shield;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Shield__u24lambda_u241 = new ImageVector.Builder("Rounded.Shield", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(11.3f, 2.26f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-6.0f, 2.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(4.52f, 4.81f, 4.0f, 5.55f, 4.0f, 6.39f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(4.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 4.83f, 3.13f, 9.37f, 7.43f, 10.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.37f, 0.12f, 0.77f, 0.12f, 1.14f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(4.3f, -1.38f, 7.43f, -5.91f, 7.43f, -10.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-4.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.83f, -0.52f, -1.58f, -1.3f, -1.87f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-6.0f, -2.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(12.25f, 2.09f, 11.75f, 2.09f, 11.3f, 2.26f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _shield = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Shield__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _shield;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
