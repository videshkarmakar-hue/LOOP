package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.caverock.androidsvg.SVGParser;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0001\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0004H\u0002\u001a\f\u0010\u0010\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"NoOpScrollConnection", "androidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1", "Landroidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1;", "Unmeasured", "", "toNestedScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "(I)I", "layoutAccordingTo", "", "Landroid/view/View;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "toComposeOffset", "", "toComposeVelocity", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidViewHolder_androidKt {
    private static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 NoOpScrollConnection = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder_androidKt$NoOpScrollConnection$1
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public /* synthetic */ Object mo419onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
            return NestedScrollConnection.CC.m5137onPostFlingRZ2iAVY$suspendImpl(this, j, j2, continuation);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public /* synthetic */ long mo420onPostScrollDzOQY0M(long j, long j2, int i) {
            return NestedScrollConnection.CC.m5130$default$onPostScrollDzOQY0M(this, j, j2, i);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        public /* synthetic */ Object mo421onPreFlingQWom1Mo(long j, Continuation continuation) {
            return NestedScrollConnection.CC.m5138onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public /* synthetic */ long mo422onPreScrollOzD1aCk(long j, int i) {
            return NestedScrollConnection.CC.m5132$default$onPreScrollOzD1aCk(this, j, i);
        }
    };
    private static final int Unmeasured = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutAccordingTo(View $this$layoutAccordingTo, LayoutNode layoutNode) {
        long position = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        float $this$fastRoundToInt$iv = Offset.m3801getXimpl(position);
        int x = Math.round($this$fastRoundToInt$iv);
        float $this$fastRoundToInt$iv2 = Offset.m3802getYimpl(position);
        int y = Math.round($this$fastRoundToInt$iv2);
        $this$layoutAccordingTo.layout(x, y, $this$layoutAccordingTo.getMeasuredWidth() + x, $this$layoutAccordingTo.getMeasuredHeight() + y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeOffset(int $this$toComposeOffset) {
        return $this$toComposeOffset * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeVelocity(float $this$toComposeVelocity) {
        return (-1.0f) * $this$toComposeVelocity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toNestedScrollSource(int type) {
        return type == 0 ? NestedScrollSource.INSTANCE.m5155getDragWNlRxjI() : NestedScrollSource.INSTANCE.m5156getFlingWNlRxjI();
    }
}
