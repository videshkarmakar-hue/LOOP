package androidx.compose.foundation.gestures;

import androidx.compose.p001ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: AnchoredDraggable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", ExifInterface.GPS_DIRECTION_TRUE, "availableVelocity"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m209c = "androidx.compose.foundation.gestures.AnchoredDraggableOverscrollNode$onDragStopped$2", m210f = "AnchoredDraggable.kt", m211i = {0}, m212l = {HttpStatusCodesKt.HTTP_IM_USED}, m213m = "invokeSuspend", m214n = {"availableVelocity"}, m215s = {"J$0"})
final class AnchoredDraggableOverscrollNode$onDragStopped$2 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableOverscrollNode<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableOverscrollNode$onDragStopped$2(AnchoredDraggableOverscrollNode<T> anchoredDraggableOverscrollNode, Continuation<? super AnchoredDraggableOverscrollNode$onDragStopped$2> continuation) {
        super(2, continuation);
        this.this$0 = anchoredDraggableOverscrollNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnchoredDraggableOverscrollNode$onDragStopped$2 anchoredDraggableOverscrollNode$onDragStopped$2 = new AnchoredDraggableOverscrollNode$onDragStopped$2(this.this$0, continuation);
        anchoredDraggableOverscrollNode$onDragStopped$2.J$0 = ((Velocity) obj).getPackedValue();
        return anchoredDraggableOverscrollNode$onDragStopped$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m583invokesFctU(velocity.getPackedValue(), continuation);
    }

    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m583invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((AnchoredDraggableOverscrollNode$onDragStopped$2) create(Velocity.m7033boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        AnchoredDraggableOverscrollNode$onDragStopped$2 anchoredDraggableOverscrollNode$onDragStopped$2;
        long availableVelocity;
        AnchoredDraggableOverscrollNode anchoredDraggableOverscrollNode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                anchoredDraggableOverscrollNode$onDragStopped$2 = this;
                availableVelocity = anchoredDraggableOverscrollNode$onDragStopped$2.J$0;
                anchoredDraggableOverscrollNode = anchoredDraggableOverscrollNode$onDragStopped$2.this$0;
                anchoredDraggableOverscrollNode$onDragStopped$2.L$0 = anchoredDraggableOverscrollNode;
                anchoredDraggableOverscrollNode$onDragStopped$2.J$0 = availableVelocity;
                anchoredDraggableOverscrollNode$onDragStopped$2.label = 1;
                Object obj = anchoredDraggableOverscrollNode$onDragStopped$2.this$0.getState().settle(anchoredDraggableOverscrollNode$onDragStopped$2.this$0.m578toFloatTH1AsA0(availableVelocity), anchoredDraggableOverscrollNode$onDragStopped$2);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj;
                break;
            case 1:
                long availableVelocity2 = this.J$0;
                AnchoredDraggableOverscrollNode anchoredDraggableOverscrollNode2 = (AnchoredDraggableOverscrollNode) this.L$0;
                ResultKt.throwOnFailure($result);
                anchoredDraggableOverscrollNode = anchoredDraggableOverscrollNode2;
                availableVelocity = availableVelocity2;
                anchoredDraggableOverscrollNode$onDragStopped$2 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long consumed = anchoredDraggableOverscrollNode.m581toVelocityadjELrA(((Number) $result).floatValue());
        float currentOffset = anchoredDraggableOverscrollNode$onDragStopped$2.this$0.getState().requireOffset();
        float minAnchor = anchoredDraggableOverscrollNode$onDragStopped$2.this$0.getState().getAnchors().minAnchor();
        float maxAnchor = anchoredDraggableOverscrollNode$onDragStopped$2.this$0.getState().getAnchors().maxAnchor();
        if (currentOffset >= maxAnchor || currentOffset <= minAnchor) {
            availableVelocity = consumed;
        }
        return Velocity.m7033boximpl(availableVelocity);
    }
}
