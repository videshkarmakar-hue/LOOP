package androidx.compose.p001ui.input.nestedscroll;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface NestedScrollConnection {
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    Object mo667onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation);

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    long mo668onPostScrollDzOQY0M(long consumed, long available, int source);

    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    Object mo669onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation);

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    long mo670onPreScrollOzD1aCk(long available, int source);

    /* JADX INFO: renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollConnection$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: NestedScrollModifier.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m5380$default$onPreScrollOzD1aCk(NestedScrollConnection _this, long available, int source) {
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }

        /* JADX INFO: renamed from: $default$onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m5378$default$onPostScrollDzOQY0M(NestedScrollConnection _this, long consumed, long available, int source) {
            return Offset.INSTANCE.m4065getZeroF1C5BW0();
        }

        /* JADX INFO: renamed from: onPreFling-QWom1Mo$suspendImpl, reason: not valid java name */
        public static /* synthetic */ Object m5386onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection $this, long available, Continuation<? super Velocity> continuation) {
            return Velocity.m7033boximpl(Velocity.INSTANCE.m7053getZero9UxMQ8M());
        }

        /* JADX INFO: renamed from: onPostFling-RZ2iAVY$suspendImpl, reason: not valid java name */
        public static /* synthetic */ Object m5385onPostFlingRZ2iAVY$suspendImpl(NestedScrollConnection $this, long consumed, long available, Continuation<? super Velocity> continuation) {
            return Velocity.m7033boximpl(Velocity.INSTANCE.m7053getZero9UxMQ8M());
        }
    }

    /* JADX INFO: compiled from: NestedScrollModifier.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m5390onPreScrollOzD1aCk(NestedScrollConnection $this, long available, int source) {
            return CC.m5380$default$onPreScrollOzD1aCk($this, available, source);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m5388onPostScrollDzOQY0M(NestedScrollConnection $this, long consumed, long available, int source) {
            return CC.m5378$default$onPostScrollDzOQY0M($this, consumed, available, source);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m5389onPreFlingQWom1Mo(NestedScrollConnection $this, long available, Continuation<? super Velocity> continuation) {
            return CC.m5386onPreFlingQWom1Mo$suspendImpl($this, available, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m5387onPostFlingRZ2iAVY(NestedScrollConnection $this, long consumed, long available, Continuation<? super Velocity> continuation) {
            return CC.m5385onPostFlingRZ2iAVY$suspendImpl($this, consumed, available, continuation);
        }
    }
}
