package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.p001ui.focus.FocusRequester;
import androidx.compose.p001ui.input.pointer.AwaitPointerEventScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1$invokeSuspend$$inlined$detectStylusHandwriting$1 */
/* JADX INFO: compiled from: StylusHandwriting.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "androidx/compose/foundation/text/handwriting/StylusHandwritingKt$detectStylusHandwriting$2"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1$invokeSuspend$$inlined$detectStylusHandwriting$1", m210f = "CoreTextField.kt", m211i = {0, 1, 1, 2, 2}, m212l = {39, 50, 78}, m213m = "invokeSuspend", m214n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "firstDown", "$this$awaitEachGesture", "firstDown"}, m215s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
public final class C0729x8b2642ff extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester$inlined;
    final /* synthetic */ LegacyPlatformTextInputServiceAdapter $legacyTextInputServiceAdapter$inlined;
    final /* synthetic */ LegacyTextFieldState $state$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0729x8b2642ff(Continuation continuation, LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
        super(2, continuation);
        this.$state$inlined = legacyTextFieldState;
        this.$focusRequester$inlined = focusRequester;
        this.$legacyTextInputServiceAdapter$inlined = legacyPlatformTextInputServiceAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C0729x8b2642ff c0729x8b2642ff = new C0729x8b2642ff(continuation, this.$state$inlined, this.$focusRequester$inlined, this.$legacyTextInputServiceAdapter$inlined);
        c0729x8b2642ff.L$0 = obj;
        return c0729x8b2642ff;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((C0729x8b2642ff) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:42:0x0100 A[LOOP:1: B:30:0x00cd->B:42:0x0100, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x010b A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b5 -> B:29:0x00bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0176 -> B:62:0x017b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.C0729x8b2642ff.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
