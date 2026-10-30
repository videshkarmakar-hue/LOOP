package com.videshkarmakar.loop.ui.common.motion;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialSharedAxis.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a3\u0010\u0011\u001a\u00020\u00122!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a3\u0010\u0013\u001a\u00020\u00142!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001aV\u0010\u0015\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a3\u0010\u0017\u001a\u00020\u00122!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a3\u0010\u0018\u001a\u00020\u00142!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u001a\u001c\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0018\u0010\u0006\u001a\u00020\u0003*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"ProgressThreshold", "", "ForIncoming", "", "getForIncoming", "(I)I", "ForOutgoing", "getForOutgoing", "materialSharedAxisX", "Landroidx/compose/animation/ContentTransform;", "initialOffsetX", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "fullWidth", "targetOffsetX", "durationMillis", "materialSharedAxisXIn", "Landroidx/compose/animation/EnterTransition;", "materialSharedAxisXOut", "Landroidx/compose/animation/ExitTransition;", "materialSharedAxisY", "targetOffsetY", "materialSharedAxisYIn", "materialSharedAxisYOut", "materialSharedAxisZ", "forward", "", "materialSharedAxisZIn", "materialSharedAxisZOut", "rememberSlideDistance", "slideDistance", "Landroidx/compose/ui/unit/Dp;", "rememberSlideDistance-kHDZbjc", "(FLandroidx/compose/runtime/Composer;II)I", "app_debug"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MaterialSharedAxisKt {
    private static final float ProgressThreshold = 0.35f;

    /* JADX INFO: renamed from: rememberSlideDistance-kHDZbjc, reason: not valid java name */
    public static final int m7101rememberSlideDistancekHDZbjc(float slideDistance, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceGroup(-1359137718);
        ComposerKt.sourceInformation($composer, "C(rememberSlideDistance)P(0:c#ui.unit.Dp)49@1924L7,50@1943L92:MaterialSharedAxis.kt#8etp5p");
        boolean z = true;
        if ((i & 1) != 0) {
            slideDistance = MotionConstants.INSTANCE.m7102getDefaultSlideDistanceD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1359137718, $changed, -1, "com.videshkarmakar.loop.ui.common.motion.rememberSlideDistance (MaterialSharedAxis.kt:48)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) objConsume;
        $composer.startReplaceGroup(-1498201617);
        ComposerKt.sourceInformation($composer, "CC(remember):MaterialSharedAxis.kt#9igjgp");
        boolean zChanged = $composer.changed(density);
        if (((($changed & 14) ^ 6) <= 4 || !$composer.changed(slideDistance)) && ($changed & 6) != 4) {
            z = false;
        }
        boolean invalid$iv = zChanged | z;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = Integer.valueOf(density.mo313roundToPx0680j_4(slideDistance));
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        int iIntValue = ((Number) value$iv).intValue();
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return iIntValue;
    }

    private static final int getForOutgoing(int $this$ForOutgoing) {
        return (int) ($this$ForOutgoing * ProgressThreshold);
    }

    private static final int getForIncoming(int $this$ForIncoming) {
        return $this$ForIncoming - getForOutgoing($this$ForIncoming);
    }

    public static /* synthetic */ ContentTransform materialSharedAxisX$default(Function1 function1, Function1 function2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 300;
        }
        return materialSharedAxisX(function1, function2, i);
    }

    public static final ContentTransform materialSharedAxisX(Function1<? super Integer, Integer> initialOffsetX, Function1<? super Integer, Integer> targetOffsetX, int durationMillis) {
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        Intrinsics.checkNotNullParameter(targetOffsetX, "targetOffsetX");
        return AnimatedContentKt.togetherWith(materialSharedAxisXIn(initialOffsetX, durationMillis), materialSharedAxisXOut(targetOffsetX, durationMillis));
    }

    public static /* synthetic */ EnterTransition materialSharedAxisXIn$default(Function1 function1, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 300;
        }
        return materialSharedAxisXIn(function1, i);
    }

    public static final EnterTransition materialSharedAxisXIn(Function1<? super Integer, Integer> initialOffsetX, int durationMillis) {
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        return EnterExitTransitionKt.slideInHorizontally(AnimationSpecKt.tween$default(durationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, null), initialOffsetX).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(getForIncoming(durationMillis), getForOutgoing(durationMillis), EasingKt.getLinearOutSlowInEasing()), 0.0f, 2, null));
    }

    public static /* synthetic */ ExitTransition materialSharedAxisXOut$default(Function1 function1, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 300;
        }
        return materialSharedAxisXOut(function1, i);
    }

    public static final ExitTransition materialSharedAxisXOut(Function1<? super Integer, Integer> targetOffsetX, int durationMillis) {
        Intrinsics.checkNotNullParameter(targetOffsetX, "targetOffsetX");
        return EnterExitTransitionKt.slideOutHorizontally(AnimationSpecKt.tween$default(durationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, null), targetOffsetX).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween(getForOutgoing(durationMillis), 0, EasingKt.getFastOutLinearInEasing()), 0.0f, 2, null));
    }

    public static /* synthetic */ ContentTransform materialSharedAxisY$default(Function1 function1, Function1 function2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 300;
        }
        return materialSharedAxisY(function1, function2, i);
    }

    public static final ContentTransform materialSharedAxisY(Function1<? super Integer, Integer> initialOffsetX, Function1<? super Integer, Integer> targetOffsetY, int durationMillis) {
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        Intrinsics.checkNotNullParameter(targetOffsetY, "targetOffsetY");
        return AnimatedContentKt.togetherWith(materialSharedAxisYIn(initialOffsetX, durationMillis), materialSharedAxisYOut(targetOffsetY, durationMillis));
    }

    public static /* synthetic */ EnterTransition materialSharedAxisYIn$default(Function1 function1, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 300;
        }
        return materialSharedAxisYIn(function1, i);
    }

    public static final EnterTransition materialSharedAxisYIn(Function1<? super Integer, Integer> initialOffsetX, int durationMillis) {
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        return EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(durationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, null), initialOffsetX).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(getForIncoming(durationMillis), getForOutgoing(durationMillis), EasingKt.getLinearOutSlowInEasing()), 0.0f, 2, null));
    }

    public static /* synthetic */ ExitTransition materialSharedAxisYOut$default(Function1 function1, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 300;
        }
        return materialSharedAxisYOut(function1, i);
    }

    public static final ExitTransition materialSharedAxisYOut(Function1<? super Integer, Integer> targetOffsetY, int durationMillis) {
        Intrinsics.checkNotNullParameter(targetOffsetY, "targetOffsetY");
        return EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(durationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, null), targetOffsetY).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween(getForOutgoing(durationMillis), 0, EasingKt.getFastOutLinearInEasing()), 0.0f, 2, null));
    }

    public static /* synthetic */ ContentTransform materialSharedAxisZ$default(boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 300;
        }
        return materialSharedAxisZ(z, i);
    }

    public static final ContentTransform materialSharedAxisZ(boolean forward, int durationMillis) {
        return AnimatedContentKt.togetherWith(materialSharedAxisZIn(forward, durationMillis), materialSharedAxisZOut(forward, durationMillis));
    }

    public static /* synthetic */ EnterTransition materialSharedAxisZIn$default(boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 300;
        }
        return materialSharedAxisZIn(z, i);
    }

    public static final EnterTransition materialSharedAxisZIn(boolean forward, int durationMillis) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(getForIncoming(durationMillis), getForOutgoing(durationMillis), EasingKt.getLinearOutSlowInEasing()), 0.0f, 2, null).plus(EnterExitTransitionKt.m72scaleInL8ZKhE$default(AnimationSpecKt.tween$default(durationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, null), forward ? 0.8f : 1.1f, 0L, 4, null));
    }

    public static /* synthetic */ ExitTransition materialSharedAxisZOut$default(boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 300;
        }
        return materialSharedAxisZOut(z, i);
    }

    public static final ExitTransition materialSharedAxisZOut(boolean forward, int durationMillis) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween(getForOutgoing(durationMillis), 0, EasingKt.getFastOutLinearInEasing()), 0.0f, 2, null).plus(EnterExitTransitionKt.m74scaleOutL8ZKhE$default(AnimationSpecKt.tween$default(durationMillis, 0, EasingKt.getFastOutSlowInEasing(), 2, null), forward ? 1.1f : 0.8f, 0L, 4, null));
    }
}
