package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u008c\u0002\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cø\u0001\u0000¢\u0006\u0004\b;\u0010<J-\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@H\u0001¢\u0006\u0004\bC\u0010DJ5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010E\u001a\u00020@2\u0006\u0010?\u001a\u00020@2\u0006\u0010F\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\bG\u0010HJ\u0013\u0010I\u001a\u00020@2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010K\u001a\u00020LH\u0016J%\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\bN\u0010OJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010P\u001a\u00020@2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\bQ\u0010DJ!\u0010R\u001a\u00020\u001c*\u0004\u0018\u00010\u001c2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001c0TH\u0000¢\u0006\u0002\bUR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0019\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0019\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0019\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u0019\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b/\u0010\u001fR\u0019\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b0\u0010\u001fR\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b1\u0010\u001fR\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b2\u0010\u001fR\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b3\u0010\u001fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b4\u0010\u001fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b5\u0010\u001fR\u0019\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b6\u0010\u001fR\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b7\u0010\u001fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b8\u0010\u001fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b9\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006V"}, m195d2 = {"Landroidx/compose/material3/DatePickerColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getCurrentYearContentColor-0d7_KjU", "getDateTextFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "getDayContentColor-0d7_KjU", "getDayInSelectionRangeContainerColor-0d7_KjU", "getDayInSelectionRangeContentColor-0d7_KjU", "getDisabledDayContentColor-0d7_KjU", "getDisabledSelectedDayContainerColor-0d7_KjU", "getDisabledSelectedDayContentColor-0d7_KjU", "getDisabledSelectedYearContainerColor-0d7_KjU", "getDisabledSelectedYearContentColor-0d7_KjU", "getDisabledYearContentColor-0d7_KjU", "getDividerColor-0d7_KjU", "getHeadlineContentColor-0d7_KjU", "getNavigationContentColor-0d7_KjU", "getSelectedDayContainerColor-0d7_KjU", "getSelectedDayContentColor-0d7_KjU", "getSelectedYearContainerColor-0d7_KjU", "getSelectedYearContentColor-0d7_KjU", "getSubheadContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getTodayContentColor-0d7_KjU", "getTodayDateBorderColor-0d7_KjU", "getWeekdayContentColor-0d7_KjU", "getYearContentColor-0d7_KjU", "copy", "copy-tNwlRmA", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;)Landroidx/compose/material3/DatePickerColors;", "dayContainerColor", "Landroidx/compose/runtime/State;", "selected", "", "enabled", "animate", "dayContainerColor$material3_release", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isToday", "inRange", "dayContentColor$material3_release", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "yearContainerColor", "yearContainerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "currentYear", "yearContentColor$material3_release", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3_release", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DatePickerColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long currentYearContentColor;
    private final TextFieldColors dateTextFieldColors;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long disabledSelectedYearContainerColor;
    private final long disabledSelectedYearContentColor;
    private final long disabledYearContentColor;
    private final long dividerColor;
    private final long headlineContentColor;
    private final long navigationContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    public /* synthetic */ DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, textFieldColors);
    }

    private DatePickerColors(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long navigationContentColor, long yearContentColor, long disabledYearContentColor, long currentYearContentColor, long selectedYearContentColor, long disabledSelectedYearContentColor, long selectedYearContainerColor, long disabledSelectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContainerColor, long dayInSelectionRangeContentColor, long dividerColor, TextFieldColors dateTextFieldColors) {
        this.containerColor = containerColor;
        this.titleContentColor = titleContentColor;
        this.headlineContentColor = headlineContentColor;
        this.weekdayContentColor = weekdayContentColor;
        this.subheadContentColor = subheadContentColor;
        this.navigationContentColor = navigationContentColor;
        this.yearContentColor = yearContentColor;
        this.disabledYearContentColor = disabledYearContentColor;
        this.currentYearContentColor = currentYearContentColor;
        this.selectedYearContentColor = selectedYearContentColor;
        this.disabledSelectedYearContentColor = disabledSelectedYearContentColor;
        this.selectedYearContainerColor = selectedYearContainerColor;
        this.disabledSelectedYearContainerColor = disabledSelectedYearContainerColor;
        this.dayContentColor = dayContentColor;
        this.disabledDayContentColor = disabledDayContentColor;
        this.selectedDayContentColor = selectedDayContentColor;
        this.disabledSelectedDayContentColor = disabledSelectedDayContentColor;
        this.selectedDayContainerColor = selectedDayContainerColor;
        this.disabledSelectedDayContainerColor = disabledSelectedDayContainerColor;
        this.todayContentColor = todayContentColor;
        this.todayDateBorderColor = todayDateBorderColor;
        this.dayInSelectionRangeContainerColor = dayInSelectionRangeContainerColor;
        this.dayInSelectionRangeContentColor = dayInSelectionRangeContentColor;
        this.dividerColor = dividerColor;
        this.dateTextFieldColors = dateTextFieldColors;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTitleContentColor() {
        return this.titleContentColor;
    }

    /* JADX INFO: renamed from: getHeadlineContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getHeadlineContentColor() {
        return this.headlineContentColor;
    }

    /* JADX INFO: renamed from: getWeekdayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getWeekdayContentColor() {
        return this.weekdayContentColor;
    }

    /* JADX INFO: renamed from: getSubheadContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSubheadContentColor() {
        return this.subheadContentColor;
    }

    /* JADX INFO: renamed from: getNavigationContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getNavigationContentColor() {
        return this.navigationContentColor;
    }

    /* JADX INFO: renamed from: getYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getYearContentColor() {
        return this.yearContentColor;
    }

    /* JADX INFO: renamed from: getDisabledYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledYearContentColor() {
        return this.disabledYearContentColor;
    }

    /* JADX INFO: renamed from: getCurrentYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCurrentYearContentColor() {
        return this.currentYearContentColor;
    }

    /* JADX INFO: renamed from: getSelectedYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedYearContentColor() {
        return this.selectedYearContentColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedYearContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedYearContentColor() {
        return this.disabledSelectedYearContentColor;
    }

    /* JADX INFO: renamed from: getSelectedYearContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedYearContainerColor() {
        return this.selectedYearContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedYearContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedYearContainerColor() {
        return this.disabledSelectedYearContainerColor;
    }

    /* JADX INFO: renamed from: getDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDayContentColor() {
        return this.dayContentColor;
    }

    /* JADX INFO: renamed from: getDisabledDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledDayContentColor() {
        return this.disabledDayContentColor;
    }

    /* JADX INFO: renamed from: getSelectedDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedDayContentColor() {
        return this.selectedDayContentColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedDayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedDayContentColor() {
        return this.disabledSelectedDayContentColor;
    }

    /* JADX INFO: renamed from: getSelectedDayContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedDayContainerColor() {
        return this.selectedDayContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledSelectedDayContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSelectedDayContainerColor() {
        return this.disabledSelectedDayContainerColor;
    }

    /* JADX INFO: renamed from: getTodayContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTodayContentColor() {
        return this.todayContentColor;
    }

    /* JADX INFO: renamed from: getTodayDateBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTodayDateBorderColor() {
        return this.todayDateBorderColor;
    }

    /* JADX INFO: renamed from: getDayInSelectionRangeContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDayInSelectionRangeContainerColor() {
        return this.dayInSelectionRangeContainerColor;
    }

    /* JADX INFO: renamed from: getDayInSelectionRangeContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDayInSelectionRangeContentColor() {
        return this.dayInSelectionRangeContentColor;
    }

    /* JADX INFO: renamed from: getDividerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDividerColor() {
        return this.dividerColor;
    }

    public final TextFieldColors getDateTextFieldColors() {
        return this.dateTextFieldColors;
    }

    /* JADX INFO: renamed from: copy-tNwlRmA, reason: not valid java name */
    public final DatePickerColors m2147copytNwlRmA(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long navigationContentColor, long yearContentColor, long disabledYearContentColor, long currentYearContentColor, long selectedYearContentColor, long disabledSelectedYearContentColor, long selectedYearContainerColor, long disabledSelectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContainerColor, long dayInSelectionRangeContentColor, long dividerColor, TextFieldColors dateTextFieldColors) {
        return new DatePickerColors((containerColor > 16L ? 1 : (containerColor == 16L ? 0 : -1)) != 0 ? containerColor : this.containerColor, (titleContentColor > 16L ? 1 : (titleContentColor == 16L ? 0 : -1)) != 0 ? titleContentColor : this.titleContentColor, (headlineContentColor > 16L ? 1 : (headlineContentColor == 16L ? 0 : -1)) != 0 ? headlineContentColor : this.headlineContentColor, (weekdayContentColor > 16L ? 1 : (weekdayContentColor == 16L ? 0 : -1)) != 0 ? weekdayContentColor : this.weekdayContentColor, (subheadContentColor > 16L ? 1 : (subheadContentColor == 16L ? 0 : -1)) != 0 ? subheadContentColor : this.subheadContentColor, (navigationContentColor > 16L ? 1 : (navigationContentColor == 16L ? 0 : -1)) != 0 ? navigationContentColor : this.navigationContentColor, (yearContentColor > 16L ? 1 : (yearContentColor == 16L ? 0 : -1)) != 0 ? yearContentColor : this.yearContentColor, (disabledYearContentColor > 16L ? 1 : (disabledYearContentColor == 16L ? 0 : -1)) != 0 ? disabledYearContentColor : this.disabledYearContentColor, (currentYearContentColor > 16L ? 1 : (currentYearContentColor == 16L ? 0 : -1)) != 0 ? currentYearContentColor : this.currentYearContentColor, (selectedYearContentColor > 16L ? 1 : (selectedYearContentColor == 16L ? 0 : -1)) != 0 ? selectedYearContentColor : this.selectedYearContentColor, (disabledSelectedYearContentColor > 16L ? 1 : (disabledSelectedYearContentColor == 16L ? 0 : -1)) != 0 ? disabledSelectedYearContentColor : this.disabledSelectedYearContentColor, (selectedYearContainerColor > 16L ? 1 : (selectedYearContainerColor == 16L ? 0 : -1)) != 0 ? selectedYearContainerColor : this.selectedYearContainerColor, (disabledSelectedYearContainerColor > 16L ? 1 : (disabledSelectedYearContainerColor == 16L ? 0 : -1)) != 0 ? disabledSelectedYearContainerColor : this.disabledSelectedYearContainerColor, (dayContentColor > 16L ? 1 : (dayContentColor == 16L ? 0 : -1)) != 0 ? dayContentColor : this.dayContentColor, (disabledDayContentColor > 16L ? 1 : (disabledDayContentColor == 16L ? 0 : -1)) != 0 ? disabledDayContentColor : this.disabledDayContentColor, (selectedDayContentColor > 16L ? 1 : (selectedDayContentColor == 16L ? 0 : -1)) != 0 ? selectedDayContentColor : this.selectedDayContentColor, (disabledSelectedDayContentColor > 16L ? 1 : (disabledSelectedDayContentColor == 16L ? 0 : -1)) != 0 ? disabledSelectedDayContentColor : this.disabledSelectedDayContentColor, (selectedDayContainerColor > 16L ? 1 : (selectedDayContainerColor == 16L ? 0 : -1)) != 0 ? selectedDayContainerColor : this.selectedDayContainerColor, (disabledSelectedDayContainerColor > 16L ? 1 : (disabledSelectedDayContainerColor == 16L ? 0 : -1)) != 0 ? disabledSelectedDayContainerColor : this.disabledSelectedDayContainerColor, (todayContentColor > 16L ? 1 : (todayContentColor == 16L ? 0 : -1)) != 0 ? todayContentColor : this.todayContentColor, (todayDateBorderColor > 16L ? 1 : (todayDateBorderColor == 16L ? 0 : -1)) != 0 ? todayDateBorderColor : this.todayDateBorderColor, (dayInSelectionRangeContainerColor > 16L ? 1 : (dayInSelectionRangeContainerColor == 16L ? 0 : -1)) != 0 ? dayInSelectionRangeContainerColor : this.dayInSelectionRangeContainerColor, (dayInSelectionRangeContentColor > 16L ? 1 : (dayInSelectionRangeContentColor == 16L ? 0 : -1)) != 0 ? dayInSelectionRangeContentColor : this.dayInSelectionRangeContentColor, dividerColor != 16 ? dividerColor : this.dividerColor, takeOrElse$material3_release(dateTextFieldColors, new Function0<TextFieldColors>() { // from class: androidx.compose.material3.DatePickerColors$copy$25
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldColors invoke() {
                return this.this$0.getDateTextFieldColors();
            }
        }), null);
    }

    public final TextFieldColors takeOrElse$material3_release(TextFieldColors $this$takeOrElse, Function0<TextFieldColors> function0) {
        return $this$takeOrElse == null ? function0.invoke() : $this$takeOrElse;
    }

    public final State<Color> dayContentColor$material3_release(boolean isToday, boolean selected, boolean inRange, boolean enabled, Composer $composer, int $changed) {
        long target;
        State<Color> stateM351animateColorAsStateeuL9pac;
        ComposerKt.sourceInformationMarkerStart($composer, -1233694918, "C(dayContentColor)P(2,3,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1233694918, $changed, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:910)");
        }
        if (selected && enabled) {
            target = this.selectedDayContentColor;
        } else if (selected && !enabled) {
            target = this.disabledSelectedDayContentColor;
        } else if (inRange && enabled) {
            target = this.dayInSelectionRangeContentColor;
        } else if (inRange && !enabled) {
            target = this.disabledDayContentColor;
        } else if (isToday) {
            target = this.todayContentColor;
        } else {
            target = enabled ? this.dayContentColor : this.disabledDayContentColor;
        }
        if (inRange) {
            $composer.startReplaceGroup(379023376);
            ComposerKt.sourceInformation($composer, "922@43447L28");
            stateM351animateColorAsStateeuL9pac = SnapshotStateKt.rememberUpdatedState(Color.m4281boximpl(target), $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(379023512);
            ComposerKt.sourceInformation($composer, "925@43583L134");
            stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer, 0, 12);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateM351animateColorAsStateeuL9pac;
    }

    public final State<Color> dayContainerColor$material3_release(boolean selected, boolean enabled, boolean animate, Composer $composer, int $changed) {
        long target;
        State<Color> stateRememberUpdatedState;
        ComposerKt.sourceInformationMarkerStart($composer, -1240482658, "C(dayContainerColor)P(2,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1240482658, $changed, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:944)");
        }
        if (selected) {
            target = enabled ? this.selectedDayContainerColor : this.disabledSelectedDayContainerColor;
        } else {
            target = Color.INSTANCE.m4326getTransparent0d7_KjU();
        }
        if (animate) {
            $composer.startReplaceGroup(1577423128);
            ComposerKt.sourceInformation($composer, "951@44407L134");
            stateRememberUpdatedState = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer, 0, 12);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(1577423292);
            ComposerKt.sourceInformation($composer, "956@44571L28");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4281boximpl(target), $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateRememberUpdatedState;
    }

    public final State<Color> yearContentColor$material3_release(boolean currentYear, boolean selected, boolean enabled, Composer $composer, int $changed) {
        long target;
        ComposerKt.sourceInformationMarkerStart($composer, 874111097, "C(yearContentColor)P(!1,2)981@45411L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(874111097, $changed, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:972)");
        }
        if (selected && enabled) {
            target = this.selectedYearContentColor;
        } else if (selected && !enabled) {
            target = this.disabledSelectedYearContentColor;
        } else if (currentYear) {
            target = this.currentYearContentColor;
        } else {
            target = enabled ? this.yearContentColor : this.disabledYearContentColor;
        }
        State<Color> stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateM351animateColorAsStateeuL9pac;
    }

    public final State<Color> yearContainerColor$material3_release(boolean selected, boolean enabled, Composer $composer, int $changed) {
        long target;
        ComposerKt.sourceInformationMarkerStart($composer, -1306331107, "C(yearContainerColor)P(1)1000@46070L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1306331107, $changed, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:994)");
        }
        if (selected) {
            target = enabled ? this.selectedYearContainerColor : this.disabledSelectedYearContainerColor;
        } else {
            target = Color.INSTANCE.m4326getTransparent0d7_KjU();
        }
        State<Color> stateM351animateColorAsStateeuL9pac = SingleValueAnimationKt.m351animateColorAsStateeuL9pac(target, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateM351animateColorAsStateeuL9pac;
    }

    public boolean equals(Object other) {
        return (other instanceof DatePickerColors) && Color.m4292equalsimpl0(this.containerColor, ((DatePickerColors) other).containerColor) && Color.m4292equalsimpl0(this.titleContentColor, ((DatePickerColors) other).titleContentColor) && Color.m4292equalsimpl0(this.headlineContentColor, ((DatePickerColors) other).headlineContentColor) && Color.m4292equalsimpl0(this.weekdayContentColor, ((DatePickerColors) other).weekdayContentColor) && Color.m4292equalsimpl0(this.subheadContentColor, ((DatePickerColors) other).subheadContentColor) && Color.m4292equalsimpl0(this.yearContentColor, ((DatePickerColors) other).yearContentColor) && Color.m4292equalsimpl0(this.disabledYearContentColor, ((DatePickerColors) other).disabledYearContentColor) && Color.m4292equalsimpl0(this.currentYearContentColor, ((DatePickerColors) other).currentYearContentColor) && Color.m4292equalsimpl0(this.selectedYearContentColor, ((DatePickerColors) other).selectedYearContentColor) && Color.m4292equalsimpl0(this.disabledSelectedYearContentColor, ((DatePickerColors) other).disabledSelectedYearContentColor) && Color.m4292equalsimpl0(this.selectedYearContainerColor, ((DatePickerColors) other).selectedYearContainerColor) && Color.m4292equalsimpl0(this.disabledSelectedYearContainerColor, ((DatePickerColors) other).disabledSelectedYearContainerColor) && Color.m4292equalsimpl0(this.dayContentColor, ((DatePickerColors) other).dayContentColor) && Color.m4292equalsimpl0(this.disabledDayContentColor, ((DatePickerColors) other).disabledDayContentColor) && Color.m4292equalsimpl0(this.selectedDayContentColor, ((DatePickerColors) other).selectedDayContentColor) && Color.m4292equalsimpl0(this.disabledSelectedDayContentColor, ((DatePickerColors) other).disabledSelectedDayContentColor) && Color.m4292equalsimpl0(this.selectedDayContainerColor, ((DatePickerColors) other).selectedDayContainerColor) && Color.m4292equalsimpl0(this.disabledSelectedDayContainerColor, ((DatePickerColors) other).disabledSelectedDayContainerColor) && Color.m4292equalsimpl0(this.todayContentColor, ((DatePickerColors) other).todayContentColor) && Color.m4292equalsimpl0(this.todayDateBorderColor, ((DatePickerColors) other).todayDateBorderColor) && Color.m4292equalsimpl0(this.dayInSelectionRangeContainerColor, ((DatePickerColors) other).dayInSelectionRangeContainerColor) && Color.m4292equalsimpl0(this.dayInSelectionRangeContentColor, ((DatePickerColors) other).dayInSelectionRangeContentColor);
    }

    public int hashCode() {
        int result = Color.m4298hashCodeimpl(this.containerColor);
        return (((((((((((((((((((((((((((((((((((((((((result * 31) + Color.m4298hashCodeimpl(this.titleContentColor)) * 31) + Color.m4298hashCodeimpl(this.headlineContentColor)) * 31) + Color.m4298hashCodeimpl(this.weekdayContentColor)) * 31) + Color.m4298hashCodeimpl(this.subheadContentColor)) * 31) + Color.m4298hashCodeimpl(this.yearContentColor)) * 31) + Color.m4298hashCodeimpl(this.disabledYearContentColor)) * 31) + Color.m4298hashCodeimpl(this.currentYearContentColor)) * 31) + Color.m4298hashCodeimpl(this.selectedYearContentColor)) * 31) + Color.m4298hashCodeimpl(this.disabledSelectedYearContentColor)) * 31) + Color.m4298hashCodeimpl(this.selectedYearContainerColor)) * 31) + Color.m4298hashCodeimpl(this.disabledSelectedYearContainerColor)) * 31) + Color.m4298hashCodeimpl(this.dayContentColor)) * 31) + Color.m4298hashCodeimpl(this.disabledDayContentColor)) * 31) + Color.m4298hashCodeimpl(this.selectedDayContentColor)) * 31) + Color.m4298hashCodeimpl(this.disabledSelectedDayContentColor)) * 31) + Color.m4298hashCodeimpl(this.selectedDayContainerColor)) * 31) + Color.m4298hashCodeimpl(this.disabledSelectedDayContainerColor)) * 31) + Color.m4298hashCodeimpl(this.todayContentColor)) * 31) + Color.m4298hashCodeimpl(this.todayDateBorderColor)) * 31) + Color.m4298hashCodeimpl(this.dayInSelectionRangeContainerColor)) * 31) + Color.m4298hashCodeimpl(this.dayInSelectionRangeContentColor);
    }
}
