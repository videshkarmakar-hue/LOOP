package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.CalendarLocale_androidKt;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
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
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.internal.ViewUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: DateRangeInput.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0085\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062:\u0010\b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\u0010\u0018\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0019"}, m195d2 = {"TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = C1979Dp.m6801constructorimpl(8);

    /* JADX WARN: Code duplicated, block: B:114:0x033b  */
    /* JADX WARN: Code duplicated, block: B:115:0x033d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0346  */
    /* JADX WARN: Code duplicated, block: B:119:0x0348  */
    /* JADX WARN: Code duplicated, block: B:130:0x0424  */
    /* JADX WARN: Code duplicated, block: B:131:0x0426  */
    /* JADX WARN: Code duplicated, block: B:134:0x042c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0447  */
    /* JADX WARN: Code duplicated, block: B:144:0x04cc  */
    public static final void DateRangeInputContent(final Long selectedStartDateMillis, final Long selectedEndDateMillis, final Function2<? super Long, ? super Long, Unit> function2, final CalendarModel calendarModel, final IntRange yearRange, final DatePickerFormatter dateFormatter, final SelectableDates selectableDates, final DatePickerColors colors, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Function0<ComposeUiNode> function0;
        MeasurePolicy measurePolicy$iv;
        boolean z;
        boolean z2;
        boolean invalid$iv;
        Object value$iv3;
        int $dirty;
        Composer $composer2;
        boolean z3;
        boolean invalid$iv2;
        Object value$iv4;
        Composer $composer3 = $composer.startRestartGroup(-607499086);
        ComposerKt.sourceInformation($composer3, "C(DateRangeInputContent)P(6,5,3!1,7,2,4)46@1832L15,47@1874L87,50@1989L45,51@2069L44,52@2147L45,53@2221L50,54@2301L486,71@3000L2321:DateRangeInput.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedStartDateMillis) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(selectedEndDateMillis) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(calendarModel) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer3.changedInstance(yearRange) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= ($changed & 262144) == 0 ? $composer3.changed(dateFormatter) : $composer3.changedInstance(dateFormatter) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changed(selectableDates) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(colors) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) != 4793490 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-607499086, $dirty2, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:44)");
            }
            Locale defaultLocale = CalendarLocale_androidKt.defaultLocale($composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, 1694772119, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changed(defaultLocale);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = calendarModel.getDateInputFormat(defaultLocale);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            DateInputFormat dateInputFormat = (DateInputFormat) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Strings.Companion companion = Strings.INSTANCE;
            String errorDatePattern = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_input_invalid_for_pattern), $composer3, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            String errorDateOutOfYearRange = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_input_invalid_year_range), $composer3, 0);
            Strings.Companion companion3 = Strings.INSTANCE;
            String errorInvalidNotAllowed = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_input_invalid_not_allowed), $composer3, 0);
            Strings.Companion companion4 = Strings.INSTANCE;
            String errorInvalidRange = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_range_input_invalid_range_input), $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, 1694772546, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changed(dateInputFormat) | ((458752 & $dirty2) == 131072 || ((262144 & $dirty2) != 0 && $composer3.changed(dateFormatter)));
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new DateInputValidator(yearRange, selectableDates, dateInputFormat, dateFormatter, errorDatePattern, errorDateOutOfYearRange, errorInvalidNotAllowed, errorInvalidRange, null, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            DateInputValidator dateInputValidator = (DateInputValidator) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            dateInputValidator.setCurrentStartDateMillis$material3_release(selectedStartDateMillis);
            dateInputValidator.setCurrentEndDateMillis$material3_release(selectedEndDateMillis);
            Modifier modifier$iv = PaddingKt.padding(Modifier.INSTANCE, DateInputKt.getInputTextFieldPadding());
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m744spacedBy0680j_4(TextFieldSpacing);
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv = (54 << 3) & 112;
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
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                measurePolicy$iv = measurePolicy$iv2;
            } else {
                measurePolicy$iv = measurePolicy$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
                int i2 = ((54 >> 6) & 112) | 6;
                RowScope $this$DateRangeInputContent_u24lambda_u245 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 1849029446, "C76@3261L56,88@3841L203,80@3455L200,86@3683L63,77@3326L955,98@4309L54,110@4881L199,102@4501L196,108@4725L63,99@4372L943:DateRangeInput.kt#uh7d8r");
                final String pattern = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(pattern, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                Strings.Companion companion5 = Strings.INSTANCE;
                final String startRangeText = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_range_picker_start_headline), $composer3, 0);
                Modifier materialized$iv$iv2 = RowScope.CC.weight$default($this$DateRangeInputContent_u24lambda_u245, Modifier.INSTANCE, 0.5f, false, 2, null);
                int iM2318getStartDateInputJ2x2o4M = InputIdentifier.INSTANCE.m2318getStartDateInputJ2x2o4M();
                ComposerKt.sourceInformationMarkerStart($composer3, 1849030119, "CC(remember):DateRangeInput.kt#9igjgp");
                if (($dirty2 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                if (($dirty2 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                invalid$iv = z2 | z;
                Object it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke2(l);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Long startDateMillis) {
                            function2.invoke(startDateMillis, selectedEndDateMillis);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $dirty = $dirty2;
                $composer2 = $composer3;
                DateInputKt.m2144DateInputTextFieldtQNruF0(materialized$iv$iv2, selectedStartDateMillis, (Function1) value$iv3, calendarModel, ComposableLambdaKt.rememberComposableLambda(801434508, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        Object value$iv5;
                        ComposerKt.sourceInformation($composer4, "C82@3544L96,81@3473L168:DateRangeInput.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(801434508, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:81)");
                            }
                            String str = startRangeText;
                            Modifier.Companion companion6 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -2126787105, "CC(remember):DateRangeInput.kt#9igjgp");
                            boolean invalid$iv5 = $composer4.changed(startRangeText) | $composer4.changed(pattern);
                            final String str2 = startRangeText;
                            final String str3 = pattern;
                            Object it$iv4 = $composer4.rememberedValue();
                            if (invalid$iv5 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2$1$1
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
                                        SemanticsPropertiesKt.setContentDescription($this$semantics, str2 + ", " + str3);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv4;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            TextKt.m2817Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion6, false, (Function1) value$iv5, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(665407211, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C86@3685L59:DateRangeInput.kt#uh7d8r");
                        if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(665407211, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:86)");
                        }
                        TextKt.m2817Text4IGK_g(pattern, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                            }
                        }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), iM2318getStartDateInputJ2x2o4M, dateInputValidator, dateInputFormat, defaultLocale, colors, $composer3, (($dirty2 << 3) & 112) | 1794048 | ($dirty2 & 7168), ($dirty2 >> 21) & 14);
                Strings.Companion companion6 = Strings.INSTANCE;
                final String endRangeText = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_range_picker_end_headline), $composer3, 0);
                Modifier modifierWeight$default = RowScope.CC.weight$default($this$DateRangeInputContent_u24lambda_u245, Modifier.INSTANCE, 0.5f, false, 2, null);
                int iM2316getEndDateInputJ2x2o4M = InputIdentifier.INSTANCE.m2316getEndDateInputJ2x2o4M();
                ComposerKt.sourceInformationMarkerStart($composer3, 1849031159, "CC(remember):DateRangeInput.kt#9igjgp");
                if (($dirty & 896) == 256) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                invalid$iv2 = z3 | (($dirty & 14) == 4);
                Object it$iv4 = $composer3.rememberedValue();
                if (!invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke2(l);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Long endDateMillis) {
                            function2.invoke(selectedStartDateMillis, endDateMillis);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                DateInputKt.m2144DateInputTextFieldtQNruF0(modifierWeight$default, selectedEndDateMillis, (Function1) value$iv4, calendarModel, ComposableLambdaKt.rememberComposableLambda(911487285, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        Object value$iv5;
                        ComposerKt.sourceInformation($composer4, "C104@4588L94,103@4519L164:DateRangeInput.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(911487285, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:103)");
                            }
                            String str = endRangeText;
                            Modifier.Companion companion7 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -2126786061, "CC(remember):DateRangeInput.kt#9igjgp");
                            boolean invalid$iv5 = $composer4.changed(endRangeText) | $composer4.changed(pattern);
                            final String str2 = endRangeText;
                            final String str3 = pattern;
                            Object it$iv5 = $composer4.rememberedValue();
                            if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5$1$1
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
                                        SemanticsPropertiesKt.setContentDescription($this$semantics, str2 + ", " + str3);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv5;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            TextKt.m2817Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion7, false, (Function1) value$iv5, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-961726252, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C108@4727L59:DateRangeInput.kt#uh7d8r");
                        if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-961726252, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:108)");
                        }
                        TextKt.m2817Text4IGK_g(pattern, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                            }
                        }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), iM2316getEndDateInputJ2x2o4M, dateInputValidator, dateInputFormat, defaultLocale, colors, $composer3, ($dirty & 112) | 1794048 | ($dirty & 7168), ($dirty >> 21) & 14);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            int i4 = ((54 >> 6) & 112) | 6;
            RowScope $this$DateRangeInputContent_u24lambda_u246 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1849029446, "C76@3261L56,88@3841L203,80@3455L200,86@3683L63,77@3326L955,98@4309L54,110@4881L199,102@4501L196,108@4725L63,99@4372L943:DateRangeInput.kt#uh7d8r");
            final String pattern2 = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(pattern2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Strings.Companion companion7 = Strings.INSTANCE;
            final String startRangeText2 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_range_picker_start_headline), $composer3, 0);
            Modifier materialized$iv$iv3 = RowScope.CC.weight$default($this$DateRangeInputContent_u24lambda_u246, Modifier.INSTANCE, 0.5f, false, 2, null);
            int iM2318getStartDateInputJ2x2o4M2 = InputIdentifier.INSTANCE.m2318getStartDateInputJ2x2o4M();
            ComposerKt.sourceInformationMarkerStart($composer3, 1849030119, "CC(remember):DateRangeInput.kt#9igjgp");
            if (($dirty2 & 896) == 256) {
                z = true;
            } else {
                z = false;
            }
            if (($dirty2 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            invalid$iv = z2 | z;
            Object it$iv5 = $composer3.rememberedValue();
            if (!invalid$iv) {
            }
            value$iv3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke2(l);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long startDateMillis) {
                    function2.invoke(startDateMillis, selectedEndDateMillis);
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $dirty = $dirty2;
            $composer2 = $composer3;
            DateInputKt.m2144DateInputTextFieldtQNruF0(materialized$iv$iv3, selectedStartDateMillis, (Function1) value$iv3, calendarModel, ComposableLambdaKt.rememberComposableLambda(801434508, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv5;
                    ComposerKt.sourceInformation($composer4, "C82@3544L96,81@3473L168:DateRangeInput.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(801434508, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:81)");
                        }
                        String str = startRangeText2;
                        Modifier.Companion companion8 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2126787105, "CC(remember):DateRangeInput.kt#9igjgp");
                        boolean invalid$iv5 = $composer4.changed(startRangeText2) | $composer4.changed(pattern2);
                        final String str2 = startRangeText2;
                        final String str3 = pattern2;
                        Object it$iv6 = $composer4.rememberedValue();
                        if (invalid$iv5 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2$1$1
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
                                    SemanticsPropertiesKt.setContentDescription($this$semantics, str2 + ", " + str3);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv6;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        TextKt.m2817Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion8, false, (Function1) value$iv5, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(665407211, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C86@3685L59:DateRangeInput.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(665407211, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:86)");
                    }
                    TextKt.m2817Text4IGK_g(pattern2, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$3.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), iM2318getStartDateInputJ2x2o4M2, dateInputValidator, dateInputFormat, defaultLocale, colors, $composer3, (($dirty2 << 3) & 112) | 1794048 | ($dirty2 & 7168), ($dirty2 >> 21) & 14);
            Strings.Companion companion8 = Strings.INSTANCE;
            final String endRangeText2 = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_date_range_picker_end_headline), $composer3, 0);
            Modifier modifierWeight$default2 = RowScope.CC.weight$default($this$DateRangeInputContent_u24lambda_u246, Modifier.INSTANCE, 0.5f, false, 2, null);
            int iM2316getEndDateInputJ2x2o4M2 = InputIdentifier.INSTANCE.m2316getEndDateInputJ2x2o4M();
            ComposerKt.sourceInformationMarkerStart($composer3, 1849031159, "CC(remember):DateRangeInput.kt#9igjgp");
            if (($dirty & 896) == 256) {
                z3 = true;
            } else {
                z3 = false;
            }
            invalid$iv2 = z3 | (($dirty & 14) == 4);
            Object it$iv6 = $composer3.rememberedValue();
            if (invalid$iv2) {
                value$iv4 = new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke2(l);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Long endDateMillis) {
                        function2.invoke(selectedStartDateMillis, endDateMillis);
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke2(l);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Long endDateMillis) {
                        function2.invoke(selectedStartDateMillis, endDateMillis);
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            DateInputKt.m2144DateInputTextFieldtQNruF0(modifierWeight$default2, selectedEndDateMillis, (Function1) value$iv4, calendarModel, ComposableLambdaKt.rememberComposableLambda(911487285, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv5;
                    ComposerKt.sourceInformation($composer4, "C104@4588L94,103@4519L164:DateRangeInput.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(911487285, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:103)");
                        }
                        String str = endRangeText2;
                        Modifier.Companion companion9 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2126786061, "CC(remember):DateRangeInput.kt#9igjgp");
                        boolean invalid$iv5 = $composer4.changed(endRangeText2) | $composer4.changed(pattern2);
                        final String str2 = endRangeText2;
                        final String str3 = pattern2;
                        Object it$iv7 = $composer4.rememberedValue();
                        if (invalid$iv5 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                            value$iv5 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$5$1$1
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
                                    SemanticsPropertiesKt.setContentDescription($this$semantics, str2 + ", " + str3);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv5);
                        } else {
                            value$iv5 = it$iv7;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        TextKt.m2817Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion9, false, (Function1) value$iv5, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-961726252, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C108@4727L59:DateRangeInput.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-961726252, $changed2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:108)");
                    }
                    TextKt.m2817Text4IGK_g(pattern2, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$6.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), iM2316getEndDateInputJ2x2o4M2, dateInputValidator, dateInputFormat, defaultLocale, colors, $composer3, ($dirty & 112) | 1794048 | ($dirty & 7168), ($dirty >> 21) & 14);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangeInputKt.DateRangeInputContent.3
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

                public final void invoke(Composer composer, int i5) {
                    DateRangeInputKt.DateRangeInputContent(selectedStartDateMillis, selectedEndDateMillis, function2, calendarModel, yearRange, dateFormatter, selectableDates, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
