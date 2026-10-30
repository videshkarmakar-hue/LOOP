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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Backspace.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m195d2 = {"_backspace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Backspace", "Landroidx/compose/material/icons/Icons$Sharp;", "getBackspace$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getBackspace", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BackspaceKt {
    private static ImageVector _backspace;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Sharp.Backspace", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Sharp.Backspace", imports = {"androidx.compose.material.icons.automirrored.sharp.Backspace"}))
    public static /* synthetic */ void getBackspace$annotations(Icons.Sharp sharp) {
    }

    public static final ImageVector getBackspace(Icons.Sharp $this$Backspace) {
        if (_backspace != null) {
            ImageVector imageVector = _backspace;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Backspace__u24lambda_u241 = new ImageVector.Builder("Sharp.Backspace", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(24.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-6.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(6.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(24.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.0f, 15.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.59f, 17.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(14.0f, 13.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(10.41f, 17.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(9.0f, 15.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.59f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(9.0f, 8.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(10.41f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(14.0f, 10.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.59f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.0f, 8.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(15.41f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.0f, 15.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _backspace = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_Backspace__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _backspace;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
