package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001aA\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m195d2 = {"unsupportedDirection", "", "lazyLayoutBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LazyLayoutBeyondBoundsModifierLocalKt {
    /* JADX WARN: Code duplicated, block: B:16:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c5  */
    public static final Modifier lazyLayoutBeyondBoundsModifier(Modifier $this$lazyLayoutBeyondBoundsModifier, LazyLayoutBeyondBoundsState state, LazyLayoutBeyondBoundsInfo beyondBoundsInfo, boolean reverseLayout, LayoutDirection layoutDirection, Orientation orientation, boolean enabled, Composer $composer, int $changed) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Modifier modifierThen;
        ComposerKt.sourceInformationMarkerStart($composer, 1331498025, "C(lazyLayoutBeyondBoundsModifier)P(5!1,4,2,3):LazyLayoutBeyondBoundsModifierLocal.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1331498025, $changed, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutBeyondBoundsModifier (LazyLayoutBeyondBoundsModifierLocal.kt:51)");
        }
        $composer.startReplaceGroup(391328174);
        ComposerKt.sourceInformation($composer, "54@2427L270");
        if (enabled) {
            ComposerKt.sourceInformationMarkerStart($composer, 391328222, "CC(remember):LazyLayoutBeyondBoundsModifierLocal.kt#9igjgp");
            if ((($changed & 112) ^ 48) > 32 && $composer.changed(state)) {
                z = true;
            } else if (($changed & 48) == 32) {
                z = true;
            } else {
                z = false;
            }
            if ((($changed & 896) ^ 384) > 256 && $composer.changed(beyondBoundsInfo)) {
                z2 = true;
            } else if (($changed & 384) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z6 = z | z2;
            if ((($changed & 7168) ^ 3072) > 2048 && $composer.changed(reverseLayout)) {
                z3 = true;
            } else if (($changed & 3072) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z7 = z6 | z3;
            if (((57344 & $changed) ^ CpioConstants.C_ISBLK) > 16384 && $composer.changed(layoutDirection)) {
                z4 = true;
            } else if (($changed & CpioConstants.C_ISBLK) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z8 = z7 | z4;
            if (((458752 & $changed) ^ ProfileVerifier.CompilationStatus.f245xf2722a21) <= 131072 || !$composer.changed(orientation)) {
                z5 = ($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 131072;
            }
            boolean invalid$iv = z8 | z5;
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new LazyLayoutBeyondBoundsModifierLocal(state, beyondBoundsInfo, reverseLayout, layoutDirection, orientation);
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            modifierThen = $this$lazyLayoutBeyondBoundsModifier.then((LazyLayoutBeyondBoundsModifierLocal) value$iv);
        } else {
            modifierThen = $this$lazyLayoutBeyondBoundsModifier;
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}
