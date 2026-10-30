package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.p001ui.focus.FocusRequester;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1", m210f = "CoreTextField.kt", m211i = {}, m212l = {1223}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class CoreTextFieldKt$CoreTextField$pointerModifier$3$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ LegacyPlatformTextInputServiceAdapter $legacyTextInputServiceAdapter;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ LegacyTextFieldState $state;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$pointerModifier$3$1(boolean z, boolean z2, LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter, Continuation<? super CoreTextFieldKt$CoreTextField$pointerModifier$3$1> continuation) {
        super(2, continuation);
        this.$enabled = z;
        this.$readOnly = z2;
        this.$state = legacyTextFieldState;
        this.$focusRequester = focusRequester;
        this.$legacyTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoreTextFieldKt$CoreTextField$pointerModifier$3$1 coreTextFieldKt$CoreTextField$pointerModifier$3$1 = new CoreTextFieldKt$CoreTextField$pointerModifier$3$1(this.$enabled, this.$readOnly, this.$state, this.$focusRequester, this.$legacyTextInputServiceAdapter, continuation);
        coreTextFieldKt$CoreTextField$pointerModifier$3$1.L$0 = obj;
        return coreTextFieldKt$CoreTextField$pointerModifier$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$pointerModifier$3$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        CoreTextFieldKt$CoreTextField$pointerModifier$3$1 coreTextFieldKt$CoreTextField$pointerModifier$3$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$detectStylusHandwriting$iv = (PointerInputScope) this.L$0;
                if (this.$enabled && !this.$readOnly) {
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture($this$detectStylusHandwriting$iv, new C0729x8b2642ff(null, this.$state, this.$focusRequester, this.$legacyTextInputServiceAdapter), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coreTextFieldKt$CoreTextField$pointerModifier$3$1 = this;
                }
                return Unit.INSTANCE;
            case 1:
                coreTextFieldKt$CoreTextField$pointerModifier$3$1 = this;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
