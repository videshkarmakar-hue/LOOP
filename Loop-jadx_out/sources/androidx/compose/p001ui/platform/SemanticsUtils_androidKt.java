package androidx.compose.p001ui.platform;

import android.graphics.Region;
import android.view.View;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.layout.LayoutInfo;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.semantics.AccessibilityAction;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsActions;
import androidx.compose.p001ui.semantics.SemanticsConfiguration;
import androidx.compose.p001ui.semantics.SemanticsConfigurationKt;
import androidx.compose.p001ui.semantics.SemanticsNode;
import androidx.compose.p001ui.semantics.SemanticsOwner;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.viewinterop.AndroidViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemanticsUtils.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f*\b\u0012\u0004\u0012\u00020\f0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0012\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u0013H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0000\u001a\f\u0010\u0018\u001a\u00020\u0015*\u00020\u0019H\u0000\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m195d2 = {"DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "getDefaultFakeNodeBounds", "()Landroidx/compose/ui/geometry/Rect;", "getScrollViewportLength", "", "configuration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Ljava/lang/Float;", "getTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "getAllUncoveredSemanticsNodesToIntObjectMap", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "isAncestorOf", "", "Landroidx/compose/ui/node/LayoutNode;", "node", "isImportantForAccessibility", "Landroidx/compose/ui/semantics/SemanticsNode;", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SemanticsUtils_androidKt {
    private static final Rect DefaultFakeNodeBounds = new Rect(0.0f, 0.0f, 10.0f, 10.0f);

    public static final TextLayoutResult getTextLayoutResult(SemanticsConfiguration configuration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(configuration, SemanticsActions.INSTANCE.getGetTextLayoutResult());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null) {
            return null;
        }
        boolean getLayoutResult = ((Boolean) function1.invoke(arrayList)).booleanValue();
        if (!getLayoutResult) {
            return null;
        }
        return (TextLayoutResult) arrayList.get(0);
    }

    public static final Float getScrollViewportLength(SemanticsConfiguration configuration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(configuration, SemanticsActions.INSTANCE.getGetScrollViewportLength());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null) {
            return null;
        }
        boolean actionResult = ((Boolean) function1.invoke(arrayList)).booleanValue();
        if (!actionResult) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    public static final ScrollObservationScope findById(List<ScrollObservationScope> list, int id) {
        int size = list.size();
        for (int index = 0; index < size; index++) {
            if (list.get(index).getSemanticsNodeId() == id) {
                return list.get(index);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: toLegacyClassName-V4PA4sw, reason: not valid java name */
    public static final String m6033toLegacyClassNameV4PA4sw(int $this$toLegacyClassName_u2dV4PA4sw) {
        if (Role.m6058equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m6062getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m6058equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m6063getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m6058equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m6066getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m6058equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m6065getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m6058equalsimpl0($this$toLegacyClassName_u2dV4PA4sw, Role.INSTANCE.m6064getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    public static final boolean isImportantForAccessibility(SemanticsNode $this$isImportantForAccessibility) {
        return $this$isImportantForAccessibility.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || $this$isImportantForAccessibility.getUnmergedConfig().containsImportantForAccessibility$ui_release();
    }

    public static final Rect getDefaultFakeNodeBounds() {
        return DefaultFakeNodeBounds;
    }

    public static final View semanticsIdToView(AndroidViewsHandler $this$semanticsIdToView, int id) {
        Object element$iv;
        Map.Entry it;
        Iterable $this$firstOrNull$iv = $this$semanticsIdToView.getLayoutNodeToHolder().entrySet();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (Map.Entry) element$iv;
        } while (!(((LayoutNode) it.getKey()).getSemanticsId() == id));
        Map.Entry entry = (Map.Entry) element$iv;
        return entry != null ? (AndroidViewHolder) entry.getValue() : null;
    }

    public static final boolean isAncestorOf(LayoutNode $this$isAncestorOf, LayoutNode node) {
        LayoutNode p = node.getParent$ui_release();
        if (p == null) {
            return false;
        }
        return Intrinsics.areEqual(p, $this$isAncestorOf) || isAncestorOf($this$isAncestorOf, p);
    }

    public static final IntObjectMap<SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner $this$getAllUncoveredSemanticsNodesToIntObjectMap) {
        SemanticsNode root = $this$getAllUncoveredSemanticsNodesToIntObjectMap.getUnmergedRootSemanticsNode();
        MutableIntObjectMap nodes = IntObjectMapKt.mutableIntObjectMapOf();
        if (!root.getLayoutNode().isPlaced() || !root.getLayoutNode().isAttached()) {
            return nodes;
        }
        Rect $this$getAllUncoveredSemanticsNodesToIntObjectMap_u24lambda_u241 = root.getBoundsInRoot();
        float $this$fastRoundToInt$iv = $this$getAllUncoveredSemanticsNodesToIntObjectMap_u24lambda_u241.getLeft();
        int iRound = Math.round($this$fastRoundToInt$iv);
        float $this$fastRoundToInt$iv2 = $this$getAllUncoveredSemanticsNodesToIntObjectMap_u24lambda_u241.getTop();
        int iRound2 = Math.round($this$fastRoundToInt$iv2);
        float $this$fastRoundToInt$iv3 = $this$getAllUncoveredSemanticsNodesToIntObjectMap_u24lambda_u241.getRight();
        int iRound3 = Math.round($this$fastRoundToInt$iv3);
        float $this$fastRoundToInt$iv4 = $this$getAllUncoveredSemanticsNodesToIntObjectMap_u24lambda_u241.getBottom();
        Region unaccountedSpace = new Region(iRound, iRound2, iRound3, Math.round($this$fastRoundToInt$iv4));
        m31x1b6f0f0a(unaccountedSpace, root, nodes, root, new Region());
        return nodes;
    }

    /* JADX INFO: renamed from: getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive */
    private static final void m31x1b6f0f0a(Region unaccountedSpace, SemanticsNode root, MutableIntObjectMap<SemanticsNodeWithAdjustedBounds> mutableIntObjectMap, SemanticsNode currentNode, Region region) {
        int id;
        Rect boundsForFakeNode;
        LayoutInfo layoutInfo;
        boolean z = false;
        boolean notAttachedOrPlaced = (currentNode.getLayoutNode().isPlaced() && currentNode.getLayoutNode().isAttached()) ? false : true;
        if (!unaccountedSpace.isEmpty() || currentNode.getId() == root.getId()) {
            if (notAttachedOrPlaced && !currentNode.getIsFake()) {
                return;
            }
            Rect touchBoundsInRoot = currentNode.getTouchBoundsInRoot();
            float $this$fastRoundToInt$iv = touchBoundsInRoot.getLeft();
            int iRound = Math.round($this$fastRoundToInt$iv);
            float $this$fastRoundToInt$iv2 = touchBoundsInRoot.getTop();
            int iRound2 = Math.round($this$fastRoundToInt$iv2);
            float $this$fastRoundToInt$iv3 = touchBoundsInRoot.getRight();
            int iRound3 = Math.round($this$fastRoundToInt$iv3);
            float $this$fastRoundToInt$iv4 = touchBoundsInRoot.getBottom();
            int iRound4 = Math.round($this$fastRoundToInt$iv4);
            region.set(iRound, iRound2, iRound3, iRound4);
            if (currentNode.getId() == root.getId()) {
                id = -1;
            } else {
                id = currentNode.getId();
            }
            int virtualViewId = id;
            if (region.op(unaccountedSpace, Region.Op.INTERSECT)) {
                mutableIntObjectMap.set(virtualViewId, new SemanticsNodeWithAdjustedBounds(currentNode, region.getBounds()));
                List<SemanticsNode> replacedChildren$ui_release = currentNode.getReplacedChildren$ui_release();
                for (int i = replacedChildren$ui_release.size() - 1; -1 < i; i--) {
                    m31x1b6f0f0a(unaccountedSpace, root, mutableIntObjectMap, replacedChildren$ui_release.get(i), region);
                }
                if (isImportantForAccessibility(currentNode)) {
                    unaccountedSpace.op(iRound, iRound2, iRound3, iRound4, Region.Op.DIFFERENCE);
                    return;
                }
                return;
            }
            if (currentNode.getIsFake()) {
                SemanticsNode parentNode = currentNode.getParent();
                if (parentNode != null && (layoutInfo = parentNode.getLayoutInfo()) != null && layoutInfo.isPlaced()) {
                    z = true;
                }
                if (z) {
                    boundsForFakeNode = parentNode.getBoundsInRoot();
                } else {
                    boundsForFakeNode = DefaultFakeNodeBounds;
                }
                float $this$fastRoundToInt$iv5 = boundsForFakeNode.getLeft();
                int iRound5 = Math.round($this$fastRoundToInt$iv5);
                float $this$fastRoundToInt$iv6 = boundsForFakeNode.getTop();
                int iRound6 = Math.round($this$fastRoundToInt$iv6);
                float $this$fastRoundToInt$iv7 = boundsForFakeNode.getRight();
                int iRound7 = Math.round($this$fastRoundToInt$iv7);
                float $this$fastRoundToInt$iv8 = boundsForFakeNode.getBottom();
                mutableIntObjectMap.set(virtualViewId, new SemanticsNodeWithAdjustedBounds(currentNode, new android.graphics.Rect(iRound5, iRound6, iRound7, Math.round($this$fastRoundToInt$iv8))));
                return;
            }
            if (virtualViewId == -1) {
                mutableIntObjectMap.set(virtualViewId, new SemanticsNodeWithAdjustedBounds(currentNode, region.getBounds()));
            }
        }
    }
}
