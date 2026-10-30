package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aH\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u008a\u0084\u0002"}, m195d2 = {"animateBorderStrokeAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release", "focused"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TextFieldDefaultsKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m2811animateBorderStrokeAsStateNuRrP5Q(boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed) {
        int i;
        int i2;
        State<Color> stateRememberUpdatedState;
        DefaultConstructorMarker defaultConstructorMarker;
        State<C1979Dp> stateRememberUpdatedState2;
        ComposerKt.sourceInformationMarkerStart($composer, -1633063017, "C(animateBorderStrokeAsState)P(1,4,3!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)1554@82386L25,1567@82987L112:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1633063017, $changed, -1, "androidx.compose.material3.animateBorderStrokeAsState (TextFieldDefaults.kt:1553)");
        }
        State<Boolean> stateCollectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        long indicatorColor = colors.m2778indicatorColorXeAY9LY$material3_release(enabled, isError, animateBorderStrokeAsState_NuRrP5Q$lambda$0(stateCollectIsFocusedAsState));
        if (enabled) {
            $composer.startReplaceGroup(-1927767730);
            ComposerKt.sourceInformation($composer, "1557@82539L78");
            i = 150;
            stateRememberUpdatedState = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(indicatorColor, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer, 48, 12);
            $composer.endReplaceGroup();
            i2 = 0;
        } else {
            i = 150;
            $composer.startReplaceGroup(-1927767630);
            ComposerKt.sourceInformation($composer, "1559@82639L36");
            i2 = 0;
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4281boximpl(indicatorColor), $composer, 0);
            $composer.endReplaceGroup();
        }
        State<Color> state = stateRememberUpdatedState;
        float targetThickness = animateBorderStrokeAsState_NuRrP5Q$lambda$0(stateCollectIsFocusedAsState) ? focusedBorderThickness : unfocusedBorderThickness;
        if (enabled) {
            $composer.startReplaceGroup(-1927767444);
            ComposerKt.sourceInformation($composer, "1563@82825L76");
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(i, i2, null, 6, null);
            defaultConstructorMarker = null;
            stateRememberUpdatedState2 = AnimateAsStateKt.m363animateDpAsStateAjpBEmI(targetThickness, tweenSpecTween$default, null, null, $composer, 48, 12);
            $composer.endReplaceGroup();
        } else {
            defaultConstructorMarker = null;
            $composer.startReplaceGroup(-1927767346);
            ComposerKt.sourceInformation($composer, "1565@82923L46");
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(C1979Dp.m6799boximpl(unfocusedBorderThickness), $composer, ($changed >> 15) & 14);
            $composer.endReplaceGroup();
        }
        State<BorderStroke> stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(new BorderStroke(stateRememberUpdatedState2.getValue().m6815unboximpl(), new SolidColor(state.getValue().m4301unboximpl(), defaultConstructorMarker), defaultConstructorMarker), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateRememberUpdatedState3;
    }

    private static final boolean animateBorderStrokeAsState_NuRrP5Q$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }
}
