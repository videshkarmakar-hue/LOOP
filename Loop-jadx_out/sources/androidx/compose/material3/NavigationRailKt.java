package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ClipKt;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p001ui.graphics.GraphicsLayerScope;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.Density;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001az\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0081\u0001\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104\u001aq\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090+H\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aP\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001bX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020\u001bX\u008a\u0084\u0002"}, m195d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", NavigationRailKt.IconLayoutIdTag, "enabled", NavigationRailKt.LabelLayoutIdTag, "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailVerticalPadding = C1979Dp.m6801constructorimpl(4);
    private static final float NavigationRailHeaderPadding = C1979Dp.m6801constructorimpl(8);
    private static final float NavigationRailItemWidth = NavigationRailTokens.INSTANCE.m3432getContainerWidthD9Ej5fM();
    private static final float NavigationRailItemHeight = NavigationRailTokens.INSTANCE.m3435getNoLabelActiveIndicatorHeightD9Ej5fM();
    private static final float NavigationRailItemVerticalPadding = C1979Dp.m6801constructorimpl(4);

    /* JADX INFO: renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    public static final void m2457NavigationRailqi6gXK8(Modifier modifier, long containerColor, long contentColor, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5;
        WindowInsets windowInsets2;
        Modifier.Companion modifier3;
        long containerColor2;
        long contentColor2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6;
        final WindowInsets windowInsets3;
        Modifier modifier4;
        long containerColor3;
        long contentColor3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function7;
        WindowInsets windowInsets4;
        Composer $composer2 = $composer.startRestartGroup(118552648);
        ComposerKt.sourceInformation($composer2, "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)110@5227L14,111@5269L31,113@5416L12,120@5599L635,116@5486L748:NavigationRail.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                j = containerColor;
                int i3 = $composer2.changed(j) ? 32 : 16;
                $dirty |= i3;
            } else {
                j = containerColor;
            }
            $dirty |= i3;
        } else {
            j = containerColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j2 = contentColor;
                int i4 = $composer2.changed(j2) ? 256 : 128;
                $dirty |= i4;
            } else {
                j2 = contentColor;
            }
            $dirty |= i4;
        } else {
            j2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            function5 = function3;
        } else if (($changed & 3072) == 0) {
            function5 = function3;
            $dirty |= $composer2.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer2.changed(windowInsets2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            containerColor3 = j;
            contentColor3 = j2;
            function7 = function5;
            windowInsets4 = windowInsets2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    containerColor2 = NavigationRailDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    containerColor2 = j;
                }
                if ((i & 4) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty >> 3) & 14);
                    $dirty &= -897;
                } else {
                    contentColor2 = j2;
                }
                function6 = i5 != 0 ? null : function5;
                if ((i & 16) != 0) {
                    windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets($composer2, 6);
                    $dirty &= -57345;
                } else {
                    windowInsets3 = windowInsets2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier3 = modifier2;
                containerColor2 = j;
                contentColor2 = j2;
                function6 = function5;
                windowInsets3 = windowInsets2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(118552648, $dirty, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:115)");
            }
            SurfaceKt.m2666SurfaceT9BRK9s(modifier3, null, containerColor2, contentColor2, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-2092683357, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$1
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
                    ComposerKt.sourceInformation($composer3, "C121@5609L619:NavigationRail.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2092683357, $changed2, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:121)");
                        }
                        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m870paddingVpY3zN4$default(SizeKt.m920widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets3), NavigationRailTokens.INSTANCE.m3432getContainerWidthD9Ej5fM(), 0.0f, 2, null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM744spacedBy0680j_4 = Arrangement.INSTANCE.m744spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
                        Function3<ColumnScope, Composer, Integer, Unit> function8 = function6;
                        Function3<ColumnScope, Composer, Integer, Unit> function9 = function4;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM744spacedBy0680j_4, centerHorizontally, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierSelectableGroup);
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
                        int $changed3 = ((432 >> 6) & 112) | 6;
                        ColumnScope $this$invoke_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, 716054060, "C135@6209L9:NavigationRail.kt#uh7d8r");
                        $composer3.startReplaceGroup(716054060);
                        ComposerKt.sourceInformation($composer3, "132@6105L8,133@6130L52");
                        if (function8 != null) {
                            function8.invoke($this$invoke_u24lambda_u240, $composer3, Integer.valueOf($changed3 & 14));
                            SpacerKt.Spacer(SizeKt.m899height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.NavigationRailHeaderPadding), $composer3, 6);
                        }
                        $composer3.endReplaceGroup();
                        function9.invoke($this$invoke_u24lambda_u240, $composer3, Integer.valueOf($changed3 & 14));
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
            }, $composer2, 54), $composer2, ($dirty & 14) | 12582912 | (($dirty << 3) & 896) | (($dirty << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            function7 = function6;
            windowInsets4 = windowInsets3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final long j3 = containerColor3;
            final long j4 = contentColor3;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function8 = function7;
            final WindowInsets windowInsets5 = windowInsets4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$2
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
                    NavigationRailKt.m2457NavigationRailqi6gXK8(modifier5, j3, j4, function8, windowInsets5, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void NavigationRailItem(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function3, boolean alwaysShowLabel, NavigationRailItemColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        final boolean enabled2;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        Modifier.Companion modifier2;
        boolean alwaysShowLabel2;
        final NavigationRailItemColors colors2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource mutableInteractionSource;
        boolean alwaysShowLabel3;
        Function0<ComposeUiNode> function1;
        Object value$iv;
        final Shape indicatorShape;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Object value$iv2;
        Modifier modifier3;
        boolean enabled3;
        NavigationRailItemColors colors3;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(-1533971045);
        ComposerKt.sourceInformation($composer2, "C(NavigationRailItem)P(8,7,3,6,2,5)177@8043L8,182@8268L565,209@9419L2744:NavigationRail.kt#uh7d8r");
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
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(modifier) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            enabled2 = enabled;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            enabled2 = enabled;
            $dirty |= $composer2.changed(enabled2) ? 16384 : 8192;
        } else {
            enabled2 = enabled;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function4 = function3;
        } else if ((196608 & $changed) == 0) {
            function4 = function3;
            $dirty |= $composer2.changedInstance(function4) ? 131072 : 65536;
        } else {
            function4 = function3;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(alwaysShowLabel) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(colors)) ? 8388608 : 4194304;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            alwaysShowLabel3 = alwaysShowLabel;
            colors3 = colors;
            interactionSource3 = interactionSource;
            enabled3 = enabled2;
            function5 = function4;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                alwaysShowLabel2 = i5 != 0 ? true : alwaysShowLabel;
                if ((i & 128) != 0) {
                    colors2 = NavigationRailItemDefaults.INSTANCE.colors($composer2, 6);
                    $dirty &= -29360129;
                } else {
                    colors2 = colors;
                }
                interactionSource2 = i6 != 0 ? null : interactionSource;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                modifier2 = modifier;
                alwaysShowLabel2 = alwaysShowLabel;
                colors2 = colors;
                interactionSource2 = interactionSource;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533971045, $dirty, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:179)");
            }
            $composer2.startReplaceGroup(-1687813038);
            ComposerKt.sourceInformation($composer2, "181@8195L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1687813017, "CC(remember):NavigationRail.kt#9igjgp");
                interactionSource3 = interactionSource2;
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource3 = interactionSource2;
                mutableInteractionSource = interactionSource3;
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource4 = mutableInteractionSource;
            final NavigationRailItemColors navigationRailItemColors = colors2;
            final boolean z = enabled2;
            final Function2<? super Composer, ? super Integer, Unit> function6 = function4;
            final boolean z2 = alwaysShowLabel2;
            Function2 styledIcon = ComposableLambdaKt.rememberComposableLambda(-1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
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

                private static final long invoke$lambda$0(State<Color> state) {
                    Object thisObj$iv = state.getValue();
                    return ((Color) thisObj$iv).m4301unboximpl();
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function7;
                    ComposerKt.sourceInformation($composer3, "C183@8295L177,189@8642L185:NavigationRail.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1023357515, $changed2, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:183)");
                        }
                        State<Color> stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(navigationRailItemColors.m2453iconColorWaAFU9c$material3_release(selected, z), AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer3, 48, 12);
                        boolean clearSemantics = function6 != null && (z2 || selected);
                        Modifier.Companion modifier$iv = Modifier.INSTANCE;
                        if (clearSemantics) {
                            modifier$iv = SemanticsModifierKt.clearAndSetSemantics(modifier$iv, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                                }
                            });
                        }
                        Function2<Composer, Integer, Unit> function8 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (0 << 3) & 112;
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
                            function7 = constructor;
                            $composer3.createNode(function7);
                        } else {
                            function7 = constructor;
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i8 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 540472649, "C190@8739L78:NavigationRail.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(invoke$lambda$0(stateM351animateColorAsStateeuL9pac))), function8, $composer3, ProvidedValue.$stable);
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
            }, $composer2, 54);
            $composer2.startReplaceGroup(-1687812321);
            ComposerKt.sourceInformation($composer2, "*195@8917L490");
            Function2 styledLabel = function4 == null ? null : ComposableLambdaKt.rememberComposableLambda(-105269599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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
                    ComposerKt.sourceInformation($composer3, "C196@8957L10,197@9043L189,201@9245L152:NavigationRail.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-105269599, $changed2, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:196)");
                        }
                        TextStyle style = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), NavigationRailTokens.INSTANCE.getLabelTextFont());
                        ProvideContentColorTextStyleKt.m3015ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(SingleValueAnimationKt.m351animateColorAsStateeuL9pac(colors2.m2454textColorWaAFU9c$material3_release(selected, enabled2), AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer3, 48, 12)), style, function4, $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }

                private static final long invoke$lambda$0(State<Color> state) {
                    Object thisObj$iv = state.getValue();
                    return ((Color) thisObj$iv).m4301unboximpl();
                }
            }, $composer2, 54);
            $composer2.endReplaceGroup();
            Modifier modifier4 = modifier2;
            Modifier modifier$iv = SizeKt.m920widthInVpY3zN4$default(SizeKt.m898defaultMinSizeVpY3zN4$default(SelectableKt.m1114selectableO2vRcR0(modifier2, selected, interactionSource4, null, enabled2, Role.m6055boximpl(Role.INSTANCE.m6068getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            boolean enabled4 = enabled2;
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            alwaysShowLabel3 = alwaysShowLabel2;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor;
                $composer2.createNode(function1);
            } else {
                function1 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1104516943, "C224@9968L145,*233@10397L7,238@10688L120,250@11216L258,258@11511L347,276@12119L27,270@11868L289:NavigationRail.kt#uh7d8r");
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(selected ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, $composer2, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$NavigationRailItem_u24lambda_u245_u24lambda_u242 = (Density) objConsume;
            int itemWidth = $this$NavigationRailItem_u24lambda_u245_u24lambda_u242.mo561roundToPx0680j_4(NavigationRailItemWidth);
            int indicatorWidth = $this$NavigationRailItem_u24lambda_u245_u24lambda_u242.mo561roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3430getActiveIndicatorWidthD9Ej5fM());
            long deltaOffset = OffsetKt.Offset((itemWidth - indicatorWidth) / 2, 0.0f);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1104517701, "CC(remember):NavigationRail.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(interactionSource4) | $composer2.changed(deltaOffset);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv = new MappedInteractionSource(interactionSource4, deltaOffset, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv2;
            }
            final MappedInteractionSource offsetInteractionSource = (MappedInteractionSource) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (function4 != null) {
                $composer2.startReplaceGroup(1104517927);
                ComposerKt.sourceInformation($composer2, "243@10914L5");
                indicatorShape = ShapesKt.getValue(NavigationRailTokens.INSTANCE.getActiveIndicatorShape(), $composer2, 6);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1104518011);
                ComposerKt.sourceInformation($composer2, "245@10998L5");
                indicatorShape = ShapesKt.getValue(NavigationRailTokens.INSTANCE.getNoLabelActiveIndicatorShape(), $composer2, 6);
                $composer2.endReplaceGroup();
            }
            function5 = function4;
            Function2 indicatorRipple = ComposableLambdaKt.rememberComposableLambda(211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicatorRipple$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C255@11417L32,251@11230L234:NavigationRail.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(211026382, $changed2, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:251)");
                        }
                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), indicatorShape), offsetInteractionSource, RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, $composer3, 0, 7)), $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            Function2 indicator = ComposableLambdaKt.rememberComposableLambda(-1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer3, "C262@11642L35,259@11525L323:NavigationRail.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1862011490, $changed2, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:259)");
                        }
                        Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                        ComposerKt.sourceInformationMarkerStart($composer3, 540475552, "CC(remember):NavigationRail.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(stateAnimateFloatAsState);
                        final State<Float> state = stateAnimateFloatAsState;
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$indicator$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                    invoke2(graphicsLayerScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                                    $this$graphicsLayer.setAlpha(state.getValue().floatValue());
                                }
                            };
                            $composer3.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        BoxKt.Box(BackgroundKt.m453backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (Function1) value$iv4), colors2.getSelectedIndicatorColor(), indicatorShape), $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            ComposerKt.sourceInformationMarkerStart($composer2, 1104519132, "CC(remember):NavigationRail.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(stateAnimateFloatAsState);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return stateAnimateFloatAsState.getValue();
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            NavigationRailItemLayout(indicatorRipple, indicator, styledIcon, styledLabel, alwaysShowLabel3, (Function0) value$iv2, $composer2, (($dirty >> 6) & 57344) | 438);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            enabled3 = enabled4;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = enabled3;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            final boolean z4 = alwaysShowLabel3;
            final NavigationRailItemColors navigationRailItemColors2 = colors3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItem.2
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
                    NavigationRailKt.NavigationRailItem(selected, function0, function2, modifier5, z3, function7, z4, navigationRailItemColors2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final boolean alwaysShowLabel, final Function0<Float> function0, Composer $composer, final int $changed) {
        MeasurePolicy value$iv;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function6;
        Composer $composer2;
        Object value$iv2;
        Function0<ComposeUiNode> function7;
        Composer $composer3 = $composer.startRestartGroup(1498399348);
        ComposerKt.sourceInformation($composer3, "C(NavigationRailItemLayout)P(4,3,2,5)513@22657L2124,500@22283L2498:NavigationRail.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function4) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function5) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changed(alwaysShowLabel) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1498399348, $dirty2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:499)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -753441829, "CC(remember):NavigationRail.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 458752) == 131072) | (($dirty2 & 7168) == 2048) | (($dirty2 & 57344) == 16384);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$2$1
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
                    public final MeasureResult mo285measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        Object it$iv2;
                        Placeable labelPlaceable;
                        float animationProgress = function0.invoke().floatValue();
                        long looseConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
                        List<? extends Measurable> list2 = list;
                        int $i$f$fastFirst = 0;
                        int index$iv$iv = 0;
                        int size = list2.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = list2.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            List<? extends Measurable> list3 = list2;
                            int $i$f$fastFirst2 = $i$f$fastFirst;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "icon")) {
                                Placeable iconPlaceable = ((Measurable) item$iv$iv).mo5644measureBRTryo0(looseConstraints);
                                int width = iconPlaceable.getWidth();
                                float arg0$iv = NavigationRailKt.IndicatorHorizontalPadding;
                                int totalIndicatorWidth = width + $this$Layout.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(2 * arg0$iv));
                                int animatedIndicatorWidth = MathKt.roundToInt(totalIndicatorWidth * animationProgress);
                                float indicatorVerticalPadding = function5 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel;
                                int height = iconPlaceable.getHeight();
                                int other$iv = $this$Layout.mo561roundToPx0680j_4(C1979Dp.m6801constructorimpl(2 * indicatorVerticalPadding));
                                int indicatorHeight = height + other$iv;
                                List<? extends Measurable> list4 = list;
                                int $i$f$fastFirst3 = 0;
                                int index$iv$iv2 = 0;
                                int size2 = list4.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = list4.get(index$iv$iv2);
                                    Measurable it2 = (Measurable) item$iv$iv2;
                                    List<? extends Measurable> list5 = list4;
                                    int $i$f$fastFirst4 = $i$f$fastFirst3;
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "indicatorRipple")) {
                                        Placeable indicatorRipplePlaceable = ((Measurable) item$iv$iv2).mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(totalIndicatorWidth, indicatorHeight));
                                        List<? extends Measurable> list6 = list;
                                        int $i$f$fastFirstOrNull = 0;
                                        int index$iv$iv3 = 0;
                                        int size3 = list6.size();
                                        while (true) {
                                            if (index$iv$iv3 >= size3) {
                                                it$iv2 = null;
                                                break;
                                            }
                                            it$iv2 = list6.get(index$iv$iv3);
                                            Measurable it3 = (Measurable) it$iv2;
                                            List<? extends Measurable> list7 = list6;
                                            int $i$f$fastFirstOrNull2 = $i$f$fastFirstOrNull;
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it3), "indicator")) {
                                                break;
                                            }
                                            index$iv$iv3++;
                                            list6 = list7;
                                            $i$f$fastFirstOrNull = $i$f$fastFirstOrNull2;
                                        }
                                        Measurable measurable = (Measurable) it$iv2;
                                        Placeable indicatorPlaceable = measurable != null ? measurable.mo5644measureBRTryo0(Constraints.INSTANCE.m6754fixedJhjzzOo(animatedIndicatorWidth, indicatorHeight)) : null;
                                        if (function5 != null) {
                                            List<? extends Measurable> list8 = list;
                                            int size4 = list8.size();
                                            int index$iv$iv4 = 0;
                                            while (true) {
                                                if (index$iv$iv4 >= size4) {
                                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                                }
                                                Object item$iv$iv3 = list8.get(index$iv$iv4);
                                                Measurable it4 = (Measurable) item$iv$iv3;
                                                int i = size4;
                                                List<? extends Measurable> list9 = list8;
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it4), "label")) {
                                                    labelPlaceable = ((Measurable) item$iv$iv3).mo5644measureBRTryo0(looseConstraints);
                                                    break;
                                                }
                                                index$iv$iv4++;
                                                size4 = i;
                                                list8 = list9;
                                            }
                                        } else {
                                            labelPlaceable = null;
                                        }
                                        if (function5 == null) {
                                            return NavigationRailKt.m2460placeIconX9ElhV4($this$Layout, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints);
                                        }
                                        Intrinsics.checkNotNull(labelPlaceable);
                                        return NavigationRailKt.m2461placeLabelAndIconzUg2_y0($this$Layout, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, alwaysShowLabel, animationProgress);
                                    }
                                    index$iv$iv2++;
                                    list4 = list5;
                                    $i$f$fastFirst3 = $i$f$fastFirst4;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            index$iv$iv++;
                            list2 = list3;
                            $i$f$fastFirst = $i$f$fastFirst2;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 484846999, "C501@22300L17,502@22326L11,504@22347L50:NavigationRail.kt#uh7d8r");
            function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
            function3.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, IconLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function6 = constructor2;
                $composer3.createNode(function6);
            } else {
                function6 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            $composer2 = $composer3;
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -960475247, "C504@22389L6:NavigationRail.kt#uh7d8r");
            function4.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.startReplaceGroup(-753442079);
            ComposerKt.sourceInformation($composer3, "510@22553L60,507@22440L199");
            if (function5 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, LabelLayoutIdTag);
                ComposerKt.sourceInformationMarkerStart($composer3, 484847252, "CC(remember):NavigationRail.kt#9igjgp");
                boolean invalid$iv2 = ((57344 & $dirty2) == 16384) | ((458752 & $dirty2) == 131072);
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                            invoke2(graphicsLayerScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                            $this$graphicsLayer.setAlpha(alwaysShowLabel ? 1.0f : function0.invoke().floatValue());
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv3 = GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (Function1) value$iv2);
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function7 = constructor3;
                    $composer3.createNode(function7);
                } else {
                    function7 = constructor3;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -960475006, "C511@22630L7:NavigationRail.kt#uh7d8r");
                function5.invoke($composer3, Integer.valueOf(($dirty2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt.NavigationRailItemLayout.3
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
                    NavigationRailKt.NavigationRailItemLayout(function2, function3, function4, function5, alwaysShowLabel, function0, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2460placeIconX9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, final Placeable iconPlaceable, final Placeable indicatorRipplePlaceable, final Placeable indicatorPlaceable, long constraints) {
        final int width = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, Math.max(iconPlaceable.getWidth(), Math.max(indicatorRipplePlaceable.getWidth(), indicatorPlaceable != null ? indicatorPlaceable.getWidth() : 0)));
        final int height = ConstraintsKt.m6760constrainHeightK40F9xA(constraints, $this$placeIcon_u2dX9ElhV4.mo561roundToPx0680j_4(NavigationRailItemHeight));
        final int iconX = (width - iconPlaceable.getWidth()) / 2;
        final int iconY = (height - iconPlaceable.getHeight()) / 2;
        final int rippleX = (width - indicatorRipplePlaceable.getWidth()) / 2;
        final int rippleY = (height - indicatorRipplePlaceable.getHeight()) / 2;
        return MeasureScope.CC.layout$default($this$placeIcon_u2dX9ElhV4, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeIcon$1
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
                Placeable it = indicatorPlaceable;
                if (it != null) {
                    int i = width;
                    int i2 = height;
                    int indicatorX = (i - it.getWidth()) / 2;
                    int indicatorY = (i2 - it.getHeight()) / 2;
                    Placeable.PlacementScope.placeRelative$default($this$layout, it, indicatorX, indicatorY, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, iconPlaceable, iconX, iconY, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default($this$layout, indicatorRipplePlaceable, rippleX, rippleY, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m2461placeLabelAndIconzUg2_y0(final MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, final Placeable labelPlaceable, final Placeable iconPlaceable, final Placeable indicatorRipplePlaceable, final Placeable indicatorPlaceable, long constraints, final boolean alwaysShowLabel, final float animationProgress) {
        float contentHeight = iconPlaceable.getHeight() + $this$placeLabelAndIcon_u2dzUg2_y0.mo567toPx0680j_4(IndicatorVerticalPaddingWithLabel) + $this$placeLabelAndIcon_u2dzUg2_y0.mo567toPx0680j_4(NavigationRailItemVerticalPadding) + labelPlaceable.getHeight();
        float f = 2;
        final float contentVerticalPadding = RangesKt.coerceAtLeast((Constraints.m6745getMinHeightimpl(constraints) - contentHeight) / f, $this$placeLabelAndIcon_u2dzUg2_y0.mo567toPx0680j_4(IndicatorVerticalPaddingWithLabel));
        float height = contentHeight + (contentVerticalPadding * f);
        float unselectedIconY = alwaysShowLabel ? contentVerticalPadding : (height - iconPlaceable.getHeight()) / f;
        float iconDistance = unselectedIconY - contentVerticalPadding;
        final float offset = iconDistance * (1 - animationProgress);
        final float labelY = contentVerticalPadding + iconPlaceable.getHeight() + $this$placeLabelAndIcon_u2dzUg2_y0.mo567toPx0680j_4(IndicatorVerticalPaddingWithLabel) + $this$placeLabelAndIcon_u2dzUg2_y0.mo567toPx0680j_4(NavigationRailItemVerticalPadding);
        final int width = ConstraintsKt.m6761constrainWidthK40F9xA(constraints, Math.max(iconPlaceable.getWidth(), Math.max(labelPlaceable.getWidth(), indicatorPlaceable != null ? indicatorPlaceable.getWidth() : 0)));
        final int labelX = (width - labelPlaceable.getWidth()) / 2;
        final int iconX = (width - iconPlaceable.getWidth()) / 2;
        final int rippleX = (width - indicatorRipplePlaceable.getWidth()) / 2;
        final float rippleY = contentVerticalPadding - $this$placeLabelAndIcon_u2dzUg2_y0.mo567toPx0680j_4(IndicatorVerticalPaddingWithLabel);
        return MeasureScope.CC.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, width, MathKt.roundToInt(height), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:12:0x0040  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                Placeable it = indicatorPlaceable;
                if (it != null) {
                    int i = width;
                    float f2 = contentVerticalPadding;
                    MeasureScope measureScope = $this$placeLabelAndIcon_u2dzUg2_y0;
                    float f3 = offset;
                    int indicatorX = (i - it.getWidth()) / 2;
                    float indicatorY = f2 - measureScope.mo567toPx0680j_4(NavigationRailKt.IndicatorVerticalPaddingWithLabel);
                    Placeable.PlacementScope.placeRelative$default($this$layout, it, indicatorX, MathKt.roundToInt(f3 + indicatorY), 0.0f, 4, null);
                }
                if (alwaysShowLabel) {
                    Placeable.PlacementScope.placeRelative$default($this$layout, labelPlaceable, labelX, MathKt.roundToInt(labelY + offset), 0.0f, 4, null);
                } else {
                    if (!(animationProgress == 0.0f)) {
                        Placeable.PlacementScope.placeRelative$default($this$layout, labelPlaceable, labelX, MathKt.roundToInt(labelY + offset), 0.0f, 4, null);
                    }
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, iconPlaceable, iconX, MathKt.roundToInt(contentVerticalPadding + offset), 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default($this$layout, indicatorRipplePlaceable, rippleX, MathKt.roundToInt(rippleY + offset), 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float arg0$iv = NavigationRailTokens.INSTANCE.m3430getActiveIndicatorWidthD9Ej5fM();
        float other$iv = NavigationRailTokens.INSTANCE.m3433getIconSizeD9Ej5fM();
        IndicatorHorizontalPadding = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv - other$iv) / 2);
        float arg0$iv2 = NavigationRailTokens.INSTANCE.m3429getActiveIndicatorHeightD9Ej5fM();
        float other$iv2 = NavigationRailTokens.INSTANCE.m3433getIconSizeD9Ej5fM();
        IndicatorVerticalPaddingWithLabel = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv2 - other$iv2) / 2);
        float arg0$iv3 = NavigationRailTokens.INSTANCE.m3435getNoLabelActiveIndicatorHeightD9Ej5fM();
        float other$iv3 = NavigationRailTokens.INSTANCE.m3433getIconSizeD9Ej5fM();
        IndicatorVerticalPaddingNoLabel = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv3 - other$iv3) / 2);
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }
}
