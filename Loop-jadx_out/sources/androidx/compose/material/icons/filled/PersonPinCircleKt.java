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

/* JADX INFO: compiled from: PersonPinCircle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_personPinCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonPinCircle", "Landroidx/compose/material/icons/Icons$Filled;", "getPersonPinCircle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PersonPinCircleKt {
    private static ImageVector _personPinCircle;

    public static final ImageVector getPersonPinCircle(Icons.Filled $this$PersonPinCircle) {
        if (_personPinCircle != null) {
            ImageVector imageVector = _personPinCircle;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_PersonPinCircle__u24lambda_u241 = new ImageVector.Builder("Filled.PersonPinCircle", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(8.14f, 2.0f, 5.0f, 5.14f, 5.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 5.25f, 7.0f, 13.0f, 7.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(7.0f, -7.75f, 7.0f, -13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(19.0f, 5.14f, 15.86f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.1f, 0.0f, 2.0f, 0.9f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 1.11f, -0.9f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(-2.0f, -0.89f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(10.0f, 4.9f, 10.9f, 4.0f, 12.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.67f, 0.0f, -3.14f, -0.85f, -4.0f, -2.15f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.02f, -1.32f, 2.67f, -2.05f, 4.0f, -2.05f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(3.98f, 0.73f, 4.0f, 2.05f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(15.14f, 13.15f, 13.67f, 14.0f, 12.0f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _personPinCircle = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_PersonPinCircle__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _personPinCircle;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
