package com.videshkarmakar.loop.ui.page.download;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: FormatPage.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.videshkarmakar.loop.ui.page.download.FormatPageKt$FormatPageImpl$4$1", f = "FormatPage.kt", i = {}, l = {351}, m = "invokeSuspend", n = {}, s = {})
final class FormatPageKt$FormatPageImpl$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ClosedFloatingPointRange<Float>> $videoClipDuration$delegate;
    final /* synthetic */ ClosedFloatingPointRange<Float> $videoDurationRange;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FormatPageKt$FormatPageImpl$4$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, MutableState<ClosedFloatingPointRange<Float>> mutableState, Continuation<? super FormatPageKt$FormatPageImpl$4$1> continuation) {
        super(2, continuation);
        this.$videoDurationRange = closedFloatingPointRange;
        this.$videoClipDuration$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FormatPageKt$FormatPageImpl$4$1(this.$videoDurationRange, this.$videoClipDuration$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FormatPageKt$FormatPageImpl$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        FormatPageKt$FormatPageImpl$4$1 formatPageKt$FormatPageImpl$4$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                formatPageKt$FormatPageImpl$4$1 = this;
                break;
                break;
            case 1:
                formatPageKt$FormatPageImpl$4$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        formatPageKt$FormatPageImpl$4$1.$videoClipDuration$delegate.setValue(formatPageKt$FormatPageImpl$4$1.$videoDurationRange);
        return Unit.INSTANCE;
    }
}
