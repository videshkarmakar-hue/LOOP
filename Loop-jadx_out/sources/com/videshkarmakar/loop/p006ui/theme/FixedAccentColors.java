package com.videshkarmakar.loop.p006ui.theme;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: ColorScheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0017\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u0017\u0010\u0019\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0017\u0010\u001b\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m195d2 = {"Lcom/videshkarmakar/loop/ui/theme/FixedAccentColors;", "", "()V", "onPrimaryFixed", "Landroidx/compose/ui/graphics/Color;", "getOnPrimaryFixed", "(Landroidx/compose/runtime/Composer;I)J", "onPrimaryFixedVariant", "getOnPrimaryFixedVariant", "onSecondaryFixed", "getOnSecondaryFixed", "onSecondaryFixedVariant", "getOnSecondaryFixedVariant", "onTertiaryFixed", "getOnTertiaryFixed", "onTertiaryFixedVariant", "getOnTertiaryFixedVariant", "primaryFixed", "getPrimaryFixed", "primaryFixedDim", "getPrimaryFixedDim", "secondaryFixed", "getSecondaryFixed", "secondaryFixedDim", "getSecondaryFixedDim", "tertiaryFixed", "getTertiaryFixed", "tertiaryFixedDim", "getTertiaryFixedDim", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FixedAccentColors {
    public static final int $stable = 0;
    public static final FixedAccentColors INSTANCE = new FixedAccentColors();

    private FixedAccentColors() {
    }

    public final long getPrimaryFixed(Composer $composer, int $changed) {
        $composer.startReplaceGroup(2105208283);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2105208283, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-primaryFixed> (ColorScheme.kt:121)");
        }
        long primaryContainer = ColorSchemeKt.getPrimaryContainer();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return primaryContainer;
    }

    public final long getPrimaryFixedDim(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1866118107);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866118107, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-primaryFixedDim> (ColorScheme.kt:123)");
        }
        long primary = ColorSchemeKt.getPrimary();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return primary;
    }

    public final long getOnPrimaryFixed(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1791804357);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1791804357, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-onPrimaryFixed> (ColorScheme.kt:125)");
        }
        long onPrimaryContainer = ColorSchemeKt.getOnPrimaryContainer();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onPrimaryContainer;
    }

    public final long getOnPrimaryFixedVariant(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1778279137);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778279137, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-onPrimaryFixedVariant> (ColorScheme.kt:127)");
        }
        long onPrimary = ColorSchemeKt.getOnPrimary();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onPrimary;
    }

    public final long getSecondaryFixed(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-12809701);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-12809701, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-secondaryFixed> (ColorScheme.kt:129)");
        }
        long secondaryContainer = ColorSchemeKt.getSecondaryContainer();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return secondaryContainer;
    }

    public final long getSecondaryFixedDim(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1140647049);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1140647049, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-secondaryFixedDim> (ColorScheme.kt:131)");
        }
        long secondary = ColorSchemeKt.getSecondary();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return secondary;
    }

    public final long getOnSecondaryFixed(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1047187141);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1047187141, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-onSecondaryFixed> (ColorScheme.kt:133)");
        }
        long onSecondaryContainer = ColorSchemeKt.getOnSecondaryContainer();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onSecondaryContainer;
    }

    public final long getOnSecondaryFixedVariant(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1510835141);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1510835141, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-onSecondaryFixedVariant> (ColorScheme.kt:135)");
        }
        long onSecondary = ColorSchemeKt.getOnSecondary();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onSecondary;
    }

    public final long getTertiaryFixed(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1520396035);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1520396035, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-tertiaryFixed> (ColorScheme.kt:137)");
        }
        long tertiaryContainer = ColorSchemeKt.getTertiaryContainer();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return tertiaryContainer;
    }

    public final long getTertiaryFixedDim(Composer $composer, int $changed) {
        $composer.startReplaceGroup(770087003);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(770087003, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-tertiaryFixedDim> (ColorScheme.kt:139)");
        }
        long tertiary = ColorSchemeKt.getTertiary();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return tertiary;
    }

    public final long getOnTertiaryFixed(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-221306111);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-221306111, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-onTertiaryFixed> (ColorScheme.kt:141)");
        }
        long onTertiaryContainer = ColorSchemeKt.getOnTertiaryContainer();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onTertiaryContainer;
    }

    public final long getOnTertiaryFixedVariant(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1253104731);
        ComposerKt.sourceInformation($composer, "C:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1253104731, $changed, -1, "com.videshkarmakar.loop.ui.theme.FixedAccentColors.<get-onTertiaryFixedVariant> (ColorScheme.kt:143)");
        }
        long onTertiary = ColorSchemeKt.getOnTertiary();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onTertiary;
    }
}
