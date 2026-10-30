package androidx.compose.foundation.layout;

import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"Landroidx/compose/foundation/layout/DoNothingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "()V", "foundation-layout_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class DoNothingNestedScrollConnection implements NestedScrollConnection {
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public /* synthetic */ Object mo667onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return NestedScrollConnection.CC.m5385onPostFlingRZ2iAVY$suspendImpl(this, j, j2, continuation);
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public /* synthetic */ long mo668onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollConnection.CC.m5378$default$onPostScrollDzOQY0M(this, j, j2, i);
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public /* synthetic */ Object mo669onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m5386onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public /* synthetic */ long mo670onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.CC.m5380$default$onPreScrollOzD1aCk(this, j, i);
    }

    private DoNothingNestedScrollConnection() {
    }
}
