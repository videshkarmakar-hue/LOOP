package androidx.compose.material3.internal;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.p006ui.common.Route;
import kotlin.Metadata;

/* JADX INFO: compiled from: Elevation.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m195d2 = {"Landroidx/compose/material3/internal/ElevationDefaults;", "", "()V", "incomingAnimationSpecForInteraction", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/Dp;", Route.INTERACTION, "Landroidx/compose/foundation/interaction/Interaction;", "outgoingAnimationSpecForInteraction", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ElevationDefaults {
    public static final ElevationDefaults INSTANCE = new ElevationDefaults();

    private ElevationDefaults() {
    }

    public final AnimationSpec<C1979Dp> incomingAnimationSpecForInteraction(Interaction interaction) {
        if ((interaction instanceof PressInteraction.Press) || (interaction instanceof DragInteraction.Start) || (interaction instanceof HoverInteraction.Enter) || (interaction instanceof FocusInteraction.Focus)) {
            return ElevationKt.DefaultIncomingSpec;
        }
        return null;
    }

    public final AnimationSpec<C1979Dp> outgoingAnimationSpecForInteraction(Interaction interaction) {
        if (!(interaction instanceof PressInteraction.Press) && !(interaction instanceof DragInteraction.Start)) {
            if (interaction instanceof HoverInteraction.Enter) {
                return ElevationKt.HoveredOutgoingSpec;
            }
            if (interaction instanceof FocusInteraction.Focus) {
                return ElevationKt.DefaultOutgoingSpec;
            }
            return null;
        }
        return ElevationKt.DefaultOutgoingSpec;
    }
}
