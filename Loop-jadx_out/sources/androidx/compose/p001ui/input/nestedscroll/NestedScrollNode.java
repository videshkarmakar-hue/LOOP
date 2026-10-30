package androidx.compose.p001ui.input.nestedscroll;

import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.node.TraversableNode;
import androidx.compose.p001ui.node.TraversableNodeKt;
import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NestedScrollNode.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J#\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J*\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\"\u0010,\u001a\u00020$2\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u001bH\u0002J\u0012\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\u001f\u00103\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b4R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, m195d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "parentConnection", "getParentConnection", "parentNestedScrollNode", "getParentNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "resolvedDispatcher", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onAttach", "", "onDetach", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "resetDispatcherFields", "updateDispatcher", "newDispatcher", "updateDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        this.resolvedDispatcher = dispatcher == null ? new NestedScrollDispatcher() : dispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (getIsAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    @Override // androidx.compose.p001ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope scope$ui_release;
        NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        if ((parentNestedScrollNode$ui_release == null || (scope$ui_release = parentNestedScrollNode$ui_release.getNestedCoroutineScope()) == null) && (scope$ui_release = this.resolvedDispatcher.getScope()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return scope$ui_release;
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo670onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long parentPreConsumed = parentConnection != null ? parentConnection.mo670onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m4065getZeroF1C5BW0();
        long selfPreConsumed = this.connection.mo670onPreScrollOzD1aCk(Offset.m4053minusMKHz9U(available, parentPreConsumed), source);
        return Offset.m4054plusMKHz9U(parentPreConsumed, selfPreConsumed);
    }

    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo668onPostScrollDzOQY0M(long consumed, long available, int source) {
        long parentConsumed;
        long selfConsumed = this.connection.mo668onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            parentConsumed = parentConnection.mo668onPostScrollDzOQY0M(Offset.m4054plusMKHz9U(consumed, selfConsumed), Offset.m4053minusMKHz9U(available, selfConsumed), source);
        } else {
            parentConsumed = Offset.INSTANCE.m4065getZeroF1C5BW0();
        }
        return Offset.m4054plusMKHz9U(selfConsumed, parentConsumed);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo669onPreFlingQWom1Mo(long parentPreConsumed, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        NestedScrollNode nestedScrollNode;
        long parentPreConsumed2;
        Object objMo669onPreFlingQWom1Mo;
        Object objMo669onPreFlingQWom1Mo2;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            if ((nestedScrollNode$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
            }
        } else {
            nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
        }
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$2 = nestedScrollNode$onPreFling$1;
        Object $result = nestedScrollNode$onPreFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nestedScrollNode$onPreFling$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                nestedScrollNode = this;
                NestedScrollConnection parentConnection = nestedScrollNode.getParentConnection();
                if (parentConnection != null) {
                    nestedScrollNode$onPreFling$2.L$0 = nestedScrollNode;
                    nestedScrollNode$onPreFling$2.J$0 = parentPreConsumed;
                    nestedScrollNode$onPreFling$2.label = 1;
                    objMo669onPreFlingQWom1Mo = parentConnection.mo669onPreFlingQWom1Mo(parentPreConsumed, nestedScrollNode$onPreFling$2);
                    if (objMo669onPreFlingQWom1Mo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    parentPreConsumed2 = ((Velocity) objMo669onPreFlingQWom1Mo).getPackedValue();
                } else {
                    parentPreConsumed2 = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                }
                NestedScrollConnection nestedScrollConnection = nestedScrollNode.connection;
                long jM7045minusAH228Gc = Velocity.m7045minusAH228Gc(parentPreConsumed, parentPreConsumed2);
                nestedScrollNode$onPreFling$2.L$0 = null;
                nestedScrollNode$onPreFling$2.J$0 = parentPreConsumed2;
                nestedScrollNode$onPreFling$2.label = 2;
                objMo669onPreFlingQWom1Mo2 = nestedScrollConnection.mo669onPreFlingQWom1Mo(jM7045minusAH228Gc, nestedScrollNode$onPreFling$2);
                if (objMo669onPreFlingQWom1Mo2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long selfPreConsumed = ((Velocity) objMo669onPreFlingQWom1Mo2).getPackedValue();
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(parentPreConsumed2, selfPreConsumed));
            case 1:
                parentPreConsumed = nestedScrollNode$onPreFling$2.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPreFling$2.L$0;
                ResultKt.throwOnFailure($result);
                objMo669onPreFlingQWom1Mo = $result;
                parentPreConsumed2 = ((Velocity) objMo669onPreFlingQWom1Mo).getPackedValue();
                NestedScrollConnection nestedScrollConnection2 = nestedScrollNode.connection;
                long jM7045minusAH228Gc2 = Velocity.m7045minusAH228Gc(parentPreConsumed, parentPreConsumed2);
                nestedScrollNode$onPreFling$2.L$0 = null;
                nestedScrollNode$onPreFling$2.J$0 = parentPreConsumed2;
                nestedScrollNode$onPreFling$2.label = 2;
                objMo669onPreFlingQWom1Mo2 = nestedScrollConnection2.mo669onPreFlingQWom1Mo(jM7045minusAH228Gc2, nestedScrollNode$onPreFling$2);
                if (objMo669onPreFlingQWom1Mo2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long selfPreConsumed2 = ((Velocity) objMo669onPreFlingQWom1Mo2).getPackedValue();
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(parentPreConsumed2, selfPreConsumed2));
            case 2:
                long parentPreConsumed3 = nestedScrollNode$onPreFling$2.J$0;
                ResultKt.throwOnFailure($result);
                parentPreConsumed2 = parentPreConsumed3;
                objMo669onPreFlingQWom1Mo2 = $result;
                long selfPreConsumed3 = ((Velocity) objMo669onPreFlingQWom1Mo2).getPackedValue();
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(parentPreConsumed2, selfPreConsumed3));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0073  */
    /* JADX WARN: Code duplicated, block: B:22:0x008a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0092  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // androidx.compose.p001ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo667onPostFlingRZ2iAVY(long consumed, long j, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        long available;
        Object objMo667onPostFlingRZ2iAVY;
        NestedScrollNode nestedScrollNode;
        long consumed2;
        long selfConsumed;
        NestedScrollConnection parentConnection;
        long parentConsumed;
        Object objMo667onPostFlingRZ2iAVY2;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$2 = (NestedScrollNode$onPostFling$1) continuation;
            if ((nestedScrollNode$onPostFling$2.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$2.label -= Integer.MIN_VALUE;
                nestedScrollNode$onPostFling$1 = nestedScrollNode$onPostFling$2;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
            }
        } else {
            nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        }
        Object $result = nestedScrollNode$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nestedScrollNode$onPostFling$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                available = j;
                NestedScrollConnection nestedScrollConnection = this.connection;
                nestedScrollNode$onPostFling$1.L$0 = this;
                nestedScrollNode$onPostFling$1.J$0 = consumed;
                nestedScrollNode$onPostFling$1.J$1 = available;
                nestedScrollNode$onPostFling$1.label = 1;
                objMo667onPostFlingRZ2iAVY = nestedScrollConnection.mo667onPostFlingRZ2iAVY(consumed, available, nestedScrollNode$onPostFling$1);
                if (objMo667onPostFlingRZ2iAVY == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nestedScrollNode = this;
                consumed2 = consumed;
                selfConsumed = ((Velocity) objMo667onPostFlingRZ2iAVY).getPackedValue();
                parentConnection = nestedScrollNode.getParentConnection();
                if (parentConnection != null) {
                    long jM7046plusAH228Gc = Velocity.m7046plusAH228Gc(consumed2, selfConsumed);
                    long jM7045minusAH228Gc = Velocity.m7045minusAH228Gc(available, selfConsumed);
                    nestedScrollNode$onPostFling$1.L$0 = null;
                    nestedScrollNode$onPostFling$1.J$0 = selfConsumed;
                    nestedScrollNode$onPostFling$1.label = 2;
                    objMo667onPostFlingRZ2iAVY2 = parentConnection.mo667onPostFlingRZ2iAVY(jM7046plusAH228Gc, jM7045minusAH228Gc, nestedScrollNode$onPostFling$1);
                    if (objMo667onPostFlingRZ2iAVY2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    parentConsumed = ((Velocity) objMo667onPostFlingRZ2iAVY2).getPackedValue();
                } else {
                    parentConsumed = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                }
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(selfConsumed, parentConsumed));
            case 1:
                long selfConsumed2 = nestedScrollNode$onPostFling$1.J$1;
                consumed2 = nestedScrollNode$onPostFling$1.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$1.L$0;
                ResultKt.throwOnFailure($result);
                available = selfConsumed2;
                objMo667onPostFlingRZ2iAVY = $result;
                selfConsumed = ((Velocity) objMo667onPostFlingRZ2iAVY).getPackedValue();
                parentConnection = nestedScrollNode.getParentConnection();
                if (parentConnection != null) {
                    long jM7046plusAH228Gc2 = Velocity.m7046plusAH228Gc(consumed2, selfConsumed);
                    long jM7045minusAH228Gc2 = Velocity.m7045minusAH228Gc(available, selfConsumed);
                    nestedScrollNode$onPostFling$1.L$0 = null;
                    nestedScrollNode$onPostFling$1.J$0 = selfConsumed;
                    nestedScrollNode$onPostFling$1.label = 2;
                    objMo667onPostFlingRZ2iAVY2 = parentConnection.mo667onPostFlingRZ2iAVY(jM7046plusAH228Gc2, jM7045minusAH228Gc2, nestedScrollNode$onPostFling$1);
                    if (objMo667onPostFlingRZ2iAVY2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    parentConsumed = ((Velocity) objMo667onPostFlingRZ2iAVY2).getPackedValue();
                } else {
                    parentConsumed = Velocity.INSTANCE.m7053getZero9UxMQ8M();
                }
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(selfConsumed, parentConsumed));
            case 2:
                long selfConsumed3 = nestedScrollNode$onPostFling$1.J$0;
                ResultKt.throwOnFailure($result);
                selfConsumed = selfConsumed3;
                objMo667onPostFlingRZ2iAVY2 = $result;
                parentConsumed = ((Velocity) objMo667onPostFlingRZ2iAVY2).getPackedValue();
                return Velocity.m7033boximpl(Velocity.m7046plusAH228Gc(selfConsumed, parentConsumed));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode.updateDispatcherFields.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return NestedScrollNode.this.getNestedCoroutineScope();
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
