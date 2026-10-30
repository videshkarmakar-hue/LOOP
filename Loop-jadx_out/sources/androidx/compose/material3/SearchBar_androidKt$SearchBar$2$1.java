package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.internal.PredictiveBack;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: SearchBar.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\u008a@"}, m195d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_PROGRESS, "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1", m210f = "SearchBar.android.kt", m211i = {}, m212l = {218}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class SearchBar_androidKt$SearchBar$2$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutatorMutex $mutatorMutex;
    final /* synthetic */ Function1<Boolean, Unit> $onActiveChange;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SearchBar_androidKt$SearchBar$2$1(MutatorMutex mutatorMutex, MutableFloatState mutableFloatState, Animatable<Float, AnimationVector1D> animatable, Function1<? super Boolean, Unit> function1, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, Continuation<? super SearchBar_androidKt$SearchBar$2$1> continuation) {
        super(2, continuation);
        this.$mutatorMutex = mutatorMutex;
        this.$finalBackProgress = mutableFloatState;
        this.$animationProgress = animatable;
        this.$onActiveChange = function1;
        this.$firstBackEvent = mutableState;
        this.$currentBackEvent = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchBar_androidKt$SearchBar$2$1 searchBar_androidKt$SearchBar$2$1 = new SearchBar_androidKt$SearchBar$2$1(this.$mutatorMutex, this.$finalBackProgress, this.$animationProgress, this.$onActiveChange, this.$firstBackEvent, this.$currentBackEvent, continuation);
        searchBar_androidKt$SearchBar$2$1.L$0 = obj;
        return searchBar_androidKt$SearchBar$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((SearchBar_androidKt$SearchBar$2$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1 */
    /* JADX INFO: compiled from: SearchBar.android.kt */
    @Metadata(m194d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m195d2 = {"<anonymous>", ""}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1", m210f = "SearchBar.android.kt", m211i = {}, m212l = {221, 232}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C14631 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
        final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
        final /* synthetic */ MutableFloatState $finalBackProgress;
        final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
        final /* synthetic */ Function1<Boolean, Unit> $onActiveChange;
        final /* synthetic */ Flow<BackEventCompat> $progress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C14631(MutableFloatState mutableFloatState, Flow<BackEventCompat> flow, Animatable<Float, AnimationVector1D> animatable, Function1<? super Boolean, Unit> function1, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, Continuation<? super C14631> continuation) {
            super(1, continuation);
            this.$finalBackProgress = mutableFloatState;
            this.$progress = flow;
            this.$animationProgress = animatable;
            this.$onActiveChange = function1;
            this.$firstBackEvent = mutableState;
            this.$currentBackEvent = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C14631(this.$finalBackProgress, this.$progress, this.$animationProgress, this.$onActiveChange, this.$firstBackEvent, this.$currentBackEvent, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C14631) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C14631 c14631;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            C14631 c14632 = this.label;
            try {
                switch (c14632) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        C14631 c14633 = this;
                        c14633.$finalBackProgress.setFloatValue(Float.NaN);
                        Flow<BackEventCompat> flow = c14633.$progress;
                        final MutableState<BackEventCompat> mutableState = c14633.$firstBackEvent;
                        final MutableState<BackEventCompat> mutableState2 = c14633.$currentBackEvent;
                        final Animatable<Float, AnimationVector1D> animatable = c14633.$animationProgress;
                        c14633.label = 1;
                        Object objCollect = flow.collect(new FlowCollector() { // from class: androidx.compose.material3.SearchBar_androidKt.SearchBar.2.1.1.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((BackEventCompat) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(BackEventCompat backEvent, Continuation<? super Unit> continuation) {
                                if (mutableState.getValue() == null) {
                                    mutableState.setValue(backEvent);
                                }
                                mutableState2.setValue(backEvent);
                                float interpolatedProgress = PredictiveBack.INSTANCE.transform$material3_release(backEvent.getProgress());
                                Object objSnapTo = animatable.snapTo(Boxing.boxFloat(1 - interpolatedProgress), continuation);
                                return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
                            }
                        }, c14633);
                        c14632 = c14633;
                        if (objCollect == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c14632.$finalBackProgress.setFloatValue(c14632.$animationProgress.getValue().floatValue());
                        c14632.$onActiveChange.invoke(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    case 1:
                        c14632 = this;
                        ResultKt.throwOnFailure(obj);
                        c14632.$finalBackProgress.setFloatValue(c14632.$animationProgress.getValue().floatValue());
                        c14632.$onActiveChange.invoke(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    case 2:
                        c14631 = this;
                        ResultKt.throwOnFailure(obj);
                        c14631.$finalBackProgress.setFloatValue(Float.NaN);
                        c14631.$firstBackEvent.setValue(null);
                        c14631.$currentBackEvent.setValue(null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (CancellationException e) {
                Animatable<Float, AnimationVector1D> animatable2 = c14632.$animationProgress;
                Float fBoxFloat = Boxing.boxFloat(1.0f);
                FiniteAnimationSpec finiteAnimationSpec = SearchBar_androidKt.AnimationPredictiveBackExitFloatSpec;
                c14632.label = 2;
                if (animatable2.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable2.defaultSpringSpec : finiteAnimationSpec, (4 & 4) != 0 ? animatable2.getVelocity() : null, (4 & 8) != 0 ? null : null, c14632) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c14631 = c14632;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow progress = (Flow) this.L$0;
                this.label = 1;
                if (MutatorMutex.mutate$default(this.$mutatorMutex, null, new C14631(this.$finalBackProgress, progress, this.$animationProgress, this.$onActiveChange, this.$firstBackEvent, this.$currentBackEvent, null), this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
