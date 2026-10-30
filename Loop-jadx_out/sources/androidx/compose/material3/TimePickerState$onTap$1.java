package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material3.TimePickerState", m210f = "TimePicker.kt", m211i = {0, 0, 0, 0, 0, 1, 1}, m212l = {744, 752, 753, 756}, m213m = "onTap$material3_release", m214n = {"this", "x", "y", "maxDist", "autoSwitchToMinute", "this", "targetValue"}, m215s = {"L$0", "F$0", "F$1", "F$2", "Z$0", "L$0", "L$1"})
final class TimePickerState$onTap$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    float F$2;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TimePickerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimePickerState$onTap$1(TimePickerState timePickerState, Continuation<? super TimePickerState$onTap$1> continuation) {
        super(continuation);
        this.this$0 = timePickerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onTap$material3_release(0.0f, 0.0f, 0.0f, false, this);
    }
}
