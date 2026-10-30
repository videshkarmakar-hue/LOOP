package com.videshkarmakar.loop.p006ui.common.motion;

import android.graphics.Path;
import android.view.animation.PathInterpolator;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationSpecs.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m194d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m195d2 = {"emphasizeEasing", "Landroidx/compose/animation/core/Easing;", "getEmphasizeEasing", "()Landroidx/compose/animation/core/Easing;", "emphasizeEasingVariant", "Landroidx/compose/animation/core/CubicBezierEasing;", "emphasizePathInterpolator", "Landroid/view/animation/PathInterpolator;", "emphasizedAccelerate", "emphasizedDecelerate", "motionEasingStandard", DownloadUtil.CookieScheme.PATH, "Landroid/graphics/Path;", "standardDecelerate", "tweenSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "toEasing", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnimationSpecsKt {
    private static final Easing emphasizeEasing;
    private static final CubicBezierEasing emphasizeEasingVariant;
    private static final PathInterpolator emphasizePathInterpolator;
    private static final CubicBezierEasing emphasizedAccelerate;
    private static final CubicBezierEasing emphasizedDecelerate;
    private static final CubicBezierEasing motionEasingStandard;
    private static final Path path;
    private static final CubicBezierEasing standardDecelerate;
    private static final TweenSpec<Float> tweenSpec;

    public static final Easing toEasing(final PathInterpolator $this$toEasing) {
        Intrinsics.checkNotNullParameter($this$toEasing, "<this>");
        return new Easing() { // from class: com.videshkarmakar.loop.ui.common.motion.AnimationSpecsKt$$ExternalSyntheticLambda0
            @Override // androidx.compose.animation.core.Easing
            public final float transform(float f) {
                return AnimationSpecsKt.toEasing$lambda$0($this$toEasing, f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toEasing$lambda$0(PathInterpolator this_toEasing, float f) {
        Intrinsics.checkNotNullParameter(this_toEasing, "$this_toEasing");
        return this_toEasing.getInterpolation(f);
    }

    static {
        Path $this$path_u24lambda_u241 = new Path();
        $this$path_u24lambda_u241.moveTo(0.0f, 0.0f);
        $this$path_u24lambda_u241.cubicTo(0.05f, 0.0f, 0.133333f, 0.06f, 0.166666f, 0.4f);
        $this$path_u24lambda_u241.cubicTo(0.208333f, 0.82f, 0.25f, 1.0f, 1.0f, 1.0f);
        path = $this$path_u24lambda_u241;
        emphasizePathInterpolator = new PathInterpolator(path);
        emphasizeEasing = toEasing(emphasizePathInterpolator);
        emphasizeEasingVariant = new CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f);
        emphasizedDecelerate = new CubicBezierEasing(0.05f, 0.7f, 0.1f, 1.0f);
        emphasizedAccelerate = new CubicBezierEasing(0.3f, 0.0f, 1.0f, 1.0f);
        standardDecelerate = new CubicBezierEasing(0.0f, 0.0f, 0.0f, 1.0f);
        motionEasingStandard = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
        tweenSpec = AnimationSpecKt.tween$default(400, 0, emphasizeEasing, 2, null);
    }

    public static final Easing getEmphasizeEasing() {
        return emphasizeEasing;
    }
}
