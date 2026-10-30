package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m195d2 = {"androidx/compose/material3/ExitAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExitAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitAlwaysScrollBehavior this$0;

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

    ExitAlwaysScrollBehavior$nestedScrollConnection$1(ExitAlwaysScrollBehavior $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo668onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }
        BottomAppBarState state = this.this$0.getState();
        state.setContentOffset(state.getContentOffset() + Offset.m4050getYimpl(consumed));
        if (this.this$0.getState().getHeightOffset() == 0.0f) {
            if ((Offset.m4050getYimpl(consumed) == 0.0f) && Offset.m4050getYimpl(available) > 0.0f) {
                this.this$0.getState().setContentOffset(0.0f);
            }
        } else {
            if (this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit()) {
                if (Offset.m4050getYimpl(consumed) == 0.0f) {
                    this.this$0.getState().setContentOffset(0.0f);
                }
            }
        }
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m4050getYimpl(consumed));
        return Offset.INSTANCE.m4065getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0083 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo667onPostFlingRZ2iAVY(long consumed, long j, Continuation<? super Velocity> continuation) {
        ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        ExitAlwaysScrollBehavior$nestedScrollConnection$1 exitAlwaysScrollBehavior$nestedScrollConnection$1;
        long available;
        Object objM5385onPostFlingRZ2iAVY$suspendImpl;
        long packedValue;
        Object obj;
        if (continuation instanceof ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            if ((exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
            }
        } else {
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
        }
        ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object $result = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                exitAlwaysScrollBehavior$nestedScrollConnection$1 = this;
                available = j;
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.L$0 = exitAlwaysScrollBehavior$nestedScrollConnection$1;
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = available;
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 1;
                objM5385onPostFlingRZ2iAVY$suspendImpl = NestedScrollConnection.CC.m5385onPostFlingRZ2iAVY$suspendImpl(exitAlwaysScrollBehavior$nestedScrollConnection$1, consumed, available, exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2);
                if (objM5385onPostFlingRZ2iAVY$suspendImpl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                packedValue = ((Velocity) objM5385onPostFlingRZ2iAVY$suspendImpl).getPackedValue();
                BottomAppBarState state = exitAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getState();
                float fM7043getYimpl = Velocity.m7043getYimpl(available);
                DecayAnimationSpec<Float> flingAnimationSpec = exitAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
                AnimationSpec<Float> snapAnimationSpec = exitAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.L$0 = null;
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = packedValue;
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 2;
                obj = AppBarKt.settleAppBarBottom(state, fM7043getYimpl, flingAnimationSpec, snapAnimationSpec, exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(packedValue, ((Velocity) obj).getPackedValue()));
            case 1:
                available = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
                ExitAlwaysScrollBehavior$nestedScrollConnection$1 exitAlwaysScrollBehavior$nestedScrollConnection$2 = (ExitAlwaysScrollBehavior$nestedScrollConnection$1) exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.L$0;
                ResultKt.throwOnFailure($result);
                exitAlwaysScrollBehavior$nestedScrollConnection$1 = exitAlwaysScrollBehavior$nestedScrollConnection$2;
                objM5385onPostFlingRZ2iAVY$suspendImpl = $result;
                packedValue = ((Velocity) objM5385onPostFlingRZ2iAVY$suspendImpl).getPackedValue();
                BottomAppBarState state2 = exitAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getState();
                float fM7043getYimpl2 = Velocity.m7043getYimpl(available);
                DecayAnimationSpec<Float> flingAnimationSpec2 = exitAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getFlingAnimationSpec();
                AnimationSpec<Float> snapAnimationSpec2 = exitAlwaysScrollBehavior$nestedScrollConnection$1.this$0.getSnapAnimationSpec();
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.L$0 = null;
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = packedValue;
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 2;
                obj = AppBarKt.settleAppBarBottom(state2, fM7043getYimpl2, flingAnimationSpec2, snapAnimationSpec2, exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(packedValue, ((Velocity) obj).getPackedValue()));
            case 2:
                long j2 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
                ResultKt.throwOnFailure($result);
                packedValue = j2;
                obj = $result;
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(packedValue, ((Velocity) obj).getPackedValue()));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
