package androidx.compose.material3;

import androidx.compose.p001ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExpressiveNavigationBar.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tR\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m195d2 = {"Landroidx/compose/material3/ExpressiveNavigationBarItemDefaults;", "", "()V", "defaultExpressiveNavigationBarItemColors", "Landroidx/compose/material3/NavigationItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultExpressiveNavigationBarItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExpressiveNavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final ExpressiveNavigationBarItemDefaults INSTANCE = new ExpressiveNavigationBarItemDefaults();

    private ExpressiveNavigationBarItemDefaults() {
    }

    public final NavigationItemColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1959617551, "C(colors)127@5417L11:ExpressiveNavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1959617551, $changed, -1, "androidx.compose.material3.ExpressiveNavigationBarItemDefaults.colors (ExpressiveNavigationBar.kt:127)");
        }
        NavigationItemColors defaultExpressiveNavigationBarItemColors$material3_release = getDefaultExpressiveNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultExpressiveNavigationBarItemColors$material3_release;
    }

    public final NavigationItemColors getDefaultExpressiveNavigationBarItemColors$material3_release(ColorScheme $this$defaultExpressiveNavigationBarItemColors) {
        NavigationItemColors defaultExpressiveNavigationBarItemColorsCached = $this$defaultExpressiveNavigationBarItemColors.getDefaultExpressiveNavigationBarItemColorsCached();
        if (defaultExpressiveNavigationBarItemColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultExpressiveNavigationBarItemColors, ExpressiveNavigationBarKt.ActiveIconColor);
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultExpressiveNavigationBarItemColors, ExpressiveNavigationBarKt.ActiveLabelTextColor);
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultExpressiveNavigationBarItemColors, ExpressiveNavigationBarKt.ActiveIndicatorColor);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultExpressiveNavigationBarItemColors, ExpressiveNavigationBarKt.InactiveIconColor);
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultExpressiveNavigationBarItemColors, ExpressiveNavigationBarKt.InactiveLabelTextColor);
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultExpressiveNavigationBarItemColors, ExpressiveNavigationBarKt.InactiveIconColor);
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken6) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken6) : 0.0f);
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultExpressiveNavigationBarItemColors, ExpressiveNavigationBarKt.InactiveLabelTextColor);
            NavigationItemColors it = new NavigationItemColors(jFromToken, jFromToken2, jFromToken3, jFromToken4, jFromToken5, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken7) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken7) : 0.0f), null);
            $this$defaultExpressiveNavigationBarItemColors.m22x8a7577ad(it);
            return it;
        }
        return defaultExpressiveNavigationBarItemColorsCached;
    }
}
