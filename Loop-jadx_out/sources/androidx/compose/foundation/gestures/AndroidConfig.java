package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.PointerEvent;
import androidx.compose.p001ui.input.pointer.PointerInputChange;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidScrollable.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m195d2 = {"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "()V", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/Density;", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* JADX INFO: renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo584calculateMouseWheelScroll8xgXZGE(Density $this$calculateMouseWheelScroll_u2d8xgXZGE, PointerEvent event, long bounds) {
        List<PointerInputChange> changes = event.getChanges();
        Offset offsetM4038boximpl = Offset.m4038boximpl(Offset.INSTANCE.m4065getZeroF1C5BW0());
        Offset offsetM4038boximpl2 = offsetM4038boximpl;
        int index$iv$iv = 0;
        int size = changes.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = changes.get(index$iv$iv);
            PointerInputChange c = (PointerInputChange) item$iv$iv;
            long acc = offsetM4038boximpl2.getPackedValue();
            offsetM4038boximpl2 = Offset.m4038boximpl(Offset.m4054plusMKHz9U(acc, c.getScrollDelta()));
            index$iv$iv++;
            changes = changes;
            offsetM4038boximpl = offsetM4038boximpl;
        }
        return Offset.m4056timestuRUvjQ(offsetM4038boximpl2.getPackedValue(), -$this$calculateMouseWheelScroll_u2d8xgXZGE.mo567toPx0680j_4(C1979Dp.m6801constructorimpl(64)));
    }
}
