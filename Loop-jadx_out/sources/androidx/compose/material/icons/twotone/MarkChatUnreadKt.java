package androidx.compose.material.icons.twotone;

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

/* JADX INFO: compiled from: MarkChatUnread.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_markChatUnread", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkChatUnread", "Landroidx/compose/material/icons/Icons$TwoTone;", "getMarkChatUnread", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MarkChatUnreadKt {
    private static ImageVector _markChatUnread;

    public static final ImageVector getMarkChatUnread(Icons.TwoTone $this$MarkChatUnread) {
        if (_markChatUnread != null) {
            ImageVector imageVector = _markChatUnread;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_MarkChatUnread__u24lambda_u242 = new ImageVector.Builder("TwoTone.MarkChatUnread", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(4.0f, 16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(7.9f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(19.68f, 7.96f, 19.34f, 8.0f, 19.0f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-2.42f, 0.0f, -4.44f, -1.72f, -4.9f, -4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_MarkChatUnread__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 0.3f, null, 0.3f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(20.0f, 7.9f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.74f, -0.15f, 1.42f, -0.48f, 2.0f, -0.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineTo(16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-4.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -1.1f, 0.9f, -2.0f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(10.1f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(14.04f, 2.32f, 14.0f, 2.66f, 14.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(0.04f, 0.68f, 0.1f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineTo(7.9f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(16.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, 1.66f, 1.34f, 3.0f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(3.0f, -1.34f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(-1.34f, -3.0f, -3.0f, -3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveTo(16.0f, 1.34f, 16.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        _markChatUnread = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_MarkChatUnread__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _markChatUnread;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
