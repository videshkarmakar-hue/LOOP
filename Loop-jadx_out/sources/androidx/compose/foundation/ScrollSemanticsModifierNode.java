package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.node.SemanticsModifierNode;
import androidx.compose.p001ui.semantics.ScrollAxisRange;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0010\"\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, m195d2 = {"Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "isScrollable", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "setFlingBehavior", "(Landroidx/compose/foundation/gestures/FlingBehavior;)V", "()Z", "setScrollable", "(Z)V", "setVertical", "getReverseScrolling", "setReverseScrolling", "getState", "()Landroidx/compose/foundation/ScrollState;", "setState", "(Landroidx/compose/foundation/ScrollState;)V", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ScrollSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private FlingBehavior flingBehavior;
    private boolean isScrollable;
    private boolean isVertical;
    private boolean reverseScrolling;
    private ScrollState state;

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: getShouldClearDescendantSemantics */
    public /* synthetic */ boolean getIsClearingSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final ScrollState getState() {
        return this.state;
    }

    public final void setState(ScrollState scrollState) {
        this.state = scrollState;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final void setReverseScrolling(boolean z) {
        this.reverseScrolling = z;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final void setFlingBehavior(FlingBehavior flingBehavior) {
        this.flingBehavior = flingBehavior;
    }

    /* JADX INFO: renamed from: isScrollable, reason: from getter */
    public final boolean getIsScrollable() {
        return this.isScrollable;
    }

    public final void setScrollable(boolean z) {
        this.isScrollable = z;
    }

    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }

    public ScrollSemanticsModifierNode(ScrollState state, boolean reverseScrolling, FlingBehavior flingBehavior, boolean isScrollable, boolean isVertical) {
        this.state = state;
        this.reverseScrolling = reverseScrolling;
        this.flingBehavior = flingBehavior;
        this.isScrollable = isScrollable;
        this.isVertical = isVertical;
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        SemanticsPropertiesKt.setTraversalGroup($this$applySemantics, true);
        ScrollAxisRange accessibilityScrollState = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$accessibilityScrollState$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.this$0.getState().getValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$accessibilityScrollState$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.this$0.getState().getMaxValue());
            }
        }, this.reverseScrolling);
        if (this.isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange($this$applySemantics, accessibilityScrollState);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange($this$applySemantics, accessibilityScrollState);
        }
        if (this.isScrollable) {
            SemanticsPropertiesKt.scrollBy$default($this$applySemantics, null, new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.ScrollSemanticsModifierNode.applySemantics.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Boolean invoke(Float f, Float f2) {
                    return invoke(f.floatValue(), f2.floatValue());
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: Scroll.kt */
                @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m209c = "androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$1$1", m210f = "Scroll.kt", m211i = {}, m212l = {361, 363}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: $x */
                    final /* synthetic */ float f36$x;

                    /* JADX INFO: renamed from: $y */
                    final /* synthetic */ float f37$y;
                    int label;
                    final /* synthetic */ ScrollSemanticsModifierNode this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ScrollSemanticsModifierNode scrollSemanticsModifierNode, float f, float f2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = scrollSemanticsModifierNode;
                        this.f37$y = f;
                        this.f36$x = f2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.f37$y, this.f36$x, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                if (this.this$0.getIsVertical()) {
                                    ScrollState state = this.this$0.getState();
                                    Intrinsics.checkNotNull(state, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                    this.label = 1;
                                    if (ScrollExtensionsKt.animateScrollBy$default(state, this.f37$y, null, this, 2, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    ScrollState state2 = this.this$0.getState();
                                    Intrinsics.checkNotNull(state2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                    this.label = 2;
                                    if (ScrollExtensionsKt.animateScrollBy$default(state2, this.f36$x, null, this, 2, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            case 2:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }

                public final Boolean invoke(float x, float y) {
                    BuildersKt__Builders_commonKt.launch$default(ScrollSemanticsModifierNode.this.getCoroutineScope(), null, null, new AnonymousClass1(ScrollSemanticsModifierNode.this, y, x, null), 3, null);
                    return true;
                }
            }, 1, null);
            SemanticsPropertiesKt.scrollByOffset($this$applySemantics, new C03402(null));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$2 */
    /* JADX INFO: compiled from: Scroll.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "offset"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.ScrollSemanticsModifierNode$applySemantics$2", m210f = "Scroll.kt", m211i = {}, m212l = {372, 375}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C03402 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
        /* synthetic */ long J$0;
        int label;

        C03402(Continuation<? super C03402> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03402 c03402 = ScrollSemanticsModifierNode.this.new C03402(continuation);
            c03402.J$0 = ((Offset) obj).getPackedValue();
            return c03402;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Offset> continuation) {
            return m545invoke3MmeM6k(offset.getPackedValue(), continuation);
        }

        /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
        public final Object m545invoke3MmeM6k(long j, Continuation<? super Offset> continuation) {
            return ((C03402) create(Offset.m4038boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            long jOffset;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    long offset = this.J$0;
                    if (ScrollSemanticsModifierNode.this.getIsVertical()) {
                        ScrollState state = ScrollSemanticsModifierNode.this.getState();
                        Intrinsics.checkNotNull(state, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                        this.label = 1;
                        Object objAnimateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(state, Offset.m4050getYimpl(offset), null, this, 2, null);
                        if (objAnimateScrollBy$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objAnimateScrollBy$default;
                        float consumed = ((Number) $result).floatValue();
                        jOffset = OffsetKt.Offset(0.0f, consumed);
                        return Offset.m4038boximpl(jOffset);
                    }
                    ScrollState state2 = ScrollSemanticsModifierNode.this.getState();
                    Intrinsics.checkNotNull(state2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                    this.label = 2;
                    Object objAnimateScrollBy$default2 = ScrollExtensionsKt.animateScrollBy$default(state2, Offset.m4049getXimpl(offset), null, this, 2, null);
                    if (objAnimateScrollBy$default2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objAnimateScrollBy$default2;
                    float consumed2 = ((Number) $result).floatValue();
                    jOffset = OffsetKt.Offset(consumed2, 0.0f);
                    return Offset.m4038boximpl(jOffset);
                case 1:
                    ResultKt.throwOnFailure($result);
                    float consumed3 = ((Number) $result).floatValue();
                    jOffset = OffsetKt.Offset(0.0f, consumed3);
                    return Offset.m4038boximpl(jOffset);
                case 2:
                    ResultKt.throwOnFailure($result);
                    float consumed4 = ((Number) $result).floatValue();
                    jOffset = OffsetKt.Offset(consumed4, 0.0f);
                    return Offset.m4038boximpl(jOffset);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
