package io.material.hct;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.material.utils.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Hct.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m194d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, m195d2 = {"Lio/material/hct/Hct;", "", "argb", "", "(I)V", "getArgb", "()I", "setArgb", "<set-?>", "", "chroma", "getChroma", "()D", "hue", "getHue", "tone", "getTone", "inViewingConditions", "vc", "Lio/material/hct/ViewingConditions;", "setChroma", "", "newChroma", "setHue", "newHue", "setInternalState", "setTone", "newTone", "toInt", "Companion", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Hct {
    private int argb;
    private double chroma;
    private double hue;
    private double tone;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ Hct(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private Hct(int argb) {
        setInternalState(argb);
    }

    public final double getHue() {
        return this.hue;
    }

    public final double getChroma() {
        return this.chroma;
    }

    public final double getTone() {
        return this.tone;
    }

    public final int getArgb() {
        return this.argb;
    }

    public final void setArgb(int i) {
        this.argb = i;
    }

    public final int toInt() {
        return this.argb;
    }

    public final void setHue(double newHue) {
        setInternalState(HctSolver.INSTANCE.solveToInt(newHue, this.chroma, this.tone));
    }

    public final void setChroma(double newChroma) {
        setInternalState(HctSolver.INSTANCE.solveToInt(this.hue, newChroma, this.tone));
    }

    public final void setTone(double newTone) {
        setInternalState(HctSolver.INSTANCE.solveToInt(this.hue, this.chroma, newTone));
    }

    public final Hct inViewingConditions(ViewingConditions vc) {
        Intrinsics.checkNotNullParameter(vc, "vc");
        Cam16 cam16 = Cam16.INSTANCE.fromInt(toInt());
        double[] viewedInVc = cam16.xyzInViewingConditions(vc, null);
        Cam16 recastInVc = Cam16.INSTANCE.fromXyzInViewingConditions(viewedInVc[0], viewedInVc[1], viewedInVc[2], ViewingConditions.INSTANCE.getDEFAULT());
        return INSTANCE.from(recastInVc.getHue(), recastInVc.getChroma(), ColorUtils.INSTANCE.lstarFromY(viewedInVc[1]));
    }

    private final void setInternalState(int argb) {
        this.argb = argb;
        Cam16 cam = Cam16.INSTANCE.fromInt(argb);
        this.hue = cam.getHue();
        this.chroma = cam.getChroma();
        this.tone = ColorUtils.INSTANCE.lstarFromArgb(argb);
    }

    /* JADX INFO: compiled from: Hct.kt */
    @Metadata(m194d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, m195d2 = {"Lio/material/hct/Hct$Companion;", "", "()V", "from", "Lio/material/hct/Hct;", "hue", "", "chroma", "tone", "fromInt", "argb", "", "color_debug"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Hct from(double hue, double chroma, double tone) {
            int argb = HctSolver.INSTANCE.solveToInt(hue, chroma, tone);
            return new Hct(argb, null);
        }

        public final Hct fromInt(int argb) {
            return new Hct(argb, null);
        }
    }
}
