package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014J\u000e\u0010\u0015\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u0003*\u0004\u0018\u00010\rH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m195d2 = {"Landroidx/compose/material/FloatingActionButtonElevationAnimatable;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "F", "lastTargetInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "targetInteraction", "animateElevation", "", "to", "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "snapElevation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateElevation", "updateElevation-lDy3nrA", "(FFFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateTarget", "calculateTarget-u2uoSUM", "(Landroidx/compose/foundation/interaction/Interaction;)F", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class FloatingActionButtonElevationAnimatable {
    private final Animatable<C1979Dp, AnimationVector1D> animatable;
    private float defaultElevation;
    private float focusedElevation;
    private float hoveredElevation;
    private Interaction lastTargetInteraction;
    private float pressedElevation;
    private Interaction targetInteraction;

    /* JADX INFO: renamed from: androidx.compose.material.FloatingActionButtonElevationAnimatable$animateElevation$1 */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.FloatingActionButtonElevationAnimatable", m210f = "FloatingActionButton.kt", m211i = {0, 0}, m212l = {397}, m213m = "animateElevation", m214n = {"this", "to"}, m215s = {"L$0", "L$1"})
    static final class C10301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10301(Continuation<? super C10301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FloatingActionButtonElevationAnimatable.this.animateElevation(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.FloatingActionButtonElevationAnimatable$snapElevation$1 */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.material.FloatingActionButtonElevationAnimatable", m210f = "FloatingActionButton.kt", m211i = {0}, m212l = {383}, m213m = "snapElevation", m214n = {"this"}, m215s = {"L$0"})
    static final class C10311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10311(Continuation<? super C10311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FloatingActionButtonElevationAnimatable.this.snapElevation(this);
        }
    }

    public /* synthetic */ FloatingActionButtonElevationAnimatable(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private FloatingActionButtonElevationAnimatable(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation) {
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.hoveredElevation = hoveredElevation;
        this.focusedElevation = focusedElevation;
        this.animatable = new Animatable<>(C1979Dp.m6799boximpl(this.defaultElevation), VectorConvertersKt.getVectorConverter(C1979Dp.INSTANCE), null, null, 12, null);
    }

    /* JADX INFO: renamed from: calculateTarget-u2uoSUM, reason: not valid java name */
    private final float m1714calculateTargetu2uoSUM(Interaction $this$calculateTarget_u2du2uoSUM) {
        if ($this$calculateTarget_u2du2uoSUM instanceof PressInteraction.Press) {
            return this.pressedElevation;
        }
        if ($this$calculateTarget_u2du2uoSUM instanceof HoverInteraction.Enter) {
            return this.hoveredElevation;
        }
        return $this$calculateTarget_u2du2uoSUM instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
    }

    /* JADX INFO: renamed from: updateElevation-lDy3nrA, reason: not valid java name */
    public final Object m1715updateElevationlDy3nrA(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation, Continuation<? super Unit> continuation) throws Throwable {
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.hoveredElevation = hoveredElevation;
        this.focusedElevation = focusedElevation;
        Object objSnapElevation = snapElevation(continuation);
        return objSnapElevation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapElevation : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object snapElevation(Continuation<? super Unit> continuation) throws Throwable {
        C10311 c10311;
        Throwable th;
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable;
        if (continuation instanceof C10311) {
            c10311 = (C10311) continuation;
            if ((c10311.label & Integer.MIN_VALUE) != 0) {
                c10311.label -= Integer.MIN_VALUE;
            } else {
                c10311 = new C10311(continuation);
            }
        } else {
            c10311 = new C10311(continuation);
        }
        C10311 c10312 = c10311;
        Object $result = c10312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c10312.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                float target = m1714calculateTargetu2uoSUM(this.targetInteraction);
                if (!C1979Dp.m6806equalsimpl0(this.animatable.getTargetValue().m6815unboximpl(), target)) {
                    try {
                        Animatable<C1979Dp, AnimationVector1D> animatable = this.animatable;
                        C1979Dp c1979DpM6799boximpl = C1979Dp.m6799boximpl(target);
                        c10312.L$0 = this;
                        c10312.label = 1;
                        if (animatable.snapTo(c1979DpM6799boximpl, c10312) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        floatingActionButtonElevationAnimatable = this;
                        floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
                    } catch (Throwable th2) {
                        th = th2;
                        floatingActionButtonElevationAnimatable = this;
                        floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
                        throw th;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                floatingActionButtonElevationAnimatable = (FloatingActionButtonElevationAnimatable) c10312.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    floatingActionButtonElevationAnimatable.lastTargetInteraction = floatingActionButtonElevationAnimatable.targetInteraction;
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object animateElevation(Interaction to, Continuation<? super Unit> continuation) throws Throwable {
        C10301 c10301;
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable;
        Throwable th;
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable2;
        if (continuation instanceof C10301) {
            c10301 = (C10301) continuation;
            if ((c10301.label & Integer.MIN_VALUE) != 0) {
                c10301.label -= Integer.MIN_VALUE;
            } else {
                c10301 = new C10301(continuation);
            }
        } else {
            c10301 = new C10301(continuation);
        }
        C10301 c10302 = c10301;
        Object $result = c10302.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c10302.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                floatingActionButtonElevationAnimatable = this;
                float target = floatingActionButtonElevationAnimatable.m1714calculateTargetu2uoSUM(to);
                floatingActionButtonElevationAnimatable.targetInteraction = to;
                try {
                    if (!C1979Dp.m6806equalsimpl0(floatingActionButtonElevationAnimatable.animatable.getTargetValue().m6815unboximpl(), target)) {
                        Animatable<C1979Dp, AnimationVector1D> animatable = floatingActionButtonElevationAnimatable.animatable;
                        Interaction interaction = floatingActionButtonElevationAnimatable.lastTargetInteraction;
                        c10302.L$0 = floatingActionButtonElevationAnimatable;
                        c10302.L$1 = to;
                        c10302.label = 1;
                        if (ElevationKt.m1692animateElevationrAjV9yQ(animatable, target, interaction, to, c10302) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        floatingActionButtonElevationAnimatable2 = floatingActionButtonElevationAnimatable;
                        floatingActionButtonElevationAnimatable = floatingActionButtonElevationAnimatable2;
                    }
                    floatingActionButtonElevationAnimatable.lastTargetInteraction = to;
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    floatingActionButtonElevationAnimatable2 = floatingActionButtonElevationAnimatable;
                    floatingActionButtonElevationAnimatable2.lastTargetInteraction = to;
                    throw th;
                }
            case 1:
                to = (Interaction) c10302.L$1;
                floatingActionButtonElevationAnimatable2 = (FloatingActionButtonElevationAnimatable) c10302.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    floatingActionButtonElevationAnimatable = floatingActionButtonElevationAnimatable2;
                    floatingActionButtonElevationAnimatable.lastTargetInteraction = to;
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    floatingActionButtonElevationAnimatable2.lastTargetInteraction = to;
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final State<C1979Dp> asState() {
        return this.animatable.asState();
    }
}
