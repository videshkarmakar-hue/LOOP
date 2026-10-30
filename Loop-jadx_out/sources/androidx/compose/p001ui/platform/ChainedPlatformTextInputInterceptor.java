package androidx.compose.p001ui.platform;

import androidx.compose.p001ui.SessionMutex;
import androidx.compose.p001ui.node.Owner;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005J?\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112'\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\u0002\b\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0003R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m195d2 = {"Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "", "initialInterceptor", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "parent", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;)V", "<set-?>", "interceptor", "getInterceptor", "()Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "setInterceptor", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;)V", "interceptor$delegate", "Landroidx/compose/runtime/MutableState;", "textInputSession", "", "owner", "Landroidx/compose/ui/node/Owner;", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/node/Owner;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInterceptor", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ChainedPlatformTextInputInterceptor {

    /* JADX INFO: renamed from: interceptor$delegate, reason: from kotlin metadata */
    private final MutableState interceptor;
    private final ChainedPlatformTextInputInterceptor parent;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1 */
    /* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor", m210f = "PlatformTextInputModifierNode.kt", m211i = {}, m212l = {225}, m213m = "textInputSession", m214n = {}, m215s = {})
    static final class C18661 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C18661(Continuation<? super C18661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChainedPlatformTextInputInterceptor.this.textInputSession(null, null, this);
        }
    }

    public ChainedPlatformTextInputInterceptor(PlatformTextInputInterceptor initialInterceptor, ChainedPlatformTextInputInterceptor parent) {
        this.parent = parent;
        this.interceptor = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialInterceptor, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlatformTextInputInterceptor getInterceptor() {
        State $this$getValue$iv = this.interceptor;
        return (PlatformTextInputInterceptor) $this$getValue$iv.getValue();
    }

    private final void setInterceptor(PlatformTextInputInterceptor platformTextInputInterceptor) {
        MutableState $this$setValue$iv = this.interceptor;
        $this$setValue$iv.setValue(platformTextInputInterceptor);
    }

    public final void updateInterceptor(PlatformTextInputInterceptor interceptor) {
        setInterceptor(interceptor);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object textInputSession(Owner owner, Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        C18661 c18661;
        if (continuation instanceof C18661) {
            c18661 = (C18661) continuation;
            if ((c18661.label & Integer.MIN_VALUE) != 0) {
                c18661.label -= Integer.MIN_VALUE;
            } else {
                c18661 = new C18661(continuation);
            }
        } else {
            c18661 = new C18661(continuation);
        }
        C18661 c18662 = c18661;
        Object $result = c18662.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c18662.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor = this.parent;
                C18672 c18672 = new C18672(function2, this, null);
                c18662.label = 1;
                if (PlatformTextInputModifierNodeKt.interceptedTextInputSession(owner, chainedPlatformTextInputInterceptor, c18672, c18662) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2 */
    /* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2", m210f = "PlatformTextInputModifierNode.kt", m211i = {}, m212l = {248}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C18672 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {
        final /* synthetic */ Function2<PlatformTextInputSessionScope, Continuation<?>, Object> $session;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChainedPlatformTextInputInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C18672(Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor, Continuation<? super C18672> continuation) {
            super(2, continuation);
            this.$session = function2;
            this.this$0 = chainedPlatformTextInputInterceptor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18672 c18672 = new C18672(this.$session, this.this$0, continuation);
            c18672.L$0 = obj;
            return c18672;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, Continuation<?> continuation) {
            return ((C18672) create(platformTextInputSessionScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PlatformTextInputSessionScope parentSession = (PlatformTextInputSessionScope) this.L$0;
                    AtomicReference inputMethodMutex = SessionMutex.m3911constructorimpl();
                    ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1 scope = new ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1(parentSession, inputMethodMutex, this.this$0);
                    Function2<PlatformTextInputSessionScope, Continuation<?>, Object> function2 = this.$session;
                    this.label = 1;
                    if (function2.invoke(scope, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }
}
