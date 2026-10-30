package com.google.accompanist.pager;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Pager.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, m195d2 = {"Lcom/google/accompanist/pager/ConsumeFlingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "consumeHorizontal", "", "consumeVertical", "pagerState", "Lcom/google/accompanist/pager/PagerState;", "(ZZLcom/google/accompanist/pager/PagerState;)V", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "pager_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ConsumeFlingNestedScrollConnection implements NestedScrollConnection {
    private final boolean consumeHorizontal;
    private final boolean consumeVertical;
    private final PagerState pagerState;

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

    public ConsumeFlingNestedScrollConnection(boolean consumeHorizontal, boolean consumeVertical, PagerState pagerState) {
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        this.consumeHorizontal = consumeHorizontal;
        this.consumeVertical = consumeVertical;
        this.pagerState = pagerState;
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo668onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m5398equalsimpl0(source, NestedScrollSource.INSTANCE.m5404getFlingWNlRxjI())) {
            return Pager.m7174consume9KIMszo(available, this.consumeHorizontal, this.consumeVertical);
        }
        return Offset.INSTANCE.m4065getZeroF1C5BW0();
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo667onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
        long jM7175consumeBMRW4eQ;
        if (this.pagerState.getCurrentPageOffset() == 0.0f) {
            jM7175consumeBMRW4eQ = Pager.m7175consumeBMRW4eQ(available, this.consumeHorizontal, this.consumeVertical);
        } else {
            jM7175consumeBMRW4eQ = Velocity.INSTANCE.m7053getZero9UxMQ8M();
        }
        return Velocity.m7033boximpl(jM7175consumeBMRW4eQ);
    }
}
