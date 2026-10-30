package androidx.compose.foundation;

import android.view.Surface;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: AndroidExternalSurface.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000bJu\u0010\b\u001a\u00020\u00132f\u0010\b\u001ab\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t¢\u0006\u0002\b\u0015H\u0016¢\u0006\u0002\u0010 JO\u0010!\u001a\u00020\u0013*\u00020\u000b2A\u0010!\u001a=\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00130\u0018¢\u0006\u0002\b\u0015H\u0016J%\u0010\"\u001a\u00020\u0013*\u00020\u000b2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u001a¢\u0006\u0002\b\u0015H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000Rr\u0010\b\u001ad\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t¢\u0006\u0002\b\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016RK\u0010\u0017\u001a?\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0018¢\u0006\u0002\b\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001a¢\u0006\u0002\b\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006#"}, m195d2 = {"Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Landroidx/compose/foundation/SurfaceScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "job", "Lkotlinx/coroutines/Job;", "onSurface", "Lkotlin/Function5;", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroid/view/Surface;", "Lkotlin/ParameterName;", "name", "surface", "", "width", "height", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function5;", "onSurfaceChanged", "Lkotlin/Function3;", "onSurfaceDestroyed", "Lkotlin/Function1;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "dispatchSurfaceChanged", "dispatchSurfaceCreated", "dispatchSurfaceDestroyed", "(Lkotlin/jvm/functions/Function5;)V", "onChanged", "onDestroyed", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
abstract class BaseAndroidExternalSurfaceState implements AndroidExternalSurfaceScope, SurfaceScope {
    private Job job;
    private Function5<? super SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> onSurface;
    private Function3<? super Surface, ? super Integer, ? super Integer, Unit> onSurfaceChanged;
    private Function1<? super Surface, Unit> onSurfaceDestroyed;
    private final CoroutineScope scope;

    public BaseAndroidExternalSurfaceState(CoroutineScope scope) {
        this.scope = scope;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public void onSurface(Function5<? super SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> onSurface) {
        this.onSurface = onSurface;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onChanged(Surface $this$onChanged, Function3<? super Surface, ? super Integer, ? super Integer, Unit> function3) {
        this.onSurfaceChanged = function3;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onDestroyed(Surface $this$onDestroyed, Function1<? super Surface, Unit> function1) {
        this.onSurfaceDestroyed = function1;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1 */
    /* JADX INFO: compiled from: AndroidExternalSurface.android.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1", m210f = "AndroidExternalSurface.android.kt", m211i = {0}, m212l = {132, 137}, m213m = "invokeSuspend", m214n = {"$this$launch"}, m215s = {"L$0"})
    static final class C02841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $height;
        final /* synthetic */ Surface $surface;
        final /* synthetic */ int $width;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02841(Surface surface, int i, int i2, Continuation<? super C02841> continuation) {
            super(2, continuation);
            this.$surface = surface;
            this.$width = i;
            this.$height = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02841 c02841 = BaseAndroidExternalSurfaceState.this.new C02841(this.$surface, this.$width, this.$height, continuation);
            c02841.L$0 = obj;
            return c02841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0050  */
        /* JADX WARN: Code duplicated, block: B:17:0x006b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x006c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C02841 c02841;
            CoroutineScope $this$launch;
            C02841 c02842;
            C0285x6d6f8e47 receiver;
            Function5 function5;
            Surface surface;
            Integer numBoxInt;
            Integer numBoxInt2;
            C02841 c02843;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c02841 = this;
                    $this$launch = (CoroutineScope) c02841.L$0;
                    Job job = BaseAndroidExternalSurfaceState.this.job;
                    if (job != null) {
                        c02841.L$0 = $this$launch;
                        c02841.label = 1;
                        if (JobKt.cancelAndJoin(job, c02841) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    c02842 = c02841;
                    receiver = new C0285x6d6f8e47(BaseAndroidExternalSurfaceState.this, $this$launch);
                    function5 = BaseAndroidExternalSurfaceState.this.onSurface;
                    if (function5 != null) {
                        surface = c02842.$surface;
                        numBoxInt = Boxing.boxInt(c02842.$width);
                        numBoxInt2 = Boxing.boxInt(c02842.$height);
                        c02842.L$0 = null;
                        c02842.label = 2;
                        if (function5.invoke(receiver, surface, numBoxInt, numBoxInt2, c02842) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c02843 = c02842;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c02841 = this;
                    $this$launch = (CoroutineScope) c02841.L$0;
                    ResultKt.throwOnFailure($result);
                    c02842 = c02841;
                    receiver = new C0285x6d6f8e47(BaseAndroidExternalSurfaceState.this, $this$launch);
                    function5 = BaseAndroidExternalSurfaceState.this.onSurface;
                    if (function5 != null) {
                        surface = c02842.$surface;
                        numBoxInt = Boxing.boxInt(c02842.$width);
                        numBoxInt2 = Boxing.boxInt(c02842.$height);
                        c02842.L$0 = null;
                        c02842.label = 2;
                        if (function5.invoke(receiver, surface, numBoxInt, numBoxInt2, c02842) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c02843 = c02842;
                    }
                    return Unit.INSTANCE;
                case 2:
                    c02843 = this;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void dispatchSurfaceCreated(Surface surface, int width, int height) {
        if (this.onSurface != null) {
            this.job = BuildersKt__Builders_commonKt.launch$default(this.scope, null, CoroutineStart.UNDISPATCHED, new C02841(surface, width, height, null), 1, null);
        }
    }

    public final void dispatchSurfaceChanged(Surface surface, int width, int height) {
        Function3<? super Surface, ? super Integer, ? super Integer, Unit> function3 = this.onSurfaceChanged;
        if (function3 != null) {
            function3.invoke(surface, Integer.valueOf(width), Integer.valueOf(height));
        }
    }

    public final void dispatchSurfaceDestroyed(Surface surface) {
        Function1<? super Surface, Unit> function1 = this.onSurfaceDestroyed;
        if (function1 != null) {
            function1.invoke(surface);
        }
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
    }
}
