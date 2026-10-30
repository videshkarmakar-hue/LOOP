package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B!\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tB!\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bB/\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ'\u0010Q\u001a\u00020#2\u0018\u0010R\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bSJ\u0019\u0010T\u001a\u00020#2\n\u0010U\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bVJ\u0017\u0010W\u001a\u00020X2\u0006\u0010B\u001a\u00028\u0000H\u0001¢\u0006\u0004\bY\u0010ZJ\b\u0010[\u001a\u00020\u0012H\u0002J\r\u0010\\\u001a\u00020XH\u0000¢\u0006\u0002\b]J\b\u0010^\u001a\u00020XH\u0002J\r\u0010_\u001a\u00020XH\u0000¢\u0006\u0002\b`J\u001d\u0010a\u001a\u00020X2\u0006\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020#H\u0000¢\u0006\u0002\bdJ\u001d\u0010a\u001a\u00020X2\u0006\u0010e\u001a\u00020\u00122\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bdJ\r\u0010h\u001a\u00020XH\u0000¢\u0006\u0002\biJ\u0015\u0010j\u001a\u00020X2\u0006\u0010e\u001a\u00020\u0012H\u0000¢\u0006\u0002\bkJ'\u0010l\u001a\u00020X2\u0018\u0010m\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030nR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boJ'\u0010l\u001a\u00020X2\u0018\u0010R\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boJ\u0019\u0010p\u001a\u00020#2\n\u0010U\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bqJ\u0015\u0010r\u001a\u00020X2\u0006\u0010s\u001a\u00020gH\u0000¢\u0006\u0002\btJ\b\u0010u\u001a\u00020XH\u0002J\u0015\u0010v\u001a\u00020X2\u0006\u00104\u001a\u00020\u0012H\u0000¢\u0006\u0002\bwJ\u0015\u0010x\u001a\u00020X2\u0006\u0010y\u001a\u00020zH\u0000¢\u0006\u0002\b{J'\u0010|\u001a\u00020X2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010B\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u0012H\u0007¢\u0006\u0004\b}\u0010~J\b\u0010\u007f\u001a\u00020\u0006H\u0016J\u000f\u0010\u0080\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020X2\u0006\u0010B\u001a\u00028\u0000H\u0000¢\u0006\u0005\b\u0083\u0001\u0010ER&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#8GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b(\u0010'R+\u0010)\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8G@AX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00104\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R7\u00108\u001a\b\u0012\u0004\u0012\u00028\u0000072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u0000078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010-\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R+\u0010>\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\u0019\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0017R+\u0010B\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010-\u001a\u0004\bC\u0010!\"\u0004\bD\u0010ER\u001b\u0010G\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bH\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010K\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u001c8F¢\u0006\u0006\u001a\u0004\bL\u0010\u001eR+\u0010M\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010-\u001a\u0004\bN\u0010'\"\u0004\bO\u0010+¨\u0006\u0088\u0001"}, m195d2 = {"Landroidx/compose/animation/core/Transition;", ExifInterface.LATITUDE_SOUTH, "", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "parentTransition", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "<set-?>", "", "_playTimeNanos", "get_playTimeNanos", "()J", "set_playTimeNanos", "(J)V", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "_transitions", "animations", "", "getAnimations", "()Ljava/util/List;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "hasInitialValueAnimations", "", "getHasInitialValueAnimations$annotations", "()V", "getHasInitialValueAnimations", "()Z", "isRunning", "isSeeking", "setSeeking$animation_core_release", "(Z)V", "isSeeking$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lastSeekedTimeNanos", "getLastSeekedTimeNanos$animation_core_release", "setLastSeekedTimeNanos$animation_core_release", DownloadUtil.CookieScheme.VALUE, "playTimeNanos", "getPlayTimeNanos", "setPlayTimeNanos", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "startTimeNanos", "getStartTimeNanos$animation_core_release", "setStartTimeNanos$animation_core_release", "startTimeNanos$delegate", "targetState", "getTargetState", "setTargetState$animation_core_release", "(Ljava/lang/Object;)V", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "transitions", "getTransitions", "updateChildrenNeeded", "getUpdateChildrenNeeded", "setUpdateChildrenNeeded", "updateChildrenNeeded$delegate", "addAnimation", "animation", "addAnimation$animation_core_release", "addTransition", "transition", "addTransition$animation_core_release", "animateTo", "", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "calculateTotalDurationNanos", "clearInitialAnimations", "clearInitialAnimations$animation_core_release", "onChildAnimationUpdated", "onDisposed", "onDisposed$animation_core_release", "onFrame", "scaledPlayTimeNanos", "scaleToEnd", "onFrame$animation_core_release", "frameTimeNanos", "durationScale", "", "onTransitionEnd", "onTransitionEnd$animation_core_release", "onTransitionStart", "onTransitionStart$animation_core_release", "removeAnimation", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "removeAnimation$animation_core_release", "removeTransition", "removeTransition$animation_core_release", "resetAnimationFraction", "fraction", "resetAnimationFraction$animation_core_release", "resetAnimations", "seekAnimations", "seekAnimations$animation_core_release", "setInitialAnimations", "animationState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialAnimations$animation_core_release", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "toString", "updateInitialValues", "updateInitialValues$animation_core_release", "updateTarget", "updateTarget$animation_core_release", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Transition<S> {
    public static final int $stable = 0;
    private final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;

    /* JADX INFO: renamed from: _playTimeNanos$delegate, reason: from kotlin metadata */
    private final MutableLongState _playTimeNanos;
    private final SnapshotStateList<Transition<?>> _transitions;

    /* JADX INFO: renamed from: isSeeking$delegate, reason: from kotlin metadata */
    private final MutableState isSeeking;
    private final String label;
    private long lastSeekedTimeNanos;
    private final Transition<?> parentTransition;

    /* JADX INFO: renamed from: segment$delegate, reason: from kotlin metadata */
    private final MutableState segment;

    /* JADX INFO: renamed from: startTimeNanos$delegate, reason: from kotlin metadata */
    private final MutableLongState startTimeNanos;

    /* JADX INFO: renamed from: targetState$delegate, reason: from kotlin metadata */
    private final MutableState targetState;

    /* JADX INFO: renamed from: totalDurationNanos$delegate, reason: from kotlin metadata */
    private final State totalDurationNanos;
    private final TransitionState<S> transitionState;

    /* JADX INFO: renamed from: updateChildrenNeeded$delegate, reason: from kotlin metadata */
    private final MutableState updateChildrenNeeded;

    public static /* synthetic */ void getHasInitialValueAnimations$annotations() {
    }

    public Transition(TransitionState<S> transitionState, Transition<?> transition, String label) {
        this.transitionState = transitionState;
        this.parentTransition = transition;
        this.label = label;
        this.targetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.segment = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this._playTimeNanos = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.startTimeNanos = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        this.updateChildrenNeeded = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.totalDurationNanos = SnapshotStateKt.derivedStateOf(new Function0<Long>(this) { // from class: androidx.compose.animation.core.Transition$totalDurationNanos$2
            final /* synthetic */ Transition<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(this.this$0.calculateTotalDurationNanos());
            }
        });
        this.transitionState.transitionConfigured$animation_core_release(this);
    }

    public /* synthetic */ Transition(TransitionState transitionState, Transition transition, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionState, transition, (i & 4) != 0 ? null : str);
    }

    public final String getLabel() {
        return this.label;
    }

    public /* synthetic */ Transition(TransitionState transitionState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(transitionState, (i & 2) != 0 ? null : str);
    }

    public Transition(TransitionState<S> transitionState, String label) {
        this(transitionState, null, label);
    }

    public Transition(S s, String label) {
        this(new MutableTransitionState(s), null, label);
    }

    public /* synthetic */ Transition(MutableTransitionState mutableTransitionState, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableTransitionState, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Transition(MutableTransitionState<S> mutableTransitionState, String label) {
        this(mutableTransitionState, null, label);
        Intrinsics.checkNotNull(mutableTransitionState, "null cannot be cast to non-null type androidx.compose.animation.core.TransitionState<S of androidx.compose.animation.core.Transition>");
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final S getTargetState() {
        return (S) this.targetState.getValue();
    }

    public final void setTargetState$animation_core_release(S s) {
        MutableState $this$setValue$iv = this.targetState;
        $this$setValue$iv.setValue(s);
    }

    private final void setSegment(Segment<S> segment) {
        MutableState $this$setValue$iv = this.segment;
        $this$setValue$iv.setValue(segment);
    }

    public final Segment<S> getSegment() {
        State $this$getValue$iv = this.segment;
        return (Segment) $this$getValue$iv.getValue();
    }

    public final boolean isRunning() {
        return getStartTimeNanos$animation_core_release() != Long.MIN_VALUE;
    }

    private final long get_playTimeNanos() {
        LongState $this$getValue$iv = this._playTimeNanos;
        return $this$getValue$iv.getLongValue();
    }

    private final void set_playTimeNanos(long j) {
        MutableLongState $this$setValue$iv = this._playTimeNanos;
        $this$setValue$iv.setLongValue(j);
    }

    public final long getPlayTimeNanos() {
        Transition<?> transition = this.parentTransition;
        return transition != null ? transition.getPlayTimeNanos() : get_playTimeNanos();
    }

    public final void setPlayTimeNanos(long value) {
        if (this.parentTransition == null) {
            set_playTimeNanos(value);
        }
    }

    public final long getStartTimeNanos$animation_core_release() {
        LongState $this$getValue$iv = this.startTimeNanos;
        return $this$getValue$iv.getLongValue();
    }

    public final void setStartTimeNanos$animation_core_release(long j) {
        MutableLongState $this$setValue$iv = this.startTimeNanos;
        $this$setValue$iv.setLongValue(j);
    }

    private final boolean getUpdateChildrenNeeded() {
        State $this$getValue$iv = this.updateChildrenNeeded;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void setUpdateChildrenNeeded(boolean z) {
        MutableState $this$setValue$iv = this.updateChildrenNeeded;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final boolean isSeeking() {
        State $this$getValue$iv = this.isSeeking;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setSeeking$animation_core_release(boolean z) {
        MutableState $this$setValue$iv = this.isSeeking;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: getLastSeekedTimeNanos$animation_core_release, reason: from getter */
    public final long getLastSeekedTimeNanos() {
        return this.lastSeekedTimeNanos;
    }

    public final void setLastSeekedTimeNanos$animation_core_release(long j) {
        this.lastSeekedTimeNanos = j;
    }

    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    public final boolean getHasInitialValueAnimations() {
        boolean z;
        boolean z2;
        List $this$fastAny$iv = this._animations;
        int index$iv$iv = 0;
        int size = $this$fastAny$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
                if (((TransitionAnimationState) item$iv$iv).getInitialValueState() != null) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            List $this$fastAny$iv2 = this._transitions;
            int size2 = $this$fastAny$iv2.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                Object item$iv$iv2 = $this$fastAny$iv2.get(index$iv$iv2);
                if (((Transition) item$iv$iv2).getHasInitialValueAnimations()) {
                    z2 = true;
                    if (z2) {
                        return false;
                    }
                }
            }
            z2 = false;
            if (z2) {
                return false;
            }
        }
        return true;
    }

    public final long getTotalDurationNanos() {
        State $this$getValue$iv = this.totalDurationNanos;
        return ((Number) $this$getValue$iv.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateTotalDurationNanos() {
        long maxDurationNanos = 0;
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            maxDurationNanos = Math.max(maxDurationNanos, ((TransitionAnimationState) item$iv).getDurationNanos$animation_core_release());
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            maxDurationNanos = Math.max(maxDurationNanos, ((Transition) item$iv2).calculateTotalDurationNanos());
        }
        return maxDurationNanos;
    }

    public final void onFrame$animation_core_release(long frameTimeNanos, float durationScale) {
        long scaledPlayTimeNanos;
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(frameTimeNanos);
        }
        long deltaT = frameTimeNanos - getStartTimeNanos$animation_core_release();
        if (durationScale == 0.0f) {
            scaledPlayTimeNanos = deltaT;
        } else {
            scaledPlayTimeNanos = MathKt.roundToLong(deltaT / durationScale);
        }
        setPlayTimeNanos(scaledPlayTimeNanos);
        onFrame$animation_core_release(scaledPlayTimeNanos, durationScale == 0.0f);
    }

    public final void onFrame$animation_core_release(long scaledPlayTimeNanos, boolean scaleToEnd) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(scaledPlayTimeNanos);
        } else if (!this.transitionState.isRunning$animation_core_release()) {
            this.transitionState.setRunning$animation_core_release(true);
        }
        setUpdateChildrenNeeded(false);
        boolean allFinished = true;
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = (TransitionAnimationState) item$iv;
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                transitionAnimationState.onPlayTimeChanged$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
            }
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                allFinished = false;
            }
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            Transition<?> transition = (Transition) item$iv2;
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.onFrame$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
            }
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                allFinished = false;
            }
        }
        if (allFinished) {
            onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionStart$animation_core_release(long frameTimeNanos) {
        setStartTimeNanos$animation_core_release(frameTimeNanos);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void onDisposed$animation_core_release() {
        onTransitionEnd$animation_core_release();
        this.transitionState.transitionRemoved$animation_core_release();
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        if (this.transitionState instanceof MutableTransitionState) {
            this.transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setPlayTimeNanos(0L);
        this.transitionState.setRunning$animation_core_release(false);
    }

    public final void seek(S initialState, S targetState, long playTimeNanos) {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), initialState) || !Intrinsics.areEqual(getTargetState(), targetState)) {
            if (!Intrinsics.areEqual(getCurrentState(), initialState) && (this.transitionState instanceof MutableTransitionState)) {
                this.transitionState.setCurrentState$animation_core_release(initialState);
            }
            setTargetState$animation_core_release(targetState);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(initialState, targetState));
        }
        List $this$fastForEach$iv = this._transitions;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Transition<?> transition = (Transition) item$iv;
            Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (transition.isSeeking()) {
                transition.seek(transition.getCurrentState(), transition.getTargetState(), playTimeNanos);
            }
        }
        List $this$fastForEach$iv2 = this._animations;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            ((TransitionAnimationState) item$iv2).seekTo$animation_core_release(playTimeNanos);
        }
        this.lastSeekedTimeNanos = playTimeNanos;
    }

    public final boolean addTransition$animation_core_release(Transition<?> transition) {
        return this._transitions.add(transition);
    }

    public final boolean removeTransition$animation_core_release(Transition<?> transition) {
        return this._transitions.remove(transition);
    }

    public final boolean addAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> animation) {
        return this._animations.add(animation);
    }

    public final void removeAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> animation) {
        this._animations.remove(animation);
    }

    public final void updateTarget$animation_core_release(S targetState) {
        if (!Intrinsics.areEqual(getTargetState(), targetState)) {
            setSegment(new SegmentImpl(getTargetState(), targetState));
            if (!Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                this.transitionState.setCurrentState$animation_core_release(getTargetState());
            }
            setTargetState$animation_core_release(targetState);
            if (!isRunning()) {
                setUpdateChildrenNeeded(true);
            }
            resetAnimations();
        }
    }

    private final void resetAnimations() {
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ((TransitionAnimationState) item$iv).resetAnimation$animation_core_release();
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            ((Transition) item$iv2).resetAnimations();
        }
    }

    public final void animateTo$animation_core_release(final S s, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1493585151);
        ComposerKt.sourceInformation($composer2, "C(animateTo)1202@49043L24,1203@49123L1245,1203@49084L1284:Transition.kt#pdpnli");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(s) : $composer2.changedInstance(s) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493585151, $dirty, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1194)");
            }
            if (!isSeeking()) {
                updateTarget$animation_core_release(s);
                if (!Intrinsics.areEqual(s, getCurrentState()) || isRunning() || getUpdateChildrenNeeded()) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart($composer2, -723523240, "CC(remember):Effects.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    final CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1097545572, "CC(remember):Transition.kt#9igjgp");
                    boolean invalid$iv = $composer2.changedInstance(coroutineScope) | (($dirty & 112) == 32);
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX INFO: renamed from: androidx.compose.animation.core.Transition$animateTo$1$1$1 */
                            /* JADX INFO: compiled from: Transition.kt */
                            @Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(m209c = "androidx.compose.animation.core.Transition$animateTo$1$1$1", m210f = "Transition.kt", m211i = {0, 1}, m212l = {1209, 1215}, m213m = "invokeSuspend", m214n = {"durationScale", "durationScale"}, m215s = {"F$0", "F$0"})
                            static final class C02601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                float F$0;
                                private /* synthetic */ Object L$0;
                                int label;
                                final /* synthetic */ Transition<S> this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C02601(Transition<S> transition, Continuation<? super C02601> continuation) {
                                    super(2, continuation);
                                    this.this$0 = transition;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    C02601 c02601 = new C02601(this.this$0, continuation);
                                    c02601.L$0 = obj;
                                    return c02601;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C02601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object $result) {
                                    C02601 c02601;
                                    final float durationScale;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            c02601 = this;
                                            CoroutineScope $this$launch = (CoroutineScope) c02601.L$0;
                                            durationScale = SuspendAnimationKt.getDurationScale($this$launch.getCoroutineContext());
                                            final Transition<S> transition = c02601.this$0;
                                            c02601.F$0 = durationScale;
                                            c02601.label = 1;
                                            if (MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.Transition.animateTo.1.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                    invoke(l.longValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                                 */
                                                public final void invoke(long it) {
                                                    if (!transition.isSeeking()) {
                                                        transition.onFrame$animation_core_release(it / 1, durationScale);
                                                    }
                                                }
                                            }, c02601) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            break;
                                        case 1:
                                            c02601 = this;
                                            durationScale = c02601.F$0;
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        case 2:
                                            c02601 = this;
                                            durationScale = c02601.F$0;
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    while (c02601.this$0.isRunning()) {
                                        final Transition<S> transition2 = c02601.this$0;
                                        c02601.F$0 = durationScale;
                                        c02601.label = 2;
                                        if (MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.Transition.animateTo.1.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                invoke(l.longValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                                            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                             */
                                            public final void invoke(long it) {
                                                if (!transition2.isSeeking()) {
                                                    transition2.onFrame$animation_core_release(it / 1, durationScale);
                                                }
                                            }
                                        }, c02601) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C02601(this, null), 1, null);
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.DisposableEffect(coroutineScope, this, (Function1) value$iv, $composer2, $dirty & 112);
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.animation.core.Transition$animateTo$2
                final /* synthetic */ Transition<S> $tmp1_rcvr;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$tmp1_rcvr = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                public final void invoke(Composer composer, int i) {
                    this.$tmp1_rcvr.animateTo$animation_core_release(s, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public final void seekAnimations$animation_core_release(long playTimeNanos) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            setStartTimeNanos$animation_core_release(playTimeNanos);
        }
        setPlayTimeNanos(playTimeNanos);
        setUpdateChildrenNeeded(false);
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ((TransitionAnimationState) item$iv).seekTo$animation_core_release(playTimeNanos);
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            Transition<?> transition = (Transition) item$iv2;
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.seekAnimations$animation_core_release(playTimeNanos);
            }
        }
    }

    public final void setInitialAnimations$animation_core_release(SeekableTransitionState.SeekingAnimationState animationState) {
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ((TransitionAnimationState) item$iv).setInitialValueAnimation$animation_core_release(animationState);
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            ((Transition) item$iv2).setInitialAnimations$animation_core_release(animationState);
        }
    }

    public final void resetAnimationFraction$animation_core_release(float fraction) {
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ((TransitionAnimationState) item$iv).resetAnimationValue$animation_core_release(fraction);
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            ((Transition) item$iv2).resetAnimationFraction$animation_core_release(fraction);
        }
    }

    public final void clearInitialAnimations$animation_core_release() {
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ((TransitionAnimationState) item$iv).clearInitialAnimation$animation_core_release();
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            ((Transition) item$iv2).clearInitialAnimations$animation_core_release();
        }
    }

    public final void updateInitialValues$animation_core_release() {
        List $this$fastForEach$iv = this._animations;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ((TransitionAnimationState) item$iv).updateInitialValue$animation_core_release();
        }
        List $this$fastForEach$iv2 = this._transitions;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            ((Transition) item$iv2).updateInitialValues$animation_core_release();
        }
    }

    public String toString() {
        List<Transition<S>.TransitionAnimationState<?, ?>> animations = getAnimations();
        String str = "Transition animation values: ";
        int size = animations.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = animations.get(index$iv$iv);
            String acc = str;
            str = acc + ((TransitionAnimationState) item$iv$iv) + ", ";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded(true);
        if (isSeeking()) {
            long maxDurationNanos = 0;
            List $this$fastForEach$iv = this._animations;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = (TransitionAnimationState) item$iv;
                maxDurationNanos = Math.max(maxDurationNanos, transitionAnimationState.getDurationNanos$animation_core_release());
                transitionAnimationState.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded(false);
        }
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m194d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B3\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010I\u001a\u00020JH\u0000¢\u0006\u0002\bKJ\u001d\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020(H\u0000¢\u0006\u0002\bOJ\r\u0010P\u001a\u00020JH\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020J2\u0006\u0010S\u001a\u000202H\u0000¢\u0006\u0002\bTJ\u0015\u0010U\u001a\u00020J2\u0006\u0010M\u001a\u00020\u001dH\u0000¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020J2\u0006\u0010X\u001a\u00020\"H\u0000¢\u0006\u0002\bYJ\b\u0010Z\u001a\u00020\nH\u0016J!\u0010[\u001a\u00020J2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010\\\u001a\u00020(H\u0002¢\u0006\u0002\u0010]J-\u0010^\u001a\u00020J2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010:\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020JH\u0000¢\u0006\u0002\bbJ%\u0010c\u001a\u00020J2\u0006\u0010:\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\bd\u0010eRC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010)\u001a\u00020(2\u0006\u0010\f\u001a\u00020(8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0014\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010/\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R+\u00103\u001a\u0002022\u0006\u0010\f\u001a\u0002028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b4\u00105\"\u0004\b6\u00107R+\u0010:\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\u0014\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010C\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00018V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010\u0014\u001a\u0004\bD\u0010<\"\u0004\bE\u0010>R\u0010\u0010G\u001a\u00028\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010H¨\u0006f"}, m195d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "initialValueAnimation", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core_release", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core_release", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "interruptionSpec", "", "isFinished", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished$delegate", "isSeeking", "getLabel", "()Ljava/lang/String;", "", "resetSnapValue", "getResetSnapValue$animation_core_release", "()F", "setResetSnapValue$animation_core_release", "(F)V", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "useOnlyInitialValue", DownloadUtil.CookieScheme.VALUE, "getValue", "setValue$animation_core_release", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "clearInitialAnimation", "", "clearInitialAnimation$animation_core_release", "onPlayTimeChanged", "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core_release", "resetAnimation", "resetAnimation$animation_core_release", "resetAnimationValue", "fraction", "resetAnimationValue$animation_core_release", "seekTo", "seekTo$animation_core_release", "setInitialValueAnimation", "animationState", "setInitialValueAnimation$animation_core_release", "toString", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialValue", "updateInitialValue$animation_core_release", "updateTargetValue", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {

        /* JADX INFO: renamed from: animation$delegate, reason: from kotlin metadata */
        private final MutableState animation;
        private TargetBasedAnimation<T, V> initialValueAnimation;
        private SeekableTransitionState.SeekingAnimationState initialValueState;
        private final FiniteAnimationSpec<T> interruptionSpec;
        private boolean isSeeking;
        private final String label;

        /* JADX INFO: renamed from: targetValue$delegate, reason: from kotlin metadata */
        private final MutableState targetValue;
        private final TwoWayConverter<T, V> typeConverter;
        private boolean useOnlyInitialValue;

        /* JADX INFO: renamed from: value$delegate, reason: from kotlin metadata */
        private final MutableState value;
        private V velocityVector;

        /* JADX INFO: renamed from: animationSpec$delegate, reason: from kotlin metadata */
        private final MutableState animationSpec = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), null, 2, null);

        /* JADX INFO: renamed from: isFinished$delegate, reason: from kotlin metadata */
        private final MutableState isFinished = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);

        /* JADX INFO: renamed from: resetSnapValue$delegate, reason: from kotlin metadata */
        private final MutableFloatState resetSnapValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1.0f);

        public TransitionAnimationState(T t, V v, TwoWayConverter<T, V> twoWayConverter, String label) {
            Object visibilityThreshold;
            this.typeConverter = twoWayConverter;
            this.label = label;
            this.targetValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            this.animation = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), this.typeConverter, t, getTargetValue(), v), null, 2, null);
            this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            this.velocityVector = v;
            Float f = VisibilityThresholdsKt.getVisibilityThresholdMap().get(this.typeConverter);
            if (f == null) {
                visibilityThreshold = null;
            } else {
                float it = f.floatValue();
                V vInvoke = this.typeConverter.getConvertToVector().invoke(t);
                int size = vInvoke.getSize();
                for (int id = 0; id < size; id++) {
                    vInvoke.set$animation_core_release(id, it);
                }
                visibilityThreshold = this.typeConverter.getConvertFromVector().invoke(vInvoke);
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, visibilityThreshold, 3, null);
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final String getLabel() {
            return this.label;
        }

        private final T getTargetValue() {
            State $this$getValue$iv = this.targetValue;
            return $this$getValue$iv.getValue();
        }

        private final void setTargetValue(T t) {
            MutableState $this$setValue$iv = this.targetValue;
            $this$setValue$iv.setValue(t);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> finiteAnimationSpec) {
            MutableState $this$setValue$iv = this.animationSpec;
            $this$setValue$iv.setValue(finiteAnimationSpec);
        }

        public final FiniteAnimationSpec<T> getAnimationSpec() {
            State $this$getValue$iv = this.animationSpec;
            return (FiniteAnimationSpec) $this$getValue$iv.getValue();
        }

        private final void setAnimation(TargetBasedAnimation<T, V> targetBasedAnimation) {
            MutableState $this$setValue$iv = this.animation;
            $this$setValue$iv.setValue(targetBasedAnimation);
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            State $this$getValue$iv = this.animation;
            return (TargetBasedAnimation) $this$getValue$iv.getValue();
        }

        /* JADX INFO: renamed from: getInitialValueState$animation_core_release, reason: from getter */
        public final SeekableTransitionState.SeekingAnimationState getInitialValueState() {
            return this.initialValueState;
        }

        public final void setInitialValueState$animation_core_release(SeekableTransitionState.SeekingAnimationState seekingAnimationState) {
            this.initialValueState = seekingAnimationState;
        }

        public final boolean isFinished$animation_core_release() {
            State $this$getValue$iv = this.isFinished;
            return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
        }

        public final void setFinished$animation_core_release(boolean z) {
            MutableState $this$setValue$iv = this.isFinished;
            $this$setValue$iv.setValue(Boolean.valueOf(z));
        }

        public final float getResetSnapValue$animation_core_release() {
            FloatState $this$getValue$iv = this.resetSnapValue;
            return $this$getValue$iv.getFloatValue();
        }

        public final void setResetSnapValue$animation_core_release(float f) {
            MutableFloatState $this$setValue$iv = this.resetSnapValue;
            $this$setValue$iv.setFloatValue(f);
        }

        @Override // androidx.compose.runtime.State
        public T getValue() {
            State $this$getValue$iv = this.value;
            return $this$getValue$iv.getValue();
        }

        public void setValue$animation_core_release(T t) {
            MutableState $this$setValue$iv = this.value;
            $this$setValue$iv.setValue(t);
        }

        public final long getDurationNanos$animation_core_release() {
            return getAnimation().getDurationNanos();
        }

        public final void onPlayTimeChanged$animation_core_release(long playTimeNanos, boolean scaleToEnd) {
            long durationNanos = scaleToEnd ? getAnimation().getDurationNanos() : playTimeNanos;
            setValue$animation_core_release(getAnimation().getValueFromNanos(durationNanos));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(durationNanos);
            if (getAnimation().isFinishedFromNanos(durationNanos)) {
                setFinished$animation_core_release(true);
            }
        }

        public final void seekTo$animation_core_release(long playTimeNanos) {
            if (!(getResetSnapValue$animation_core_release() == -1.0f)) {
                return;
            }
            this.isSeeking = true;
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                setValue$animation_core_release(getAnimation().getTargetValue());
            } else {
                setValue$animation_core_release(getAnimation().getValueFromNanos(playTimeNanos));
                this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(playTimeNanos);
            }
        }

        public final void updateInitialValue$animation_core_release() {
            TargetBasedAnimation<T, V> targetBasedAnimation;
            SeekableTransitionState.SeekingAnimationState animState = this.initialValueState;
            if (animState == null || (targetBasedAnimation = this.initialValueAnimation) == null) {
                return;
            }
            long initialPlayTimeNanos = MathKt.roundToLong(animState.getDurationNanos() * animState.getValue());
            T valueFromNanos = targetBasedAnimation.getValueFromNanos(initialPlayTimeNanos);
            if (this.useOnlyInitialValue) {
                getAnimation().setMutableTargetValue$animation_core_release(valueFromNanos);
            }
            getAnimation().setMutableInitialValue$animation_core_release(valueFromNanos);
            if ((getResetSnapValue$animation_core_release() == -2.0f) || this.useOnlyInitialValue) {
                setValue$animation_core_release(valueFromNanos);
            } else {
                seekTo$animation_core_release(Transition.this.getPlayTimeNanos());
            }
            if (initialPlayTimeNanos >= animState.getDurationNanos()) {
                this.initialValueState = null;
                this.initialValueAnimation = null;
            } else {
                animState.setComplete(false);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i & 2) != 0) {
                z = false;
            }
            transitionAnimationState.updateAnimation(obj, z);
        }

        private final void updateAnimation(T initialValue, boolean isInterrupted) {
            AnimationSpec spec;
            TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
            if (Intrinsics.areEqual(targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null, getTargetValue())) {
                setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, initialValue, initialValue, AnimationVectorsKt.newInstance(this.velocityVector)));
                this.useOnlyInitialValue = true;
                return;
            }
            FiniteAnimationSpec<T> animationSpec = (!isInterrupted || this.isSeeking || (getAnimationSpec() instanceof SpringSpec)) ? getAnimationSpec() : this.interruptionSpec;
            if (Transition.this.getPlayTimeNanos() <= 0) {
                spec = animationSpec;
            } else {
                spec = AnimationSpecKt.delayed(animationSpec, Transition.this.getPlayTimeNanos());
            }
            setAnimation(new TargetBasedAnimation<>(spec, this.typeConverter, initialValue, getTargetValue(), this.velocityVector));
            this.useOnlyInitialValue = false;
            Transition.this.onChildAnimationUpdated();
        }

        public final void resetAnimation$animation_core_release() {
            setResetSnapValue$animation_core_release(-2.0f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void resetAnimationValue$animation_core_release(float fraction) {
            Object animationValue;
            if (!(fraction == -4.0f)) {
                if (!(fraction == -5.0f)) {
                    setResetSnapValue$animation_core_release(fraction);
                    return;
                }
            }
            TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
            if (targetBasedAnimation != null) {
                getAnimation().setMutableInitialValue$animation_core_release(targetBasedAnimation.getTargetValue());
                this.initialValueState = null;
                this.initialValueAnimation = null;
            }
            if (fraction == -4.0f) {
                animationValue = getAnimation().getInitialValue();
            } else {
                animationValue = getAnimation().getTargetValue();
            }
            getAnimation().setMutableInitialValue$animation_core_release(animationValue);
            getAnimation().setMutableTargetValue$animation_core_release(animationValue);
            setValue$animation_core_release(animationValue);
        }

        public final void setInitialValueAnimation$animation_core_release(SeekableTransitionState.SeekingAnimationState animationState) {
            if (!Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                this.initialValueAnimation = getAnimation();
                this.initialValueState = animationState;
            }
            setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, getValue(), getValue(), AnimationVectorsKt.newInstance(this.velocityVector)));
            this.useOnlyInitialValue = true;
        }

        public final void clearInitialAnimation$animation_core_release() {
            this.initialValueAnimation = null;
            this.initialValueState = null;
            this.useOnlyInitialValue = false;
        }

        public String toString() {
            return "current value: " + getValue() + ", target: " + getTargetValue() + ", spec: " + getAnimationSpec();
        }

        public final void updateTargetValue$animation_core_release(T targetValue, FiniteAnimationSpec<T> animationSpec) {
            if (this.useOnlyInitialValue) {
                TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
                if (Intrinsics.areEqual(targetValue, targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null)) {
                    return;
                }
            }
            if (Intrinsics.areEqual(getTargetValue(), targetValue)) {
                if (getResetSnapValue$animation_core_release() == -1.0f) {
                    return;
                }
            }
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            updateAnimation((getResetSnapValue$animation_core_release() > (-3.0f) ? 1 : (getResetSnapValue$animation_core_release() == (-3.0f) ? 0 : -1)) == 0 ? targetValue : getValue(), !isFinished$animation_core_release());
            setFinished$animation_core_release(getResetSnapValue$animation_core_release() == -3.0f);
            if (getResetSnapValue$animation_core_release() >= 0.0f) {
                long duration = getAnimation().getDurationNanos();
                setValue$animation_core_release(getAnimation().getValueFromNanos((long) (duration * getResetSnapValue$animation_core_release())));
            } else {
                if (getResetSnapValue$animation_core_release() == -3.0f) {
                    setValue$animation_core_release(targetValue);
                }
            }
            this.useOnlyInitialValue = false;
            setResetSnapValue$animation_core_release(-1.0f);
        }

        public final void updateInitialAndTargetValue$animation_core_release(T initialValue, T targetValue, FiniteAnimationSpec<T> animationSpec) {
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), initialValue) && Intrinsics.areEqual(getAnimation().getTargetValue(), targetValue)) {
                return;
            }
            updateAnimation$default(this, initialValue, false, 2, null);
        }
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, m195d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        @Override // androidx.compose.animation.core.Transition.Segment
        public /* synthetic */ boolean isTransitioningTo(Object obj, Object obj2) {
            return Segment.CC.$default$isTransitioningTo(this, obj, obj2);
        }

        public SegmentImpl(S s, S s2) {
            this.initialState = s;
            this.targetState = s2;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getTargetState() {
            return this.targetState;
        }

        public boolean equals(Object other) {
            return (other instanceof Segment) && Intrinsics.areEqual(getInitialState(), ((Segment) other).getInitialState()) && Intrinsics.areEqual(getTargetState(), ((Segment) other).getTargetState());
        }

        public int hashCode() {
            S initialState = getInitialState();
            int iHashCode = (initialState != null ? initialState.hashCode() : 0) * 31;
            S targetState = getTargetState();
            return iHashCode + (targetState != null ? targetState.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m194d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, m195d2 = {"Landroidx/compose/animation/core/Transition$Segment;", ExifInterface.LATITUDE_SOUTH, "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public interface Segment<S> {
        S getInitialState();

        S getTargetState();

        boolean isTransitioningTo(S s, S s2);

        /* JADX INFO: renamed from: androidx.compose.animation.core.Transition$Segment$-CC, reason: invalid class name */
        /* JADX INFO: compiled from: Transition.kt */
        public final /* synthetic */ class CC {
            public static boolean $default$isTransitioningTo(Segment _this, Object $this$isTransitioningTo, Object targetState) {
                return Intrinsics.areEqual($this$isTransitioningTo, _this.getInitialState()) && Intrinsics.areEqual(targetState, _this.getTargetState());
            }
        }

        /* JADX INFO: compiled from: Transition.kt */
        @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class DefaultImpls {
            @Deprecated
            public static <S> boolean isTransitioningTo(Segment<S> segment, S s, S s2) {
                return CC.$default$isTransitioningTo(segment, s, s2);
            }
        }
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(m194d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001&B#\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJT\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192#\u0010\u001a\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d0\u001b¢\u0006\u0002\b\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00028\u00010\u001bJ\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%R{\u0010\r\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f2.\u0010\n\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, m195d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core_release", "DeferredAnimationData", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public final class DeferredAnimation<T, V extends AnimationVector> {

        /* JADX INFO: renamed from: data$delegate, reason: from kotlin metadata */
        private final MutableState data = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        private final String label;
        private final TwoWayConverter<T, V> typeConverter;

        public DeferredAnimation(TwoWayConverter<T, V> twoWayConverter, String label) {
            this.typeConverter = twoWayConverter;
            this.label = label;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final String getLabel() {
            return this.label;
        }

        public final Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> getData$animation_core_release() {
            State $this$getValue$iv = this.data;
            return (DeferredAnimationData) $this$getValue$iv.getValue();
        }

        public final void setData$animation_core_release(Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> deferredAnimationData) {
            MutableState $this$setValue$iv = this.data;
            $this$setValue$iv.setValue(deferredAnimationData);
        }

        /* JADX INFO: compiled from: Transition.kt */
        @Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bk\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0002\u0010\u0011J\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\nR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, m195d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTargetValueByState", "()Lkotlin/jvm/functions/Function1;", "setTargetValueByState", "(Lkotlin/jvm/functions/Function1;)V", "getTransitionSpec", "setTransitionSpec", DownloadUtil.CookieScheme.VALUE, "getValue", "()Ljava/lang/Object;", "updateAnimationStates", "", "segment", "animation-core_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            private final Transition<S>.TransitionAnimationState<T, V> animation;
            private Function1<? super S, ? extends T> targetValueByState;
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1, Function1<? super S, ? extends T> function2) {
                this.animation = transitionAnimationState;
                this.transitionSpec = function1;
                this.targetValueByState = function2;
            }

            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            public final void setTransitionSpec(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1) {
                this.transitionSpec = function1;
            }

            public final Function1<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            public final void setTargetValueByState(Function1<? super S, ? extends T> function1) {
                this.targetValueByState = function1;
            }

            public final void updateAnimationStates(Segment<S> segment) {
                T tInvoke = this.targetValueByState.invoke(segment.getTargetState());
                if (Transition.this.isSeeking()) {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), tInvoke, this.transitionSpec.invoke(segment));
                } else {
                    this.animation.updateTargetValue$animation_core_release(tInvoke, this.transitionSpec.invoke(segment));
                }
            }

            @Override // androidx.compose.runtime.State
            public T getValue() {
                updateAnimationStates(Transition.this.getSegment());
                return this.animation.getValue();
            }
        }

        public final State<T> animate(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec, Function1<? super S, ? extends T> targetValueByState) {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release == null) {
                data$animation_core_release = new DeferredAnimationData<>(Transition.this.new TransitionAnimationState(targetValueByState.invoke(Transition.this.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, targetValueByState.invoke(Transition.this.getCurrentState())), this.typeConverter, this.label), transitionSpec, targetValueByState);
                Transition<S> transition = Transition.this;
                setData$animation_core_release(data$animation_core_release);
                transition.addAnimation$animation_core_release(data$animation_core_release.getAnimation());
            }
            Transition<S> transition2 = Transition.this;
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> deferredAnimationData = data$animation_core_release;
            deferredAnimationData.setTargetValueByState(targetValueByState);
            deferredAnimationData.setTransitionSpec(transitionSpec);
            deferredAnimationData.updateAnimationStates(transition2.getSegment());
            return data$animation_core_release;
        }

        public final void setupSeeking$animation_core_release() {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release != null) {
                Transition<S> transition = Transition.this;
                data$animation_core_release.getAnimation().updateInitialAndTargetValue$animation_core_release(data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getInitialState()), data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getTargetState()), data$animation_core_release.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    public final void removeAnimation$animation_core_release(Transition<S>.DeferredAnimation<?, ?> deferredAnimation) {
        Transition<S>.TransitionAnimationState<?, ?> animation;
        Transition<S>.DeferredAnimationData<?, ?>.DeferredAnimationData<?, V> data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release != 0 && (animation = data$animation_core_release.getAnimation()) != null) {
            removeAnimation$animation_core_release(animation);
        }
    }
}
