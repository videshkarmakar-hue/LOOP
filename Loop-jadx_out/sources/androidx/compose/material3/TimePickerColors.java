package androidx.compose.material3;

import androidx.compose.p001ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\u001d\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u009c\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0013\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010,\u001a\u00020-H\u0016J\u001d\u0010.\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010&J\u001d\u00100\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010&J\u001d\u00102\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010&J\u001d\u00104\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u0010&R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001e\u0010\u0013R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b \u0010\u0013R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, m195d2 = {"Landroidx/compose/material3/TimePickerColors;", "", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "selectorColor", "containerColor", "periodSelectorBorderColor", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "(JJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClockDialColor-0d7_KjU", "()J", "J", "getClockDialSelectedContentColor-0d7_KjU", "getClockDialUnselectedContentColor-0d7_KjU", "getContainerColor-0d7_KjU", "getPeriodSelectorBorderColor-0d7_KjU", "getPeriodSelectorSelectedContainerColor-0d7_KjU", "getPeriodSelectorSelectedContentColor-0d7_KjU", "getPeriodSelectorUnselectedContainerColor-0d7_KjU", "getPeriodSelectorUnselectedContentColor-0d7_KjU", "getSelectorColor-0d7_KjU", "getTimeSelectorSelectedContainerColor-0d7_KjU", "getTimeSelectorSelectedContentColor-0d7_KjU", "getTimeSelectorUnselectedContainerColor-0d7_KjU", "getTimeSelectorUnselectedContentColor-0d7_KjU", "clockDialContentColor", "selected", "", "clockDialContentColor-vNxB06k$material3_release", "(Z)J", "copy", "copy-dVHXu7A", "(JJJJJJJJJJJJJJ)Landroidx/compose/material3/TimePickerColors;", "equals", "other", "hashCode", "", "periodSelectorContainerColor", "periodSelectorContainerColor-vNxB06k$material3_release", "periodSelectorContentColor", "periodSelectorContentColor-vNxB06k$material3_release", "timeSelectorContainerColor", "timeSelectorContainerColor-vNxB06k$material3_release", "timeSelectorContentColor", "timeSelectorContentColor-vNxB06k$material3_release", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TimePickerColors {
    public static final int $stable = 0;
    private final long clockDialColor;
    private final long clockDialSelectedContentColor;
    private final long clockDialUnselectedContentColor;
    private final long containerColor;
    private final long periodSelectorBorderColor;
    private final long periodSelectorSelectedContainerColor;
    private final long periodSelectorSelectedContentColor;
    private final long periodSelectorUnselectedContainerColor;
    private final long periodSelectorUnselectedContentColor;
    private final long selectorColor;
    private final long timeSelectorSelectedContainerColor;
    private final long timeSelectorSelectedContentColor;
    private final long timeSelectorUnselectedContainerColor;
    private final long timeSelectorUnselectedContentColor;

    public /* synthetic */ TimePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    private TimePickerColors(long clockDialColor, long selectorColor, long containerColor, long periodSelectorBorderColor, long clockDialSelectedContentColor, long clockDialUnselectedContentColor, long periodSelectorSelectedContainerColor, long periodSelectorUnselectedContainerColor, long periodSelectorSelectedContentColor, long periodSelectorUnselectedContentColor, long timeSelectorSelectedContainerColor, long timeSelectorUnselectedContainerColor, long timeSelectorSelectedContentColor, long timeSelectorUnselectedContentColor) {
        this.clockDialColor = clockDialColor;
        this.selectorColor = selectorColor;
        this.containerColor = containerColor;
        this.periodSelectorBorderColor = periodSelectorBorderColor;
        this.clockDialSelectedContentColor = clockDialSelectedContentColor;
        this.clockDialUnselectedContentColor = clockDialUnselectedContentColor;
        this.periodSelectorSelectedContainerColor = periodSelectorSelectedContainerColor;
        this.periodSelectorUnselectedContainerColor = periodSelectorUnselectedContainerColor;
        this.periodSelectorSelectedContentColor = periodSelectorSelectedContentColor;
        this.periodSelectorUnselectedContentColor = periodSelectorUnselectedContentColor;
        this.timeSelectorSelectedContainerColor = timeSelectorSelectedContainerColor;
        this.timeSelectorUnselectedContainerColor = timeSelectorUnselectedContainerColor;
        this.timeSelectorSelectedContentColor = timeSelectorSelectedContentColor;
        this.timeSelectorUnselectedContentColor = timeSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: getClockDialColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getClockDialColor() {
        return this.clockDialColor;
    }

    /* JADX INFO: renamed from: getSelectorColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectorColor() {
        return this.selectorColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getPeriodSelectorBorderColor() {
        return this.periodSelectorBorderColor;
    }

    /* JADX INFO: renamed from: getClockDialSelectedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getClockDialSelectedContentColor() {
        return this.clockDialSelectedContentColor;
    }

    /* JADX INFO: renamed from: getClockDialUnselectedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getClockDialUnselectedContentColor() {
        return this.clockDialUnselectedContentColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorSelectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getPeriodSelectorSelectedContainerColor() {
        return this.periodSelectorSelectedContainerColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorUnselectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getPeriodSelectorUnselectedContainerColor() {
        return this.periodSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorSelectedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getPeriodSelectorSelectedContentColor() {
        return this.periodSelectorSelectedContentColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorUnselectedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getPeriodSelectorUnselectedContentColor() {
        return this.periodSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorSelectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTimeSelectorSelectedContainerColor() {
        return this.timeSelectorSelectedContainerColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorUnselectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTimeSelectorUnselectedContainerColor() {
        return this.timeSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorSelectedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTimeSelectorSelectedContentColor() {
        return this.timeSelectorSelectedContentColor;
    }

    /* JADX INFO: renamed from: getTimeSelectorUnselectedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTimeSelectorUnselectedContentColor() {
        return this.timeSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: copy-dVHXu7A, reason: not valid java name */
    public final TimePickerColors m2822copydVHXu7A(long clockDialColor, long selectorColor, long containerColor, long periodSelectorBorderColor, long clockDialSelectedContentColor, long clockDialUnselectedContentColor, long periodSelectorSelectedContainerColor, long periodSelectorUnselectedContainerColor, long periodSelectorSelectedContentColor, long periodSelectorUnselectedContentColor, long timeSelectorSelectedContainerColor, long timeSelectorUnselectedContainerColor, long timeSelectorSelectedContentColor, long timeSelectorUnselectedContentColor) {
        return new TimePickerColors((clockDialColor > 16L ? 1 : (clockDialColor == 16L ? 0 : -1)) != 0 ? clockDialColor : this.clockDialColor, (selectorColor > 16L ? 1 : (selectorColor == 16L ? 0 : -1)) != 0 ? selectorColor : this.selectorColor, (containerColor > 16L ? 1 : (containerColor == 16L ? 0 : -1)) != 0 ? containerColor : this.containerColor, (periodSelectorBorderColor > 16L ? 1 : (periodSelectorBorderColor == 16L ? 0 : -1)) != 0 ? periodSelectorBorderColor : this.periodSelectorBorderColor, (clockDialSelectedContentColor > 16L ? 1 : (clockDialSelectedContentColor == 16L ? 0 : -1)) != 0 ? clockDialSelectedContentColor : this.clockDialSelectedContentColor, (clockDialUnselectedContentColor > 16L ? 1 : (clockDialUnselectedContentColor == 16L ? 0 : -1)) != 0 ? clockDialUnselectedContentColor : this.clockDialUnselectedContentColor, (periodSelectorSelectedContainerColor > 16L ? 1 : (periodSelectorSelectedContainerColor == 16L ? 0 : -1)) != 0 ? periodSelectorSelectedContainerColor : this.periodSelectorSelectedContainerColor, (periodSelectorUnselectedContainerColor > 16L ? 1 : (periodSelectorUnselectedContainerColor == 16L ? 0 : -1)) != 0 ? periodSelectorUnselectedContainerColor : this.periodSelectorUnselectedContainerColor, (periodSelectorSelectedContentColor > 16L ? 1 : (periodSelectorSelectedContentColor == 16L ? 0 : -1)) != 0 ? periodSelectorSelectedContentColor : this.periodSelectorSelectedContentColor, (periodSelectorUnselectedContentColor > 16L ? 1 : (periodSelectorUnselectedContentColor == 16L ? 0 : -1)) != 0 ? periodSelectorUnselectedContentColor : this.periodSelectorUnselectedContentColor, (timeSelectorSelectedContainerColor > 16L ? 1 : (timeSelectorSelectedContainerColor == 16L ? 0 : -1)) != 0 ? timeSelectorSelectedContainerColor : this.timeSelectorSelectedContainerColor, (timeSelectorUnselectedContainerColor > 16L ? 1 : (timeSelectorUnselectedContainerColor == 16L ? 0 : -1)) != 0 ? timeSelectorUnselectedContainerColor : this.timeSelectorUnselectedContainerColor, (timeSelectorSelectedContentColor > 16L ? 1 : (timeSelectorSelectedContentColor == 16L ? 0 : -1)) != 0 ? timeSelectorSelectedContentColor : this.timeSelectorSelectedContentColor, timeSelectorUnselectedContentColor != 16 ? timeSelectorUnselectedContentColor : this.timeSelectorUnselectedContentColor, null);
    }

    /* JADX INFO: renamed from: periodSelectorContainerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m2837periodSelectorContainerColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.periodSelectorSelectedContainerColor;
        }
        return this.periodSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: periodSelectorContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m2838periodSelectorContentColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.periodSelectorSelectedContentColor;
        }
        return this.periodSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: timeSelectorContainerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m2839timeSelectorContainerColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.timeSelectorSelectedContainerColor;
        }
        return this.timeSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: timeSelectorContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m2840timeSelectorContentColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.timeSelectorSelectedContentColor;
        }
        return this.timeSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: clockDialContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m2821clockDialContentColorvNxB06k$material3_release(boolean selected) {
        if (selected) {
            return this.clockDialSelectedContentColor;
        }
        return this.clockDialUnselectedContentColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (Color.m4292equalsimpl0(this.clockDialColor, ((TimePickerColors) other).clockDialColor) && Color.m4292equalsimpl0(this.selectorColor, ((TimePickerColors) other).selectorColor) && Color.m4292equalsimpl0(this.containerColor, ((TimePickerColors) other).containerColor) && Color.m4292equalsimpl0(this.periodSelectorBorderColor, ((TimePickerColors) other).periodSelectorBorderColor) && Color.m4292equalsimpl0(this.periodSelectorSelectedContainerColor, ((TimePickerColors) other).periodSelectorSelectedContainerColor) && Color.m4292equalsimpl0(this.periodSelectorUnselectedContainerColor, ((TimePickerColors) other).periodSelectorUnselectedContainerColor) && Color.m4292equalsimpl0(this.periodSelectorSelectedContentColor, ((TimePickerColors) other).periodSelectorSelectedContentColor) && Color.m4292equalsimpl0(this.periodSelectorUnselectedContentColor, ((TimePickerColors) other).periodSelectorUnselectedContentColor) && Color.m4292equalsimpl0(this.timeSelectorSelectedContainerColor, ((TimePickerColors) other).timeSelectorSelectedContainerColor) && Color.m4292equalsimpl0(this.timeSelectorUnselectedContainerColor, ((TimePickerColors) other).timeSelectorUnselectedContainerColor) && Color.m4292equalsimpl0(this.timeSelectorSelectedContentColor, ((TimePickerColors) other).timeSelectorSelectedContentColor) && Color.m4292equalsimpl0(this.timeSelectorUnselectedContentColor, ((TimePickerColors) other).timeSelectorUnselectedContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m4298hashCodeimpl(this.clockDialColor);
        return (((((((((((((((((((((result * 31) + Color.m4298hashCodeimpl(this.selectorColor)) * 31) + Color.m4298hashCodeimpl(this.containerColor)) * 31) + Color.m4298hashCodeimpl(this.periodSelectorBorderColor)) * 31) + Color.m4298hashCodeimpl(this.periodSelectorSelectedContainerColor)) * 31) + Color.m4298hashCodeimpl(this.periodSelectorUnselectedContainerColor)) * 31) + Color.m4298hashCodeimpl(this.periodSelectorSelectedContentColor)) * 31) + Color.m4298hashCodeimpl(this.periodSelectorUnselectedContentColor)) * 31) + Color.m4298hashCodeimpl(this.timeSelectorSelectedContainerColor)) * 31) + Color.m4298hashCodeimpl(this.timeSelectorUnselectedContainerColor)) * 31) + Color.m4298hashCodeimpl(this.timeSelectorSelectedContentColor)) * 31) + Color.m4298hashCodeimpl(this.timeSelectorUnselectedContentColor);
    }
}
