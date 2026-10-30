package androidx.compose.foundation.text.input.internal;

import androidx.compose.p001ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: LegacyAdaptingPlatformTextInputModifierNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m195d2 = {"legacyTextInputAdapter", "Landroidx/compose/ui/Modifier;", "serviceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LegacyAdaptingPlatformTextInputModifierNodeKt {
    public static final Modifier legacyTextInputAdapter(Modifier $this$legacyTextInputAdapter, LegacyPlatformTextInputServiceAdapter serviceAdapter) {
        return $this$legacyTextInputAdapter.then(new LegacyAdaptingPlatformTextInputModifier(serviceAdapter));
    }
}
