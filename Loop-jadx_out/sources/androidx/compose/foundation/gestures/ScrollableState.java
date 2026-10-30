package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ScrollableState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&JA\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112'\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\u0002\b\u0016H¦@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0003"}, m195d2 = {"Landroidx/compose/foundation/gestures/ScrollableState;", "", "canScrollBackward", "", "getCanScrollBackward", "()Z", "canScrollForward", "getCanScrollForward", "isLastScrollBackward", "isLastScrollForward", "isScrollInProgress", "dispatchRawDelta", "", "delta", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface ScrollableState {
    float dispatchRawDelta(float delta);

    boolean getCanScrollBackward();

    boolean getCanScrollForward();

    boolean isLastScrollBackward();

    boolean isLastScrollForward();

    boolean isScrollInProgress();

    Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableState$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ScrollableState.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object scroll$default(ScrollableState scrollableState, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scroll");
            }
            if ((i & 1) != 0) {
                mutatePriority = MutatePriority.Default;
            }
            return scrollableState.scroll(mutatePriority, function2, continuation);
        }

        public static boolean $default$getCanScrollForward(ScrollableState _this) {
            return true;
        }

        public static boolean $default$getCanScrollBackward(ScrollableState _this) {
            return true;
        }

        public static boolean $default$isLastScrollForward(ScrollableState _this) {
            return false;
        }

        public static boolean $default$isLastScrollBackward(ScrollableState _this) {
            return false;
        }
    }

    /* JADX INFO: compiled from: ScrollableState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getCanScrollForward(ScrollableState $this) {
            return CC.$default$getCanScrollForward($this);
        }

        @Deprecated
        public static boolean getCanScrollBackward(ScrollableState $this) {
            return CC.$default$getCanScrollBackward($this);
        }

        @Deprecated
        public static boolean isLastScrollForward(ScrollableState $this) {
            return CC.$default$isLastScrollForward($this);
        }

        @Deprecated
        public static boolean isLastScrollBackward(ScrollableState $this) {
            return CC.$default$isLastScrollBackward($this);
        }
    }
}
