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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrowForwardIos.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m195d2 = {"_arrowForwardIos", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowForwardIos", "Landroidx/compose/material/icons/Icons$Rounded;", "getArrowForwardIos$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getArrowForwardIos", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ArrowForwardIosKt {
    private static ImageVector _arrowForwardIos;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.ArrowForwardIos", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Rounded.ArrowForwardIos", imports = {"androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos"}))
    public static /* synthetic */ void getArrowForwardIos$annotations(Icons.Rounded rounded) {
    }

    public static final ImageVector getArrowForwardIos(Icons.Rounded $this$ArrowForwardIos) {
        if (_arrowForwardIos != null) {
            ImageVector imageVector = _arrowForwardIos;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_ArrowForwardIos__u24lambda_u241 = new ImageVector.Builder("Rounded.ArrowForwardIos", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(7.38f, 21.01f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.49f, 0.49f, 1.28f, 0.49f, 1.77f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(8.31f, -8.31f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(9.15f, 2.98f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.49f, -0.49f, -1.28f, -0.49f, -1.77f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(-0.49f, 1.28f, 0.0f, 1.77f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(14.62f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-7.25f, 7.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.48f, 0.48f, -0.48f, 1.28f, 0.01f, 1.76f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _arrowForwardIos = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_ArrowForwardIos__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _arrowForwardIos;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
