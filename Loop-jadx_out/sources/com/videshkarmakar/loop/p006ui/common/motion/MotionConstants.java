package com.videshkarmakar.loop.p006ui.common.motion;

import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: MotionConstants.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m194d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, m195d2 = {"Lcom/videshkarmakar/loop/ui/common/motion/MotionConstants;", "", "()V", "DefaultFadeInDuration", "", "DefaultFadeOutDuration", "DefaultMotionDuration", "DefaultSlideDistance", "Landroidx/compose/ui/unit/Dp;", "getDefaultSlideDistance-D9Ej5fM", "()F", "F", "app_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MotionConstants {
    public static final int $stable = 0;
    public static final int DefaultFadeInDuration = 150;
    public static final int DefaultFadeOutDuration = 75;
    public static final int DefaultMotionDuration = 300;
    public static final MotionConstants INSTANCE = new MotionConstants();
    private static final float DefaultSlideDistance = C1979Dp.m6801constructorimpl(30);

    private MotionConstants() {
    }

    /* JADX INFO: renamed from: getDefaultSlideDistance-D9Ej5fM, reason: not valid java name */
    public final float m7238getDefaultSlideDistanceD9Ej5fM() {
        return DefaultSlideDistance;
    }
}
