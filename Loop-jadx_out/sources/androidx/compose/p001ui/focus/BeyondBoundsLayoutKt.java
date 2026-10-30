package androidx.compose.p001ui.focus;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.BeyondBoundsLayout;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.NodeChain;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BeyondBoundsLayout.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, m195d2 = {"searchBeyondBounds", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BeyondBoundsLayoutKt {
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m3957searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        Modifier.Node node;
        int iM5630getBeforehoxUOeE;
        FocusTargetNode focusTargetNode2;
        int i2;
        int i3;
        FocusTargetNode focusTargetNode3;
        NodeChain nodes;
        int i4;
        int i5;
        FocusTargetNode focusTargetNode4;
        int i6;
        FocusTargetNode focusTargetNode5 = focusTargetNode;
        int iM5876constructorimpl = NodeKind.m5876constructorimpl(1024);
        int i7 = 0;
        FocusTargetNode focusTargetNode6 = focusTargetNode5;
        if (!focusTargetNode6.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = focusTargetNode6.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode6);
        loop0: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                node = null;
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM5876constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM5876constructorimpl) != 0) {
                        MutableVector mutableVector = null;
                        Modifier.Node nodePop = parent;
                        while (nodePop != null) {
                            focusTargetNode5 = focusTargetNode5;
                            if (nodePop instanceof FocusTargetNode) {
                                node = nodePop;
                                break loop0;
                            }
                            if (((nodePop.getKindSet() & iM5876constructorimpl) != 0 ? 1 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                i4 = iM5876constructorimpl;
                                i5 = i7;
                                focusTargetNode4 = focusTargetNode6;
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                                iM5876constructorimpl = i4;
                                i7 = i5;
                                focusTargetNode6 = focusTargetNode4;
                            } else {
                                int i8 = 0;
                                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                while (delegate != null) {
                                    Modifier.Node node2 = delegate;
                                    if ((node2.getKindSet() & iM5876constructorimpl) != 0) {
                                        i8++;
                                        i6 = iM5876constructorimpl;
                                        if (i8 == 1) {
                                            nodePop = node2;
                                            i7 = i7;
                                            focusTargetNode6 = focusTargetNode6;
                                        } else {
                                            MutableVector mutableVector2 = mutableVector == null ? new MutableVector(new Modifier.Node[16], 0) : mutableVector;
                                            Modifier.Node node3 = nodePop;
                                            if (node3 != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node3);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(node2);
                                            }
                                            mutableVector = mutableVector2;
                                            i8 = i8;
                                        }
                                    } else {
                                        i6 = iM5876constructorimpl;
                                        i7 = i7;
                                        focusTargetNode6 = focusTargetNode6;
                                    }
                                    delegate = delegate.getChild();
                                    iM5876constructorimpl = i6;
                                    i7 = i7;
                                    focusTargetNode6 = focusTargetNode6;
                                }
                                i4 = iM5876constructorimpl;
                                i5 = i7;
                                focusTargetNode4 = focusTargetNode6;
                                if (i8 == 1) {
                                    iM5876constructorimpl = i4;
                                    i7 = i5;
                                    focusTargetNode6 = focusTargetNode4;
                                } else {
                                    nodePop = DelegatableNodeKt.pop(mutableVector);
                                    iM5876constructorimpl = i4;
                                    i7 = i5;
                                    focusTargetNode6 = focusTargetNode4;
                                }
                            }
                        }
                    }
                    parent = parent.getParent();
                    focusTargetNode5 = focusTargetNode5;
                    iM5876constructorimpl = iM5876constructorimpl;
                    i7 = i7;
                    focusTargetNode6 = focusTargetNode6;
                }
                focusTargetNode2 = focusTargetNode5;
                i2 = iM5876constructorimpl;
                i3 = i7;
                focusTargetNode3 = focusTargetNode6;
            } else {
                focusTargetNode2 = focusTargetNode5;
                i2 = iM5876constructorimpl;
                i3 = i7;
                focusTargetNode3 = focusTargetNode6;
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            focusTargetNode5 = focusTargetNode2;
            iM5876constructorimpl = i2;
            i7 = i3;
            focusTargetNode6 = focusTargetNode3;
        }
        FocusTargetNode focusTargetNode7 = (FocusTargetNode) node;
        if (focusTargetNode7 != null && Intrinsics.areEqual(focusTargetNode7.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) {
            return null;
        }
        T t = null;
        BeyondBoundsLayout beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent();
        if (beyondBoundsLayoutParent == null) {
            return t;
        }
        if (FocusDirection.m3961equalsimpl0(i, FocusDirection.INSTANCE.m3974getUpdhqQ8s())) {
            iM5630getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5628getAbovehoxUOeE();
        } else if (FocusDirection.m3961equalsimpl0(i, FocusDirection.INSTANCE.m3967getDowndhqQ8s())) {
            iM5630getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5631getBelowhoxUOeE();
        } else if (FocusDirection.m3961equalsimpl0(i, FocusDirection.INSTANCE.m3970getLeftdhqQ8s())) {
            iM5630getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5632getLefthoxUOeE();
        } else if (FocusDirection.m3961equalsimpl0(i, FocusDirection.INSTANCE.m3973getRightdhqQ8s())) {
            iM5630getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5633getRighthoxUOeE();
        } else if (FocusDirection.m3961equalsimpl0(i, FocusDirection.INSTANCE.m3971getNextdhqQ8s())) {
            iM5630getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5629getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m3961equalsimpl0(i, FocusDirection.INSTANCE.m3972getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            iM5630getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m5630getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo1027layouto7g1Pn8(iM5630getBeforehoxUOeE, function1);
    }
}
