package androidx.compose.foundation.lazy.layout;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AwaitFirstLayoutModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "", "wasPositioned", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    public static final int $stable = 0;
    private Continuation<? super Unit> continuation;
    private boolean wasPositioned;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 */
    /* JADX INFO: compiled from: AwaitFirstLayoutModifier.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier", m210f = "AwaitFirstLayoutModifier.kt", m211i = {0, 0}, m212l = {35}, m213m = "waitForFirstLayout", m214n = {"this", "oldContinuation"}, m215s = {"L$0", "L$1"})
    static final class C06061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06061(Continuation<? super C06061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitFirstLayoutModifier.this.waitForFirstLayout(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    @Override // androidx.compose.p001ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0074  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object waitForFirstLayout(Continuation<? super Unit> continuation) throws Throwable {
        C06061 c06061;
        Continuation<? super Unit> continuation2;
        if (continuation instanceof C06061) {
            c06061 = (C06061) continuation;
            if ((c06061.label & Integer.MIN_VALUE) != 0) {
                c06061.label -= Integer.MIN_VALUE;
            } else {
                c06061 = new C06061(continuation);
            }
        } else {
            c06061 = new C06061(continuation);
        }
        C06061 c06062 = c06061;
        Object $result = c06062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c06062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.wasPositioned) {
                    Continuation<? super Unit> continuation3 = this.continuation;
                    c06062.L$0 = this;
                    c06062.L$1 = continuation3;
                    c06062.label = 1;
                    SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c06062));
                    SafeContinuation it = safeContinuation;
                    this.continuation = it;
                    Object orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c06062);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    continuation2 = continuation3;
                    if (continuation2 != null) {
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
                    }
                }
                return Unit.INSTANCE;
            case 1:
                continuation2 = (Continuation) c06062.L$1;
                ResultKt.throwOnFailure($result);
                if (continuation2 != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.compose.p001ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        if (!this.wasPositioned) {
            this.wasPositioned = true;
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m7693constructorimpl(Unit.INSTANCE));
            }
            this.continuation = null;
        }
    }
}
