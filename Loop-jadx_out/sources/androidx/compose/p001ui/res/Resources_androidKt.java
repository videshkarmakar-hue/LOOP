package androidx.compose.p001ui.res;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: Resources.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"resources", "Landroid/content/res/Resources;", "(Landroidx/compose/runtime/Composer;I)Landroid/content/res/Resources;", "ui_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Resources_androidKt {
    public static final Resources resources(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1554054999, "C(resources)34@1219L7,35@1251L7:Resources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1554054999, $changed, -1, "androidx.compose.ui.res.resources (Resources.android.kt:33)");
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return resources;
    }
}
