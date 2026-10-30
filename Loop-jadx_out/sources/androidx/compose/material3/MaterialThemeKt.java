package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m195d2 = {"TextSelectionBackgroundOpacity", "", "MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MaterialThemeKt {
    public static final float TextSelectionBackgroundOpacity = 0.4f;

    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        ColorScheme colorScheme2;
        Shapes shapes2;
        Typography typography2;
        int $dirty;
        final Typography typography3;
        Typography typography4;
        ColorScheme colorScheme3;
        Shapes shapes3;
        Composer $composer2 = $composer.startRestartGroup(-2127166334);
        ComposerKt.sourceInformation($composer2, "C(MaterialTheme)P(!1,2,3)52@2513L11,53@2561L6,54@2612L10,57@2691L32,58@2750L40,68@3250L81,60@2830L501:MaterialTheme.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            if ((i & 1) == 0) {
                colorScheme2 = colorScheme;
                int i2 = $composer2.changed(colorScheme2) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                colorScheme2 = colorScheme;
            }
            $dirty2 |= i2;
        } else {
            colorScheme2 = colorScheme;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                shapes2 = shapes;
                int i3 = $composer2.changed(shapes2) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                shapes2 = shapes;
            }
            $dirty2 |= i3;
        } else {
            shapes2 = shapes;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                typography2 = typography;
                int i4 = $composer2.changed(typography2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                typography2 = typography;
            }
            $dirty2 |= i4;
        } else {
            typography2 = typography;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shapes3 = shapes2;
            typography4 = typography2;
            colorScheme3 = colorScheme2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme($composer2, 6);
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes($composer2, 6);
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    typography3 = MaterialTheme.INSTANCE.getTypography($composer2, 6);
                } else {
                    $dirty = $dirty2;
                    typography3 = typography2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    typography3 = typography2;
                } else {
                    $dirty = $dirty2;
                    typography3 = typography2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2127166334, $dirty, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:56)");
            }
            Indication rippleIndication = RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7);
            SelectionColors selectionColors = rememberTextSelectionColors(colorScheme2, $composer2, $dirty & 14);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme2), IndicationKt.getLocalIndication().provides(rippleIndication), RippleThemeKt.getLocalRippleTheme().provides(CompatRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(selectionColors), TypographyKt.getLocalTypography().provides(typography3)}, ComposableLambdaKt.rememberComposableLambda(-1066563262, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C69@3260L65:MaterialTheme.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1066563262, $changed2, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:69)");
                    }
                    TextKt.ProvideTextStyle(typography3.getBodyLarge(), function2, $composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography4 = typography3;
            colorScheme3 = colorScheme2;
            shapes3 = shapes2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ColorScheme colorScheme4 = colorScheme3;
            final Shapes shapes4 = shapes3;
            final Typography typography5 = typography4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    MaterialThemeKt.MaterialTheme(colorScheme4, shapes4, typography5, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final SelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1866455512, "C(rememberTextSelectionColors)107@4322L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, $changed, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:105)");
        }
        long primaryColor = colorScheme.getPrimary();
        ComposerKt.sourceInformationMarkerStart($composer, -314518781, "CC(remember):MaterialTheme.kt#9igjgp");
        boolean invalid$iv = $composer.changed(primaryColor);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new SelectionColors(primaryColor, Color.m4289copywmQWz5c(primaryColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(primaryColor) : 0.4f, (14 & 2) != 0 ? Color.m4297getRedimpl(primaryColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(primaryColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(primaryColor) : 0.0f), null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        SelectionColors selectionColors = (SelectionColors) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return selectionColors;
    }
}
