package androidx.compose.material;

import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ:\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m195d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* JADX INFO: renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m1712elevationixp7dh8(float defaultElevation, float pressedElevation, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -654132828, "C(elevation)P(0:c#ui.unit.Dp,1:c#ui.unit.Dp)222@9683L134:FloatingActionButton.kt#jmzs0o");
        if ((i & 1) != 0) {
            defaultElevation = C1979Dp.m6801constructorimpl(6);
        }
        if ((i & 2) != 0) {
            pressedElevation = C1979Dp.m6801constructorimpl(12);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-654132828, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:222)");
        }
        int $this$dp$iv = $changed & 14;
        FloatingActionButtonElevation floatingActionButtonElevationM1713elevationxZ9QkE = m1713elevationxZ9QkE(defaultElevation, pressedElevation, C1979Dp.m6801constructorimpl(8), C1979Dp.m6801constructorimpl(8), $composer, $this$dp$iv | 3456 | ($changed & 112) | (($changed << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return floatingActionButtonElevationM1713elevationxZ9QkE;
    }

    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m1713elevationxZ9QkE(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 380403812, "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)249@10645L367:FloatingActionButton.kt#jmzs0o");
        float defaultElevation2 = (i & 1) != 0 ? C1979Dp.m6801constructorimpl(6) : defaultElevation;
        float pressedElevation2 = (i & 2) != 0 ? C1979Dp.m6801constructorimpl(12) : pressedElevation;
        float hoveredElevation2 = (i & 4) != 0 ? C1979Dp.m6801constructorimpl(8) : hoveredElevation;
        float focusedElevation2 = (i & 8) != 0 ? C1979Dp.m6801constructorimpl(8) : focusedElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:248)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 795787840, "CC(remember):FloatingActionButton.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(defaultElevation2)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(pressedElevation2)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(hoveredElevation2)) || ($changed & 384) == 256) | (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(focusedElevation2)) || ($changed & 3072) == 2048);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new DefaultFloatingActionButtonElevation(defaultElevation2, pressedElevation2, hoveredElevation2, focusedElevation2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultFloatingActionButtonElevation;
    }
}
