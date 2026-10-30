package com.videshkarmakar.loop.p006ui.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.color.MaterialColors;
import com.videshkarmakar.loop.p006ui.common.CompositionLocalsKt;
import com.videshkarmakar.loop.util.DarkThemePreference;
import io.material.hct.Hct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorScheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m194d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0006\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a\u001b\u0010K\u001a\u00020L*\u00020M2\b\b\u0002\u0010N\u001a\u00020OH\u0007¢\u0006\u0002\u0010P\u001a\u0011\u0010Q\u001a\u00020\u0001*\u00020\u0006H\u0007¢\u0006\u0002\u0010R\u001a\u001e\u0010S\u001a\u00020\u0001*\u00020\u00012\u0006\u0010T\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a\u0016\u0010W\u001a\u00020\u0001*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\"\u0013\u0010\u0000\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0013\u0010\t\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\"\u0013\u0010\u000b\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\u0003\"\u0013\u0010\r\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u0003\"\u0013\u0010\u000f\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0013\u0010\u0015\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0016\u0010\u0003\"\u0013\u0010\u0017\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0018\u0010\u0003\"\u0013\u0010\u0019\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001a\u0010\u0003\"\u0013\u0010\u001b\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001c\u0010\u0003\"\u0013\u0010\u001d\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001e\u0010\u0003\"\u0013\u0010\u001f\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b \u0010\u0003\"\u0013\u0010!\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\"\u0010\u0003\"\u0013\u0010#\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b$\u0010\u0003\"\u0013\u0010%\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b&\u0010\u0003\"\u0013\u0010'\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b(\u0010\u0003\"\u0013\u0010)\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b*\u0010\u0003\"\u0013\u0010+\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b,\u0010\u0003\"\u0013\u0010-\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b.\u0010\u0003\"\u0013\u0010/\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b0\u0010\u0003\"\u0013\u00101\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b2\u0010\u0003\"\u0013\u00103\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b4\u0010\u0003\"\u0013\u00105\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b6\u0010\u0003\"\u0013\u00107\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b8\u0010\u0003\"\u0013\u00109\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b:\u0010\u0003\"\u0013\u0010;\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b<\u0010\u0003\"\u0013\u0010=\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b>\u0010\u0003\"\u0013\u0010?\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b@\u0010\u0003\"\u0013\u0010A\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bB\u0010\u0003\"\u0013\u0010C\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bD\u0010\u0003\"\u0013\u0010E\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bF\u0010\u0003\"\u0013\u0010G\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bH\u0010\u0003\"\u0013\u0010I\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bJ\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, m195d2 = {"Background", "Landroidx/compose/ui/graphics/Color;", "getBackground", "()J", "J", "DEFAULT_SEED_COLOR", "", "Error", "getError", "ErrorContainer", "getErrorContainer", "InverseOnSurface", "getInverseOnSurface", "InversePrimary", "getInversePrimary", "InverseSurface", "getInverseSurface", "LoopColorScheme", "Landroidx/compose/material3/ColorScheme;", "getLoopColorScheme", "()Landroidx/compose/material3/ColorScheme;", "OnBackground", "getOnBackground", "OnError", "getOnError", "OnErrorContainer", "getOnErrorContainer", "OnPrimary", "getOnPrimary", "OnPrimaryContainer", "getOnPrimaryContainer", "OnSecondary", "getOnSecondary", "OnSecondaryContainer", "getOnSecondaryContainer", "OnSurface", "getOnSurface", "OnSurfaceVariant", "getOnSurfaceVariant", "OnTertiary", "getOnTertiary", "OnTertiaryContainer", "getOnTertiaryContainer", "Outline", "getOutline", "OutlineVariant", "getOutlineVariant", "Primary", "getPrimary", "PrimaryContainer", "getPrimaryContainer", "Scrim", "getScrim", "Secondary", "getSecondary", "SecondaryContainer", "getSecondaryContainer", "Surface", "getSurface", "SurfaceContainer", "getSurfaceContainer", "SurfaceContainerHigh", "getSurfaceContainerHigh", "SurfaceContainerHighest", "getSurfaceContainerHighest", "SurfaceContainerLow", "getSurfaceContainerLow", "SurfaceContainerLowest", "getSurfaceContainerLowest", "SurfaceVariant", "getSurfaceVariant", "Tertiary", "getTertiary", "TertiaryContainer", "getTertiaryContainer", "autoDark", "", "", "isDarkTheme", "", "(Ljava/lang/Number;ZLandroidx/compose/runtime/Composer;II)D", "generateLabelColor", "(ILandroidx/compose/runtime/Composer;I)J", "harmonizeWith", "other", "harmonizeWith-RFnl5yQ", "(JJLandroidx/compose/runtime/Composer;I)J", "harmonizeWithPrimary", "harmonizeWithPrimary-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ColorSchemeKt {
    public static final int DEFAULT_SEED_COLOR = 8026746;
    private static final ColorScheme LoopColorScheme;
    private static final long Background = ColorKt.Color(4279769112L);
    private static final long OnBackground = ColorKt.Color(4291744466L);
    private static final long Surface = ColorKt.Color(4279769112L);
    private static final long OnSurface = ColorKt.Color(4291744466L);
    private static final long SurfaceVariant = ColorKt.Color(4279242768L);
    private static final long OnSurfaceVariant = ColorKt.Color(4287927958L);
    private static final long SurfaceContainer = ColorKt.Color(4280229663L);
    private static final long SurfaceContainerHigh = ColorKt.Color(4280558628L);
    private static final long SurfaceContainerHighest = ColorKt.Color(4281348144L);
    private static final long SurfaceContainerLow = ColorKt.Color(4279505940L);
    private static final long SurfaceContainerLowest = ColorKt.Color(4278848010L);
    private static final long Primary = ColorKt.Color(4291744466L);
    private static final long OnPrimary = ColorKt.Color(4279769112L);
    private static final long PrimaryContainer = ColorKt.Color(4281348144L);
    private static final long OnPrimaryContainer = ColorKt.Color(4291744466L);
    private static final long Secondary = ColorKt.Color(4287927958L);
    private static final long OnSecondary = ColorKt.Color(4279769112L);
    private static final long SecondaryContainer = ColorKt.Color(4280558628L);
    private static final long OnSecondaryContainer = ColorKt.Color(4291744466L);
    private static final long Tertiary = ColorKt.Color(4285624945L);
    private static final long OnTertiary = ColorKt.Color(4291744466L);
    private static final long TertiaryContainer = ColorKt.Color(4280229663L);
    private static final long OnTertiaryContainer = ColorKt.Color(4289506989L);
    private static final long Error = ColorKt.Color(4294111986L);
    private static final long OnError = ColorKt.Color(4279769112L);
    private static final long ErrorContainer = ColorKt.Color(4281348144L);
    private static final long OnErrorContainer = ColorKt.Color(4294111986L);
    private static final long Outline = ColorKt.Color(4283256141L);
    private static final long OutlineVariant = ColorKt.Color(4280558628L);
    private static final long InverseSurface = ColorKt.Color(4291744466L);
    private static final long InverseOnSurface = ColorKt.Color(4279769112L);
    private static final long InversePrimary = ColorKt.Color(4279769112L);
    private static final long Scrim = ColorKt.Color(4278190080L);

    /* JADX INFO: renamed from: harmonizeWithPrimary-ek8zF_U, reason: not valid java name */
    public static final long m7646harmonizeWithPrimaryek8zF_U(long $this$harmonizeWithPrimary_u2dek8zF_U, Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1101520704);
        ComposerKt.sourceInformation($composer, "C(harmonizeWithPrimary)19@749L11:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1101520704, $changed, -1, "com.videshkarmakar.loop.ui.theme.harmonizeWithPrimary (ColorScheme.kt:19)");
        }
        long jColor = ColorKt.Color(MaterialColors.harmonize(ColorKt.m4345toArgb8_81llA($this$harmonizeWithPrimary_u2dek8zF_U), ColorKt.m4345toArgb8_81llA(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary())));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return jColor;
    }

    /* JADX INFO: renamed from: harmonizeWith-RFnl5yQ, reason: not valid java name */
    public static final long m7645harmonizeWithRFnl5yQ(long $this$harmonizeWith_u2dRFnl5yQ, long other, Composer $composer, int $changed) {
        $composer.startReplaceGroup(319755531);
        ComposerKt.sourceInformation($composer, "C(harmonizeWith)P(0:c#ui.graphics.Color):ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(319755531, $changed, -1, "com.videshkarmakar.loop.ui.theme.harmonizeWith (ColorScheme.kt:23)");
        }
        long jColor = ColorKt.Color(MaterialColors.harmonize(ColorKt.m4345toArgb8_81llA($this$harmonizeWith_u2dRFnl5yQ), ColorKt.m4345toArgb8_81llA(other)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return jColor;
    }

    public static final long generateLabelColor(int $this$generateLabelColor, Composer $composer, int $changed) {
        $composer.startReplaceGroup(287018397);
        ComposerKt.sourceInformation($composer, "C(generateLabelColor)33@1105L22:ColorScheme.kt#lfpg37");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(287018397, $changed, -1, "com.videshkarmakar.loop.ui.theme.generateLabelColor (ColorScheme.kt:27)");
        }
        long jM7646harmonizeWithPrimaryek8zF_U = m7646harmonizeWithPrimaryek8zF_U(ColorKt.Color(Hct.INSTANCE.from($this$generateLabelColor % 360, 36.0d, 80.0d).toInt()), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return jM7646harmonizeWithPrimaryek8zF_U;
    }

    static {
        long j = Primary;
        long j2 = PrimaryContainer;
        long j3 = OnPrimary;
        long j4 = OnPrimaryContainer;
        long j5 = InversePrimary;
        long j6 = Secondary;
        long j7 = SecondaryContainer;
        long j8 = OnSecondary;
        long j9 = OnSecondaryContainer;
        long j10 = Tertiary;
        long j11 = TertiaryContainer;
        long j12 = OnTertiary;
        long j13 = OnTertiaryContainer;
        long j14 = Background;
        long j15 = OnBackground;
        long j16 = Surface;
        long j17 = OnSurface;
        long j18 = SurfaceVariant;
        long j19 = OnSurfaceVariant;
        long j20 = SurfaceContainerLowest;
        long j21 = SurfaceContainerLow;
        LoopColorScheme = androidx.compose.material3.ColorSchemeKt.m2084darkColorSchemeCXl9yA$default(j, j3, j2, j4, j5, j6, j8, j7, j9, j10, j12, j11, j13, j14, j15, j16, j17, j18, j19, 0L, InverseSurface, InverseOnSurface, Error, OnError, ErrorContainer, OnErrorContainer, Outline, OutlineVariant, Scrim, 0L, SurfaceContainer, SurfaceContainerHigh, SurfaceContainerHighest, j21, j20, 0L, 537395200, 8, null);
    }

    public static final long getBackground() {
        return Background;
    }

    public static final long getOnBackground() {
        return OnBackground;
    }

    public static final long getSurface() {
        return Surface;
    }

    public static final long getOnSurface() {
        return OnSurface;
    }

    public static final long getSurfaceVariant() {
        return SurfaceVariant;
    }

    public static final long getOnSurfaceVariant() {
        return OnSurfaceVariant;
    }

    public static final long getSurfaceContainer() {
        return SurfaceContainer;
    }

    public static final long getSurfaceContainerHigh() {
        return SurfaceContainerHigh;
    }

    public static final long getSurfaceContainerHighest() {
        return SurfaceContainerHighest;
    }

    public static final long getSurfaceContainerLow() {
        return SurfaceContainerLow;
    }

    public static final long getSurfaceContainerLowest() {
        return SurfaceContainerLowest;
    }

    public static final long getPrimary() {
        return Primary;
    }

    public static final long getOnPrimary() {
        return OnPrimary;
    }

    public static final long getPrimaryContainer() {
        return PrimaryContainer;
    }

    public static final long getOnPrimaryContainer() {
        return OnPrimaryContainer;
    }

    public static final long getSecondary() {
        return Secondary;
    }

    public static final long getOnSecondary() {
        return OnSecondary;
    }

    public static final long getSecondaryContainer() {
        return SecondaryContainer;
    }

    public static final long getOnSecondaryContainer() {
        return OnSecondaryContainer;
    }

    public static final long getTertiary() {
        return Tertiary;
    }

    public static final long getOnTertiary() {
        return OnTertiary;
    }

    public static final long getTertiaryContainer() {
        return TertiaryContainer;
    }

    public static final long getOnTertiaryContainer() {
        return OnTertiaryContainer;
    }

    public static final long getError() {
        return Error;
    }

    public static final long getOnError() {
        return OnError;
    }

    public static final long getErrorContainer() {
        return ErrorContainer;
    }

    public static final long getOnErrorContainer() {
        return OnErrorContainer;
    }

    public static final long getOutline() {
        return Outline;
    }

    public static final long getOutlineVariant() {
        return OutlineVariant;
    }

    public static final long getInverseSurface() {
        return InverseSurface;
    }

    public static final long getInverseOnSurface() {
        return InverseOnSurface;
    }

    public static final long getInversePrimary() {
        return InversePrimary;
    }

    public static final long getScrim() {
        return Scrim;
    }

    public static final ColorScheme getLoopColorScheme() {
        return LoopColorScheme;
    }

    public static final double autoDark(Number $this$autoDark, boolean isDarkTheme, Composer $composer, int $changed, int i) {
        boolean isDarkTheme2;
        double dDoubleValue;
        Intrinsics.checkNotNullParameter($this$autoDark, "<this>");
        $composer.startReplaceGroup(925535920);
        ComposerKt.sourceInformation($composer, "C(autoDark)147@5339L7,147@5347L13:ColorScheme.kt#lfpg37");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<DarkThemePreference> localDarkTheme = CompositionLocalsKt.getLocalDarkTheme();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localDarkTheme);
            ComposerKt.sourceInformationMarkerEnd($composer);
            isDarkTheme2 = ((DarkThemePreference) objConsume).isDarkTheme($composer, 0);
        } else {
            isDarkTheme2 = isDarkTheme;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(925535920, $changed, -1, "com.videshkarmakar.loop.ui.theme.autoDark (ColorScheme.kt:148)");
        }
        if (isDarkTheme2) {
            double dDoubleValue2 = $this$autoDark.doubleValue();
            if (dDoubleValue2 == 6.0d) {
                dDoubleValue = 98.0d;
            } else {
                if (dDoubleValue2 == 10.0d) {
                    dDoubleValue = 99.0d;
                } else {
                    if (dDoubleValue2 == 20.0d) {
                        dDoubleValue = 95.0d;
                    } else {
                        if (dDoubleValue2 == 25.0d) {
                            dDoubleValue = 90.0d;
                        } else {
                            if (dDoubleValue2 == 30.0d) {
                                dDoubleValue = 90.0d;
                            } else {
                                if (dDoubleValue2 == 40.0d) {
                                    dDoubleValue = 80.0d;
                                } else {
                                    if (dDoubleValue2 == 50.0d) {
                                        dDoubleValue = 60.0d;
                                    } else {
                                        if (dDoubleValue2 == 60.0d) {
                                            dDoubleValue = 50.0d;
                                        } else {
                                            if (dDoubleValue2 == 70.0d) {
                                                dDoubleValue = 40.0d;
                                            } else {
                                                if (dDoubleValue2 == 80.0d) {
                                                    dDoubleValue = 40.0d;
                                                } else {
                                                    if (dDoubleValue2 == 90.0d) {
                                                        dDoubleValue = 30.0d;
                                                    } else {
                                                        if (dDoubleValue2 == 95.0d) {
                                                            dDoubleValue = 20.0d;
                                                        } else {
                                                            if (dDoubleValue2 == 98.0d) {
                                                                dDoubleValue = 10.0d;
                                                            } else {
                                                                if (dDoubleValue2 == 99.0d) {
                                                                    dDoubleValue = 10.0d;
                                                                } else {
                                                                    dDoubleValue = dDoubleValue2 == 100.0d ? 20.0d : $this$autoDark.doubleValue();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            dDoubleValue = $this$autoDark.doubleValue();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return dDoubleValue;
    }
}
