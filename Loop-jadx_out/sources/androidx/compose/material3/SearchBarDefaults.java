package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: compiled from: SearchBar.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u008a\u0001\u0010 \u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u001e2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010&\u001a\u00020\u001e2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001e2\b\b\u0002\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010,\u001a\u00020\u001e2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u00020\u001e2\b\b\u0002\u00100\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u009e\u0001\u0010 \u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u001e2\b\b\u0002\u00104\u001a\u00020\u001e2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010&\u001a\u00020\u001e2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001e2\b\b\u0002\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010+\u001a\u00020\u001e2\b\b\u0002\u0010,\u001a\u00020\u001e2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\b\b\u0002\u00105\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u00020\u001e2\b\b\u0002\u00100\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b7\u00108R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, m195d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "ShadowElevation", "getShadowElevation-D9Ej5fM", "TonalElevation", "getTonalElevation-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchBarDefaults {
    public static final int $stable = 0;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float TonalElevation = ElevationTokens.INSTANCE.m3273getLevel0D9Ej5fM();
    private static final float ShadowElevation = ElevationTokens.INSTANCE.m3273getLevel0D9Ej5fM();
    private static final float Elevation = TonalElevation;
    private static final float InputFieldHeight = SearchBarTokens.INSTANCE.m3574getContainerHeightD9Ej5fM();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* JADX INFO: renamed from: getElevation-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2536getElevationD9Ej5fM$annotations() {
    }

    private SearchBarDefaults() {
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2541getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* JADX INFO: renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m2540getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2538getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX INFO: renamed from: getInputFieldHeight-D9Ej5fM, reason: not valid java name */
    public final float m2539getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -971556142, "C506@23291L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-971556142, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.android.kt:506)");
        }
        Shape value = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getFullScreenShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1665502056, "C510@23463L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1665502056, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.android.kt:510)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getDockedShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1006952150, "C513@23605L5:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006952150, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.android.kt:513)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 2112270157, "C516@23732L10:SearchBar.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2112270157, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.android.kt:516)");
        }
        WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return statusBars;
    }

    /* JADX INFO: renamed from: colors-Klgx-Pg, reason: not valid java name */
    public final SearchBarColors m2537colorsKlgxPg(long containerColor, long dividerColor, TextFieldColors inputFieldColors, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1216168196, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)528@24221L5,529@24288L5,530@24339L18:SearchBar.android.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        long dividerColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), $composer, 6) : dividerColor;
        TextFieldColors inputFieldColors2 = (i & 4) != 0 ? m2543inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, ($changed << 3) & 57344, 16383) : inputFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216168196, $changed, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:531)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(containerColor2, dividerColor2, inputFieldColors2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return searchBarColors;
    }

    /* JADX INFO: renamed from: inputFieldColors-ITpI4ow, reason: not valid java name */
    public final TextFieldColors m2543inputFieldColorsITpI4ow(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long cursorColor, SelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -602148837, "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)563@26306L5,564@26380L5,565@26463L5,567@26602L5,568@26681L7,569@26764L5,570@26847L5,572@26956L5,573@27102L5,574@27187L5,576@27298L5,577@27446L5,578@27532L5,579@27622L5,582@27750L847:SearchBar.android.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : focusedTextColor;
        long unfocusedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : unfocusedTextColor;
        if ((i & 4) != 0) {
            long value = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long cursorColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6) : cursorColor;
        if ((i & 16) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedLeadingIconColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((i & 128) != 0) {
            long value2 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long focusedTrailingIconColor2 = (i & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (i & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((i & 1024) != 0) {
            long value3 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long focusedPlaceholderColor2 = (i & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6) : focusedPlaceholderColor;
        long unfocusedPlaceholderColor2 = (i & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6) : unfocusedPlaceholderColor;
        if ((i & 8192) != 0) {
            long value4 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602148837, $changed, $changed1, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:582)");
        }
        TextFieldColors textFieldColorsM2796colors0hiis_0 = TextFieldDefaults.INSTANCE.m2796colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, 0L, 0L, 0L, 0L, 0L, cursorColor2, 0L, selectionColors2, 0L, 0L, 0L, 0L, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, 0L, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, 0L, 0L, 0L, 0L, 0L, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | (($changed << 15) & 234881024), (($changed >> 12) & 14) | (458752 & $changed) | (3670016 & $changed) | ($changed & 29360128) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($changed1 << 3) & 112) | (29360128 & ($changed1 << 18)) | (($changed1 << 18) & 234881024) | (($changed1 << 18) & 1879048192), 0, 3072, 1204058872, UnixStat.PERM_MASK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2796colors0hiis_0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: inputFieldColors--u-KgnY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2542inputFieldColorsuKgnY(long textColor, long disabledTextColor, long cursorColor, SelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledTextColor2;
        SelectionColors selectionColors2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long disabledPlaceholderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 355927049, "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)602@28787L5,603@28870L5,605@29009L5,606@29088L7,607@29171L5,608@29254L5,610@29363L5,611@29509L5,612@29594L5,614@29705L5,615@29846L5,616@29936L5,618@30021L765:SearchBar.android.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            long value = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledTextColor2 = Color.m4289copywmQWz5c(value, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value) : 0.0f);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long cursorColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6) : cursorColor;
        if ((i & 8) != 0) {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) objConsume;
        } else {
            selectionColors2 = selectionColors;
        }
        long focusedLeadingIconColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : focusedLeadingIconColor;
        long unfocusedLeadingIconColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6) : unfocusedLeadingIconColor;
        if ((i & 64) != 0) {
            long value2 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6);
            disabledLeadingIconColor2 = Color.m4289copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value2) : FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value2) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long focusedTrailingIconColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : focusedTrailingIconColor;
        long unfocusedTrailingIconColor2 = (i & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6) : unfocusedTrailingIconColor;
        if ((i & 512) != 0) {
            long value3 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6);
            disabledTrailingIconColor2 = Color.m4289copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value3) : FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value3) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long placeholderColor2 = (i & 1024) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6) : placeholderColor;
        if ((i & 2048) != 0) {
            long value4 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6);
            disabledPlaceholderColor2 = Color.m4289copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(value4) : FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(value4) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(355927049, $changed, $changed1, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:618)");
        }
        TextFieldColors textFieldColorsM2543inputFieldColorsITpI4ow = m2543inputFieldColorsITpI4ow(textColor2, textColor2, disabledTextColor2, cursorColor2, selectionColors2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 3) & 7168) | (($changed << 3) & 57344) | (($changed << 3) & 458752) | (($changed << 3) & 3670016) | (($changed << 3) & 29360128) | (($changed << 3) & 234881024) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($changed1 << 3) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textFieldColorsM2543inputFieldColorsITpI4ow;
    }
}
