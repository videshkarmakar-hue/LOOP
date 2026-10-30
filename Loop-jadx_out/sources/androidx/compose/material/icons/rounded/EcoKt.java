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

/* JADX INFO: compiled from: Eco.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_eco", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Eco", "Landroidx/compose/material/icons/Icons$Rounded;", "getEco", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EcoKt {
    private static ImageVector _eco;

    public static final ImageVector getEco(Icons.Rounded $this$Eco) {
        if (_eco != null) {
            ImageVector imageVector = _eco;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Eco__u24lambda_u241 = new ImageVector.Builder("Rounded.Eco", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.95f, 5.97f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.05f, -1.04f, -0.89f, -1.88f, -1.92f, -1.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(17.33f, 4.02f, 16.66f, 4.0f, 16.01f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(10.98f, 4.0f, 7.49f, 4.97f, 5.55f, 6.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-3.68f, 3.68f, -3.15f, 8.9f, 0.09f, 11.9f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.01f, 0.0f, 0.01f, 0.0f, 0.01f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.51f, -4.22f, 4.52f, -7.16f, 7.67f, -8.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.21f, 0.18f, -4.7f, 3.58f, -5.51f, 10.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.05f, 0.48f, 2.2f, 0.75f, 3.36f, 0.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(2.05f, 0.0f, 4.16f, -0.8f, 5.92f, -2.55f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(19.28f, 16.26f, 20.23f, 12.1f, 19.95f, 5.97f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _eco = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Eco__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _eco;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
