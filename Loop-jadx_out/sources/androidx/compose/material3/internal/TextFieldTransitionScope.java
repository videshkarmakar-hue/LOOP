package androidx.compose.material3.internal;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.colorspace.ColorSpace;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FloatCompanionObject;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J¶\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2z\u0010\r\u001av\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a²\u0006\n\u0010\u0012\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\bX\u008a\u0084\u0002"}, m195d2 = {"Landroidx/compose/material3/internal/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "showLabel", "", "content", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "Landroidx/compose/runtime/Composable;", "Transition-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* JADX INFO: compiled from: TextFieldImpl.kt */
    @Metadata(m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX INFO: renamed from: Transition-Jy8F4Js, reason: not valid java name */
    public final void m3091TransitionJy8F4Js(final InputPhase inputState, final long focusedTextStyleColor, final long unfocusedTextStyleColor, final long contentColor, final boolean showLabel, final Function7<? super Float, ? super Color, ? super Color, ? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function7, Composer $composer, final int $changed) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(1729601997);
        ComposerKt.sourceInformation($composer2, "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,4)317@12881L59,319@12982L325,330@13354L1101,358@14503L354,369@14905L299,380@15308L190,386@15508L174:TextFieldImpl.kt#mqatfk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(inputState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(focusedTextStyleColor) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(unfocusedTextStyleColor) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(showLabel) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function7) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1729601997, $dirty, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition (TextFieldImpl.kt:313)");
            }
            Transition transition = TransitionKt.updateTransition(inputState, "TextFieldInputState", $composer2, ($dirty & 14) | 48, 0);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldTransitionScope$Transition$labelProgress$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed2) {
                    $composer3.startReplaceGroup(1293072927);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1293072927, $changed2, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:321)");
                    }
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecTween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = ((384 << 3) & 896) | (384 & 14) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            InputPhase it = (InputPhase) transition.getCurrentState();
            $composer2.startReplaceGroup(700685627);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(700685627, $changed2, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:323)");
            }
            float f6 = 0.0f;
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
            InputPhase it2 = (InputPhase) transition.getTargetState();
            $composer2.startReplaceGroup(700685627);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(700685627, $changed3, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:323)");
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
            State labelProgress$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "LabelProgress", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldTransitionScope$Transition$placeholderOpacity$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed4) {
                    TweenSpec tweenSpecTween;
                    $composer3.startReplaceGroup(528714774);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(528714774, $changed4, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:333)");
                    }
                    if (segment.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
                        tweenSpecTween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                    } else if (segment.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
                        tweenSpecTween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                    } else {
                        tweenSpecTween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecTween;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            InputPhase it3 = (InputPhase) transition.getCurrentState();
            $composer2.startReplaceGroup(1018182266);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1018182266, $changed4, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:351)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f3 = 1.0f;
                    break;
                case 2:
                    f3 = !showLabel ? 1.0f : 0.0f;
                    break;
                case 3:
                    f3 = 0.0f;
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
            InputPhase it4 = (InputPhase) transition.getTargetState();
            $composer2.startReplaceGroup(1018182266);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1018182266, $changed5, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:351)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
                case 1:
                    f4 = 1.0f;
                    break;
                case 2:
                    f4 = !showLabel ? 1.0f : 0.0f;
                    break;
                case 3:
                    f4 = 0.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv2 = Float.valueOf(f4);
            State placeholderOpacity$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "PlaceholderOpacity", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv3 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed6) {
                    $composer3.startReplaceGroup(952760952);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(952760952, $changed6, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:360)");
                    }
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecTween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv3 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed6 = ($changed$iv$iv3 >> 9) & 112;
            InputPhase it5 = (InputPhase) transition.getCurrentState();
            $composer2.startReplaceGroup(-1053615980);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1053615980, $changed6, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:362)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it5.ordinal()]) {
                case 1:
                    f5 = 1.0f;
                    break;
                case 2:
                    f5 = !showLabel ? 1.0f : 0.0f;
                    break;
                case 3:
                    f5 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv3 = Float.valueOf(f5);
            int $changed7 = ($changed$iv$iv3 >> 9) & 112;
            InputPhase it6 = (InputPhase) transition.getTargetState();
            $composer2.startReplaceGroup(-1053615980);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1053615980, $changed7, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:362)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it6.ordinal()]) {
                case 1:
                    f6 = 1.0f;
                    break;
                case 2:
                    if (!showLabel) {
                        f6 = 1.0f;
                    }
                    break;
                case 3:
                    f6 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv3 = Float.valueOf(f6);
            State prefixSuffixOpacity$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv3, targetValue$iv$iv3, transitionSpec$iv3.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv3 >> 3) & 112)), vectorConverter3, "PrefixSuffixOpacity", $composer2, ($changed$iv$iv3 & 14) | (($changed$iv$iv3 << 9) & 57344) | (($changed$iv$iv3 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv4 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed8) {
                    $composer3.startReplaceGroup(1275271014);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1275271014, $changed8, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:370)");
                    }
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecTween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            int $changed8 = (384 >> 6) & 112;
            InputPhase it7 = (InputPhase) transition.getTargetState();
            $composer2.startReplaceGroup(50673243);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(50673243, $changed8, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:373)");
            }
            long j = WhenMappings.$EnumSwitchMapping$0[it7.ordinal()] == 1 ? focusedTextStyleColor : unfocusedTextStyleColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            ColorSpace colorSpace$iv = Color.m4295getColorSpaceimpl(j);
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
            int $changed$iv$iv4 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed9 = ($changed$iv$iv4 >> 9) & 112;
            InputPhase it8 = (InputPhase) transition.getCurrentState();
            $composer2.startReplaceGroup(50673243);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(50673243, $changed9, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:373)");
            }
            long j2 = WhenMappings.$EnumSwitchMapping$0[it8.ordinal()] == 1 ? focusedTextStyleColor : unfocusedTextStyleColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv4 = Color.m4281boximpl(j2);
            int $changed10 = ($changed$iv$iv4 >> 9) & 112;
            InputPhase it9 = (InputPhase) transition.getTargetState();
            $composer2.startReplaceGroup(50673243);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(50673243, $changed10, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:373)");
            }
            long j3 = WhenMappings.$EnumSwitchMapping$0[it9.ordinal()] == 1 ? focusedTextStyleColor : unfocusedTextStyleColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv4 = Color.m4281boximpl(j3);
            State labelTextStyleColor$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv4, targetValue$iv$iv4, transitionSpec$iv4.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv4 >> 3) & 112)), typeConverter$iv, "LabelTextStyleColor", $composer2, ($changed$iv$iv4 & 14) | (($changed$iv$iv4 << 9) & 57344) | (($changed$iv$iv4 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv5 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldTransitionScope$Transition$labelContentColor$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed11) {
                    $composer3.startReplaceGroup(63420955);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(63420955, $changed11, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:381)");
                    }
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceGroup();
                    return tweenSpecTween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            int $changed11 = (384 >> 6) & 112;
            $composer2.startReplaceGroup(-1153494448);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153494448, $changed11, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:383)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            ColorSpace colorSpace$iv2 = Color.m4295getColorSpaceimpl(contentColor);
            ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(colorSpace$iv2);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv2);
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            TwoWayConverter typeConverter$iv2 = (TwoWayConverter) value$iv$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv$iv5 = ((384 << 3) & 57344) | (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed12 = ($changed$iv$iv5 >> 9) & 112;
            $composer2.startReplaceGroup(-1153494448);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153494448, $changed12, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:383)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv5 = Color.m4281boximpl(contentColor);
            int $changed13 = ($changed$iv$iv5 >> 9) & 112;
            $composer2.startReplaceGroup(-1153494448);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153494448, $changed13, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:383)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv5 = Color.m4281boximpl(contentColor);
            State labelContentColor$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv5, targetValue$iv$iv5, transitionSpec$iv5.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv5 >> 3) & 112)), typeConverter$iv2, "LabelContentColor", $composer2, ($changed$iv$iv5 & 14) | (($changed$iv$iv5 << 9) & 57344) | (($changed$iv$iv5 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            function7.invoke(Float.valueOf(Transition_Jy8F4Js$lambda$1(labelProgress$delegate)), Color.m4281boximpl(Transition_Jy8F4Js$lambda$7(labelTextStyleColor$delegate)), Color.m4281boximpl(Transition_Jy8F4Js$lambda$9(labelContentColor$delegate)), Float.valueOf(Transition_Jy8F4Js$lambda$3(placeholderOpacity$delegate)), Float.valueOf(Transition_Jy8F4Js$lambda$5(prefixSuffixOpacity$delegate)), $composer2, Integer.valueOf($dirty & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldTransitionScope$Transition$1
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
                    this.$tmp0_rcvr.m3091TransitionJy8F4Js(inputState, focusedTextStyleColor, unfocusedTextStyleColor, contentColor, showLabel, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final float Transition_Jy8F4Js$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float Transition_Jy8F4Js$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float Transition_Jy8F4Js$lambda$5(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final long Transition_Jy8F4Js$lambda$7(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    private static final long Transition_Jy8F4Js$lambda$9(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }
}
