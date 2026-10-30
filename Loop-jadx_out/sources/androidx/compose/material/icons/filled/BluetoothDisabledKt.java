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

/* JADX INFO: compiled from: BluetoothDisabled.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_bluetoothDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BluetoothDisabled", "Landroidx/compose/material/icons/Icons$Filled;", "getBluetoothDisabled", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BluetoothDisabledKt {
    private static ImageVector _bluetoothDisabled;

    public static final ImageVector getBluetoothDisabled(Icons.Filled $this$BluetoothDisabled) {
        if (_bluetoothDisabled != null) {
            ImageVector imageVector = _bluetoothDisabled;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_BluetoothDisabled__u24lambda_u241 = new ImageVector.Builder("Filled.BluetoothDisabled", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(13.0f, 5.83f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.88f, 1.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.6f, 1.6f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.41f, 1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(3.02f, -3.02f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(5.03f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-3.2f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(5.41f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.0f, 5.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(10.59f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.0f, 17.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.41f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(11.0f, 14.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(4.29f, -4.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.3f, 2.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(20.0f, 18.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.41f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(13.0f, 18.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-3.76f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.88f, 1.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(13.0f, 18.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _bluetoothDisabled = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_BluetoothDisabled__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _bluetoothDisabled;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
