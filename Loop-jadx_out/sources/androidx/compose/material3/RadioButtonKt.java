package androidx.compose.material3;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.RadioButtonTokens;
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
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0015"}, m195d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonPadding = C1979Dp.m6801constructorimpl(2);
    private static final float RadioButtonDotSize = C1979Dp.m6801constructorimpl(12);
    private static final float RadioStrokeWidth = C1979Dp.m6801constructorimpl(2);

    public static final void RadioButton(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, RadioButtonColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        RadioButtonColors radioButtonColors;
        MutableInteractionSource mutableInteractionSource;
        RadioButtonColors colors2;
        int $dirty;
        boolean enabled2;
        RadioButtonColors colors3;
        MutableInteractionSource interactionSource2;
        Modifier modifier3;
        float fM6801constructorimpl;
        Modifier.Companion selectableModifier;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(408580840);
        ComposerKt.sourceInformation($composer2, "C(RadioButton)P(5,4,3,1)77@3747L8,80@3837L164,84@4030L29,114@5022L415,101@4604L833:RadioButton.kt#uh7d8r");
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
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                radioButtonColors = colors;
                int i4 = $composer2.changed(radioButtonColors) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                radioButtonColors = colors;
            }
            $dirty2 |= i4;
        } else {
            radioButtonColors = colors;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            mutableInteractionSource = interactionSource;
        } else if ((196608 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? 131072 : 65536;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled2 = z;
            colors3 = radioButtonColors;
            interactionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled3 = i3 != 0 ? true : z;
                if ((i & 16) != 0) {
                    colors2 = RadioButtonDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    colors2 = radioButtonColors;
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    colors3 = colors2;
                    interactionSource2 = null;
                } else {
                    $dirty = $dirty2;
                    enabled2 = enabled3;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                enabled2 = z;
                colors3 = radioButtonColors;
                interactionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(408580840, $dirty, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:79)");
            }
            if (selected) {
                float arg0$iv = RadioButtonDotSize;
                fM6801constructorimpl = C1979Dp.m6801constructorimpl(arg0$iv / 2);
            } else {
                fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
            }
            int $dirty3 = $dirty;
            final State<C1979Dp> stateM363animateDpAsStateAjpBEmI = AnimateAsStateKt.m363animateDpAsStateAjpBEmI(fM6801constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer2, 48, 12);
            final State<Color> stateRadioColor$material3_release = colors3.radioColor$material3_release(enabled2, selected, $composer2, (($dirty3 >> 9) & 14) | (($dirty3 << 3) & 112) | (($dirty3 >> 6) & 896));
            $composer2.startReplaceGroup(735546359);
            ComposerKt.sourceInformation($composer2, "93@4385L152");
            if (function0 != null) {
                Modifier.Companion companion = Modifier.INSTANCE;
                int iM6066getRadioButtono7Vup1c = Role.INSTANCE.m6066getRadioButtono7Vup1c();
                float arg0$iv2 = RadioButtonTokens.INSTANCE.m3570getStateLayerSizeD9Ej5fM();
                selectableModifier = SelectableKt.m1114selectableO2vRcR0(companion, selected, interactionSource2, RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, C1979Dp.m6801constructorimpl(arg0$iv2 / 2), 0L, $composer2, 54, 4), enabled2, Role.m6055boximpl(iM6066getRadioButtono7Vup1c), function0);
            } else {
                selectableModifier = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            Modifier modifierM905requiredSize3ABfNKs = SizeKt.m905requiredSize3ABfNKs(PaddingKt.m868padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(function0 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(selectableModifier), Alignment.INSTANCE.getCenter(), false, 2, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m3569getIconSizeD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart($composer2, 735547284, "CC(remember):RadioButton.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(stateRadioColor$material3_release) | $composer2.changed(stateM363animateDpAsStateAjpBEmI);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$1$1
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
                        long jM4301unboximpl = stateRadioColor$material3_release.getValue().m4301unboximpl();
                        float arg0$iv3 = RadioButtonTokens.INSTANCE.m3569getIconSizeD9Ej5fM();
                        float f = 2;
                        DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$Canvas, jM4301unboximpl, $this$Canvas.mo567toPx0680j_4(C1979Dp.m6801constructorimpl(arg0$iv3 / 2)) - (strokeWidth / f), 0L, 0.0f, new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null), null, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, null);
                        if (C1979Dp.m6800compareTo0680j_4(stateM363animateDpAsStateAjpBEmI.getValue().m6815unboximpl(), C1979Dp.m6801constructorimpl(0)) > 0) {
                            DrawScope.CC.m4845drawCircleVaOC9Bg$default($this$Canvas, stateRadioColor$material3_release.getValue().m4301unboximpl(), $this$Canvas.mo567toPx0680j_4(stateM363animateDpAsStateAjpBEmI.getValue().m6815unboximpl()) - (strokeWidth / f), 0L, 0.0f, Fill.INSTANCE, null, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, null);
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
            final boolean z2 = enabled2;
            final RadioButtonColors radioButtonColors2 = colors3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.RadioButtonKt.RadioButton.2
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
                    RadioButtonKt.RadioButton(selected, function0, modifier5, z2, radioButtonColors2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
