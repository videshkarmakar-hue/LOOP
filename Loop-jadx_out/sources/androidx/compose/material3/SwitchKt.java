package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001al\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001ay\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\f\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0011X\u008a\u0084\u0002"}, m195d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release", "isPressed"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float ThumbDiameter = SwitchTokens.INSTANCE.m3621getSelectedHandleWidthD9Ej5fM();
    private static final float UncheckedThumbDiameter = SwitchTokens.INSTANCE.m3628getUnselectedHandleWidthD9Ej5fM();
    private static final float SwitchWidth = SwitchTokens.INSTANCE.m3626getTrackWidthD9Ej5fM();
    private static final float SwitchHeight = SwitchTokens.INSTANCE.m3624getTrackHeightD9Ej5fM();

    /* JADX WARN: Code duplicated, block: B:178:0x0553  */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z2, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function3;
        boolean z3;
        SwitchColors switchColorsColors;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        boolean z4;
        SwitchColors switchColors2;
        MutableInteractionSource mutableInteractionSource3;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        MutableInteractionSource mutableInteractionSource4;
        Object obj;
        Object obj2;
        Object obj3;
        boolean z5;
        Modifier.Companion companionM1119toggleableO2vRcR0;
        Function0<ComposeUiNode> function0;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Object objMutableInteractionSource;
        Composer composerStartRestartGroup = composer.startRestartGroup(1580463220);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Switch)P(!1,5,4,6,2)97@4510L8,*109@4945L7,110@5020L7,111@5080L111,116@5255L36,117@5308L24,119@5349L145,119@5338L156,124@5526L190,124@5500L216,148@6176L844:Switch.kt#uh7d8r");
        int i4 = i;
        if ((i2 & 1) != 0) {
            i4 |= 6;
        } else if ((i & 6) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 4 : 2;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i4 |= 384;
            modifier2 = modifier;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i2 & 8;
        if (i6 != 0) {
            i4 |= 3072;
            function3 = function2;
        } else if ((i & 3072) == 0) {
            function3 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function2;
        }
        int i7 = i2 & 16;
        if (i7 != 0) {
            i4 |= CpioConstants.C_ISBLK;
            z3 = z2;
        } else if ((i & CpioConstants.C_ISBLK) == 0) {
            z3 = z2;
            i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
        } else {
            z3 = z2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                switchColorsColors = switchColors;
                int i8 = composerStartRestartGroup.changed(switchColorsColors) ? 131072 : 65536;
                i4 |= i8;
            } else {
                switchColorsColors = switchColors;
            }
            i4 |= i8;
        } else {
            switchColorsColors = switchColors;
        }
        int i9 = i2 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
        } else if ((1572864 & i) == 0) {
            mutableInteractionSource2 = mutableInteractionSource;
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i4 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            z4 = z3;
            switchColors2 = switchColorsColors;
            mutableInteractionSource3 = mutableInteractionSource2;
            function5 = function3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier;
                Function2<? super Composer, ? super Integer, Unit> function6 = i6 != 0 ? null : function3;
                if (i7 != 0) {
                    z3 = true;
                }
                if ((i2 & 32) != 0) {
                    i4 &= -458753;
                    switchColorsColors = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i9 != 0) {
                    modifier3 = companion;
                    i3 = i4;
                    mutableInteractionSource3 = null;
                    z4 = z3;
                    switchColors2 = switchColorsColors;
                    function4 = function6;
                } else {
                    modifier3 = companion;
                    z4 = z3;
                    switchColors2 = switchColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i3 = i4;
                    function4 = function6;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 32) != 0) {
                    i4 &= -458753;
                }
                modifier3 = modifier;
                z4 = z3;
                switchColors2 = switchColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
                i3 = i4;
                function4 = function3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580463220, i3, -1, "androidx.compose.material3.Switch (Switch.kt:99)");
            }
            composerStartRestartGroup.startReplaceGroup(-1221650902);
            ComposerKt.sourceInformation(composerStartRestartGroup, "101@4662L39");
            if (mutableInteractionSource3 == null) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1221650881, "CC(remember):Switch.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objMutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objMutableInteractionSource);
                } else {
                    objMutableInteractionSource = objRememberedValue;
                }
                mutableInteractionSource4 = (MutableInteractionSource) objMutableInteractionSource;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            composerStartRestartGroup.endReplaceGroup();
            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
            float f = function4 == null ? UncheckedThumbDiameter : ThumbDiameter;
            float fM6801constructorimpl = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(SwitchHeight - f) / 2);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo567toPx0680j_4 = ((Density) objConsume).mo567toPx0680j_4(fM6801constructorimpl);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo567toPx0680j_5 = ((Density) objConsume2).mo567toPx0680j_4(ThumbPathLength);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1221650463, "CC(remember):Switch.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(fMo567toPx0680j_4) | composerStartRestartGroup.changed(fMo567toPx0680j_5);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Float invoke(boolean value) {
                        return Float.valueOf(value ? fMo567toPx0680j_5 : fMo567toPx0680j_4);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Float invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fFloatValue = ((Number) ((Function1) obj).invoke(Boolean.valueOf(z))).floatValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1221650288, "CC(remember):Switch.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = AnimatableKt.Animatable$default(fFloatValue, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final Animatable animatable = (Animatable) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -723523240, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1221650194, "CC(remember):Switch.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changed(fMo567toPx0680j_4);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                obj2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        Animatable.updateBounds$default(animatable, Float.valueOf(fMo567toPx0680j_4), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue5;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) obj2, composerStartRestartGroup, 0);
            Boolean boolValueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1221650017, "CC(remember):Switch.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changed(fFloatValue) | composerStartRestartGroup.changedInstance(coroutineScope);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                obj3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.SwitchKt$Switch$2$1$1 */
                    /* JADX INFO: compiled from: Switch.kt */
                    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m209c = "androidx.compose.material3.SwitchKt$Switch$2$1$1", m210f = "Switch.kt", m211i = {}, m212l = {128}, m213m = "invokeSuspend", m214n = {}, m215s = {})
                    static final class C15401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                        final /* synthetic */ float $targetValue;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C15401(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super C15401> continuation) {
                            super(2, continuation);
                            this.$offset = animatable;
                            this.$targetValue = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C15401(this.$offset, this.$targetValue, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C15401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                    Float fBoxFloat = Boxing.boxFloat(this.$targetValue);
                                    TweenSpec tweenSpec = SwitchKt.AnimationSpec;
                                    this.label = 1;
                                    if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : tweenSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    break;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        if (!(animatable.getTargetValue().floatValue() == fFloatValue)) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C15401(animatable, fFloatValue, null), 3, null);
                        }
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj3);
            } else {
                obj3 = objRememberedValue6;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(boolValueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) obj3, composerStartRestartGroup, i3 & 14);
            if (function1 != null) {
                z5 = false;
                companionM1119toggleableO2vRcR0 = ToggleableKt.m1119toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z4, Role.m6055boximpl(Role.INSTANCE.m6067getSwitcho7Vup1c()), function1);
            } else {
                z5 = false;
                companionM1119toggleableO2vRcR0 = Modifier.INSTANCE;
            }
            Modifier modifierM907requiredSizeVpY3zN4 = SizeKt.m907requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companionM1119toggleableO2vRcR0), Alignment.INSTANCE.getCenter(), z5, 2, null), SwitchWidth, SwitchHeight);
            boolean z6 = z5;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int i10 = ((z6 ? 1 : 0) << 3) & 112;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM907requiredSizeVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i11 = ((i10 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                function0 = constructor;
                composerStartRestartGroup.createNode(function0);
            } else {
                function0 = constructor;
                composerStartRestartGroup.useNode();
            }
            Composer composerM3795constructorimpl = Updater.m3795constructorimpl(composerStartRestartGroup);
            Updater.m3802setimpl(composerM3795constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl(composerM3795constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3795constructorimpl.getInserting()) {
                modifier4 = modifier3;
            } else {
                modifier4 = modifier3;
                if (!Intrinsics.areEqual(composerM3795constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3802setimpl(composerM3795constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i12 = (i11 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i13 = (((z6 ? 1 : 0) >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1873061295, "C167@6814L5,161@6567L447:Switch.kt#uh7d8r");
                m2700SwitchImpl0DmnUew(boxScopeInstance, z, z4, switchColors2, animatable.asState(), function4, mutableInteractionSource5, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), composerStartRestartGroup, 6), f, fM6801constructorimpl, ThumbPathLength, composerStartRestartGroup, (i13 & 14) | ((i3 << 3) & 112) | ((i3 >> 6) & 896) | ((i3 >> 6) & 7168) | ((i3 << 6) & 458752), 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function4;
            }
            composerM3795constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3795constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            Updater.m3802setimpl(composerM3795constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i14 = (i11 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i15 = (((z6 ? 1 : 0) >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1873061295, "C167@6814L5,161@6567L447:Switch.kt#uh7d8r");
            m2700SwitchImpl0DmnUew(boxScopeInstance2, z, z4, switchColors2, animatable.asState(), function4, mutableInteractionSource5, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), composerStartRestartGroup, 6), f, fM6801constructorimpl, ThumbPathLength, composerStartRestartGroup, (i15 & 14) | ((i3 << 3) & 112) | ((i3 >> 6) & 896) | ((i3 >> 6) & 7168) | ((i3 << 6) & 458752), 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            final boolean z7 = z4;
            final SwitchColors switchColors3 = switchColors2;
            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt.Switch.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i16) {
                    SwitchKt.Switch(z, function1, modifier5, function7, z7, switchColors3, mutableInteractionSource6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SwitchImpl-0DmnUew, reason: not valid java name */
    public static final void m2700SwitchImpl0DmnUew(final BoxScope $this$SwitchImpl_u2d0DmnUew, final boolean checked, final boolean enabled, final SwitchColors colors, final State<Float> state, final Function2<? super Composer, ? super Integer, Unit> function2, final InteractionSource interactionSource, final Shape thumbShape, final float uncheckedThumbDiameter, final float minBound, final float maxBound, Composer $composer, final int $changed, final int $changed1) {
        int $dirty1;
        int $dirty;
        float other$iv;
        final float thumbOffset;
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        Object value$iv;
        Function0<ComposeUiNode> function1;
        float arg0$iv;
        Composer $composer3 = $composer.startRestartGroup(-1968109941);
        ComposerKt.sourceInformation($composer3, "C(SwitchImpl)P(!1,2!1,8,6!1,7,9:c#ui.unit.Dp,5:c#ui.unit.Dp,4:c#ui.unit.Dp)191@7529L25,*193@7597L7,213@8230L5,225@8548L994:Switch.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty3 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed($this$SwitchImpl_u2d0DmnUew) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(checked) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(colors) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changed(state) ? 16384 : 8192;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(thumbShape) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(uncheckedThumbDiameter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changed(minBound) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty3 |= $composer3.changed(maxBound) ? 4 : 2;
        }
        if (($dirty2 & 306783379) != 306783378 || ($dirty3 & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968109941, $dirty2, $dirty3, "androidx.compose.material3.SwitchImpl (Switch.kt:189)");
            }
            $dirty1 = $dirty3;
            long trackColor = colors.m2697trackColorWaAFU9c$material3_release(enabled, checked);
            State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, $composer3, ($dirty2 >> 18) & 14);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            $dirty = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$SwitchImpl_0DmnUew_u24lambda_u249 = (Density) objConsume;
            float thumbValueDp = $this$SwitchImpl_0DmnUew_u24lambda_u249.mo563toDpu2uoSUM(state.getValue().floatValue());
            if (SwitchImpl_0DmnUew$lambda$8(stateCollectIsPressedAsState)) {
                other$iv = SwitchTokens.INSTANCE.m3619getPressedHandleWidthD9Ej5fM();
            } else {
                float arg0$iv2 = ThumbDiameter;
                float arg0$iv3 = C1979Dp.m6801constructorimpl(arg0$iv2 - uncheckedThumbDiameter);
                float arg0$iv4 = C1979Dp.m6801constructorimpl(thumbValueDp - minBound);
                float other$iv2 = C1979Dp.m6801constructorimpl(maxBound - minBound);
                other$iv = C1979Dp.m6801constructorimpl(uncheckedThumbDiameter + C1979Dp.m6801constructorimpl(arg0$iv3 * (arg0$iv4 / other$iv2)));
            }
            $composer3.startReplaceGroup(-993794016);
            ComposerKt.sourceInformation($composer3, "*202@7938L7");
            if (SwitchImpl_0DmnUew$lambda$8(stateCollectIsPressedAsState)) {
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$SwitchImpl_0DmnUew_u24lambda_u2410 = (Density) objConsume2;
                if (checked) {
                    float arg0$iv5 = ThumbPathLength;
                    float other$iv3 = SwitchTokens.INSTANCE.m3625getTrackOutlineWidthD9Ej5fM();
                    arg0$iv = C1979Dp.m6801constructorimpl(arg0$iv5 - other$iv3);
                } else {
                    arg0$iv = SwitchTokens.INSTANCE.m3625getTrackOutlineWidthD9Ej5fM();
                }
                thumbOffset = $this$SwitchImpl_0DmnUew_u24lambda_u2410.mo567toPx0680j_4(arg0$iv);
            } else {
                thumbOffset = state.getValue().floatValue();
            }
            $composer3.endReplaceGroup();
            Shape trackShape = ShapesKt.getValue(SwitchTokens.INSTANCE.getTrackShape(), $composer3, 6);
            Modifier modifier = BackgroundKt.m453backgroundbw27NRU(BorderKt.m465borderxT4_qwU(SizeKt.m899height3ABfNKs(SizeKt.m918width3ABfNKs($this$SwitchImpl_u2d0DmnUew.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), SwitchWidth), SwitchHeight), SwitchTokens.INSTANCE.m3625getTrackOutlineWidthD9Ej5fM(), colors.m2677borderColorWaAFU9c$material3_release(enabled, checked), trackShape), trackColor, trackShape);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier);
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
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SwitchImpl_0DmnUew_u24lambda_u2413 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1420969830, "C230@8748L42,233@8912L150,227@8641L895:Switch.kt#uh7d8r");
            long resolvedThumbColor = colors.m2696thumbColorWaAFU9c$material3_release(enabled, checked);
            $composer2 = $composer3;
            Modifier modifierAlign = $this$SwitchImpl_0DmnUew_u24lambda_u2413.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer3, 1420970006, "CC(remember):Switch.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(thumbOffset);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m6924boximpl(m2702invokeBjo55l4(density));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m2702invokeBjo55l4(Density $this$offset) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(thumbOffset), 0);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierOffset = OffsetKt.offset(modifierAlign, (Function1) value$iv);
            float arg0$iv6 = SwitchTokens.INSTANCE.m3623getStateLayerSizeD9Ej5fM();
            float thumbOffset2 = 2;
            Modifier modifier$iv = BackgroundKt.m453backgroundbw27NRU(SizeKt.m905requiredSize3ABfNKs(IndicationKt.indication(modifierOffset, interactionSource, RippleKt.m2529rippleOrFallbackImplementation9IZ8Weo(false, C1979Dp.m6801constructorimpl(arg0$iv6 / thumbOffset2), 0L, $composer3, 54, 4)), other$iv), resolvedThumbColor, thumbShape);
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function1 = constructor2;
                $composer3.createNode(function1);
            } else {
                function1 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2040677068, "C:Switch.kt#uh7d8r");
            $composer3.startReplaceGroup(1420970515);
            ComposerKt.sourceInformation($composer3, "244@9368L144");
            if (function2 != null) {
                long iconColor = colors.m2695iconColorWaAFU9c$material3_release(enabled, checked);
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(iconColor)), function2, $composer3, ProvidedValue.$stable | (($dirty >> 12) & 112));
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $dirty = $dirty2;
            $dirty1 = $dirty3;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$2
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

                public final void invoke(Composer composer, int i5) {
                    SwitchKt.m2700SwitchImpl0DmnUew($this$SwitchImpl_u2d0DmnUew, checked, enabled, colors, state, function2, interactionSource, thumbShape, uncheckedThumbDiameter, minBound, maxBound, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    private static final boolean SwitchImpl_0DmnUew$lambda$8(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    static {
        float arg0$iv = SwitchHeight;
        float other$iv = ThumbDiameter;
        ThumbPadding = C1979Dp.m6801constructorimpl(C1979Dp.m6801constructorimpl(arg0$iv - other$iv) / 2);
        float arg0$iv2 = SwitchWidth;
        float other$iv2 = ThumbDiameter;
        float arg0$iv3 = C1979Dp.m6801constructorimpl(arg0$iv2 - other$iv2);
        float other$iv3 = ThumbPadding;
        ThumbPathLength = C1979Dp.m6801constructorimpl(arg0$iv3 - other$iv3);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
