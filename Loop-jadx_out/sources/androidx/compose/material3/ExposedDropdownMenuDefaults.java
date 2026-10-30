package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.internal.TouchExplorationStateProvider_androidKt;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.draw.RotateKt;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.window.PopupProperties;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ\u0082\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0084\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0098\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010>\u001a\u00020\u00122\b\b\u0002\u0010?\u001a\u00020\u00122\b\b\u0002\u0010@\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\nH\u0001¢\u0006\u0004\bF\u0010GJ\u0082\u0002\u0010H\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010I\u001a\u00020\u00122\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010,J\u0084\u0003\u0010H\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010I\u001a\u00020\u00122\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010=J\u0098\u0003\u0010H\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u0010>\u001a\u00020\u00122\b\b\u0002\u0010?\u001a\u00020\u00122\b\b\u0002\u0010@\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010I\u001a\u00020\u00122\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u00122\b\b\u0002\u0010L\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00122\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u00122\b\b\u0002\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010BR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P²\u0006\n\u0010Q\u001a\u00020\nX\u008a\u0084\u0002"}, m195d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "errorTextColor", "errorContainerColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "outlinedTextFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "outlinedTextFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "popupProperties", "Landroidx/compose/ui/window/PopupProperties;", "focusable", "popupProperties$material3_release", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupProperties;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "textFieldColors-tN0la-I", "textFieldColors-FD9MK7s", "material3_release", "touchExplorationServicesEnabled"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    private static final PaddingValues ItemContentPadding = PaddingKt.m862PaddingValuesYgX7TsA(ExposedDropdownMenu_androidKt.ExposedDropdownMenuItemHorizontalPadding, C1979Dp.m6801constructorimpl(0));

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(final boolean expanded, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-1987096744);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)411@18110L129:ExposedDropdownMenu.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1987096744, $dirty2, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:410)");
            }
            IconKt.m2292Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), (String) null, RotateKt.rotate(modifier, expanded ? 180.0f : 0.0f), 0L, $composer2, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon.1
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
                    ExposedDropdownMenuDefaults.this.TrailingIcon(expanded, modifier2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: textFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m2234textFieldColorsFD9MK7s(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledIndicatorColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledPlaceholderColor2;
        long disabledPrefixColor2;
        long disabledSuffixColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 768358577, "C(textFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,29,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)468@22222L5,469@22310L5,470@22405L5,472@22576L5,473@22671L5,474@22768L5,475@22864L5,476@22957L5,477@23038L5,478@23134L5,479@23213L7,481@23333L5,483@23448L5,485@23570L5,488@23782L5,490@23898L5,492@24011L5,494@24131L5,497@24337L5,499@24455L5,501@24570L5,503@24692L5,506@24901L5,507@24993L5,508@25082L5,509@25178L5,510@25268L5,512@25378L5,514@25490L5,516@25609L5,518@25796L5,519@25889L5,520@25984L5,522@26099L5,523@26264L5,524@26357L5,525@26452L5,527@26567L5,528@26732L5,530@26790L2230:ExposedDropdownMenu.android.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        long unfocusedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : unfocusedTextColor;
        if ((i & 4) != 0) {
            long value = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long errorTextColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6) : errorTextColor;
        long focusedContainerColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6) : focusedContainerColor;
        long unfocusedContainerColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6) : unfocusedContainerColor;
        long disabledContainerColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6) : disabledContainerColor;
        long errorContainerColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6) : errorContainerColor;
        long cursorColor2 = (i & 256) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6) : cursorColor;
        long errorCursorColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6) : errorCursorColor;
        if ((i & 1024) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedIndicatorColor2 = (i & 2048) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), $composer, 6) : focusedIndicatorColor;
        long unfocusedIndicatorColor2 = (i & 4096) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), $composer, 6) : unfocusedIndicatorColor;
        if ((i & 8192) != 0) {
            long value2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), $composer, 6);
            disabledIndicatorColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), $composer, 6) : errorIndicatorColor;
        long focusedLeadingIconColor2 = (32768 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (65536 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((131072 & i) != 0) {
            long value3 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (262144 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6) : errorLeadingIconColor;
        long focusedTrailingIconColor2 = (524288 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (1048576 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((2097152 & i) != 0) {
            long value4 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (4194304 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6) : errorTrailingIconColor;
        long focusedLabelColor2 = (8388608 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6) : focusedLabelColor;
        long unfocusedLabelColor2 = (16777216 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6) : unfocusedLabelColor;
        long disabledLabelColor2 = (33554432 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6) : disabledLabelColor;
        long errorLabelColor2 = (67108864 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6) : errorLabelColor;
        long focusedPlaceholderColor2 = (134217728 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPlaceholderColor;
        long unfocusedPlaceholderColor2 = (268435456 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPlaceholderColor;
        if ((536870912 & i) != 0) {
            long value5 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value5) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value5) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        long errorPlaceholderColor2 = (i & BasicMeasure.EXACTLY) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPlaceholderColor;
        long focusedPrefixColor2 = (i2 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPrefixColor;
        long unfocusedPrefixColor2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPrefixColor;
        if ((i2 & 4) != 0) {
            long value6 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPrefixColor2 = Color.m4289copywmQWz5c(value6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value6) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value6) : 0.0f);
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        long errorPrefixColor2 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPrefixColor;
        long focusedSuffixColor2 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedSuffixColor;
        long unfocusedSuffixColor2 = (i2 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedSuffixColor;
        if ((i2 & 64) != 0) {
            long value7 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledSuffixColor2 = Color.m4289copywmQWz5c(value7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value7) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value7) : 0.0f);
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        long errorSuffixColor2 = (i2 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorSuffixColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(768358577, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:530)");
        }
        TextFieldColors textFieldColorsM2796colors0hiis_0 = TextFieldDefaults.INSTANCE.m2796colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, 0L, 0L, 0L, 0L, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | ($changed & 458752) | ($changed & 3670016) | ($changed & 29360128) | ($changed & 234881024) | ($changed & 1879048192), ($changed1 & 14) | ($changed1 & 112) | ($changed1 & 896) | ($changed1 & 7168) | ($changed1 & 57344) | ($changed1 & 458752) | ($changed1 & 3670016) | ($changed1 & 29360128) | ($changed1 & 234881024) | ($changed1 & 1879048192), ($changed2 & 14) | ($changed2 & 112) | ($changed2 & 896) | ($changed2 & 7168) | (57344 & $changed2) | ($changed2 & 458752) | ($changed2 & 3670016) | ($changed2 & 29360128) | ($changed2 & 234881024) | ($changed2 & 1879048192), ($changed3 & 14) | (($changed3 << 12) & 458752) | (($changed3 << 12) & 3670016) | (($changed3 << 12) & 29360128) | (($changed3 << 12) & 234881024) | (($changed3 << 12) & 1879048192), (($changed3 >> 18) & 14) | 3072 | (($changed3 >> 18) & 112) | (($changed3 >> 18) & 896), 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2796colors0hiis_0;
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m2231outlinedTextFieldColorsFD9MK7s(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledBorderColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledLabelColor2;
        long disabledPlaceholderColor2;
        long disabledPrefixColor2;
        long disabledSuffixColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1567195085, "C(outlinedTextFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,29,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)621@32985L5,622@33075L5,623@33172L5,625@33347L5,630@33663L5,632@33773L5,633@33852L7,634@33951L5,635@34045L5,637@34158L5,639@34343L5,641@34461L5,643@34576L5,645@34698L5,648@34908L5,650@35028L5,652@35145L5,654@35269L5,657@35482L5,658@35576L5,659@35667L5,660@35765L5,662@35941L5,664@36053L5,666@36167L5,668@36288L5,671@36491L5,672@36586L5,673@36683L5,675@36800L5,676@36969L5,677@37064L5,678@37161L5,680@37278L5,681@37447L5,683@37513L2206:ExposedDropdownMenu.android.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        long unfocusedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : unfocusedTextColor;
        if ((i & 4) != 0) {
            long value = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long errorTextColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6) : errorTextColor;
        long focusedContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : focusedContainerColor;
        long unfocusedContainerColor2 = (i & 32) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : unfocusedContainerColor;
        long disabledContainerColor2 = (i & 64) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : disabledContainerColor;
        long errorContainerColor2 = (i & 128) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : errorContainerColor;
        long cursorColor2 = (i & 256) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6) : cursorColor;
        long errorCursorColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6) : errorCursorColor;
        if ((i & 1024) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedBorderColor2 = (i & 2048) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), $composer, 6) : focusedBorderColor;
        long unfocusedBorderColor2 = (i & 4096) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), $composer, 6) : unfocusedBorderColor;
        if ((i & 8192) != 0) {
            long value2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), $composer, 6);
            disabledBorderColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), $composer, 6) : errorBorderColor;
        long focusedLeadingIconColor2 = (32768 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (65536 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((131072 & i) != 0) {
            long value3 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (262144 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6) : errorLeadingIconColor;
        long focusedTrailingIconColor2 = (524288 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (1048576 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((2097152 & i) != 0) {
            long value4 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (4194304 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6) : errorTrailingIconColor;
        long focusedLabelColor2 = (8388608 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6) : focusedLabelColor;
        long unfocusedLabelColor2 = (16777216 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6) : unfocusedLabelColor;
        if ((33554432 & i) != 0) {
            long value5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6);
            disabledLabelColor2 = Color.m4289copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value5) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value5) : 0.0f);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (67108864 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6) : errorLabelColor;
        long focusedPlaceholderColor2 = (134217728 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPlaceholderColor;
        long unfocusedPlaceholderColor2 = (268435456 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPlaceholderColor;
        if ((536870912 & i) != 0) {
            long value6 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value6) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value6) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        long errorPlaceholderColor2 = (i & BasicMeasure.EXACTLY) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPlaceholderColor;
        long focusedPrefixColor2 = (i2 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPrefixColor;
        long unfocusedPrefixColor2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPrefixColor;
        if ((i2 & 4) != 0) {
            long value7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPrefixColor2 = Color.m4289copywmQWz5c(value7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value7) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value7) : 0.0f);
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        long errorPrefixColor2 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPrefixColor;
        long focusedSuffixColor2 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedSuffixColor;
        long unfocusedSuffixColor2 = (i2 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedSuffixColor;
        if ((i2 & 64) != 0) {
            long value8 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledSuffixColor2 = Color.m4289copywmQWz5c(value8, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value8) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value8) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value8) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value8) : 0.0f);
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        long errorSuffixColor2 = (i2 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorSuffixColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1567195085, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:683)");
        }
        TextFieldColors textFieldColorsM2464colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m2464colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, 0L, 0L, 0L, 0L, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | ($changed & 458752) | ($changed & 3670016) | ($changed & 29360128) | ($changed & 234881024) | ($changed & 1879048192), ($changed1 & 14) | ($changed1 & 112) | ($changed1 & 896) | ($changed1 & 7168) | ($changed1 & 57344) | ($changed1 & 458752) | ($changed1 & 3670016) | ($changed1 & 29360128) | ($changed1 & 234881024) | ($changed1 & 1879048192), ($changed2 & 14) | ($changed2 & 112) | ($changed2 & 896) | ($changed2 & 7168) | (57344 & $changed2) | ($changed2 & 458752) | ($changed2 & 3670016) | ($changed2 & 29360128) | ($changed2 & 234881024) | ($changed2 & 1879048192), ($changed3 & 14) | (($changed3 << 12) & 458752) | (($changed3 << 12) & 3670016) | (($changed3 << 12) & 29360128) | (($changed3 << 12) & 234881024) | (($changed3 << 12) & 1879048192), (($changed3 >> 18) & 14) | 3072 | (($changed3 >> 18) & 112) | (($changed3 >> 18) & 896), 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2464colors0hiis_0;
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    public final PopupProperties popupProperties$material3_release(boolean focusable, Composer $composer, int $changed, int i) {
        int flags;
        ComposerKt.sourceInformationMarkerStart($composer, -382576514, "C(popupProperties)746@40631L23:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 1) != 0) {
            focusable = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-382576514, $changed, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.popupProperties (ExposedDropdownMenu.android.kt:745)");
        }
        if (popupProperties$lambda$0(TouchExplorationStateProvider_androidKt.touchExplorationState($composer, 0))) {
            flags = 393216;
        } else if (!focusable) {
            flags = 393248 | 8;
        } else {
            flags = 393248;
        }
        PopupProperties popupProperties = new PopupProperties(flags, false, false, false, false, false, 62, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return popupProperties;
    }

    private static final boolean popupProperties$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final /* synthetic */ void TrailingIcon(final boolean expanded, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-473088613);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)769@41666L32:ExposedDropdownMenu.android.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473088613, $dirty2, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:769)");
            }
            TrailingIcon(expanded, Modifier.INSTANCE, $composer2, ($dirty2 & 14) | 48 | (($dirty2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ExposedDropdownMenuDefaults.this.TrailingIcon(expanded, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: textFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2236textFieldColorstN0laI(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledIndicatorColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledPlaceholderColor2;
        long disabledPrefixColor2;
        long disabledSuffixColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 611690079, "C(textFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)774@41913L5,775@42001L5,776@42096L5,778@42267L5,779@42355L5,780@42448L5,781@42529L5,782@42625L5,783@42704L7,785@42824L5,787@42939L5,789@43061L5,792@43273L5,794@43389L5,796@43502L5,798@43622L5,801@43828L5,803@43946L5,805@44061L5,807@44183L5,810@44392L5,811@44484L5,812@44573L5,813@44669L5,814@44759L5,816@44869L5,818@44981L5,820@45100L5,822@45287L5,823@45380L5,824@45475L5,826@45590L5,827@45755L5,828@45848L5,829@45943L5,831@46058L5,832@46223L5,834@46263L2215:ExposedDropdownMenu.android.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        long unfocusedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : unfocusedTextColor;
        if ((i & 4) != 0) {
            long value = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long errorTextColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6) : errorTextColor;
        long containerColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6) : containerColor;
        long errorContainerColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6) : errorContainerColor;
        long cursorColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6) : cursorColor;
        long errorCursorColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6) : errorCursorColor;
        if ((i & 256) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedIndicatorColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), $composer, 6) : focusedIndicatorColor;
        long unfocusedIndicatorColor2 = (i & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), $composer, 6) : unfocusedIndicatorColor;
        if ((i & 2048) != 0) {
            long value2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), $composer, 6);
            disabledIndicatorColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 4096) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), $composer, 6) : errorIndicatorColor;
        long focusedLeadingIconColor2 = (i & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((32768 & i) != 0) {
            long value3 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (65536 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6) : errorLeadingIconColor;
        long focusedTrailingIconColor2 = (131072 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (262144 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((524288 & i) != 0) {
            long value4 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (1048576 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6) : errorTrailingIconColor;
        long focusedLabelColor2 = (2097152 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6) : focusedLabelColor;
        long unfocusedLabelColor2 = (4194304 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6) : unfocusedLabelColor;
        long disabledLabelColor2 = (8388608 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6) : disabledLabelColor;
        long errorLabelColor2 = (16777216 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6) : errorLabelColor;
        long focusedPlaceholderColor2 = (33554432 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPlaceholderColor;
        long unfocusedPlaceholderColor2 = (67108864 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPlaceholderColor;
        if ((134217728 & i) != 0) {
            long value5 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value5) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value5) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        long errorPlaceholderColor2 = (268435456 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPlaceholderColor;
        long focusedPrefixColor2 = (536870912 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPrefixColor;
        long unfocusedPrefixColor2 = (i & BasicMeasure.EXACTLY) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPrefixColor;
        if ((i2 & 1) != 0) {
            long value6 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPrefixColor2 = Color.m4289copywmQWz5c(value6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value6) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value6) : 0.0f);
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        long errorPrefixColor2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPrefixColor;
        long focusedSuffixColor2 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedSuffixColor;
        long unfocusedSuffixColor2 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedSuffixColor;
        if ((i2 & 16) != 0) {
            long value7 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledSuffixColor2 = Color.m4289copywmQWz5c(value7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value7) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value7) : 0.0f);
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        long errorSuffixColor2 = (i2 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorSuffixColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611690079, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:834)");
        }
        TextFieldColors textFieldColorsM2234textFieldColorsFD9MK7s = m2234textFieldColorsFD9MK7s(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, containerColor2, containerColor2, containerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | (($changed << 3) & 458752) | (($changed << 6) & 3670016) | (($changed << 6) & 29360128) | (($changed << 6) & 234881024) | (($changed << 6) & 1879048192), (($changed >> 24) & 14) | (($changed >> 24) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344) | (($changed1 << 6) & 458752) | (($changed1 << 6) & 3670016) | (($changed1 << 6) & 29360128) | (($changed1 << 6) & 234881024) | (($changed1 << 6) & 1879048192), (($changed1 >> 24) & 14) | (($changed1 >> 24) & 112) | (($changed2 << 6) & 896) | (($changed2 << 6) & 7168) | (($changed2 << 6) & 57344) | (($changed2 << 6) & 458752) | (($changed2 << 6) & 3670016) | (($changed2 << 6) & 29360128) | (($changed2 << 6) & 234881024) | (($changed2 << 6) & 1879048192), (($changed2 >> 24) & 14) | (($changed2 >> 24) & 112) | (($changed3 << 6) & 896) | (($changed3 << 6) & 7168) | (57344 & ($changed3 << 6)) | (($changed3 << 6) & 458752) | (($changed3 << 6) & 3670016) | (($changed3 << 6) & 29360128) | (($changed3 << 6) & 234881024) | (($changed3 << 6) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2234textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: outlinedTextFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2233outlinedTextFieldColorstN0laI(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledBorderColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledLabelColor2;
        long disabledPlaceholderColor2;
        long disabledPrefixColor2;
        long disabledSuffixColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -388128543, "C(outlinedTextFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)879@48703L5,880@48793L5,881@48890L5,883@49065L5,886@49255L5,888@49365L5,889@49444L7,890@49543L5,891@49637L5,893@49750L5,895@49935L5,897@50053L5,899@50168L5,901@50290L5,904@50500L5,906@50620L5,908@50737L5,910@50861L5,913@51074L5,914@51168L5,915@51259L5,916@51357L5,918@51533L5,920@51645L5,922@51759L5,924@51880L5,927@52083L5,928@52178L5,929@52275L5,931@52392L5,932@52561L5,933@52656L5,934@52753L5,936@52870L5,937@53039L5,939@53079L2199:ExposedDropdownMenu.android.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        long unfocusedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : unfocusedTextColor;
        if ((i & 4) != 0) {
            long value = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long errorTextColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6) : errorTextColor;
        long containerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : containerColor;
        long errorContainerColor2 = (i & 32) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : errorContainerColor;
        long cursorColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6) : cursorColor;
        long errorCursorColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6) : errorCursorColor;
        if ((i & 256) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedBorderColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), $composer, 6) : focusedBorderColor;
        long unfocusedBorderColor2 = (i & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), $composer, 6) : unfocusedBorderColor;
        if ((i & 2048) != 0) {
            long value2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), $composer, 6);
            disabledBorderColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 4096) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), $composer, 6) : errorBorderColor;
        long focusedLeadingIconColor2 = (i & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((32768 & i) != 0) {
            long value3 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (65536 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6) : errorLeadingIconColor;
        long focusedTrailingIconColor2 = (131072 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (262144 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((524288 & i) != 0) {
            long value4 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (1048576 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6) : errorTrailingIconColor;
        long focusedLabelColor2 = (2097152 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6) : focusedLabelColor;
        long unfocusedLabelColor2 = (4194304 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6) : unfocusedLabelColor;
        if ((8388608 & i) != 0) {
            long value5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6);
            disabledLabelColor2 = Color.m4289copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value5) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value5) : 0.0f);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (16777216 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6) : errorLabelColor;
        long focusedPlaceholderColor2 = (33554432 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPlaceholderColor;
        long unfocusedPlaceholderColor2 = (67108864 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPlaceholderColor;
        if ((134217728 & i) != 0) {
            long value6 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value6) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value6) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        long errorPlaceholderColor2 = (268435456 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPlaceholderColor;
        long focusedPrefixColor2 = (536870912 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedPrefixColor;
        long unfocusedPrefixColor2 = (i & BasicMeasure.EXACTLY) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedPrefixColor;
        if ((i2 & 1) != 0) {
            long value7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledPrefixColor2 = Color.m4289copywmQWz5c(value7, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value7) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value7) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value7) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value7) : 0.0f);
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        long errorPrefixColor2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorPrefixColor;
        long focusedSuffixColor2 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : focusedSuffixColor;
        long unfocusedSuffixColor2 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : unfocusedSuffixColor;
        if ((i2 & 16) != 0) {
            long value8 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
            disabledSuffixColor2 = Color.m4289copywmQWz5c(value8, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value8) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value8) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value8) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value8) : 0.0f);
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        long errorSuffixColor2 = (i2 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : errorSuffixColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-388128543, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:939)");
        }
        TextFieldColors textFieldColorsM2231outlinedTextFieldColorsFD9MK7s = m2231outlinedTextFieldColorsFD9MK7s(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, containerColor2, containerColor2, containerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | (($changed << 3) & 458752) | (($changed << 6) & 3670016) | (($changed << 6) & 29360128) | (($changed << 6) & 234881024) | (($changed << 6) & 1879048192), (($changed >> 24) & 14) | (($changed >> 24) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344) | (($changed1 << 6) & 458752) | (($changed1 << 6) & 3670016) | (($changed1 << 6) & 29360128) | (($changed1 << 6) & 234881024) | (($changed1 << 6) & 1879048192), (($changed1 >> 24) & 14) | (($changed1 >> 24) & 112) | (($changed2 << 6) & 896) | (($changed2 << 6) & 7168) | (($changed2 << 6) & 57344) | (($changed2 << 6) & 458752) | (($changed2 << 6) & 3670016) | (($changed2 << 6) & 29360128) | (($changed2 << 6) & 234881024) | (($changed2 << 6) & 1879048192), (($changed2 >> 24) & 14) | (($changed2 >> 24) & 112) | (($changed3 << 6) & 896) | (($changed3 << 6) & 7168) | (57344 & ($changed3 << 6)) | (($changed3 << 6) & 458752) | (($changed3 << 6) & 3670016) | (($changed3 << 6) & 29360128) | (($changed3 << 6) & 234881024) | (($changed3 << 6) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2231outlinedTextFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: textFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2235textFieldColorsStqZLY(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledIndicatorColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1343678550, "C(textFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)984@55481L5,985@55576L5,987@55746L5,988@55827L5,989@55923L5,990@56002L7,992@56122L5,994@56237L5,996@56359L5,999@56571L5,1001@56687L5,1003@56800L5,1005@56920L5,1008@57126L5,1010@57244L5,1012@57359L5,1014@57481L5,1017@57690L5,1018@57782L5,1019@57871L5,1020@57967L5,1021@58057L5,1022@58148L5,1024@58262L5,1058@60067L5,1059@60157L5,1060@60254L5,1062@60429L5,1063@60517L5,1064@60607L5,1065@60704L5,1067@60879L5,1026@58379L2512:ExposedDropdownMenu.android.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            long value = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long containerColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6) : containerColor;
        long cursorColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6) : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6) : errorCursorColor;
        if ((i & 32) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedIndicatorColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), $composer, 6) : focusedIndicatorColor;
        long unfocusedIndicatorColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), $composer, 6) : unfocusedIndicatorColor;
        if ((i & 256) != 0) {
            long value2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), $composer, 6);
            disabledIndicatorColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), $composer, 6) : errorIndicatorColor;
        long focusedLeadingIconColor2 = (i & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 2048) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((i & 4096) != 0) {
            long value3 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6) : errorLeadingIconColor;
        long focusedTrailingIconColor2 = (i & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (32768 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((65536 & i) != 0) {
            long value4 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (131072 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6) : errorTrailingIconColor;
        long focusedLabelColor2 = (262144 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6) : focusedLabelColor;
        long unfocusedLabelColor2 = (524288 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6) : unfocusedLabelColor;
        long disabledLabelColor2 = (1048576 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6) : disabledLabelColor;
        long errorLabelColor2 = (2097152 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6) : errorLabelColor;
        long placeholderColor2 = (4194304 & i) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : placeholderColor;
        if ((i & 8388608) != 0) {
            long value5 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value5) : FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value5) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1343678550, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.android.kt:1026)");
        }
        long value6 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value8 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
        long jM4289copywmQWz5c = Color.m4289copywmQWz5c(value8, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value8) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value8) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value8) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value8) : 0.0f);
        long value9 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value10 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value11 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value12 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
        TextFieldColors textFieldColorsM2234textFieldColorsFD9MK7s = m2234textFieldColorsFD9MK7s(textColor2, textColor2, disabledTextColor2, textColor2, containerColor2, containerColor2, containerColor2, containerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, placeholderColor2, value6, value7, jM4289copywmQWz5c, value9, value10, value11, Color.m4289copywmQWz5c(value12, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value12) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value12) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value12) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value12) : 0.0f), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6), $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 9) & 7168) | (($changed << 6) & 57344) | (($changed << 9) & 458752) | (($changed << 12) & 3670016) | (($changed << 15) & 29360128) | (($changed << 15) & 234881024) | (($changed << 15) & 1879048192), (($changed >> 15) & 14) | (($changed >> 15) & 112) | (($changed >> 15) & 896) | (($changed >> 15) & 7168) | (($changed >> 15) & 57344) | (($changed1 << 15) & 458752) | (($changed1 << 15) & 3670016) | (($changed1 << 15) & 29360128) | (($changed1 << 15) & 234881024) | (($changed1 << 15) & 1879048192), (($changed1 >> 15) & 14) | (($changed1 >> 15) & 112) | (($changed1 >> 15) & 896) | (($changed1 >> 15) & 7168) | (($changed1 >> 15) & 57344) | (($changed2 << 15) & 458752) | (($changed2 << 15) & 3670016) | (($changed2 << 15) & 29360128) | (($changed2 << 18) & 234881024) | (($changed2 << 18) & 1879048192), (($changed2 >> 6) & 14) | (($changed2 << 15) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2234textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: outlinedTextFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2232outlinedTextFieldColorsStqZLY(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledBorderColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledLabelColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -836383316, "C(outlinedTextFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)1073@61104L5,1074@61201L5,1077@61419L5,1079@61529L5,1080@61608L7,1081@61707L5,1082@61801L5,1084@61914L5,1086@62099L5,1088@62217L5,1090@62332L5,1092@62454L5,1095@62664L5,1097@62784L5,1099@62901L5,1101@63025L5,1104@63238L5,1105@63332L5,1106@63423L5,1107@63521L5,1109@63697L5,1110@63790L5,1112@63906L5,1146@65697L5,1147@65787L5,1148@65884L5,1150@66059L5,1151@66147L5,1152@66237L5,1153@66334L5,1155@66509L5,1114@64025L2496:ExposedDropdownMenu.android.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            long value = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long containerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4326getTransparent0d7_KjU() : containerColor;
        long cursorColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6) : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6) : errorCursorColor;
        if ((i & 32) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedBorderColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), $composer, 6) : focusedBorderColor;
        long unfocusedBorderColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), $composer, 6) : unfocusedBorderColor;
        if ((i & 256) != 0) {
            long value2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), $composer, 6);
            disabledBorderColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), $composer, 6) : errorBorderColor;
        long focusedLeadingIconColor2 = (i & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 2048) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((i & 4096) != 0) {
            long value3 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6) : errorLeadingIconColor;
        long focusedTrailingIconColor2 = (i & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (32768 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((65536 & i) != 0) {
            long value4 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (131072 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6) : errorTrailingIconColor;
        long focusedLabelColor2 = (262144 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6) : focusedLabelColor;
        long unfocusedLabelColor2 = (524288 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6) : unfocusedLabelColor;
        if ((1048576 & i) != 0) {
            long value5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6);
            disabledLabelColor2 = Color.m4289copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value5) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value5) : 0.0f);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (2097152 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6) : errorLabelColor;
        long placeholderColor2 = (4194304 & i) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6) : placeholderColor;
        if ((i & 8388608) != 0) {
            long value6 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value6, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value6) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value6) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value6) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value6) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-836383316, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.android.kt:1114)");
        }
        long value7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value8 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value9 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
        long jM4289copywmQWz5c = Color.m4289copywmQWz5c(value9, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value9) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value9) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value9) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value9) : 0.0f);
        long value10 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value11 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value12 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long value13 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6);
        TextFieldColors textFieldColorsM2231outlinedTextFieldColorsFD9MK7s = m2231outlinedTextFieldColorsFD9MK7s(textColor2, textColor2, disabledTextColor2, textColor2, containerColor2, containerColor2, containerColor2, containerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, placeholderColor2, value7, value8, jM4289copywmQWz5c, value10, value11, value12, Color.m4289copywmQWz5c(value13, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value13) : OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value13) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value13) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value13) : 0.0f), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6), $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 9) & 7168) | (($changed << 6) & 57344) | (($changed << 9) & 458752) | (($changed << 12) & 3670016) | (($changed << 15) & 29360128) | (($changed << 15) & 234881024) | (($changed << 15) & 1879048192), (($changed >> 15) & 14) | (($changed >> 15) & 112) | (($changed >> 15) & 896) | (($changed >> 15) & 7168) | (($changed >> 15) & 57344) | (($changed1 << 15) & 458752) | (($changed1 << 15) & 3670016) | (($changed1 << 15) & 29360128) | (($changed1 << 15) & 234881024) | (($changed1 << 15) & 1879048192), (($changed1 >> 15) & 14) | (($changed1 >> 15) & 112) | (($changed1 >> 15) & 896) | (($changed1 >> 15) & 7168) | (($changed1 >> 15) & 57344) | (($changed2 << 15) & 458752) | (($changed2 << 15) & 3670016) | (($changed2 << 15) & 29360128) | (($changed2 << 18) & 234881024) | (($changed2 << 18) & 1879048192), (($changed2 >> 6) & 14) | (($changed2 << 15) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2231outlinedTextFieldColorsFD9MK7s;
    }
}
