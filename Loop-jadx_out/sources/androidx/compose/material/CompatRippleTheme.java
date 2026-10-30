package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, m195d2 = {"Landroidx/compose/material/CompatRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CompatRippleTheme implements RippleTheme {
    public static final int $stable = 0;
    public static final CompatRippleTheme INSTANCE = new CompatRippleTheme();

    private CompatRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Deprecated(message = "Super method is deprecated")
    /* JADX INFO: renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public long mo1650defaultColorWaAFU9c(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1599906584);
        ComposerKt.sourceInformation($composer, "C(defaultColor)282@12390L7,283@12434L6:Ripple.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1599906584, $changed, -1, "androidx.compose.material.CompatRippleTheme.defaultColor (Ripple.kt:281)");
        }
        RippleDefaults rippleDefaults = RippleDefaults.INSTANCE;
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        long jM1774rippleColor5vOe2sY = rippleDefaults.m1774rippleColor5vOe2sY(((Color) objConsume).m4301unboximpl(), MaterialTheme.INSTANCE.getColors($composer, 6).isLight());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return jM1774rippleColor5vOe2sY;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Deprecated(message = "Super method is deprecated")
    public RippleAlpha rippleAlpha(Composer $composer, int $changed) {
        $composer.startReplaceGroup(112776173);
        ComposerKt.sourceInformation($composer, "C(rippleAlpha)289@12620L7,290@12664L6:Ripple.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(112776173, $changed, -1, "androidx.compose.material.CompatRippleTheme.rippleAlpha (Ripple.kt:288)");
        }
        RippleDefaults rippleDefaults = RippleDefaults.INSTANCE;
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        RippleAlpha rippleAlphaM1773rippleAlphaDxMtmZc = rippleDefaults.m1773rippleAlphaDxMtmZc(((Color) objConsume).m4301unboximpl(), MaterialTheme.INSTANCE.getColors($composer, 6).isLight());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return rippleAlphaM1773rippleAlphaDxMtmZc;
    }
}
