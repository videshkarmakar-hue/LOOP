package androidx.compose.p001ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.input.pointer.util.PointerIdArray;
import androidx.compose.p001ui.layout.LayoutCoordinates;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.p001ui.node.PointerInputModifierNode;
import androidx.compose.p001ui.node.PointerInputModifierNodeKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HitPathTracker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0017\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0#H\u0082\bJ.\u0010$\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u001a\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\rH\u0002J\u0006\u0010(\u001a\u00020\u001dJ\b\u0010)\u001a\u00020*H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m195d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;

    /* JADX INFO: renamed from: modifierNode, reason: from kotlin metadata and from toString */
    private final Modifier.Node pointerInputFilter;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node modifierNode) {
        this.pointerInputFilter = modifierNode;
    }

    /* JADX INFO: renamed from: getModifierNode, reason: from getter */
    public final Modifier.Node getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.p001ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int kind$iv;
        MutableVector<Node> children;
        int size$iv;
        Node this_$iv;
        int $i$f$dispatchIfNeeded;
        Node this_$iv2 = this;
        int $i$f$dispatchIfNeeded2 = 0;
        if (!this_$iv2.relevantChanges.isEmpty() && this_$iv2.pointerInputFilter.getIsAttached()) {
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long size = layoutCoordinates.mo5646getSizeYbymL2g();
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2 = this.pointerInputFilter;
            int iM5876constructorimpl = NodeKind.m5876constructorimpl(16);
            MutableVector mutableVector = null;
            Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv2;
            while (true) {
                int i = 1;
                if (nodePop == null) {
                    break;
                }
                if (nodePop instanceof PointerInputModifierNode) {
                    PointerInputModifierNode it = (PointerInputModifierNode) nodePop;
                    it.mo427onPointerEventH0pRuoY(event, PointerEventPass.Initial, size);
                    this_$iv = this_$iv2;
                    $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded2;
                } else {
                    Modifier.Node this_$iv$iv = nodePop;
                    if (!((this_$iv$iv.getKindSet() & iM5876constructorimpl) != 0) || !(nodePop instanceof DelegatingNode)) {
                        this_$iv = this_$iv2;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded2;
                    } else {
                        int count$iv = 0;
                        DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                        Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                        while (node$iv$iv != null) {
                            Modifier.Node next$iv = node$iv$iv;
                            if (!((next$iv.getKindSet() & iM5876constructorimpl) != 0)) {
                                this_$iv2 = this_$iv2;
                                $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded2;
                            } else {
                                count$iv++;
                                if (count$iv == i) {
                                    nodePop = next$iv;
                                    this_$iv2 = this_$iv2;
                                    $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded2;
                                } else {
                                    mutableVector = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                    Modifier.Node theNode$iv = nodePop;
                                    if (theNode$iv != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(theNode$iv);
                                        }
                                        nodePop = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(next$iv);
                                    }
                                }
                            }
                            node$iv$iv = node$iv$iv.getChild();
                            this_$iv2 = this_$iv2;
                            $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded2;
                            i = 1;
                        }
                        this_$iv = this_$iv2;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded2;
                        if (count$iv == 1) {
                            this_$iv2 = this_$iv;
                            $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded;
                        }
                    }
                }
                nodePop = DelegatableNodeKt.pop(mutableVector);
                this_$iv2 = this_$iv;
                $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded;
            }
            if (this.pointerInputFilter.getIsAttached() && (size$iv = (children = getChildren()).getSize()) > 0) {
                int i$iv = 0;
                Object[] content$iv = children.getContent();
                do {
                    Node it2 = (Node) content$iv[i$iv];
                    LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    it2.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
                    i$iv++;
                } while (i$iv < size$iv);
            }
            if (!this.pointerInputFilter.getIsAttached()) {
                return true;
            }
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv3 = this.pointerInputFilter;
            int kind$iv2 = NodeKind.m5876constructorimpl(16);
            MutableVector mutableVector2 = null;
            Modifier.Node nodePop2 = $this$dispatchForKind_u2d6rFNWt0$iv3;
            while (nodePop2 != null) {
                if (nodePop2 instanceof PointerInputModifierNode) {
                    PointerInputModifierNode it3 = (PointerInputModifierNode) nodePop2;
                    it3.mo427onPointerEventH0pRuoY(event, PointerEventPass.Main, size);
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    kind$iv = kind$iv2;
                } else {
                    Modifier.Node this_$iv$iv3 = nodePop2;
                    if (!((this_$iv$iv3.getKindSet() & kind$iv2) != 0) || !(nodePop2 instanceof DelegatingNode)) {
                        $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                        kind$iv = kind$iv2;
                    } else {
                        int count$iv2 = 0;
                        DelegatingNode this_$iv$iv4 = (DelegatingNode) nodePop2;
                        Modifier.Node node$iv$iv2 = this_$iv$iv4.getDelegate();
                        while (node$iv$iv2 != null) {
                            Modifier.Node next$iv2 = node$iv$iv2;
                            if (!((next$iv2.getKindSet() & kind$iv2) != 0)) {
                                $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                kind$iv2 = kind$iv2;
                            } else {
                                count$iv2++;
                                if (count$iv2 == 1) {
                                    nodePop2 = next$iv2;
                                    $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                                    kind$iv2 = kind$iv2;
                                } else {
                                    mutableVector2 = mutableVector2 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector2;
                                    Modifier.Node theNode$iv2 = nodePop2;
                                    if (theNode$iv2 != null) {
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(theNode$iv2);
                                        }
                                        nodePop2 = null;
                                    }
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(next$iv2);
                                    }
                                }
                            }
                            node$iv$iv2 = node$iv$iv2.getChild();
                            $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                            kind$iv2 = kind$iv2;
                        }
                        $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv3;
                        kind$iv = kind$iv2;
                        if (count$iv2 == 1) {
                            $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv;
                            kind$iv2 = kind$iv;
                        }
                    }
                }
                nodePop2 = DelegatableNodeKt.pop(mutableVector2);
                $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv;
                kind$iv2 = kind$iv;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.compose.p001ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size$iv;
        Node this_$iv;
        int $i$f$dispatchIfNeeded;
        Node this_$iv2 = this;
        int $i$f$dispatchIfNeeded2 = 0;
        boolean z = false;
        if (!this_$iv2.relevantChanges.isEmpty() && this_$iv2.pointerInputFilter.getIsAttached()) {
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long size = layoutCoordinates.mo5646getSizeYbymL2g();
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.pointerInputFilter;
            int iM5876constructorimpl = NodeKind.m5876constructorimpl(16);
            MutableVector mutableVector = null;
            Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv;
            while (true) {
                int i = 1;
                if (nodePop == null) {
                    break;
                }
                if (nodePop instanceof PointerInputModifierNode) {
                    PointerInputModifierNode it = (PointerInputModifierNode) nodePop;
                    it.mo427onPointerEventH0pRuoY(event, PointerEventPass.Final, size);
                    this_$iv = this_$iv2;
                    $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded2;
                } else {
                    Modifier.Node this_$iv$iv = nodePop;
                    if (!((this_$iv$iv.getKindSet() & iM5876constructorimpl) != 0) || !(nodePop instanceof DelegatingNode)) {
                        this_$iv = this_$iv2;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded2;
                    } else {
                        int count$iv = 0;
                        DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                        Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                        while (node$iv$iv != null) {
                            Modifier.Node next$iv = node$iv$iv;
                            if (!((next$iv.getKindSet() & iM5876constructorimpl) != 0)) {
                                this_$iv2 = this_$iv2;
                                $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded2;
                            } else {
                                count$iv++;
                                if (count$iv == i) {
                                    nodePop = next$iv;
                                    this_$iv2 = this_$iv2;
                                    $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded2;
                                } else {
                                    mutableVector = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                    Modifier.Node theNode$iv = nodePop;
                                    if (theNode$iv != null) {
                                        if (mutableVector != null) {
                                            mutableVector.add(theNode$iv);
                                        }
                                        nodePop = null;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(next$iv);
                                    }
                                }
                            }
                            node$iv$iv = node$iv$iv.getChild();
                            this_$iv2 = this_$iv2;
                            $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded2;
                            i = 1;
                        }
                        this_$iv = this_$iv2;
                        $i$f$dispatchIfNeeded = $i$f$dispatchIfNeeded2;
                        if (count$iv == 1) {
                            this_$iv2 = this_$iv;
                            $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded;
                        }
                    }
                }
                nodePop = DelegatableNodeKt.pop(mutableVector);
                this_$iv2 = this_$iv;
                $i$f$dispatchIfNeeded2 = $i$f$dispatchIfNeeded;
            }
            if (this.pointerInputFilter.getIsAttached() && (size$iv = (children = getChildren()).getSize()) > 0) {
                int i$iv = 0;
                Object[] content$iv = children.getContent();
                do {
                    Node it2 = (Node) content$iv[i$iv];
                    it2.dispatchFinalEventPass(internalPointerEvent);
                    i$iv++;
                } while (i$iv < size$iv);
            }
            z = true;
        }
        boolean result = z;
        cleanUpHits(internalPointerEvent);
        clearCache();
        return result;
    }

    @Override // androidx.compose.p001ui.input.pointer.NodeParent
    public boolean buildCache(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Object it$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int kind$iv;
        boolean childChanged = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        int i = 1;
        if (!this.pointerInputFilter.getIsAttached()) {
            return true;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2 = this.pointerInputFilter;
        int kind$iv2 = NodeKind.m5876constructorimpl(16);
        MutableVector mutableVector = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv2;
        while (nodePop != null) {
            if (nodePop instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) nodePop);
                $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv2;
                kind$iv = kind$iv2;
            } else {
                Modifier.Node this_$iv$iv = nodePop;
                if (((this_$iv$iv.getKindSet() & kind$iv2) != 0) && (nodePop instanceof DelegatingNode)) {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if ((next$iv.getKindSet() & kind$iv2) != 0) {
                            count$iv++;
                            if (count$iv == i) {
                                nodePop = next$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                                kind$iv2 = kind$iv2;
                            } else {
                                mutableVector = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                Modifier.Node theNode$iv = nodePop;
                                if (theNode$iv != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(theNode$iv);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(next$iv);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                            kind$iv2 = kind$iv2;
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                        kind$iv2 = kind$iv2;
                        i = 1;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv2;
                    kind$iv = kind$iv2;
                    if (count$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv;
                        kind$iv2 = kind$iv;
                        i = 1;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv2;
                    kind$iv = kind$iv2;
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector);
            $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv;
            kind$iv2 = kind$iv;
            i = 1;
        }
        int j = 0;
        int size = changes.size();
        while (j < size) {
            long keyValue = changes.keyAt(j);
            PointerInputChange change = changes.valueAt(j);
            if (this.pointerIds.contains(keyValue)) {
                long prevPosition = change.getPreviousPosition();
                long currentPosition = change.getPosition();
                if (Offset.m4052isValidimpl(prevPosition) && Offset.m4052isValidimpl(currentPosition)) {
                    ArrayList historical = new ArrayList(change.getHistorical().size());
                    List<HistoricalChange> historical2 = change.getHistorical();
                    int size2 = historical2.size();
                    int index$iv = 0;
                    while (index$iv < size2) {
                        Object item$iv = historical2.get(index$iv);
                        HistoricalChange it = (HistoricalChange) item$iv;
                        long uptimeMillis = it.getUptimeMillis();
                        List<HistoricalChange> list = historical2;
                        LayoutCoordinates layoutCoordinates = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates);
                        historical.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo5647localPositionOfR5De75A(parentCoordinates, it.getPosition()), it.getOriginalEventPosition(), null));
                        index$iv++;
                        size2 = size2;
                        historical2 = list;
                        keyValue = keyValue;
                    }
                    LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    long jMo5647localPositionOfR5De75A = layoutCoordinates2.mo5647localPositionOfR5De75A(parentCoordinates, prevPosition);
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    longSparseArray.put(keyValue, change.m5505copyOHpmEuE((731 & 1) != 0 ? change.id : 0L, (731 & 2) != 0 ? change.uptimeMillis : 0L, (731 & 4) != 0 ? change.position : layoutCoordinates3.mo5647localPositionOfR5De75A(parentCoordinates, currentPosition), (731 & 8) != 0 ? change.pressed : false, (731 & 16) != 0 ? change.previousUptimeMillis : 0L, (731 & 32) != 0 ? change.previousPosition : jMo5647localPositionOfR5De75A, (731 & 64) != 0 ? change.previousPressed : false, (731 & 128) != 0 ? change.type : 0, historical, (731 & 512) != 0 ? change.scrollDelta : 0L));
                }
            }
            j++;
            size = size;
            childChanged = childChanged;
        }
        boolean childChanged2 = childChanged;
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        PointerIdArray this_$iv = this.pointerIds;
        for (int i2 = this_$iv.getSize() - 1; -1 < i2; i2--) {
            long pointerId = this.pointerIds.m5606get_I2yYro(i2);
            if (!changes.containsKey(pointerId)) {
                this.pointerIds.removeAt(i2);
            }
        }
        ArrayList changesList = new ArrayList(this.relevantChanges.size());
        int size3 = this.relevantChanges.size();
        for (int i3 = 0; i3 < size3; i3++) {
            changesList.add(this.relevantChanges.valueAt(i3));
        }
        PointerEvent event = new PointerEvent(changesList, internalPointerEvent);
        List<PointerInputChange> changes2 = event.getChanges();
        int index$iv$iv = 0;
        int size4 = changes2.size();
        while (true) {
            if (index$iv$iv >= size4) {
                it$iv = null;
                break;
            }
            Object item$iv$iv = changes2.get(index$iv$iv);
            it$iv = item$iv$iv;
            if (internalPointerEvent.m5439activeHoverEvent0FcD4WY(((PointerInputChange) it$iv).getId())) {
                break;
            }
            index$iv$iv++;
        }
        PointerInputChange activeHoverChange = (PointerInputChange) it$iv;
        if (activeHoverChange != null) {
            if (!isInBounds) {
                this.isIn = false;
            } else if (!this.isIn && (activeHoverChange.getPressed() || activeHoverChange.getPreviousPressed())) {
                LayoutCoordinates layoutCoordinates4 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates4);
                long size5 = layoutCoordinates4.mo5646getSizeYbymL2g();
                this.isIn = !PointerEventKt.m5454isOutOfBoundsO0kMr_c(activeHoverChange, size5);
            }
            if (this.isIn != this.wasIn && (PointerEventType.m5459equalsimpl0(event.getType(), PointerEventType.INSTANCE.m5465getMove7fucELk()) || PointerEventType.m5459equalsimpl0(event.getType(), PointerEventType.INSTANCE.m5463getEnter7fucELk()) || PointerEventType.m5459equalsimpl0(event.getType(), PointerEventType.INSTANCE.m5464getExit7fucELk()))) {
                event.m5453setTypeEhbLWgg$ui_release(this.isIn ? PointerEventType.INSTANCE.m5463getEnter7fucELk() : PointerEventType.INSTANCE.m5464getExit7fucELk());
            } else if (PointerEventType.m5459equalsimpl0(event.getType(), PointerEventType.INSTANCE.m5463getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                event.m5453setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m5465getMove7fucELk());
            } else if (PointerEventType.m5459equalsimpl0(event.getType(), PointerEventType.INSTANCE.m5464getExit7fucELk()) && this.isIn && activeHoverChange.getPressed()) {
                event.m5453setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m5465getMove7fucELk());
            }
        }
        boolean changed = childChanged2 || !PointerEventType.m5459equalsimpl0(event.getType(), PointerEventType.INSTANCE.m5465getMove7fucELk()) || hasPositionChanged(this.pointerEvent, event);
        this.pointerEvent = event;
        return changed;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            PointerInputChange old = oldEvent.getChanges().get(i);
            PointerInputChange current = newEvent.getChanges().get(i);
            if (!Offset.m4046equalsimpl0(old.getPosition(), current.getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    @Override // androidx.compose.p001ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector mutableVector;
        MutableVector<Node> children = getChildren();
        int size$iv = children.getSize();
        int i = 1;
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = children.getContent();
            do {
                Node it = (Node) content$iv[i$iv];
                it.dispatchCancel();
                i$iv++;
            } while (i$iv < size$iv);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = this.pointerInputFilter;
        int iM5876constructorimpl = NodeKind.m5876constructorimpl(16);
        MutableVector mutableVector2 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv;
        while (nodePop != null) {
            if (nodePop instanceof PointerInputModifierNode) {
                PointerInputModifierNode it2 = (PointerInputModifierNode) nodePop;
                it2.onCancelPointerInput();
            } else {
                Modifier.Node this_$iv$iv = nodePop;
                if (((this_$iv$iv.getKindSet() & iM5876constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if ((next$iv.getKindSet() & iM5876constructorimpl) != 0) {
                            count$iv++;
                            if (count$iv == i) {
                                nodePop = next$iv;
                            } else {
                                if (mutableVector2 != null) {
                                    mutableVector = mutableVector2;
                                } else {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                mutableVector2 = mutableVector;
                                Modifier.Node theNode$iv = nodePop;
                                if (theNode$iv != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(theNode$iv);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(next$iv);
                                }
                            }
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        i = 1;
                    }
                    if (count$iv == 1) {
                        i = 1;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector2);
            i = 1;
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.p001ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent event = this.pointerEvent;
        if (event == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = event.getChanges();
        int $i$f$fastForEach = 0;
        int index$iv = 0;
        int size = changes.size();
        while (true) {
            boolean removePointerId = false;
            if (index$iv >= size) {
                this.isIn = false;
                this.hasExited = PointerEventType.m5459equalsimpl0(event.getType(), PointerEventType.INSTANCE.m5464getExit7fucELk());
                return;
            }
            Object item$iv = changes.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            boolean released = !change.getPressed();
            boolean nonHoverEventStream = !internalPointerEvent.m5439activeHoverEvent0FcD4WY(change.getId());
            boolean outsideArea = !this.isIn;
            if ((released && nonHoverEventStream) || (released && outsideArea)) {
                removePointerId = true;
            }
            if (removePointerId) {
                this.pointerIds.m5607remove0FcD4WY(change.getId());
            }
            index$iv++;
            changes = changes;
            $i$f$fastForEach = $i$f$fastForEach;
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
