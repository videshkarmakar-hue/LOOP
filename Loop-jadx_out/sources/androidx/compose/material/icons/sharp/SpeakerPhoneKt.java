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

/* JADX INFO: compiled from: SpeakerPhone.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_speakerPhone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SpeakerPhone", "Landroidx/compose/material/icons/Icons$Sharp;", "getSpeakerPhone", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SpeakerPhoneKt {
    private static ImageVector _speakerPhone;

    public static final ImageVector getSpeakerPhone(Icons.Sharp $this$SpeakerPhone) {
        if (_speakerPhone != null) {
            ImageVector imageVector = _speakerPhone;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_SpeakerPhone__u24lambda_u241 = new ImageVector.Builder("Sharp.SpeakerPhone", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(7.0f, 7.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(8.43f, 8.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.91f, -0.91f, 2.18f, -1.48f, 3.57f, -1.48f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(2.66f, 0.57f, 3.57f, 1.48f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.0f, 7.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(15.72f, 5.79f, 13.95f, 5.0f, 12.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(-3.72f, 0.79f, -5.0f, 2.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(8.98f, 1.0f, 6.24f, 2.23f, 4.25f, 4.21f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.41f, 1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.28f, 4.0f, 9.53f, 3.0f, 12.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(4.72f, 1.0f, 6.34f, 2.62f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.41f, -1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(17.76f, 2.23f, 15.02f, 1.0f, 12.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(15.99f, 10.01f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(8.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(11.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(7.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(15.99f, 10.01f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(15.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(9.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _speakerPhone = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_SpeakerPhone__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _speakerPhone;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
