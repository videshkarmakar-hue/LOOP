package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.ShadowKt;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aU\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a.\u0010)\u001a\u00020\u0016*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u000b\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\r\"\u0016\u0010\u0013\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020,X\u008a\u0084\u0002"}, m195d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float ThumbDefaultElevation;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float TrackWidth = C1979Dp.m6801constructorimpl(34);
    private static final float TrackStrokeWidth = C1979Dp.m6801constructorimpl(14);
    private static final float ThumbDiameter = C1979Dp.m6801constructorimpl(20);
    private static final float ThumbRippleRadius = C1979Dp.m6801constructorimpl(24);
    private static final float DefaultSwitchPadding = C1979Dp.m6801constructorimpl(2);
    private static final float SwitchWidth = TrackWidth;
    private static final float SwitchHeight = ThumbDiameter;

    public static final void Switch(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, SwitchColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource interactionSource2;
        SwitchColors switchColors;
        SwitchColors colors2;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource3;
        MutableInteractionSource mutableInteractionSource;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        SwitchKt$Switch$2$1 value$iv4;
        AnchoredDraggableState anchoredDraggableState;
        Modifier.Companion toggleableModifier;
        Function0<ComposeUiNode> function0;
        Object value$iv5;
        Composer $composer2 = $composer.startRestartGroup(25866825);
        ComposerKt.sourceInformation($composer2, "C(Switch)P(!1,5,4,2,3)98@4560L8,*103@4753L7,108@5135L34,109@5224L7,110@5301L447,122@5783L37,123@5847L29,124@5920L315,124@5881L354,133@6285L133,133@6240L178,138@6456L7,153@6897L1050:Switch.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            interactionSource2 = interactionSource;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                switchColors = colors;
                int i5 = $composer2.changed(switchColors) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                switchColors = colors;
            }
            $dirty2 |= i5;
        } else {
            switchColors = colors;
        }
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enabled2 = z;
            colors2 = switchColors;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled3 = i3 != 0 ? true : z;
                MutableInteractionSource interactionSource4 = i4 != 0 ? null : interactionSource2;
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    interactionSource3 = interactionSource4;
                    colors2 = SwitchDefaults.INSTANCE.m1821colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, $composer2, 0, 6, 1023);
                } else {
                    colors2 = colors;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    interactionSource3 = interactionSource4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                modifier3 = modifier2;
                enabled2 = z;
                interactionSource3 = interactionSource2;
                colors2 = switchColors;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(25866825, $dirty, -1, "androidx.compose.material.Switch (Switch.kt:99)");
            }
            $composer2.startReplaceGroup(1826260671);
            ComposerKt.sourceInformation($composer2, "101@4654L39");
            if (interactionSource3 == null) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1826260692, "CC(remember):Switch.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv5);
                } else {
                    value$iv5 = it$iv;
                }
                mutableInteractionSource = (MutableInteractionSource) value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                mutableInteractionSource = interactionSource3;
            }
            $composer2.endReplaceGroup();
            MutableInteractionSource interactionSource5 = mutableInteractionSource;
            final float minBound = 0.0f;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Switch_u24lambda_u241 = (Density) objConsume;
            final float maxBound = $this$Switch_u24lambda_u241.mo567toPx0680j_4(ThumbPathLength);
            ComposerKt.sourceInformationMarkerStart($composer2, 1826261173, "CC(remember):Switch.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv2;
            }
            MutableState forceAnimationCheck$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Switch_u24lambda_u245 = (Density) objConsume2;
            final float switchVelocityThresholdPx = $this$Switch_u24lambda_u245.mo567toPx0680j_4(SwitchVelocityThreshold);
            ComposerKt.sourceInformationMarkerStart($composer2, 1826261339, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(maxBound) | $composer2.changed(switchVelocityThresholdPx);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new AnchoredDraggableState(Boolean.valueOf(checked), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<Boolean>, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                        draggableAnchorsConfig.m15at(false, minBound);
                        draggableAnchorsConfig.m15at(true, maxBound);
                    }
                }), new Function1<Float, Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$2
                    public final Float invoke(float distance) {
                        return Float.valueOf(0.7f * distance);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Float invoke(Float f) {
                        return invoke(f.floatValue());
                    }
                }, new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(switchVelocityThresholdPx);
                    }
                }, AnimationSpec, null, 32, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv3;
            }
            AnchoredDraggableState anchoredDraggableState2 = (AnchoredDraggableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            State currentOnCheckedChange$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty >> 3) & 14);
            State currentChecked$delegate = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(checked), $composer2, $dirty & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 1826261958, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(anchoredDraggableState2) | $composer2.changed(currentChecked$delegate) | $composer2.changed(currentOnCheckedChange$delegate);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new SwitchKt$Switch$1$1(anchoredDraggableState2, currentChecked$delegate, currentOnCheckedChange$delegate, forceAnimationCheck$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv3, $composer2, 0);
            Boolean boolValueOf = Boolean.valueOf(checked);
            Boolean boolValueOf2 = Boolean.valueOf(Switch$lambda$3(forceAnimationCheck$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, 1826262323, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv3 = (($dirty & 14) == 4) | $composer2.changed(anchoredDraggableState2);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new SwitchKt$Switch$2$1(checked, anchoredDraggableState2, null);
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(boolValueOf, boolValueOf2, (Function2) value$iv4, $composer2, $dirty & 14);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean isRtl = objConsume3 == LayoutDirection.Rtl;
            if (function1 != null) {
                anchoredDraggableState = anchoredDraggableState2;
                toggleableModifier = ToggleableKt.m1119toggleableO2vRcR0(Modifier.INSTANCE, checked, interactionSource5, null, enabled2, Role.m6055boximpl(Role.INSTANCE.m6067getSwitcho7Vup1c()), function1);
            } else {
                anchoredDraggableState = anchoredDraggableState2;
                toggleableModifier = Modifier.INSTANCE;
            }
            Modifier modifier$iv = SizeKt.m907requiredSizeVpY3zN4(PaddingKt.m868padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifier3.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(toggleableModifier), anchoredDraggableState, Orientation.Horizontal, enabled2 && function1 != null, isRtl, interactionSource5, false), Alignment.INSTANCE.getCenter(), false, 2, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$Switch_u24lambda_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1229337654, "C179@7838L42,175@7683L258:Switch.kt#jmzs0o");
            boolean zBooleanValue = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
            ComposerKt.sourceInformationMarkerStart($composer2, -1229337499, "CC(remember):Switch.kt#9igjgp");
            final AnchoredDraggableState anchoredDraggableState3 = anchoredDraggableState;
            boolean invalid$iv4 = $composer2.changed(anchoredDraggableState3);
            Object value$iv6 = $composer2.rememberedValue();
            if (invalid$iv4 || value$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$3$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(anchoredDraggableState3.requireOffset());
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SwitchImpl($this$Switch_u24lambda_u2412, zBooleanValue, enabled2, colors2, (Function0) value$iv6, interactionSource5, $composer2, ($changed2 & 14) | (($dirty >> 3) & 896) | (($dirty >> 6) & 7168));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource2 = interactionSource3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = enabled2;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            final SwitchColors switchColors2 = colors2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.Switch.4
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
                    SwitchKt.Switch(checked, function1, modifier5, z2, mutableInteractionSource2, switchColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope $this$SwitchImpl, final boolean checked, final boolean enabled, final SwitchColors colors, final Function0<Float> function0, final InteractionSource interactionSource, Composer $composer, final int $changed) {
        Object value$iv;
        SwitchKt$SwitchImpl$1$1 value$iv2;
        float f;
        Object value$iv3;
        long jSwitchImpl$lambda$17;
        Object value$iv4;
        Composer $composer2 = $composer.startRestartGroup(70908914);
        ComposerKt.sourceInformation($composer2, "C(SwitchImpl)P(!1,2!1,4)221@9029L46,223@9115L614,223@9081L648,242@9932L28,246@10055L81,243@9965L171,249@10166L28,250@10244L7,*251@10303L7,252@10353L228,262@10673L43,265@10826L133,259@10586L549:Switch.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$SwitchImpl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(checked) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, $dirty2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:220)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -539244885, "CC(remember):Switch.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            SnapshotStateList interactions = (SnapshotStateList) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -539244799, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty2) == 131072;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SwitchKt$SwitchImpl$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, ($dirty2 >> 15) & 14);
            boolean hasInteraction = !interactions.isEmpty();
            if (hasInteraction) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float elevation = f;
            final State<Color> stateTrackColor = colors.trackColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default($this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -539243859, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(stateTrackColor);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) {
                        SwitchKt.m1823drawTrackRPmYEkk($this$Canvas, SwitchKt.SwitchImpl$lambda$15(stateTrackColor), $this$Canvas.mo567toPx0680j_4(SwitchKt.getTrackWidth()), $this$Canvas.mo567toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) value$iv3, $composer2, 0);
            State<Color> stateThumbColor = colors.thumbColor(enabled, checked, $composer2, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            ProvidableCompositionLocal<C1979Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1979Dp) objConsume2).m6815unboximpl();
            float absoluteElevation = C1979Dp.m6801constructorimpl(arg0$iv + elevation);
            $composer2.startReplaceGroup(-539243532);
            ComposerKt.sourceInformation($composer2, "253@10414L6,254@10489L36");
            if (Color.m4292equalsimpl0(SwitchImpl$lambda$17(stateThumbColor), MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU()) && elevationOverlay != null) {
                jSwitchImpl$lambda$17 = elevationOverlay.mo1669apply7g2Lkgo(SwitchImpl$lambda$17(stateThumbColor), absoluteElevation, $composer2, 0);
            } else {
                jSwitchImpl$lambda$17 = SwitchImpl$lambda$17(stateThumbColor);
            }
            $composer2.endReplaceGroup();
            State<Color> stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(jSwitchImpl$lambda$17, null, null, null, $composer2, 0, 14);
            Modifier modifierAlign = $this$SwitchImpl.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer2, -539243241, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 57344) == 16384;
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m6924boximpl(m1824invokeBjo55l4(density));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1824invokeBjo55l4(Density $this$offset) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(function0.invoke().floatValue()), 0);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(BackgroundKt.m453backgroundbw27NRU(ShadowKt.m3954shadows4CzXII$default(SizeKt.m905requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) value$iv4), interactionSource, RippleKt.m1779rippleOrFallbackImplementation9IZ8Weo(false, ThumbRippleRadius, 0L, $composer2, 54, 4)), ThumbDiameter), elevation, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$18(stateM351animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.SwitchImpl.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    SwitchKt.SwitchImpl($this$SwitchImpl, checked, enabled, colors, function0, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$15(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    private static final long SwitchImpl$lambda$17(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1823drawTrackRPmYEkk(DrawScope $this$drawTrack_u2dRPmYEkk, long trackColor, float trackWidth, float strokeWidth) {
        float strokeRadius = strokeWidth / 2;
        DrawScope.CC.m4850drawLineNGM6Ib0$default($this$drawTrack_u2dRPmYEkk, trackColor, androidx.compose.p001ui.geometry.OffsetKt.Offset(strokeRadius, Offset.m4050getYimpl($this$drawTrack_u2dRPmYEkk.mo4772getCenterF1C5BW0())), androidx.compose.p001ui.geometry.OffsetKt.Offset(trackWidth - strokeRadius, Offset.m4050getYimpl($this$drawTrack_u2dRPmYEkk.mo4772getCenterF1C5BW0())), strokeWidth, StrokeCap.INSTANCE.m4653getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    static {
        float arg0$iv = TrackWidth;
        float other$iv = ThumbDiameter;
        ThumbPathLength = C1979Dp.m6801constructorimpl(arg0$iv - other$iv);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = C1979Dp.m6801constructorimpl(1);
        ThumbPressedElevation = C1979Dp.m6801constructorimpl(6);
        SwitchVelocityThreshold = C1979Dp.m6801constructorimpl(125);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }
}
