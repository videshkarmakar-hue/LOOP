package androidx.compose.material;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.p001ui.C1733R;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Strings.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, m195d2 = {"getString", "", "string", "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Strings_androidKt {
    /* JADX INFO: renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m1808getString4foXLRw(int string, Composer $composer, int $changed) {
        String string2;
        ComposerKt.sourceInformationMarkerStart($composer, -726638443, "C(getString)P(0:c#material.Strings)25@921L7,26@962L7:Strings.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, $changed, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        $composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Resources resources = ((Context) objConsume).getResources();
        if (Strings.m1797equalsimpl0(string, Strings.INSTANCE.m1805getNavigationMenuUdPEhr4())) {
            string2 = resources.getString(C1733R.string.navigation_menu);
        } else if (Strings.m1797equalsimpl0(string, Strings.INSTANCE.m1801getCloseDrawerUdPEhr4())) {
            string2 = resources.getString(C1733R.string.close_drawer);
        } else if (Strings.m1797equalsimpl0(string, Strings.INSTANCE.m1802getCloseSheetUdPEhr4())) {
            string2 = resources.getString(C1733R.string.close_sheet);
        } else if (Strings.m1797equalsimpl0(string, Strings.INSTANCE.m1803getDefaultErrorMessageUdPEhr4())) {
            string2 = resources.getString(C1733R.string.default_error_message);
        } else if (Strings.m1797equalsimpl0(string, Strings.INSTANCE.m1804getExposedDropdownMenuUdPEhr4())) {
            string2 = resources.getString(C1733R.string.dropdown_menu);
        } else if (Strings.m1797equalsimpl0(string, Strings.INSTANCE.m1807getSliderRangeStartUdPEhr4())) {
            string2 = resources.getString(C1733R.string.range_start);
        } else {
            string2 = Strings.m1797equalsimpl0(string, Strings.INSTANCE.m1806getSliderRangeEndUdPEhr4()) ? resources.getString(C1733R.string.range_end) : "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return string2;
    }
}
