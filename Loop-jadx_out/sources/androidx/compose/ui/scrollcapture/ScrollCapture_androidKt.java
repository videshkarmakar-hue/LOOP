package androidx.compose.ui.scrollcapture;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ScrollCapture.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d0\"H\u0002\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0%*\u00020\fH\u0002\u001a!\u0010&\u001a\u00020\u001d*\u00020\f2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\"H\u0082\b\"1\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00018G@GX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b\t\u0010\n\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\"\u0018\u0010\u000b\u001a\u00020\u0001*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001e\u0010\u000f\u001a\u00020\u0001*\u00020\f8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\u000e\"E\u0010\u0012\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0013*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"<set-?>", "", "ComposeFeatureFlag_LongScreenshotsEnabled", "getComposeFeatureFlag_LongScreenshotsEnabled$annotations", "()V", "getComposeFeatureFlag_LongScreenshotsEnabled", "()Z", "setComposeFeatureFlag_LongScreenshotsEnabled", "(Z)V", "ComposeFeatureFlag_LongScreenshotsEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollVertically", "Landroidx/compose/ui/semantics/SemanticsNode;", "getCanScrollVertically", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isVisible", "isVisible$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "scrollCaptureScrollByAction", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "offset", "Lkotlin/coroutines/Continuation;", "", "getScrollCaptureScrollByAction", "(Landroidx/compose/ui/semantics/SemanticsNode;)Lkotlin/jvm/functions/Function2;", "visitScrollCaptureCandidates", "", "fromNode", "depth", "", "onCandidate", "Lkotlin/Function1;", "Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", "getChildrenForSearch", "", "visitDescendants", "onNode", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScrollCapture_androidKt {
    private static final MutableState ComposeFeatureFlag_LongScreenshotsEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    @Deprecated(message = "Temporary feature flag. See b/329128246")
    public static /* synthetic */ void getComposeFeatureFlag_LongScreenshotsEnabled$annotations() {
    }

    private static /* synthetic */ void isVisible$annotations(SemanticsNode semanticsNode) {
    }

    @Deprecated(message = "Temporary feature flag. See b/329128246")
    public static final boolean getComposeFeatureFlag_LongScreenshotsEnabled() {
        State $this$getValue$iv = ComposeFeatureFlag_LongScreenshotsEnabled$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    @Deprecated(message = "Temporary feature flag. See b/329128246")
    public static final void setComposeFeatureFlag_LongScreenshotsEnabled(boolean z) {
        MutableState $this$setValue$iv = ComposeFeatureFlag_LongScreenshotsEnabled$delegate;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    static /* synthetic */ void visitScrollCaptureCandidates$default(SemanticsNode semanticsNode, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        visitScrollCaptureCandidates(semanticsNode, i, function1);
    }

    private static final void visitScrollCaptureCandidates(SemanticsNode fromNode, int depth, Function1<? super ScrollCaptureCandidate, Unit> function1) {
        MutableVector nodes$iv = new MutableVector(new SemanticsNode[16], 0);
        nodes$iv.addAll(nodes$iv.getSize(), (List) getChildrenForSearch(fromNode));
        while (nodes$iv.isNotEmpty()) {
            boolean z = true;
            SemanticsNode node$iv = (SemanticsNode) nodes$iv.removeAt(nodes$iv.getSize() - 1);
            if (!isVisible(node$iv) || node$iv.getConfig().contains(SemanticsProperties.INSTANCE.getDisabled())) {
                z = false;
            } else {
                NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = node$iv.findCoordinatorToGetBounds$ui_release();
                if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
                    LayoutCoordinates nodeCoordinates = nodeCoordinatorFindCoordinatorToGetBounds$ui_release.getCoordinates();
                    IntRect viewportBoundsInWindow = IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInWindow(nodeCoordinates));
                    if (viewportBoundsInWindow.isEmpty()) {
                        z = false;
                    } else if (getCanScrollVertically(node$iv)) {
                        int candidateDepth = depth + 1;
                        function1.invoke(new ScrollCaptureCandidate(node$iv, candidateDepth, viewportBoundsInWindow, nodeCoordinates));
                        visitScrollCaptureCandidates(node$iv, candidateDepth, function1);
                        z = false;
                    }
                } else {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Expected semantics node to have a coordinator.");
                    throw new KotlinNothingValueException();
                }
            }
            boolean visitChildren$iv = z;
            if (visitChildren$iv) {
                nodes$iv.addAll(nodes$iv.getSize(), (List) getChildrenForSearch(node$iv));
            }
        }
    }

    public static final Function2<Offset, Continuation<? super Offset>, Object> getScrollCaptureScrollByAction(SemanticsNode $this$scrollCaptureScrollByAction) {
        return (Function2) SemanticsConfigurationKt.getOrNull($this$scrollCaptureScrollByAction.getConfig(), SemanticsActions.INSTANCE.getScrollByOffset());
    }

    private static final boolean isVisible(SemanticsNode $this$isVisible) {
        return ($this$isVisible.isTransparent$ui_release() || $this$isVisible.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) ? false : true;
    }

    private static final boolean getCanScrollVertically(SemanticsNode $this$canScrollVertically) {
        Function2<Offset, Continuation<? super Offset>, Object> scrollCaptureScrollByAction = getScrollCaptureScrollByAction($this$canScrollVertically);
        ScrollAxisRange verticalScrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull($this$canScrollVertically.getConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        return (scrollCaptureScrollByAction == null || verticalScrollAxisRange == null || verticalScrollAxisRange.getMaxValue().invoke().floatValue() <= 0.0f) ? false : true;
    }

    private static final void visitDescendants(SemanticsNode $this$visitDescendants, Function1<? super SemanticsNode, Boolean> function1) {
        MutableVector nodes = new MutableVector(new SemanticsNode[16], 0);
        nodes.addAll(nodes.getSize(), (List) getChildrenForSearch($this$visitDescendants));
        while (nodes.isNotEmpty()) {
            SemanticsNode node = (SemanticsNode) nodes.removeAt(nodes.getSize() - 1);
            boolean visitChildren = function1.invoke(node).booleanValue();
            if (visitChildren) {
                nodes.addAll(nodes.getSize(), (List) getChildrenForSearch(node));
            }
        }
    }

    private static final List<SemanticsNode> getChildrenForSearch(SemanticsNode $this$getChildrenForSearch) {
        return $this$getChildrenForSearch.getChildren$ui_release(false, false, false);
    }
}
