package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.colorspace.ColorSpace;
import androidx.compose.p001ui.layout.AlignmentLineKt;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0082\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u008a\u0001\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001az\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b\u0018¢\u0006\u0002\b*H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a7\u0010-\u001a\u00020\u00122\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010.\u001a=\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0012*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rH\u0002\u001a\u001c\u0010?\u001a\u00020\u0012*\u0002052\u0006\u0010@\u001a\u0002092\u0006\u0010<\u001a\u00020\rH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u001eX\u008a\u0084\u0002"}, m195d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release", "color"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m3560getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = C1979Dp.m6801constructorimpl(72);
    private static final float HorizontalTextPadding = C1979Dp.m6801constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = C1979Dp.m6801constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = C1979Dp.m6801constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = C1979Dp.m6801constructorimpl(8);

    /* JADX INFO: renamed from: Tab-wqdebIU, reason: not valid java name */
    public static final void m2705TabwqdebIU(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        int $dirty;
        long selectedContentColor2;
        long unselectedContentColor2;
        MutableInteractionSource interactionSource2;
        int $dirty2;
        long selectedContentColor3;
        long unselectedContentColor3;
        Function2 it;
        Function2<? super Composer, ? super Integer, Unit> function6;
        long selectedContentColor4;
        MutableInteractionSource interactionSource3;
        Modifier modifier3;
        boolean enabled3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(-350627181);
        ComposerKt.sourceInformation($composer2, "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)98@4468L7,118@5087L65,110@4918L234:Tab.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            function4 = function2;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function4 = function2;
            $dirty4 |= $composer2.changedInstance(function4) ? 16384 : 8192;
        } else {
            function4 = function2;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function5 = function3;
        } else if ((196608 & $changed) == 0) {
            function5 = function3;
            $dirty4 |= $composer2.changedInstance(function5) ? 131072 : 65536;
        } else {
            function5 = function3;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                int i6 = $composer2.changed(selectedContentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i6;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i6;
        } else {
            $dirty = $dirty4;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(unselectedContentColor)) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            selectedContentColor4 = selectedContentColor;
            unselectedContentColor3 = unselectedContentColor;
            interactionSource3 = interactionSource;
            modifier3 = modifier2;
            function6 = function4;
            function7 = function5;
            enabled3 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    enabled2 = true;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if (i5 != 0) {
                    function5 = null;
                }
                if ((i & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    selectedContentColor2 = ((Color) objConsume).m4301unboximpl();
                    $dirty &= -3670017;
                } else {
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 128) != 0) {
                    unselectedContentColor2 = selectedContentColor2;
                    $dirty &= -29360129;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                }
                if (i7 != 0) {
                    interactionSource2 = null;
                    $dirty2 = $dirty;
                    selectedContentColor3 = selectedContentColor2;
                    unselectedContentColor3 = unselectedContentColor2;
                } else {
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    selectedContentColor3 = selectedContentColor2;
                    unselectedContentColor3 = unselectedContentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & (-29360129);
                    selectedContentColor3 = selectedContentColor;
                } else {
                    selectedContentColor3 = selectedContentColor;
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350627181, $dirty2, -1, "androidx.compose.material3.Tab (Tab.kt:101)");
            }
            $composer2.startReplaceGroup(1665134999);
            ComposerKt.sourceInformation($composer2, "*103@4675L232");
            if (function4 == null) {
                it = null;
            } else {
                Function2 it2 = ComposableLambdaKt.rememberComposableLambda(708874428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$styledText$1$1
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
                        ComposerKt.sourceInformation($composer3, "C105@4731L10,107@4858L39:Tab.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(708874428, $changed2, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:104)");
                            }
                            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont());
                            TextStyle style = textStyleFromToken.m6277copyp1EtxEg((16777213 & 1) != 0 ? textStyleFromToken.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyleFromToken.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyleFromToken.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyleFromToken.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyleFromToken.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyleFromToken.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyleFromToken.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyleFromToken.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyleFromToken.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyleFromToken.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyleFromToken.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyleFromToken.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyleFromToken.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyleFromToken.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyleFromToken.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyleFromToken.paragraphStyle.getTextAlign() : TextAlign.INSTANCE.m6658getCentere0LSkKk(), (16777213 & 65536) != 0 ? textStyleFromToken.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyleFromToken.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyleFromToken.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyleFromToken.platformStyle : null, (16777213 & 1048576) != 0 ? textStyleFromToken.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyleFromToken.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? textStyleFromToken.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyleFromToken.paragraphStyle.getTextMotion() : null);
                            TextKt.ProvideTextStyle(style, function4, $composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }, $composer2, 54);
                it = it2;
            }
            $composer2.endReplaceGroup();
            final Function2 styledText = it;
            m2704TabbogVsAg(selected, function0, modifier2, enabled2, selectedContentColor3, unselectedContentColor3, interactionSource2, ComposableLambdaKt.rememberComposableLambda(1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope $this$Tab, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C119@5097L49:Tab.kt#uh7d8r");
                    if (($changed2 & 17) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1540996038, $changed2, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:119)");
                        }
                        TabKt.TabBaselineLayout(styledText, function5, $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty2 & 14) | 12582912 | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752) | (3670016 & ($dirty2 >> 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function4;
            selectedContentColor4 = selectedContentColor3;
            interactionSource3 = interactionSource2;
            modifier3 = modifier2;
            enabled3 = enabled2;
            function7 = function5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z = enabled3;
            final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
            final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
            final long j = selectedContentColor4;
            final long j2 = unselectedContentColor3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$2
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

                public final void invoke(Composer composer, int i8) {
                    TabKt.m2705TabwqdebIU(selected, function0, modifier4, z, function8, function9, j, j2, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    public static final void m2703LeadingIconTabwqdebIU(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        long selectedContentColor2;
        int $dirty;
        long unselectedContentColor2;
        MutableInteractionSource interactionSource2;
        long unselectedContentColor3;
        Modifier modifier3;
        boolean enabled3;
        int $dirty2;
        long selectedContentColor3;
        Modifier modifier4;
        long unselectedContentColor4;
        MutableInteractionSource interactionSource3;
        long selectedContentColor4;
        boolean enabled4;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(-777316544);
        ComposerKt.sourceInformation($composer2, "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)161@6978L7,168@7341L76,170@7493L921,170@7423L991:Tab.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty4 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty4 |= CpioConstants.C_ISBLK;
            modifier2 = modifier;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            enabled2 = enabled;
        } else if ((196608 & $changed) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer2.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                selectedContentColor2 = selectedContentColor;
                int i4 = $composer2.changed(selectedContentColor2) ? 1048576 : 524288;
                $dirty4 |= i4;
            } else {
                selectedContentColor2 = selectedContentColor;
            }
            $dirty4 |= i4;
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((12582912 & $changed) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                int i5 = $composer2.changed(unselectedContentColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i5;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i5;
        } else {
            $dirty = $dirty4;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            unselectedContentColor4 = unselectedContentColor;
            interactionSource3 = interactionSource;
            modifier4 = modifier2;
            selectedContentColor4 = selectedContentColor2;
            enabled4 = enabled2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -3670017;
                    selectedContentColor2 = ((Color) objConsume).m4301unboximpl();
                }
                if ((i & 128) != 0) {
                    unselectedContentColor2 = selectedContentColor2;
                    $dirty &= -29360129;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                }
                if (i6 != 0) {
                    interactionSource2 = null;
                    unselectedContentColor3 = unselectedContentColor2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty2 = $dirty;
                    selectedContentColor3 = selectedContentColor2;
                } else {
                    interactionSource2 = interactionSource;
                    unselectedContentColor3 = unselectedContentColor2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty2 = $dirty;
                    selectedContentColor3 = selectedContentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & (-29360129);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                } else {
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty2 = $dirty;
                    selectedContentColor3 = selectedContentColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777316544, $dirty2, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
            }
            final Indication ripple = RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, selectedContentColor3, $composer2, (($dirty2 >> 12) & 896) | 6, 2);
            final Modifier modifier5 = modifier3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            modifier4 = modifier3;
            final boolean z = enabled3;
            int $dirty5 = $dirty2;
            m2706TabTransitionKlgxPg(selectedContentColor3, unselectedContentColor3, selected, ComposableLambdaKt.rememberComposableLambda(-429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$1
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
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C171@7503L905:Tab.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-429037564, $changed2, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:171)");
                        }
                        Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.m870paddingVpY3zN4$default(SelectableKt.m1114selectableO2vRcR0(SizeKt.m899height3ABfNKs(modifier5, TabKt.SmallTabHeight), selected, mutableInteractionSource, ripple, z, Role.m6055boximpl(Role.INSTANCE.m6068getTabo7Vup1c()), function0), TabKt.getHorizontalTextPadding(), 0.0f, 2, null), 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function4 = function3;
                        Function2<Composer, Integer, Unit> function5 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function1 = constructor;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i8 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 757417340, "C187@8115L6,188@8134L59,189@8232L10,191@8359L39:Tab.kt#uh7d8r");
                        function4.invoke($composer3, 0);
                        SpacerKt.Spacer(SizeKt.m910requiredWidth3ABfNKs(Modifier.INSTANCE, TabKt.TextDistanceFromLeadingIcon), $composer3, 6);
                        TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont());
                        TextStyle style = textStyleFromToken.m6277copyp1EtxEg((16777213 & 1) != 0 ? textStyleFromToken.spanStyle.m6199getColor0d7_KjU() : 0L, (16777213 & 2) != 0 ? textStyleFromToken.spanStyle.getFontSize() : 0L, (16777213 & 4) != 0 ? textStyleFromToken.spanStyle.getFontWeight() : null, (16777213 & 8) != 0 ? textStyleFromToken.spanStyle.getFontStyle() : null, (16777213 & 16) != 0 ? textStyleFromToken.spanStyle.getFontSynthesis() : null, (16777213 & 32) != 0 ? textStyleFromToken.spanStyle.getFontFamily() : null, (16777213 & 64) != 0 ? textStyleFromToken.spanStyle.getFontFeatureSettings() : null, (16777213 & 128) != 0 ? textStyleFromToken.spanStyle.getLetterSpacing() : 0L, (16777213 & 256) != 0 ? textStyleFromToken.spanStyle.getBaselineShift() : null, (16777213 & 512) != 0 ? textStyleFromToken.spanStyle.getTextGeometricTransform() : null, (16777213 & 1024) != 0 ? textStyleFromToken.spanStyle.getLocaleList() : null, (16777213 & 2048) != 0 ? textStyleFromToken.spanStyle.getBackground() : 0L, (16777213 & 4096) != 0 ? textStyleFromToken.spanStyle.getTextDecoration() : null, (16777213 & 8192) != 0 ? textStyleFromToken.spanStyle.getShadow() : null, (16777213 & 16384) != 0 ? textStyleFromToken.spanStyle.getDrawStyle() : null, (16777213 & 32768) != 0 ? textStyleFromToken.paragraphStyle.getTextAlign() : TextAlign.INSTANCE.m6658getCentere0LSkKk(), (16777213 & 65536) != 0 ? textStyleFromToken.paragraphStyle.getTextDirection() : 0, (16777213 & 131072) != 0 ? textStyleFromToken.paragraphStyle.getLineHeight() : 0L, (16777213 & 262144) != 0 ? textStyleFromToken.paragraphStyle.getTextIndent() : null, (16777213 & 524288) != 0 ? textStyleFromToken.platformStyle : null, (16777213 & 1048576) != 0 ? textStyleFromToken.paragraphStyle.getLineHeightStyle() : null, (16777213 & 2097152) != 0 ? textStyleFromToken.paragraphStyle.getLineBreak() : 0, (16777213 & 4194304) != 0 ? textStyleFromToken.paragraphStyle.getHyphens() : 0, (16777213 & 8388608) != 0 ? textStyleFromToken.paragraphStyle.getTextMotion() : null);
                        TextKt.ProvideTextStyle(style, function5, $composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty5 >> 18) & 14) | 3072 | (($dirty5 >> 18) & 112) | (($dirty5 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            unselectedContentColor4 = unselectedContentColor3;
            interactionSource3 = interactionSource2;
            selectedContentColor4 = selectedContentColor3;
            enabled4 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z2 = enabled4;
            final long j = selectedContentColor4;
            final long j2 = unselectedContentColor4;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$2
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

                public final void invoke(Composer composer, int i7) {
                    TabKt.m2703LeadingIconTabwqdebIU(selected, function0, function2, function3, modifier6, z2, j, j2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Tab-bogVsAg, reason: not valid java name */
    public static final void m2704TabbogVsAg(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean enabled2;
        long selectedContentColor2;
        long unselectedContentColor2;
        Modifier modifier2;
        MutableInteractionSource interactionSource2;
        boolean enabled3;
        long selectedContentColor3;
        long unselectedContentColor3;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-202735880);
        ComposerKt.sourceInformation($composer2, "C(Tab)P(5,4,3,1,6:c#ui.graphics.Color,7:c#ui.graphics.Color,2)232@10201L7,240@10610L76,242@10762L548,242@10692L618:Tab.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                selectedContentColor2 = selectedContentColor;
                int i4 = $composer2.changed(selectedContentColor2) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                selectedContentColor2 = selectedContentColor;
            }
            $dirty |= i4;
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                unselectedContentColor2 = unselectedContentColor;
                int i5 = $composer2.changed(unselectedContentColor2) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                unselectedContentColor2 = unselectedContentColor;
            }
            $dirty |= i5;
        } else {
            unselectedContentColor2 = unselectedContentColor;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if (($dirty & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            interactionSource2 = interactionSource;
            enabled3 = enabled2;
            selectedContentColor3 = selectedContentColor2;
            unselectedContentColor3 = unselectedContentColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -57345;
                    selectedContentColor2 = ((Color) objConsume).m4301unboximpl();
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    unselectedContentColor2 = selectedContentColor2;
                }
                if (i6 != 0) {
                    interactionSource2 = null;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    unselectedContentColor3 = unselectedContentColor2;
                    modifier2 = modifier4;
                } else {
                    modifier2 = modifier4;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    unselectedContentColor3 = unselectedContentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    interactionSource2 = interactionSource;
                    $dirty &= -458753;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    unselectedContentColor3 = unselectedContentColor2;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    unselectedContentColor3 = unselectedContentColor2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202735880, $dirty, -1, "androidx.compose.material3.Tab (Tab.kt:236)");
            }
            final Indication ripple = RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(true, 0.0f, selectedContentColor3, $composer2, (($dirty >> 6) & 896) | 6, 2);
            final Modifier modifier5 = modifier2;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z = enabled3;
            m2706TabTransitionKlgxPg(selectedContentColor3, unselectedContentColor3, selected, ComposableLambdaKt.rememberComposableLambda(-551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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
                    ComposerKt.sourceInformation($composer3, "C243@10772L532:Tab.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-551896140, $changed2, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:243)");
                        }
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1114selectableO2vRcR0(modifier5, selected, mutableInteractionSource, ripple, z, Role.m6055boximpl(Role.INSTANCE.m6068getTabo7Vup1c()), function0), 0.0f, 1, null);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Function3<ColumnScope, Composer, Integer, Unit> function4 = function3;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(center, centerHorizontally, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxWidth$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
                        function4.invoke(ColumnScopeInstance.INSTANCE, $composer3, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 12) & 14) | 3072 | (($dirty >> 12) & 112) | (($dirty << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = enabled3;
            final long j = selectedContentColor3;
            final long j2 = unselectedContentColor3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$4
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

                public final void invoke(Composer composer, int i7) {
                    TabKt.m2704TabbogVsAg(selected, function0, modifier6, z2, j, j2, mutableInteractionSource2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m2706TabTransitionKlgxPg(final long activeColor, final long inactiveColor, final boolean selected, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        long j;
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(735731848);
        ComposerKt.sourceInformation($composer2, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)273@11741L26,274@11796L550,292@12351L99:Tab.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(activeColor) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            j = inactiveColor;
            $dirty |= $composer2.changed(j) ? 32 : 16;
        } else {
            j = inactiveColor;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(selected) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, $dirty, -1, "androidx.compose.material3.TabTransition (Tab.kt:272)");
            }
            Transition transition = TransitionKt.updateTransition(Boolean.valueOf(selected), (String) null, $composer2, ($dirty >> 6) & 14, 2);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer $composer3, int $changed2) {
                    TweenSpec tweenSpecTween$default;
                    $composer3.startReplaceGroup(-899623535);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-899623535, $changed2, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:276)");
                    }
                    if (segment.isTransitioningTo(false, true)) {
                        tweenSpecTween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
                    } else {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecTween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            int $changed2 = (0 >> 6) & 112;
            boolean it = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, $changed2, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:290)");
            }
            long j2 = it ? activeColor : j;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            ColorSpace colorSpace$iv = Color.m4295getColorSpaceimpl(j2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(colorSpace$iv);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            TwoWayConverter typeConverter$iv = (TwoWayConverter) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv = (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) transition.getCurrentState()).booleanValue();
            $composer2.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, $changed3, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:290)");
            }
            long j3 = it2 ? activeColor : j;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv = Color.m4281boximpl(j3);
            int $changed4 = ($changed$iv$iv >> 9) & 112;
            boolean it3 = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, $changed4, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:290)");
            }
            long j4 = it3 ? activeColor : j;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv = Color.m4281boximpl(j4);
            State color$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), typeConverter$iv, "ColorAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(TabTransition_Klgx_Pg$lambda$2(color$delegate))), function2, $composer2, ProvidedValue.$stable | (($dirty >> 6) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabTransition$1
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

                public final void invoke(Composer composer, int i) {
                    TabKt.m2706TabTransitionKlgxPg(activeColor, inactiveColor, selected, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Object value$iv;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function4;
        Composer $composer2 = $composer.startRestartGroup(514131524);
        ComposerKt.sourceInformation($composer2, "C(TabBaselineLayout)P(1)321@13232L1785,308@12858L2159:Tab.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, $dirty, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:307)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 150513295, "CC(remember):Tab.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$1
                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(final MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        Placeable placeableMo5644measureBRTryo0;
                        Placeable iconPlaceable;
                        Function2<Composer, Integer, Unit> function5 = function2;
                        if (function5 == null) {
                            placeableMo5644measureBRTryo0 = null;
                        } else {
                            int index$iv$iv = 0;
                            int size = list.size();
                            while (true) {
                                if (index$iv$iv < size) {
                                    Object item$iv$iv = list.get(index$iv$iv);
                                    Measurable it = (Measurable) item$iv$iv;
                                    Function2<Composer, Integer, Unit> function6 = function5;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "text")) {
                                        placeableMo5644measureBRTryo0 = ((Measurable) item$iv$iv).mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
                                        break;
                                    }
                                    index$iv$iv++;
                                    function5 = function6;
                                } else {
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                            }
                        }
                        final Placeable textPlaceable = placeableMo5644measureBRTryo0;
                        Function2<Composer, Integer, Unit> function7 = function3;
                        if (function7 == null) {
                            iconPlaceable = null;
                        } else {
                            int index$iv$iv2 = 0;
                            int size2 = list.size();
                            while (true) {
                                if (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = list.get(index$iv$iv2);
                                    Measurable it2 = (Measurable) item$iv$iv2;
                                    Function2<Composer, Integer, Unit> function8 = function7;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "icon")) {
                                        iconPlaceable = ((Measurable) item$iv$iv2).mo5644measureBRTryo0(constraints);
                                        break;
                                    }
                                    index$iv$iv2++;
                                    function7 = function8;
                                } else {
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                            }
                        }
                        final int tabWidth = Math.max(textPlaceable != null ? textPlaceable.getWidth() : 0, iconPlaceable != null ? iconPlaceable.getWidth() : 0);
                        int specHeight = $this$Layout.mo561roundToPx0680j_4((textPlaceable == null || iconPlaceable == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight);
                        final int tabHeight = Math.max(specHeight, (iconPlaceable != null ? iconPlaceable.getHeight() : 0) + (textPlaceable != null ? textPlaceable.getHeight() : 0) + $this$Layout.mo560roundToPxR2X_6o(TabKt.IconDistanceFromBaseline));
                        final Integer firstBaseline = textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getFirstBaseline())) : null;
                        final Integer lastBaseline = textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getLastBaseline())) : null;
                        final Placeable placeable = iconPlaceable;
                        return MeasureScope.CC.layout$default($this$Layout, tabWidth, tabHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                if (textPlaceable != null && placeable != null) {
                                    MeasureScope measureScope = $this$Layout;
                                    Placeable placeable2 = textPlaceable;
                                    Placeable placeable3 = placeable;
                                    int i = tabWidth;
                                    int i2 = tabHeight;
                                    Integer num = firstBaseline;
                                    Intrinsics.checkNotNull(num);
                                    int iIntValue = num.intValue();
                                    Integer num2 = lastBaseline;
                                    Intrinsics.checkNotNull(num2);
                                    TabKt.placeTextAndIcon($this$layout, measureScope, placeable2, placeable3, i, i2, iIntValue, num2.intValue());
                                    return;
                                }
                                if (textPlaceable != null) {
                                    TabKt.placeTextOrIcon($this$layout, textPlaceable, tabHeight);
                                } else if (placeable != null) {
                                    TabKt.placeTextOrIcon($this$layout, placeable, tabHeight);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 720851160, "C:Tab.kt#uh7d8r");
            $composer2.startReplaceGroup(720851160);
            ComposerKt.sourceInformation($composer2, "311@12924L173");
            if (function2 != null) {
                Modifier modifier$iv2 = PaddingKt.m870paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), HorizontalTextPadding, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function4 = constructor2;
                    $composer2.createNode(function4);
                } else {
                    function4 = constructor2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i3 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -978021438, "C315@13089L6:Tab.kt#uh7d8r");
                function2.invoke($composer2, Integer.valueOf($dirty & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(150513187);
            ComposerKt.sourceInformation($composer2, "318@13160L41");
            if (function3 != null) {
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function1 = constructor3;
                    $composer2.createNode(function1);
                } else {
                    function1 = constructor3;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer2);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -978021334, "C318@13193L6:Tab.kt#uh7d8r");
                function3.invoke($composer2, Integer.valueOf(($dirty >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt.TabBaselineLayout.3
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

                public final void invoke(Composer composer, int i6) {
                    TabKt.TabBaselineLayout(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope $this$placeTextOrIcon, Placeable textOrIconPlaceable, int tabHeight) {
        int contentY = (tabHeight - textOrIconPlaceable.getHeight()) / 2;
        Placeable.PlacementScope.placeRelative$default($this$placeTextOrIcon, textOrIconPlaceable, 0, contentY, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope $this$placeTextAndIcon, Density density, Placeable textPlaceable, Placeable iconPlaceable, int tabWidth, int tabHeight, int firstBaseline, int lastBaseline) {
        float baselineOffset;
        if (firstBaseline == lastBaseline) {
            baselineOffset = SingleLineTextBaselineWithIcon;
        } else {
            baselineOffset = DoubleLineTextBaselineWithIcon;
        }
        int textOffset = density.mo561roundToPx0680j_4(baselineOffset) + density.mo561roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m3558getActiveIndicatorHeightD9Ej5fM());
        int iconOffset = (iconPlaceable.getHeight() + density.mo560roundToPxR2X_6o(IconDistanceFromBaseline)) - firstBaseline;
        int textPlaceableX = (tabWidth - textPlaceable.getWidth()) / 2;
        int textPlaceableY = (tabHeight - lastBaseline) - textOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, textPlaceableX, textPlaceableY, 0.0f, 4, null);
        int iconPlaceableX = (tabWidth - iconPlaceable.getWidth()) / 2;
        int iconPlaceableY = textPlaceableY - iconOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, iconPlaceableX, iconPlaceableY, 0.0f, 4, null);
    }

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }
}
