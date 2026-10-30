package androidx.compose.material;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.Fill;
import androidx.compose.p001ui.graphics.drawscope.Stroke;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0018"}, m195d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;
    private static final float RadioButtonRippleRadius = C1979Dp.m6801constructorimpl(24);
    private static final float RadioButtonPadding = C1979Dp.m6801constructorimpl(2);
    private static final float RadioButtonSize = C1979Dp.m6801constructorimpl(20);

    public static final void RadioButton(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, RadioButtonColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        RadioButtonColors colors2;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        float fM6801constructorimpl;
        boolean z2;
        Modifier.Companion selectableModifier;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1314435585);
        ComposerKt.sourceInformation($composer2, "C(RadioButton)P(5,4,3,1,2)78@3689L8,80@3722L164,84@3915L29,114@4883L385,101@4476L792:RadioButton.kt#jmzs0o");
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
            mutableInteractionSource = interactionSource;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 16384 : 8192;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i5 = $composer2.changed(colors2) ? 131072 : 65536;
                $dirty2 |= i5;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i5;
        } else {
            colors2 = colors;
        }
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = z;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled3 = i3 != 0 ? true : z;
                MutableInteractionSource interactionSource3 = i4 != 0 ? null : mutableInteractionSource;
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    interactionSource2 = interactionSource3;
                    colors2 = RadioButtonDefaults.INSTANCE.m1771colorsRGew2ao(0L, 0L, 0L, $composer2, 3072, 7);
                } else {
                    colors2 = colors;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    interactionSource2 = interactionSource3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                enabled2 = z;
                interactionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1314435585, $dirty, -1, "androidx.compose.material.RadioButton (RadioButton.kt:79)");
            }
            if (selected) {
                float arg0$iv = RadioButtonDotSize;
                fM6801constructorimpl = C1979Dp.m6801constructorimpl(arg0$iv / 2);
            } else {
                fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
            }
            int $dirty3 = $dirty;
            final State<C1979Dp> stateM363animateDpAsStateAjpBEmI = AnimateAsStateKt.m363animateDpAsStateAjpBEmI(fM6801constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer2, 48, 12);
            final State<Color> stateRadioColor = colors2.radioColor(enabled2, selected, $composer2, (($dirty3 >> 9) & 14) | (($dirty3 << 3) & 112) | (($dirty3 >> 9) & 896));
            $composer2.startReplaceGroup(1941632263);
            ComposerKt.sourceInformation($composer2, "93@4270L139");
            if (function0 != null) {
                z2 = false;
                selectableModifier = SelectableKt.m1114selectableO2vRcR0(Modifier.INSTANCE, selected, interactionSource2, RippleKt.m1779rippleOrFallbackImplementation9IZ8Weo(false, RadioButtonRippleRadius, 0L, $composer2, 54, 4), enabled2, Role.m6055boximpl(Role.INSTANCE.m6066getRadioButtono7Vup1c()), function0);
            } else {
                z2 = false;
                selectableModifier = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            Modifier modifierM905requiredSize3ABfNKs = SizeKt.m905requiredSize3ABfNKs(PaddingKt.m868padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(function0 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(selectableModifier), Alignment.INSTANCE.getCenter(), z2, 2, null), RadioButtonPadding), RadioButtonSize);
            ComposerKt.sourceInformationMarkerStart($composer2, 1941633164, "CC(remember):RadioButton.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(stateRadioColor) | $composer2.changed(stateM363animateDpAsStateAjpBEmI);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$1$1
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
                        float strokeWidth = $this$Canvas.mo567toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
                        float f = 2;
                        DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$Canvas, stateRadioColor.getValue().m4301unboximpl(), $this$Canvas.mo567toPx0680j_4(RadioButtonKt.RadioRadius) - (strokeWidth / f), 0L, 0.0f, new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null), null, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, null);
                        if (C1979Dp.m6800compareTo0680j_4(stateM363animateDpAsStateAjpBEmI.getValue().m6815unboximpl(), C1979Dp.m6801constructorimpl(0)) > 0) {
                            DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$Canvas, stateRadioColor.getValue().m4301unboximpl(), $this$Canvas.mo567toPx0680j_4(stateM363animateDpAsStateAjpBEmI.getValue().m6815unboximpl()) - (strokeWidth / f), 0L, 0.0f, Fill.INSTANCE, null, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, null);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifierM905requiredSize3ABfNKs, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = enabled2;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            final RadioButtonColors radioButtonColors = colors2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt.RadioButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    RadioButtonKt.RadioButton(selected, function0, modifier5, z3, mutableInteractionSource2, radioButtonColors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    static {
        float arg0$iv = RadioButtonSize;
        RadioRadius = C1979Dp.m6801constructorimpl(arg0$iv / 2);
        RadioButtonDotSize = C1979Dp.m6801constructorimpl(12);
        RadioStrokeWidth = C1979Dp.m6801constructorimpl(2);
    }
}
