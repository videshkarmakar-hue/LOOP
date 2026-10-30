package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.LayoutKt;
import androidx.compose.p001ui.layout.LayoutModifierKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: SegmentedButton.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00062\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0014\u001aD\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u0091\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010&\u001a\u008b\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u00162\u0006\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, m195d2 = {"CheckedZIndexFactor", "", "IconSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "MultiChoiceSegmentedButtonRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "space", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SegmentedButtonContent", "icon", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceSegmentedButtonRow", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButton", "checked", "", "onCheckedChange", "shape", "Landroidx/compose/ui/graphics/Shape;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = C1979Dp.m6801constructorimpl(8);

    public static final void SegmentedButton(final MultiChoiceSegmentedButtonRowScope $this$SegmentedButton, final boolean checked, final Function1<? super Boolean, Unit> function1, final Shape shape, Modifier modifier, boolean enabled, SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean enabled2;
        SegmentedButtonColors colors2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        int $dirty;
        final Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Modifier modifier2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource mutableInteractionSource;
        Function2<? super Composer, ? super Integer, Unit> function4;
        MutableInteractionSource interactionSource4;
        Modifier modifier3;
        boolean enabled3;
        SegmentedButtonColors colors3;
        BorderStroke border3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1596038053);
        ComposerKt.sourceInformation($composer2, "C(SegmentedButton)P(1,8,9,7,3,2!1,5)134@6785L8,139@7004L41,146@7378L25,164@7943L51,148@7409L585:SegmentedButton.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed($this$SegmentedButton) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(shape) ? 2048 : 1024;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 16384 : 8192;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(colors)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(border)) ? 8388608 : 4194304;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if ((i & 512) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int $dirty3 = $dirty1;
        if ((306783379 & $dirty2) == 306783378 && ($dirty3 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            colors3 = colors;
            border3 = border;
            interactionSource4 = interactionSource;
            function4 = function2;
            $dirty3 = $dirty3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                if ((i & 32) != 0) {
                    colors2 = SegmentedButtonDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    colors2 = colors;
                }
                if ((i & 64) != 0) {
                    border2 = SegmentedButtonDefaults.m2569borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors2.m2553borderColorWaAFU9c$material3_release(enabled2, checked), 0.0f, 2, null);
                    $dirty2 &= -29360129;
                } else {
                    border2 = border;
                }
                MutableInteractionSource interactionSource5 = i4 != 0 ? null : interactionSource;
                if (i5 != 0) {
                    int $dirty4 = $dirty2;
                    Modifier modifier5 = modifier4;
                    interactionSource2 = interactionSource5;
                    $dirty = $dirty4;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(970447394, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.1
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
                            ComposerKt.sourceInformation($composer3, "C139@7030L13:SegmentedButton.kt#uh7d8r");
                            if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(970447394, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:139)");
                            }
                            SegmentedButtonDefaults.INSTANCE.Icon(checked, null, null, $composer3, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                    modifier2 = modifier5;
                } else {
                    int $dirty5 = $dirty2;
                    Modifier modifier6 = modifier4;
                    interactionSource2 = interactionSource5;
                    $dirty = $dirty5;
                    function2RememberComposableLambda = function2;
                    modifier2 = modifier6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 64) != 0) {
                    int i6 = $dirty2 & (-29360129);
                    enabled2 = enabled;
                    colors2 = colors;
                    border2 = border;
                    interactionSource2 = interactionSource;
                    function2RememberComposableLambda = function2;
                    $dirty = i6;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    colors2 = colors;
                    border2 = border;
                    function2RememberComposableLambda = function2;
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1596038053, $dirty, $dirty3, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:141)");
            }
            $composer2.startReplaceGroup(-773603479);
            ComposerKt.sourceInformation($composer2, "143@7167L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -773603458, "CC(remember):SegmentedButton.kt#9igjgp");
                interactionSource3 = interactionSource2;
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource3 = interactionSource2;
                mutableInteractionSource = interactionSource3;
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource6 = mutableInteractionSource;
            long containerColor = colors2.m2554containerColorWaAFU9c$material3_release(enabled2, checked);
            long contentColor = colors2.m2555contentColorWaAFU9c$material3_release(enabled2, checked);
            Modifier modifier7 = modifier2;
            function4 = function2RememberComposableLambda;
            SurfaceKt.m2668Surfaced85dljk(checked, function1, SizeKt.m897defaultMinSizeVpY3zN4(interactionZIndex(RowScope.CC.weight$default($this$SegmentedButton, modifier2, 1.0f, false, 2, null), checked, interactionCountAsState(interactionSource6, $composer2, 0)), ButtonDefaults.INSTANCE.m1968getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1967getMinHeightD9Ej5fM()), enabled2, shape, containerColor, contentColor, 0.0f, 0.0f, border2, interactionSource6, ComposableLambdaKt.rememberComposableLambda(1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.2
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
                    ComposerKt.sourceInformation($composer3, "C165@7953L35:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1635710341, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:165)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(function2RememberComposableLambda, function3, $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 6) & 7168) | (57344 & ($dirty << 3)) | (($dirty << 6) & 1879048192), 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource4 = interactionSource3;
            modifier3 = modifier7;
            enabled3 = enabled2;
            colors3 = colors2;
            border3 = border2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final boolean z = enabled3;
            final SegmentedButtonColors segmentedButtonColors = colors3;
            final BorderStroke borderStroke = border3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
            final Function2<? super Composer, ? super Integer, Unit> function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.3
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
                    SegmentedButtonKt.SegmentedButton($this$SegmentedButton, checked, function1, shape, modifier8, z, segmentedButtonColors, borderStroke, mutableInteractionSource2, function5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void SegmentedButton(final SingleChoiceSegmentedButtonRowScope $this$SegmentedButton, final boolean selected, final Function0<Unit> function0, final Shape shape, Modifier modifier, boolean enabled, SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean enabled2;
        SegmentedButtonColors colors2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        int $dirty;
        final Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Modifier modifier2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource mutableInteractionSource;
        SegmentedButtonColors colors3;
        MutableInteractionSource interactionSource4;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        boolean enabled3;
        BorderStroke border3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1016574361);
        ComposerKt.sourceInformation($composer2, "C(SegmentedButton)P(8,7,9,6,2,1!1,4)211@10299L8,216@10519L42,223@10896L25,242@11499L51,225@10927L623:SegmentedButton.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed($this$SegmentedButton) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(selected) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(shape) ? 2048 : 1024;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 16384 : 8192;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= ((i & 32) == 0 && $composer2.changed(colors)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= ((i & 64) == 0 && $composer2.changed(border)) ? 8388608 : 4194304;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if ((i & 512) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int $dirty3 = $dirty1;
        if ((306783379 & $dirty2) == 306783378 && ($dirty3 & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled3 = enabled;
            colors3 = colors;
            border3 = border;
            interactionSource4 = interactionSource;
            function4 = function2;
            $dirty3 = $dirty3;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                enabled2 = i3 != 0 ? true : enabled;
                if ((i & 32) != 0) {
                    colors2 = SegmentedButtonDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    colors2 = colors;
                }
                if ((i & 64) != 0) {
                    border2 = SegmentedButtonDefaults.m2569borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors2.m2553borderColorWaAFU9c$material3_release(enabled2, selected), 0.0f, 2, null);
                    $dirty2 &= -29360129;
                } else {
                    border2 = border;
                }
                MutableInteractionSource interactionSource5 = i4 != 0 ? null : interactionSource;
                if (i5 != 0) {
                    int $dirty4 = $dirty2;
                    Modifier modifier5 = modifier4;
                    interactionSource2 = interactionSource5;
                    $dirty = $dirty4;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1235063168, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.4
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
                            ComposerKt.sourceInformation($composer3, "C216@10545L14:SegmentedButton.kt#uh7d8r");
                            if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                $composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1235063168, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:216)");
                            }
                            SegmentedButtonDefaults.INSTANCE.Icon(selected, null, null, $composer3, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer2, 54);
                    modifier2 = modifier5;
                } else {
                    int $dirty5 = $dirty2;
                    Modifier modifier6 = modifier4;
                    interactionSource2 = interactionSource5;
                    $dirty = $dirty5;
                    function2RememberComposableLambda = function2;
                    modifier2 = modifier6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 64) != 0) {
                    int i6 = $dirty2 & (-29360129);
                    enabled2 = enabled;
                    colors2 = colors;
                    border2 = border;
                    interactionSource2 = interactionSource;
                    function2RememberComposableLambda = function2;
                    $dirty = i6;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    enabled2 = enabled;
                    colors2 = colors;
                    border2 = border;
                    function2RememberComposableLambda = function2;
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1016574361, $dirty, $dirty3, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:218)");
            }
            $composer2.startReplaceGroup(-773599963);
            ComposerKt.sourceInformation($composer2, "220@10683L39");
            if (interactionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, -773599942, "CC(remember):SegmentedButton.kt#9igjgp");
                interactionSource3 = interactionSource2;
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                interactionSource3 = interactionSource2;
                mutableInteractionSource = interactionSource3;
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource6 = mutableInteractionSource;
            long containerColor = colors2.m2554containerColorWaAFU9c$material3_release(enabled2, selected);
            long contentColor = colors2.m2555contentColorWaAFU9c$material3_release(enabled2, selected);
            Modifier modifier7 = modifier2;
            colors3 = colors2;
            SurfaceKt.m2667Surfaced85dljk(selected, function0, SemanticsModifierKt.semantics$default(SizeKt.m897defaultMinSizeVpY3zN4(interactionZIndex(RowScope.CC.weight$default($this$SegmentedButton, modifier2, 1.0f, false, 2, null), selected, interactionCountAsState(interactionSource6, $composer2, 0)), ButtonDefaults.INSTANCE.m1968getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1967getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m6079setRolekuIjeqM($this$semantics, Role.INSTANCE.m6066getRadioButtono7Vup1c());
                }
            }, 1, null), enabled2, shape, containerColor, contentColor, 0.0f, 0.0f, border2, interactionSource6, ComposableLambdaKt.rememberComposableLambda(383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.6
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
                    ComposerKt.sourceInformation($composer3, "C243@11509L35:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(383378045, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:243)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(function2RememberComposableLambda, function3, $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 6) & 7168) | (57344 & ($dirty << 3)) | (($dirty << 6) & 1879048192), 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource4 = interactionSource3;
            modifier3 = modifier7;
            function4 = function2RememberComposableLambda;
            enabled3 = enabled2;
            border3 = border2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final boolean z = enabled3;
            final SegmentedButtonColors segmentedButtonColors = colors3;
            final BorderStroke borderStroke = border3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource4;
            final Function2<? super Composer, ? super Integer, Unit> function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.7
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
                    SegmentedButtonKt.SegmentedButton($this$SegmentedButton, selected, function0, shape, modifier8, z, segmentedButtonColors, borderStroke, mutableInteractionSource2, function5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2575SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float space, final Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        float space2;
        Function0<ComposeUiNode> function0;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1520863498);
        ComposerKt.sourceInformation($composer2, "C(SingleChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)269@12572L423:SegmentedButton.kt#uh7d8r");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f = space;
        } else if (($changed & 48) == 0) {
            f = space;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = space;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            space2 = f;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            float space3 = i3 != 0 ? SegmentedButtonDefaults.INSTANCE.m2572getBorderWidthD9Ej5fM() : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520863498, $dirty2, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:268)");
            }
            Modifier modifier$iv = IntrinsicKt.width(SizeKt.m898defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier4), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3457getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(-space3));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            space2 = space3;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$SingleChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -181589282, "C277@12907L58,278@12980L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart($composer2, -181589270, "CC(remember):SegmentedButton.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SingleChoiceSegmentedButtonScopeWrapper($this$SingleChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u243);
                $composer2.updateRememberedValue(value$iv);
            }
            SingleChoiceSegmentedButtonScopeWrapper scope = (SingleChoiceSegmentedButtonScopeWrapper) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            function3.invoke(scope, $composer2, Integer.valueOf((($dirty2 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f2 = space2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SingleChoiceSegmentedButtonRow$2
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
                    SegmentedButtonKt.m2575SingleChoiceSegmentedButtonRowuFdPcIQ(modifier6, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m2574MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float space, final Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        float space2;
        Function0<ComposeUiNode> function0;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(155922315);
        ComposerKt.sourceInformation($composer2, "C(MultiChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)306@14038L391:SegmentedButton.kt#uh7d8r");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f = space;
        } else if (($changed & 48) == 0) {
            f = space;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = space;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            space2 = f;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            float space3 = i3 != 0 ? SegmentedButtonDefaults.INSTANCE.m2572getBorderWidthD9Ej5fM() : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(155922315, $dirty2, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:305)");
            }
            Modifier modifier$iv = IntrinsicKt.width(SizeKt.m898defaultMinSizeVpY3zN4$default(modifier4, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m3457getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m744spacedBy0680j_4(C1979Dp.m6801constructorimpl(-space3));
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            space2 = space3;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer2);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$MultiChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u245 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 573415950, "C313@14342L57,314@14414L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart($composer2, 573415962, "CC(remember):SegmentedButton.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MultiChoiceSegmentedButtonScopeWrapper($this$MultiChoiceSegmentedButtonRow_uFdPcIQ_u24lambda_u245);
                $composer2.updateRememberedValue(value$iv);
            }
            MultiChoiceSegmentedButtonScopeWrapper scope = (MultiChoiceSegmentedButtonScopeWrapper) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            function3.invoke(scope, $composer2, Integer.valueOf((($dirty2 >> 3) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f2 = space2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$MultiChoiceSegmentedButtonRow$2
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
                    SegmentedButtonKt.m2574MultiChoiceSegmentedButtonRowuFdPcIQ(modifier6, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SegmentedButtonContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1464121570);
        ComposerKt.sourceInformation($composer2, "C(SegmentedButtonContent)P(1)323@14560L637:SegmentedButton.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464121570, $dirty, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:322)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, ButtonDefaults.INSTANCE.getTextButtonContentPadding());
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 372432376, "C328@14746L10,329@14849L342,329@14820L371:SegmentedButton.kt#uh7d8r");
            TextStyle typography = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont());
            TextKt.ProvideTextStyle(typography, ComposableLambdaKt.rememberComposableLambda(1420592651, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButtonContent$1$1
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
                    Object value$iv$iv;
                    Object value$iv;
                    Object value$iv$iv2;
                    ComposerKt.sourceInformation($composer3, "C330@14875L24,331@14932L55,333@15001L180:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1420592651, $changed2, -1, "androidx.compose.material3.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButton.kt:330)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer3, -723523240, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, -1468900482, "CC(remember):SegmentedButton.kt#9igjgp");
                        Object it$iv = $composer3.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new SegmentedButtonContentMeasurePolicy(scope);
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        SegmentedButtonContentMeasurePolicy measurePolicy = (SegmentedButtonContentMeasurePolicy) value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                        boolean invalid$iv$iv = true;
                        List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, function3});
                        ComposerKt.sourceInformationMarkerStart($composer3, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1376093675, "CC(remember):Layout.kt#9igjgp");
                        if ((((432 & 896) ^ 384) <= 256 || !$composer3.changed(measurePolicy)) && (432 & 384) != 256) {
                            invalid$iv$iv = false;
                        }
                        Object it$iv$iv2 = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
                            $composer3.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        int $changed$iv$iv2 = 432 & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifierHeight);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor2);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts.invoke($composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 6) & 14));
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
            }, $composer2, 54), $composer2, 48);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButtonContent.2
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

                public final void invoke(Composer composer, int i3) {
                    SegmentedButtonKt.SegmentedButtonContent(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final State<Integer> interactionCountAsState(InteractionSource $this$interactionCountAsState, Composer $composer, int $changed) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, 281890131, "C(interactionCountAsState)399@17392L33,400@17451L500,400@17430L521:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, $changed, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:398)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1372284335, "CC(remember):SegmentedButton.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableIntState interactionCount = (MutableIntState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1372284276, "CC(remember):SegmentedButton.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed($this$interactionCountAsState)) || ($changed & 6) == 4;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new SegmentedButtonKt$interactionCountAsState$1$1($this$interactionCountAsState, interactionCount, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect($this$interactionCountAsState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return interactionCount;
    }

    private static final Modifier interactionZIndex(Modifier $this$interactionZIndex, final boolean checked, final State<Integer> state) {
        return LayoutModifierKt.layout($this$interactionZIndex, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2576invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2576invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                final Placeable placeable = measurable.mo5644measureBRTryo0(constraints);
                int width = placeable.getWidth();
                int height = placeable.getHeight();
                final State<Integer> state2 = state;
                final boolean z = checked;
                return MeasureScope.CC.layout$default($this$layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1.1
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
                    public final void invoke2(Placeable.PlacementScope $this$layout2) {
                        float zIndex = state2.getValue().floatValue() + (z ? SegmentedButtonKt.CheckedZIndexFactor : 0.0f);
                        $this$layout2.place(placeable, 0, 0, zIndex);
                    }
                }, 4, null);
            }
        });
    }
}
