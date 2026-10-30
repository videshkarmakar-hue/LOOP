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

/* JADX INFO: compiled from: QuestionAnswer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m195d2 = {"_questionAnswer", "Landroidx/compose/ui/graphics/vector/ImageVector;", "QuestionAnswer", "Landroidx/compose/material/icons/Icons$TwoTone;", "getQuestionAnswer", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class QuestionAnswerKt {
    private static ImageVector _questionAnswer;

    public static final ImageVector getQuestionAnswer(Icons.TwoTone $this$QuestionAnswer) {
        if (_questionAnswer != null) {
            ImageVector imageVector = _questionAnswer;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_QuestionAnswer__u24lambda_u242 = new ImageVector.Builder("TwoTone.QuestionAnswer", C1979Dp.m6801constructorimpl(24.0f), C1979Dp.m6801constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(15.0f, 11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineTo(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(8.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.59f, -0.58f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.58f, -0.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_QuestionAnswer__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 0.3f, null, 0.3f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m4652getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m4662getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(21.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(6.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(4.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(22.0f, 7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(16.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(17.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(3.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(4.0f, -4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(4.59f, 11.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-0.59f, 0.58f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(4.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(7.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(5.17f, 11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-0.58f, 0.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        _questionAnswer = ImageVector.Builder.m4995addPathoIyEayM$default($this$_get_QuestionAnswer__u24lambda_u242, $this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), pathFillType$iv2, "", fill$iv$iv2, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv2, strokeLineJoin$iv$iv2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _questionAnswer;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
