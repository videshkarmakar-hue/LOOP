package androidx.compose.p001ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.internal.InlineClassHelperKt;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: FocusInvalidationManager.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ%\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\t2\u0006\u0010\u0014\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m195d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "invalidateOwnerFocusState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusTargetsWithInvalidatedFocusEvents", "hasPendingInvalidation", "", "invalidateNodes", "scheduleInvalidation", "node", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final Function0<Unit> invalidateOwnerFocusState;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusPropertiesModifierNode> focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusTargetNode> focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    public final boolean hasPendingInvalidation() {
        return this.focusTargetNodes.isNotEmpty() || this.focusPropertiesNodes.isNotEmpty() || this.focusEventNodes.isNotEmpty();
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t) {
        if (mutableScatterSet.add(t) && this.focusTargetNodes.get_size() + this.focusEventNodes.get_size() + this.focusPropertiesNodes.get_size() == 1) {
            this.onRequestApplyChangesListener.invoke(new C17431(this));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusInvalidationManager$scheduleInvalidation$1 */
    /* JADX INFO: compiled from: FocusInvalidationManager.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* synthetic */ class C17431 extends FunctionReferenceImpl implements Function0<Unit> {
        C17431(Object obj) {
            super(0, obj, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((FocusInvalidationManager) this.receiver).invalidateNodes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateNodes() {
        Object[] k$iv;
        ScatterSet this_$iv$iv;
        int $i$f$forEachIndex;
        long[] m$iv$iv;
        Object[] k$iv2;
        ScatterSet this_$iv$iv2;
        int $i$f$forEachIndex2;
        long[] m$iv$iv2;
        FocusStateImpl focusState;
        FocusStateImpl focusState2;
        MutableVector mutableVector;
        MutableVector branches$iv$iv;
        Modifier.Node child$iv$iv;
        Modifier.Node branch$iv$iv;
        DelegatingNode this_$iv$iv$iv;
        long[] m$iv$iv3;
        int index$iv$iv;
        DelegatingNode this_$iv$iv$iv2;
        ScatterSet this_$iv;
        int $i$f$forEach;
        Object[] k$iv3;
        ScatterSet this_$iv$iv3;
        int $i$f$forEachIndex3;
        ScatterSet this_$iv2;
        int $i$f$forEach2;
        Object[] k$iv4;
        MutableVector branches$iv$iv2;
        Modifier.Node child$iv$iv2;
        DelegatingNode this_$iv$iv$iv3;
        ScatterSet this_$iv3;
        int $i$f$forEach3;
        Object[] k$iv5;
        int $i$f$forEach4;
        MutableVector mutableVector2;
        ScatterSet this_$iv4 = this.focusPropertiesNodes;
        int $i$f$forEach5 = 0;
        Object[] k$iv6 = this_$iv4.elements;
        ScatterSet this_$iv$iv4 = this_$iv4;
        int $i$f$forEachIndex4 = 0;
        long[] m$iv$iv4 = this_$iv$iv4.metadata;
        int lastIndex$iv$iv = m$iv$iv4.length - 2;
        int i$iv$iv = 0;
        char c = 7;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv4[i$iv$iv];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << c) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                        if ($i$f$isFull != 0) {
                            DelegatableNode it = (FocusPropertiesModifierNode) k$iv6[(i$iv$iv << 3) + j$iv$iv];
                            if (it.getNode().getIsAttached()) {
                                DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv = it;
                                int iM5876constructorimpl = NodeKind.m5876constructorimpl(1024);
                                Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv.getNode();
                                MutableVector mutableVector3 = null;
                                Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                while (nodePop != null) {
                                    if (nodePop instanceof FocusTargetNode) {
                                        FocusTargetNode focusTarget = (FocusTargetNode) nodePop;
                                        this_$iv3 = this_$iv4;
                                        this.focusTargetNodes.add(focusTarget);
                                        $i$f$forEach3 = $i$f$forEach5;
                                        k$iv5 = k$iv6;
                                    } else {
                                        this_$iv3 = this_$iv4;
                                        Modifier.Node this_$iv$iv$iv4 = nodePop;
                                        if (((this_$iv$iv$iv4.getKindSet() & iM5876constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                            int count$iv$iv = 0;
                                            DelegatingNode this_$iv$iv$iv5 = (DelegatingNode) nodePop;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv5.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet() & iM5876constructorimpl) != 0) {
                                                    count$iv$iv++;
                                                    $i$f$forEach4 = $i$f$forEach5;
                                                    if (count$iv$iv == 1) {
                                                        nodePop = next$iv$iv;
                                                        k$iv6 = k$iv6;
                                                    } else {
                                                        if (mutableVector3 == null) {
                                                            Object[] k$iv7 = new Modifier.Node[16];
                                                            mutableVector2 = new MutableVector(k$iv7, 0);
                                                        } else {
                                                            mutableVector2 = mutableVector3;
                                                        }
                                                        MutableVector mutableVector4 = mutableVector2;
                                                        Modifier.Node theNode$iv$iv = nodePop;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector4 != null) {
                                                                Boolean.valueOf(mutableVector4.add(theNode$iv$iv));
                                                            }
                                                            nodePop = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            Boolean.valueOf(mutableVector4.add(next$iv$iv));
                                                        }
                                                        mutableVector3 = mutableVector4;
                                                        count$iv$iv = count$iv$iv;
                                                    }
                                                } else {
                                                    $i$f$forEach4 = $i$f$forEach5;
                                                    k$iv6 = k$iv6;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                $i$f$forEach5 = $i$f$forEach4;
                                                k$iv6 = k$iv6;
                                            }
                                            $i$f$forEach3 = $i$f$forEach5;
                                            k$iv5 = k$iv6;
                                            if (count$iv$iv == 1) {
                                                this_$iv4 = this_$iv3;
                                                $i$f$forEach5 = $i$f$forEach3;
                                                k$iv6 = k$iv5;
                                            }
                                        } else {
                                            $i$f$forEach3 = $i$f$forEach5;
                                            k$iv5 = k$iv6;
                                        }
                                    }
                                    nodePop = DelegatableNodeKt.pop(mutableVector3);
                                    this_$iv4 = this_$iv3;
                                    $i$f$forEach5 = $i$f$forEach3;
                                    k$iv6 = k$iv5;
                                }
                                this_$iv2 = this_$iv4;
                                $i$f$forEach2 = $i$f$forEach5;
                                k$iv4 = k$iv6;
                                int mask$iv$iv = iM5876constructorimpl;
                                DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                if (!$this$visitChildren$iv$iv.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                MutableVector branches$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child$iv$iv3 = $this$visitChildren$iv$iv.getNode().getChild();
                                if (child$iv$iv3 == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, $this$visitChildren$iv$iv.getNode());
                                } else {
                                    branches$iv$iv3.add(child$iv$iv3);
                                }
                                while (branches$iv$iv3.isNotEmpty()) {
                                    MutableVector this_$iv$iv$iv6 = branches$iv$iv3;
                                    Modifier.Node branch$iv$iv2 = (Modifier.Node) branches$iv$iv3.removeAt(this_$iv$iv$iv6.getSize() - 1);
                                    if ((branch$iv$iv2.getAggregateChildKindSet() & mask$iv$iv) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, branch$iv$iv2);
                                    } else {
                                        for (Modifier.Node node$iv$iv = branch$iv$iv2; node$iv$iv != null; node$iv$iv = node$iv$iv.getChild()) {
                                            if ((node$iv$iv.getKindSet() & mask$iv$iv) != 0) {
                                                Modifier.Node it$iv = node$iv$iv;
                                                MutableVector mutableVector5 = null;
                                                int mask$iv$iv2 = mask$iv$iv;
                                                Modifier.Node nodePop2 = it$iv;
                                                while (nodePop2 != null) {
                                                    $this$visitChildren$iv$iv = $this$visitChildren$iv$iv;
                                                    if (nodePop2 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTarget2 = (FocusTargetNode) nodePop2;
                                                        branches$iv$iv2 = branches$iv$iv3;
                                                        this.focusTargetNodes.add(focusTarget2);
                                                        child$iv$iv2 = child$iv$iv3;
                                                    } else {
                                                        branches$iv$iv2 = branches$iv$iv3;
                                                        Modifier.Node this_$iv$iv$iv7 = nodePop2;
                                                        if (((this_$iv$iv$iv7.getKindSet() & iM5876constructorimpl) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                                            int count$iv$iv2 = 0;
                                                            DelegatingNode this_$iv$iv$iv8 = (DelegatingNode) nodePop2;
                                                            Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv8.getDelegate();
                                                            while (node$iv$iv$iv2 != null) {
                                                                Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                                                                if ((next$iv$iv2.getKindSet() & iM5876constructorimpl) != 0) {
                                                                    count$iv$iv2++;
                                                                    this_$iv$iv$iv3 = this_$iv$iv$iv8;
                                                                    if (count$iv$iv2 == 1) {
                                                                        nodePop2 = next$iv$iv2;
                                                                        child$iv$iv3 = child$iv$iv3;
                                                                    } else {
                                                                        MutableVector mutableVector6 = mutableVector5 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector5;
                                                                        Modifier.Node theNode$iv$iv2 = nodePop2;
                                                                        if (theNode$iv$iv2 != null) {
                                                                            if (mutableVector6 != null) {
                                                                                Boolean.valueOf(mutableVector6.add(theNode$iv$iv2));
                                                                            }
                                                                            nodePop2 = null;
                                                                        }
                                                                        if (mutableVector6 != null) {
                                                                            Boolean.valueOf(mutableVector6.add(next$iv$iv2));
                                                                        }
                                                                        mutableVector5 = mutableVector6;
                                                                        count$iv$iv2 = count$iv$iv2;
                                                                    }
                                                                } else {
                                                                    this_$iv$iv$iv3 = this_$iv$iv$iv8;
                                                                    child$iv$iv3 = child$iv$iv3;
                                                                }
                                                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                                                this_$iv$iv$iv8 = this_$iv$iv$iv3;
                                                                child$iv$iv3 = child$iv$iv3;
                                                            }
                                                            child$iv$iv2 = child$iv$iv3;
                                                            if (count$iv$iv2 == 1) {
                                                                branches$iv$iv3 = branches$iv$iv2;
                                                                child$iv$iv3 = child$iv$iv2;
                                                            }
                                                        } else {
                                                            child$iv$iv2 = child$iv$iv3;
                                                        }
                                                    }
                                                    nodePop2 = DelegatableNodeKt.pop(mutableVector5);
                                                    branches$iv$iv3 = branches$iv$iv2;
                                                    child$iv$iv3 = child$iv$iv2;
                                                }
                                                mask$iv$iv = mask$iv$iv2;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                this_$iv2 = this_$iv4;
                                $i$f$forEach2 = $i$f$forEach5;
                                k$iv4 = k$iv6;
                            }
                        } else {
                            this_$iv2 = this_$iv4;
                            $i$f$forEach2 = $i$f$forEach5;
                            k$iv4 = k$iv6;
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        this_$iv$iv4 = this_$iv$iv4;
                        $i$f$forEachIndex4 = $i$f$forEachIndex4;
                        this_$iv4 = this_$iv2;
                        $i$f$forEach5 = $i$f$forEach2;
                        k$iv6 = k$iv4;
                    }
                    this_$iv = this_$iv4;
                    $i$f$forEach = $i$f$forEach5;
                    k$iv3 = k$iv6;
                    this_$iv$iv3 = this_$iv$iv4;
                    $i$f$forEachIndex3 = $i$f$forEachIndex4;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                } else {
                    this_$iv = this_$iv4;
                    $i$f$forEach = $i$f$forEach5;
                    k$iv3 = k$iv6;
                    this_$iv$iv3 = this_$iv$iv4;
                    $i$f$forEachIndex3 = $i$f$forEachIndex4;
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv$iv4 = this_$iv$iv3;
                $i$f$forEachIndex4 = $i$f$forEachIndex3;
                this_$iv4 = this_$iv;
                $i$f$forEach5 = $i$f$forEach;
                k$iv6 = k$iv3;
                c = 7;
            }
        }
        this.focusPropertiesNodes.clear();
        ScatterSet this_$iv5 = this.focusEventNodes;
        int $i$f$forEach6 = 0;
        Object[] k$iv8 = this_$iv5.elements;
        ScatterSet this_$iv$iv5 = this_$iv5;
        int $i$f$forEachIndex5 = 0;
        long[] m$iv$iv5 = this_$iv$iv5.metadata;
        int lastIndex$iv$iv2 = m$iv$iv5.length - 2;
        int i$iv$iv2 = 0;
        if (0 <= lastIndex$iv$iv2) {
            while (true) {
                long slot$iv$iv2 = m$iv$iv5[i$iv$iv2];
                ScatterSet this_$iv6 = this_$iv5;
                int $i$f$forEach7 = $i$f$forEach6;
                if ((((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                    int j$iv$iv2 = 0;
                    while (j$iv$iv2 < bitCount$iv$iv2) {
                        long value$iv$iv$iv2 = slot$iv$iv2 & 255;
                        int $i$f$isFull2 = value$iv$iv$iv2 < 128 ? 1 : 0;
                        if ($i$f$isFull2 != 0) {
                            int index$iv$iv2 = (i$iv$iv2 << 3) + j$iv$iv2;
                            k$iv2 = k$iv8;
                            FocusEventModifierNode focusEventNode = (FocusEventModifierNode) k$iv8[index$iv$iv2];
                            if (focusEventNode.getNode().getIsAttached()) {
                                this_$iv$iv2 = this_$iv$iv5;
                                boolean aggregatedNode = false;
                                FocusTargetNode focusTargetNode = null;
                                FocusEventModifierNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = focusEventNode;
                                int iM5876constructorimpl2 = NodeKind.m5876constructorimpl(1024);
                                Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2.getNode();
                                MutableVector mutableVector7 = null;
                                boolean requiresUpdate = true;
                                Modifier.Node nodePop3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                while (nodePop3 != null) {
                                    $i$f$forEachIndex5 = $i$f$forEachIndex5;
                                    if (nodePop3 instanceof FocusTargetNode) {
                                        FocusTargetNode it2 = (FocusTargetNode) nodePop3;
                                        if (focusTargetNode != null) {
                                            aggregatedNode = true;
                                        }
                                        focusTargetNode = it2;
                                        m$iv$iv3 = m$iv$iv5;
                                        if (this.focusTargetNodes.contains(it2)) {
                                            requiresUpdate = false;
                                            this.focusTargetsWithInvalidatedFocusEvents.add(it2);
                                        }
                                        index$iv$iv = index$iv$iv2;
                                    } else {
                                        m$iv$iv3 = m$iv$iv5;
                                        Modifier.Node this_$iv$iv$iv9 = nodePop3;
                                        if (((this_$iv$iv$iv9.getKindSet() & iM5876constructorimpl2) != 0) && (nodePop3 instanceof DelegatingNode)) {
                                            int count$iv$iv3 = 0;
                                            DelegatingNode this_$iv$iv$iv10 = (DelegatingNode) nodePop3;
                                            Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv10.getDelegate();
                                            while (node$iv$iv$iv3 != null) {
                                                Modifier.Node next$iv$iv3 = node$iv$iv$iv3;
                                                if ((next$iv$iv3.getKindSet() & iM5876constructorimpl2) != 0) {
                                                    count$iv$iv3++;
                                                    this_$iv$iv$iv2 = this_$iv$iv$iv10;
                                                    if (count$iv$iv3 == 1) {
                                                        nodePop3 = next$iv$iv3;
                                                        index$iv$iv2 = index$iv$iv2;
                                                    } else {
                                                        MutableVector mutableVector8 = mutableVector7 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector7;
                                                        Modifier.Node theNode$iv$iv3 = nodePop3;
                                                        if (theNode$iv$iv3 != null) {
                                                            if (mutableVector8 != null) {
                                                                Boolean.valueOf(mutableVector8.add(theNode$iv$iv3));
                                                            }
                                                            nodePop3 = null;
                                                        }
                                                        if (mutableVector8 != null) {
                                                            Boolean.valueOf(mutableVector8.add(next$iv$iv3));
                                                        }
                                                        mutableVector7 = mutableVector8;
                                                        count$iv$iv3 = count$iv$iv3;
                                                    }
                                                } else {
                                                    this_$iv$iv$iv2 = this_$iv$iv$iv10;
                                                    index$iv$iv2 = index$iv$iv2;
                                                }
                                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild();
                                                this_$iv$iv$iv10 = this_$iv$iv$iv2;
                                                index$iv$iv2 = index$iv$iv2;
                                            }
                                            index$iv$iv = index$iv$iv2;
                                            if (count$iv$iv3 == 1) {
                                                m$iv$iv5 = m$iv$iv3;
                                                index$iv$iv2 = index$iv$iv;
                                            }
                                        } else {
                                            index$iv$iv = index$iv$iv2;
                                        }
                                    }
                                    nodePop3 = DelegatableNodeKt.pop(mutableVector7);
                                    m$iv$iv5 = m$iv$iv3;
                                    index$iv$iv2 = index$iv$iv;
                                }
                                $i$f$forEachIndex2 = $i$f$forEachIndex5;
                                m$iv$iv2 = m$iv$iv5;
                                int mask$iv$iv3 = iM5876constructorimpl2;
                                DelegatableNode $this$visitChildren$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                                if (!$this$visitChildren$iv$iv2.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                MutableVector branches$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child$iv$iv4 = $this$visitChildren$iv$iv2.getNode().getChild();
                                if (child$iv$iv4 == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, $this$visitChildren$iv$iv2.getNode());
                                } else {
                                    branches$iv$iv4.add(child$iv$iv4);
                                }
                                while (branches$iv$iv4.isNotEmpty()) {
                                    MutableVector this_$iv$iv$iv11 = branches$iv$iv4;
                                    Modifier.Node branch$iv$iv3 = (Modifier.Node) branches$iv$iv4.removeAt(this_$iv$iv$iv11.getSize() - 1);
                                    if ((branch$iv$iv3.getAggregateChildKindSet() & mask$iv$iv3) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, branch$iv$iv3);
                                        mutableVector = branches$iv$iv4;
                                    } else {
                                        Modifier.Node node$iv$iv2 = branch$iv$iv3;
                                        while (true) {
                                            if (node$iv$iv2 == null) {
                                                mutableVector = branches$iv$iv4;
                                            } else {
                                                if ((node$iv$iv2.getKindSet() & mask$iv$iv3) != 0) {
                                                    Modifier.Node it$iv2 = node$iv$iv2;
                                                    MutableVector mutableVector9 = null;
                                                    int mask$iv$iv4 = mask$iv$iv3;
                                                    Modifier.Node nodePop4 = it$iv2;
                                                    while (nodePop4 != null) {
                                                        $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv2;
                                                        if (nodePop4 instanceof FocusTargetNode) {
                                                            FocusTargetNode it3 = (FocusTargetNode) nodePop4;
                                                            if (focusTargetNode != null) {
                                                                aggregatedNode = true;
                                                            }
                                                            focusTargetNode = it3;
                                                            branches$iv$iv = branches$iv$iv4;
                                                            if (this.focusTargetNodes.contains(it3)) {
                                                                requiresUpdate = false;
                                                                this.focusTargetsWithInvalidatedFocusEvents.add(it3);
                                                            }
                                                            child$iv$iv = child$iv$iv4;
                                                            branch$iv$iv = branch$iv$iv3;
                                                        } else {
                                                            branches$iv$iv = branches$iv$iv4;
                                                            Modifier.Node this_$iv$iv$iv12 = nodePop4;
                                                            if (((this_$iv$iv$iv12.getKindSet() & iM5876constructorimpl2) != 0) && (nodePop4 instanceof DelegatingNode)) {
                                                                int count$iv$iv4 = 0;
                                                                DelegatingNode this_$iv$iv$iv13 = (DelegatingNode) nodePop4;
                                                                Modifier.Node node$iv$iv$iv4 = this_$iv$iv$iv13.getDelegate();
                                                                while (node$iv$iv$iv4 != null) {
                                                                    Modifier.Node next$iv$iv4 = node$iv$iv$iv4;
                                                                    if ((next$iv$iv4.getKindSet() & iM5876constructorimpl2) != 0) {
                                                                        count$iv$iv4++;
                                                                        this_$iv$iv$iv = this_$iv$iv$iv13;
                                                                        if (count$iv$iv4 == 1) {
                                                                            nodePop4 = next$iv$iv4;
                                                                            child$iv$iv4 = child$iv$iv4;
                                                                            branch$iv$iv3 = branch$iv$iv3;
                                                                        } else {
                                                                            MutableVector mutableVector10 = mutableVector9 == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector9;
                                                                            Modifier.Node theNode$iv$iv4 = nodePop4;
                                                                            if (theNode$iv$iv4 != null) {
                                                                                if (mutableVector10 != null) {
                                                                                    Boolean.valueOf(mutableVector10.add(theNode$iv$iv4));
                                                                                }
                                                                                nodePop4 = null;
                                                                            }
                                                                            if (mutableVector10 != null) {
                                                                                Boolean.valueOf(mutableVector10.add(next$iv$iv4));
                                                                            }
                                                                            mutableVector9 = mutableVector10;
                                                                            count$iv$iv4 = count$iv$iv4;
                                                                        }
                                                                    } else {
                                                                        this_$iv$iv$iv = this_$iv$iv$iv13;
                                                                        child$iv$iv4 = child$iv$iv4;
                                                                        branch$iv$iv3 = branch$iv$iv3;
                                                                    }
                                                                    node$iv$iv$iv4 = node$iv$iv$iv4.getChild();
                                                                    this_$iv$iv$iv13 = this_$iv$iv$iv;
                                                                    child$iv$iv4 = child$iv$iv4;
                                                                    branch$iv$iv3 = branch$iv$iv3;
                                                                }
                                                                child$iv$iv = child$iv$iv4;
                                                                branch$iv$iv = branch$iv$iv3;
                                                                if (count$iv$iv4 == 1) {
                                                                    branches$iv$iv4 = branches$iv$iv;
                                                                    child$iv$iv4 = child$iv$iv;
                                                                    branch$iv$iv3 = branch$iv$iv;
                                                                }
                                                            } else {
                                                                child$iv$iv = child$iv$iv4;
                                                                branch$iv$iv = branch$iv$iv3;
                                                            }
                                                        }
                                                        nodePop4 = DelegatableNodeKt.pop(mutableVector9);
                                                        branches$iv$iv4 = branches$iv$iv;
                                                        child$iv$iv4 = child$iv$iv;
                                                        branch$iv$iv3 = branch$iv$iv;
                                                    }
                                                    mask$iv$iv3 = mask$iv$iv4;
                                                    branches$iv$iv4 = branches$iv$iv4;
                                                    break;
                                                }
                                                node$iv$iv2 = node$iv$iv2.getChild();
                                                branches$iv$iv4 = branches$iv$iv4;
                                                branch$iv$iv3 = branch$iv$iv3;
                                            }
                                        }
                                    }
                                    mask$iv$iv3 = mask$iv$iv3;
                                    $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv2;
                                    branches$iv$iv4 = mutableVector;
                                    child$iv$iv4 = child$iv$iv4;
                                }
                                if (requiresUpdate) {
                                    if (aggregatedNode) {
                                        focusState2 = FocusEventModifierNodeKt.getFocusState(focusEventNode);
                                    } else {
                                        if (focusTargetNode == null || (focusState = focusTargetNode.getFocusState()) == null) {
                                            focusState = FocusStateImpl.Inactive;
                                        }
                                        focusState2 = focusState;
                                    }
                                    focusEventNode.onFocusEvent(focusState2);
                                }
                            } else {
                                this_$iv$iv2 = this_$iv$iv5;
                                focusEventNode.onFocusEvent(FocusStateImpl.Inactive);
                                $i$f$forEachIndex2 = $i$f$forEachIndex5;
                                m$iv$iv2 = m$iv$iv5;
                            }
                        } else {
                            k$iv2 = k$iv8;
                            this_$iv$iv2 = this_$iv$iv5;
                            $i$f$forEachIndex2 = $i$f$forEachIndex5;
                            m$iv$iv2 = m$iv$iv5;
                        }
                        slot$iv$iv2 >>= 8;
                        j$iv$iv2++;
                        k$iv8 = k$iv2;
                        this_$iv$iv5 = this_$iv$iv2;
                        $i$f$forEachIndex5 = $i$f$forEachIndex2;
                        m$iv$iv5 = m$iv$iv2;
                    }
                    k$iv = k$iv8;
                    this_$iv$iv = this_$iv$iv5;
                    $i$f$forEachIndex = $i$f$forEachIndex5;
                    m$iv$iv = m$iv$iv5;
                    if (bitCount$iv$iv2 != 8) {
                        break;
                    }
                } else {
                    k$iv = k$iv8;
                    this_$iv$iv = this_$iv$iv5;
                    $i$f$forEachIndex = $i$f$forEachIndex5;
                    m$iv$iv = m$iv$iv5;
                }
                if (i$iv$iv2 == lastIndex$iv$iv2) {
                    break;
                }
                i$iv$iv2++;
                this_$iv5 = this_$iv6;
                $i$f$forEach6 = $i$f$forEach7;
                k$iv8 = k$iv;
                this_$iv$iv5 = this_$iv$iv;
                $i$f$forEachIndex5 = $i$f$forEachIndex;
                m$iv$iv5 = m$iv$iv;
            }
        }
        this.focusEventNodes.clear();
        ScatterSet this_$iv7 = this.focusTargetNodes;
        Object[] k$iv9 = this_$iv7.elements;
        long[] m$iv$iv6 = this_$iv7.metadata;
        int lastIndex$iv$iv3 = m$iv$iv6.length - 2;
        int i$iv$iv3 = 0;
        if (0 <= lastIndex$iv$iv3) {
            while (true) {
                long slot$iv$iv3 = m$iv$iv6[i$iv$iv3];
                long[] m$iv$iv7 = m$iv$iv6;
                if ((((~slot$iv$iv3) << 7) & slot$iv$iv3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int bitCount$iv$iv3 = 8 - ((~(i$iv$iv3 - lastIndex$iv$iv3)) >>> 31);
                    for (int j$iv$iv3 = 0; j$iv$iv3 < bitCount$iv$iv3; j$iv$iv3++) {
                        long value$iv$iv$iv3 = slot$iv$iv3 & 255;
                        int $i$f$isFull3 = value$iv$iv$iv3 < 128 ? 1 : 0;
                        if ($i$f$isFull3 != 0) {
                            FocusTargetNode it4 = (FocusTargetNode) k$iv9[(i$iv$iv3 << 3) + j$iv$iv3];
                            if (it4.getIsAttached()) {
                                FocusStateImpl preInvalidationState = it4.getFocusState();
                                it4.invalidateFocus$ui_release();
                                if (preInvalidationState != it4.getFocusState() || this.focusTargetsWithInvalidatedFocusEvents.contains(it4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(it4);
                                }
                            }
                        }
                        slot$iv$iv3 >>= 8;
                    }
                    if (bitCount$iv$iv3 != 8) {
                        break;
                    }
                }
                if (i$iv$iv3 == lastIndex$iv$iv3) {
                    break;
                }
                i$iv$iv3++;
                m$iv$iv6 = m$iv$iv7;
            }
        }
        this.focusTargetNodes.clear();
        this.focusTargetsWithInvalidatedFocusEvents.clear();
        this.invalidateOwnerFocusState.invoke();
        boolean value$iv = this.focusPropertiesNodes.isEmpty();
        if (!value$iv) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        boolean value$iv2 = this.focusEventNodes.isEmpty();
        if (!value$iv2) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        boolean value$iv3 = this.focusTargetNodes.isEmpty();
        if (value$iv3) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
    }
}
