package androidx.compose.material3;

import androidx.compose.p001ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJt\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J%\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J%\u0010)\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010(R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m195d2 = {"Landroidx/compose/material3/SliderColors;", "", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveTickColor-0d7_KjU", "()J", "J", "getActiveTrackColor-0d7_KjU", "getDisabledActiveTickColor-0d7_KjU", "getDisabledActiveTrackColor-0d7_KjU", "getDisabledInactiveTickColor-0d7_KjU", "getDisabledInactiveTrackColor-0d7_KjU", "getDisabledThumbColor-0d7_KjU", "getInactiveTickColor-0d7_KjU", "getInactiveTrackColor-0d7_KjU", "getThumbColor-0d7_KjU", "copy", "copy--K518z4", "(JJJJJJJJJJ)Landroidx/compose/material3/SliderColors;", "equals", "", "other", "hashCode", "", "enabled", "thumbColor-vNxB06k$material3_release", "(Z)J", "tickColor", "active", "tickColor-WaAFU9c$material3_release", "(ZZ)J", "trackColor", "trackColor-WaAFU9c$material3_release", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SliderColors {
    public static final int $stable = 0;
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ SliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10);
    }

    private SliderColors(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor) {
        this.thumbColor = thumbColor;
        this.activeTrackColor = activeTrackColor;
        this.activeTickColor = activeTickColor;
        this.inactiveTrackColor = inactiveTrackColor;
        this.inactiveTickColor = inactiveTickColor;
        this.disabledThumbColor = disabledThumbColor;
        this.disabledActiveTrackColor = disabledActiveTrackColor;
        this.disabledActiveTickColor = disabledActiveTickColor;
        this.disabledInactiveTrackColor = disabledInactiveTrackColor;
        this.disabledInactiveTickColor = disabledInactiveTickColor;
    }

    /* JADX INFO: renamed from: getThumbColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getThumbColor() {
        return this.thumbColor;
    }

    /* JADX INFO: renamed from: getActiveTrackColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getActiveTrackColor() {
        return this.activeTrackColor;
    }

    /* JADX INFO: renamed from: getActiveTickColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getActiveTickColor() {
        return this.activeTickColor;
    }

    /* JADX INFO: renamed from: getInactiveTrackColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getInactiveTrackColor() {
        return this.inactiveTrackColor;
    }

    /* JADX INFO: renamed from: getInactiveTickColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getInactiveTickColor() {
        return this.inactiveTickColor;
    }

    /* JADX INFO: renamed from: getDisabledThumbColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledThumbColor() {
        return this.disabledThumbColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveTrackColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledActiveTrackColor() {
        return this.disabledActiveTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledActiveTickColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledActiveTickColor() {
        return this.disabledActiveTickColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveTrackColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledInactiveTrackColor() {
        return this.disabledInactiveTrackColor;
    }

    /* JADX INFO: renamed from: getDisabledInactiveTickColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledInactiveTickColor() {
        return this.disabledInactiveTickColor;
    }

    /* JADX INFO: renamed from: copy--K518z4, reason: not valid java name */
    public final SliderColors m2601copyK518z4(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor) {
        return new SliderColors((thumbColor > 16L ? 1 : (thumbColor == 16L ? 0 : -1)) != 0 ? thumbColor : this.thumbColor, (activeTrackColor > 16L ? 1 : (activeTrackColor == 16L ? 0 : -1)) != 0 ? activeTrackColor : this.activeTrackColor, (activeTickColor > 16L ? 1 : (activeTickColor == 16L ? 0 : -1)) != 0 ? activeTickColor : this.activeTickColor, (inactiveTrackColor > 16L ? 1 : (inactiveTrackColor == 16L ? 0 : -1)) != 0 ? inactiveTrackColor : this.inactiveTrackColor, (inactiveTickColor > 16L ? 1 : (inactiveTickColor == 16L ? 0 : -1)) != 0 ? inactiveTickColor : this.inactiveTickColor, (disabledThumbColor > 16L ? 1 : (disabledThumbColor == 16L ? 0 : -1)) != 0 ? disabledThumbColor : this.disabledThumbColor, (disabledActiveTrackColor > 16L ? 1 : (disabledActiveTrackColor == 16L ? 0 : -1)) != 0 ? disabledActiveTrackColor : this.disabledActiveTrackColor, (disabledActiveTickColor > 16L ? 1 : (disabledActiveTickColor == 16L ? 0 : -1)) != 0 ? disabledActiveTickColor : this.disabledActiveTickColor, (disabledInactiveTrackColor > 16L ? 1 : (disabledInactiveTrackColor == 16L ? 0 : -1)) != 0 ? disabledInactiveTrackColor : this.disabledInactiveTrackColor, disabledInactiveTickColor != 16 ? disabledInactiveTickColor : this.disabledInactiveTickColor, null);
    }

    /* JADX INFO: renamed from: thumbColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m2612thumbColorvNxB06k$material3_release(boolean enabled) {
        return enabled ? this.thumbColor : this.disabledThumbColor;
    }

    /* JADX INFO: renamed from: trackColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2614trackColorWaAFU9c$material3_release(boolean enabled, boolean active) {
        if (enabled) {
            return active ? this.activeTrackColor : this.inactiveTrackColor;
        }
        return active ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
    }

    /* JADX INFO: renamed from: tickColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2613tickColorWaAFU9c$material3_release(boolean enabled, boolean active) {
        if (enabled) {
            return active ? this.activeTickColor : this.inactiveTickColor;
        }
        return active ? this.disabledActiveTickColor : this.disabledInactiveTickColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof SliderColors) && Color.m4292equalsimpl0(this.thumbColor, ((SliderColors) other).thumbColor) && Color.m4292equalsimpl0(this.activeTrackColor, ((SliderColors) other).activeTrackColor) && Color.m4292equalsimpl0(this.activeTickColor, ((SliderColors) other).activeTickColor) && Color.m4292equalsimpl0(this.inactiveTrackColor, ((SliderColors) other).inactiveTrackColor) && Color.m4292equalsimpl0(this.inactiveTickColor, ((SliderColors) other).inactiveTickColor) && Color.m4292equalsimpl0(this.disabledThumbColor, ((SliderColors) other).disabledThumbColor) && Color.m4292equalsimpl0(this.disabledActiveTrackColor, ((SliderColors) other).disabledActiveTrackColor) && Color.m4292equalsimpl0(this.disabledActiveTickColor, ((SliderColors) other).disabledActiveTickColor) && Color.m4292equalsimpl0(this.disabledInactiveTrackColor, ((SliderColors) other).disabledInactiveTrackColor) && Color.m4292equalsimpl0(this.disabledInactiveTickColor, ((SliderColors) other).disabledInactiveTickColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m4298hashCodeimpl(this.thumbColor);
        return (((((((((((((((((result * 31) + Color.m4298hashCodeimpl(this.activeTrackColor)) * 31) + Color.m4298hashCodeimpl(this.activeTickColor)) * 31) + Color.m4298hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m4298hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m4298hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m4298hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m4298hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m4298hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m4298hashCodeimpl(this.disabledInactiveTickColor);
    }
}
