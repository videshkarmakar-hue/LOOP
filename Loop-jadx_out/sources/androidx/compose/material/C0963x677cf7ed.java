package androidx.compose.material;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 */
/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1", m210f = "BackdropScaffold.kt", m211i = {0}, m212l = {708}, m213m = "onPreFling-QWom1Mo", m214n = {"available"}, m215s = {"J$0"})
final class C0963x677cf7ed extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackdropScaffoldKt.C09611 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0963x677cf7ed(BackdropScaffoldKt.C09611 c09611, Continuation<? super C0963x677cf7ed> continuation) {
        super(continuation);
        this.this$0 = c09611;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo669onPreFlingQWom1Mo(0L, this);
    }
}
