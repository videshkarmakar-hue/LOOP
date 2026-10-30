package androidx.compose.p001ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.p001ui.Actual_jvmKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.DrawModifier;
import androidx.compose.p001ui.focus.FocusEventModifier;
import androidx.compose.p001ui.focus.FocusEventModifierNode;
import androidx.compose.p001ui.focus.FocusEventModifierNodeKt;
import androidx.compose.p001ui.focus.FocusOrderModifier;
import androidx.compose.p001ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p001ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.p001ui.focus.FocusTargetNode;
import androidx.compose.p001ui.focus.FocusTargetNodeKt;
import androidx.compose.p001ui.input.key.KeyInputModifierNode;
import androidx.compose.p001ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.p001ui.input.pointer.PointerInputModifier;
import androidx.compose.p001ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.p001ui.internal.InlineClassHelperKt;
import androidx.compose.p001ui.layout.ApproachLayoutModifierNode;
import androidx.compose.p001ui.layout.LayoutModifier;
import androidx.compose.p001ui.layout.OnGloballyPositionedModifier;
import androidx.compose.p001ui.layout.OnPlacedModifier;
import androidx.compose.p001ui.layout.OnRemeasuredModifier;
import androidx.compose.p001ui.layout.ParentDataModifier;
import androidx.compose.p001ui.modifier.ModifierLocalConsumer;
import androidx.compose.p001ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p001ui.modifier.ModifierLocalProvider;
import androidx.compose.p001ui.semantics.SemanticsModifier;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: NodeKind.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u001a \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a#\u0010\u001f\u001a\u00020\f*\u00020\u00012\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0080\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\u00020\u0001*\u00020\u00012\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\rH\u0080\fø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\f\u0010'\u001a\u00020\u0011*\u00020(H\u0002\u001a\f\u0010)\u001a\u00020\f*\u00020(H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m195d2 = {"Inserted", "", "getInserted$annotations", "()V", "Removed", "getRemoved$annotations", "Updated", "getUpdated$annotations", "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "", "includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "autoInvalidateInsertedNode", "", "node", "Landroidx/compose/ui/Modifier$Node;", "autoInvalidateNodeIncludingDelegates", "remainingSet", "phase", "autoInvalidateNodeSelf", "selfKindSet", "autoInvalidateRemovedNode", "autoInvalidateUpdatedNode", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "calculateNodeKindSetFromIncludingDelegates", "contains", DownloadUtil.CookieScheme.VALUE, "contains-64DMado", "(II)Z", "or", "other", "or-64DMado", "(II)I", "scheduleInvalidationOfAssociatedFocusTargets", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "specifiesCanFocusProperty", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;
    private static final MutableObjectIntMap<Object> classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    /* JADX INFO: renamed from: or-64DMado, reason: not valid java name */
    public static final int m5886or64DMado(int $this$or_u2d64DMado, int other) {
        return $this$or_u2d64DMado | other;
    }

    /* JADX INFO: renamed from: contains-64DMado, reason: not valid java name */
    public static final boolean m5884contains64DMado(int $this$contains_u2d64DMado, int value) {
        return ($this$contains_u2d64DMado & value) != 0;
    }

    /* JADX INFO: renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m5885getIncludeSelfInTraversalH91voCI(int $this$includeSelfInTraversal) {
        return (NodeKind.m5876constructorimpl(128) & $this$includeSelfInTraversal) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int mask = NodeKind.m5876constructorimpl(1);
        if (element instanceof LayoutModifier) {
            int other$iv = NodeKind.m5876constructorimpl(2) | mask;
            mask = other$iv;
        }
        if (element instanceof DrawModifier) {
            int $this$or_u2d64DMado$iv = mask;
            int other$iv2 = NodeKind.m5876constructorimpl(4) | $this$or_u2d64DMado$iv;
            mask = other$iv2;
        }
        if (element instanceof SemanticsModifier) {
            int $this$or_u2d64DMado$iv2 = mask;
            int other$iv3 = NodeKind.m5876constructorimpl(8) | $this$or_u2d64DMado$iv2;
            mask = other$iv3;
        }
        if (element instanceof PointerInputModifier) {
            int $this$or_u2d64DMado$iv3 = mask;
            int other$iv4 = NodeKind.m5876constructorimpl(16) | $this$or_u2d64DMado$iv3;
            mask = other$iv4;
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            int $this$or_u2d64DMado$iv4 = mask;
            int other$iv5 = NodeKind.m5876constructorimpl(32) | $this$or_u2d64DMado$iv4;
            mask = other$iv5;
        }
        if (element instanceof FocusEventModifier) {
            int $this$or_u2d64DMado$iv5 = mask;
            int other$iv6 = NodeKind.m5876constructorimpl(4096) | $this$or_u2d64DMado$iv5;
            mask = other$iv6;
        }
        if (element instanceof FocusOrderModifier) {
            int $this$or_u2d64DMado$iv6 = mask;
            int other$iv7 = NodeKind.m5876constructorimpl(2048) | $this$or_u2d64DMado$iv6;
            mask = other$iv7;
        }
        if (element instanceof OnGloballyPositionedModifier) {
            int $this$or_u2d64DMado$iv7 = mask;
            int other$iv8 = NodeKind.m5876constructorimpl(256) | $this$or_u2d64DMado$iv7;
            mask = other$iv8;
        }
        if (element instanceof ParentDataModifier) {
            int $this$or_u2d64DMado$iv8 = mask;
            int other$iv9 = NodeKind.m5876constructorimpl(64) | $this$or_u2d64DMado$iv8;
            mask = other$iv9;
        }
        if ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) {
            int $this$or_u2d64DMado$iv9 = mask;
            int other$iv10 = NodeKind.m5876constructorimpl(128) | $this$or_u2d64DMado$iv9;
            return other$iv10;
        }
        return mask;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        if (node.getKindSet() != 0) {
            return node.getKindSet();
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = classToKindSetMap;
        Object key$iv = Actual_jvmKt.classKeyForObject(node);
        int index$iv = mutableObjectIntMap.findKeyIndex(key$iv);
        if (index$iv >= 0) {
            int value$iv = mutableObjectIntMap.values[index$iv];
            return value$iv;
        }
        int mask = NodeKind.m5876constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            int other$iv = NodeKind.m5876constructorimpl(2) | mask;
            mask = other$iv;
        }
        if (node instanceof DrawModifierNode) {
            int $this$or_u2d64DMado$iv = mask;
            int other$iv2 = NodeKind.m5876constructorimpl(4) | $this$or_u2d64DMado$iv;
            mask = other$iv2;
        }
        if (node instanceof SemanticsModifierNode) {
            int $this$or_u2d64DMado$iv2 = mask;
            int other$iv3 = NodeKind.m5876constructorimpl(8) | $this$or_u2d64DMado$iv2;
            mask = other$iv3;
        }
        if (node instanceof PointerInputModifierNode) {
            int $this$or_u2d64DMado$iv3 = mask;
            int other$iv4 = NodeKind.m5876constructorimpl(16) | $this$or_u2d64DMado$iv3;
            mask = other$iv4;
        }
        if (node instanceof ModifierLocalModifierNode) {
            int $this$or_u2d64DMado$iv4 = mask;
            int other$iv5 = NodeKind.m5876constructorimpl(32) | $this$or_u2d64DMado$iv4;
            mask = other$iv5;
        }
        if (node instanceof ParentDataModifierNode) {
            int $this$or_u2d64DMado$iv5 = mask;
            int other$iv6 = NodeKind.m5876constructorimpl(64) | $this$or_u2d64DMado$iv5;
            mask = other$iv6;
        }
        if (node instanceof LayoutAwareModifierNode) {
            int $this$or_u2d64DMado$iv6 = mask;
            int other$iv7 = NodeKind.m5876constructorimpl(128) | $this$or_u2d64DMado$iv6;
            mask = other$iv7;
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            int $this$or_u2d64DMado$iv7 = mask;
            int other$iv8 = NodeKind.m5876constructorimpl(256) | $this$or_u2d64DMado$iv7;
            mask = other$iv8;
        }
        if (node instanceof ApproachLayoutModifierNode) {
            int $this$or_u2d64DMado$iv8 = mask;
            int other$iv9 = NodeKind.m5876constructorimpl(512) | $this$or_u2d64DMado$iv8;
            mask = other$iv9;
        }
        if (node instanceof FocusTargetNode) {
            int $this$or_u2d64DMado$iv9 = mask;
            int other$iv10 = NodeKind.m5876constructorimpl(1024) | $this$or_u2d64DMado$iv9;
            mask = other$iv10;
        }
        if (node instanceof FocusPropertiesModifierNode) {
            int $this$or_u2d64DMado$iv10 = mask;
            int other$iv11 = NodeKind.m5876constructorimpl(2048) | $this$or_u2d64DMado$iv10;
            mask = other$iv11;
        }
        if (node instanceof FocusEventModifierNode) {
            int $this$or_u2d64DMado$iv11 = mask;
            int other$iv12 = NodeKind.m5876constructorimpl(4096) | $this$or_u2d64DMado$iv11;
            mask = other$iv12;
        }
        if (node instanceof KeyInputModifierNode) {
            int $this$or_u2d64DMado$iv12 = mask;
            int other$iv13 = NodeKind.m5876constructorimpl(8192) | $this$or_u2d64DMado$iv12;
            mask = other$iv13;
        }
        if (node instanceof RotaryInputModifierNode) {
            int $this$or_u2d64DMado$iv13 = mask;
            int other$iv14 = NodeKind.m5876constructorimpl(16384) | $this$or_u2d64DMado$iv13;
            mask = other$iv14;
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            int $this$or_u2d64DMado$iv14 = mask;
            int other$iv15 = NodeKind.m5876constructorimpl(32768) | $this$or_u2d64DMado$iv14;
            mask = other$iv15;
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            int $this$or_u2d64DMado$iv15 = mask;
            int other$iv16 = NodeKind.m5876constructorimpl(131072) | $this$or_u2d64DMado$iv15;
            mask = other$iv16;
        }
        if (node instanceof TraversableNode) {
            int $this$or_u2d64DMado$iv16 = mask;
            int other$iv17 = NodeKind.m5876constructorimpl(262144) | $this$or_u2d64DMado$iv16;
            mask = other$iv17;
        }
        int i = mask;
        mutableObjectIntMap.set(key$iv, i);
        return i;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        boolean value$iv = node.getIsAttached();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        boolean value$iv = node.getIsAttached();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        boolean value$iv = node.getIsAttached();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int remainingSet, int phase) {
        if (node instanceof DelegatingNode) {
            autoInvalidateNodeSelf(node, ((DelegatingNode) node).getSelfKindSet() & remainingSet, phase);
            int newRemaining = (~((DelegatingNode) node).getSelfKindSet()) & remainingSet;
            DelegatingNode this_$iv = (DelegatingNode) node;
            for (Modifier.Node node$iv = this_$iv.getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
                Modifier.Node it = node$iv;
                autoInvalidateNodeIncludingDelegates(it, newRemaining, phase);
            }
            return;
        }
        autoInvalidateNodeSelf(node, node.getKindSet() & remainingSet, phase);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNodeSelf(Modifier.Node node, int selfKindSet, int phase) {
        if (phase != 0 || node.getShouldAutoInvalidate()) {
            int value$iv = (selfKindSet & NodeKind.m5876constructorimpl(2)) != 0 ? 1 : 0;
            if (value$iv != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (phase == 2) {
                    NodeCoordinator coordinator = DelegatableNodeKt.m5765requireCoordinator64DMado(node, NodeKind.m5876constructorimpl(2));
                    coordinator.onRelease();
                }
            }
            int value$iv2 = (selfKindSet & NodeKind.m5876constructorimpl(128)) != 0 ? 1 : 0;
            if (value$iv2 != 0 && (node instanceof LayoutAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            int value$iv3 = (selfKindSet & NodeKind.m5876constructorimpl(256)) != 0 ? 1 : 0;
            if (value$iv3 != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateOnPositioned$ui_release();
            }
            int value$iv4 = (selfKindSet & NodeKind.m5876constructorimpl(4)) != 0 ? 1 : 0;
            if (value$iv4 != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            int value$iv5 = (selfKindSet & NodeKind.m5876constructorimpl(8)) != 0 ? 1 : 0;
            if (value$iv5 != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            int value$iv6 = (selfKindSet & NodeKind.m5876constructorimpl(64)) != 0 ? 1 : 0;
            if (value$iv6 != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            int value$iv7 = (selfKindSet & NodeKind.m5876constructorimpl(1024)) != 0 ? 1 : 0;
            if (value$iv7 != 0 && (node instanceof FocusTargetNode)) {
                if (phase == 2) {
                    node.onReset();
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetNode) node);
                }
            }
            int value$iv8 = (selfKindSet & NodeKind.m5876constructorimpl(2048)) != 0 ? 1 : 0;
            if (value$iv8 != 0 && (node instanceof FocusPropertiesModifierNode) && specifiesCanFocusProperty((FocusPropertiesModifierNode) node)) {
                if (phase == 2) {
                    scheduleInvalidationOfAssociatedFocusTargets((FocusPropertiesModifierNode) node);
                } else {
                    FocusPropertiesModifierNodeKt.invalidateFocusProperties((FocusPropertiesModifierNode) node);
                }
            }
            if (((selfKindSet & NodeKind.m5876constructorimpl(4096)) != 0) && (node instanceof FocusEventModifierNode)) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
            }
        }
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode $this$scheduleInvalidationOfAssociatedFocusTargets) {
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        int type$iv;
        int i;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        FocusPropertiesModifierNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$scheduleInvalidationOfAssociatedFocusTargets;
        int type$iv2 = NodeKind.m5876constructorimpl(1024);
        int i2 = 0;
        if (!$this$visitChildren_u2d6rFNWt0$iv3.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3.getNode().getChild();
        if (child$iv$iv == null) {
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren_u2d6rFNWt0$iv3.getNode());
        } else {
            branches$iv$iv.add(child$iv$iv);
        }
        while (branches$iv$iv.isNotEmpty()) {
            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
            if ((branch$iv$iv.getAggregateChildKindSet() & type$iv2) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
            } else {
                Modifier.Node node$iv$iv = branch$iv$iv;
                while (node$iv$iv != null) {
                    if ((node$iv$iv.getKindSet() & type$iv2) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector = null;
                        Modifier.Node nodePop = it$iv;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode it = (FocusTargetNode) nodePop;
                                FocusTargetNodeKt.invalidateFocusTarget(it);
                                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                type$iv = type$iv2;
                                i = i2;
                            } else {
                                Modifier.Node this_$iv$iv$iv = nodePop;
                                if (((this_$iv$iv$iv.getKindSet() & type$iv2) != 0) && (nodePop instanceof DelegatingNode)) {
                                    int count$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if ((next$iv$iv.getKindSet() & type$iv2) != 0) {
                                            count$iv$iv++;
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                            if (count$iv$iv == 1) {
                                                nodePop = next$iv$iv;
                                                type$iv2 = type$iv2;
                                                i2 = i2;
                                            } else {
                                                MutableVector mutableVector2 = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                                Modifier.Node theNode$iv$iv = nodePop;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv);
                                                }
                                                mutableVector = mutableVector2;
                                            }
                                        } else {
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                            type$iv2 = type$iv2;
                                            i2 = i2;
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                        type$iv2 = type$iv2;
                                        i2 = i2;
                                    }
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    type$iv = type$iv2;
                                    i = i2;
                                    if (count$iv$iv == 1) {
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                        type$iv2 = type$iv;
                                        i2 = i;
                                    }
                                } else {
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    type$iv = type$iv2;
                                    i = i2;
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                            type$iv2 = type$iv;
                            i2 = i;
                        }
                        break;
                    }
                    node$iv$iv = node$iv$iv.getChild();
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv3;
                }
            }
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode $this$specifiesCanFocusProperty) {
        CanFocusChecker.INSTANCE.reset();
        $this$specifiesCanFocusProperty.applyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (node instanceof DelegatingNode) {
            int mask = ((DelegatingNode) node).getSelfKindSet();
            DelegatingNode this_$iv = (DelegatingNode) node;
            for (Modifier.Node node$iv = this_$iv.getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
                Modifier.Node it = node$iv;
                mask |= calculateNodeKindSetFromIncludingDelegates(it);
            }
            return mask;
        }
        return calculateNodeKindSetFrom(node);
    }
}
