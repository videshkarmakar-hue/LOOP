package dev.chrisbanes.snapper;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: SnapperFlingBehavior.kt */
/* JADX INFO: loaded from: classes18.dex */
@Metadata(m194d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001Bm\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012>\b\u0002\u0010\t\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u0010BC\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0002\u0010\u0013B}\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012<\u0010\t\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0002\u0010\u0014J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\"\u0010#\u001a\u00020$*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0002J%\u0010%\u001a\u00020\u0006*\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J7\u0010)\u001a\u00020\u0006*\u00020&2\u0006\u0010*\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001d\u0010-\u001a\u00020\u0006*\u00020&2\u0006\u0010\u001e\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.JK\u0010/\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000201002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000b2!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00060\u0012H\u0002J/\u00104\u001a\u00020\u0006*\u00020&2\u0006\u0010*\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u00105R/\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\t\u001a8\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, m195d2 = {"Ldev/chrisbanes/snapper/SnapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "layoutInfo", "Ldev/chrisbanes/snapper/SnapperLayoutInfo;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "springAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapIndex", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "startIndex", "targetIndex", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function3;)V", "maximumFlingDistance", "Lkotlin/Function1;", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ldev/chrisbanes/snapper/SnapperLayoutInfo;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "animationTarget", "getAnimationTarget", "()Ljava/lang/Integer;", "setAnimationTarget", "(Ljava/lang/Integer;)V", "animationTarget$delegate", "Landroidx/compose/runtime/MutableState;", "calculateSnapBack", "initialVelocity", "currentItem", "Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;", "consumeVelocityIfNotAtScrollEdge", "velocity", "canDecayBeyondCurrentItem", "", "flingToIndex", "Landroidx/compose/foundation/gestures/ScrollScope;", "index", "(Landroidx/compose/foundation/gestures/ScrollScope;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDecayFling", "initialItem", "flingThenSpring", "(Landroidx/compose/foundation/gestures/ScrollScope;Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;IFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performSnapBackIfNeeded", "Landroidx/compose/animation/core/AnimationScope;", "Landroidx/compose/animation/core/AnimationVector1D;", "scrollBy", "pixels", "performSpringFling", "(Landroidx/compose/foundation/gestures/ScrollScope;Ldev/chrisbanes/snapper/SnapperLayoutItemInfo;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_release"}, m196k = 1, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnapperFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: animationTarget$delegate, reason: from kotlin metadata */
    private final MutableState animationTarget;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final SnapperLayoutInfo layoutInfo;
    private final Function1<SnapperLayoutInfo, Float> maximumFlingDistance;
    private final Function3<SnapperLayoutInfo, Integer, Integer, Integer> snapIndex;
    private final AnimationSpec<Float> springAnimationSpec;

    /* JADX INFO: renamed from: dev.chrisbanes.snapper.SnapperFlingBehavior$flingToIndex$1 */
    /* JADX INFO: compiled from: SnapperFlingBehavior.kt */
    @Metadata(m196k = 3, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "dev.chrisbanes.snapper.SnapperFlingBehavior", m210f = "SnapperFlingBehavior.kt", m211i = {0, 0, 0, 0, 1}, m212l = {HttpStatusCodesKt.HTTP_NOT_ACCEPTABLE, HttpStatusCodesKt.HTTP_REQUESTED_RANGE_NOT_SATISFIABLE}, m213m = "flingToIndex", m214n = {"this", "$this$flingToIndex", "index", "initialVelocity", "this"}, m215s = {"L$0", "L$1", "I$0", "F$0", "L$0"})
    static final class C40771 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C40771(Continuation<? super C40771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapperFlingBehavior.this.flingToIndex(null, 0, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: dev.chrisbanes.snapper.SnapperFlingBehavior$performDecayFling$1 */
    /* JADX INFO: compiled from: SnapperFlingBehavior.kt */
    @Metadata(m196k = 3, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "dev.chrisbanes.snapper.SnapperFlingBehavior", m210f = "SnapperFlingBehavior.kt", m211i = {0, 0}, m212l = {477}, m213m = "performDecayFling", m214n = {"this", "velocityLeft"}, m215s = {"L$0", "L$1"})
    static final class C40781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C40781(Continuation<? super C40781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapperFlingBehavior.this.performDecayFling(null, null, 0, 0.0f, false, this);
        }
    }

    /* JADX INFO: renamed from: dev.chrisbanes.snapper.SnapperFlingBehavior$performSpringFling$1 */
    /* JADX INFO: compiled from: SnapperFlingBehavior.kt */
    @Metadata(m196k = 3, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "dev.chrisbanes.snapper.SnapperFlingBehavior", m210f = "SnapperFlingBehavior.kt", m211i = {0, 0}, m212l = {551}, m213m = "performSpringFling", m214n = {"this", "velocityLeft"}, m215s = {"L$0", "L$1"})
    static final class C40801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C40801(Continuation<? super C40801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapperFlingBehavior.this.performSpringFling(null, null, 0, 0.0f, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Function3<? super SnapperLayoutInfo, ? super Integer, ? super Integer, Integer> function3, Function1<? super SnapperLayoutInfo, Float> function1) {
        this.layoutInfo = layoutInfo;
        this.decayAnimationSpec = decayAnimationSpec;
        this.springAnimationSpec = animationSpec;
        this.snapIndex = function3;
        this.maximumFlingDistance = function1;
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public /* synthetic */ SnapperFlingBehavior(SnapperLayoutInfo snapperLayoutInfo, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapperLayoutInfo, (DecayAnimationSpec<Float>) decayAnimationSpec, (AnimationSpec<Float>) ((i & 4) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec() : animationSpec), (Function3<? super SnapperLayoutInfo, ? super Integer, ? super Integer, Integer>) ((i & 8) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSnapIndex() : function3));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> springAnimationSpec, Function3<? super SnapperLayoutInfo, ? super Integer, ? super Integer, Integer> snapIndex) {
        this(layoutInfo, decayAnimationSpec, springAnimationSpec, snapIndex, SnapperFlingBehaviorDefaults.INSTANCE.getMaximumFlingDistance());
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(springAnimationSpec, "springAnimationSpec");
        Intrinsics.checkNotNullParameter(snapIndex, "snapIndex");
    }

    public /* synthetic */ SnapperFlingBehavior(SnapperLayoutInfo snapperLayoutInfo, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapperLayoutInfo, (DecayAnimationSpec<Float>) decayAnimationSpec, (AnimationSpec<Float>) ((i & 4) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getSpringAnimationSpec() : animationSpec), (Function1<? super SnapperLayoutInfo, Float>) ((i & 8) != 0 ? SnapperFlingBehaviorDefaults.INSTANCE.getMaximumFlingDistance() : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "The maximumFlingDistance parameter has been replaced with snapIndex")
    public SnapperFlingBehavior(SnapperLayoutInfo layoutInfo, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> springAnimationSpec, Function1<? super SnapperLayoutInfo, Float> maximumFlingDistance) {
        this(layoutInfo, decayAnimationSpec, springAnimationSpec, SnapperFlingBehaviorDefaults.INSTANCE.getSnapIndex(), maximumFlingDistance);
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(springAnimationSpec, "springAnimationSpec");
        Intrinsics.checkNotNullParameter(maximumFlingDistance, "maximumFlingDistance");
    }

    private final void setAnimationTarget(Integer num) {
        MutableState $this$setValue$iv = this.animationTarget;
        $this$setValue$iv.setValue(num);
    }

    public final Integer getAnimationTarget() {
        State $this$getValue$iv = this.animationTarget;
        return (Integer) $this$getValue$iv.getValue();
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope $this$performFling, float initialVelocity, Continuation<? super Float> continuation) {
        if (!this.layoutInfo.canScrollTowardsStart() || !this.layoutInfo.canScrollTowardsEnd()) {
            return Boxing.boxFloat(initialVelocity);
        }
        SnapperLog snapperLog = SnapperLog.INSTANCE;
        float maxFlingDistance = this.maximumFlingDistance.invoke(this.layoutInfo).floatValue();
        if (!(maxFlingDistance > 0.0f)) {
            throw new IllegalArgumentException("Distance returned by maximumFlingDistance should be greater than 0".toString());
        }
        SnapperLayoutItemInfo initialItem = this.layoutInfo.getCurrentItem();
        if (initialItem == null) {
            return Boxing.boxFloat(initialVelocity);
        }
        int target = this.layoutInfo.determineTargetIndex(initialVelocity, this.decayAnimationSpec, maxFlingDistance);
        int targetIndex = this.snapIndex.invoke(this.layoutInfo, Boxing.boxInt(initialVelocity < 0.0f ? initialItem.getIndex() + 1 : initialItem.getIndex()), Boxing.boxInt(target)).intValue();
        if (!(targetIndex >= 0 && targetIndex < this.layoutInfo.getTotalItemsCount())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return flingToIndex($this$performFling, targetIndex, initialVelocity, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object flingToIndex(ScrollScope $this$flingToIndex, int index, float f, Continuation<? super Float> continuation) throws Throwable {
        C40771 c40771;
        SnapperFlingBehavior snapperFlingBehavior;
        float initialVelocity;
        float velocityLeft;
        int index2;
        ScrollScope $this$flingToIndex2;
        float initialVelocity2;
        Object objPerformDecayFling$default;
        SnapperFlingBehavior snapperFlingBehavior2;
        int index3;
        ScrollScope $this$flingToIndex3;
        SnapperLayoutItemInfo currentItem;
        Object objPerformSpringFling;
        if (continuation instanceof C40771) {
            C40771 c40772 = (C40771) continuation;
            if ((c40772.label & Integer.MIN_VALUE) != 0) {
                c40772.label -= Integer.MIN_VALUE;
                c40771 = c40772;
            } else {
                c40771 = new C40771(continuation);
            }
        } else {
            c40771 = new C40771(continuation);
        }
        Object $result = c40771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c40771.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                snapperFlingBehavior = this;
                initialVelocity = f;
                SnapperLayoutItemInfo initialItem = snapperFlingBehavior.layoutInfo.getCurrentItem();
                if (initialItem == null) {
                    return Boxing.boxFloat(initialVelocity);
                }
                if (initialItem.getIndex() == index && snapperFlingBehavior.layoutInfo.distanceToIndexSnap(initialItem.getIndex()) == 0) {
                    SnapperLog snapperLog = SnapperLog.INSTANCE;
                    return Boxing.boxFloat(snapperFlingBehavior.consumeVelocityIfNotAtScrollEdge(initialVelocity));
                }
                velocityLeft = initialVelocity;
                if (snapperFlingBehavior.canDecayBeyondCurrentItem(snapperFlingBehavior.decayAnimationSpec, initialVelocity, initialItem)) {
                    c40771.L$0 = snapperFlingBehavior;
                    c40771.L$1 = $this$flingToIndex;
                    c40771.I$0 = index;
                    c40771.F$0 = initialVelocity;
                    c40771.label = 1;
                    initialVelocity2 = initialVelocity;
                    objPerformDecayFling$default = performDecayFling$default(snapperFlingBehavior, $this$flingToIndex, initialItem, index, velocityLeft, false, c40771, 8, null);
                    if (objPerformDecayFling$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    snapperFlingBehavior2 = snapperFlingBehavior;
                    index3 = index;
                    $this$flingToIndex3 = $this$flingToIndex;
                    velocityLeft = ((Number) objPerformDecayFling$default).floatValue();
                    snapperFlingBehavior = snapperFlingBehavior2;
                    initialVelocity = initialVelocity2;
                    index2 = index3;
                    $this$flingToIndex2 = $this$flingToIndex3;
                } else {
                    index2 = index;
                    $this$flingToIndex2 = $this$flingToIndex;
                }
                currentItem = snapperFlingBehavior.layoutInfo.getCurrentItem();
                if (currentItem == null) {
                    return Boxing.boxFloat(initialVelocity);
                }
                if (currentItem.getIndex() == index2 || snapperFlingBehavior.layoutInfo.distanceToIndexSnap(index2) != 0) {
                    c40771.L$0 = snapperFlingBehavior;
                    c40771.L$1 = null;
                    c40771.label = 2;
                    objPerformSpringFling = snapperFlingBehavior.performSpringFling($this$flingToIndex2, currentItem, index2, velocityLeft, c40771);
                    if (objPerformSpringFling == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    velocityLeft = ((Number) objPerformSpringFling).floatValue();
                }
                return Boxing.boxFloat(snapperFlingBehavior.consumeVelocityIfNotAtScrollEdge(velocityLeft));
            case 1:
                float initialVelocity3 = c40771.F$0;
                index3 = c40771.I$0;
                $this$flingToIndex3 = (ScrollScope) c40771.L$1;
                snapperFlingBehavior2 = (SnapperFlingBehavior) c40771.L$0;
                ResultKt.throwOnFailure($result);
                initialVelocity2 = initialVelocity3;
                objPerformDecayFling$default = $result;
                velocityLeft = ((Number) objPerformDecayFling$default).floatValue();
                snapperFlingBehavior = snapperFlingBehavior2;
                initialVelocity = initialVelocity2;
                index2 = index3;
                $this$flingToIndex2 = $this$flingToIndex3;
                currentItem = snapperFlingBehavior.layoutInfo.getCurrentItem();
                if (currentItem == null) {
                    return Boxing.boxFloat(initialVelocity);
                }
                if (currentItem.getIndex() == index2) {
                    break;
                }
                c40771.L$0 = snapperFlingBehavior;
                c40771.L$1 = null;
                c40771.label = 2;
                objPerformSpringFling = snapperFlingBehavior.performSpringFling($this$flingToIndex2, currentItem, index2, velocityLeft, c40771);
                if (objPerformSpringFling == coroutine_suspended) {
                    return coroutine_suspended;
                }
                velocityLeft = ((Number) objPerformSpringFling).floatValue();
                return Boxing.boxFloat(snapperFlingBehavior.consumeVelocityIfNotAtScrollEdge(velocityLeft));
            case 2:
                SnapperFlingBehavior snapperFlingBehavior3 = (SnapperFlingBehavior) c40771.L$0;
                ResultKt.throwOnFailure($result);
                snapperFlingBehavior = snapperFlingBehavior3;
                objPerformSpringFling = $result;
                velocityLeft = ((Number) objPerformSpringFling).floatValue();
                return Boxing.boxFloat(snapperFlingBehavior.consumeVelocityIfNotAtScrollEdge(velocityLeft));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object performDecayFling(final ScrollScope scrollScope, SnapperLayoutItemInfo initialItem, final int targetIndex, float initialVelocity, boolean flingThenSpring, Continuation<? super Float> continuation) throws Throwable {
        C40781 c40781;
        SnapperFlingBehavior snapperFlingBehavior;
        Ref.FloatRef velocityLeft;
        if (continuation instanceof C40781) {
            c40781 = (C40781) continuation;
            if ((c40781.label & Integer.MIN_VALUE) != 0) {
                c40781.label -= Integer.MIN_VALUE;
            } else {
                c40781 = new C40781(continuation);
            }
        } else {
            c40781 = new C40781(continuation);
        }
        Object $result = c40781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c40781.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (initialItem.getIndex() == targetIndex && this.layoutInfo.distanceToIndexSnap(initialItem.getIndex()) == 0) {
                    SnapperLog snapperLog = SnapperLog.INSTANCE;
                    return Boxing.boxFloat(consumeVelocityIfNotAtScrollEdge(initialVelocity));
                }
                SnapperLog snapperLog2 = SnapperLog.INSTANCE;
                final Ref.FloatRef velocityLeft2 = new Ref.FloatRef();
                velocityLeft2.element = initialVelocity;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                boolean canSpringThenFling = flingThenSpring && Math.abs(targetIndex - initialItem.getIndex()) >= 2;
                try {
                    setAnimationTarget(Boxing.boxInt(targetIndex));
                    AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(0.0f, initialVelocity, 0L, 0L, false, 28, null);
                    DecayAnimationSpec<Float> decayAnimationSpec = this.decayAnimationSpec;
                    final boolean z = canSpringThenFling;
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: dev.chrisbanes.snapper.SnapperFlingBehavior.performDecayFling.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animateDecay) {
                            Intrinsics.checkNotNullParameter(animateDecay, "$this$animateDecay");
                            float delta = animateDecay.getValue().floatValue() - floatRef.element;
                            float consumed = scrollScope.scrollBy(delta);
                            floatRef.element = animateDecay.getValue().floatValue();
                            velocityLeft2.element = animateDecay.getVelocity().floatValue();
                            if (Math.abs(delta - consumed) > 0.5f) {
                                animateDecay.cancelAnimation();
                            }
                            SnapperLayoutItemInfo currentItem = this.layoutInfo.getCurrentItem();
                            if (currentItem == null) {
                                animateDecay.cancelAnimation();
                                return;
                            }
                            if (animateDecay.isRunning() && z) {
                                if (animateDecay.getVelocity().floatValue() > 0.0f && currentItem.getIndex() == targetIndex - 1) {
                                    animateDecay.cancelAnimation();
                                } else if (animateDecay.getVelocity().floatValue() < 0.0f && currentItem.getIndex() == targetIndex) {
                                    animateDecay.cancelAnimation();
                                }
                            }
                            if (animateDecay.isRunning() && this.performSnapBackIfNeeded(animateDecay, currentItem, targetIndex, new AnonymousClass1(scrollScope))) {
                                animateDecay.cancelAnimation();
                            }
                        }

                        /* JADX INFO: renamed from: dev.chrisbanes.snapper.SnapperFlingBehavior$performDecayFling$4$1, reason: invalid class name */
                        /* JADX INFO: compiled from: SnapperFlingBehavior.kt */
                        @Metadata(m196k = 3, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Float> {
                            AnonymousClass1(Object obj) {
                                super(1, obj, ScrollScope.class, "scrollBy", "scrollBy(F)F", 0);
                            }

                            public final Float invoke(float p0) {
                                return Float.valueOf(((ScrollScope) this.receiver).scrollBy(p0));
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                                return invoke(f.floatValue());
                            }
                        }
                    };
                    c40781.L$0 = this;
                    c40781.L$1 = velocityLeft2;
                    c40781.label = 1;
                    try {
                        if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default, decayAnimationSpec, false, function1, c40781, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        velocityLeft = velocityLeft2;
                        snapperFlingBehavior = this;
                        snapperFlingBehavior.setAnimationTarget(null);
                        SnapperLog snapperLog3 = SnapperLog.INSTANCE;
                        return Boxing.boxFloat(velocityLeft.element);
                    } catch (Throwable th) {
                        th = th;
                        snapperFlingBehavior = this;
                        snapperFlingBehavior.setAnimationTarget(null);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    snapperFlingBehavior = this;
                }
                break;
            case 1:
                velocityLeft = (Ref.FloatRef) c40781.L$1;
                snapperFlingBehavior = (SnapperFlingBehavior) c40781.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    snapperFlingBehavior.setAnimationTarget(null);
                    SnapperLog snapperLog4 = SnapperLog.INSTANCE;
                    return Boxing.boxFloat(velocityLeft.element);
                } catch (Throwable th3) {
                    th = th3;
                    snapperFlingBehavior.setAnimationTarget(null);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object performDecayFling$default(SnapperFlingBehavior snapperFlingBehavior, ScrollScope scrollScope, SnapperLayoutItemInfo snapperLayoutItemInfo, int i, float f, boolean z, Continuation continuation, int i2, Object obj) {
        return snapperFlingBehavior.performDecayFling(scrollScope, snapperLayoutItemInfo, i, f, (i2 & 8) != 0 ? true : z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object performSpringFling(final ScrollScope $this$performSpringFling, SnapperLayoutItemInfo initialItem, final int targetIndex, float f, Continuation<? super Float> continuation) throws Throwable {
        C40801 c40801;
        SnapperFlingBehavior snapperFlingBehavior;
        Ref.FloatRef velocityLeft;
        if (continuation instanceof C40801) {
            c40801 = (C40801) continuation;
            if ((c40801.label & Integer.MIN_VALUE) != 0) {
                c40801.label -= Integer.MIN_VALUE;
            } else {
                c40801 = new C40801(continuation);
            }
        } else {
            c40801 = new C40801(continuation);
        }
        Object $result = c40801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c40801.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                float initialVelocity = f;
                SnapperLog snapperLog = SnapperLog.INSTANCE;
                final Ref.FloatRef velocityLeft2 = new Ref.FloatRef();
                if ((targetIndex <= initialItem.getIndex() || initialVelocity <= 0.0f) && (targetIndex > initialItem.getIndex() || initialVelocity >= 0.0f)) {
                    initialVelocity = 0.0f;
                }
                velocityLeft2.element = initialVelocity;
                final Ref.FloatRef lastValue = new Ref.FloatRef();
                try {
                    setAnimationTarget(Boxing.boxInt(targetIndex));
                    AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(lastValue.element, velocityLeft2.element, 0L, 0L, false, 28, null);
                    Float fBoxFloat = Boxing.boxFloat(this.layoutInfo.distanceToIndexSnap(targetIndex));
                    AnimationSpec<Float> animationSpec = this.springAnimationSpec;
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: dev.chrisbanes.snapper.SnapperFlingBehavior.performSpringFling.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animateTo) {
                            Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                            float delta = animateTo.getValue().floatValue() - lastValue.element;
                            float consumed = $this$performSpringFling.scrollBy(delta);
                            lastValue.element = animateTo.getValue().floatValue();
                            velocityLeft2.element = animateTo.getVelocity().floatValue();
                            SnapperLayoutItemInfo currentItem = this.layoutInfo.getCurrentItem();
                            if (currentItem != null) {
                                if (this.performSnapBackIfNeeded(animateTo, currentItem, targetIndex, new AnonymousClass1($this$performSpringFling))) {
                                    animateTo.cancelAnimation();
                                    return;
                                } else {
                                    if (Math.abs(delta - consumed) > 0.5f) {
                                        animateTo.cancelAnimation();
                                        return;
                                    }
                                    return;
                                }
                            }
                            animateTo.cancelAnimation();
                        }

                        /* JADX INFO: renamed from: dev.chrisbanes.snapper.SnapperFlingBehavior$performSpringFling$3$1, reason: invalid class name */
                        /* JADX INFO: compiled from: SnapperFlingBehavior.kt */
                        @Metadata(m196k = 3, m197mv = {1, 6, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Float> {
                            AnonymousClass1(Object obj) {
                                super(1, obj, ScrollScope.class, "scrollBy", "scrollBy(F)F", 0);
                            }

                            public final Float invoke(float p0) {
                                return Float.valueOf(((ScrollScope) this.receiver).scrollBy(p0));
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                                return invoke(f.floatValue());
                            }
                        }
                    };
                    c40801.L$0 = this;
                    c40801.L$1 = velocityLeft2;
                    c40801.label = 1;
                    try {
                        if (SuspendAnimationKt.animateTo(animationStateAnimationState$default, fBoxFloat, (4 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec, (4 & 4) != 0 ? false : false, (4 & 8) != 0 ? SuspendAnimationKt.C02582.INSTANCE : function1, c40801) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        velocityLeft = velocityLeft2;
                        snapperFlingBehavior = this;
                        snapperFlingBehavior.setAnimationTarget(null);
                        SnapperLog snapperLog2 = SnapperLog.INSTANCE;
                        return Boxing.boxFloat(velocityLeft.element);
                    } catch (Throwable th) {
                        th = th;
                        snapperFlingBehavior = this;
                        snapperFlingBehavior.setAnimationTarget(null);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    snapperFlingBehavior = this;
                }
                break;
            case 1:
                velocityLeft = (Ref.FloatRef) c40801.L$1;
                snapperFlingBehavior = (SnapperFlingBehavior) c40801.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    snapperFlingBehavior.setAnimationTarget(null);
                    SnapperLog snapperLog3 = SnapperLog.INSTANCE;
                    return Boxing.boxFloat(velocityLeft.element);
                } catch (Throwable th3) {
                    th = th3;
                    snapperFlingBehavior.setAnimationTarget(null);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean performSnapBackIfNeeded(AnimationScope<Float, AnimationVector1D> animationScope, SnapperLayoutItemInfo currentItem, int targetIndex, Function1<? super Float, Float> function1) {
        SnapperLog snapperLog = SnapperLog.INSTANCE;
        int snapBackAmount = calculateSnapBack(animationScope.getVelocity().floatValue(), currentItem, targetIndex);
        if (snapBackAmount != 0) {
            SnapperLog snapperLog2 = SnapperLog.INSTANCE;
            function1.invoke(Float.valueOf(snapBackAmount));
            return true;
        }
        return false;
    }

    private final boolean canDecayBeyondCurrentItem(DecayAnimationSpec<Float> decayAnimationSpec, float velocity, SnapperLayoutItemInfo currentItem) {
        if (Math.abs(velocity) < 0.5f) {
            return false;
        }
        float flingDistance = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, velocity);
        SnapperLog snapperLog = SnapperLog.INSTANCE;
        if (velocity < 0.0f) {
            return flingDistance <= ((float) this.layoutInfo.distanceToIndexSnap(currentItem.getIndex()));
        }
        return flingDistance >= ((float) this.layoutInfo.distanceToIndexSnap(currentItem.getIndex() + 1));
    }

    private final int calculateSnapBack(float initialVelocity, SnapperLayoutItemInfo currentItem, int targetIndex) {
        if (initialVelocity > 0.0f && currentItem.getIndex() >= targetIndex) {
            return this.layoutInfo.distanceToIndexSnap(currentItem.getIndex());
        }
        if (initialVelocity < 0.0f && currentItem.getIndex() <= targetIndex - 1) {
            return this.layoutInfo.distanceToIndexSnap(currentItem.getIndex() + 1);
        }
        return 0;
    }

    private final float consumeVelocityIfNotAtScrollEdge(float velocity) {
        if (velocity < 0.0f && !this.layoutInfo.canScrollTowardsStart()) {
            return velocity;
        }
        if (velocity <= 0.0f || this.layoutInfo.canScrollTowardsEnd()) {
            return 0.0f;
        }
        return velocity;
    }
}
