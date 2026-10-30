package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BringIntoViewRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m195d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "()V", "modifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "getModifiers", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector<BringIntoViewRequesterNode> modifiers = new MutableVector<>(new BringIntoViewRequesterNode[16], 0);

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 */
    /* JADX INFO: compiled from: BringIntoViewRequester.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.relocation.BringIntoViewRequesterImpl", m210f = "BringIntoViewRequester.kt", m211i = {0, 0, 0, 0}, m212l = {114}, m213m = "bringIntoView", m214n = {"rect", "content$iv", "size$iv", "i$iv"}, m215s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C06881 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06881(Continuation<? super C06881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BringIntoViewRequesterImpl.this.bringIntoView(null, this);
        }
    }

    public final MutableVector<BringIntoViewRequesterNode> getModifiers() {
        return this.modifiers;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0071 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    /* JADX WARN: Code duplicated, block: B:22:0x0078  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0072 -> B:20:0x0073). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    public java.lang.Object bringIntoView(androidx.compose.p001ui.geometry.Rect r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.C06881
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.C06881) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r13)
        L19:
            r13 = r0
            java.lang.Object r0 = r13.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r13.label
            r3 = 1
            switch(r2) {
                case 0: goto L41;
                case 1: goto L2f;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L2f:
            r12 = 0
            r2 = 0
            int r4 = r13.I$1
            int r5 = r13.I$0
            java.lang.Object r6 = r13.L$1
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            java.lang.Object r7 = r13.L$0
            androidx.compose.ui.geometry.Rect r7 = (androidx.compose.p001ui.geometry.Rect) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L73
        L41:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r11
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.relocation.BringIntoViewRequesterNode> r2 = r2.modifiers
            r4 = 0
            int r5 = r2.getSize()
            if (r5 <= 0) goto L79
            r6 = 0
            java.lang.Object[] r7 = r2.getContent()
            r10 = r7
            r7 = r12
            r12 = r4
            r4 = r6
            r6 = r10
        L59:
            r2 = r6[r4]
            androidx.compose.foundation.relocation.BringIntoViewRequesterNode r2 = (androidx.compose.foundation.relocation.BringIntoViewRequesterNode) r2
            r8 = 0
            r9 = r2
            androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.p001ui.node.DelegatableNode) r9
            r13.L$0 = r7
            r13.L$1 = r6
            r13.I$0 = r5
            r13.I$1 = r4
            r13.label = r3
            java.lang.Object r2 = androidx.compose.foundation.relocation.ScrollIntoView.scrollIntoView(r9, r7, r13)
            if (r2 != r1) goto L72
            return r1
        L72:
            r2 = r8
        L73:
            int r4 = r4 + r3
            if (r4 < r5) goto L59
            r4 = r12
        L79:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.bringIntoView(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
