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

/* JADX INFO: compiled from: PhotoFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_photoFilter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhotoFilter", "Landroidx/compose/material/icons/Icons$Rounded;", "getPhotoFilter", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PhotoFilterKt {
    private static ImageVector _photoFilter;

    public static final ImageVector getPhotoFilter(Icons.Rounded $this$PhotoFilter) {
        if (_photoFilter != null) {
            ImageVector imageVector = _photoFilter;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_PhotoFilter__u24lambda_u241 = new ImageVector.Builder("Rounded.PhotoFilter", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.02f, 10.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.02f, 18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.0f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.02f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.0f, 21.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.1f, 0.0f, 2.0f, -0.89f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-8.01f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.55f, -0.44f, -0.99f, -0.99f, -0.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(-0.99f, 0.44f, -0.99f, 0.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(13.25f, 10.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.46f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.18f, -0.39f, -0.73f, -0.39f, -0.91f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.79f, 1.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.76f, 0.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.39f, 0.18f, -0.39f, 0.73f, 0.0f, 0.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.75f, 0.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.79f, 1.76f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.18f, 0.39f, 0.73f, 0.39f, 0.91f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.79f, -1.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.76f, -0.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.39f, -0.18f, 0.39f, -0.73f, 0.0f, -0.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.75f, -0.8f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(17.94f, 6.06f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.6f, -1.32f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.13f, -0.29f, -0.55f, -0.29f, -0.69f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.6f, 1.32f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.32f, 0.6f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.29f, 0.13f, -0.29f, 0.55f, 0.0f, 0.69f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.32f, 0.6f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.6f, 1.32f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.13f, 0.29f, 0.55f, 0.29f, 0.69f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.6f, -1.32f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.32f, -0.6f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.29f, -0.13f, 0.29f, -0.55f, 0.0f, -0.69f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.32f, -0.6f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _photoFilter = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_PhotoFilter__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _photoFilter;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
