package androidx.compose.p001ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: TransitionComposeAnimation.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000¨\u0006\u0003"}, m195d2 = {"parse", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "ui-tooling_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TransitionComposeAnimation_androidKt {
    public static final TransitionComposeAnimation<?> parse(Transition<?> transition) {
        Set states;
        Object state = transition.getCurrentState();
        if (state == null) {
            return null;
        }
        Object[] enumConstants = state.getClass().getEnumConstants();
        if (enumConstants == null || (states = ArraysKt.toSet(enumConstants)) == null) {
            states = SetsKt.setOf(state);
        }
        String label = transition.getLabel();
        if (label == null) {
            label = Reflection.getOrCreateKotlinClass(state.getClass()).getSimpleName();
        }
        return new TransitionComposeAnimation<>(transition, states, label);
    }
}
