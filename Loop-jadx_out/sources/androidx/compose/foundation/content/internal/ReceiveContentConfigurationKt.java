package androidx.compose.foundation.content.internal;

import androidx.compose.p001ui.modifier.ModifierLocalKt;
import androidx.compose.p001ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p001ui.modifier.ProvidableModifierLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReceiveContentConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0006H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m195d2 = {"ModifierLocalReceiveContent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getModifierLocalReceiveContent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getReceiveContentConfiguration", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ReceiveContentConfigurationKt {
    private static final ProvidableModifierLocal<ReceiveContentConfiguration> ModifierLocalReceiveContent = ModifierLocalKt.modifierLocalOf(new Function0<ReceiveContentConfiguration>() { // from class: androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt$ModifierLocalReceiveContent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReceiveContentConfiguration invoke() {
            return null;
        }
    });

    public static final ProvidableModifierLocal<ReceiveContentConfiguration> getModifierLocalReceiveContent() {
        return ModifierLocalReceiveContent;
    }

    public static final ReceiveContentConfiguration getReceiveContentConfiguration(ModifierLocalModifierNode $this$getReceiveContentConfiguration) {
        if ($this$getReceiveContentConfiguration.getNode().getIsAttached()) {
            return (ReceiveContentConfiguration) $this$getReceiveContentConfiguration.getCurrent(ModifierLocalReceiveContent);
        }
        return null;
    }
}
