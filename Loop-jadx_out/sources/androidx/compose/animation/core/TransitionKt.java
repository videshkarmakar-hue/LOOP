package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.p001ui.geometry.Offset;
import androidx.compose.p001ui.geometry.Rect;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0015\u001a\u0002H\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0016\u001a3\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0082\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b0\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a\u0082\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a\u0082\u0001\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a\u0082\u0001\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020*0\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a\u0082\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020,0\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a\u0082\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020.0\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a\u0082\u0001\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002000\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a\u0082\u0001\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001a\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u0002H\u001c0\r2*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002020\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010&\u001a¦\u0001\u00103\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u001a\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u000e\"\b\b\u0002\u00104*\u000205*\b\u0012\u0004\u0012\u0002H\u001c0\r2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H4072*\b\n\u0010\u001d\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u001f0\t¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010\"\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u000e0\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u00108\u001a\\\u00109\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u001c0\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122&\u0010:\u001a\"\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002H\u000e0\t¢\u0006\u0002\b H\u0087\b¢\u0006\u0002\u0010<\u001aA\u0010=\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u001c0\r2\u0006\u0010>\u001a\u0002H\u000e2\u0006\u0010\u0015\u001a\u0002H\u000e2\u0006\u0010?\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010@\u001aa\u0010A\u001a\u0018\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H40BR\b\u0012\u0004\u0012\u0002H\u001c0\r\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u000e\"\b\b\u0002\u00104*\u000205*\b\u0012\u0004\u0012\u0002H\u001c0\r2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H4072\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010C\u001am\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u001a\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u000e\"\b\b\u0002\u00104*\u000205*\b\u0012\u0004\u0012\u0002H\u001c0\r2\u0006\u0010E\u001a\u0002H\u000e2\u0006\u0010F\u001a\u0002H\u000e2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u001f2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H4072\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010H\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m195d2 = {"AnimationDebugDurationScale", "", "NoReset", "", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "ResetNoSnap", "SeekableTransitionStateTotalDurationChanged", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", "", "rememberTransition", "Landroidx/compose/animation/core/Transition;", ExifInterface.GPS_DIRECTION_TRUE, "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "updateTransition", "targetState", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", ExifInterface.LATITUDE_SOUTH, "transitionSpec", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;
    private static final float NoReset = -1.0f;
    private static final float ResetAnimationSnap = -3.0f;
    private static final float ResetAnimationSnapCurrent = -4.0f;
    private static final float ResetAnimationSnapTarget = -5.0f;
    private static final float ResetNoSnap = -2.0f;
    private static final Function1<SeekableTransitionState<?>, Unit> SeekableTransitionStateTotalDurationChanged = new Function1<SeekableTransitionState<?>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableTransitionStateTotalDurationChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SeekableTransitionState<?> seekableTransitionState) {
            invoke2(seekableTransitionState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SeekableTransitionState<?> seekableTransitionState) {
            seekableTransitionState.onTotalDurationChanged$animation_core_release();
        }
    };

    public static final <T> Transition<T> updateTransition(T t, String label, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, 2029166765, "C(updateTransition)P(1)89@3711L51,90@3778L22,91@3834L190,91@3805L219:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:88)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1641300381, "CC(remember):Transition.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Transition(t, label);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final Transition<T> transition = (Transition) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        transition.animateTo$animation_core_release(t, $composer, ($changed & 8) | 48 | ($changed & 14));
        ComposerKt.sourceInformationMarkerStart($composer, 1641300504, "CC(remember):Transition.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv2, $composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return transition;
    }

    public static final <T> Transition<T> rememberTransition(TransitionState<T> transitionState, String label, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        ComposerKt.sourceInformationMarkerStart($composer, 1643203617, "C(rememberTransition)P(1)804@33574L94:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1643203617, $changed, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:803)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 573136640, "CC(remember):Transition.kt#9igjgp");
        boolean z = true;
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(transitionState)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Transition((TransitionState) transitionState, label);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final Transition<T> transition = (Transition) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (transitionState instanceof SeekableTransitionState) {
            $composer.startReplaceGroup(573136797);
            ComposerKt.sourceInformation($composer, "808@33805L382,808@33731L456");
            T currentState = transitionState.getCurrentState();
            T targetState = transitionState.getTargetState();
            ComposerKt.sourceInformationMarkerStart($composer, 573136871, "CC(remember):Transition.kt#9igjgp");
            if (((($changed & 14) ^ 6) <= 4 || !$composer.changed(transitionState)) && ($changed & 6) != 4) {
                z = false;
            }
            boolean invalid$iv2 = z;
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new TransitionKt$rememberTransition$1$1(transitionState, null);
                $composer.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(currentState, targetState, (Function2) value$iv3, $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(573137286);
            ComposerKt.sourceInformation($composer, "817@34220L38,818@34296L214,818@34267L243");
            transition.animateTo$animation_core_release(transitionState.getTargetState(), $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 573137362, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed(transition);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        final Transition<T> transition2 = transition;
                        return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                transition2.onDisposed$animation_core_release();
                            }
                        };
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv2, $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return transition;
    }

    @Deprecated(message = "Use rememberTransition() instead", replaceWith = @ReplaceWith(expression = "rememberTransition(transitionState, label)", imports = {}))
    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> mutableTransitionState, String label, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 882913843, "C(updateTransition)P(1)858@35973L32:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:856)");
        }
        MutableTransitionState<T> state = mutableTransitionState;
        Transition<T> transitionRememberTransition = rememberTransition(state, label, $composer, ($changed & 14) | ($changed & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return transitionRememberTransition;
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(final Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, String label, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, -1714122528, "C(createDeferredAnimation)P(1)1754@71428L58,1755@71518L75,1755@71491L102:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, $changed, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1753)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -44462721, "CC(remember):Transition.kt#9igjgp");
        boolean z = true;
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = transition.new DeferredAnimation(twoWayConverter, label);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -44462631, "CC(remember):Transition.kt#9igjgp");
        if (((($changed & 14) ^ 6) <= 4 || !$composer.changed(transition)) && ($changed & 6) != 4) {
            z = false;
        }
        boolean invalid$iv2 = $composer.changedInstance(deferredAnimation) | z;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    final Transition<S> transition2 = transition;
                    final Transition<S>.DeferredAnimation<T, V> deferredAnimation2 = deferredAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.removeAnimation$animation_core_release(deferredAnimation2);
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv2, $composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return deferredAnimation;
    }

    public static final <S, T> Transition<T> createChildTransition(Transition<S> transition, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> function3, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1215497572, "CC(createChildTransition)1787@72932L36,1788@72992L74,1789@73089L39,1790@73140L63:Transition.kt#pdpnli");
        boolean z = true;
        if ((i & 1) != 0) {
            label = "ChildTransition";
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1117150131, "CC(remember):Transition.kt#9igjgp");
        if (((($changed & 14) ^ 6) <= 4 || !$composer.changed(transition)) && ($changed & 6) != 4) {
            z = false;
        }
        boolean invalid$iv = z;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = transition.getCurrentState();
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object initialParentState = value$iv;
        Object initialState = function3.invoke(transition.isSeeking() ? transition.getCurrentState() : initialParentState, $composer, Integer.valueOf(($changed >> 3) & 112));
        Object targetState = function3.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed >> 3) & 112));
        Transition<T> transitionCreateChildTransitionInternal = createChildTransitionInternal(transition, initialState, targetState, label, $composer, ($changed & 14) | (($changed << 6) & 7168));
        ComposerKt.sourceInformationMarkerEnd($composer);
        return transitionCreateChildTransitionInternal;
    }

    public static final <S, T> Transition<T> createChildTransitionInternal(final Transition<S> transition, T t, T t2, String childLabel, Composer $composer, int $changed) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, -198307638, "C(createChildTransitionInternal)P(1,2)1800@73403L116,1804@73554L112,1804@73525L141:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, $changed, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1799)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -382120115, "CC(remember):Transition.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Transition(new MutableTransitionState(t), transition, transition.getLabel() + " > " + childLabel);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        final Transition<T> transition2 = (Transition) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -382119964, "CC(remember):Transition.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(transition2) | (((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) || ($changed & 6) == 4);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    transition.addTransition$animation_core_release(transition2);
                    final Transition<S> transition3 = transition;
                    final Transition<T> transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition3.removeTransition$animation_core_release(transition4);
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv2, $composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos());
        } else {
            transition2.updateTarget$animation_core_release(t2);
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return transition2;
    }

    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> function4, Composer $composer, int $changed, int i) {
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function5;
        String label2;
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            function5 = new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<T>>() { // from class: androidx.compose.animation.core.TransitionKt.animateValue.1
                public final SpringSpec<T> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                    $composer2.startReplaceGroup(-895531546);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-895531546, $changed2, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:1854)");
                    }
                    SpringSpec<T> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Composer composer, Integer num) {
                    return invoke((Transition.Segment) p1, composer, num.intValue());
                }
            };
        } else {
            function5 = function3;
        }
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "ValueAnimation";
        }
        Object initialValue = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed >> 9) & 112));
        Object targetValue = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed >> 9) & 112));
        State<T> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue, targetValue, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed >> 3) & 112)), twoWayConverter, label2, $composer, ($changed & 14) | (57344 & ($changed << 9)) | (($changed << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(final Transition<S> transition, T t, T t2, FiniteAnimationSpec<T> finiteAnimationSpec, TwoWayConverter<T, V> twoWayConverter, String label, Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -304821198, "C(createTransitionAnimation)P(1,3!1,4)1875@76469L499,1898@77352L128,1898@77314L166:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, $changed, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1874)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 460725030, "CC(remember):Transition.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) || ($changed & 6) == 4;
        Object value$iv2 = $composer.rememberedValue();
        if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = transition.new TransitionAnimationState(t, AnimationStateKt.createZeroVectorFrom(twoWayConverter, t2), twoWayConverter, label);
            $composer.updateRememberedValue(value$iv2);
        }
        final Transition.TransitionAnimationState transitionAnimation = (Transition.TransitionAnimationState) value$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (transition.isSeeking()) {
            transitionAnimation.updateInitialAndTargetValue$animation_core_release(t, t2, finiteAnimationSpec);
        } else {
            transitionAnimation.updateTargetValue$animation_core_release(t2, finiteAnimationSpec);
        }
        ComposerKt.sourceInformationMarkerStart($composer, 460725913, "CC(remember):Transition.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(transitionAnimation) | (((($changed & 14) ^ 6) > 4 && $composer.changed(transition)) || ($changed & 6) == 4);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    transition.addAnimation$animation_core_release(transitionAnimation);
                    final Transition<S> transition2 = transition;
                    final Transition<S>.TransitionAnimationState<T, V> transitionAnimationState = transitionAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.removeAnimation$animation_core_release(transitionAnimationState);
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(transitionAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return transitionAnimation;
    }

    public static final <S> State<Float> animateFloat(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Float> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1338768149, "CC(animateFloat)P(2)1942@79370L78:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Float>>() { // from class: androidx.compose.animation.core.TransitionKt.animateFloat.1
            public final SpringSpec<Float> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(-522164544);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-522164544, $changed2, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:1938)");
                }
                SpringSpec<Float> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "FloatAnimation" : label;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<Float> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S> State<C1979Dp> animateDp(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<C1979Dp>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, C1979Dp> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 184732935, "CC(animateDp)P(2)1973@81084L75:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<C1979Dp>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<C1979Dp>>() { // from class: androidx.compose.animation.core.TransitionKt.animateDp.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<C1979Dp> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<C1979Dp> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(-575880366);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-575880366, $changed2, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:1968)");
                }
                SpringSpec<C1979Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, C1979Dp.m6799boximpl(VisibilityThresholdsKt.getVisibilityThreshold(C1979Dp.INSTANCE)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "DpAnimation" : label;
        TwoWayConverter<C1979Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(C1979Dp.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<C1979Dp> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S> State<Offset> animateOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Offset> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 2078477582, "CC(animateOffset)P(2)2004@82824L79:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Offset>>() { // from class: androidx.compose.animation.core.TransitionKt.animateOffset.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Offset> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<Offset> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(1623385561);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1623385561, $changed2, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:1999)");
                }
                SpringSpec<Offset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m4038boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "OffsetAnimation" : label;
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<Offset> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S> State<Size> animateSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Size> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -802210820, "CC(animateSize)P(2)2035@84553L77:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Size>>() { // from class: androidx.compose.animation.core.TransitionKt.animateSize.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Size> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<Size> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(-1607152761);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1607152761, $changed2, -1, "androidx.compose.animation.core.animateSize.<anonymous> (Transition.kt:2030)");
                }
                SpringSpec<Size> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m4106boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "SizeAnimation" : label;
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<Size> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S> State<IntOffset> animateIntOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, IntOffset> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 776131825, "CC(animateIntOffset)P(2)2066@86301L82:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntOffset>>() { // from class: androidx.compose.animation.core.TransitionKt.animateIntOffset.1
            public final SpringSpec<IntOffset> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(-1953479610);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1953479610, $changed2, -1, "androidx.compose.animation.core.animateIntOffset.<anonymous> (Transition.kt:2062)");
                }
                SpringSpec<IntOffset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m6924boximpl(IntOffsetKt.IntOffset(1, 1)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<IntOffset> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "IntOffsetAnimation" : label;
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<IntOffset> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S> State<Integer> animateInt(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Integer> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1318902782, "CC(animateInt)P(2)2097@88004L76:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Integer>>() { // from class: androidx.compose.animation.core.TransitionKt.animateInt.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Integer> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<Integer> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(-785273069);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-785273069, $changed2, -1, "androidx.compose.animation.core.animateInt.<anonymous> (Transition.kt:2092)");
                }
                SpringSpec<Integer> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, 1, 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "IntAnimation" : label;
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<Integer> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S> State<IntSize> animateIntSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, IntSize> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -2104123233, "CC(animateIntSize)P(2)2127@89733L80:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.core.TransitionKt.animateIntSize.1
            public final SpringSpec<IntSize> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(967893300);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(967893300, $changed2, -1, "androidx.compose.animation.core.animateIntSize.<anonymous> (Transition.kt:2123)");
                }
                SpringSpec<IntSize> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m6967boximpl(IntSizeKt.IntSize(1, 1)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "IntSizeAnimation" : label;
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<IntSize> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }

    public static final <S> State<Rect> animateRect(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Rect> function4, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1496278239, "CC(animateRect)P(2)2157@91459L77:Transition.kt#pdpnli");
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function5 = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Rect>>() { // from class: androidx.compose.animation.core.TransitionKt.animateRect.1
            public final SpringSpec<Rect> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                $composer2.startReplaceGroup(691336298);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(691336298, $changed2, -1, "androidx.compose.animation.core.animateRect.<anonymous> (Transition.kt:2153)");
                }
                SpringSpec<Rect> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                return springSpecSpring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Rect> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        String label2 = (i & 2) != 0 ? "RectAnimation" : label;
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1859@75933L32,1860@75988L31,1861@76044L23,1863@76080L89:Transition.kt#pdpnli");
        Object initialValue$iv = function4.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = function4.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        State<Rect> stateCreateTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, function5.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCreateTransitionAnimation;
    }
}
