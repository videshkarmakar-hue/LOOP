package androidx.compose.foundation.content;

import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.DynamicReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt;
import androidx.compose.p001ui.draganddrop.DragAndDropEvent;
import androidx.compose.p001ui.modifier.ModifierLocal;
import androidx.compose.p001ui.modifier.ModifierLocalMap;
import androidx.compose.p001ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p001ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.p001ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReceiveContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, m195d2 = {"Landroidx/compose/foundation/content/ReceiveContentNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "setReceiveContentListener", "updateNode", "", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ReceiveContentNode extends DelegatingNode implements ModifierLocalModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private ReceiveContentListener receiveContentListener;
    private final ReceiveContentConfiguration receiveContentConfiguration = new DynamicReceiveContentConfiguration(this);
    private final ModifierLocalMap providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.m202to(ReceiveContentConfigurationKt.getModifierLocalReceiveContent(), this.receiveContentConfiguration));

    @Override // androidx.compose.p001ui.modifier.ModifierLocalModifierNode, androidx.compose.p001ui.modifier.ModifierLocalReadScope
    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    @Override // androidx.compose.p001ui.modifier.ModifierLocalModifierNode
    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    public final ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public final void setReceiveContentListener(ReceiveContentListener receiveContentListener) {
        this.receiveContentListener = receiveContentListener;
    }

    public ReceiveContentNode(ReceiveContentListener receiveContentListener) {
        this.receiveContentListener = receiveContentListener;
        delegate(ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode(this.receiveContentConfiguration, new Function1<DragAndDropEvent, Unit>() { // from class: androidx.compose.foundation.content.ReceiveContentNode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DragAndDropEvent dragAndDropEvent) {
                invoke2(dragAndDropEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DragAndDropEvent it) {
                DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(ReceiveContentNode.this, it);
            }
        }));
    }

    @Override // androidx.compose.p001ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    public final void updateNode(ReceiveContentListener receiveContentListener) {
        this.receiveContentListener = receiveContentListener;
    }
}
