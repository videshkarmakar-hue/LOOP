package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DrawModifierNode;
import androidx.compose.runtime.Composer;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: Indication.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, m195d2 = {"Landroidx/compose/foundation/DefaultDebugIndication;", "Landroidx/compose/foundation/IndicationNodeFactory;", "()V", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "equals", "", "other", "", "hashCode", "", "DefaultDebugIndicationInstance", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class DefaultDebugIndication implements IndicationNodeFactory {
    public static final DefaultDebugIndication INSTANCE = new DefaultDebugIndication();

    @Override // androidx.compose.foundation.Indication
    public /* synthetic */ IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer, int i) {
        return Indication.CC.$default$rememberUpdatedInstance(this, interactionSource, composer, i);
    }

    private DefaultDebugIndication() {
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource interactionSource) {
        return new DefaultDebugIndicationInstance(interactionSource);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        return -1;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object other) {
        return other == this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Indication.kt */
    @Metadata(m194d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\u00020\u000b*\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m195d2 = {"Landroidx/compose/foundation/DefaultDebugIndication$DefaultDebugIndicationInstance;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isFocused", "", "isHovered", "isPressed", "onAttach", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class DefaultDebugIndicationInstance extends Modifier.Node implements DrawModifierNode {
        private final InteractionSource interactionSource;
        private boolean isFocused;
        private boolean isHovered;
        private boolean isPressed;

        @Override // androidx.compose.p001ui.node.DrawModifierNode
        public /* synthetic */ void onMeasureResultChanged() {
            DrawModifierNode.CC.$default$onMeasureResultChanged(this);
        }

        public DefaultDebugIndicationInstance(InteractionSource interactionSource) {
            this.interactionSource = interactionSource;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this, null), 3, null);
        }

        @Override // androidx.compose.p001ui.node.DrawModifierNode
        public void draw(ContentDrawScope $this$draw) {
            $this$draw.drawContent();
            if (this.isPressed) {
                long jM4317getBlack0d7_KjU = Color.INSTANCE.m4317getBlack0d7_KjU();
                DrawScope.CC.m4858drawRectnJ9OG0$default($this$draw, Color.m4289copywmQWz5c(jM4317getBlack0d7_KjU, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4317getBlack0d7_KjU) : 0.3f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4317getBlack0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4317getBlack0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4317getBlack0d7_KjU) : 0.0f), 0L, $this$draw.mo4773getSizeNHjbRc(), 0.0f, null, null, 0, 122, null);
            } else if (this.isHovered || this.isFocused) {
                long jM4317getBlack0d7_KjU2 = Color.INSTANCE.m4317getBlack0d7_KjU();
                DrawScope.CC.m4858drawRectnJ9OG0$default($this$draw, Color.m4289copywmQWz5c(jM4317getBlack0d7_KjU2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4317getBlack0d7_KjU2) : 0.1f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4317getBlack0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4317getBlack0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4317getBlack0d7_KjU2) : 0.0f), 0L, $this$draw.mo4773getSizeNHjbRc(), 0.0f, null, null, 0, 122, null);
            }
        }
    }
}
