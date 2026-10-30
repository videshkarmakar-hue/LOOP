package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.CodepointTransformationKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.graphics.Brush;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.SolidColor;
import androidx.compose.p001ui.input.key.KeyEvent;
import androidx.compose.p001ui.input.key.KeyInputModifierKt;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.platform.TextToolbar;
import androidx.compose.p001ui.platform.TextToolbarStatus;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: BasicSecureTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aÀ\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u001728\b\u0002\u0010\u0018\u001a2\u0012\u0004\u0012\u00020\u001a\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0010+\u001a\u00020\t2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b-H\u0003¢\u0006\u0002\u0010.\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, m195d2 = {"DEFAULT_OBFUSCATION_MASK", "", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "PasswordCodepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "getPasswordCodepointTransformation$annotations", "()V", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "BasicSecureTextField-i7dLibI", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ILandroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BasicSecureTextFieldKt {
    private static final char DEFAULT_OBFUSCATION_MASK = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;
    private static final CodepointTransformation PasswordCodepointTransformation = CodepointTransformationKt.mask(CodepointTransformation.INSTANCE, 8226);

    private static /* synthetic */ void getPasswordCodepointTransformation$annotations() {
    }

    /* JADX INFO: renamed from: BasicSecureTextField-i7dLibI, reason: not valid java name */
    public static final void m1151BasicSecureTextFieldi7dLibI(final TextFieldState state, Modifier modifier, boolean enabled, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource interactionSource, Brush cursorBrush, TextFieldDecorator decorator, int textObfuscationMode, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        KeyboardActionHandler onKeyboardAction2;
        Object value$iv;
        CodepointTransformation codepointTransformation;
        final CodepointTransformation codepointTransformation2;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function3;
        MutableInteractionSource interactionSource2;
        Brush cursorBrush2;
        TextFieldDecorator decorator2;
        boolean enabled2;
        InputTransformation inputTransformation2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        int textObfuscationMode2;
        Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(473302171);
        ComposerKt.sourceInformation($composer2, "C(BasicSecureTextField)P(9,6,2,3,11,5,7,8,4!,10:c#foundation.text.input.TextObfuscationMode)128@7446L40,129@7533L130,129@7491L172,170@8797L794,170@8782L809:BasicSecureTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = enabled;
        } else if (($changed & 384) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(inputTransformation) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty |= $composer2.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(onKeyboardAction) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(cursorBrush) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= ($changed1 & 8) == 0 ? $composer2.changed(decorator) : $composer2.changedInstance(decorator) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changed(textObfuscationMode) ? 32 : 16;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty1 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            inputTransformation2 = inputTransformation;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            onKeyboardAction2 = onKeyboardAction;
            function3 = function2;
            interactionSource2 = interactionSource;
            cursorBrush2 = cursorBrush;
            decorator2 = decorator;
            textObfuscationMode2 = textObfuscationMode;
            enabled2 = z;
        } else {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier;
            boolean enabled3 = i3 != 0 ? true : z;
            InputTransformation inputTransformation3 = i4 != 0 ? null : inputTransformation;
            TextStyle textStyle3 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
            KeyboardOptions keyboardOptions3 = i6 != 0 ? KeyboardOptions.INSTANCE.getSecureTextField$foundation_release() : keyboardOptions;
            onKeyboardAction2 = i7 != 0 ? null : onKeyboardAction;
            Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function4 = i8 != 0 ? null : function2;
            MutableInteractionSource interactionSource3 = i9 != 0 ? null : interactionSource;
            SolidColor cursorBrush3 = i10 != 0 ? new SolidColor(Color.INSTANCE.m4317getBlack0d7_KjU(), null) : cursorBrush;
            TextFieldDecorator decorator3 = i11 != 0 ? null : decorator;
            int textObfuscationMode3 = i12 != 0 ? TextObfuscationMode.INSTANCE.m1300getRevealLastTypedvTwcZD0() : textObfuscationMode;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(473302171, $dirty, $dirty1, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:127)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -273192601, "CC(remember):BasicSecureTextField.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new SecureTextFieldController();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final SecureTextFieldController secureTextFieldController = (SecureTextFieldController) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -273192514, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(secureTextFieldController);
            BasicSecureTextFieldKt$BasicSecureTextField$1$1 value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                codepointTransformation = null;
                value$iv2 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(secureTextFieldController, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                codepointTransformation = null;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(secureTextFieldController, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, 0);
            final boolean revealLastTypedEnabled = TextObfuscationMode.m1295equalsimpl0(textObfuscationMode3, TextObfuscationMode.INSTANCE.m1300getRevealLastTypedvTwcZD0());
            if (!revealLastTypedEnabled) {
                secureTextFieldController.getPasswordInputTransformation().hide();
            }
            if (revealLastTypedEnabled) {
                codepointTransformation2 = secureTextFieldController.getCodepointTransformation();
            } else {
                codepointTransformation2 = TextObfuscationMode.m1295equalsimpl0(textObfuscationMode3, TextObfuscationMode.INSTANCE.m1299getHiddenvTwcZD0()) ? PasswordCodepointTransformation : codepointTransformation;
            }
            final Modifier secureTextFieldModifier = SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.password($this$semantics);
                    SemanticsPropertiesKt.copyText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return false;
                        }
                    }, 1, null);
                    SemanticsPropertiesKt.cutText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return false;
                        }
                    }, 1, null);
                }
            }).then(revealLastTypedEnabled ? secureTextFieldController.getFocusChangeModifier() : Modifier.INSTANCE);
            final boolean z2 = enabled3;
            final InputTransformation inputTransformation4 = inputTransformation3;
            final TextStyle textStyle4 = textStyle3;
            final KeyboardOptions keyboardOptions4 = keyboardOptions3;
            final KeyboardActionHandler keyboardActionHandler = onKeyboardAction2;
            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function5 = function4;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Brush brush = cursorBrush3;
            final TextFieldDecorator textFieldDecorator = decorator3;
            int textObfuscationMode4 = textObfuscationMode3;
            DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(501688823, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$2
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
                    InputTransformation inputTransformationThenOrNull;
                    ComposerKt.sourceInformation($composer3, "C171@8807L778:BasicSecureTextField.kt#423gt5");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(501688823, $changed2, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:171)");
                        }
                        TextFieldState textFieldState = state;
                        Modifier modifier4 = secureTextFieldModifier;
                        boolean z3 = z2;
                        if (revealLastTypedEnabled) {
                            inputTransformationThenOrNull = InputTransformationKt.thenOrNull(inputTransformation4, secureTextFieldController.getPasswordInputTransformation());
                        } else {
                            inputTransformationThenOrNull = inputTransformation4;
                        }
                        BasicTextFieldKt.BasicTextField(textFieldState, modifier4, z3, false, inputTransformationThenOrNull, textStyle4, keyboardOptions4, keyboardActionHandler, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) function5, mutableInteractionSource, brush, codepointTransformation2, (OutputTransformation) null, textFieldDecorator, (ScrollState) null, $composer3, 100666368, 0, 40960);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
            interactionSource2 = interactionSource3;
            cursorBrush2 = cursorBrush3;
            decorator2 = decorator3;
            enabled2 = enabled3;
            inputTransformation2 = inputTransformation3;
            textStyle2 = textStyle3;
            keyboardOptions2 = keyboardOptions3;
            textObfuscationMode2 = textObfuscationMode4;
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z3 = enabled2;
            final InputTransformation inputTransformation5 = inputTransformation2;
            final TextStyle textStyle5 = textStyle2;
            final KeyboardOptions keyboardOptions5 = keyboardOptions2;
            final KeyboardActionHandler keyboardActionHandler2 = onKeyboardAction2;
            final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function6 = function3;
            final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
            final Brush brush2 = cursorBrush2;
            final TextFieldDecorator textFieldDecorator2 = decorator2;
            final int i13 = textObfuscationMode2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                public final void invoke(Composer composer, int i14) {
                    BasicSecureTextFieldKt.m1151BasicSecureTextFieldi7dLibI(state, modifier4, z3, inputTransformation5, textStyle5, keyboardOptions5, keyboardActionHandler2, function6, mutableInteractionSource2, brush2, textFieldDecorator2, i13, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1085555050);
        ComposerKt.sourceInformation($composer2, "C(DisableCutCopy)294@13128L7,295@13166L680,314@13923L361,314@13851L433:BasicSecureTextField.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1085555050, $dirty, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:293)");
            }
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final TextToolbar currentToolbar = (TextToolbar) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer2, 792483480, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(currentToolbar);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new TextToolbar() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    @Override // androidx.compose.p001ui.platform.TextToolbar
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.p001ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    {
                        this.$$delegate_0 = this.$currentToolbar;
                    }

                    @Override // androidx.compose.p001ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
                        this.$currentToolbar.showMenu(rect, null, onPasteRequested, null, onSelectAllRequested);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1 copyDisabledToolbar = (BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides(copyDisabledToolbar), ComposableLambdaKt.rememberComposableLambda(-1448819882, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.1
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C315@13933L345:BasicSecureTextField.kt#423gt5");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1448819882, $changed2, -1, "androidx.compose.foundation.text.DisableCutCopy.<anonymous> (BasicSecureTextField.kt:315)");
                        }
                        Modifier modifier$iv = KeyInputModifierKt.onPreviewKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m1152invokeZmokQxo(keyEvent.m5358unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m1152invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                KeyCommand command = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1178mapZmokQxo(keyEvent);
                                return Boolean.valueOf(command == KeyCommand.COPY || command == KeyCommand.CUT);
                            }
                        });
                        Function2<Composer, Integer, Unit> function3 = function2;
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
                            function0 = constructor;
                            $composer3.createNode(function0);
                        } else {
                            function0 = constructor;
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
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 34527135, "C321@14259L9:BasicSecureTextField.kt#423gt5");
                        function3.invoke($composer3, 0);
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
            }, $composer2, 54), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.2
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
                    BasicSecureTextFieldKt.DisableCutCopy(function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
