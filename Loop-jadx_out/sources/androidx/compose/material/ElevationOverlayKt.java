package androidx.compose.material;

import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ElevationOverlay.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, m195d2 = {"LocalAbsoluteElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalElevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "elevation", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ElevationOverlayKt {
    private static final ProvidableCompositionLocal<ElevationOverlay> LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(new Function0<ElevationOverlay>() { // from class: androidx.compose.material.ElevationOverlayKt$LocalElevationOverlay$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ElevationOverlay invoke() {
            return DefaultElevationOverlay.INSTANCE;
        }
    });
    private static final ProvidableCompositionLocal<C1979Dp> LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0<C1979Dp>() { // from class: androidx.compose.material.ElevationOverlayKt$LocalAbsoluteElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ C1979Dp invoke() {
            return C1979Dp.m6799boximpl(m1696invokeD9Ej5fM());
        }

        /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m1696invokeD9Ej5fM() {
            return C1979Dp.m6801constructorimpl(0);
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<ElevationOverlay> getLocalElevationOverlay() {
        return LocalElevationOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateForegroundColor-CLU3JFs, reason: not valid java name */
    public static final long m1695calculateForegroundColorCLU3JFs(long backgroundColor, float elevation, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1613340891, "C(calculateForegroundColor)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)88@3446L32:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613340891, $changed, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:86)");
        }
        float alpha = ((((float) Math.log(elevation + 1)) * 4.5f) + 2.0f) / 100.0f;
        long baseForegroundColor = ColorsKt.m1645contentColorForek8zF_U(backgroundColor, $composer, $changed & 14);
        long jM4289copywmQWz5c = Color.m4289copywmQWz5c(baseForegroundColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(baseForegroundColor) : alpha, (14 & 2) != 0 ? Color.m4297getRedimpl(baseForegroundColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(baseForegroundColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(baseForegroundColor) : 0.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return jM4289copywmQWz5c;
    }

    public static final ProvidableCompositionLocal<C1979Dp> getLocalAbsoluteElevation() {
        return LocalAbsoluteElevation;
    }
}
