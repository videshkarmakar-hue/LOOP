package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 */
/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", m210f = "WindowRecomposer.android.kt", m211i = {0}, m212l = {396}, m213m = "invokeSuspend", m214n = {"durationScaleJob"}, m215s = {"L$0"})
final class C1899x149b840a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt.C18982 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1899x149b840a(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt.C18982 c18982, View view, Continuation<? super C1899x149b840a> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = c18982;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C1899x149b840a c1899x149b840a = new C1899x149b840a(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        c1899x149b840a.L$0 = obj;
        return c1899x149b840a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C1899x149b840a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0084  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Job job;
        Job jobLaunch$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        C1899x149b840a c1899x149b840a = this.label;
        try {
            switch (c1899x149b840a) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c1899x149b840a = this;
                    CoroutineScope coroutineScope = (CoroutineScope) c1899x149b840a.L$0;
                    try {
                        MotionDurationScaleImpl motionDurationScaleImpl = c1899x149b840a.$systemDurationScaleSettingConsumer.element;
                        if (motionDurationScaleImpl != null) {
                            StateFlow animationScaleFlowFor = WindowRecomposer_androidKt.getAnimationScaleFlowFor(c1899x149b840a.$this_createLifecycleAwareWindowRecomposer.getContext().getApplicationContext());
                            motionDurationScaleImpl.setScaleFactor(((Number) animationScaleFlowFor.getValue()).floatValue());
                            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C1900x93d788e4(animationScaleFlowFor, motionDurationScaleImpl, null), 3, null);
                            break;
                        } else {
                            jobLaunch$default = null;
                        }
                        job = jobLaunch$default;
                        c1899x149b840a.L$0 = job;
                        c1899x149b840a.label = 1;
                        Object objRunRecomposeAndApplyChanges = c1899x149b840a.$recomposer.runRecomposeAndApplyChanges(c1899x149b840a);
                        c1899x149b840a = c1899x149b840a;
                        if (objRunRecomposeAndApplyChanges == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        c1899x149b840a.$source.getLifecycleRegistry().removeObserver(c1899x149b840a.$self);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        job = null;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        c1899x149b840a.$source.getLifecycleRegistry().removeObserver(c1899x149b840a.$self);
                        throw th;
                    }
                case 1:
                    C1899x149b840a c1899x149b840a2 = this;
                    job = (Job) c1899x149b840a2.L$0;
                    ResultKt.throwOnFailure(obj);
                    c1899x149b840a = c1899x149b840a2;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    c1899x149b840a.$source.getLifecycleRegistry().removeObserver(c1899x149b840a.$self);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
