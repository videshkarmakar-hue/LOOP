package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SnapshotDoubleState.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n¨\u0006\f"}, m195d2 = {"mutableDoubleStateOf", "Landroidx/compose/runtime/MutableDoubleState;", DownloadUtil.CookieScheme.VALUE, "", "getValue", "Landroidx/compose/runtime/DoubleState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime_release"}, m196k = 5, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, m200xs = "androidx/compose/runtime/SnapshotDoubleStateKt")
final /* synthetic */ class SnapshotDoubleStateKt__SnapshotDoubleStateKt {
    public static final MutableDoubleState mutableDoubleStateOf(double value) {
        return ActualAndroid_androidKt.createSnapshotMutableDoubleState(value);
    }

    public static final double getValue(DoubleState $this$getValue, Object thisObj, KProperty<?> kProperty) {
        return $this$getValue.getDoubleValue();
    }

    public static final void setValue(MutableDoubleState $this$setValue, Object thisObj, KProperty<?> kProperty, double value) {
        $this$setValue.setDoubleValue(value);
    }
}
