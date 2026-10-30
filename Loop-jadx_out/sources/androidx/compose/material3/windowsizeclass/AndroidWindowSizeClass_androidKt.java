package androidx.compose.material3.windowsizeclass;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.compose.p001ui.graphics.RectHelper_androidKt;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p001ui.platform.CompositionLocalsKt;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidWindowSizeClass.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m195d2 = {"calculateWindowSizeClass", "Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "material3-window-size-class_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidWindowSizeClass_androidKt {
    public static final WindowSizeClass calculateWindowSizeClass(Activity activity, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 866044206, "C(calculateWindowSizeClass)41@1807L7,42@1846L7:AndroidWindowSizeClass.android.kt#hkqeis");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(866044206, $changed, -1, "androidx.compose.material3.windowsizeclass.calculateWindowSizeClass (AndroidWindowSizeClass.android.kt:36)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        $composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) objConsume;
        WindowMetrics metrics = WindowMetricsCalculator.INSTANCE.getOrCreate().computeCurrentWindowMetrics(activity);
        long size = density.mo565toDpSizekrfVVM(RectHelper_androidKt.toComposeRect(metrics.getBounds()).m4082getSizeNHjbRc());
        WindowSizeClass windowSizeClassM3733calculateFromSizeqzXmJYc$default = WindowSizeClass.Companion.m3733calculateFromSizeqzXmJYc$default(WindowSizeClass.INSTANCE, size, null, null, 6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return windowSizeClassM3733calculateFromSizeqzXmJYc$default;
    }
}
