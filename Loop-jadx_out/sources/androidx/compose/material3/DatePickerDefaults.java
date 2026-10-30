package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarLocale_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.semantics.LiveRegionMode;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(J$\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010-J\u008e\u0002\u0010,\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u00020/2\b\b\u0002\u00104\u001a\u00020/2\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020/2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020/2\b\b\u0002\u0010F\u001a\u00020/2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ$\u0010#\u001a\u00020$2\b\b\u0002\u0010K\u001a\u00020\r2\b\b\u0002\u0010L\u001a\u00020\r2\b\b\u0002\u0010M\u001a\u00020\rJ'\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0001¢\u0006\u0004\bU\u0010VR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, m195d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "()V", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "YearAbbrMonthDaySkeleton", "", "YearMonthSkeleton", "YearMonthWeekdayDaySkeleton", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultDatePickerColors", "Landroidx/compose/material3/DatePickerColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "DatePickerHeadline", "", "selectedDateMillis", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DatePickerHeadline-3kbWawI", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DatePickerTitle", "DatePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "yearSelectionSkeleton", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3_release", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final IntRange YearRange = new IntRange(1900, 2100);
    private static final float TonalElevation = ElevationTokens.INSTANCE.m3273getLevel0D9Ej5fM();
    private static final SelectableDates AllDates = new SelectableDates() { // from class: androidx.compose.material3.DatePickerDefaults$AllDates$1
        @Override // androidx.compose.material3.SelectableDates
        public /* synthetic */ boolean isSelectableDate(long j) {
            return SelectableDates.CC.$default$isSelectableDate(this, j);
        }

        @Override // androidx.compose.material3.SelectableDates
        public /* synthetic */ boolean isSelectableYear(int i) {
            return SelectableDates.CC.$default$isSelectableYear(this, i);
        }
    };

    private DatePickerDefaults() {
    }

    public final DatePickerColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -275219611, "C(colors)448@18783L11,448@18795L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-275219611, $changed, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:448)");
        }
        DatePickerColors defaultDatePickerColors = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, ($changed << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultDatePickerColors;
    }

    /* JADX INFO: renamed from: colors-bSRYm20, reason: not valid java name */
    public final DatePickerColors m2174colorsbSRYm20(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long navigationContentColor, long yearContentColor, long disabledYearContentColor, long currentYearContentColor, long selectedYearContentColor, long disabledSelectedYearContentColor, long selectedYearContainerColor, long disabledSelectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContentColor, long dayInSelectionRangeContainerColor, long dividerColor, TextFieldColors dateTextFieldColors, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1991626358, "C(colors)P(0:c#ui.graphics.Color,20:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,19:c#ui.graphics.Color,14:c#ui.graphics.Color,24:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,18:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,21:c#ui.graphics.Color,22:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color)517@23061L11,517@23073L23:DatePicker.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long titleContentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : titleContentColor;
        long headlineContentColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : headlineContentColor;
        long weekdayContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : weekdayContentColor;
        long subheadContentColor2 = (i & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : subheadContentColor;
        long navigationContentColor2 = (i & 32) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : navigationContentColor;
        long yearContentColor2 = (i & 64) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : yearContentColor;
        long disabledYearContentColor2 = (i & 128) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledYearContentColor;
        long currentYearContentColor2 = (i & 256) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : currentYearContentColor;
        long selectedYearContentColor2 = (i & 512) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : selectedYearContentColor;
        long disabledSelectedYearContentColor2 = (i & 1024) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledSelectedYearContentColor;
        long selectedYearContainerColor2 = (i & 2048) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : selectedYearContainerColor;
        long disabledSelectedYearContainerColor2 = (i & 4096) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledSelectedYearContainerColor;
        long dayContentColor2 = (i & 8192) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : dayContentColor;
        long disabledDayContentColor2 = (i & 16384) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledDayContentColor;
        long selectedDayContentColor2 = (32768 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : selectedDayContentColor;
        long disabledSelectedDayContentColor2 = (65536 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledSelectedDayContentColor;
        long selectedDayContainerColor2 = (131072 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : selectedDayContainerColor;
        long disabledSelectedDayContainerColor2 = (262144 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledSelectedDayContainerColor;
        long todayContentColor2 = (524288 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : todayContentColor;
        long todayDateBorderColor2 = (1048576 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : todayDateBorderColor;
        long dayInSelectionRangeContentColor2 = (2097152 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : dayInSelectionRangeContentColor;
        long dayInSelectionRangeContainerColor2 = (4194304 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : dayInSelectionRangeContainerColor;
        long dividerColor2 = (8388608 & i) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : dividerColor;
        TextFieldColors dateTextFieldColors2 = (i & 16777216) != 0 ? null : dateTextFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991626358, $changed, $changed1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:517)");
        }
        DatePickerColors datePickerColorsM2147copytNwlRmA = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, ($changed2 >> 12) & 112).m2147copytNwlRmA(containerColor2, titleContentColor2, headlineContentColor2, weekdayContentColor2, subheadContentColor2, navigationContentColor2, yearContentColor2, disabledYearContentColor2, currentYearContentColor2, selectedYearContentColor2, disabledSelectedYearContentColor2, selectedYearContainerColor2, disabledSelectedYearContainerColor2, dayContentColor2, disabledDayContentColor2, selectedDayContentColor2, disabledSelectedDayContentColor2, selectedDayContainerColor2, disabledSelectedDayContainerColor2, todayContentColor2, todayDateBorderColor2, dayInSelectionRangeContainerColor2, dayInSelectionRangeContentColor2, dividerColor2, dateTextFieldColors2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return datePickerColorsM2147copytNwlRmA;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme $this$defaultDatePickerColors, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1180555308, "C:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180555308, $changed, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:547)");
        }
        DatePickerColors it = $this$defaultDatePickerColors.getDefaultDatePickerColorsCached();
        $composer.startReplaceGroup(117459873);
        ComposerKt.sourceInformation($composer, "*596@28086L30");
        if (it == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getContainerColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor());
            long onSurfaceVariant = $this$defaultDatePickerColors.getOnSurfaceVariant();
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor());
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken7) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken7) : 0.0f);
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor());
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor());
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor());
            long jM4289copywmQWz5c2 = Color.m4289copywmQWz5c(jFromToken10, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken10) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken10) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken10) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken10) : 0.0f);
            long jFromToken11 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor());
            long jFromToken12 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor());
            long jM4289copywmQWz5c3 = Color.m4289copywmQWz5c(jFromToken12, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken12) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken12) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken12) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken12) : 0.0f);
            long jFromToken13 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor());
            long jFromToken14 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor());
            long jM4289copywmQWz5c4 = Color.m4289copywmQWz5c(jFromToken14, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken14) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken14) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken14) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken14) : 0.0f);
            long jFromToken15 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor());
            long jFromToken16 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor());
            long jM4289copywmQWz5c5 = Color.m4289copywmQWz5c(jFromToken16, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken16) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken16) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken16) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken16) : 0.0f);
            long jFromToken17 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor());
            long jFromToken18 = ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor());
            it = new DatePickerColors(jFromToken, jFromToken2, jFromToken3, jFromToken4, jFromToken5, onSurfaceVariant, jFromToken6, jM4289copywmQWz5c, jFromToken8, jFromToken9, jM4289copywmQWz5c2, jFromToken11, jM4289copywmQWz5c3, jFromToken13, jM4289copywmQWz5c4, jFromToken15, jM4289copywmQWz5c5, jFromToken17, Color.m4289copywmQWz5c(jFromToken18, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken18) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken18) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken18) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken18) : 0.0f), ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken($this$defaultDatePickerColors, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken($this$defaultDatePickerColors, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors($this$defaultDatePickerColors, $composer, ($changed & 14) | 48), null);
            $this$defaultDatePickerColors.setDefaultDatePickerColorsCached$material3_release(it);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return it;
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = YearMonthSkeleton;
        }
        if ((i & 2) != 0) {
            str2 = YearAbbrMonthDaySkeleton;
        }
        if ((i & 4) != 0) {
            str3 = YearMonthWeekdayDaySkeleton;
        }
        return datePickerDefaults.dateFormatter(str, str2, str3);
    }

    public final DatePickerFormatter dateFormatter(String yearSelectionSkeleton, String selectedDateSkeleton, String selectedDateDescriptionSkeleton) {
        return new DatePickerFormatterImpl(yearSelectionSkeleton, selectedDateSkeleton, selectedDateDescriptionSkeleton);
    }

    /* JADX INFO: renamed from: DatePickerTitle-hOD91z4, reason: not valid java name */
    public final void m2173DatePickerTitlehOD91z4(final int displayMode, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(327413563);
        ComposerKt.sourceInformation($composer2, "C(DatePickerTitle)P(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(displayMode) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer2.getSkipping()) {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(327413563, $dirty2, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:636)");
            }
            if (!DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2220getPickerjFl4v0())) {
                if (DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2219getInputjFl4v0())) {
                    $composer2.startReplaceGroup(-2065100680);
                    ComposerKt.sourceInformation($composer2, "644@30196L42,643@30167L122");
                    Strings.Companion companion = Strings.INSTANCE;
                    TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_input_title), $composer2, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-2065100548);
                    $composer2.endReplaceGroup();
                }
            } else {
                $composer2.startReplaceGroup(-2065100838);
                ComposerKt.sourceInformation($composer2, "639@30038L43,638@30009L123");
                Strings.Companion companion2 = Strings.INSTANCE;
                TextKt.m2817Text4IGK_g(Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_title), $composer2, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    this.$tmp0_rcvr.m2173DatePickerTitlehOD91z4(displayMode, modifier5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: DatePickerHeadline-3kbWawI, reason: not valid java name */
    public final void m2172DatePickerHeadline3kbWawI(final Long selectedDateMillis, final int displayMode, final DatePickerFormatter dateFormatter, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String headlineText;
        Object value$iv;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1502835813);
        ComposerKt.sourceInformation($composer2, "C(DatePickerHeadline)P(3,1:c#material3.DisplayMode)667@31066L15,696@32259L123,694@32178L240:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(selectedDateMillis) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(displayMode) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer2.changed(dateFormatter) : $composer2.changedInstance(dateFormatter) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1502835813, $dirty2, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:666)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale($composer2, 0);
            String formattedDate = DatePickerFormatter.CC.formatDate$default(dateFormatter, selectedDateMillis, defaultLocale, false, 4, null);
            String verboseDateDescription = dateFormatter.formatDate(selectedDateMillis, defaultLocale, true);
            $composer2.startReplaceGroup(729794098);
            String strM3086getString2EP1pXo = "";
            ComposerKt.sourceInformation($composer2, "");
            if (verboseDateDescription == null) {
                if (DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2220getPickerjFl4v0())) {
                    $composer2.startReplaceGroup(729794314);
                    ComposerKt.sourceInformation($composer2, "677@31479L51");
                    Strings.Companion companion = Strings.INSTANCE;
                    verboseDateDescription = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_no_selection_description), $composer2, 0);
                    $composer2.endReplaceGroup();
                } else if (DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2219getInputjFl4v0())) {
                    $composer2.startReplaceGroup(729794399);
                    ComposerKt.sourceInformation($composer2, "678@31564L46");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    verboseDateDescription = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_input_no_input_description), $composer2, 0);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(1148791966);
                    $composer2.endReplaceGroup();
                    verboseDateDescription = "";
                }
            }
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(729794507);
            ComposerKt.sourceInformation($composer2, "");
            if (formattedDate != null) {
                headlineText = formattedDate;
            } else if (DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2220getPickerjFl4v0())) {
                $composer2.startReplaceGroup(729794579);
                ComposerKt.sourceInformation($composer2, "683@31744L37");
                Strings.Companion companion3 = Strings.INSTANCE;
                String strM3086getString2EP1pXo2 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_headline), $composer2, 0);
                $composer2.endReplaceGroup();
                headlineText = strM3086getString2EP1pXo2;
            } else if (DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2219getInputjFl4v0())) {
                $composer2.startReplaceGroup(729794650);
                ComposerKt.sourceInformation($composer2, "684@31815L36");
                Strings.Companion companion4 = Strings.INSTANCE;
                String strM3086getString2EP1pXo3 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_input_headline), $composer2, 0);
                $composer2.endReplaceGroup();
                headlineText = strM3086getString2EP1pXo3;
            } else {
                $composer2.startReplaceGroup(1148799437);
                $composer2.endReplaceGroup();
                headlineText = "";
            }
            $composer2.endReplaceGroup();
            if (DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2220getPickerjFl4v0())) {
                $composer2.startReplaceGroup(729794810);
                ComposerKt.sourceInformation($composer2, "689@31975L48");
                Strings.Companion companion5 = Strings.INSTANCE;
                strM3086getString2EP1pXo = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_picker_headline_description), $composer2, 0);
                $composer2.endReplaceGroup();
            } else if (DisplayMode.m2215equalsimpl0(displayMode, DisplayMode.INSTANCE.m2219getInputjFl4v0())) {
                $composer2.startReplaceGroup(729794892);
                ComposerKt.sourceInformation($composer2, "690@32057L47");
                Strings.Companion companion6 = Strings.INSTANCE;
                strM3086getString2EP1pXo = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_input_headline_description), $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1148807280);
                $composer2.endReplaceGroup();
            }
            final String headlineDescription = String.format(strM3086getString2EP1pXo, Arrays.copyOf(new Object[]{verboseDateDescription}, 1));
            Intrinsics.checkNotNullExpressionValue(headlineDescription, "format(this, *args)");
            ComposerKt.sourceInformationMarkerStart($composer2, 729795094, "CC(remember):DatePicker.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(headlineDescription);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.m6078setLiveRegionhR3wRGc($this$semantics, LiveRegionMode.INSTANCE.m6054getPolite0phEisY());
                        SemanticsPropertiesKt.setContentDescription($this$semantics, headlineDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier5 = modifier4;
            TextKt.m2817Text4IGK_g(headlineText, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) value$iv, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 3072, 122876);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    this.$tmp9_rcvr.m2172DatePickerHeadline3kbWawI(selectedDateMillis, displayMode, dateFormatter, modifier6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer $composer, int $changed, int i) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -2036003494, "C(rememberSnapFlingBehavior)P(1)716@32906L607:DatePicker.kt#uh7d8r");
        DecayAnimationSpec<Float> decayAnimationSpecExponentialDecay$default = (i & 2) != 0 ? DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, null) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, $changed, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:715)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1872610576, "CC(remember):DatePicker.kt#9igjgp");
        boolean invalid$iv = $composer.changed(decayAnimationSpecExponentialDecay$default) | (((($changed & 14) ^ 6) > 4 && $composer.changed(lazyListState)) || ($changed & 6) == 4);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            final SnapLayoutInfoProvider original = LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(lazyListState, null, 2, null);
            value$iv = new SnapFlingBehavior(new SnapLayoutInfoProvider() { // from class: androidx.compose.material3.DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1
                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateSnappingOffset(float currentVelocity) {
                    return original.calculateSnappingOffset(currentVelocity);
                }

                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateApproachOffset(float initialVelocity) {
                    return 0.0f;
                }
            }, decayAnimationSpecExponentialDecay$default, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null));
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return snapFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2175getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 700927667, "C739@33885L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, $changed, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:739)");
        }
        Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }
}
