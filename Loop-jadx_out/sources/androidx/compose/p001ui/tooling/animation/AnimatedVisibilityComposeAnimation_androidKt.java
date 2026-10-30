package androidx.compose.p001ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimatedVisibilityComposeAnimation.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¨\u0006\u0004"}, m195d2 = {"parseAnimatedVisibility", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "", "ui-tooling_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnimatedVisibilityComposeAnimation_androidKt {
    public static final AnimatedVisibilityComposeAnimation parseAnimatedVisibility(Transition<Boolean> transition) {
        String label = transition.getLabel();
        if (label == null) {
            label = "AnimatedVisibility";
        }
        return new AnimatedVisibilityComposeAnimation(transition, label);
    }
}
