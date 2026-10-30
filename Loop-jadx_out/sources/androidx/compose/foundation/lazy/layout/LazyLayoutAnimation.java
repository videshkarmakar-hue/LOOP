package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p001ui.graphics.GraphicsContext;
import androidx.compose.p001ui.graphics.layer.GraphicsLayer;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\bJ\u0018\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\bF\u0010\u0019J\u0006\u0010G\u001a\u00020\bJ\u0006\u0010H\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010#\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R+\u0010&\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 R+\u0010)\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\"\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u001b\u001a\u0004\u0018\u00010,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\"\u00100\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R1\u00103\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00158F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020908X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u0010\u0010R\"\u0010=\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R\u001a\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020A08X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006J"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "onLayerPropertyChanged", "Lkotlin/Function0;", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function0;)V", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "fadeOutSpec", "getFadeOutSpec", "setFadeOutSpec", "finalOffset", "Landroidx/compose/ui/unit/IntOffset;", "getFinalOffset-nOcc-ac", "()J", "setFinalOffset--gyyYBs", "(J)V", "J", "<set-?>", "", "isAppearanceAnimationInProgress", "()Z", "setAppearanceAnimationInProgress", "(Z)V", "isAppearanceAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "isDisappearanceAnimationFinished$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationInProgress$delegate", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "isPlacementAnimationInProgress$delegate", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "placementSpec", "getPlacementSpec", "setPlacementSpec", "rawOffset", "getRawOffset-nOcc-ac", "setRawOffset--gyyYBs", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "animateAppearance", "animateDisappearance", "animatePlacementDelta", "delta", "animatePlacementDelta--gyyYBs", "cancelPlacementAnimation", "release", "Companion", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyLayoutAnimation {
    private final CoroutineScope coroutineScope;
    private FiniteAnimationSpec<Float> fadeInSpec;
    private FiniteAnimationSpec<Float> fadeOutSpec;
    private long finalOffset;
    private final GraphicsContext graphicsContext;

    /* JADX INFO: renamed from: isAppearanceAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isAppearanceAnimationInProgress;

    /* JADX INFO: renamed from: isDisappearanceAnimationFinished$delegate, reason: from kotlin metadata */
    private final MutableState isDisappearanceAnimationFinished;

    /* JADX INFO: renamed from: isDisappearanceAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isDisappearanceAnimationInProgress;

    /* JADX INFO: renamed from: isPlacementAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isPlacementAnimationInProgress;
    private GraphicsLayer layer;
    private long lookaheadOffset;
    private final Function0<Unit> onLayerPropertyChanged;

    /* JADX INFO: renamed from: placementDelta$delegate, reason: from kotlin metadata */
    private final MutableState placementDelta;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private long rawOffset;
    private final Animatable<Float, AnimationVector1D> visibilityAnimation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);

    public LazyLayoutAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, Function0<Unit> function0) {
        this.coroutineScope = coroutineScope;
        this.graphicsContext = graphicsContext;
        this.onLayerPropertyChanged = function0;
        this.isPlacementAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isAppearanceAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isDisappearanceAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isDisappearanceAnimationFinished = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.rawOffset = NotInitialized;
        this.finalOffset = IntOffset.INSTANCE.m6943getZeronOccac();
        GraphicsContext graphicsContext2 = this.graphicsContext;
        this.layer = graphicsContext2 != null ? graphicsContext2.createGraphicsLayer() : null;
        this.placementDeltaAnimation = new Animatable<>(IntOffset.m6924boximpl(IntOffset.INSTANCE.m6943getZeronOccac()), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), null, null, 12, null);
        this.visibilityAnimation = new Animatable<>(Float.valueOf(1.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        this.placementDelta = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m6924boximpl(IntOffset.INSTANCE.m6943getZeronOccac()), null, 2, null);
        this.lookaheadOffset = NotInitialized;
    }

    public /* synthetic */ LazyLayoutAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, C06081 c06081, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i & 2) != 0 ? null : graphicsContext, (i & 4) != 0 ? new Function0<Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : c06081);
    }

    public final FiniteAnimationSpec<Float> getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final void setFadeInSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.fadeInSpec = finiteAnimationSpec;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        this.placementSpec = finiteAnimationSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.fadeOutSpec = finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlacementAnimationInProgress(boolean z) {
        MutableState $this$setValue$iv = this.isPlacementAnimationInProgress;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isPlacementAnimationInProgress() {
        State $this$getValue$iv = this.isPlacementAnimationInProgress;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppearanceAnimationInProgress(boolean z) {
        MutableState $this$setValue$iv = this.isAppearanceAnimationInProgress;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isAppearanceAnimationInProgress() {
        State $this$getValue$iv = this.isAppearanceAnimationInProgress;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDisappearanceAnimationInProgress(boolean z) {
        MutableState $this$setValue$iv = this.isDisappearanceAnimationInProgress;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isDisappearanceAnimationInProgress() {
        State $this$getValue$iv = this.isDisappearanceAnimationInProgress;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDisappearanceAnimationFinished(boolean z) {
        MutableState $this$setValue$iv = this.isDisappearanceAnimationFinished;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isDisappearanceAnimationFinished() {
        State $this$getValue$iv = this.isDisappearanceAnimationFinished;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getRawOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getRawOffset() {
        return this.rawOffset;
    }

    /* JADX INFO: renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m1020setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }

    /* JADX INFO: renamed from: getFinalOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getFinalOffset() {
        return this.finalOffset;
    }

    /* JADX INFO: renamed from: setFinalOffset--gyyYBs, reason: not valid java name */
    public final void m1018setFinalOffsetgyyYBs(long j) {
        this.finalOffset = j;
    }

    public final GraphicsLayer getLayer() {
        return this.layer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    public final void m1012setPlacementDeltagyyYBs(long j) {
        MutableState $this$setValue$iv = this.placementDelta;
        $this$setValue$iv.setValue(IntOffset.m6924boximpl(j));
    }

    /* JADX INFO: renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m1016getPlacementDeltanOccac() {
        State $this$getValue$iv = this.placementDelta;
        return ((IntOffset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$cancelPlacementAnimation$1 */
    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$cancelPlacementAnimation$1", m210f = "LazyLayoutAnimation.kt", m211i = {}, m212l = {111}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06131(Continuation<? super C06131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C06131 c06131;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.placementDeltaAnimation.snapTo(IntOffset.m6924boximpl(IntOffset.INSTANCE.m6943getZeronOccac()), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c06131 = this;
                    break;
                    break;
                case 1:
                    c06131 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LazyLayoutAnimation.this.m1012setPlacementDeltagyyYBs(IntOffset.INSTANCE.m6943getZeronOccac());
            LazyLayoutAnimation.this.setPlacementAnimationInProgress(false);
            return Unit.INSTANCE;
        }
    }

    public final void cancelPlacementAnimation() {
        if (isPlacementAnimationInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06131(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getLookaheadOffset() {
        return this.lookaheadOffset;
    }

    /* JADX INFO: renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public final void m1019setLookaheadOffsetgyyYBs(long j) {
        this.lookaheadOffset = j;
    }

    /* JADX INFO: renamed from: animatePlacementDelta--gyyYBs, reason: not valid java name */
    public final void m1013animatePlacementDeltagyyYBs(long delta) {
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec = this.placementSpec;
        if (finiteAnimationSpec == null) {
            return;
        }
        long arg0$iv = m1016getPlacementDeltanOccac();
        int $i$f$unpackInt1 = (int) (delta >> 32);
        int i = ((int) (arg0$iv >> 32)) - $i$f$unpackInt1;
        int $i$f$unpackInt2 = (int) (arg0$iv & 4294967295L);
        long totalDelta = IntOffsetKt.IntOffset(i, $i$f$unpackInt2 - ((int) (4294967295L & delta)));
        m1012setPlacementDeltagyyYBs(totalDelta);
        setPlacementAnimationInProgress(true);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new LazyLayoutAnimation$animatePlacementDelta$1(this, finiteAnimationSpec, totalDelta, null), 3, null);
    }

    public final void animateAppearance() {
        GraphicsLayer layer = this.layer;
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.fadeInSpec;
        if (isAppearanceAnimationInProgress() || finiteAnimationSpec == null || layer == null) {
            if (isDisappearanceAnimationInProgress()) {
                if (layer != null) {
                    layer.setAlpha(1.0f);
                }
                BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06091(null), 3, null);
                return;
            }
            return;
        }
        setAppearanceAnimationInProgress(true);
        boolean shouldResetValue = true ^ isDisappearanceAnimationInProgress();
        if (shouldResetValue) {
            layer.setAlpha(0.0f);
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06102(shouldResetValue, this, finiteAnimationSpec, layer, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1 */
    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1", m210f = "LazyLayoutAnimation.kt", m211i = {}, m212l = {176}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06091(Continuation<? super C06091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.visibilityAnimation.snapTo(Boxing.boxFloat(1.0f), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$2 */
    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$2", m210f = "LazyLayoutAnimation.kt", m211i = {}, m212l = {189, 191}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ boolean $shouldResetValue;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;
        final /* synthetic */ LazyLayoutAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06102(boolean z, LazyLayoutAnimation lazyLayoutAnimation, FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super C06102> continuation) {
            super(2, continuation);
            this.$shouldResetValue = z;
            this.this$0 = lazyLayoutAnimation;
            this.$spec = finiteAnimationSpec;
            this.$layer = graphicsLayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06102(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0072 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x0073  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$2] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$2] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$2] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r9v0 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            ?? r0;
            Animatable animatable;
            Float fBoxFloat;
            FiniteAnimationSpec<Float> finiteAnimationSpec;
            Function1<Animatable<Float, AnimationVector1D>, Unit> function1;
            ?? r1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r2 = this.label;
            try {
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        C06102 c06102 = this;
                        boolean z = c06102.$shouldResetValue;
                        r2 = c06102;
                        if (z) {
                            c06102.label = 1;
                            if (c06102.this$0.visibilityAnimation.snapTo(Boxing.boxFloat(0.0f), c06102) == coroutine_suspended) {
                                r2 = c06102;
                                return coroutine_suspended;
                            }
                        }
                        r2 = c06102;
                        animatable = r2.this$0.visibilityAnimation;
                        fBoxFloat = Boxing.boxFloat(1.0f);
                        finiteAnimationSpec = r2.$spec;
                        final GraphicsLayer graphicsLayer = r2.$layer;
                        final LazyLayoutAnimation lazyLayoutAnimation = r2.this$0;
                        function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.animateAppearance.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable2) {
                                invoke2(animatable2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Animatable<Float, AnimationVector1D> animatable2) {
                                graphicsLayer.setAlpha(animatable2.getValue().floatValue());
                                lazyLayoutAnimation.onLayerPropertyChanged.invoke();
                            }
                        };
                        r2.label = 2;
                        if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : finiteAnimationSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : function1, (Continuation) r2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r1 = r2;
                        r1.this$0.setAppearanceAnimationInProgress(false);
                        return Unit.INSTANCE;
                    case 1:
                        r2 = this;
                        ResultKt.throwOnFailure(obj);
                        r2 = c06102;
                        animatable = r2.this$0.visibilityAnimation;
                        fBoxFloat = Boxing.boxFloat(1.0f);
                        finiteAnimationSpec = r2.$spec;
                        final GraphicsLayer graphicsLayer2 = r2.$layer;
                        final LazyLayoutAnimation lazyLayoutAnimation2 = r2.this$0;
                        function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.animateAppearance.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable2) {
                                invoke2(animatable2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Animatable<Float, AnimationVector1D> animatable2) {
                                graphicsLayer2.setAlpha(animatable2.getValue().floatValue());
                                lazyLayoutAnimation2.onLayerPropertyChanged.invoke();
                            }
                        };
                        r2.label = 2;
                        if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : finiteAnimationSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : function1, (Continuation) r2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r1 = r2;
                        r1.this$0.setAppearanceAnimationInProgress(false);
                        return Unit.INSTANCE;
                    case 2:
                        r0 = this;
                        try {
                            ResultKt.throwOnFailure(obj);
                            r1 = r0;
                            r1.this$0.setAppearanceAnimationInProgress(false);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            r0.this$0.setAppearanceAnimationInProgress(false);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th3) {
                ?? r12 = r2;
                th = th3;
                r0 = r12;
            }
        }
    }

    public final void animateDisappearance() {
        GraphicsLayer layer = this.layer;
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.fadeOutSpec;
        if (layer == null || isDisappearanceAnimationInProgress() || finiteAnimationSpec == null) {
            return;
        }
        setDisappearanceAnimationInProgress(true);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06111(finiteAnimationSpec, layer, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateDisappearance$1 */
    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateDisappearance$1", m210f = "LazyLayoutAnimation.kt", m211i = {}, m212l = {210}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06111(FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super C06111> continuation) {
            super(2, continuation);
            this.$spec = finiteAnimationSpec;
            this.$layer = graphicsLayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06111(this.$spec, this.$layer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Throwable th;
            C06111 c06111;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Animatable animatable = LazyLayoutAnimation.this.visibilityAnimation;
                        Float fBoxFloat = Boxing.boxFloat(0.0f);
                        FiniteAnimationSpec<Float> finiteAnimationSpec = this.$spec;
                        final GraphicsLayer graphicsLayer = this.$layer;
                        final LazyLayoutAnimation lazyLayoutAnimation = LazyLayoutAnimation.this;
                        Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.animateDisappearance.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable2) {
                                invoke2(animatable2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Animatable<Float, AnimationVector1D> animatable2) {
                                graphicsLayer.setAlpha(animatable2.getValue().floatValue());
                                lazyLayoutAnimation.onLayerPropertyChanged.invoke();
                            }
                        };
                        this.label = 1;
                        if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : finiteAnimationSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : function1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c06111 = this;
                        LazyLayoutAnimation.this.setDisappearanceAnimationFinished(true);
                        LazyLayoutAnimation.this.setDisappearanceAnimationInProgress(false);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        c06111 = this;
                        LazyLayoutAnimation.this.setDisappearanceAnimationInProgress(false);
                        throw th;
                    }
                case 1:
                    c06111 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        LazyLayoutAnimation.this.setDisappearanceAnimationFinished(true);
                        LazyLayoutAnimation.this.setDisappearanceAnimationInProgress(false);
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        LazyLayoutAnimation.this.setDisappearanceAnimationInProgress(false);
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void release() {
        GraphicsContext graphicsContext;
        if (isPlacementAnimationInProgress()) {
            setPlacementAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06141(null), 3, null);
        }
        if (isAppearanceAnimationInProgress()) {
            setAppearanceAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06152(null), 3, null);
        }
        if (isDisappearanceAnimationInProgress()) {
            setDisappearanceAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06163(null), 3, null);
        }
        m1012setPlacementDeltagyyYBs(IntOffset.INSTANCE.m6943getZeronOccac());
        this.rawOffset = NotInitialized;
        GraphicsLayer it = this.layer;
        if (it != null && (graphicsContext = this.graphicsContext) != null) {
            graphicsContext.releaseGraphicsLayer(it);
        }
        this.layer = null;
        this.fadeInSpec = null;
        this.fadeOutSpec = null;
        this.placementSpec = null;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$release$1 */
    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$release$1", m210f = "LazyLayoutAnimation.kt", m211i = {}, m212l = {225}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06141(Continuation<? super C06141> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06141(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.placementDeltaAnimation.stop(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$release$2 */
    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$release$2", m210f = "LazyLayoutAnimation.kt", m211i = {}, m212l = {231}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06152(Continuation<? super C06152> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06152(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06152) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.visibilityAnimation.stop(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$release$3 */
    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$release$3", m210f = "LazyLayoutAnimation.kt", m211i = {}, m212l = {237}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06163 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06163(Continuation<? super C06163> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06163(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06163) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.visibilityAnimation.stop(this) == coroutine_suspended) {
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

    /* JADX INFO: compiled from: LazyLayoutAnimation.kt */
    @Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation$Companion;", "", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m1021getNotInitializednOccac() {
            return LazyLayoutAnimation.NotInitialized;
        }
    }
}
