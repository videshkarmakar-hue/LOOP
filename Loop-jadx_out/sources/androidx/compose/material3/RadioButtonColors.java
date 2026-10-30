package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m195d2 = {"Landroidx/compose/material3/RadioButtonColors;", "", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledSelectedColor-0d7_KjU", "()J", "J", "getDisabledUnselectedColor-0d7_KjU", "getSelectedColor-0d7_KjU", "getUnselectedColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RadioButtonColors;", "equals", "", "other", "hashCode", "", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "selected", "radioColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RadioButtonColors {
    public static final int $stable = 0;
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ RadioButtonColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private RadioButtonColors(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor) {
        this.selectedColor = selectedColor;
        this.unselectedColor = unselectedColor;
        this.disabledSelectedColor = disabledSelectedColor;
        this.disabledUnselectedColor = disabledUnselectedColor;
    }

    /* JADX INFO: renamed from: getSelectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedColor() {
        return this.selectedColor;
    }

    /* JADX INFO: renamed from: getUnselectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedColor() {
        return this.unselectedColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedColor() {
        return this.disabledSelectedColor;
    }

    /* JADX INFO: renamed from: getDisabledUnselectedColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledUnselectedColor() {
        return this.disabledUnselectedColor;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final RadioButtonColors m2511copyjRlVdoo(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor) {
        return new RadioButtonColors((selectedColor > 16L ? 1 : (selectedColor == 16L ? 0 : -1)) != 0 ? selectedColor : this.selectedColor, (unselectedColor > 16L ? 1 : (unselectedColor == 16L ? 0 : -1)) != 0 ? unselectedColor : this.unselectedColor, (disabledSelectedColor > 16L ? 1 : (disabledSelectedColor == 16L ? 0 : -1)) != 0 ? disabledSelectedColor : this.disabledSelectedColor, disabledUnselectedColor != 16 ? disabledUnselectedColor : this.disabledUnselectedColor, null);
    }

    public final State<Color> radioColor$material3_release(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long target;
        State<Color> stateRememberUpdatedState;
        ComposerKt.sourceInformationMarkerStart($composer, -1840145292, "C(radioColor):RadioButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840145292, $changed, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:223)");
        }
        if (enabled && selected) {
            target = this.selectedColor;
        } else if (!enabled || selected) {
            target = (enabled || !selected) ? this.disabledUnselectedColor : this.disabledSelectedColor;
        } else {
            target = this.unselectedColor;
        }
        if (enabled) {
            $composer.startReplaceGroup(-1943768248);
            ComposerKt.sourceInformation($composer, "234@9988L75");
            stateRememberUpdatedState = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer, 48, 12);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1943768143);
            ComposerKt.sourceInformation($composer, "236@10093L28");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4281boximpl(target), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateRememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof RadioButtonColors) && Color.m4292equalsimpl0(this.selectedColor, ((RadioButtonColors) other).selectedColor) && Color.m4292equalsimpl0(this.unselectedColor, ((RadioButtonColors) other).unselectedColor) && Color.m4292equalsimpl0(this.disabledSelectedColor, ((RadioButtonColors) other).disabledSelectedColor) && Color.m4292equalsimpl0(this.disabledUnselectedColor, ((RadioButtonColors) other).disabledUnselectedColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m4298hashCodeimpl(this.selectedColor);
        return (((((result * 31) + Color.m4298hashCodeimpl(this.unselectedColor)) * 31) + Color.m4298hashCodeimpl(this.disabledSelectedColor)) * 31) + Color.m4298hashCodeimpl(this.disabledUnselectedColor);
    }
}
