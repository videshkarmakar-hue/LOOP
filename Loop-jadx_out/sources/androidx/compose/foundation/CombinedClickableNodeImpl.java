package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.PointerInputScope;
import androidx.compose.p001ui.node.SemanticsModifierNodeKt;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bm\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Jx\u0010\u0014\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016ø\u0001\u0000¢\u0006\u0002\b\u0015J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m195d2 = {"Landroidx/compose/foundation/CombinedClickableNodeImpl;", "Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "update", "update-nSzSaCc", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "clickPointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class CombinedClickableNodeImpl extends AbstractClickableNode implements CombinedClickableNode {
    private Function0<Unit> onDoubleClick;
    private Function0<Unit> onLongClick;
    private String onLongClickLabel;

    public /* synthetic */ CombinedClickableNodeImpl(Function0 function0, String str, Function0 function1, Function0 function2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str2, Role role, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, function1, function2, mutableInteractionSource, indicationNodeFactory, z, str2, role);
    }

    private CombinedClickableNodeImpl(Function0<Unit> function0, String onLongClickLabel, Function0<Unit> function1, Function0<Unit> function2, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role) {
        super(interactionSource, indicationNodeFactory, enabled, onClickLabel, role, function0, null);
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = function1;
        this.onDoubleClick = function2;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object clickPointerInput(PointerInputScope $this$clickPointerInput, Continuation<? super Unit> continuation) {
        Object objDetectTapGestures = TapGestureDetectorKt.detectTapGestures($this$clickPointerInput, (!getEnabled() || this.onDoubleClick == null) ? null : new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.clickPointerInput.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m504invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m504invokek4lQ0M(long it) {
                Function0 function0 = CombinedClickableNodeImpl.this.onDoubleClick;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, (!getEnabled() || this.onLongClick == null) ? null : new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.clickPointerInput.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m505invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m505invokek4lQ0M(long it) {
                Function0 function0 = CombinedClickableNodeImpl.this.onLongClick;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, new C03154(null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.clickPointerInput.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m507invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m507invokek4lQ0M(long it) {
                if (CombinedClickableNodeImpl.this.getEnabled()) {
                    CombinedClickableNodeImpl.this.getOnClick().invoke();
                }
            }
        }, continuation);
        return objDetectTapGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$4 */
    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$4", m210f = "Clickable.kt", m211i = {}, m212l = {787}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03154 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        C03154(Continuation<? super C03154> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m506invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m506invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            C03154 c03154 = CombinedClickableNodeImpl.this.new C03154(continuation);
            c03154.L$0 = pressGestureScope;
            c03154.J$0 = j;
            return c03154.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C03154 c03154;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PressGestureScope $this$detectTapGestures = (PressGestureScope) this.L$0;
                    long offset = this.J$0;
                    if (CombinedClickableNodeImpl.this.getEnabled()) {
                        this.label = 1;
                        if (CombinedClickableNodeImpl.this.m425handlePressInteractiond4ec7I($this$detectTapGestures, offset, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03154 = this;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03154 = this;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // androidx.compose.foundation.CombinedClickableNode
    /* JADX INFO: renamed from: update-nSzSaCc */
    public void mo503updatenSzSaCc(Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role) {
        boolean resetPointerInputHandling;
        boolean resetPointerInputHandling2 = false;
        if (!Intrinsics.areEqual(this.onLongClickLabel, onLongClickLabel)) {
            this.onLongClickLabel = onLongClickLabel;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if ((this.onLongClick == null) != (onLongClick == null)) {
            disposeInteractions();
            resetPointerInputHandling2 = true;
        }
        if (!Intrinsics.areEqual(this.onLongClick, onLongClick)) {
            this.onLongClick = onLongClick;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if ((this.onDoubleClick == null) != (onDoubleClick == null)) {
            resetPointerInputHandling2 = true;
        }
        this.onDoubleClick = onDoubleClick;
        if (getEnabled() == enabled) {
            resetPointerInputHandling = resetPointerInputHandling2;
        } else {
            resetPointerInputHandling = true;
        }
        m429updateCommonQzZPfjk(interactionSource, indicationNodeFactory, enabled, onClickLabel, role, onClick);
        if (resetPointerInputHandling) {
            resetPointerInputHandler();
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver $this$applyAdditionalSemantics) {
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick($this$applyAdditionalSemantics, this.onLongClickLabel, new Function0<Boolean>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.applyAdditionalSemantics.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    Function0 function0 = CombinedClickableNodeImpl.this.onLongClick;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return true;
                }
            });
        }
    }
}
