package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.internal.PredictiveBack;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: NavigationDrawer.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\u008a@"}, m195d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_PROGRESS, "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1", m210f = "NavigationDrawer.android.kt", m211i = {}, m212l = {60, 84, 84, 84}, m213m = "invokeSuspend", m214n = {}, m215s = {})
final class NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceGrow;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceShrink;
    final /* synthetic */ Ref.FloatRef $maxScaleYDistance;
    final /* synthetic */ CoroutineScope $scope;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(DrawerPredictiveBackState drawerPredictiveBackState, CoroutineScope coroutineScope, DrawerState drawerState, boolean z, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Continuation<? super NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1> continuation) {
        super(2, continuation);
        this.$drawerPredictiveBackState = drawerPredictiveBackState;
        this.$scope = coroutineScope;
        this.$drawerState = drawerState;
        this.$isRtl = z;
        this.$maxScaleXDistanceGrow = floatRef;
        this.$maxScaleXDistanceShrink = floatRef2;
        this.$maxScaleYDistance = floatRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(this.$drawerPredictiveBackState, this.$scope, this.$drawerState, this.$isRtl, this.$maxScaleXDistanceGrow, this.$maxScaleXDistanceShrink, this.$maxScaleYDistance, continuation);
        navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.L$0 = obj;
        return navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:0x007c A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ?? r1;
        Object objClose;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        try {
            try {
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = this;
                        Flow flow = (Flow) navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.L$0;
                        final DrawerPredictiveBackState drawerPredictiveBackState = navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.$drawerPredictiveBackState;
                        final boolean z = navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.$isRtl;
                        final Ref.FloatRef floatRef = navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.$maxScaleXDistanceGrow;
                        final Ref.FloatRef floatRef2 = navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.$maxScaleXDistanceShrink;
                        final Ref.FloatRef floatRef3 = navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.$maxScaleYDistance;
                        navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.label = 1;
                        Object objCollect = flow.collect(new FlowCollector() { // from class: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((BackEventCompat) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(BackEventCompat backEvent, Continuation<? super Unit> continuation) {
                                drawerPredictiveBackState.update(PredictiveBack.INSTANCE.transform$material3_release(backEvent.getProgress()), backEvent.getSwipeEdge() == 0, z, floatRef.element, floatRef2.element, floatRef3.element);
                                return Unit.INSTANCE;
                            }
                        }, navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1);
                        r2 = navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1;
                        if (objCollect == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (r2.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                            BuildersKt__Builders_commonKt.launch$default(r2.$scope, null, null, new C14372(r2.$drawerPredictiveBackState, null), 3, null);
                        }
                        r2.label = 2;
                        objClose = r2.$drawerState.close((Continuation) r2);
                        r1 = r2;
                        if (objClose == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        r2 = this;
                        ResultKt.throwOnFailure(obj);
                        if (r2.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                            BuildersKt__Builders_commonKt.launch$default(r2.$scope, null, null, new C14372(r2.$drawerPredictiveBackState, null), 3, null);
                        }
                        r2.label = 2;
                        objClose = r2.$drawerState.close((Continuation) r2);
                        r1 = r2;
                        if (objClose == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        Throwable th = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (CancellationException e) {
                r2.$drawerPredictiveBackState.clear();
                if (r2.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                    BuildersKt__Builders_commonKt.launch$default(r2.$scope, null, null, new C14372(r2.$drawerPredictiveBackState, null), 3, null);
                }
                r2.label = 3;
                Object objClose2 = r2.$drawerState.close((Continuation) r2);
                r1 = r2;
                if (objClose2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th2) {
            if (r2.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                BuildersKt__Builders_commonKt.launch$default(r2.$scope, null, null, new C14372(r2.$drawerPredictiveBackState, null), 3, null);
            }
            r2.L$0 = th2;
            r2.label = 4;
            if (r2.$drawerState.close((Continuation) r2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 */
    /* JADX INFO: compiled from: NavigationDrawer.android.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2", m210f = "NavigationDrawer.android.kt", m211i = {}, m212l = {77}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C14372 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14372(DrawerPredictiveBackState drawerPredictiveBackState, Continuation<? super C14372> continuation) {
            super(2, continuation);
            this.$drawerPredictiveBackState = drawerPredictiveBackState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C14372(this.$drawerPredictiveBackState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14372) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C14372 c14372;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    float scaleXDistance = this.$drawerPredictiveBackState.getScaleXDistance();
                    final DrawerPredictiveBackState drawerPredictiveBackState = this.$drawerPredictiveBackState;
                    this.label = 1;
                    if (SuspendAnimationKt.animate$default(scaleXDistance, 0.0f, 0.0f, null, new Function2<Float, Float, Unit>() { // from class: androidx.compose.material3.NavigationDrawer_androidKt.DrawerPredictiveBackHandler.2.1.2.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2) {
                            invoke(f.floatValue(), f2.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float value, float f) {
                            drawerPredictiveBackState.setScaleXDistance(value);
                        }
                    }, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c14372 = this;
                    break;
                    break;
                case 1:
                    c14372 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c14372.$drawerPredictiveBackState.clear();
            return Unit.INSTANCE;
        }
    }
}
