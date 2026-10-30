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

/* JADX INFO: compiled from: Sync.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_sync", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Sync", "Landroidx/compose/material/icons/Icons$Rounded;", "getSync", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SyncKt {
    private static ImageVector _sync;

    public static final ImageVector getSync(Icons.Rounded $this$Sync) {
        if (_sync != null) {
            ImageVector imageVector = _sync;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Sync__u24lambda_u241 = new ImageVector.Builder("Rounded.Sync", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 2.21f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.8f, 2.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0.0f, 0.71f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.79f, 2.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.32f, 0.31f, 0.86f, 0.09f, 0.86f, -0.36f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(3.31f, 0.0f, 6.0f, 2.69f, 6.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.79f, -0.15f, 1.56f, -0.44f, 2.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.15f, 0.36f, -0.04f, 0.77f, 0.23f, 1.04f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.51f, 0.51f, 1.37f, 0.33f, 1.64f, -0.34f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.37f, -0.91f, 0.57f, -1.91f, 0.57f, -2.95f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -4.42f, -3.58f, -8.0f, -8.0f, -8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-3.31f, 0.0f, -6.0f, -2.69f, -6.0f, -6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.79f, 0.15f, -1.56f, 0.44f, -2.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.15f, -0.36f, 0.04f, -0.77f, -0.23f, -1.04f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.51f, -0.51f, -1.37f, -0.33f, -1.64f, 0.34f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(4.2f, 9.96f, 4.0f, 10.96f, 4.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 4.42f, 3.58f, 8.0f, 8.0f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(1.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.79f, -2.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0.0f, -0.71f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.79f, -2.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.31f, -0.31f, -0.85f, -0.09f, -0.85f, 0.36f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _sync = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Sync__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _sync;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
