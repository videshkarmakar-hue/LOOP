package com.google.accompanist.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.videshkarmakar.loop.util.DownloadUtil;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: PagerState.kt */
/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "\naccompanist/pager is deprecated.\nThe androidx.compose equivalent of Insets is Pager.\nFor more migration information, please visit https://google.github.io/accompanist/pager/#migration\n", replaceWith = @ReplaceWith(expression = "PagerState(currentPage = currentPage)", imports = {"androidx.compose.foundation.pager.PagerState"}))
@Metadata(m194d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 _2\u00020\u0001:\u0001_B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010?\u001a\u00020@2\b\b\u0001\u0010A\u001a\u00020\u00032\b\b\u0003\u0010B\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010CJF\u0010?\u001a\u00020@2\b\b\u0001\u0010A\u001a\u00020\u00032\b\b\u0003\u0010B\u001a\u00020\u001a2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001a0E2\b\b\u0002\u0010F\u001a\u00020\u001a2\b\b\u0002\u0010G\u001a\u00020+H\u0087@¢\u0006\u0002\u0010HJ\u0010\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u001aH\u0016J\r\u0010K\u001a\u00020@H\u0000¢\u0006\u0002\bLJ\u0018\u0010M\u001a\u00020@2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010N\u001a\u00020OH\u0002J\u0018\u0010P\u001a\u00020@2\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020OH\u0002J?\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020S2'\u0010T\u001a#\b\u0001\u0012\u0004\u0012\u00020V\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0W\u0012\u0006\u0012\u0004\u0018\u00010X0U¢\u0006\u0002\bYH\u0096@¢\u0006\u0002\u0010ZJ\"\u0010[\u001a\u00020@2\b\b\u0001\u0010A\u001a\u00020\u00032\b\b\u0003\u0010B\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010CJ\b\u0010\\\u001a\u00020OH\u0016J\r\u0010]\u001a\u00020@H\u0000¢\u0006\u0002\b^R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R/\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038G@@X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR?\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001f2\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010,R+\u0010-\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\u0004R\u0014\u00101\u001a\u000202X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u00105\u001a\u0004\u0018\u00010\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0018R!\u00107\u001a\u00020\u00038GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b;\u0010\u001e\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010\bR\u001a\u0010<\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u00109\u001a\u0004\b>\u0010\b¨\u0006`"}, m195d2 = {"Lcom/google/accompanist/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "(I)V", "<set-?>", "_currentPage", "get_currentPage", "()I", "set_currentPage", "_currentPage$delegate", "Landroidx/compose/runtime/MutableState;", "animationTargetPage", "getAnimationTargetPage", "()Ljava/lang/Integer;", "setAnimationTargetPage", "(Ljava/lang/Integer;)V", "animationTargetPage$delegate", DownloadUtil.CookieScheme.VALUE, "getCurrentPage", "setCurrentPage$pager_release", "currentPageLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getCurrentPageLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListItemInfo;", "currentPageOffset", "", "getCurrentPageOffset", "()F", "currentPageOffset$delegate", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "flingAnimationTarget", "getFlingAnimationTarget$pager_release", "()Lkotlin/jvm/functions/Function0;", "setFlingAnimationTarget$pager_release", "(Lkotlin/jvm/functions/Function0;)V", "flingAnimationTarget$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "", "()Z", "itemSpacing", "getItemSpacing$pager_release", "setItemSpacing$pager_release", "itemSpacing$delegate", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "getLazyListState$pager_release", "()Landroidx/compose/foundation/lazy/LazyListState;", "mostVisiblePageLayoutInfo", "getMostVisiblePageLayoutInfo$pager_release", "pageCount", "getPageCount$annotations", "()V", "getPageCount", "pageCount$delegate", "targetPage", "getTargetPage$annotations", "getTargetPage", "animateScrollToPage", "", "page", "pageOffset", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "initialVelocity", "skipPages", "(IFLandroidx/compose/animation/core/AnimationSpec;FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "onScrollFinished", "onScrollFinished$pager_release", "requireCurrentPage", "name", "", "requireCurrentPageOffset", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "toString", "updateCurrentPageBasedOnLazyListState", "updateCurrentPageBasedOnLazyListState$pager_release", "Companion", "pager_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PagerState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<PagerState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, PagerState, List<? extends Object>>() { // from class: com.google.accompanist.pager.PagerState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Object> invoke(SaverScope listSaver, PagerState it) {
            Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt.listOf(Integer.valueOf(it.getCurrentPage()));
        }
    }, new Function1<List<? extends Object>, PagerState>() { // from class: com.google.accompanist.pager.PagerState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final PagerState invoke(List<? extends Object> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Object obj = it.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new PagerState(((Integer) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: _currentPage$delegate, reason: from kotlin metadata */
    private final MutableState _currentPage;

    /* JADX INFO: renamed from: animationTargetPage$delegate, reason: from kotlin metadata */
    private final MutableState animationTargetPage;

    /* JADX INFO: renamed from: currentPageOffset$delegate, reason: from kotlin metadata */
    private final State currentPageOffset;

    /* JADX INFO: renamed from: flingAnimationTarget$delegate, reason: from kotlin metadata */
    private final MutableState flingAnimationTarget;

    /* JADX INFO: renamed from: itemSpacing$delegate, reason: from kotlin metadata */
    private final MutableState itemSpacing;
    private final LazyListState lazyListState;

    /* JADX INFO: renamed from: pageCount$delegate, reason: from kotlin metadata */
    private final State pageCount;

    /* JADX INFO: renamed from: com.google.accompanist.pager.PagerState$animateScrollToPage$2 */
    /* JADX INFO: compiled from: PagerState.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.pager.PagerState", m210f = "PagerState.kt", m211i = {0, 0, 0, 1, 2, 2, 2, 3, 4, 4, 4, 4, 5}, m212l = {234, 239, 242, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 257, 269}, m213m = "animateScrollToPage", m214n = {"this", "page", "pageOffset", "this", "this", "page", "pageOffset", "this", "this", "page", "pageOffset", "currentSize", "this"}, m215s = {"L$0", "I$0", "F$0", "L$0", "L$0", "I$0", "F$0", "L$0", "L$0", "I$0", "F$0", "I$1", "L$0"})
    static final class C26762 extends ContinuationImpl {
        float F$0;
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C26762(Continuation<? super C26762> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerState.this.animateScrollToPage(0, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: com.google.accompanist.pager.PagerState$scrollToPage$1 */
    /* JADX INFO: compiled from: PagerState.kt */
    @Metadata(m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.pager.PagerState", m210f = "PagerState.kt", m211i = {0, 0, 1}, m212l = {HttpStatusCodesKt.HTTP_NOT_MODIFIED, 310}, m213m = "scrollToPage", m214n = {"this", "pageOffset", "this"}, m215s = {"L$0", "F$0", "L$0"})
    static final class C26781 extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C26781(Continuation<? super C26781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerState.this.scrollToPage(0, 0.0f, this);
        }
    }

    public PagerState() {
        this(0, 1, null);
    }

    @Deprecated(message = "pageCount is deprecated, use androidx.compose.foundation.pager.PagerState.canScrollForward or androidx.compose.foundation.pager.PagerState.canScrollBackward")
    public static /* synthetic */ void getPageCount$annotations() {
    }

    @Deprecated(message = "targetPage is deprecated in favor of currentPage as currentPage property isnow being updated right after we over scrolled the half of the previous current page.If you still think that you need targetPage, not currentPage please file a bug as we are planning to remove this property in future.", replaceWith = @ReplaceWith(expression = "currentPage", imports = {}))
    public static /* synthetic */ void getTargetPage$annotations() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public /* synthetic */ boolean getCanScrollBackward() {
        return ScrollableState.CC.$default$getCanScrollBackward(this);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public /* synthetic */ boolean getCanScrollForward() {
        return ScrollableState.CC.$default$getCanScrollForward(this);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public /* synthetic */ boolean isLastScrollBackward() {
        return ScrollableState.CC.$default$isLastScrollBackward(this);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public /* synthetic */ boolean isLastScrollForward() {
        return ScrollableState.CC.$default$isLastScrollForward(this);
    }

    public PagerState(int currentPage) {
        this.lazyListState = new LazyListState(currentPage, 0, 2, null);
        this._currentPage = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(currentPage), null, 2, null);
        this.itemSpacing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.pageCount = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.google.accompanist.pager.PagerState$pageCount$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(this.this$0.getLazyListState().getLayoutInfo().getTotalItemsCount());
            }
        });
        this.currentPageOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.google.accompanist.pager.PagerState$currentPageOffset$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float fCoerceIn;
                LazyListItemInfo it = this.this$0.getCurrentPageLayoutInfo();
                if (it != null) {
                    fCoerceIn = RangesKt.coerceIn((-it.getOffset()) / (it.getSize() + this.this$0.getItemSpacing$pager_release()), -0.5f, 0.5f);
                } else {
                    fCoerceIn = 0.0f;
                }
                return Float.valueOf(fCoerceIn);
            }
        });
        this.animationTargetPage = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.flingAnimationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public /* synthetic */ PagerState(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: getLazyListState$pager_release, reason: from getter */
    public final LazyListState getLazyListState() {
        return this.lazyListState;
    }

    private final int get_currentPage() {
        State $this$getValue$iv = this._currentPage;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    private final void set_currentPage(int i) {
        MutableState $this$setValue$iv = this._currentPage;
        $this$setValue$iv.setValue(Integer.valueOf(i));
    }

    public final LazyListItemInfo getMostVisiblePageLayoutInfo$pager_release() {
        Object maxElem$iv;
        LazyListLayoutInfo layoutInfo = this.lazyListState.getLayoutInfo();
        Iterable $this$maxByOrNull$iv = layoutInfo.getVisibleItemsInfo();
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            maxElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                LazyListItemInfo it = (LazyListItemInfo) maxElem$iv;
                int start = Math.max(it.getOffset(), 0);
                int end = Math.min(it.getOffset() + it.getSize(), layoutInfo.getViewportEndOffset() - layoutInfo.getAfterContentPadding());
                int maxValue$iv = end - start;
                do {
                    Object e$iv = iterator$iv.next();
                    LazyListItemInfo it2 = (LazyListItemInfo) e$iv;
                    int start2 = Math.max(it2.getOffset(), 0);
                    int end2 = Math.min(it2.getOffset() + it2.getSize(), layoutInfo.getViewportEndOffset() - layoutInfo.getAfterContentPadding());
                    int end3 = end2 - start2;
                    if (maxValue$iv < end3) {
                        maxElem$iv = e$iv;
                        maxValue$iv = end3;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            maxElem$iv = null;
        }
        return (LazyListItemInfo) maxElem$iv;
    }

    public final int getItemSpacing$pager_release() {
        State $this$getValue$iv = this.itemSpacing;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    public final void setItemSpacing$pager_release(int i) {
        MutableState $this$setValue$iv = this.itemSpacing;
        $this$setValue$iv.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LazyListItemInfo getCurrentPageLayoutInfo() {
        Object element$iv;
        List<LazyListItemInfo> visibleItemsInfo = this.lazyListState.getLayoutInfo().getVisibleItemsInfo();
        ListIterator<LazyListItemInfo> listIterator = visibleItemsInfo.listIterator(visibleItemsInfo.size());
        while (listIterator.hasPrevious()) {
            element$iv = listIterator.previous();
            LazyListItemInfo it = (LazyListItemInfo) element$iv;
            if (it.getIndex() == getCurrentPage()) {
                return (LazyListItemInfo) element$iv;
            }
        }
        element$iv = null;
        return (LazyListItemInfo) element$iv;
    }

    public final InteractionSource getInteractionSource() {
        return this.lazyListState.getInteractionSource();
    }

    public final int getPageCount() {
        State $this$getValue$iv = this.pageCount;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    public final int getCurrentPage() {
        return get_currentPage();
    }

    public final void setCurrentPage$pager_release(int value) {
        if (value != get_currentPage()) {
            set_currentPage(value);
        }
    }

    public final float getCurrentPageOffset() {
        State $this$getValue$iv = this.currentPageOffset;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    private final Integer getAnimationTargetPage() {
        State $this$getValue$iv = this.animationTargetPage;
        return (Integer) $this$getValue$iv.getValue();
    }

    private final void setAnimationTargetPage(Integer num) {
        MutableState $this$setValue$iv = this.animationTargetPage;
        $this$setValue$iv.setValue(num);
    }

    public final Function0<Integer> getFlingAnimationTarget$pager_release() {
        State $this$getValue$iv = this.flingAnimationTarget;
        return (Function0) $this$getValue$iv.getValue();
    }

    public final void setFlingAnimationTarget$pager_release(Function0<Integer> function0) {
        MutableState $this$setValue$iv = this.flingAnimationTarget;
        $this$setValue$iv.setValue(function0);
    }

    public final int getTargetPage() {
        Integer animationTargetPage = getAnimationTargetPage();
        if (animationTargetPage == null) {
            Function0<Integer> flingAnimationTarget$pager_release = getFlingAnimationTarget$pager_release();
            animationTargetPage = flingAnimationTarget$pager_release != null ? flingAnimationTarget$pager_release.invoke() : null;
            if (animationTargetPage == null) {
                if (isScrollInProgress() && Math.abs(getCurrentPageOffset()) >= 0.001f) {
                    return getCurrentPageOffset() < 0.0f ? RangesKt.coerceAtLeast(getCurrentPage() - 1, 0) : RangesKt.coerceAtMost(getCurrentPage() + 1, getPageCount() - 1);
                }
                return getCurrentPage();
            }
        }
        return animationTargetPage.intValue();
    }

    @Deprecated(message = "Replaced with animateScrollToPage(page, pageOffset)", replaceWith = @ReplaceWith(expression = "animateScrollToPage(page = page, pageOffset = pageOffset)", imports = {}))
    public final Object animateScrollToPage(int page, float pageOffset, AnimationSpec<Float> animationSpec, float initialVelocity, boolean skipPages, Continuation<? super Unit> continuation) throws Throwable {
        Object objAnimateScrollToPage = animateScrollToPage(page, pageOffset, continuation);
        return objAnimateScrollToPage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToPage : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.animateScrollToPage(i, f, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:? A[LOOP:0: B:82:0x01d5->B:113:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f9 A[Catch: all -> 0x0228, TryCatch #2 {all -> 0x0228, blocks: (B:49:0x00ee, B:51:0x00f9, B:56:0x010f, B:37:0x00a7, B:39:0x00bc, B:41:0x00c0, B:43:0x00c6, B:42:0x00c3), top: B:108:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x010b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x010c  */
    /* JADX WARN: Code duplicated, block: B:56:0x010f A[Catch: all -> 0x0228, TRY_LEAVE, TryCatch #2 {all -> 0x0228, blocks: (B:49:0x00ee, B:51:0x00f9, B:56:0x010f, B:37:0x00a7, B:39:0x00bc, B:41:0x00c0, B:43:0x00c6, B:42:0x00c3), top: B:108:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0130 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0131  */
    /* JADX WARN: Code duplicated, block: B:63:0x014c A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:13:0x003c, B:81:0x01c4, B:82:0x01d5, B:84:0x01db, B:91:0x01f1, B:93:0x01f6, B:95:0x0201, B:21:0x005e, B:60:0x0135, B:61:0x0146, B:63:0x014c, B:70:0x0161, B:72:0x0166, B:76:0x0187, B:78:0x0194, B:27:0x007b), top: B:105:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:65:0x015a  */
    /* JADX WARN: Code duplicated, block: B:66:0x015c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0166 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:13:0x003c, B:81:0x01c4, B:82:0x01d5, B:84:0x01db, B:91:0x01f1, B:93:0x01f6, B:95:0x0201, B:21:0x005e, B:60:0x0135, B:61:0x0146, B:63:0x014c, B:70:0x0161, B:72:0x0166, B:76:0x0187, B:78:0x0194, B:27:0x007b), top: B:105:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x0187 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:13:0x003c, B:81:0x01c4, B:82:0x01d5, B:84:0x01db, B:91:0x01f1, B:93:0x01f6, B:95:0x0201, B:21:0x005e, B:60:0x0135, B:61:0x0146, B:63:0x014c, B:70:0x0161, B:72:0x0166, B:76:0x0187, B:78:0x0194, B:27:0x007b), top: B:105:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0194 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:13:0x003c, B:81:0x01c4, B:82:0x01d5, B:84:0x01db, B:91:0x01f1, B:93:0x01f6, B:95:0x0201, B:21:0x005e, B:60:0x0135, B:61:0x0146, B:63:0x014c, B:70:0x0161, B:72:0x0166, B:76:0x0187, B:78:0x0194, B:27:0x007b), top: B:105:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01c3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x01db A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:13:0x003c, B:81:0x01c4, B:82:0x01d5, B:84:0x01db, B:91:0x01f1, B:93:0x01f6, B:95:0x0201, B:21:0x005e, B:60:0x0135, B:61:0x0146, B:63:0x014c, B:70:0x0161, B:72:0x0166, B:76:0x0187, B:78:0x0194, B:27:0x007b), top: B:105:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:93:0x01f6 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:13:0x003c, B:81:0x01c4, B:82:0x01d5, B:84:0x01db, B:91:0x01f1, B:93:0x01f6, B:95:0x0201, B:21:0x005e, B:60:0x0135, B:61:0x0146, B:63:0x014c, B:70:0x0161, B:72:0x0166, B:76:0x0187, B:78:0x0194, B:27:0x007b), top: B:105:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:97:0x021f A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0090: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY] A[D('this' com.google.accompanist.pager.PagerState)]), block:B:35:0x0090 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public final Object animateScrollToPage(int page, float pageOffset, Continuation<? super Unit> continuation) throws Throwable {
        C26762 c26762;
        PagerState pagerState;
        PagerState pagerState2;
        float pageOffset2;
        int page2;
        PagerState pagerState3;
        float pageOffset3;
        int page3;
        LazyListState lazyListState;
        C26773 c26773;
        float pageOffset4;
        PagerState pagerState4;
        int page4;
        float pageOffset5;
        LazyListState lazyListState2;
        LazyListLayoutInfo layoutInfo;
        Iterator it;
        Object element$iv;
        LazyListItemInfo target;
        int currentSize;
        LazyListState lazyListState3;
        int iRoundToInt;
        LazyListState lazyListState4;
        int iRoundToInt2;
        LazyListItemInfo it2;
        boolean z;
        LazyListItemInfo target2;
        LazyListState lazyListState5;
        int iRoundToInt3;
        LazyListItemInfo it3;
        boolean z2;
        if (continuation instanceof C26762) {
            c26762 = (C26762) continuation;
            if ((c26762.label & Integer.MIN_VALUE) != 0) {
                c26762.label -= Integer.MIN_VALUE;
            } else {
                c26762 = new C26762(continuation);
            }
        } else {
            c26762 = new C26762(continuation);
        }
        Object $result = c26762.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PagerState pagerState5 = c26762.label;
        Object obj = null;
        try {
            try {
                switch (pagerState5) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        pagerState2 = this;
                        pagerState2.requireCurrentPage(page, "page");
                        pagerState2.requireCurrentPageOffset(pageOffset, "pageOffset");
                        try {
                            pagerState2.setAnimationTargetPage(Boxing.boxInt(page));
                            int oldPage = pagerState2.lazyListState.getFirstVisibleItemIndex();
                            if (Math.abs(page - oldPage) > 3) {
                                LazyListState lazyListState6 = pagerState2.lazyListState;
                                int i = page > oldPage ? page - 3 : page + 3;
                                c26762.L$0 = pagerState2;
                                c26762.I$0 = page;
                                c26762.F$0 = pageOffset;
                                c26762.label = 1;
                                if (LazyListState.scrollToItem$default(lazyListState6, i, 0, c26762, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                pagerState3 = pagerState2;
                                pageOffset3 = pageOffset;
                                page3 = page;
                                pageOffset2 = pageOffset3;
                                page2 = page3;
                                pagerState2 = pagerState3;
                            } else {
                                pageOffset2 = pageOffset;
                                page2 = page;
                            }
                            if (Math.abs(pageOffset2) <= 0.005f) {
                                lazyListState2 = pagerState2.lazyListState;
                                c26762.L$0 = pagerState2;
                                c26762.label = 2;
                                if (LazyListState.animateScrollToItem$default(lazyListState2, page2, 0, c26762, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                pagerState4 = pagerState2;
                                pagerState4.onScrollFinished$pager_release();
                                return Unit.INSTANCE;
                            }
                            lazyListState = pagerState2.lazyListState;
                            c26773 = new C26773(null);
                            c26762.L$0 = pagerState2;
                            c26762.I$0 = page2;
                            c26762.F$0 = pageOffset2;
                            c26762.label = 3;
                            pageOffset4 = pageOffset2;
                            if (ScrollableState.CC.scroll$default(lazyListState, null, c26773, c26762, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pagerState4 = pagerState2;
                            page4 = page2;
                            pageOffset5 = pageOffset4;
                            layoutInfo = pagerState4.lazyListState.getLayoutInfo();
                            Iterable $this$firstOrNull$iv = layoutInfo.getVisibleItemsInfo();
                            it = $this$firstOrNull$iv.iterator();
                            do {
                                if (it.hasNext()) {
                                    element$iv = it.next();
                                    it2 = (LazyListItemInfo) element$iv;
                                    if (it2.getIndex() == page4) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else {
                                    element$iv = null;
                                }
                                target = (LazyListItemInfo) element$iv;
                                if (target != null) {
                                    lazyListState4 = pagerState4.lazyListState;
                                    iRoundToInt2 = MathKt.roundToInt((target.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                    c26762.L$0 = pagerState4;
                                    c26762.label = 4;
                                    if (lazyListState4.animateScrollToItem(page4, iRoundToInt2, c26762) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                                    currentSize = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getSize() + pagerState4.getItemSpacing$pager_release();
                                    lazyListState3 = pagerState4.lazyListState;
                                    iRoundToInt = MathKt.roundToInt(currentSize * pageOffset5);
                                    c26762.L$0 = pagerState4;
                                    c26762.I$0 = page4;
                                    c26762.F$0 = pageOffset5;
                                    c26762.I$1 = currentSize;
                                    c26762.label = 5;
                                    if (lazyListState3.animateScrollToItem(page4, iRoundToInt, c26762) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Iterable $this$firstOrNull$iv2 = pagerState4.lazyListState.getLayoutInfo().getVisibleItemsInfo();
                                    for (Object element$iv2 : $this$firstOrNull$iv2) {
                                        it3 = (LazyListItemInfo) element$iv2;
                                        if (it3.getIndex() == page4) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            obj = element$iv2;
                                            target2 = (LazyListItemInfo) obj;
                                            if (target2 != null && target2.getSize() + pagerState4.getItemSpacing$pager_release() != currentSize) {
                                                lazyListState5 = pagerState4.lazyListState;
                                                iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                                c26762.L$0 = pagerState4;
                                                c26762.label = 6;
                                                if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            }
                                        }
                                    }
                                    target2 = (LazyListItemInfo) obj;
                                    if (target2 != null) {
                                        lazyListState5 = pagerState4.lazyListState;
                                        iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                        c26762.L$0 = pagerState4;
                                        c26762.label = 6;
                                        if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                                pagerState4.onScrollFinished$pager_release();
                                return Unit.INSTANCE;
                            } while (!z);
                            target = (LazyListItemInfo) element$iv;
                            if (target != null) {
                                lazyListState4 = pagerState4.lazyListState;
                                iRoundToInt2 = MathKt.roundToInt((target.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.label = 4;
                                if (lazyListState4.animateScrollToItem(page4, iRoundToInt2, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                                currentSize = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getSize() + pagerState4.getItemSpacing$pager_release();
                                lazyListState3 = pagerState4.lazyListState;
                                iRoundToInt = MathKt.roundToInt(currentSize * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.I$0 = page4;
                                c26762.F$0 = pageOffset5;
                                c26762.I$1 = currentSize;
                                c26762.label = 5;
                                if (lazyListState3.animateScrollToItem(page4, iRoundToInt, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Iterable $this$firstOrNull$iv3 = pagerState4.lazyListState.getLayoutInfo().getVisibleItemsInfo();
                                while (r10.hasNext()) {
                                    it3 = (LazyListItemInfo) element$iv2;
                                    if (it3.getIndex() == page4) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        obj = element$iv2;
                                        target2 = (LazyListItemInfo) obj;
                                        if (target2 != null) {
                                            lazyListState5 = pagerState4.lazyListState;
                                            iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                            c26762.L$0 = pagerState4;
                                            c26762.label = 6;
                                            if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                }
                                target2 = (LazyListItemInfo) obj;
                                if (target2 != null) {
                                    lazyListState5 = pagerState4.lazyListState;
                                    iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                    c26762.L$0 = pagerState4;
                                    c26762.label = 6;
                                    if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            pagerState4.onScrollFinished$pager_release();
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            pagerState5 = pagerState2;
                            pagerState5.onScrollFinished$pager_release();
                            throw th;
                        }
                    case 1:
                        pageOffset3 = c26762.F$0;
                        page3 = c26762.I$0;
                        pagerState3 = (PagerState) c26762.L$0;
                        ResultKt.throwOnFailure($result);
                        pageOffset2 = pageOffset3;
                        page2 = page3;
                        pagerState2 = pagerState3;
                        if (Math.abs(pageOffset2) <= 0.005f) {
                            lazyListState2 = pagerState2.lazyListState;
                            c26762.L$0 = pagerState2;
                            c26762.label = 2;
                            if (LazyListState.animateScrollToItem$default(lazyListState2, page2, 0, c26762, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pagerState4 = pagerState2;
                            pagerState4.onScrollFinished$pager_release();
                            return Unit.INSTANCE;
                        }
                        lazyListState = pagerState2.lazyListState;
                        c26773 = new C26773(null);
                        c26762.L$0 = pagerState2;
                        c26762.I$0 = page2;
                        c26762.F$0 = pageOffset2;
                        c26762.label = 3;
                        pageOffset4 = pageOffset2;
                        if (ScrollableState.CC.scroll$default(lazyListState, null, c26773, c26762, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pagerState4 = pagerState2;
                        page4 = page2;
                        pageOffset5 = pageOffset4;
                        layoutInfo = pagerState4.lazyListState.getLayoutInfo();
                        Iterable $this$firstOrNull$iv4 = layoutInfo.getVisibleItemsInfo();
                        it = $this$firstOrNull$iv4.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (LazyListItemInfo) element$iv;
                                if (it2.getIndex() == page4) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                element$iv = null;
                            }
                            target = (LazyListItemInfo) element$iv;
                            if (target != null) {
                                lazyListState4 = pagerState4.lazyListState;
                                iRoundToInt2 = MathKt.roundToInt((target.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.label = 4;
                                if (lazyListState4.animateScrollToItem(page4, iRoundToInt2, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                                currentSize = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getSize() + pagerState4.getItemSpacing$pager_release();
                                lazyListState3 = pagerState4.lazyListState;
                                iRoundToInt = MathKt.roundToInt(currentSize * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.I$0 = page4;
                                c26762.F$0 = pageOffset5;
                                c26762.I$1 = currentSize;
                                c26762.label = 5;
                                if (lazyListState3.animateScrollToItem(page4, iRoundToInt, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Iterable $this$firstOrNull$iv5 = pagerState4.lazyListState.getLayoutInfo().getVisibleItemsInfo();
                                while (r10.hasNext()) {
                                    it3 = (LazyListItemInfo) element$iv2;
                                    if (it3.getIndex() == page4) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        obj = element$iv2;
                                        target2 = (LazyListItemInfo) obj;
                                        if (target2 != null) {
                                            lazyListState5 = pagerState4.lazyListState;
                                            iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                            c26762.L$0 = pagerState4;
                                            c26762.label = 6;
                                            if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                }
                                target2 = (LazyListItemInfo) obj;
                                if (target2 != null) {
                                    lazyListState5 = pagerState4.lazyListState;
                                    iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                    c26762.L$0 = pagerState4;
                                    c26762.label = 6;
                                    if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            pagerState4.onScrollFinished$pager_release();
                            return Unit.INSTANCE;
                        } while (!z);
                        target = (LazyListItemInfo) element$iv;
                        if (target != null) {
                            lazyListState4 = pagerState4.lazyListState;
                            iRoundToInt2 = MathKt.roundToInt((target.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                            c26762.L$0 = pagerState4;
                            c26762.label = 4;
                            if (lazyListState4.animateScrollToItem(page4, iRoundToInt2, c26762) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                            currentSize = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getSize() + pagerState4.getItemSpacing$pager_release();
                            lazyListState3 = pagerState4.lazyListState;
                            iRoundToInt = MathKt.roundToInt(currentSize * pageOffset5);
                            c26762.L$0 = pagerState4;
                            c26762.I$0 = page4;
                            c26762.F$0 = pageOffset5;
                            c26762.I$1 = currentSize;
                            c26762.label = 5;
                            if (lazyListState3.animateScrollToItem(page4, iRoundToInt, c26762) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Iterable $this$firstOrNull$iv6 = pagerState4.lazyListState.getLayoutInfo().getVisibleItemsInfo();
                            while (r10.hasNext()) {
                                it3 = (LazyListItemInfo) element$iv2;
                                if (it3.getIndex() == page4) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    obj = element$iv2;
                                    target2 = (LazyListItemInfo) obj;
                                    if (target2 != null) {
                                        lazyListState5 = pagerState4.lazyListState;
                                        iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                        c26762.L$0 = pagerState4;
                                        c26762.label = 6;
                                        if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                            }
                            target2 = (LazyListItemInfo) obj;
                            if (target2 != null) {
                                lazyListState5 = pagerState4.lazyListState;
                                iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.label = 6;
                                if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        pagerState4.onScrollFinished$pager_release();
                        return Unit.INSTANCE;
                    case 2:
                        pagerState4 = (PagerState) c26762.L$0;
                        ResultKt.throwOnFailure($result);
                        pagerState4.onScrollFinished$pager_release();
                        return Unit.INSTANCE;
                    case 3:
                        float pageOffset6 = c26762.F$0;
                        int page5 = c26762.I$0;
                        PagerState pagerState6 = (PagerState) c26762.L$0;
                        ResultKt.throwOnFailure($result);
                        pageOffset5 = pageOffset6;
                        pagerState4 = pagerState6;
                        page4 = page5;
                        layoutInfo = pagerState4.lazyListState.getLayoutInfo();
                        Iterable $this$firstOrNull$iv7 = layoutInfo.getVisibleItemsInfo();
                        it = $this$firstOrNull$iv7.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (LazyListItemInfo) element$iv;
                                if (it2.getIndex() == page4) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                element$iv = null;
                            }
                            target = (LazyListItemInfo) element$iv;
                            if (target != null) {
                                lazyListState4 = pagerState4.lazyListState;
                                iRoundToInt2 = MathKt.roundToInt((target.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.label = 4;
                                if (lazyListState4.animateScrollToItem(page4, iRoundToInt2, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                                currentSize = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getSize() + pagerState4.getItemSpacing$pager_release();
                                lazyListState3 = pagerState4.lazyListState;
                                iRoundToInt = MathKt.roundToInt(currentSize * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.I$0 = page4;
                                c26762.F$0 = pageOffset5;
                                c26762.I$1 = currentSize;
                                c26762.label = 5;
                                if (lazyListState3.animateScrollToItem(page4, iRoundToInt, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Iterable $this$firstOrNull$iv8 = pagerState4.lazyListState.getLayoutInfo().getVisibleItemsInfo();
                                while (r10.hasNext()) {
                                    it3 = (LazyListItemInfo) element$iv2;
                                    if (it3.getIndex() == page4) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        obj = element$iv2;
                                        target2 = (LazyListItemInfo) obj;
                                        if (target2 != null) {
                                            lazyListState5 = pagerState4.lazyListState;
                                            iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                            c26762.L$0 = pagerState4;
                                            c26762.label = 6;
                                            if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                }
                                target2 = (LazyListItemInfo) obj;
                                if (target2 != null) {
                                    lazyListState5 = pagerState4.lazyListState;
                                    iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                    c26762.L$0 = pagerState4;
                                    c26762.label = 6;
                                    if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            pagerState4.onScrollFinished$pager_release();
                            return Unit.INSTANCE;
                        } while (!z);
                        target = (LazyListItemInfo) element$iv;
                        if (target != null) {
                            lazyListState4 = pagerState4.lazyListState;
                            iRoundToInt2 = MathKt.roundToInt((target.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                            c26762.L$0 = pagerState4;
                            c26762.label = 4;
                            if (lazyListState4.animateScrollToItem(page4, iRoundToInt2, c26762) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                            currentSize = ((LazyListItemInfo) CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getSize() + pagerState4.getItemSpacing$pager_release();
                            lazyListState3 = pagerState4.lazyListState;
                            iRoundToInt = MathKt.roundToInt(currentSize * pageOffset5);
                            c26762.L$0 = pagerState4;
                            c26762.I$0 = page4;
                            c26762.F$0 = pageOffset5;
                            c26762.I$1 = currentSize;
                            c26762.label = 5;
                            if (lazyListState3.animateScrollToItem(page4, iRoundToInt, c26762) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Iterable $this$firstOrNull$iv9 = pagerState4.lazyListState.getLayoutInfo().getVisibleItemsInfo();
                            while (r10.hasNext()) {
                                it3 = (LazyListItemInfo) element$iv2;
                                if (it3.getIndex() == page4) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    obj = element$iv2;
                                    target2 = (LazyListItemInfo) obj;
                                    if (target2 != null) {
                                        lazyListState5 = pagerState4.lazyListState;
                                        iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                        c26762.L$0 = pagerState4;
                                        c26762.label = 6;
                                        if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                            }
                            target2 = (LazyListItemInfo) obj;
                            if (target2 != null) {
                                lazyListState5 = pagerState4.lazyListState;
                                iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.label = 6;
                                if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        pagerState4.onScrollFinished$pager_release();
                        return Unit.INSTANCE;
                    case 4:
                        pagerState4 = (PagerState) c26762.L$0;
                        ResultKt.throwOnFailure($result);
                        pagerState4.onScrollFinished$pager_release();
                        return Unit.INSTANCE;
                    case 5:
                        int currentSize2 = c26762.I$1;
                        pageOffset5 = c26762.F$0;
                        page4 = c26762.I$0;
                        PagerState pagerState7 = (PagerState) c26762.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            currentSize = currentSize2;
                            pagerState4 = pagerState7;
                            Iterable $this$firstOrNull$iv10 = pagerState4.lazyListState.getLayoutInfo().getVisibleItemsInfo();
                            while (r10.hasNext()) {
                                it3 = (LazyListItemInfo) element$iv2;
                                if (it3.getIndex() == page4) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    obj = element$iv2;
                                    target2 = (LazyListItemInfo) obj;
                                    if (target2 != null) {
                                        lazyListState5 = pagerState4.lazyListState;
                                        iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                        c26762.L$0 = pagerState4;
                                        c26762.label = 6;
                                        if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    pagerState4.onScrollFinished$pager_release();
                                    return Unit.INSTANCE;
                                }
                            }
                            target2 = (LazyListItemInfo) obj;
                            if (target2 != null) {
                                lazyListState5 = pagerState4.lazyListState;
                                iRoundToInt3 = MathKt.roundToInt((target2.getSize() + pagerState4.getItemSpacing$pager_release()) * pageOffset5);
                                c26762.L$0 = pagerState4;
                                c26762.label = 6;
                                if (lazyListState5.animateScrollToItem(page4, iRoundToInt3, c26762) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            pagerState4.onScrollFinished$pager_release();
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            pagerState5 = pagerState7;
                            pagerState5.onScrollFinished$pager_release();
                            throw th;
                        }
                    case 6:
                        pagerState4 = (PagerState) c26762.L$0;
                        ResultKt.throwOnFailure($result);
                        pagerState4.onScrollFinished$pager_release();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            pagerState5 = pagerState;
        }
    }

    /* JADX INFO: renamed from: com.google.accompanist.pager.PagerState$animateScrollToPage$3 */
    /* JADX INFO: compiled from: PagerState.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m196k = 3, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m209c = "com.google.accompanist.pager.PagerState$animateScrollToPage$3", m210f = "PagerState.kt", m211i = {}, m212l = {}, m213m = "invokeSuspend", m214n = {}, m215s = {})
    static final class C26773 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        int label;

        C26773(Continuation<? super C26773> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C26773(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C26773) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.scrollToPage(i, f, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    public final Object scrollToPage(int i, float f, Continuation<? super Unit> continuation) throws Throwable {
        C26781 c26781;
        float f2;
        PagerState pagerState;
        LazyListItemInfo currentPageLayoutInfo;
        PagerState$scrollToPage$2$1 pagerState$scrollToPage$2$1;
        if (continuation instanceof C26781) {
            c26781 = (C26781) continuation;
            if ((c26781.label & Integer.MIN_VALUE) != 0) {
                c26781.label -= Integer.MIN_VALUE;
            } else {
                c26781 = new C26781(continuation);
            }
        } else {
            c26781 = new C26781(continuation);
        }
        C26781 c26782 = c26781;
        Object obj = c26782.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c26782.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    requireCurrentPage(i, "page");
                    requireCurrentPageOffset(f, "pageOffset");
                    try {
                        setAnimationTargetPage(Boxing.boxInt(i));
                        LazyListState lazyListState = this.lazyListState;
                        c26782.L$0 = this;
                        c26782.F$0 = f;
                        c26782.label = 1;
                        if (LazyListState.scrollToItem$default(lazyListState, i, 0, c26782, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        f2 = f;
                        pagerState = this;
                        pagerState.updateCurrentPageBasedOnLazyListState$pager_release();
                        if (Math.abs(f2) > 1.0E-4f && (currentPageLayoutInfo = pagerState.getCurrentPageLayoutInfo()) != null) {
                            pagerState$scrollToPage$2$1 = new PagerState$scrollToPage$2$1(currentPageLayoutInfo, pagerState, f2, null);
                            c26782.L$0 = pagerState;
                            c26782.label = 2;
                            if (ScrollableState.CC.scroll$default(pagerState, null, pagerState$scrollToPage$2$1, c26782, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        pagerState.onScrollFinished$pager_release();
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        f = this;
                        f.onScrollFinished$pager_release();
                        throw th;
                    }
                case 1:
                    float f3 = c26782.F$0;
                    pagerState = (PagerState) c26782.L$0;
                    ResultKt.throwOnFailure(obj);
                    f2 = f3;
                    pagerState.updateCurrentPageBasedOnLazyListState$pager_release();
                    if (Math.abs(f2) > 1.0E-4f) {
                        pagerState$scrollToPage$2$1 = new PagerState$scrollToPage$2$1(currentPageLayoutInfo, pagerState, f2, null);
                        c26782.L$0 = pagerState;
                        c26782.label = 2;
                        if (ScrollableState.CC.scroll$default(pagerState, null, pagerState$scrollToPage$2$1, c26782, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    pagerState.onScrollFinished$pager_release();
                    return Unit.INSTANCE;
                case 2:
                    pagerState = (PagerState) c26782.L$0;
                    ResultKt.throwOnFailure(obj);
                    pagerState.onScrollFinished$pager_release();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void updateCurrentPageBasedOnLazyListState$pager_release() {
        LazyListItemInfo it = getMostVisiblePageLayoutInfo$pager_release();
        if (it != null) {
            setCurrentPage$pager_release(it.getIndex());
        }
    }

    public final void onScrollFinished$pager_release() {
        setAnimationTargetPage(null);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority scrollPriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.lazyListState.scroll(scrollPriority, function2, continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.lazyListState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.lazyListState.isScrollInProgress();
    }

    public String toString() {
        return "PagerState(pageCount=" + getPageCount() + ", currentPage=" + getCurrentPage() + ", currentPageOffset=" + getCurrentPageOffset() + ')';
    }

    private final void requireCurrentPage(int value, String name) {
        if (!(value >= 0)) {
            throw new IllegalArgumentException((name + AbstractJsonLexerKt.BEGIN_LIST + value + "] must be >= 0").toString());
        }
    }

    private final void requireCurrentPageOffset(float value, String name) {
        boolean z = false;
        if (-1.0f <= value && value <= 1.0f) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException((name + " must be >= -1 and <= 1").toString());
        }
    }

    /* JADX INFO: compiled from: PagerState.kt */
    @Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m195d2 = {"Lcom/google/accompanist/pager/PagerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Lcom/google/accompanist/pager/PagerState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "pager_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<PagerState, ?> getSaver() {
            return PagerState.Saver;
        }
    }
}
