package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 r*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001rB\u008f\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0015B\u007f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0016Jy\u0010S\u001a\u00020T2\u0006\u0010N\u001a\u00028\u00002\b\b\u0002\u0010U\u001a\u00020V2W\u0010W\u001aS\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(Y\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(N\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Z\u0012\u0006\u0012\u0004\u0018\u00010\u00020X¢\u0006\u0002\b[H\u0086@¢\u0006\u0002\u0010\\J\\\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020V2B\u0010W\u001a>\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Z\u0012\u0006\u0012\u0004\u0018\u00010\u00020]¢\u0006\u0002\b[H\u0086@¢\u0006\u0002\u0010^J%\u0010_\u001a\u00028\u00002\u0006\u0010=\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010`\u001a\u00020\bH\u0002¢\u0006\u0002\u0010aJ\u000e\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\bJ\u0015\u0010d\u001a\u00020\b2\u0006\u0010c\u001a\u00020\bH\u0000¢\u0006\u0002\beJ\u001d\u0010B\u001a\u00020\b2\u0006\u0010f\u001a\u00028\u00002\u0006\u0010g\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010hJ\u0006\u0010i\u001a\u00020\bJ\u0016\u0010j\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010kJ\u0015\u0010l\u001a\u00020\u00142\u0006\u0010N\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010mJ#\u0010n\u001a\u00020T2\f\u0010o\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010p\u001a\u00028\u0000¢\u0006\u0002\u0010qR\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R+\u0010\"\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010,\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u001f\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u0011\u00100\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b0\u00101R+\u00102\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b3\u00104\"\u0004\b5\u00106R+\u00109\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u001f\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&R+\u0010=\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u00108\u001a\u0004\b>\u00104\"\u0004\b?\u00106R/\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010!R!\u0010B\u001a\u00020\b8GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bF\u0010G\u0012\u0004\bC\u0010D\u001a\u0004\bE\u00104R+\u0010H\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u001f\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001b\u0010N\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010G\u001a\u0004\bO\u0010$R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010R¨\u0006s"}, m195d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "<set-?>", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "nextValue", "getNextValue", "setNextValue", "nextValue$delegate", "offset", "getOffset", "setOffset", "offset$delegate", "getPositionalThreshold$foundation_release", NotificationCompat.CATEGORY_PROGRESS, "getProgress$annotations", "()V", "getProgress", "progress$delegate", "Landroidx/compose/runtime/State;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function4;", "anchor", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "velocity", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "newOffsetForDelta", "newOffsetForDelta$foundation_release", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)F", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "updateAnchors", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "Companion", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDragScope anchoredDragScope;

    /* JADX INFO: renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final Function1<T, Boolean> confirmValueChange;

    /* JADX INFO: renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;

    /* JADX INFO: renamed from: dragTarget$delegate, reason: from kotlin metadata */
    private final MutableState dragTarget;

    /* JADX INFO: renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* JADX INFO: renamed from: nextValue$delegate, reason: from kotlin metadata */
    private final MutableState nextValue;

    /* JADX INFO: renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;
    private final Function1<Float, Float> positionalThreshold;

    /* JADX INFO: renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* JADX INFO: renamed from: settledValue$delegate, reason: from kotlin metadata */
    private final MutableState settledValue;
    private final AnimationSpec<Float> snapAnimationSpec;

    /* JADX INFO: renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final Function0<Float> velocityThreshold;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableState", m210f = "AnchoredDraggable.kt", m211i = {0}, m212l = {PointerIconCompat.TYPE_WAIT}, m213m = "anchoredDrag", m214n = {"this"}, m215s = {"L$0"})
    static final class C03633 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03633(AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super C03633> continuation) {
            super(continuation);
            this.this$0 = anchoredDraggableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.anchoredDrag(null, null, null, this);
        }
    }

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(expression = "progress(state.settledValue, state.targetValue)", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState(T t, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function2) {
        this.positionalThreshold = function1;
        this.velocityThreshold = function0;
        this.snapAnimationSpec = animationSpec;
        this.decayAnimationSpec = decayAnimationSpec;
        this.confirmValueChange = function2;
        this.dragMutex = new MutatorMutex();
        this.currentValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.settledValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$targetValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                T currentValue;
                T t2 = (T) this.this$0.getDragTarget();
                if (t2 != null) {
                    return t2;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                float offset = anchoredDraggableState.getOffset();
                if (!Float.isNaN(offset)) {
                    currentValue = (T) anchoredDraggableState.computeTarget(offset, anchoredDraggableState.getCurrentValue(), 0.0f);
                } else {
                    currentValue = anchoredDraggableState.getCurrentValue();
                }
                return currentValue;
            }
        });
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Float>(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.progress.2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float fPositionOf = this.this$0.getAnchors().positionOf(this.this$0.getSettledValue());
                float fPositionOf2 = this.this$0.getAnchors().positionOf(this.this$0.getTargetValue());
                float fAbs = Math.abs(fPositionOf2 - fPositionOf);
                float f = 1.0f;
                if (!Float.isNaN(fAbs) && fAbs > 1.0E-6f) {
                    float fRequireOffset = (this.this$0.requireOffset() - fPositionOf) / (fPositionOf2 - fPositionOf);
                    if (fRequireOffset < 1.0E-6f) {
                        f = 0.0f;
                    } else if (fRequireOffset <= 0.999999f) {
                        f = fRequireOffset;
                    }
                }
                return Float.valueOf(f);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.emptyDraggableAnchors(), null, 2, null);
        this.nextValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.anchoredDragScope = new AnchoredDragScope(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1
            private boolean initialized;
            final /* synthetic */ AnchoredDraggableState<T> this$0;
            private float absoluteThresholdToCross = Float.NaN;
            private float min = Float.NaN;
            private float max = Float.NaN;

            {
                this.this$0 = this;
            }

            public final boolean getInitialized() {
                return this.initialized;
            }

            public final void setInitialized(boolean z) {
                this.initialized = z;
            }

            public final float getAbsoluteThresholdToCross() {
                return this.absoluteThresholdToCross;
            }

            public final void setAbsoluteThresholdToCross(float f) {
                this.absoluteThresholdToCross = f;
            }

            public final float getMin() {
                return this.min;
            }

            public final void setMin(float f) {
                this.min = f;
            }

            public final float getMax() {
                return this.max;
            }

            public final void setMax(float f) {
                this.max = f;
            }

            @Override // androidx.compose.foundation.gestures.AnchoredDragScope
            public void dragTo(float newOffset, float lastKnownVelocity) {
                float previousOffset = this.this$0.getOffset();
                this.this$0.setOffset(newOffset);
                this.this$0.setLastVelocity(lastKnownVelocity);
                boolean crossedThresholdTowardsNextAnchor = false;
                boolean isMovingForward = newOffset >= previousOffset;
                if (this.initialized) {
                    if (isMovingForward) {
                        if (newOffset >= this.absoluteThresholdToCross) {
                            crossedThresholdTowardsNextAnchor = true;
                        }
                    } else if (newOffset <= this.absoluteThresholdToCross) {
                        crossedThresholdTowardsNextAnchor = true;
                    }
                    if (crossedThresholdTowardsNextAnchor) {
                        update(isMovingForward);
                        return;
                    }
                    return;
                }
                if (!Float.isNaN(previousOffset)) {
                    initialize(isMovingForward);
                    if (isMovingForward) {
                        if (newOffset >= this.absoluteThresholdToCross) {
                            crossedThresholdTowardsNextAnchor = true;
                        }
                    } else if (newOffset <= this.absoluteThresholdToCross) {
                        crossedThresholdTowardsNextAnchor = true;
                    }
                    if (crossedThresholdTowardsNextAnchor) {
                        update(isMovingForward);
                    }
                    this.initialized = true;
                }
            }

            public final void initialize(boolean isMovingForward) {
                float currentAnchorPosition = this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue());
                Object nextAnchor = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), isMovingForward);
                if (nextAnchor == null) {
                    nextAnchor = this.this$0.getCurrentValue();
                }
                DraggableAnchors anchors = this.this$0.getAnchors();
                Intrinsics.checkNotNull(nextAnchor);
                float nextAnchorPosition = anchors.positionOf(nextAnchor);
                float relativeThreshold = (nextAnchorPosition - currentAnchorPosition) / 2.0f;
                this.absoluteThresholdToCross = currentAnchorPosition + relativeThreshold;
                this.this$0.setNextValue(nextAnchor);
            }

            public final void update(boolean isMovingForward) {
                float currentAnchorPosition = this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue());
                this.min = this.this$0.getAnchors().minAnchor();
                this.max = this.this$0.getAnchors().maxAnchor();
                boolean z = true;
                if (!(currentAnchorPosition == this.min)) {
                    z = currentAnchorPosition == this.max ? false : isMovingForward;
                }
                boolean lookUpwards = z;
                Object closestAnchor = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset(), lookUpwards);
                Object nextAnchor = closestAnchor == null ? this.this$0.getCurrentValue() : closestAnchor;
                DraggableAnchors anchors = this.this$0.getAnchors();
                Intrinsics.checkNotNull(nextAnchor);
                float nextAnchorPosition = anchors.positionOf(nextAnchor);
                if (((Boolean) this.this$0.getConfirmValueChange$foundation_release().invoke(nextAnchor)).booleanValue()) {
                    this.this$0.setCurrentValue(nextAnchor);
                }
                float relativeThreshold = (nextAnchorPosition - currentAnchorPosition) / 2.0f;
                this.absoluteThresholdToCross = currentAnchorPosition + relativeThreshold;
                this.this$0.setNextValue(nextAnchor);
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AnchoredDraggableState(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Function1 function3;
        if ((i & 32) == 0) {
            function3 = function2;
        } else {
            function3 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t) {
                    return true;
                }
            };
        }
        this(obj, function1, function0, animationSpec, decayAnimationSpec, function3);
    }

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        return this.velocityThreshold;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        return this.decayAnimationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Function1 function3;
        if ((i & 64) == 0) {
            function3 = function2;
        } else {
            function3 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t) {
                    return true;
                }
            };
        }
        this(obj, draggableAnchors, function1, function0, animationSpec, decayAnimationSpec, function3);
    }

    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function2) {
        this(t, function1, function0, animationSpec, decayAnimationSpec, function2);
        setAnchors(draggableAnchors);
        trySnapTo(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        MutableState $this$setValue$iv = this.currentValue;
        $this$setValue$iv.setValue(t);
    }

    public final T getCurrentValue() {
        State $this$getValue$iv = this.currentValue;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSettledValue(T t) {
        MutableState $this$setValue$iv = this.settledValue;
        $this$setValue$iv.setValue(t);
    }

    public final T getSettledValue() {
        State $this$getValue$iv = this.settledValue;
        return $this$getValue$iv.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(float f) {
        MutableFloatState $this$setValue$iv = this.offset;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getOffset() {
        FloatState $this$getValue$iv = this.offset;
        return $this$getValue$iv.getFloatValue();
    }

    public final float requireOffset() {
        if (!(!Float.isNaN(getOffset()))) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
        }
        return getOffset();
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float progress(T from, T to) {
        float fromOffset = getAnchors().positionOf(from);
        float toOffset = getAnchors().positionOf(to);
        float currentOffset = RangesKt.coerceIn(getOffset(), Math.min(fromOffset, toOffset), Math.max(fromOffset, toOffset));
        float fraction = (currentOffset - fromOffset) / (toOffset - fromOffset);
        if (Float.isNaN(fraction)) {
            return 1.0f;
        }
        if (fraction < 1.0E-6f) {
            return 0.0f;
        }
        if (fraction > 0.999999f) {
            return 1.0f;
        }
        return Math.abs(fraction);
    }

    public final float getProgress() {
        State $this$getValue$iv = this.progress;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        MutableFloatState $this$setValue$iv = this.lastVelocity;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getLastVelocity() {
        FloatState $this$getValue$iv = this.lastVelocity;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getDragTarget() {
        State $this$getValue$iv = this.dragTarget;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDragTarget(T t) {
        MutableState $this$setValue$iv = this.dragTarget;
        $this$setValue$iv.setValue(t);
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        MutableState $this$setValue$iv = this.anchors;
        $this$setValue$iv.setValue(draggableAnchors);
    }

    public final DraggableAnchors<T> getAnchors() {
        State $this$getValue$iv = this.anchors;
        return (DraggableAnchors) $this$getValue$iv.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0 && (Float.isNaN(anchoredDraggableState.getOffset()) || (obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset())) == null)) {
            obj = anchoredDraggableState.getTargetValue();
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    public final void updateAnchors(DraggableAnchors<T> newAnchors, T newTarget) {
        if (!Intrinsics.areEqual(getAnchors(), newAnchors)) {
            setAnchors(newAnchors);
            boolean snapSuccessful = trySnapTo(newTarget);
            if (!snapSuccessful) {
                setDragTarget(newTarget);
            }
        }
    }

    public final Object settle(float velocity, Continuation<? super Float> continuation) {
        T currentValue = getCurrentValue();
        T tComputeTarget = computeTarget(requireOffset(), currentValue, velocity);
        if (this.confirmValueChange.invoke(tComputeTarget).booleanValue()) {
            return AnchoredDraggableKt.animateToWithDecay(this, tComputeTarget, velocity, continuation);
        }
        return AnchoredDraggableKt.animateToWithDecay(this, currentValue, velocity, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        DraggableAnchors<T> anchors = getAnchors();
        float currentAnchorPosition = anchors.positionOf(currentValue);
        float velocityThresholdPx = this.velocityThreshold.invoke().floatValue();
        if (!(currentAnchorPosition == offset) && !Float.isNaN(currentAnchorPosition)) {
            if (Math.abs(velocity) >= Math.abs(velocityThresholdPx)) {
                T tClosestAnchor = anchors.closestAnchor(offset, Math.signum(velocity) > 0.0f);
                Intrinsics.checkNotNull(tClosestAnchor);
                return tClosestAnchor;
            }
            T tClosestAnchor2 = anchors.closestAnchor(offset, offset - currentAnchorPosition > 0.0f);
            Intrinsics.checkNotNull(tClosestAnchor2);
            float neighborAnchorPosition = anchors.positionOf(tClosestAnchor2);
            float distance = Math.abs(currentAnchorPosition - neighborAnchorPosition);
            float relativeThreshold = Math.abs(this.positionalThreshold.invoke(Float.valueOf(distance)).floatValue());
            float relativePosition = Math.abs(currentAnchorPosition - offset);
            if (relativePosition > relativeThreshold) {
                return tClosestAnchor2;
            }
        }
        return currentValue;
    }

    private final T getNextValue() {
        State $this$getValue$iv = this.nextValue;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNextValue(T t) {
        MutableState $this$setValue$iv = this.nextValue;
        $this$setValue$iv.setValue(t);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {959}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03622 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03622(AnchoredDraggableState<T> anchoredDraggableState, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C03622> continuation) {
            super(1, continuation);
            this.this$0 = anchoredDraggableState;
            this.$block = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03622(this.this$0, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03622) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: AnchoredDraggable.kt */
        @Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "latestAnchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {960}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<DraggableAnchors<T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$block = function3;
                this.this$0 = anchoredDraggableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(draggableAnchors, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DraggableAnchors<T> draggableAnchors = (DraggableAnchors) this.L$0;
                        Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> function3 = this.$block;
                        AnchoredDragScope anchoredDragScope = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                        this.label = 1;
                        if (function3.invoke(anchoredDragScope, draggableAnchors, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C03622 c03622;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                    this.label = 1;
                    if (AnchoredDraggableKt.restartable(new Function0<DraggableAnchors<T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final DraggableAnchors<T> invoke() {
                            return anchoredDraggableState.getAnchors();
                        }
                    }, new AnonymousClass2(this.$block, this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c03622 = this;
                    break;
                    break;
                case 1:
                    c03622 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            T tClosestAnchor = c03622.this$0.getAnchors().closestAnchor(c03622.this$0.getOffset());
            if (tClosestAnchor != null) {
                float closestAnchorOffset = c03622.this$0.getAnchors().positionOf(tClosestAnchor);
                boolean isAtClosestAnchor = Math.abs(c03622.this$0.getOffset() - closestAnchorOffset) < 0.5f;
                if (isAtClosestAnchor && c03622.this$0.getConfirmValueChange$foundation_release().invoke(tClosestAnchor).booleanValue()) {
                    c03622.this$0.setSettledValue(tClosestAnchor);
                    c03622.this$0.setCurrentValue(tClosestAnchor);
                }
            }
            Object closest = Unit.INSTANCE;
            return closest;
        }
    }

    public final Object anchoredDrag(MutatePriority dragPriority, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objMutate = this.dragMutex.mutate(dragPriority, new C03622(this, function3, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function4, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object anchoredDrag(T t, MutatePriority dragPriority, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super Unit> continuation) throws Throwable {
        C03633 c03633;
        AnchoredDraggableState<T> anchoredDraggableState;
        if (continuation instanceof C03633) {
            c03633 = (C03633) continuation;
            if ((c03633.label & Integer.MIN_VALUE) != 0) {
                c03633.label -= Integer.MIN_VALUE;
            } else {
                c03633 = new C03633(this, continuation);
            }
        } else {
            c03633 = new C03633(this, continuation);
        }
        C03633 c03634 = c03633;
        Object $result = c03634.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03634.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (getAnchors().hasAnchorFor(t)) {
                    try {
                        MutatorMutex mutatorMutex = this.dragMutex;
                        C03644 c03644 = new C03644(this, t, function4, null);
                        c03634.L$0 = this;
                        c03634.label = 1;
                        if (mutatorMutex.mutate(dragPriority, c03644, c03634) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anchoredDraggableState = this;
                        anchoredDraggableState.setDragTarget(null);
                    } catch (Throwable th) {
                        th = th;
                        anchoredDraggableState = this;
                        anchoredDraggableState.setDragTarget(null);
                        throw th;
                    }
                } else if (this.confirmValueChange.invoke(t).booleanValue()) {
                    setSettledValue(t);
                    setCurrentValue(t);
                }
                Object targetValue = Unit.INSTANCE;
                return targetValue;
            case 1:
                anchoredDraggableState = (AnchoredDraggableState) c03634.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    anchoredDraggableState.setDragTarget(null);
                    Object targetValue2 = Unit.INSTANCE;
                    return targetValue2;
                } catch (Throwable th2) {
                    th = th2;
                    anchoredDraggableState.setDragTarget(null);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4 */
    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {PointerIconCompat.TYPE_CELL}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03644 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03644(AnchoredDraggableState<T> anchoredDraggableState, T t, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super C03644> continuation) {
            super(1, continuation);
            this.this$0 = anchoredDraggableState;
            this.$targetValue = t;
            this.$block = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03644(this.this$0, this.$targetValue, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03644) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C03644 c03644;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.this$0.setDragTarget(this.$targetValue);
                    final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                    this.label = 1;
                    if (AnchoredDraggableKt.restartable(new Function0<Pair<? extends DraggableAnchors<T>, ? extends T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag.4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Pair<DraggableAnchors<T>, T> invoke() {
                            return TuplesKt.m202to(anchoredDraggableState.getAnchors(), anchoredDraggableState.getTargetValue());
                        }
                    }, new AnonymousClass2(this.$block, this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c03644 = this;
                    break;
                    break;
                case 1:
                    c03644 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (c03644.this$0.getConfirmValueChange$foundation_release().invoke(c03644.$targetValue).booleanValue()) {
                float latestTargetOffset = c03644.this$0.getAnchors().positionOf(c03644.$targetValue);
                ((AnchoredDraggableState) c03644.this$0).anchoredDragScope.dragTo(latestTargetOffset, c03644.this$0.getLastVelocity());
                c03644.this$0.setSettledValue(c03644.$targetValue);
                c03644.this$0.setCurrentValue(c03644.$targetValue);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: AnchoredDraggable.kt */
        @Metadata(m194d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2", m210f = "AnchoredDraggable.kt", m211i = {}, m212l = {PointerIconCompat.TYPE_VERTICAL_TEXT}, m213m = "invokeSuspend", m214n = {}, m215s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends DraggableAnchors<T>, ? extends T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$block = function4;
                this.this$0 = anchoredDraggableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Pair<? extends DraggableAnchors<T>, ? extends T> pair, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2 for r7v1 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    switch(r1) {
                        case 0: goto L17;
                        case 1: goto L12;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L12:
                    r0 = r7
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L3c
                L17:
                    kotlin.ResultKt.throwOnFailure(r8)
                    r1 = r7
                    java.lang.Object r2 = r1.L$0
                    kotlin.Pair r2 = (kotlin.Pair) r2
                    java.lang.Object r3 = r2.component1()
                    androidx.compose.foundation.gestures.DraggableAnchors r3 = (androidx.compose.foundation.gestures.DraggableAnchors) r3
                    java.lang.Object r2 = r2.component2()
                    kotlin.jvm.functions.Function4<androidx.compose.foundation.gestures.AnchoredDragScope, androidx.compose.foundation.gestures.DraggableAnchors<T>, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r1.$block
                    androidx.compose.foundation.gestures.AnchoredDraggableState<T> r5 = r1.this$0
                    androidx.compose.foundation.gestures.AnchoredDragScope r5 = androidx.compose.foundation.gestures.AnchoredDraggableState.access$getAnchoredDragScope$p(r5)
                    r6 = 1
                    r1.label = r6
                    java.lang.Object r2 = r4.invoke(r5, r3, r2, r1)
                    if (r2 != r0) goto L3b
                    return r0
                L3b:
                    r0 = r1
                L3c:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.C03644.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public final float newOffsetForDelta$foundation_release(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float dispatchRawDelta(float delta) {
        float newOffset = newOffsetForDelta$foundation_release(delta);
        float oldOffset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(newOffset);
        return newOffset - oldOffset;
    }

    private final boolean trySnapTo(T targetValue) {
        MutatorMutex this_$iv = this.dragMutex;
        boolean didLock$iv = this_$iv.tryLock();
        if (didLock$iv) {
            try {
                AnchoredDragScope $this$trySnapTo_u24lambda_u242_u24lambda_u241 = this.anchoredDragScope;
                float targetOffset = getAnchors().positionOf(targetValue);
                if (!Float.isNaN(targetOffset)) {
                    AnchoredDragScope.CC.dragTo$default($this$trySnapTo_u24lambda_u242_u24lambda_u241, targetOffset, 0.0f, 2, null);
                    setDragTarget(null);
                }
                setCurrentValue(targetValue);
                setSettledValue(targetValue);
            } finally {
                this_$iv.unlock();
            }
        }
        return didLock$iv;
    }

    /* JADX INFO: compiled from: AnchoredDraggable.kt */
    @Metadata(m194d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0087\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00140\rH\u0007¨\u0006\u0015"}, m195d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "confirmValueChange", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Saver Saver$default(Companion companion, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function1, Function0 function0, Function1 function2, int i, Object obj) {
            Function1 function3;
            if ((i & 16) == 0) {
                function3 = function2;
            } else {
                function3 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(T t) {
                        return true;
                    }
                };
            }
            return companion.Saver(animationSpec, decayAnimationSpec, function1, function0, function3);
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> snapAnimationSpec, final DecayAnimationSpec<Float> decayAnimationSpec, final Function1<? super Float, Float> positionalThreshold, final Function0<Float> velocityThreshold, final Function1<? super T, Boolean> confirmValueChange) {
            return SaverKt.Saver(new Function2<SaverScope, AnchoredDraggableState<T>, T>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$2
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope $this$Saver, AnchoredDraggableState<T> anchoredDraggableState) {
                    return anchoredDraggableState.getCurrentValue();
                }
            }, new Function1<T, AnchoredDraggableState<T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AnchoredDraggableState<T> invoke(T t) {
                    return new AnchoredDraggableState<>(t, positionalThreshold, velocityThreshold, snapAnimationSpec, decayAnimationSpec, confirmValueChange);
                }
            });
        }
    }
}
