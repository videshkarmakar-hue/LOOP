package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.node.SemanticsModifierNode;
import androidx.compose.p001ui.node.SemanticsModifierNodeKt;
import androidx.compose.p001ui.semantics.CollectionInfo;
import androidx.compose.p001ui.semantics.ScrollAxisRange;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutSemantics.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ4\u0010(\u001a\u00020)2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010*\u001a\u00020)H\u0002J\f\u0010+\u001a\u00020)*\u00020,H\u0016R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R@\u0010\u001a\u001a4\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010!\u001a \b\u0001\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0#\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u001c\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m195d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/CollectionInfo;", "indexForKeyMapping", "Lkotlin/Function1;", "", "", "isVertical", "()Z", "scrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "Lkotlin/jvm/functions/Function2;", "scrollToIndexAction", "shouldAutoInvalidate", "getShouldAutoInvalidate", "update", "", "updateCachedSemanticsValues", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class LazyLayoutSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private final Function1<Object, Integer> indexForKeyMapping = new Function1<Object, Integer>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$indexForKeyMapping$1
        {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(Object needle) {
            LazyLayoutItemProvider itemProvider = (LazyLayoutItemProvider) this.this$0.itemProviderLambda.invoke();
            int result = -1;
            int itemCount = itemProvider.getItemCount();
            for (int index = 0; index < itemCount; index++) {
                if (Intrinsics.areEqual(itemProvider.getKey(index), needle)) {
                    result = index;
                    break;
                }
            }
            return Integer.valueOf(result);
        }
    };
    private Function0<? extends LazyLayoutItemProvider> itemProviderLambda;
    private Orientation orientation;
    private boolean reverseScrolling;
    private ScrollAxisRange scrollAxisRange;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private Function1<? super Integer, Boolean> scrollToIndexAction;
    private LazyLayoutSemanticState state;
    private boolean userScrollEnabled;

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: getShouldClearDescendantSemantics */
    public /* synthetic */ boolean getIsClearingSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public LazyLayoutSemanticsModifierNode(Function0<? extends LazyLayoutItemProvider> function0, LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling) {
        this.itemProviderLambda = function0;
        this.state = state;
        this.orientation = orientation;
        this.userScrollEnabled = userScrollEnabled;
        this.reverseScrolling = reverseScrolling;
        updateCachedSemanticsValues();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    private final CollectionInfo getCollectionInfo() {
        return this.state.collectionInfo();
    }

    public final void update(Function0<? extends LazyLayoutItemProvider> itemProviderLambda, LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling) {
        this.itemProviderLambda = itemProviderLambda;
        this.state = state;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (this.userScrollEnabled != userScrollEnabled || this.reverseScrolling != reverseScrolling) {
            this.userScrollEnabled = userScrollEnabled;
            this.reverseScrolling = reverseScrolling;
            updateCachedSemanticsValues();
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        SemanticsPropertiesKt.setTraversalGroup($this$applySemantics, true);
        SemanticsPropertiesKt.indexForKey($this$applySemantics, this.indexForKeyMapping);
        if (isVertical()) {
            ScrollAxisRange scrollAxisRange = this.scrollAxisRange;
            if (scrollAxisRange == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
                scrollAxisRange = null;
            }
            SemanticsPropertiesKt.setVerticalScrollAxisRange($this$applySemantics, scrollAxisRange);
        } else {
            ScrollAxisRange scrollAxisRange2 = this.scrollAxisRange;
            if (scrollAxisRange2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
                scrollAxisRange2 = null;
            }
            SemanticsPropertiesKt.setHorizontalScrollAxisRange($this$applySemantics, scrollAxisRange2);
        }
        Function2<? super Float, ? super Float, Boolean> function2 = this.scrollByAction;
        if (function2 != null) {
            SemanticsPropertiesKt.scrollBy$default($this$applySemantics, null, function2, 1, null);
        }
        Function1<? super Integer, Boolean> function1 = this.scrollToIndexAction;
        if (function1 != null) {
            SemanticsPropertiesKt.scrollToIndex$default($this$applySemantics, null, function1, 1, null);
        }
        Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> function3 = this.scrollByOffsetAction;
        if (function3 != null) {
            SemanticsPropertiesKt.scrollByOffset($this$applySemantics, function3);
        }
        SemanticsPropertiesKt.getScrollViewportLength$default($this$applySemantics, null, new Function1<List<Float>, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.applySemantics.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<Float> list) {
                list.add(Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getViewport() - LazyLayoutSemanticsModifierNode.this.state.getContentPadding()));
                return true;
            }
        }, 1, null);
        SemanticsPropertiesKt.setCollectionInfo($this$applySemantics, getCollectionInfo());
    }

    private final void updateCachedSemanticsValues() {
        this.scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getScrollOffset());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getMaxScrollOffset());
            }
        }, this.reverseScrolling);
        this.scrollByAction = this.userScrollEnabled ? new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Float f, Float f2) {
                return invoke(f.floatValue(), f2.floatValue());
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: LazyLayoutSemantics.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$1", m210f = "LazyLayoutSemantics.kt", m211i = {}, m212l = {217}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ float $delta;
                int label;
                final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, float f, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = lazyLayoutSemanticsModifierNode;
                    this.$delta = f;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$delta, continuation);
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
                            this.label = 1;
                            if (this.this$0.state.animateScrollBy(this.$delta, this) == coroutine_suspended) {
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

            public final Boolean invoke(float x, float y) {
                float delta = LazyLayoutSemanticsModifierNode.this.isVertical() ? y : x;
                BuildersKt__Builders_commonKt.launch$default(LazyLayoutSemanticsModifierNode.this.getCoroutineScope(), null, null, new AnonymousClass1(LazyLayoutSemanticsModifierNode.this, delta, null), 3, null);
                return true;
            }
        } : null;
        this.scrollByOffsetAction = this.userScrollEnabled ? new C06304(null) : null;
        this.scrollToIndexAction = this.userScrollEnabled ? new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Boolean invoke(int index) {
                LazyLayoutItemProvider itemProvider = (LazyLayoutItemProvider) LazyLayoutSemanticsModifierNode.this.itemProviderLambda.invoke();
                if (index >= 0 && index < itemProvider.getItemCount()) {
                    BuildersKt__Builders_commonKt.launch$default(LazyLayoutSemanticsModifierNode.this.getCoroutineScope(), null, null, new AnonymousClass2(LazyLayoutSemanticsModifierNode.this, index, null), 3, null);
                    return true;
                }
                throw new IllegalArgumentException(("Can't scroll to index " + index + ", it is out of bounds [0, " + itemProvider.getItemCount() + ')').toString());
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: LazyLayoutSemantics.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$5$2", m210f = "LazyLayoutSemantics.kt", m211i = {}, m212l = {249}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ int $index;
                int label;
                final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = lazyLayoutSemanticsModifierNode;
                    this.$index = i;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$index, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (this.this$0.state.scrollToItem(this.$index, this) == coroutine_suspended) {
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
        } : null;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$4 */
    /* JADX INFO: compiled from: LazyLayoutSemantics.kt */
    @Metadata(m194d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "offset"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$4", m210f = "LazyLayoutSemantics.kt", m211i = {}, m212l = {230, 233}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06304 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
        /* synthetic */ long J$0;
        int label;

        C06304(Continuation<? super C06304> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06304 c06304 = LazyLayoutSemanticsModifierNode.this.new C06304(continuation);
            c06304.J$0 = ((Offset) obj).getPackedValue();
            return c06304;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Offset> continuation) {
            return m1041invoke3MmeM6k(offset.getPackedValue(), continuation);
        }

        /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
        public final Object m1041invoke3MmeM6k(long j, Continuation<? super Offset> continuation) {
            return ((C06304) create(Offset.m4038boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            long jOffset;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    long offset = this.J$0;
                    if (LazyLayoutSemanticsModifierNode.this.isVertical()) {
                        this.label = 1;
                        Object objAnimateScrollBy = LazyLayoutSemanticsModifierNode.this.state.animateScrollBy(Offset.m4050getYimpl(offset), this);
                        if (objAnimateScrollBy == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objAnimateScrollBy;
                        float consumed = ((Number) $result).floatValue();
                        jOffset = OffsetKt.Offset(0.0f, consumed);
                        return Offset.m4038boximpl(jOffset);
                    }
                    this.label = 2;
                    Object objAnimateScrollBy2 = LazyLayoutSemanticsModifierNode.this.state.animateScrollBy(Offset.m4049getXimpl(offset), this);
                    if (objAnimateScrollBy2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objAnimateScrollBy2;
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
