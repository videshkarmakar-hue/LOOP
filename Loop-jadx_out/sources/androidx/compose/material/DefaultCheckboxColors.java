package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.state.ToggleableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0019R\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m195d2 = {"Landroidx/compose/material/DefaultCheckboxColors;", "Landroidx/compose/material/CheckboxColors;", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "checkmarkColor", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class DefaultCheckboxColors implements CheckboxColors {
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ DefaultCheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11);
    }

    private DefaultCheckboxColors(long checkedCheckmarkColor, long uncheckedCheckmarkColor, long checkedBoxColor, long uncheckedBoxColor, long disabledCheckedBoxColor, long disabledUncheckedBoxColor, long disabledIndeterminateBoxColor, long checkedBorderColor, long uncheckedBorderColor, long disabledBorderColor, long disabledIndeterminateBorderColor) {
        this.checkedCheckmarkColor = checkedCheckmarkColor;
        this.uncheckedCheckmarkColor = uncheckedCheckmarkColor;
        this.checkedBoxColor = checkedBoxColor;
        this.uncheckedBoxColor = uncheckedBoxColor;
        this.disabledCheckedBoxColor = disabledCheckedBoxColor;
        this.disabledUncheckedBoxColor = disabledUncheckedBoxColor;
        this.disabledIndeterminateBoxColor = disabledIndeterminateBoxColor;
        this.checkedBorderColor = checkedBorderColor;
        this.uncheckedBorderColor = uncheckedBorderColor;
        this.disabledBorderColor = disabledBorderColor;
        this.disabledIndeterminateBorderColor = disabledIndeterminateBorderColor;
    }

    @Override // androidx.compose.material.CheckboxColors
    public State<Color> checkmarkColor(ToggleableState state, Composer $composer, int $changed) {
        long target;
        $composer.startReplaceGroup(544656267);
        ComposerKt.sourceInformation($composer, "C(checkmarkColor)421@16366L61:Checkbox.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(544656267, $changed, -1, "androidx.compose.material.DefaultCheckboxColors.checkmarkColor (Checkbox.kt:413)");
        }
        if (state == ToggleableState.Off) {
            target = this.uncheckedCheckmarkColor;
        } else {
            target = this.checkedCheckmarkColor;
        }
        int duration = state == ToggleableState.Off ? 100 : 50;
        State<Color> stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(duration, 0, null, 6, null), null, null, $composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return stateM351animateColorAsStateeuL9pac;
    }

    @Override // androidx.compose.material.CheckboxColors
    public State<Color> boxColor(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> stateRememberUpdatedState;
        $composer.startReplaceGroup(840901029);
        ComposerKt.sourceInformation($composer, "C(boxColor):Checkbox.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(840901029, $changed, -1, "androidx.compose.material.DefaultCheckboxColors.boxColor (Checkbox.kt:425)");
        }
        if (enabled) {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 2:
                    target = this.checkedBoxColor;
                    break;
                case 3:
                    target = this.uncheckedBoxColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    target = this.disabledCheckedBoxColor;
                    break;
                case 2:
                    target = this.disabledIndeterminateBoxColor;
                    break;
                case 3:
                    target = this.disabledUncheckedBoxColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (enabled) {
            $composer.startReplaceGroup(-2010643589);
            ComposerKt.sourceInformation($composer, "443@17294L61");
            int duration = state == ToggleableState.Off ? 100 : 50;
            stateRememberUpdatedState = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(duration, 0, null, 6, null), null, null, $composer, 0, 12);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-2010643407);
            ComposerKt.sourceInformation($composer, "445@17385L28");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4281boximpl(target), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.CheckboxColors
    public State<Color> borderColor(boolean enabled, ToggleableState state, Composer $composer, int $changed) {
        long target;
        State<Color> stateRememberUpdatedState;
        $composer.startReplaceGroup(-1568341342);
        ComposerKt.sourceInformation($composer, "C(borderColor):Checkbox.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1568341342, $changed, -1, "androidx.compose.material.DefaultCheckboxColors.borderColor (Checkbox.kt:450)");
        }
        if (enabled) {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 2:
                    target = this.checkedBorderColor;
                    break;
                case 3:
                    target = this.uncheckedBorderColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                case 3:
                    target = this.disabledBorderColor;
                    break;
                case 2:
                    target = this.disabledIndeterminateBorderColor;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (enabled) {
            $composer.startReplaceGroup(-796405348);
            ComposerKt.sourceInformation($composer, "467@18254L61");
            int duration = state == ToggleableState.Off ? 100 : 50;
            stateRememberUpdatedState = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(duration, 0, null, 6, null), null, null, $composer, 0, 12);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-796405166);
            ComposerKt.sourceInformation($composer, "469@18345L28");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4281boximpl(target), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }
}
