package androidx.compose.p001ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVGParser;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: TransitionComposeAnimation.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m195d2 = {"Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/tooling/ComposeAnimation;", "Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;", "animationObject", "Landroidx/compose/animation/core/Transition;", "states", "", "", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/util/Set;Ljava/lang/String;)V", "getAnimationObject", "()Landroidx/compose/animation/core/Transition;", "getLabel", "()Ljava/lang/String;", "getStates", "()Ljava/util/Set;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "ui-tooling_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TransitionComposeAnimation<T> implements ComposeAnimation, TransitionBasedAnimation<T> {
    public static final int $stable = 8;
    private final Transition<T> animationObject;
    private final String label;
    private final Set<Object> states;
    private final ComposeAnimationType type = ComposeAnimationType.TRANSITION_ANIMATION;

    public TransitionComposeAnimation(Transition<T> transition, Set<? extends Object> set, String label) {
        this.animationObject = transition;
        this.states = set;
        this.label = label;
    }

    @Override // androidx.compose.p001ui.tooling.animation.TransitionBasedAnimation
    /* JADX INFO: renamed from: getAnimationObject, reason: merged with bridge method [inline-methods] */
    public Transition<T> m6719getAnimationObject() {
        return this.animationObject;
    }

    public Set<Object> getStates() {
        return this.states;
    }

    public String getLabel() {
        return this.label;
    }

    public ComposeAnimationType getType() {
        return this.type;
    }
}
