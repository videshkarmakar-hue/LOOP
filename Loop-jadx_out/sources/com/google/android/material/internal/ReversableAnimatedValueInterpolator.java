package com.google.android.material.internal;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes18.dex */
public class ReversableAnimatedValueInterpolator implements TimeInterpolator {
    private final TimeInterpolator sourceInterpolator;

    public ReversableAnimatedValueInterpolator(TimeInterpolator sourceInterpolator) {
        this.sourceInterpolator = sourceInterpolator;
    }

    /* JADX INFO: renamed from: of */
    public static TimeInterpolator m143of(boolean useSourceInterpolator, TimeInterpolator sourceInterpolator) {
        if (useSourceInterpolator) {
            return sourceInterpolator;
        }
        return new ReversableAnimatedValueInterpolator(sourceInterpolator);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        return 1.0f - this.sourceInterpolator.getInterpolation(input);
    }
}
