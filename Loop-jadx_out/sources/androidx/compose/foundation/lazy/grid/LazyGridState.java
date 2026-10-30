package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.Remeasurement;
import androidx.compose.p001ui.layout.RemeasurementModifier;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LazyGridState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u008c\u00012\u00020\u0001:\u0002\u008c\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\"\u0010i\u001a\u00020j2\b\b\u0001\u0010k\u001a\u00020\u00032\b\b\u0002\u0010l\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010mJ\u001f\u0010n\u001a\u00020j2\u0006\u0010o\u001a\u0002082\b\b\u0002\u0010p\u001a\u00020\u0011H\u0000¢\u0006\u0002\bqJ\u0010\u0010r\u001a\u00020j2\u0006\u0010s\u001a\u000203H\u0002J\u0010\u0010t\u001a\u00020a2\u0006\u0010u\u001a\u00020aH\u0016J\u001a\u0010v\u001a\u00020j2\u0006\u0010u\u001a\u00020a2\b\b\u0002\u0010s\u001a\u000208H\u0002J\u0015\u0010w\u001a\u00020a2\u0006\u0010x\u001a\u00020aH\u0000¢\u0006\u0002\byJC\u0010z\u001a\u00020j2\u0006\u0010{\u001a\u00020|2*\u0010}\u001a&\b\u0001\u0012\u0004\u0012\u00020\u007f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020j0\u0080\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010~¢\u0006\u0003\b\u0082\u0001H\u0096@¢\u0006\u0003\u0010\u0083\u0001J#\u0010\u0084\u0001\u001a\u00020j2\b\b\u0001\u0010k\u001a\u00020\u00032\b\b\u0002\u0010l\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010mJ\u001f\u0010\u0085\u0001\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0086\u0001J\"\u0010\u0087\u0001\u001a\u00020\u00032\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u008b\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010%R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0014R\u0014\u00100\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0014R\u0014\u00101\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0014R\u0011\u00102\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b>\u0010?*\u0004\b<\u0010=R\u001e\u0010@\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%R\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010%R\u0014\u0010D\u001a\u00020EX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\u00020MX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020QX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0014\"\u0004\bV\u0010\u0016R\"\u0010X\u001a\u0004\u0018\u00010W2\b\u0010\u0010\u001a\u0004\u0018\u00010W@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\\X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u000e\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010b\u001a\u00020a2\u0006\u0010\u0010\u001a\u00020a@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u000e\u0010e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010f\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bg\u0010%R\u000e\u0010h\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008d\u0001"}, m195d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isLastScrollBackward", "isLastScrollForward", "isScrollInProgress", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "lineToPrefetch", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "numOfItemsToTeleport", "getNumOfItemsToTeleport", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "getPlacementAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "slotsPerLine", "getSlotsPerLine$foundation_release", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "notifyPrefetch", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyGridState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<LazyGridState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, LazyGridState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Integer> invoke(SaverScope $this$listSaver, LazyGridState it) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(it.getFirstVisibleItemIndex()), Integer.valueOf(it.getFirstVisibleItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, LazyGridState>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyGridState invoke(List<? extends Integer> list) {
            return invoke2((List<Integer>) list);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyGridState invoke2(List<Integer> list) {
            return new LazyGridState(list.get(0).intValue(), list.get(1).intValue());
        }
    });
    private final LazyGridAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* JADX INFO: renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* JADX INFO: renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState<LazyGridMeasureResult> layoutInfoState;
    private int lineToPrefetch;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private boolean wasScrollingForward;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 */
    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.grid.LazyGridState", m210f = "LazyGridState.kt", m211i = {0, 0, 0}, m212l = {282, 283}, m213m = "scroll", m214n = {"this", "scrollPriority", "block"}, m215s = {"L$0", "L$1", "L$2"})
    static final class C06041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C06041(Continuation<? super C06041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyGridState.this.scroll(null, null, this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LazyGridState() {
        int i = 0;
        this(i, i, 3, null);
    }

    public LazyGridState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset) {
        this.scrollPosition = new LazyGridScrollPosition(firstVisibleItemIndex, firstVisibleItemScrollOffset);
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyGridStateKt.EmptyLazyGridLayoutInfo, SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1
            {
                super(1);
            }

            public final Float invoke(float it) {
                return Float.valueOf(-this.this$0.onScroll$foundation_release(-it));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        });
        this.prefetchingEnabled = true;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$remeasurementModifier$1
            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
            public /* synthetic */ boolean all(Function1 function1) {
                return Modifier.Element.CC.$default$all(this, function1);
            }

            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
            public /* synthetic */ boolean any(Function1 function1) {
                return Modifier.Element.CC.$default$any(this, function1);
            }

            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
            public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
                return Modifier.Element.CC.$default$foldIn(this, obj, function2);
            }

            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p001ui.Modifier
            public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
                return Modifier.Element.CC.$default$foldOut(this, obj, function2);
            }

            @Override // androidx.compose.p001ui.Modifier
            public /* synthetic */ Modifier then(Modifier modifier) {
                return Modifier.CC.$default$then(this, modifier);
            }

            @Override // androidx.compose.p001ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                this.this$0.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.placementAnimator = new LazyGridItemPlacementAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.animateScrollScope = new LazyGridAnimateScrollScope(this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.scrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m1045constructorimpl$default(null, 1, null);
        this.canScrollForward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollBackward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.prefetchState = new LazyLayoutPrefetchState(null, 1, null);
    }

    public /* synthetic */ LazyGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    /* JADX INFO: renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    /* JADX INFO: renamed from: getScrollToBeConsumed$foundation_release, reason: from getter */
    public final float getScrollToBeConsumed() {
        return this.scrollToBeConsumed;
    }

    public final int getSlotsPerLine$foundation_release() {
        return this.layoutInfoState.getValue().getSlotsPerLine();
    }

    public final Density getDensity$foundation_release() {
        return this.layoutInfoState.getValue().getDensity();
    }

    /* JADX INFO: renamed from: getNumMeasurePasses$foundation_release, reason: from getter */
    public final int getNumMeasurePasses() {
        return this.numMeasurePasses;
    }

    /* JADX INFO: renamed from: getPrefetchingEnabled$foundation_release, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    /* JADX INFO: renamed from: getRemeasurement$foundation_release, reason: from getter */
    public final Remeasurement getRemeasurement() {
        return this.remeasurement;
    }

    /* JADX INFO: renamed from: getRemeasurementModifier$foundation_release, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    /* JADX INFO: renamed from: getAwaitLayoutModifier$foundation_release, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    /* JADX INFO: renamed from: getPlacementAnimator$foundation_release, reason: from getter */
    public final LazyGridItemPlacementAnimator getPlacementAnimator() {
        return this.placementAnimator;
    }

    /* JADX INFO: renamed from: getBeyondBoundsInfo$foundation_release, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* JADX INFO: renamed from: getPinnedItems$foundation_release, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedItems() {
        return this.pinnedItems;
    }

    public final IntRange getNearestRange$foundation_release() {
        State $this$getValue$iv = this.scrollPosition.getNearestRangeState();
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1010getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public static /* synthetic */ Object scrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.scrollToItem(i, i2, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridState$scrollToItem$2 */
    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "androidx.compose.foundation.lazy.grid.LazyGridState$scrollToItem$2", m210f = "LazyGridState.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C06052 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06052(int i, int i2, Continuation<? super C06052> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$scrollOffset = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyGridState.this.new C06052(this.$index, this.$scrollOffset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C06052) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    LazyGridState.this.snapToItemIndexInternal$foundation_release(this.$index, this.$scrollOffset);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object scrollToItem(int index, int scrollOffset, Continuation<? super Unit> continuation) {
        Object objScroll$default = ScrollableState.CC.scroll$default(this, null, new C06052(index, scrollOffset, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    public final void snapToItemIndexInternal$foundation_release(int index, int scrollOffset) {
        boolean positionChanged = (this.scrollPosition.getIndex() == index && this.scrollPosition.getScrollOffset() == scrollOffset) ? false : true;
        if (positionChanged) {
            this.placementAnimator.reset();
        }
        this.scrollPosition.requestPositionAndForgetLastKnownKey(index, scrollOffset);
        Remeasurement remeasurement = this.remeasurement;
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority scrollPriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        C06041 c06041;
        LazyGridState lazyGridState;
        MutatePriority scrollPriority2;
        Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function3;
        ScrollableState scrollableState;
        if (continuation instanceof C06041) {
            c06041 = (C06041) continuation;
            if ((c06041.label & Integer.MIN_VALUE) != 0) {
                c06041.label -= Integer.MIN_VALUE;
            } else {
                c06041 = new C06041(continuation);
            }
        } else {
            c06041 = new C06041(continuation);
        }
        C06041 c06042 = c06041;
        Object $result = c06042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c06042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                lazyGridState = this;
                AwaitFirstLayoutModifier awaitFirstLayoutModifier = lazyGridState.awaitLayoutModifier;
                c06042.L$0 = lazyGridState;
                c06042.L$1 = scrollPriority;
                c06042.L$2 = function2;
                c06042.label = 1;
                if (awaitFirstLayoutModifier.waitForFirstLayout(c06042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                scrollPriority2 = scrollPriority;
                function3 = function2;
                scrollableState = lazyGridState.scrollableState;
                c06042.L$0 = null;
                c06042.L$1 = null;
                c06042.L$2 = null;
                c06042.label = 2;
                if (scrollableState.scroll(scrollPriority2, function3, c06042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                function3 = (Function2) c06042.L$2;
                scrollPriority2 = (MutatePriority) c06042.L$1;
                lazyGridState = (LazyGridState) c06042.L$0;
                ResultKt.throwOnFailure($result);
                scrollableState = lazyGridState.scrollableState;
                c06042.L$0 = null;
                c06042.L$1 = null;
                c06042.L$2 = null;
                c06042.label = 2;
                if (scrollableState.scroll(scrollPriority2, function3, c06042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private void setCanScrollForward(boolean z) {
        MutableState $this$setValue$iv = this.canScrollForward;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        State $this$getValue$iv = this.canScrollForward;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private void setCanScrollBackward(boolean z) {
        MutableState $this$setValue$iv = this.canScrollBackward;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        State $this$getValue$iv = this.canScrollBackward;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isLastScrollForward() {
        return this.scrollableState.isLastScrollForward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isLastScrollBackward() {
        return this.scrollableState.isLastScrollBackward();
    }

    public final float onScroll$foundation_release(float distance) {
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
        }
        this.scrollToBeConsumed += distance;
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) {
            LazyGridMeasureResult layoutInfo = this.layoutInfoState.getValue();
            float preScrollToBeConsumed = this.scrollToBeConsumed;
            int intDelta = MathKt.roundToInt(this.scrollToBeConsumed);
            if (layoutInfo.tryToApplyScrollWithoutRemeasure(intDelta)) {
                applyMeasureResult$foundation_release(layoutInfo, true);
                ObservableScopeInvalidator.m1049invalidateScopeimpl(this.placementScopeInvalidator);
                notifyPrefetch(preScrollToBeConsumed - this.scrollToBeConsumed, layoutInfo);
            } else {
                Remeasurement remeasurement = this.remeasurement;
                if (remeasurement != null) {
                    remeasurement.forceRemeasure();
                }
                notifyPrefetch$default(this, preScrollToBeConsumed - this.scrollToBeConsumed, null, 2, null);
            }
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            return distance;
        }
        float scrollConsumed = distance - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return scrollConsumed;
    }

    static /* synthetic */ void notifyPrefetch$default(LazyGridState lazyGridState, float f, LazyGridMeasureResult lazyGridMeasureResult, int i, Object obj) {
        if ((i & 2) != 0) {
            lazyGridMeasureResult = lazyGridState.layoutInfoState.getValue();
        }
        lazyGridState.notifyPrefetch(f, lazyGridMeasureResult);
    }

    private final void notifyPrefetch(float delta, LazyGridMeasureResult info) {
        int lineToPrefetch;
        int closestNextItemToPrefetch;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector;
        int size$iv;
        LazyLayoutPrefetchState prefetchState = this.prefetchState;
        if (this.prefetchingEnabled && (!info.getVisibleItemsInfo().isEmpty())) {
            boolean z = false;
            boolean scrollingForward = delta < 0.0f;
            if (scrollingForward) {
                LazyGridMeasuredItem it = (LazyGridMeasuredItem) CollectionsKt.last((List) info.getVisibleItemsInfo());
                lineToPrefetch = (info.getOrientation() == Orientation.Vertical ? it.getRow() : it.getColumn()) + 1;
                closestNextItemToPrefetch = ((LazyGridMeasuredItem) CollectionsKt.last((List) info.getVisibleItemsInfo())).getIndex() + 1;
            } else {
                LazyGridMeasuredItem it2 = (LazyGridMeasuredItem) CollectionsKt.first((List) info.getVisibleItemsInfo());
                lineToPrefetch = (info.getOrientation() == Orientation.Vertical ? it2.getRow() : it2.getColumn()) - 1;
                closestNextItemToPrefetch = ((LazyGridMeasuredItem) CollectionsKt.first((List) info.getVisibleItemsInfo())).getIndex() - 1;
            }
            int closestNextItemToPrefetch2 = this.lineToPrefetch;
            if (lineToPrefetch != closestNextItemToPrefetch2) {
                if (closestNextItemToPrefetch >= 0 && closestNextItemToPrefetch < info.getTotalItemsCount()) {
                    z = true;
                }
                if (z) {
                    if (this.wasScrollingForward != scrollingForward && (size$iv = (mutableVector = this.currentLinePrefetchHandles).getSize()) > 0) {
                        int i$iv = 0;
                        Object[] content$iv = mutableVector.getContent();
                        do {
                            ((LazyLayoutPrefetchState.PrefetchHandle) content$iv[i$iv]).cancel();
                            i$iv++;
                        } while (i$iv < size$iv);
                    }
                    this.wasScrollingForward = scrollingForward;
                    this.lineToPrefetch = lineToPrefetch;
                    this.currentLinePrefetchHandles.clear();
                    List<Pair<Integer, Constraints>> listInvoke = info.getPrefetchInfoRetriever().invoke(Integer.valueOf(lineToPrefetch));
                    int size = listInvoke.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv = listInvoke.get(index$iv);
                        Pair<Integer, Constraints> pair = (Pair) item$iv;
                        this.currentLinePrefetchHandles.add(prefetchState.m1040schedulePrefetch0kLqBqw(pair.getFirst().intValue(), pair.getSecond().getValue()));
                    }
                }
            }
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyGridLayoutInfo info) {
        int row;
        if (this.lineToPrefetch != -1 && (!info.getVisibleItemsInfo().isEmpty())) {
            if (this.wasScrollingForward) {
                LazyGridItemInfo it = (LazyGridItemInfo) CollectionsKt.last((List) info.getVisibleItemsInfo());
                row = (info.getOrientation() == Orientation.Vertical ? it.getRow() : it.getColumn()) + 1;
            } else {
                LazyGridItemInfo it2 = (LazyGridItemInfo) CollectionsKt.first((List) info.getVisibleItemsInfo());
                row = (info.getOrientation() == Orientation.Vertical ? it2.getRow() : it2.getColumn()) - 1;
            }
            int expectedLineToPrefetch = row;
            if (this.lineToPrefetch != expectedLineToPrefetch) {
                this.lineToPrefetch = -1;
                MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentLinePrefetchHandles;
                int size$iv = mutableVector.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = mutableVector.getContent();
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content$iv[i$iv]).cancel();
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                this.currentLinePrefetchHandles.clear();
            }
        }
    }

    /* JADX INFO: renamed from: getPrefetchState$foundation_release, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    private final int getNumOfItemsToTeleport() {
        return getSlotsPerLine$foundation_release() * 100;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int index, int scrollOffset, Continuation<? super Unit> continuation) {
        Object objAnimateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, index, scrollOffset, getNumOfItemsToTeleport(), getDensity$foundation_release(), continuation);
        return objAnimateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToItem : Unit.INSTANCE;
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyGridState lazyGridState, LazyGridMeasureResult lazyGridMeasureResult, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        lazyGridState.applyMeasureResult$foundation_release(lazyGridMeasureResult, z);
    }

    public final void applyMeasureResult$foundation_release(LazyGridMeasureResult result, boolean visibleItemsStayedTheSame) {
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.layoutInfoState.setValue(result);
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateScrollOffset(result.getFirstVisibleLineScrollOffset());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            cancelPrefetchIfVisibleItemsChanged(result);
        }
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        this.numMeasurePasses++;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyGridItemProvider itemProvider, int firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }

    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m195d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyGridState, ?> getSaver() {
            return LazyGridState.Saver;
        }
    }
}
