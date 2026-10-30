package androidx.compose.material;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 */
/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", m210f = "ModalBottomSheet.kt", m211i = {0}, m212l = {580}, m213m = "onPreFling-QWom1Mo", m214n = {"available"}, m215s = {"J$0"})
final class C1052x8819a6ee extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModalBottomSheetKt.C10501 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1052x8819a6ee(ModalBottomSheetKt.C10501 c10501, Continuation<? super C1052x8819a6ee> continuation) {
        super(continuation);
        this.this$0 = c10501;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo669onPreFlingQWom1Mo(0L, this);
    }
}
