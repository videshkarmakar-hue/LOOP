package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.p001ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: PrefetchExecutor.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m195d2 = {"rememberDefaultPrefetchExecutor", "Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchExecutor;", "foundation_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PrefetchExecutor_androidKt {
    public static final PrefetchExecutor rememberDefaultPrefetchExecutor(Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1258212267, "C(rememberDefaultPrefetchExecutor)33@1251L7,34@1270L60:PrefetchExecutor.android.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1258212267, $changed, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchExecutor (PrefetchExecutor.android.kt:32)");
        }
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd($composer);
        View view = (View) objConsume;
        ComposerKt.sourceInformationMarkerStart($composer, 932459132, "CC(remember):PrefetchExecutor.android.kt#9igjgp");
        boolean invalid$iv = $composer.changed(view);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new AndroidPrefetchExecutor(view);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        AndroidPrefetchExecutor androidPrefetchExecutor = (AndroidPrefetchExecutor) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return androidPrefetchExecutor;
    }
}
