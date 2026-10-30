package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJD\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m195d2 = {"Landroidx/compose/material3/NavigationRailItemDefaults;", "", "()V", "defaultNavigationRailItemColors", "Landroidx/compose/material3/NavigationRailItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationRailItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationRailItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationRailItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NavigationRailItemDefaults {
    public static final int $stable = 0;
    public static final NavigationRailItemDefaults INSTANCE = new NavigationRailItemDefaults();

    private NavigationRailItemDefaults() {
    }

    public final NavigationRailItemColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -2014332261, "C(colors)302@12909L11:NavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2014332261, $changed, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:302)");
        }
        NavigationRailItemColors defaultNavigationRailItemColors$material3_release = getDefaultNavigationRailItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultNavigationRailItemColors$material3_release;
    }

    /* JADX INFO: renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationRailItemColors m2455colors69fazGs(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, long disabledIconColor, long disabledTextColor, Composer $composer, int $changed, int i) {
        long disabledIconColor2;
        long disabledTextColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -2104358508, "C(colors)P(3:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)319@13935L5,320@14019L5,321@14100L5,322@14183L5,323@14271L5,326@14494L11:NavigationRail.kt#uh7d8r");
        long selectedIconColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIconColor(), $composer, 6) : selectedIconColor;
        long selectedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6) : selectedTextColor;
        long indicatorColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6) : indicatorColor;
        long unselectedIconColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveIconColor(), $composer, 6) : unselectedIconColor;
        long unselectedTextColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveLabelTextColor(), $composer, 6) : unselectedTextColor;
        if ((i & 32) != 0) {
            long j = unselectedIconColor2;
            disabledIconColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            disabledIconColor2 = disabledIconColor;
        }
        if ((i & 64) != 0) {
            long j2 = unselectedTextColor2;
            disabledTextColor2 = Color.m4289copywmQWz5c(j2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j2) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j2) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2104358508, $changed, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:326)");
        }
        NavigationRailItemColors navigationRailItemColorsM2444copy4JmcsL4 = getDefaultNavigationRailItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2444copy4JmcsL4(selectedIconColor2, selectedTextColor2, indicatorColor2, unselectedIconColor2, unselectedTextColor2, disabledIconColor2, disabledTextColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return navigationRailItemColorsM2444copy4JmcsL4;
    }

    public final NavigationRailItemColors getDefaultNavigationRailItemColors$material3_release(ColorScheme $this$defaultNavigationRailItemColors) {
        NavigationRailItemColors defaultNavigationRailItemColorsCached = $this$defaultNavigationRailItemColors.getDefaultNavigationRailItemColorsCached();
        if (defaultNavigationRailItemColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultNavigationRailItemColors, NavigationRailTokens.INSTANCE.getActiveIconColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultNavigationRailItemColors, NavigationRailTokens.INSTANCE.getActiveLabelTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultNavigationRailItemColors, NavigationRailTokens.INSTANCE.getActiveIndicatorColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultNavigationRailItemColors, NavigationRailTokens.INSTANCE.getInactiveIconColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultNavigationRailItemColors, NavigationRailTokens.INSTANCE.getInactiveLabelTextColor());
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultNavigationRailItemColors, NavigationRailTokens.INSTANCE.getInactiveIconColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken6) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken6) : 0.0f);
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultNavigationRailItemColors, NavigationRailTokens.INSTANCE.getInactiveLabelTextColor());
            NavigationRailItemColors it = new NavigationRailItemColors(jFromToken, jFromToken2, jFromToken3, jFromToken4, jFromToken5, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken7) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken7) : 0.0f), null);
            $this$defaultNavigationRailItemColors.setDefaultNavigationRailItemColorsCached$material3_release(it);
            return it;
        }
        return defaultNavigationRailItemColorsCached;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final /* synthetic */ NavigationRailItemColors m2456colorszjMxDiM(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1621601574, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)359@16112L5,360@16196L5,361@16277L5,362@16360L5,363@16448L5:NavigationRail.kt#uh7d8r");
        long selectedIconColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIconColor(), $composer, 6) : selectedIconColor;
        long selectedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6) : selectedTextColor;
        long indicatorColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6) : indicatorColor;
        long unselectedIconColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveIconColor(), $composer, 6) : unselectedIconColor;
        long unselectedTextColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveLabelTextColor(), $composer, 6) : unselectedTextColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1621601574, $changed, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:364)");
        }
        long j = unselectedIconColor2;
        long jM4289copywmQWz5c = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        long j2 = unselectedTextColor2;
        NavigationRailItemColors navigationRailItemColors = new NavigationRailItemColors(selectedIconColor2, selectedTextColor2, indicatorColor2, unselectedIconColor2, unselectedTextColor2, jM4289copywmQWz5c, Color.m4289copywmQWz5c(j2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j2) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j2) : 0.0f), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return navigationRailItemColors;
    }
}
