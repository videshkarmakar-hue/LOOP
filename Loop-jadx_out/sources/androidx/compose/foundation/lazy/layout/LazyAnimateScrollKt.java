package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyAnimateScroll.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a2\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0016"}, m195d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "MinimumDistance", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "animateScrollToItem", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "index", "", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemVisible", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyAnimateScrollKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = C1979Dp.m6801constructorimpl(2500);
    private static final float BoundDistance = C1979Dp.m6801constructorimpl(1500);
    private static final float MinimumDistance = C1979Dp.m6801constructorimpl(50);

    private static final void debugLog(Function0<String> function0) {
    }

    public static final boolean isItemVisible(LazyLayoutAnimateScrollScope $this$isItemVisible, int index) {
        return index <= $this$isItemVisible.getLastVisibleItemIndex() && $this$isItemVisible.getFirstVisibleItemIndex() <= index;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2 */
    /* JADX INFO: compiled from: LazyAnimateScroll.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", m210f = "LazyAnimateScroll.kt", m211i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, m212l = {174, 272}, m213m = "invokeSuspend", m214n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$scroll"}, m215s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
    static final class C06072 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Density $density;
        final /* synthetic */ int $index;
        final /* synthetic */ int $numOfItemsForTeleport;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToItem;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06072(int i, Density density, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i2, int i3, Continuation<? super C06072> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$density = density;
            this.$this_animateScrollToItem = lazyLayoutAnimateScrollScope;
            this.$scrollOffset = i2;
            this.$numOfItemsForTeleport = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06072 c06072 = new C06072(this.$index, this.$density, this.$this_animateScrollToItem, this.$scrollOffset, this.$numOfItemsForTeleport, continuation);
            c06072.L$0 = obj;
            return c06072;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C06072) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00d8 A[Catch: ItemFoundInScroll -> 0x01f8, TryCatch #4 {ItemFoundInScroll -> 0x01f8, blocks: (B:26:0x00d4, B:28:0x00d8, B:30:0x00e0, B:41:0x010a), top: B:99:0x00d4 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r4v13, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x01bb -> B:103:0x01c3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C06072 c06072;
            Object $result;
            ItemFoundInScroll itemFound;
            C06072 c06073;
            Object $result2;
            final ScrollScope $this$scroll;
            float boundDistancePx;
            Ref.BooleanRef loop;
            Ref.IntRef loops;
            float targetDistancePx;
            int i;
            ScrollScope $this$scroll2;
            float minDistancePx;
            Ref.ObjectRef anim;
            Object $result3;
            final float target;
            final ScrollScope $this$scroll3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            float f = 0.0f;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c06072 = this;
                    $result = obj;
                    ScrollScope $this$scroll4 = (ScrollScope) c06072.L$0;
                    boolean z = ((float) c06072.$index) >= 0.0f;
                    int i2 = c06072.$index;
                    if (!z) {
                        throw new IllegalArgumentException(("Index should be non-negative (" + i2 + ')').toString());
                    }
                    try {
                        Density $this$invokeSuspend_u24lambda_u241 = c06072.$density;
                        float targetDistancePx2 = $this$invokeSuspend_u24lambda_u241.mo567toPx0680j_4(LazyAnimateScrollKt.TargetDistance);
                        Density $this$invokeSuspend_u24lambda_u242 = c06072.$density;
                        float boundDistancePx2 = $this$invokeSuspend_u24lambda_u242.mo567toPx0680j_4(LazyAnimateScrollKt.BoundDistance);
                        Density $this$invokeSuspend_u24lambda_u243 = c06072.$density;
                        float minDistancePx2 = $this$invokeSuspend_u24lambda_u243.mo567toPx0680j_4(LazyAnimateScrollKt.MinimumDistance);
                        Ref.BooleanRef loop2 = new Ref.BooleanRef();
                        loop2.element = true;
                        Ref.ObjectRef anim2 = new Ref.ObjectRef();
                        anim2.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
                        if (LazyAnimateScrollKt.isItemVisible(c06072.$this_animateScrollToItem, c06072.$index)) {
                            int targetItemInitialOffset = MathKt.roundToInt(c06072.$this_animateScrollToItem.calculateDistanceTo(c06072.$index));
                            throw new ItemFoundInScroll(targetItemInitialOffset, (AnimationState) anim2.element);
                        }
                        int i3 = c06072.$index > c06072.$this_animateScrollToItem.getFirstVisibleItemIndex() ? 1 : 0;
                        Ref.IntRef loops2 = new Ref.IntRef();
                        loops2.element = 1;
                        boundDistancePx = boundDistancePx2;
                        loop = loop2;
                        loops = loops2;
                        targetDistancePx = targetDistancePx2;
                        i = i3;
                        $this$scroll2 = $this$scroll4;
                        minDistancePx = minDistancePx2;
                        anim = anim2;
                        try {
                            if (loop.element || c06072.$this_animateScrollToItem.getItemCount() <= 0) {
                                return Unit.INSTANCE;
                            }
                            try {
                                try {
                                    try {
                                        float expectedDistance = c06072.$this_animateScrollToItem.calculateDistanceTo(c06072.$index) + c06072.$scrollOffset;
                                        if (Math.abs(expectedDistance) >= targetDistancePx) {
                                            target = i != 0 ? targetDistancePx : -targetDistancePx;
                                        } else {
                                            float absTargetPx = Math.max(Math.abs(expectedDistance), minDistancePx);
                                            target = i != 0 ? absTargetPx : -absTargetPx;
                                        }
                                        int i4 = c06072.$index;
                                        int i5 = c06072.$scrollOffset;
                                        LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope = c06072.$this_animateScrollToItem;
                                        anim.element = AnimationStateKt.copy$default((AnimationState) anim.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                                        final Ref.FloatRef floatRef = new Ref.FloatRef();
                                        $this$scroll3 = $this$scroll2;
                                        AnimationState animationState = (AnimationState) anim.element;
                                        Float fBoxFloat = Boxing.boxFloat(target);
                                        boolean z2 = !((((Number) ((AnimationState) anim.element).getVelocity()).floatValue() > f ? 1 : (((Number) ((AnimationState) anim.element).getVelocity()).floatValue() == f ? 0 : -1)) == 0);
                                        final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope2 = c06072.$this_animateScrollToItem;
                                        final int i6 = c06072.$index;
                                        final boolean z3 = i != 0;
                                        final int i7 = c06072.$numOfItemsForTeleport;
                                        $result2 = $result;
                                        final int i8 = c06072.$scrollOffset;
                                        final Ref.BooleanRef loop3 = loop;
                                        final Ref.ObjectRef anim3 = anim;
                                        final Ref.IntRef loops3 = loops;
                                        float targetDistancePx3 = targetDistancePx;
                                        final float boundDistancePx3 = boundDistancePx;
                                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.3
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
                                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                                float coercedValue;
                                                if (!LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope2, i6)) {
                                                    if (target > 0.0f) {
                                                        coercedValue = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), target);
                                                    } else {
                                                        coercedValue = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), target);
                                                    }
                                                    float delta = coercedValue - floatRef.element;
                                                    float consumed = $this$scroll3.scrollBy(delta);
                                                    if (!LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope2, i6) && !C06072.invokeSuspend$isOvershot(z3, lazyLayoutAnimateScrollScope2, i6, i8)) {
                                                        if (!(delta == consumed)) {
                                                            animationScope.cancelAnimation();
                                                            loop3.element = false;
                                                            return;
                                                        }
                                                        floatRef.element += delta;
                                                        if (z3) {
                                                            if (animationScope.getValue().floatValue() > boundDistancePx3) {
                                                                animationScope.cancelAnimation();
                                                            }
                                                        } else if (animationScope.getValue().floatValue() < (-boundDistancePx3)) {
                                                            animationScope.cancelAnimation();
                                                        }
                                                        if (z3) {
                                                            if (loops3.element >= 2 && i6 - lazyLayoutAnimateScrollScope2.getLastVisibleItemIndex() > i7) {
                                                                lazyLayoutAnimateScrollScope2.snapToItem($this$scroll3, i6 - i7, 0);
                                                            }
                                                        } else if (loops3.element >= 2 && lazyLayoutAnimateScrollScope2.getFirstVisibleItemIndex() - i6 > i7) {
                                                            lazyLayoutAnimateScrollScope2.snapToItem($this$scroll3, i6 + i7, 0);
                                                        }
                                                    }
                                                }
                                                if (C06072.invokeSuspend$isOvershot(z3, lazyLayoutAnimateScrollScope2, i6, i8)) {
                                                    lazyLayoutAnimateScrollScope2.snapToItem($this$scroll3, i6, i8);
                                                    loop3.element = false;
                                                    animationScope.cancelAnimation();
                                                } else if (LazyAnimateScrollKt.isItemVisible(lazyLayoutAnimateScrollScope2, i6)) {
                                                    int targetItemOffset = MathKt.roundToInt(lazyLayoutAnimateScrollScope2.calculateDistanceTo(i6));
                                                    throw new ItemFoundInScroll(targetItemOffset, anim3.element);
                                                }
                                            }
                                        };
                                        C06072 c06074 = c06072;
                                        c06072.L$0 = $this$scroll3;
                                        c06072.L$1 = loop3;
                                        c06072.L$2 = anim3;
                                        c06072.L$3 = loops3;
                                        c06072.F$0 = targetDistancePx3;
                                        c06072.F$1 = boundDistancePx3;
                                        c06072.F$2 = minDistancePx;
                                        c06072.I$0 = i;
                                        c06072.label = 1;
                                        if (SuspendAnimationKt.animateTo(animationState, fBoxFloat, (4 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : null, (4 & 4) != 0 ? false : z2, (4 & 8) != 0 ? SuspendAnimationKt.C02582.INSTANCE : function1, c06074) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        try {
                                            $this$scroll2 = $this$scroll3;
                                            targetDistancePx = targetDistancePx3;
                                            boundDistancePx = boundDistancePx3;
                                            loop = loop3;
                                            anim = anim3;
                                            $result = $result2;
                                            loops = loops3;
                                            loops.element++;
                                            f = 0.0f;
                                            if (loop.element) {
                                            }
                                        } catch (ItemFoundInScroll e) {
                                            itemFound = e;
                                            c06073 = c06072;
                                            $result2 = $result;
                                            $this$scroll = $this$scroll2;
                                        }
                                        return Unit.INSTANCE;
                                    } catch (ItemFoundInScroll e2) {
                                        $result2 = $result;
                                        $this$scroll = $this$scroll3;
                                        itemFound = e2;
                                        c06073 = c06072;
                                    }
                                } catch (ItemFoundInScroll e3) {
                                    $this$scroll = $this$scroll3;
                                    itemFound = e3;
                                    c06073 = c06072;
                                }
                            } catch (ItemFoundInScroll e4) {
                                $this$scroll = $this$scroll3;
                                itemFound = e4;
                                c06073 = c06072;
                            }
                        } catch (ItemFoundInScroll e5) {
                            $result2 = $result;
                            $this$scroll = $this$scroll2;
                            itemFound = e5;
                            c06073 = c06072;
                        }
                        AnimationState anim4 = AnimationStateKt.copy$default((AnimationState) itemFound.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                        final float target2 = itemFound.getItemOffset() + c06073.$scrollOffset;
                        final Ref.FloatRef prevValue = new Ref.FloatRef();
                        Float fBoxFloat2 = Boxing.boxFloat(target2);
                        boolean z4 = ((Number) anim4.getVelocity()).floatValue() == 0.0f;
                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function2 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.animateScrollToItem.2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Code duplicated, block: B:19:0x0061  */
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                float fCoerceAtLeast = 0.0f;
                                if (target2 > 0.0f) {
                                    fCoerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), target2);
                                } else if (target2 < 0.0f) {
                                    fCoerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), target2);
                                }
                                float coercedValue = fCoerceAtLeast;
                                float delta = coercedValue - prevValue.element;
                                float consumed = $this$scroll.scrollBy(delta);
                                if (delta == consumed) {
                                    if (!(coercedValue == animationScope.getValue().floatValue())) {
                                        animationScope.cancelAnimation();
                                    }
                                } else {
                                    animationScope.cancelAnimation();
                                }
                                prevValue.element += delta;
                            }
                        };
                        C06072 c06075 = c06073;
                        c06073.L$0 = $this$scroll;
                        c06073.L$1 = null;
                        c06073.L$2 = null;
                        c06073.L$3 = null;
                        c06073.label = 2;
                        if (SuspendAnimationKt.animateTo(anim4, fBoxFloat2, (4 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : null, (4 & 4) != 0 ? false : !z4, (4 & 8) != 0 ? SuspendAnimationKt.C02582.INSTANCE : function2, c06075) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result3 = $result2;
                        c06073.$this_animateScrollToItem.snapToItem($this$scroll, c06073.$index, c06073.$scrollOffset);
                        return Unit.INSTANCE;
                    } catch (ItemFoundInScroll e6) {
                        itemFound = e6;
                        c06073 = c06072;
                        $result2 = $result;
                        $this$scroll = $this$scroll4;
                    }
                    break;
                case 1:
                    c06072 = this;
                    $result = obj;
                    i = c06072.I$0;
                    minDistancePx = c06072.F$2;
                    float boundDistancePx4 = c06072.F$1;
                    float targetDistancePx4 = c06072.F$0;
                    loops = (Ref.IntRef) c06072.L$3;
                    Ref.ObjectRef anim5 = (Ref.ObjectRef) c06072.L$2;
                    Ref.BooleanRef loop4 = (Ref.BooleanRef) c06072.L$1;
                    ScrollScope $this$scroll5 = (ScrollScope) c06072.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        boundDistancePx = boundDistancePx4;
                        loop = loop4;
                        $this$scroll2 = $this$scroll5;
                        targetDistancePx = targetDistancePx4;
                        anim = anim5;
                        loops.element++;
                        f = 0.0f;
                        if (loop.element) {
                        }
                        break;
                    } catch (ItemFoundInScroll e7) {
                        itemFound = e7;
                        c06073 = c06072;
                        $result2 = $result;
                        $this$scroll = $this$scroll5;
                        break;
                    }
                    return Unit.INSTANCE;
                case 2:
                    c06073 = this;
                    $result3 = obj;
                    $this$scroll = (ScrollScope) c06073.L$0;
                    ResultKt.throwOnFailure($result3);
                    c06073.$this_animateScrollToItem.snapToItem($this$scroll, c06073.$index, c06073.$scrollOffset);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean forward, LazyLayoutAnimateScrollScope $this_animateScrollToItem, int $index, int $scrollOffset) {
            if (forward) {
                if ($this_animateScrollToItem.getFirstVisibleItemIndex() > $index) {
                    return true;
                }
                if ($this_animateScrollToItem.getFirstVisibleItemIndex() != $index || $this_animateScrollToItem.getFirstVisibleItemScrollOffset() <= $scrollOffset) {
                    return false;
                }
                return true;
            }
            if ($this_animateScrollToItem.getFirstVisibleItemIndex() < $index) {
                return true;
            }
            if ($this_animateScrollToItem.getFirstVisibleItemIndex() != $index || $this_animateScrollToItem.getFirstVisibleItemScrollOffset() >= $scrollOffset) {
                return false;
            }
            return true;
        }
    }

    public static final Object animateScrollToItem(LazyLayoutAnimateScrollScope $this$animateScrollToItem, int index, int scrollOffset, int numOfItemsForTeleport, Density density, Continuation<? super Unit> continuation) {
        Object objScroll = $this$animateScrollToItem.scroll(new C06072(index, density, $this$animateScrollToItem, scrollOffset, numOfItemsForTeleport, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }
}
