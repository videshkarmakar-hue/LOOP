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

/* JADX INFO: compiled from: NearMeDisabled.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_nearMeDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NearMeDisabled", "Landroidx/compose/material/icons/Icons$Filled;", "getNearMeDisabled", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NearMeDisabledKt {
    private static ImageVector _nearMeDisabled;

    public static final ImageVector getNearMeDisabled(Icons.Filled $this$NearMeDisabled) {
        if (_nearMeDisabled != null) {
            ImageVector imageVector = _nearMeDisabled;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_NearMeDisabled__u24lambda_u241 = new ImageVector.Builder("Filled.NearMeDisabled", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 6.34f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(21.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-3.34f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 6.34f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(22.61f, 19.78f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.22f, 1.39f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.81f, 2.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(5.07f, 5.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(3.0f, 9.69f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(7.07f, 2.83f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.9f, 21.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.81f, -4.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(5.07f, 5.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(22.61f, 19.78f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _nearMeDisabled = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_NearMeDisabled__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _nearMeDisabled;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
