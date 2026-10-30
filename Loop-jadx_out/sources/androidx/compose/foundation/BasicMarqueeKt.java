package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: BasicMarquee.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aH\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180#2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0001H\u0002\u001aR\u0010$\u001a\u00020%*\u00020%2\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0001X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m195d2 = {"DefaultMarqueeDelayMillis", "", "getDefaultMarqueeDelayMillis$annotations", "()V", "getDefaultMarqueeDelayMillis", "()I", "DefaultMarqueeIterations", "getDefaultMarqueeIterations$annotations", "getDefaultMarqueeIterations", "DefaultMarqueeSpacing", "Landroidx/compose/foundation/MarqueeSpacing;", "getDefaultMarqueeSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "DefaultMarqueeVelocity", "Landroidx/compose/ui/unit/Dp;", "getDefaultMarqueeVelocity", "()F", "F", "MarqueeSpacing", "spacing", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "iterations", "targetValue", "initialDelayMillis", "delayMillis", "velocity", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "basicMarquee", "Landroidx/compose/ui/Modifier;", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BasicMarqueeKt {
    private static final int DefaultMarqueeIterations = 3;
    private static final int DefaultMarqueeDelayMillis = 1200;
    private static final MarqueeSpacing DefaultMarqueeSpacing = MarqueeSpacing.INSTANCE.fractionOfContainer(0.33333334f);
    private static final float DefaultMarqueeVelocity = C1979Dp.m6801constructorimpl(30);

    public static /* synthetic */ void getDefaultMarqueeDelayMillis$annotations() {
    }

    public static /* synthetic */ void getDefaultMarqueeIterations$annotations() {
    }

    public static final int getDefaultMarqueeIterations() {
        return DefaultMarqueeIterations;
    }

    public static final int getDefaultMarqueeDelayMillis() {
        return DefaultMarqueeDelayMillis;
    }

    public static final MarqueeSpacing getDefaultMarqueeSpacing() {
        return DefaultMarqueeSpacing;
    }

    public static final float getDefaultMarqueeVelocity() {
        return DefaultMarqueeVelocity;
    }

    /* JADX INFO: renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m460basicMarquee1Mj1MLw$default(Modifier modifier, int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, int i5, Object obj) {
        int i6;
        if ((i5 & 1) != 0) {
            i = DefaultMarqueeIterations;
        }
        int iM532getImmediatelyZbEOnfQ = (i5 & 2) != 0 ? MarqueeAnimationMode.INSTANCE.m532getImmediatelyZbEOnfQ() : i2;
        int i7 = (i5 & 4) != 0 ? DefaultMarqueeDelayMillis : i3;
        if ((i5 & 8) != 0) {
            i6 = MarqueeAnimationMode.m528equalsimpl0(iM532getImmediatelyZbEOnfQ, MarqueeAnimationMode.INSTANCE.m532getImmediatelyZbEOnfQ()) ? i7 : 0;
        } else {
            i6 = i4;
        }
        return m459basicMarquee1Mj1MLw(modifier, i, iM532getImmediatelyZbEOnfQ, i7, i6, (i5 & 16) != 0 ? DefaultMarqueeSpacing : marqueeSpacing, (i5 & 32) != 0 ? DefaultMarqueeVelocity : f);
    }

    /* JADX INFO: renamed from: basicMarquee-1Mj1MLw, reason: not valid java name */
    public static final Modifier m459basicMarquee1Mj1MLw(Modifier $this$basicMarquee_u2d1Mj1MLw, int iterations, int animationMode, int delayMillis, int initialDelayMillis, MarqueeSpacing spacing, float velocity) {
        return $this$basicMarquee_u2d1Mj1MLw.then(new MarqueeModifierElement(iterations, animationMode, delayMillis, initialDelayMillis, spacing, velocity, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    public static final AnimationSpec<Float> m461createMarqueeAnimationSpecZ4HSEVQ(int iterations, float targetValue, int initialDelayMillis, int delayMillis, float velocity, Density density) {
        float pxPerSec = density.mo567toPx0680j_4(velocity);
        TweenSpec<Float> tweenSpecVelocityBasedTween = velocityBasedTween(Math.abs(pxPerSec), targetValue, delayMillis);
        long startOffset = StartOffset.m396constructorimpl$default((-delayMillis) + initialDelayMillis, 0, 2, null);
        if (iterations == Integer.MAX_VALUE) {
            return AnimationSpecKt.m374infiniteRepeatable9IiC70o$default(tweenSpecVelocityBasedTween, null, startOffset, 2, null);
        }
        return AnimationSpecKt.m376repeatable91I0pcU$default(iterations, tweenSpecVelocityBasedTween, null, startOffset, 4, null);
    }

    private static final TweenSpec<Float> velocityBasedTween(float velocity, float targetValue, int delayMillis) {
        float pxPerMilli = velocity / 1000.0f;
        return AnimationSpecKt.tween((int) Math.ceil(targetValue / pxPerMilli), delayMillis, EasingKt.getLinearEasing());
    }

    /* JADX INFO: renamed from: MarqueeSpacing-0680j_4, reason: not valid java name */
    public static final MarqueeSpacing m457MarqueeSpacing0680j_4(final float spacing) {
        return new MarqueeSpacing() { // from class: androidx.compose.foundation.BasicMarqueeKt$$ExternalSyntheticLambda0
            @Override // androidx.compose.foundation.MarqueeSpacing
            public final int calculateSpacing(Density density, int i, int i2) {
                return BasicMarqueeKt.MarqueeSpacing_0680j_4$lambda$1(spacing, density, i, i2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MarqueeSpacing_0680j_4$lambda$1(float $spacing, Density $this$MarqueeSpacing, int i, int i2) {
        return $this$MarqueeSpacing.mo561roundToPx0680j_4($spacing);
    }
}
