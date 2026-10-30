package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: ExpressiveNavigationBar.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009d\u0001\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u001e0\"¢\u0006\u0002\b$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020 2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"¢\u0006\u0002\b$2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"¢\u0006\u0002\b$2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000e\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0010\"\u0016\u0010\u0013\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0010\"\u0016\u0010\u0015\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0010\"\u0016\u0010\u0017\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0010\"\u0016\u0010\u0019\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0010\"\u0010\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, m195d2 = {"ActiveIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIndicatorColor", "ActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveLabelTextColor", "HorizontalItemActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "F", "IconSize", "InactiveIconColor", "InactiveLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "()F", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "StartIconToLabelPadding", "getStartIconToLabelPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "VerticalItemActiveIndicatorHeight", "VerticalItemActiveIndicatorWidth", "ExpressiveNavigationBarItem", "", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "label", "badge", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ExpressiveNavigationBarItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExpressiveNavigationBarKt {
    private static final float StartIconIndicatorHorizontalPadding;
    private static final float StartIconIndicatorVerticalPadding;
    private static final float StartIconToLabelPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorToLabelPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final float IconSize = C1979Dp.m6801constructorimpl((float) 24.0d);
    private static final float VerticalItemActiveIndicatorWidth = C1979Dp.m6801constructorimpl(56);
    private static final float VerticalItemActiveIndicatorHeight = C1979Dp.m6801constructorimpl(32);
    private static final float HorizontalItemActiveIndicatorHeight = C1979Dp.m6801constructorimpl(40);
    private static final TypographyKeyTokens LabelTextFont = TypographyKeyTokens.LabelMedium;
    private static final ShapeKeyTokens ActiveIndicatorShape = ShapeKeyTokens.CornerFull;
    private static final ColorSchemeKeyTokens ActiveIconColor = ColorSchemeKeyTokens.Secondary;
    private static final ColorSchemeKeyTokens ActiveLabelTextColor = ColorSchemeKeyTokens.Secondary;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
    private static final ColorSchemeKeyTokens InactiveIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final ColorSchemeKeyTokens InactiveLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;

    /* JADX INFO: renamed from: ExpressiveNavigationBarItem-pli-t6k, reason: not valid java name */
    public static final void m2238ExpressiveNavigationBarItemplit6k(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, int iconPosition, NavigationItemColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier.Companion modifier2;
        boolean enabled2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int iconPosition2;
        NavigationItemColors colors2;
        MutableInteractionSource interactionSource2;
        int $dirty;
        NavigationItemColors colors3;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource interactionSource4;
        MutableInteractionSource interactionSource5;
        int iconPosition3;
        NavigationItemColors colors4;
        Modifier modifier3;
        boolean enabled3;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1250474866);
        ComposerKt.sourceInformation($composer2, "C(ExpressiveNavigationBarItem)P(9,8,3,7,2,6!1,4:c#material3.NavigationItemIconPosition)77@3726L8,99@4459L10,100@4542L5,95@4327L766:ExpressiveNavigationBar.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 16384 : 8192;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 1572864;
            function5 = function4;
        } else if ((1572864 & $changed) == 0) {
            function5 = function4;
            $dirty2 |= $composer2.changedInstance(function5) ? 1048576 : 524288;
        } else {
            function5 = function4;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(iconPosition) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= ((i & 256) == 0 && $composer2.changed(colors)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i7 = i & 512;
        if (i7 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function8 = function3;
            iconPosition3 = iconPosition;
            colors4 = colors;
            interactionSource5 = interactionSource;
            function9 = function5;
            enabled3 = enabled;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                function6 = i4 != 0 ? null : function3;
                function7 = i5 != 0 ? null : function5;
                iconPosition2 = i6 != 0 ? NavigationItemIconPosition.INSTANCE.m2432getTopxw1Ddg() : iconPosition;
                if ((i & 256) != 0) {
                    colors2 = ExpressiveNavigationBarItemDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 &= -234881025;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    $dirty = $dirty2;
                    colors3 = colors2;
                } else {
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                modifier2 = modifier;
                enabled2 = enabled;
                function6 = function3;
                iconPosition2 = iconPosition;
                interactionSource2 = interactionSource;
                function7 = function5;
                $dirty = $dirty2;
                colors3 = colors;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1250474866, $dirty, -1, "androidx.compose.material3.ExpressiveNavigationBarItem (ExpressiveNavigationBar.kt:79)");
            }
            $composer2.startReplaceGroup(-863112918);
            ComposerKt.sourceInformation($composer2, "81@3878L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -863112897, "CC(remember):ExpressiveNavigationBar.kt#9igjgp");
                interactionSource3 = interactionSource2;
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                interactionSource4 = (MutableInteractionSource) value$iv;
            } else {
                interactionSource3 = interactionSource2;
                interactionSource4 = interactionSource3;
            }
            $composer2.endReplaceGroup();
            boolean isIconPositionTop = NavigationItemIconPosition.m2427equalsimpl0(iconPosition2, NavigationItemIconPosition.INSTANCE.m2432getTopxw1Ddg());
            float indicatorHorizontalPadding = isIconPositionTop ? TopIconIndicatorHorizontalPadding : StartIconIndicatorHorizontalPadding;
            float indicatorVerticalPadding = isIconPositionTop ? TopIconIndicatorVerticalPadding : StartIconIndicatorVerticalPadding;
            NavigationItemKt.m2433NavigationItembik9Nc4(selected, function0, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), LabelTextFont), ShapesKt.getValue(ActiveIndicatorShape, $composer2, 6), VerticalItemActiveIndicatorWidth, indicatorHorizontalPadding, indicatorVerticalPadding, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, colors3, modifier2, enabled2, function6, function7, iconPosition2, interactionSource4, $composer2, ($dirty & 14) | 906166272 | ($dirty & 112) | ($dirty & 896), (($dirty >> 24) & 14) | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource5 = interactionSource3;
            iconPosition3 = iconPosition2;
            colors4 = colors3;
            modifier3 = modifier2;
            enabled3 = enabled2;
            function8 = function6;
            function9 = function7;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z = enabled3;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function8;
            final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
            final int i8 = iconPosition3;
            final NavigationItemColors navigationItemColors = colors4;
            final MutableInteractionSource mutableInteractionSource = interactionSource5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExpressiveNavigationBarKt$ExpressiveNavigationBarItem$1
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

                public final void invoke(Composer composer, int i9) {
                    ExpressiveNavigationBarKt.m2238ExpressiveNavigationBarItemplit6k(selected, function0, function2, modifier4, z, function10, function11, i8, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    static {
        float arg0$iv = VerticalItemActiveIndicatorHeight;
        float other$iv = IconSize;
        TopIconIndicatorVerticalPadding = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv - other$iv) / 2);
        float arg0$iv2 = VerticalItemActiveIndicatorWidth;
        float other$iv2 = IconSize;
        TopIconIndicatorHorizontalPadding = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv2 - other$iv2) / 2);
        float arg0$iv3 = HorizontalItemActiveIndicatorHeight;
        float other$iv3 = IconSize;
        StartIconIndicatorVerticalPadding = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv3 - other$iv3) / 2);
        TopIconIndicatorToLabelPadding = C1979Dp.m6801constructorimpl(4);
        StartIconIndicatorHorizontalPadding = C1979Dp.m6801constructorimpl(16);
        StartIconToLabelPadding = C1979Dp.m6801constructorimpl(4);
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }
}
