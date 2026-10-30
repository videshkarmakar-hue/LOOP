package androidx.compose.material;

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
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FloatCompanionObject;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J²\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\bX\u008a\u0084\u0002"}, m195d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:114:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:117:0x0333  */
    /* JADX WARN: Code duplicated, block: B:120:0x0344  */
    /* JADX WARN: Code duplicated, block: B:121:0x0347  */
    /* JADX WARN: Code duplicated, block: B:124:0x034f  */
    /* JADX WARN: Code duplicated, block: B:127:0x036f  */
    /* JADX WARN: Code duplicated, block: B:131:0x037c  */
    /* JADX WARN: Code duplicated, block: B:134:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:137:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:138:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:141:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:144:0x0414  */
    /* JADX WARN: Code duplicated, block: B:147:0x0423  */
    /* JADX WARN: Code duplicated, block: B:148:0x0426  */
    /* JADX WARN: Code duplicated, block: B:151:0x042e  */
    /* JADX WARN: Code duplicated, block: B:154:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:158:0x04c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:162:0x058f  */
    /* JADX INFO: renamed from: Transition-DTcfvLk, reason: not valid java name */
    public final void m1868TransitionDTcfvLk(final InputPhase inputState, final long focusedTextStyleColor, final long unfocusedTextStyleColor, final Function3<? super InputPhase, ? super Composer, ? super Integer, Color> function3, final boolean showLabel, final Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> function6, Composer $composer, final int $changed) {
        float f;
        float f2;
        int i;
        float f3;
        int $changed2;
        InputPhase it;
        long j;
        ColorSpace colorSpace$iv;
        boolean invalid$iv$iv;
        Object value$iv$iv;
        int $changed3;
        InputPhase it2;
        long j2;
        int $changed4;
        InputPhase it3;
        long j3;
        boolean invalid$iv$iv2;
        Object value$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(1988729962);
        ComposerKt.sourceInformation($composer2, "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)270@10987L59,272@11088L325,283@11460L1101,311@12609L299,321@12954L186,327@13150L140:TextFieldImpl.kt#jmzs0o");
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
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changed(showLabel) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function6) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1988729962, $dirty2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:266)");
            }
            Transition transition = TransitionKt.updateTransition(inputState, "TextFieldInputState", $composer2, ($dirty2 & 14) | 48, 0);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed5) {
                    $composer3.startReplaceGroup(-611722692);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611722692, $changed5, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:274)");
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
            int $changed$iv$iv = ((384 << 3) & 57344) | (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168);
            ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
            int $changed5 = ($changed$iv$iv >> 9) & 112;
            InputPhase it4 = (InputPhase) transition.getCurrentState();
            $composer2.startReplaceGroup(-1158004136);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158004136, $changed5, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:276)");
            }
            float f4 = 0.0f;
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
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
            int $changed6 = ($changed$iv$iv >> 9) & 112;
            InputPhase it5 = (InputPhase) transition.getTargetState();
            $composer2.startReplaceGroup(-1158004136);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158004136, $changed6, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:276)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it5.ordinal()]) {
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
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "LabelProgress", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed7) {
                    TweenSpec tweenSpecTween;
                    $composer3.startReplaceGroup(-1079955085);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1079955085, $changed7, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:286)");
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
            int $changed7 = ($changed$iv$iv2 >> 9) & 112;
            InputPhase it6 = (InputPhase) transition.getCurrentState();
            $composer2.startReplaceGroup(-1376159017);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                i = -1;
                ComposerKt.traceEventStart(-1376159017, $changed7, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:304)");
            } else {
                i = -1;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it6.ordinal()]) {
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
            int $changed8 = ($changed$iv$iv2 >> 9) & 112;
            InputPhase it7 = (InputPhase) transition.getTargetState();
            $composer2.startReplaceGroup(-1376159017);
            ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1376159017, $changed8, i, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:304)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it7.ordinal()]) {
                case 1:
                    f4 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object targetValue$iv$iv2 = Float.valueOf(f4);
                    State placeholderOpacity$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "PlaceholderOpacity", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function3 transitionSpec$iv3 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed9) {
                            $composer3.startReplaceGroup(-130058045);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-130058045, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
                    $changed2 = (384 >> 6) & 112;
                    it = (InputPhase) transition.getTargetState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed2, i, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it.ordinal()] == 1) {
                        j = focusedTextStyleColor;
                    } else {
                        j = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    colorSpace$iv = Color.m4295getColorSpaceimpl(j);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv = $composer2.changed(colorSpace$iv);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (!invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    TwoWayConverter typeConverter$iv = (TwoWayConverter) value$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv$iv3 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                    ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                    $changed3 = ($changed$iv$iv3 >> 9) & 112;
                    it2 = (InputPhase) transition.getCurrentState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed3, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()] == 1) {
                        j2 = focusedTextStyleColor;
                    } else {
                        j2 = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object initialValue$iv$iv3 = Color.m4281boximpl(j2);
                    $changed4 = ($changed$iv$iv3 >> 9) & 112;
                    it3 = (InputPhase) transition.getTargetState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed4, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()] == 1) {
                        j3 = focusedTextStyleColor;
                    } else {
                        j3 = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object targetValue$iv$iv3 = Color.m4281boximpl(j3);
                    State labelTextStyleColor$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv3, targetValue$iv$iv3, transitionSpec$iv3.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv3 >> 3) & 112)), typeConverter$iv, "LabelTextStyleColor", $composer2, ($changed$iv$iv3 & 14) | (($changed$iv$iv3 << 9) & 57344) | (($changed$iv$iv3 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function3 transitionSpec$iv4 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed9) {
                            $composer3.startReplaceGroup(-32667848);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                            }
                            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceGroup();
                            return tweenSpecTween$default;
                        }
                    };
                    int $changed$iv = ($dirty2 & 7168) | 384;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    ColorSpace colorSpace$iv2 = Color.m4295getColorSpaceimpl(function3.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv >> 6) & 112)).m4301unboximpl());
                    ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv2 = $composer2.changed(colorSpace$iv2);
                    Object it$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv2);
                        $composer2.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv2;
                    }
                    TwoWayConverter typeConverter$iv2 = (TwoWayConverter) value$iv$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv$iv4 = ($changed$iv & 14) | (($changed$iv << 3) & 896) | (($changed$iv << 3) & 7168) | (($changed$iv << 3) & 57344);
                    ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                    Object initialValue$iv$iv4 = function3.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv4 >> 9) & 112));
                    Object targetValue$iv$iv4 = function3.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv4 >> 9) & 112));
                    State labelContentColor$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv4, targetValue$iv$iv4, transitionSpec$iv4.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv4 >> 3) & 112)), typeConverter$iv2, "LabelContentColor", $composer2, ($changed$iv$iv4 & 14) | (($changed$iv$iv4 << 9) & 57344) | (($changed$iv$iv4 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation)), Color.m4281boximpl(Transition_DTcfvLk$lambda$5(labelTextStyleColor$delegate)), Color.m4281boximpl(Transition_DTcfvLk$lambda$6(labelContentColor$delegate)), Float.valueOf(Transition_DTcfvLk$lambda$3(placeholderOpacity$delegate)), $composer2, Integer.valueOf(($dirty2 >> 3) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    break;
                case 2:
                    if (!showLabel) {
                        f4 = 1.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object targetValue$iv$iv5 = Float.valueOf(f4);
                    State placeholderOpacity$delegate2 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv5, transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "PlaceholderOpacity", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function3 transitionSpec$iv5 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed9) {
                            $composer3.startReplaceGroup(-130058045);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-130058045, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
                    $changed2 = (384 >> 6) & 112;
                    it = (InputPhase) transition.getTargetState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed2, i, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it.ordinal()] == 1) {
                        j = focusedTextStyleColor;
                    } else {
                        j = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    colorSpace$iv = Color.m4295getColorSpaceimpl(j);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv = $composer2.changed(colorSpace$iv);
                    Object it$iv$iv3 = $composer2.rememberedValue();
                    if (invalid$iv$iv) {
                        value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                        $composer2.updateRememberedValue(value$iv$iv);
                    }
                    TwoWayConverter typeConverter$iv3 = (TwoWayConverter) value$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv$iv5 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                    ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                    $changed3 = ($changed$iv$iv5 >> 9) & 112;
                    it2 = (InputPhase) transition.getCurrentState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed3, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()] == 1) {
                        j2 = focusedTextStyleColor;
                    } else {
                        j2 = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object initialValue$iv$iv5 = Color.m4281boximpl(j2);
                    $changed4 = ($changed$iv$iv5 >> 9) & 112;
                    it3 = (InputPhase) transition.getTargetState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed4, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()] == 1) {
                        j3 = focusedTextStyleColor;
                    } else {
                        j3 = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object targetValue$iv$iv6 = Color.m4281boximpl(j3);
                    State labelTextStyleColor$delegate2 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv5, targetValue$iv$iv6, transitionSpec$iv5.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv5 >> 3) & 112)), typeConverter$iv3, "LabelTextStyleColor", $composer2, ($changed$iv$iv5 & 14) | (($changed$iv$iv5 << 9) & 57344) | (($changed$iv$iv5 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function3 transitionSpec$iv6 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed9) {
                            $composer3.startReplaceGroup(-32667848);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                            }
                            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceGroup();
                            return tweenSpecTween$default;
                        }
                    };
                    int $changed$iv2 = ($dirty2 & 7168) | 384;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    ColorSpace colorSpace$iv3 = Color.m4295getColorSpaceimpl(function3.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv2 >> 6) & 112)).m4301unboximpl());
                    ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv2 = $composer2.changed(colorSpace$iv3);
                    Object it$iv$iv4 = $composer2.rememberedValue();
                    if (invalid$iv$iv2) {
                        break;
                    }
                    value$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv3);
                    $composer2.updateRememberedValue(value$iv$iv2);
                    TwoWayConverter typeConverter$iv4 = (TwoWayConverter) value$iv$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv$iv6 = ($changed$iv2 & 14) | (($changed$iv2 << 3) & 896) | (($changed$iv2 << 3) & 7168) | (($changed$iv2 << 3) & 57344);
                    ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                    Object initialValue$iv$iv6 = function3.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv6 >> 9) & 112));
                    Object targetValue$iv$iv7 = function3.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv6 >> 9) & 112));
                    State labelContentColor$delegate2 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv6, targetValue$iv$iv7, transitionSpec$iv6.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv6 >> 3) & 112)), typeConverter$iv4, "LabelContentColor", $composer2, ($changed$iv$iv6 & 14) | (($changed$iv$iv6 << 9) & 57344) | (($changed$iv$iv6 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation)), Color.m4281boximpl(Transition_DTcfvLk$lambda$5(labelTextStyleColor$delegate2)), Color.m4281boximpl(Transition_DTcfvLk$lambda$6(labelContentColor$delegate2)), Float.valueOf(Transition_DTcfvLk$lambda$3(placeholderOpacity$delegate2)), $composer2, Integer.valueOf(($dirty2 >> 3) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    break;
                case 3:
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object targetValue$iv$iv8 = Float.valueOf(f4);
                    State placeholderOpacity$delegate3 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv8, transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112)), vectorConverter2, "PlaceholderOpacity", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function3 transitionSpec$iv7 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed9) {
                            $composer3.startReplaceGroup(-130058045);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-130058045, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:312)");
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
                    $changed2 = (384 >> 6) & 112;
                    it = (InputPhase) transition.getTargetState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed2, i, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it.ordinal()] == 1) {
                        j = focusedTextStyleColor;
                    } else {
                        j = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    colorSpace$iv = Color.m4295getColorSpaceimpl(j);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv = $composer2.changed(colorSpace$iv);
                    Object it$iv$iv5 = $composer2.rememberedValue();
                    if (invalid$iv$iv) {
                        value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                        $composer2.updateRememberedValue(value$iv$iv);
                    }
                    TwoWayConverter typeConverter$iv5 = (TwoWayConverter) value$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv$iv7 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                    ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                    $changed3 = ($changed$iv$iv7 >> 9) & 112;
                    it2 = (InputPhase) transition.getCurrentState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed3, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()] == 1) {
                        j2 = focusedTextStyleColor;
                    } else {
                        j2 = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object initialValue$iv$iv7 = Color.m4281boximpl(j2);
                    $changed4 = ($changed$iv$iv7 >> 9) & 112;
                    it3 = (InputPhase) transition.getTargetState();
                    $composer2.startReplaceGroup(-1490209928);
                    ComposerKt.sourceInformation($composer2, "C:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490209928, $changed4, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:315)");
                    }
                    if (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()] == 1) {
                        j3 = focusedTextStyleColor;
                    } else {
                        j3 = unfocusedTextStyleColor;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    Object targetValue$iv$iv9 = Color.m4281boximpl(j3);
                    State labelTextStyleColor$delegate3 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv7, targetValue$iv$iv9, transitionSpec$iv7.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv7 >> 3) & 112)), typeConverter$iv5, "LabelTextStyleColor", $composer2, ($changed$iv$iv7 & 14) | (($changed$iv$iv7 << 9) & 57344) | (($changed$iv$iv7 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Function3 transitionSpec$iv8 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
                            return invoke(segment, composer, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer $composer3, int $changed9) {
                            $composer3.startReplaceGroup(-32667848);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-32667848, $changed9, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:322)");
                            }
                            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            $composer3.endReplaceGroup();
                            return tweenSpecTween$default;
                        }
                    };
                    int $changed$iv3 = ($dirty2 & 7168) | 384;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                    ColorSpace colorSpace$iv4 = Color.m4295getColorSpaceimpl(function3.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv3 >> 6) & 112)).m4301unboximpl());
                    ComposerKt.sourceInformationMarkerStart($composer2, -1462136630, "CC(remember):Transition.kt#9igjgp");
                    invalid$iv$iv2 = $composer2.changed(colorSpace$iv4);
                    Object it$iv$iv6 = $composer2.rememberedValue();
                    if (invalid$iv$iv2) {
                        break;
                    }
                    value$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv4);
                    $composer2.updateRememberedValue(value$iv$iv2);
                    TwoWayConverter typeConverter$iv6 = (TwoWayConverter) value$iv$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int $changed$iv$iv8 = ($changed$iv3 & 14) | (($changed$iv3 << 3) & 896) | (($changed$iv3 << 3) & 7168) | (($changed$iv3 << 3) & 57344);
                    ComposerKt.sourceInformationMarkerStart($composer2, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
                    Object initialValue$iv$iv8 = function3.invoke(transition.getCurrentState(), $composer2, Integer.valueOf(($changed$iv$iv8 >> 9) & 112));
                    Object targetValue$iv$iv10 = function3.invoke(transition.getTargetState(), $composer2, Integer.valueOf(($changed$iv$iv8 >> 9) & 112));
                    State labelContentColor$delegate3 = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv8, targetValue$iv$iv10, transitionSpec$iv8.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv8 >> 3) & 112)), typeConverter$iv6, "LabelContentColor", $composer2, ($changed$iv$iv8 & 14) | (($changed$iv$iv8 << 9) & 57344) | (($changed$iv$iv8 << 6) & 458752));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    function6.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(stateCreateTransitionAnimation)), Color.m4281boximpl(Transition_DTcfvLk$lambda$5(labelTextStyleColor$delegate3)), Color.m4281boximpl(Transition_DTcfvLk$lambda$6(labelContentColor$delegate3)), Float.valueOf(Transition_DTcfvLk$lambda$3(placeholderOpacity$delegate3)), $composer2, Integer.valueOf(($dirty2 >> 3) & 57344));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldTransitionScope$Transition$1
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

                public final void invoke(Composer composer, int i2) {
                    this.$tmp0_rcvr.m1868TransitionDTcfvLk(inputState, focusedTextStyleColor, unfocusedTextStyleColor, function3, showLabel, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m4301unboximpl();
    }
}
