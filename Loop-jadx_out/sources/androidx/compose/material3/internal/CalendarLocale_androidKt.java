package androidx.compose.material3.internal;

import android.content.res.Configuration;
import android.os.Build;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: compiled from: CalendarLocale.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m195d2 = {"defaultLocale", "Ljava/util/Locale;", "Landroidx/compose/material3/internal/CalendarLocale;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/Locale;", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CalendarLocale_androidKt {
    public static final Locale defaultLocale(Composer $composer, int $changed) {
        Locale localeDefaultLocale;
        ComposerKt.sourceInformationMarkerStart($composer, -1686747996, "C(defaultLocale):CalendarLocale.android.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1686747996, $changed, -1, "androidx.compose.material3.internal.defaultLocale (CalendarLocale.android.kt:33)");
        }
        if (Build.VERSION.SDK_INT >= 24) {
            $composer.startReplaceGroup(-1482593666);
            ComposerKt.sourceInformation($composer, "35@1259L15");
            localeDefaultLocale = Locale24.INSTANCE.defaultLocale($composer, 6);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1482593639);
            ComposerKt.sourceInformation($composer, "37@1346L7");
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer);
            localeDefaultLocale = ConfigurationCompat.getLocales((Configuration) objConsume).get(0);
            if (localeDefaultLocale == null) {
                localeDefaultLocale = Locale.getDefault();
            }
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return localeDefaultLocale;
    }
}
