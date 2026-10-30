package androidx.compose.p001ui.graphics;

import android.graphics.Canvas;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidVertexMode.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0005"}, m195d2 = {"toAndroidVertexMode", "Landroid/graphics/Canvas$VertexMode;", "Landroidx/compose/ui/graphics/VertexMode;", "toAndroidVertexMode-JOOmi9M", "(I)Landroid/graphics/Canvas$VertexMode;", "ui-graphics_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidVertexMode_androidKt {
    /* JADX INFO: renamed from: toAndroidVertexMode-JOOmi9M, reason: not valid java name */
    public static final Canvas.VertexMode m4197toAndroidVertexModeJOOmi9M(int $this$toAndroidVertexMode_u2dJOOmi9M) {
        if (VertexMode.m4694equalsimpl0($this$toAndroidVertexMode_u2dJOOmi9M, VertexMode.INSTANCE.m4700getTrianglesc2xauaI())) {
            return Canvas.VertexMode.TRIANGLES;
        }
        if (VertexMode.m4694equalsimpl0($this$toAndroidVertexMode_u2dJOOmi9M, VertexMode.INSTANCE.m4699getTriangleStripc2xauaI())) {
            return Canvas.VertexMode.TRIANGLE_STRIP;
        }
        return VertexMode.m4694equalsimpl0($this$toAndroidVertexMode_u2dJOOmi9M, VertexMode.INSTANCE.m4698getTriangleFanc2xauaI()) ? Canvas.VertexMode.TRIANGLE_FAN : Canvas.VertexMode.TRIANGLES;
    }
}
