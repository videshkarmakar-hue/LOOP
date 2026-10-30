package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m195d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    private boolean enabled;
    private final ScrollingLogic scrollingLogic;

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public /* synthetic */ Object mo669onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m5386onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public /* synthetic */ long mo670onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.CC.m5380$default$onPreScrollOzD1aCk(this, j, i);
    }

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean enabled) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = enabled;
    }

    public final ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo668onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.enabled) {
            return this.scrollingLogic.m677performRawScrollMKHz9U(available);
        }
        return Offset.INSTANCE.m4065getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object mo667onPostFlingRZ2iAVY(long j, long available, Continuation<? super Velocity> continuation) {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        long available2;
        Object objM675doFlingAnimationQWom1Mo;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            if ((scrollableNestedScrollConnection$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
            }
        } else {
            scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
        }
        Object $result = scrollableNestedScrollConnection$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (scrollableNestedScrollConnection$onPostFling$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.enabled) {
                    ScrollingLogic scrollingLogic = this.scrollingLogic;
                    scrollableNestedScrollConnection$onPostFling$1.J$0 = available;
                    scrollableNestedScrollConnection$onPostFling$1.label = 1;
                    objM675doFlingAnimationQWom1Mo = scrollingLogic.m675doFlingAnimationQWom1Mo(available, scrollableNestedScrollConnection$onPostFling$1);
                    if (objM675doFlingAnimationQWom1Mo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    long velocityLeft = ((Velocity) objM675doFlingAnimationQWom1Mo).getPackedValue();
                    available2 = Velocity.m7045minusAH228Gc(available, velocityLeft);
                } else {
                    available2 = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                }
                return Velocity.m7033boximpl(available2);
            case 1:
                available = scrollableNestedScrollConnection$onPostFling$1.J$0;
                ResultKt.throwOnFailure($result);
                objM675doFlingAnimationQWom1Mo = $result;
                long velocityLeft2 = ((Velocity) objM675doFlingAnimationQWom1Mo).getPackedValue();
                available2 = Velocity.m7045minusAH228Gc(available, velocityLeft2);
                return Velocity.m7033boximpl(available2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
