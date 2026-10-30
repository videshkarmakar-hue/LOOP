package androidx.compose.animation.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.videshkarmakar.loop.util.DownloadUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\n\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m195d2 = {"UNSET", "", "getUNSET", "()F", "VelocityThresholdMultiplier", "", "Motion", "Landroidx/compose/animation/core/Motion;", DownloadUtil.CookieScheme.VALUE, "velocity", "(FF)J", "animation-core_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SpringSimulationKt {
    private static final float UNSET = Float.MAX_VALUE;
    private static final double VelocityThresholdMultiplier = 62.5d;

    public static final long Motion(float value, float velocity) {
        long v1$iv = Float.floatToRawIntBits(value);
        long v2$iv = Float.floatToRawIntBits(velocity);
        return Motion.m381constructorimpl((v1$iv << 32) | (4294967295L & v2$iv));
    }

    public static final float getUNSET() {
        return UNSET;
    }
}
