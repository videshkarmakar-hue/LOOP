package androidx.compose.material;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 */
/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", m210f = "Drawer.kt", m211i = {0}, m212l = {901}, m213m = "onPostFling-RZ2iAVY", m214n = {"available"}, m215s = {"J$0"})
final class C1007x1c3b93eb extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DrawerKt.C10061 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1007x1c3b93eb(DrawerKt.C10061 c10061, Continuation<? super C1007x1c3b93eb> continuation) {
        super(continuation);
        this.this$0 = c10061;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo667onPostFlingRZ2iAVY(0L, 0L, this);
    }
}
