package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SnapshotFloatState.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt"}, m196k = 4, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PrimitiveSnapshotStateKt {
    public static final float getValue(FloatState $this$getValue, Object thisObj, KProperty<?> kProperty) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue($this$getValue, thisObj, kProperty);
    }

    public static final MutableFloatState mutableFloatStateOf(float value) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(value);
    }

    public static final void setValue(MutableFloatState $this$setValue, Object thisObj, KProperty<?> kProperty, float value) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue($this$setValue, thisObj, kProperty, value);
    }
}
