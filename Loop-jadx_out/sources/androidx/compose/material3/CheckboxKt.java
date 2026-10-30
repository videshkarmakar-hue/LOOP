package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.CornerRadiusKt;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.StrokeCap;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.graphics.drawscope.Fill;
import androidx.compose.p001ui.graphics.drawscope.Stroke;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.state.ToggleableState;
import androidx.compose.p001ui.state.ToggleableStateKt;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aO\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010 \u001a6\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a>\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, m195d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", DownloadUtil.CookieScheme.VALUE, "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding = C1979Dp.m6801constructorimpl(2);
    private static final float CheckboxSize = C1979Dp.m6801constructorimpl(20);
    private static final float StrokeWidth = C1979Dp.m6801constructorimpl(2);
    private static final float RadiusSize = C1979Dp.m6801constructorimpl(2);

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void Checkbox(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        CheckboxColors colors2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier3;
        int $dirty;
        CheckboxColors colors3;
        MutableInteractionSource interactionSource2;
        Function0 function0;
        CheckboxColors colors4;
        Modifier modifier4;
        MutableInteractionSource interactionSource3;
        boolean enabled3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1406741137);
        ComposerKt.sourceInformation($composer2, "C(Checkbox)P(!1,5,4,2)93@4273L8,96@4347L328:Checkbox.kt#uh7d8r");
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
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                int i4 = $composer2.changed(colors2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i4;
        } else {
            colors2 = colors;
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
            enabled3 = enabled2;
            interactionSource3 = mutableInteractionSource;
            colors4 = colors2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    colors2 = CheckboxDefaults.INSTANCE.colors($composer2, 6);
                }
                if (i5 != 0) {
                    interactionSource2 = null;
                    $dirty = $dirty2;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                modifier3 = modifier2;
                interactionSource2 = mutableInteractionSource;
                $dirty = $dirty2;
                colors3 = colors2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406741137, $dirty, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:95)");
            }
            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(checked);
            $composer2.startReplaceGroup(1557792611);
            ComposerKt.sourceInformation($composer2, "99@4468L29");
            if (function1 != null) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1557792654, "CC(remember):Checkbox.kt#9igjgp");
                boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.CheckboxKt$Checkbox$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function1.invoke(Boolean.valueOf(!checked));
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                function0 = (Function0) value$iv;
            } else {
                function0 = null;
            }
            $composer2.endReplaceGroup();
            TriStateCheckbox(ToggleableState, function0, modifier3, enabled2, colors3, interactionSource2, $composer2, ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            modifier4 = modifier3;
            interactionSource3 = interactionSource2;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final boolean z = enabled3;
            final CheckboxColors checkboxColors = colors4;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt.Checkbox.2
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
                    CheckboxKt.Checkbox(checked, function1, modifier5, z, checkboxColors, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void TriStateCheckbox(final ToggleableState state, final Function0<Unit> function0, Modifier modifier, boolean enabled, CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        CheckboxColors checkboxColors;
        MutableInteractionSource mutableInteractionSource;
        CheckboxColors colors2;
        int $dirty;
        boolean enabled2;
        CheckboxColors colors3;
        MutableInteractionSource interactionSource2;
        Modifier modifier3;
        Modifier.Companion toggleableModifier;
        MutableInteractionSource interactionSource3;
        CheckboxColors colors4;
        boolean enabled3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation($composer2, "C(TriStateCheckbox)P(5,4,3,1)144@6663L8,163@7273L412:Checkbox.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
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
                checkboxColors = colors;
                int i4 = $composer2.changed(checkboxColors) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                checkboxColors = colors;
            }
            $dirty2 |= i4;
        } else {
            checkboxColors = colors;
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
            modifier4 = modifier2;
            enabled3 = z;
            colors4 = checkboxColors;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i3 != 0 ? true : z;
                if ((i & 16) != 0) {
                    colors2 = CheckboxDefaults.INSTANCE.colors($composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    colors2 = checkboxColors;
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                    colors3 = colors2;
                    interactionSource2 = null;
                } else {
                    $dirty = $dirty2;
                    enabled2 = enabled4;
                    colors3 = colors2;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                enabled2 = z;
                colors3 = checkboxColors;
                interactionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1608358065, $dirty, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:146)");
            }
            $composer2.startReplaceGroup(1797978246);
            ComposerKt.sourceInformation($composer2, "155@7057L149");
            if (function0 != null) {
                Modifier.Companion companion = Modifier.INSTANCE;
                int iM6063getCheckboxo7Vup1c = Role.INSTANCE.m6063getCheckboxo7Vup1c();
                float arg0$iv = CheckboxTokens.INSTANCE.m3129getStateLayerSizeD9Ej5fM();
                toggleableModifier = ToggleableKt.m1123triStateToggleableO2vRcR0(companion, state, interactionSource2, RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, C1979Dp.m6801constructorimpl(arg0$iv / 2), 0L, $composer2, 54, 4), enabled2, Role.m6055boximpl(iM6063getCheckboxo7Vup1c), function0);
            } else {
                toggleableModifier = Modifier.INSTANCE;
            }
            $composer2.endReplaceGroup();
            CheckboxImpl(enabled2, state, PaddingKt.m868padding3ABfNKs(modifier3.then(function0 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(toggleableModifier), CheckboxDefaultPadding), colors3, $composer2, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource3 = interactionSource2;
            colors4 = colors3;
            enabled3 = enabled2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier4;
            final boolean z2 = enabled3;
            final CheckboxColors checkboxColors2 = colors4;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt.TriStateCheckbox.1
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
                    CheckboxKt.TriStateCheckbox(state, function0, modifier6, z2, checkboxColors2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckboxImpl(final boolean enabled, final ToggleableState value, final Modifier modifier, final CheckboxColors colors, Composer $composer, final int $changed) {
        float f;
        float f2;
        float f3;
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(2007131616);
        ComposerKt.sourceInformation($composer2, "C(CheckboxImpl)P(1,3,2)265@11947L23,266@12010L443,282@12512L458,297@12992L32,298@13053L21,299@13101L24,300@13155L27,305@13305L538,301@13187L656:Checkbox.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(value) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007131616, $dirty2, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:264)");
            }
            Transition transition = TransitionKt.updateTransition(value, (String) null, $composer2, ($dirty2 >> 3) & 14, 2);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer $composer3, int $changed2) {
                    SpringSpec springSpecSnap;
                    $composer3.startReplaceGroup(1373301606);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1373301606, $changed2, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:268)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        springSpecSnap = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    } else {
                        springSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return springSpecSnap;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it = (ToggleableState) transition.getCurrentState();
            $composer2.startReplaceGroup(1800065638);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, $changed2, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:275)");
            }
            float f4 = 0.0f;
            switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                case 1:
                    f = 1.0f;
                    break;
                case 2:
                    f = 0.0f;
                    break;
                case 3:
                    f = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv = Float.valueOf(f);
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it2 = (ToggleableState) transition.getTargetState();
            $composer2.startReplaceGroup(1800065638);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, $changed3, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:275)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                case 1:
                    f2 = 1.0f;
                    break;
                case 2:
                    f2 = 0.0f;
                    break;
                case 3:
                    f2 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv = Float.valueOf(f2);
            final State checkDrawFraction = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer $composer3, int $changed4) {
                    TweenSpec tweenSpecSnap;
                    $composer3.startReplaceGroup(-1324481169);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1324481169, $changed4, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:284)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        tweenSpecSnap = AnimationSpecKt.snap$default(0, 1, null);
                    } else {
                        tweenSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecSnap;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it3 = (ToggleableState) transition.getCurrentState();
            $composer2.startReplaceGroup(-1426969489);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426969489, $changed4, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:291)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f3 = 0.0f;
                    break;
                case 2:
                    f3 = 0.0f;
                    break;
                case 3:
                    f3 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it4 = (ToggleableState) transition.getTargetState();
            $composer2.startReplaceGroup(-1426969489);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426969489, $changed5, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:291)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
                case 3:
                    f4 = 1.0f;
                case 1:
                case 2:
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object targetValue$iv$iv2 = Float.valueOf(f4);
                    final State checkCenterGravitationShiftFraction = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -661291622, "CC(remember):Checkbox.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new CheckDrawingCache(null, null, null, 7, null);
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    final CheckDrawingCache checkCache = (CheckDrawingCache) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    final State<Color> stateCheckmarkColor$material3_release = colors.checkmarkColor$material3_release(value, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 6) & 112));
                    final State<Color> stateBoxColor$material3_release = colors.boxColor$material3_release(enabled, value, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
                    final State<Color> stateBorderColor$material3_release = colors.borderColor$material3_release(enabled, value, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
                    Modifier modifierM905requiredSize3ABfNKs = SizeKt.m905requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                    ComposerKt.sourceInformationMarkerStart($composer2, -661291309, "CC(remember):Checkbox.kt#9igjgp");
                    boolean invalid$iv = $composer2.changed(stateBoxColor$material3_release) | $composer2.changed(stateBorderColor$material3_release) | $composer2.changed(stateCheckmarkColor$material3_release) | $composer2.changed(checkDrawFraction) | $composer2.changed(checkCenterGravitationShiftFraction);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
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
                                float strokeWidthPx = (float) Math.floor($this$Canvas.mo567toPx0680j_4(CheckboxKt.StrokeWidth));
                                CheckboxKt.m2008drawBox1wkBAMs($this$Canvas, stateBoxColor$material3_release.getValue().m4301unboximpl(), stateBorderColor$material3_release.getValue().m4301unboximpl(), $this$Canvas.mo567toPx0680j_4(CheckboxKt.RadiusSize), strokeWidthPx);
                                CheckboxKt.m2009drawCheck3IgeMak($this$Canvas, stateCheckmarkColor$material3_release.getValue().m4301unboximpl(), checkDrawFraction.getValue().floatValue(), checkCenterGravitationShiftFraction.getValue().floatValue(), strokeWidthPx, checkCache);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    CanvasKt.Canvas(modifierM905requiredSize3ABfNKs, (Function1) value$iv2, $composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt.CheckboxImpl.2
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
                    CheckboxKt.CheckboxImpl(enabled, value, modifier, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m2008drawBox1wkBAMs(DrawScope $this$drawBox_u2d1wkBAMs, long boxColor, long borderColor, float radius, float strokeWidth) {
        float halfStrokeWidth = strokeWidth / 2.0f;
        Stroke stroke = new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null);
        float checkboxSize = Size.m4118getWidthimpl($this$drawBox_u2d1wkBAMs.mo4773getSizeNHjbRc());
        if (Color.m4292equalsimpl0(boxColor, borderColor)) {
            DrawScope.CC.m4860drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, 0L, androidx.compose.p001ui.geometry.SizeKt.Size(checkboxSize, checkboxSize), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, HttpStatusCodesKt.HTTP_IM_USED, null);
            return;
        }
        float f = 2;
        DrawScope.CC.m4860drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, OffsetKt.Offset(strokeWidth, strokeWidth), androidx.compose.p001ui.geometry.SizeKt.Size(checkboxSize - (strokeWidth * f), checkboxSize - (f * strokeWidth)), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, radius - strokeWidth), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        DrawScope.CC.m4860drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, borderColor, OffsetKt.Offset(halfStrokeWidth, halfStrokeWidth), androidx.compose.p001ui.geometry.SizeKt.Size(checkboxSize - strokeWidth, checkboxSize - strokeWidth), CornerRadiusKt.CornerRadius$default(radius - halfStrokeWidth, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m2009drawCheck3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, CheckDrawingCache drawingCache) {
        Stroke stroke = new Stroke(strokeWidthPx, 0.0f, StrokeCap.INSTANCE.m4654getSquareKaPHkGw(), 0, null, 26, null);
        float width = Size.m4118getWidthimpl($this$drawCheck_u2d3IgeMak.mo4773getSizeNHjbRc());
        float gravitatedCrossX = MathHelpersKt.lerp(0.4f, 0.5f, crossCenterGravitation);
        float gravitatedCrossY = MathHelpersKt.lerp(0.7f, 0.5f, crossCenterGravitation);
        float gravitatedLeftY = MathHelpersKt.lerp(0.5f, 0.5f, crossCenterGravitation);
        float gravitatedRightY = MathHelpersKt.lerp(0.3f, 0.5f, crossCenterGravitation);
        drawingCache.getCheckPath().reset();
        float checkCrossX = width * gravitatedLeftY;
        drawingCache.getCheckPath().moveTo(width * 0.2f, checkCrossX);
        drawingCache.getCheckPath().lineTo(width * gravitatedCrossX, width * gravitatedCrossY);
        drawingCache.getCheckPath().lineTo(width * 0.8f, width * gravitatedRightY);
        drawingCache.getPathMeasure().setPath(drawingCache.getCheckPath(), false);
        drawingCache.getPathToDraw().reset();
        drawingCache.getPathMeasure().getSegment(0.0f, drawingCache.getPathMeasure().getLength() * checkFraction, drawingCache.getPathToDraw(), true);
        DrawScope.CC.m4854drawPathLG529CI$default($this$drawCheck_u2d3IgeMak, drawingCache.getPathToDraw(), checkColor, 0.0f, stroke, null, 0, 52, null);
    }
}
