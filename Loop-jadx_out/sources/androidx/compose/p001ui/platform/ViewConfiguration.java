package androidx.compose.p001ui.platform;

import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.DpKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewConfiguration.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0012\u0010\u0013\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0003"}, m195d2 = {"Landroidx/compose/ui/platform/ViewConfiguration;", "", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "handwritingSlop", "", "getHandwritingSlop", "()F", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "maximumFlingVelocity", "getMaximumFlingVelocity", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "touchSlop", "getTouchSlop", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface ViewConfiguration {
    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    float getHandwritingSlop();

    long getLongPressTimeoutMillis();

    float getMaximumFlingVelocity();

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo5799getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ViewConfiguration$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ViewConfiguration.kt */
    public final /* synthetic */ class CC {
        public static float $default$getHandwritingSlop(ViewConfiguration _this) {
            return 2.0f;
        }

        /* JADX INFO: renamed from: $default$getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m6037$default$getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration _this) {
            return DpKt.m6823DpSizeYgX7TsA(C1979Dp.m6801constructorimpl(48), C1979Dp.m6801constructorimpl(48));
        }

        public static float $default$getMaximumFlingVelocity(ViewConfiguration _this) {
            return Float.MAX_VALUE;
        }
    }

    /* JADX INFO: compiled from: ViewConfiguration.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        @Deprecated
        public static float getHandwritingSlop(ViewConfiguration $this) {
            return CC.$default$getHandwritingSlop($this);
        }

        @Deprecated
        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m6039getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration $this) {
            return CC.m6037$default$getMinimumTouchTargetSizeMYxV2XQ($this);
        }

        @Deprecated
        public static float getMaximumFlingVelocity(ViewConfiguration $this) {
            return CC.$default$getMaximumFlingVelocity($this);
        }
    }
}
