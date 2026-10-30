package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarLocale_androidKt;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.geometry.OffsetKt;
import androidx.compose.p001ui.geometry.Size;
import androidx.compose.p001ui.geometry.SizeKt;
import androidx.compose.p001ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p001ui.graphics.drawscope.DrawScope;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.CustomAccessibilityAction;
import androidx.compose.p001ui.semantics.ScrollAxisRange;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: DateRangePicker.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ak\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a°\u0001\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010.\u001a`\u0010/\u001a\u00020\f2\n\u00100\u001a\u000601j\u0002`22\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a½\u0001\u0010:\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010;\u001a\u0002072:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a°\u0001\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010A\u001a.\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010\u000b\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002\u001aT\u0010J\u001a\u00020\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001ae\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001c2\b\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010P\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 H\u0002¢\u0006\u0002\u0010Q\u001a&\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0000ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, m195d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayedMonthMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/internal/CalendarLocale;", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "displayMode", "SwitchableDateEntryContent-RN-2D1Q", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m865PaddingValuesa9UjIt4$default(C1979Dp.m6801constructorimpl(24), C1979Dp.m6801constructorimpl(20), 0.0f, C1979Dp.m6801constructorimpl(8), 4, null);
    private static final PaddingValues DateRangePickerTitlePadding = PaddingKt.m865PaddingValuesa9UjIt4$default(C1979Dp.m6801constructorimpl(64), 0.0f, C1979Dp.m6801constructorimpl(12), 0.0f, 10, null);
    private static final PaddingValues DateRangePickerHeadlinePadding = PaddingKt.m865PaddingValuesa9UjIt4$default(C1979Dp.m6801constructorimpl(64), 0.0f, C1979Dp.m6801constructorimpl(12), C1979Dp.m6801constructorimpl(12), 2, null);
    private static final float HeaderHeightOffset = C1979Dp.m6801constructorimpl(60);

    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    public static final void DateRangePicker(final DateRangePickerState state, Modifier modifier, DatePickerFormatter dateFormatter, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, boolean showModeToggle, DatePickerColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda2;
        boolean showModeToggle2;
        DatePickerColors datePickerColors;
        final DatePickerFormatter dateFormatter2;
        int i2;
        boolean z;
        int $dirty;
        boolean showModeToggle3;
        final DatePickerColors colors2;
        Object value$iv;
        Object value$iv2;
        DatePickerFormatter dateFormatter3;
        boolean showModeToggle4;
        DatePickerColors colors3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(650830774);
        ComposerKt.sourceInformation($composer2, "C(DateRangePicker)P(5,3,1,6,2,4)95@4562L47,96@4650L185,102@4879L352,112@5319L8,114@5356L15,115@5396L62,131@6012L10,137@6261L1139,116@5463L1937:DateRangePicker.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) != 0) {
                i3 = 128;
            } else {
                if (($changed & 512) == 0 ? $composer2.changed(dateFormatter) : $composer2.changedInstance(dateFormatter)) {
                    i3 = 256;
                } else {
                    i3 = 128;
                }
            }
            $dirty2 |= i3;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            function2RememberComposableLambda = function2;
        } else if (($changed & 3072) == 0) {
            function2RememberComposableLambda = function2;
            $dirty2 |= $composer2.changedInstance(function2RememberComposableLambda) ? 2048 : 1024;
        } else {
            function2RememberComposableLambda = function2;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
            function2RememberComposableLambda2 = function3;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            function2RememberComposableLambda2 = function3;
            $dirty2 |= $composer2.changedInstance(function2RememberComposableLambda2) ? 16384 : 8192;
        } else {
            function2RememberComposableLambda2 = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            showModeToggle2 = showModeToggle;
        } else if ((196608 & $changed) == 0) {
            showModeToggle2 = showModeToggle;
            $dirty2 |= $composer2.changed(showModeToggle2) ? 131072 : 65536;
        } else {
            showModeToggle2 = showModeToggle;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                datePickerColors = colors;
                int i8 = $composer2.changed(datePickerColors) ? 1048576 : 524288;
                $dirty2 |= i8;
            } else {
                datePickerColors = colors;
            }
            $dirty2 |= i8;
        } else {
            datePickerColors = colors;
        }
        if ((599187 & $dirty2) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            dateFormatter3 = dateFormatter;
            modifier3 = modifier2;
            showModeToggle4 = showModeToggle2;
            colors3 = datePickerColors;
            function4 = function2RememberComposableLambda;
            function5 = function2RememberComposableLambda2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1155307080, "CC(remember):DateRangePicker.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    dateFormatter2 = (DatePickerFormatter) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty2 &= -897;
                } else {
                    dateFormatter2 = dateFormatter;
                }
                if (i5 != 0) {
                    i2 = 54;
                    z = true;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-162164694, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePicker.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C97@4684L145:DateRangePicker.kt#uh7d8r");
                            if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-162164694, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:97)");
                                }
                                DateRangePickerDefaults.INSTANCE.m2193DateRangePickerTitlehOD91z4(state.mo2202getDisplayModejFl4v0(), PaddingKt.padding(Modifier.INSTANCE, DateRangePickerKt.DateRangePickerTitlePadding), $composer3, 432, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }, $composer2, 54);
                } else {
                    i2 = 54;
                    z = true;
                }
                if (i6 != 0) {
                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-185279404, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePicker.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C103@4913L312:DateRangePicker.kt#uh7d8r");
                            if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-185279404, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:103)");
                                }
                                DateRangePickerDefaults.INSTANCE.m2192DateRangePickerHeadlinev84Udv0(state.getSelectedStartDateMillis(), state.getSelectedEndDateMillis(), state.mo2202getDisplayModejFl4v0(), dateFormatter2, PaddingKt.padding(Modifier.INSTANCE, DateRangePickerKt.DateRangePickerHeadlinePadding), $composer3, 221184, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }, $composer2, i2);
                }
                if (i7 != 0) {
                    showModeToggle2 = true;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier4;
                    $dirty = $dirty2 & (-3670017);
                    colors2 = DatePickerDefaults.INSTANCE.colors($composer2, 6);
                    showModeToggle3 = showModeToggle2;
                } else {
                    modifier2 = modifier4;
                    $dirty = $dirty2;
                    showModeToggle3 = showModeToggle2;
                    colors2 = datePickerColors;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 64) != 0) {
                    dateFormatter2 = dateFormatter;
                    $dirty = (-3670017) & $dirty2;
                    showModeToggle3 = showModeToggle2;
                    colors2 = datePickerColors;
                } else {
                    dateFormatter2 = dateFormatter;
                    $dirty = $dirty2;
                    showModeToggle3 = showModeToggle2;
                    colors2 = datePickerColors;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(650830774, $dirty, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:113)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1155306246, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(defaultLocale);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = CalendarModel_androidKt.createCalendarModel(defaultLocale);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final CalendarModel calendarModel = (CalendarModel) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(-1155306051);
            ComposerKt.sourceInformation($composer2, "121@5625L299");
            ComposableLambda composableLambdaRememberComposableLambda = showModeToggle3 ? ComposableLambdaKt.rememberComposableLambda(-1490010652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePicker.4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv3;
                    ComposerKt.sourceInformation($composer3, "C125@5841L50,122@5643L267:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1490010652, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:122)");
                        }
                        Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                        int iMo2202getDisplayModejFl4v0 = state.mo2202getDisplayModejFl4v0();
                        ComposerKt.sourceInformationMarkerStart($composer3, -1467496488, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(state);
                        final DateRangePickerState dateRangePickerState = state;
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                    m2200invokevCnGnXg(displayMode.getValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-vCnGnXg, reason: not valid java name */
                                public final void m2200invokevCnGnXg(int displayMode) {
                                    dateRangePickerState.mo2203setDisplayModevCnGnXg(displayMode);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        DatePickerKt.m2181DisplayModeToggleButtontER2X8s(modifierPadding, iMo2202getDisplayModejFl4v0, (Function1) value$iv3, $composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54) : null;
            $composer2.endReplaceGroup();
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont());
            float arg0$iv = DatePickerModalTokens.INSTANCE.m3251getRangeSelectionHeaderContainerHeightD9Ej5fM();
            float other$iv = HeaderHeightOffset;
            dateFormatter3 = dateFormatter2;
            DatePickerKt.m2177DateEntryContainerau3_HiA(modifier2, function2RememberComposableLambda, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, colors2, textStyleFromToken, C1979Dp.m6801constructorimpl(arg0$iv - other$iv), ComposableLambdaKt.rememberComposableLambda(-57534331, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePicker.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv3;
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer3, "C143@6578L467,154@7084L91,138@6271L1123:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-57534331, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:138)");
                        }
                        Long selectedStartDateMillis = state.getSelectedStartDateMillis();
                        Long selectedEndDateMillis = state.getSelectedEndDateMillis();
                        long displayedMonthMillis = state.getDisplayedMonthMillis();
                        int iMo2202getDisplayModejFl4v0 = state.mo2202getDisplayModejFl4v0();
                        ComposerKt.sourceInformationMarkerStart($composer3, -1467495751, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(state);
                        final DateRangePickerState dateRangePickerState = state;
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function2) new Function2<Long, Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                    invoke2(l, l2);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Long startDateMillis, Long endDateMillis) {
                                    try {
                                        dateRangePickerState.setSelection(startDateMillis, endDateMillis);
                                    } catch (IllegalArgumentException e) {
                                    }
                                }
                            };
                            $composer3.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        Function2 function6 = (Function2) value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, -1467495245, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean invalid$iv3 = $composer3.changed(state);
                        final DateRangePickerState dateRangePickerState2 = state;
                        Object it$iv4 = $composer3.rememberedValue();
                        if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                    invoke(l.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long monthInMillis) {
                                    dateRangePickerState2.setDisplayedMonthMillis(monthInMillis);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        DateRangePickerKt.m2196SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, iMo2202getDisplayModejFl4v0, function6, (Function1) value$iv4, calendarModel, state.getYearRange(), dateFormatter2, state.getSelectableDates(), colors2, $composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 14155776 | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            showModeToggle4 = showModeToggle3;
            colors3 = colors2;
            modifier3 = modifier2;
            function4 = function2RememberComposableLambda;
            function5 = function2RememberComposableLambda2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final DatePickerFormatter datePickerFormatter = dateFormatter3;
            final Function2<? super Composer, ? super Integer, Unit> function6 = function4;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
            final boolean z2 = showModeToggle4;
            final DatePickerColors datePickerColors2 = colors3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePicker.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    DateRangePickerKt.DateRangePicker(state, modifier5, datePickerFormatter, function6, function7, z2, datePickerColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m2199rememberDateRangePickerStateIlFM19s(Long initialSelectedStartDateMillis, Long initialSelectedEndDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, SelectableDates selectableDates, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -2012087461, "C(rememberDateRangePickerState)P(3,2,1,5,0:c#material3.DisplayMode)270@11923L15,273@12046L435,271@11950L531:DateRangePicker.kt#uh7d8r");
        Long initialSelectedStartDateMillis2 = (i & 1) != 0 ? null : initialSelectedStartDateMillis;
        Long initialSelectedEndDateMillis2 = (i & 2) != 0 ? null : initialSelectedEndDateMillis;
        Long initialDisplayedMonthMillis2 = (i & 4) != 0 ? initialSelectedStartDateMillis2 : initialDisplayedMonthMillis;
        IntRange yearRange2 = (i & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : yearRange;
        int initialDisplayMode2 = (i & 16) != 0 ? DisplayMode.INSTANCE.m2220getPickerjFl4v0() : initialDisplayMode;
        final SelectableDates selectableDates2 = (i & 32) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012087461, $changed, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:269)");
        }
        final Locale locale = CalendarLocale_androidKt.defaultLocale($composer, 0);
        Object[] objArr = new Object[0];
        Saver<DateRangePickerStateImpl, Object> Saver = DateRangePickerStateImpl.INSTANCE.Saver(selectableDates2, locale);
        ComposerKt.sourceInformationMarkerStart($composer, 269010730, "CC(remember):DateRangePicker.kt#9igjgp");
        boolean invalid$iv = ((((458752 & $changed) ^ ProfileVerifier.CompilationStatus.f245xf2722a21) > 131072 && $composer.changed(selectableDates2)) || ($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 131072) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialSelectedEndDateMillis2)) || ($changed & 48) == 32) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialSelectedStartDateMillis2)) || ($changed & 6) == 4) | (((($changed & 896) ^ 384) > 256 && $composer.changed(initialDisplayedMonthMillis2)) || ($changed & 384) == 256) | $composer.changedInstance(yearRange2) | ((((57344 & $changed) ^ CpioConstants.C_ISBLK) > 16384 && $composer.changed(initialDisplayMode2)) || ($changed & CpioConstants.C_ISBLK) == 16384) | $composer.changedInstance(locale);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
            final Long l = initialSelectedStartDateMillis2;
            final Long l2 = initialSelectedEndDateMillis2;
            final Long l3 = initialDisplayedMonthMillis2;
            final IntRange intRange = yearRange2;
            final int i2 = initialDisplayMode2;
            value$iv = new Function0<DateRangePickerStateImpl>() { // from class: androidx.compose.material3.DateRangePickerKt$rememberDateRangePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DateRangePickerStateImpl invoke() {
                    return new DateRangePickerStateImpl(l, l2, l3, intRange, i2, selectableDates2, locale, null);
                }
            };
            $composer.updateRememberedValue(value$iv);
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        DateRangePickerStateImpl dateRangePickerStateImpl = (DateRangePickerStateImpl) RememberSaveableKt.m3889rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return dateRangePickerStateImpl;
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m2195DateRangePickerStateHVP43zI$default(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = null;
        }
        if ((i2 & 8) != 0) {
            l3 = l;
        }
        if ((i2 & 16) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 32) != 0) {
            i = DisplayMode.INSTANCE.m2220getPickerjFl4v0();
        }
        if ((i2 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m2194DateRangePickerStateHVP43zI(locale, l, l2, l3, intRange, i, selectableDates);
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m2194DateRangePickerStateHVP43zI(Locale locale, Long initialSelectedStartDateMillis, Long initialSelectedEndDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, SelectableDates selectableDates) {
        return new DateRangePickerStateImpl(initialSelectedStartDateMillis, initialSelectedEndDateMillis, initialDisplayedMonthMillis, yearRange, initialDisplayMode, selectableDates, locale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SwitchableDateEntryContent-RN-2D1Q, reason: not valid java name */
    public static final void m2196SwitchableDateEntryContentRN2D1Q(final Long selectedStartDateMillis, final Long selectedEndDateMillis, final long displayedMonthMillis, final int displayMode, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange yearRange, final DatePickerFormatter dateFormatter, final SelectableDates selectableDates, final DatePickerColors colors, Composer $composer, final int $changed, final int $changed1) {
        Composer $composer2 = $composer.startRestartGroup(-532789335);
        ComposerKt.sourceInformation($composer2, "C(SwitchableDateEntryContent)P(9,8,4,3:c#material3.DisplayMode,5,6!1,10,2,7)697@30090L1138,691@29891L1337:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(selectedStartDateMillis) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selectedEndDateMillis) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(displayedMonthMillis) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(displayMode) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(calendarModel) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(yearRange) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ($changed & 134217728) == 0 ? $composer2.changed(dateFormatter) : $composer2.changedInstance(dateFormatter) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(selectableDates) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(colors) ? 4 : 2;
        }
        int $dirty2 = $dirty1;
        if ((306783379 & $dirty) != 306783378 || ($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532789335, $dirty, $dirty2, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:688)");
            }
            SpringSpec springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            CrossfadeKt.Crossfade(DisplayMode.m2212boximpl(displayMode), SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.setContainer($this$semantics, true);
                }
            }, 1, null), springSpecSpring$default, (String) null, ComposableLambdaKt.rememberComposableLambda(-1026642619, true, new Function3<DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode2, Composer composer, Integer num) {
                    m2201invokeQujVXRc(displayMode2.getValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-QujVXRc, reason: not valid java name */
                public final void m2201invokeQujVXRc(int mode, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "CP(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
                    int $dirty3 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty3 |= $composer3.changed(mode) ? 4 : 2;
                    }
                    int $dirty4 = $dirty3;
                    if (($dirty4 & 19) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1026642619, $dirty4, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:698)");
                        }
                        if (DisplayMode.m2215equalsimpl0(mode, DisplayMode.INSTANCE.m2220getPickerjFl4v0())) {
                            $composer3.startReplaceGroup(-1168744345);
                            ComposerKt.sourceInformation($composer3, "699@30156L574");
                            DateRangePickerKt.DateRangePickerContent(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, function2, function1, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer3, 0);
                            $composer3.endReplaceGroup();
                        } else if (DisplayMode.m2215equalsimpl0(mode, DisplayMode.INSTANCE.m2219getInputjFl4v0())) {
                            $composer3.startReplaceGroup(-1168743736);
                            ComposerKt.sourceInformation($composer3, "712@30765L447");
                            DateRangeInputKt.DateRangeInputContent(selectedStartDateMillis, selectedEndDateMillis, function2, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer3, 0);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(-1168743279);
                            $composer3.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 9) & 14) | 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DateRangePickerKt.m2196SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, displayMode, function2, function1, calendarModel, yearRange, dateFormatter, selectableDates, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DateRangePickerContent(final Long selectedStartDateMillis, final Long selectedEndDateMillis, final long displayedMonthMillis, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange yearRange, final DatePickerFormatter dateFormatter, final SelectableDates selectableDates, final DatePickerColors colors, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-787063721);
        ComposerKt.sourceInformation($composer3, "C(DateRangePickerContent)P(8,7,3,4,5!1,9,2,6)742@31839L87,743@31931L648:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedStartDateMillis) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(selectedEndDateMillis) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(displayedMonthMillis) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(yearRange) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= (16777216 & $changed) == 0 ? $composer3.changed(dateFormatter) : $composer3.changedInstance(dateFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changed(selectableDates) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(colors) ? 536870912 : 268435456;
        }
        if (($dirty & 306783379) != 306783378 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787063721, $dirty, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:739)");
            }
            CalendarMonth displayedMonth = calendarModel.getMonth(displayedMonthMillis);
            LazyListState monthsListState = LazyListStateKt.rememberLazyListState(displayedMonth.indexIn(yearRange), 0, $composer3, 0, 2);
            Modifier modifier$iv = PaddingKt.m870paddingVpY3zN4$default(Modifier.INSTANCE, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1265380821, "C744@32019L31,745@32059L514:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(colors, calendarModel, $composer3, (($dirty >> 27) & 14) | (($dirty >> 12) & 112));
            $composer2 = $composer3;
            VerticalMonthsList(monthsListState, selectedStartDateMillis, selectedEndDateMillis, function2, function1, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer3, (($dirty << 3) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.DateRangePickerContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    DateRangePickerKt.DateRangePickerContent(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, function2, function1, calendarModel, yearRange, dateFormatter, selectableDates, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalMonthsList(final LazyListState lazyListState, final Long selectedStartDateMillis, final Long selectedEndDateMillis, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange yearRange, final DatePickerFormatter dateFormatter, final SelectableDates selectableDates, final DatePickerColors colors, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2;
        Object value$iv2;
        Composer $composer3 = $composer.startRestartGroup(1257365001);
        ComposerKt.sourceInformation($composer3, "C(VerticalMonthsList)P(3,8,7,4,5!1,9,2,6)779@33299L138,786@33482L10,787@33550L4172,785@33442L4280,879@37757L228,879@37727L258:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(lazyListState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(selectedStartDateMillis) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(selectedEndDateMillis) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(yearRange) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= (16777216 & $changed) == 0 ? $composer3.changed(dateFormatter) : $composer3.changedInstance(dateFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changed(selectableDates) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & $changed) == 0) {
            $dirty |= $composer3.changed(colors) ? 536870912 : 268435456;
        }
        if (($dirty & 306783379) != 306783378 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257365001, $dirty, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:777)");
            }
            final CalendarDate today = calendarModel.getToday();
            ComposerKt.sourceInformationMarkerStart($composer3, 1454981865, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(yearRange);
            int $dirty2 = $dirty;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = calendarModel.getMonth(yearRange.getFirst(), 1);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final CalendarMonth firstMonth = (CalendarMonth) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), DatePickerModalTokens.INSTANCE.getDateLabelTextFont()), ComposableLambdaKt.rememberComposableLambda(1090773432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv$iv;
                    Object value$iv3;
                    Object value$iv4;
                    ComposerKt.sourceInformation($composer4, "C788@33581L24,789@33647L59,790@33744L55,794@33980L317,818@34951L2765,811@34600L3116:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1090773432, $changed2, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:788)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer4, -723523240, "CC(remember):Effects.kt#9igjgp");
                        Object it$iv$iv = $composer4.rememberedValue();
                        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4));
                            $composer4.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Strings.Companion companion = Strings.INSTANCE;
                        String scrollToPreviousMonthLabel = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_range_picker_scroll_to_previous_month), $composer4, 0);
                        Strings.Companion companion2 = Strings.INSTANCE;
                        String scrollToNextMonthLabel = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_range_picker_scroll_to_next_month), $composer4, 0);
                        ComposerKt.sourceInformationMarkerStart($composer4, 1645721267, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(selectedStartDateMillis) | $composer4.changed(selectedEndDateMillis) | $composer4.changed(function2);
                        final Long l = selectedStartDateMillis;
                        final Long l2 = selectedEndDateMillis;
                        final Function2<Long, Long, Unit> function3 = function2;
                        Object it$iv2 = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                                    invoke(l3.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long dateInMillis) {
                                    DateRangePickerKt.updateDateSelection(dateInMillis, l, l2, function3);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv2;
                        }
                        final Function1 onDateSelectionChange = (Function1) value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        final List customAccessibilityAction = DateRangePickerKt.customScrollActions(lazyListState, coroutineScope, scrollToPreviousMonthLabel, scrollToNextMonthLabel);
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                SemanticsPropertiesKt.setVerticalScrollAxisRange($this$semantics, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, null));
                            }
                        }, 1, null);
                        LazyListState lazyListState2 = lazyListState;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1645722238, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean invalid$iv3 = $composer4.changedInstance(yearRange) | $composer4.changedInstance(calendarModel) | $composer4.changed(firstMonth) | $composer4.changedInstance(dateFormatter) | $composer4.changedInstance(customAccessibilityAction) | $composer4.changed(colors) | $composer4.changed(selectedStartDateMillis) | $composer4.changed(selectedEndDateMillis) | $composer4.changed(onDateSelectionChange) | $composer4.changed(today) | $composer4.changed(selectableDates);
                        final IntRange intRange = yearRange;
                        final CalendarModel calendarModel2 = calendarModel;
                        final CalendarMonth calendarMonth = firstMonth;
                        final Long l3 = selectedStartDateMillis;
                        final Long l4 = selectedEndDateMillis;
                        final CalendarDate calendarDate = today;
                        final DatePickerFormatter datePickerFormatter = dateFormatter;
                        final SelectableDates selectableDates2 = selectableDates;
                        final DatePickerColors datePickerColors = colors;
                        Object it$iv3 = $composer4.rememberedValue();
                        if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope $this$LazyColumn) {
                                    int iNumberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(intRange);
                                    final CalendarModel calendarModel3 = calendarModel2;
                                    final CalendarMonth calendarMonth2 = calendarMonth;
                                    final Long l5 = l3;
                                    final Long l6 = l4;
                                    final Function1<Long, Unit> function4 = onDateSelectionChange;
                                    final CalendarDate calendarDate2 = calendarDate;
                                    final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                                    final SelectableDates selectableDates3 = selectableDates2;
                                    final DatePickerColors datePickerColors2 = datePickerColors;
                                    final List<CustomAccessibilityAction> list = customAccessibilityAction;
                                    LazyListScope.CC.items$default($this$LazyColumn, iNumberOfMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(-1413501381, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /*  JADX ERROR: Types fix failed
                                            jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v9 ??, new type: java.lang.Object
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
                                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                                            	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                                            	... 5 more
                                            */
                                        public final void invoke(androidx.compose.foundation.lazy.LazyItemScope r42, int r43, androidx.compose.runtime.Composer r44, int r45) {
                                            /*
                                                Method dump skipped, instruction units count: 626
                                                To view this dump add '--comments-level debug' option
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1.C13221.invoke(androidx.compose.foundation.lazy.LazyItemScope, int, androidx.compose.runtime.Composer, int):void");
                                        }
                                    }), 6, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        LazyDslKt.LazyColumn(modifierSemantics$default, lazyListState2, null, false, null, null, null, false, (Function1) value$iv4, $composer4, 0, 252);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 48);
            ComposerKt.sourceInformationMarkerStart($composer2, 1454986323, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & 57344) == 16384) | $composer2.changedInstance(calendarModel) | $composer2.changedInstance(yearRange);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState, function1, calendarModel, yearRange, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(lazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, $dirty2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    DateRangePickerKt.VerticalMonthsList(lazyListState, selectedStartDateMillis, selectedEndDateMillis, function2, function1, calendarModel, yearRange, dateFormatter, selectableDates, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDateSelection(long dateInMillis, Long currentStartDateMillis, Long currentEndDateMillis, Function2<? super Long, ? super Long, Unit> function2) {
        if ((currentStartDateMillis == null && currentEndDateMillis == null) || (currentStartDateMillis != null && currentEndDateMillis != null)) {
            function2.invoke(Long.valueOf(dateInMillis), null);
        } else if (currentStartDateMillis == null || dateInMillis < currentStartDateMillis.longValue()) {
            function2.invoke(Long.valueOf(dateInMillis), null);
        } else {
            function2.invoke(currentStartDateMillis, Long.valueOf(dateInMillis));
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* JADX INFO: renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m2198drawRangeBackgroundmxwnekA(ContentDrawScope $this$drawRangeBackground_u2dmxwnekA, SelectedRangeInfo selectedRangeInfo, long color) {
        float fM4118getWidthimpl;
        float itemContainerWidth = $this$drawRangeBackground_u2dmxwnekA.mo567toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float itemContainerHeight = $this$drawRangeBackground_u2dmxwnekA.mo567toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float itemStateLayerHeight = $this$drawRangeBackground_u2dmxwnekA.mo567toPx0680j_4(DatePickerModalTokens.INSTANCE.m3244getDateStateLayerHeightD9Ej5fM());
        float f = 2;
        float stateLayerVerticalPadding = (itemContainerHeight - itemStateLayerHeight) / f;
        float f2 = 7;
        float horizontalSpaceBetweenItems = (Size.m4118getWidthimpl($this$drawRangeBackground_u2dmxwnekA.mo4773getSizeNHjbRc()) - (f2 * itemContainerWidth)) / f2;
        long gridStartCoordinates = selectedRangeInfo.getGridStartCoordinates();
        int iM6933getXimpl = IntOffset.m6933getXimpl(gridStartCoordinates);
        int y1 = IntOffset.m6934getYimpl(gridStartCoordinates);
        long gridEndCoordinates = selectedRangeInfo.getGridEndCoordinates();
        int iM6933getXimpl2 = IntOffset.m6933getXimpl(gridEndCoordinates);
        int y2 = IntOffset.m6934getYimpl(gridEndCoordinates);
        float startX = (iM6933getXimpl * (itemContainerWidth + horizontalSpaceBetweenItems)) + (selectedRangeInfo.getFirstIsSelectionStart() ? itemContainerWidth / f : 0.0f) + (horizontalSpaceBetweenItems / f);
        float startY = (y1 * itemContainerHeight) + stateLayerVerticalPadding;
        float endX = (iM6933getXimpl2 * (itemContainerWidth + horizontalSpaceBetweenItems)) + (selectedRangeInfo.getLastIsSelectionEnd() ? itemContainerWidth / f : itemContainerWidth) + (horizontalSpaceBetweenItems / f);
        float endY = (y2 * itemContainerHeight) + stateLayerVerticalPadding;
        boolean isRtl = $this$drawRangeBackground_u2dmxwnekA.getLayoutDirection() == LayoutDirection.Rtl;
        if (isRtl) {
            startX = Size.m4118getWidthimpl($this$drawRangeBackground_u2dmxwnekA.mo4773getSizeNHjbRc()) - startX;
            endX = Size.m4118getWidthimpl($this$drawRangeBackground_u2dmxwnekA.mo4773getSizeNHjbRc()) - endX;
        }
        ContentDrawScope contentDrawScope = $this$drawRangeBackground_u2dmxwnekA;
        long jOffset = OffsetKt.Offset(startX, startY);
        if (y1 == y2) {
            fM4118getWidthimpl = endX - startX;
        } else {
            fM4118getWidthimpl = isRtl ? -startX : Size.m4118getWidthimpl($this$drawRangeBackground_u2dmxwnekA.mo4773getSizeNHjbRc()) - startX;
        }
        DrawScope.CC.m4858drawRectnJ9OG0$default(contentDrawScope, color, jOffset, SizeKt.Size(fM4118getWidthimpl, itemStateLayerHeight), 0.0f, null, null, 0, 120, null);
        if (y1 != y2) {
            int y = (y2 - y1) - 1;
            while (y > 0) {
                DrawScope.CC.m4858drawRectnJ9OG0$default($this$drawRangeBackground_u2dmxwnekA, color, OffsetKt.Offset(0.0f, (y * itemContainerHeight) + startY), SizeKt.Size(Size.m4118getWidthimpl($this$drawRangeBackground_u2dmxwnekA.mo4773getSizeNHjbRc()), itemStateLayerHeight), 0.0f, null, null, 0, 120, null);
                y--;
                itemContainerWidth = itemContainerWidth;
                itemContainerHeight = itemContainerHeight;
            }
            float topLeftX = $this$drawRangeBackground_u2dmxwnekA.getLayoutDirection() == LayoutDirection.Ltr ? 0.0f : Size.m4118getWidthimpl($this$drawRangeBackground_u2dmxwnekA.mo4773getSizeNHjbRc());
            DrawScope.CC.m4858drawRectnJ9OG0$default($this$drawRangeBackground_u2dmxwnekA, color, OffsetKt.Offset(topLeftX, endY), SizeKt.Size(isRtl ? endX - Size.m4118getWidthimpl($this$drawRangeBackground_u2dmxwnekA.mo4773getSizeNHjbRc()) : endX, itemStateLayerHeight), 0.0f, null, null, 0, 120, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyListState state, final CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(scrollUpLabel, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (state.getCanScrollBackward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C13251(state, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1 */
            /* JADX INFO: compiled from: DateRangePicker.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1", m210f = "DateRangePicker.kt", m211i = {}, m212l = {1071}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C13251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C13251(LazyListState lazyListState, Continuation<? super C13251> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C13251(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C13251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (LazyListState.scrollToItem$default(this.$state, this.$state.getFirstVisibleItemIndex() - 1, 0, this, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        }), new CustomAccessibilityAction(scrollDownLabel, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (state.getCanScrollForward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C13241(state, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1 */
            /* JADX INFO: compiled from: DateRangePicker.kt */
            @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m195d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m209c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1", m210f = "DateRangePicker.kt", m211i = {}, m212l = {1081}, m213m = "invokeSuspend", m214n = {}, m215s = {})
            static final class C13241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C13241(LazyListState lazyListState, Continuation<? super C13241> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C13241(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C13241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (LazyListState.scrollToItem$default(this.$state, this.$state.getFirstVisibleItemIndex() + 1, 0, this, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        })});
    }
}
