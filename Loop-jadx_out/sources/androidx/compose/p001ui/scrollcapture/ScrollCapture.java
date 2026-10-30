package androidx.compose.p001ui.scrollcapture;

import android.graphics.Point;
import android.view.ScrollCaptureTarget;
import android.view.View;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.RectHelper_androidKt;
import androidx.compose.p001ui.layout.LayoutCoordinatesKt;
import androidx.compose.p001ui.semantics.SemanticsOwner;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntRectKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: ScrollCapture.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¨\u0006\u000e"}, m195d2 = {"Landroidx/compose/ui/scrollcapture/ScrollCapture;", "", "()V", "onScrollCaptureSearch", "", "view", "Landroid/view/View;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScrollCapture {
    public static final int $stable = 0;
    public static final ScrollCapture INSTANCE = new ScrollCapture();

    private ScrollCapture() {
    }

    public final void onScrollCaptureSearch(View view, SemanticsOwner semanticsOwner, CoroutineContext coroutineContext, Consumer<ScrollCaptureTarget> targets) {
        if (ScrollCapture_androidKt.getComposeFeatureFlag_LongScreenshotsEnabled()) {
            MutableVector candidates = new MutableVector(new ScrollCaptureCandidate[16], 0);
            Object obj = null;
            ScrollCapture_androidKt.visitScrollCaptureCandidates$default(semanticsOwner.getUnmergedRootSemanticsNode(), 0, new C19101(candidates), 2, null);
            candidates.sortWith(ComparisonsKt.compareBy(new Function1<ScrollCaptureCandidate, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture.onScrollCaptureSearch.2
                @Override // kotlin.jvm.functions.Function1
                public final Comparable<?> invoke(ScrollCaptureCandidate it) {
                    return Integer.valueOf(it.getDepth());
                }
            }, new Function1<ScrollCaptureCandidate, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture.onScrollCaptureSearch.3
                @Override // kotlin.jvm.functions.Function1
                public final Comparable<?> invoke(ScrollCaptureCandidate it) {
                    return Integer.valueOf(it.getViewportBoundsInWindow().getHeight());
                }
            }));
            if (!candidates.isEmpty()) {
                int index$iv$iv = candidates.getSize() - 1;
                obj = candidates.getContent()[index$iv$iv];
            }
            ScrollCaptureCandidate candidate = (ScrollCaptureCandidate) obj;
            if (candidate == null) {
                return;
            }
            CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineContext);
            ComposeScrollCaptureCallback callback = new ComposeScrollCaptureCallback(candidate.getNode(), candidate.getViewportBoundsInWindow(), coroutineScope);
            Rect localVisibleRectOfCandidate = LayoutCoordinatesKt.boundsInRoot(candidate.getCoordinates());
            long windowOffsetOfCandidate = candidate.getViewportBoundsInWindow().m6961getTopLeftnOccac();
            ScrollCaptureTarget $this$onScrollCaptureSearch_u24lambda_u241 = new ScrollCaptureTarget(view, RectHelper_androidKt.toAndroidRect(IntRectKt.roundToIntRect(localVisibleRectOfCandidate)), new Point(IntOffset.m6933getXimpl(windowOffsetOfCandidate), IntOffset.m6934getYimpl(windowOffsetOfCandidate)), callback);
            $this$onScrollCaptureSearch_u24lambda_u241.setScrollBounds(RectHelper_androidKt.toAndroidRect(candidate.getViewportBoundsInWindow()));
            targets.accept($this$onScrollCaptureSearch_u24lambda_u241);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$1 */
    /* JADX INFO: compiled from: ScrollCapture.android.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C19101 extends AdaptedFunctionReference implements Function1<ScrollCaptureCandidate, Unit> {
        C19101(Object obj) {
            super(1, obj, MutableVector.class, "add", "add(Ljava/lang/Object;)Z", 8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ScrollCaptureCandidate scrollCaptureCandidate) {
            invoke2(scrollCaptureCandidate);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ScrollCaptureCandidate p0) {
            ((MutableVector) this.receiver).add(p0);
        }
    }
}
