package androidx.compose.material;

import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0088\u0001\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0088\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001c\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m195d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Colors invoke() {
            return ColorsKt.m1648lightColors2qZNXz8((UnixStat.PERM_MASK & 1) != 0 ? ColorKt.Color(4284612846L) : 0L, (UnixStat.PERM_MASK & 2) != 0 ? ColorKt.Color(4281794739L) : 0L, (UnixStat.PERM_MASK & 4) != 0 ? ColorKt.Color(4278442694L) : 0L, (UnixStat.PERM_MASK & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (UnixStat.PERM_MASK & 16) != 0 ? Color.INSTANCE.m4328getWhite0d7_KjU() : 0L, (UnixStat.PERM_MASK & 32) != 0 ? Color.INSTANCE.m4328getWhite0d7_KjU() : 0L, (UnixStat.PERM_MASK & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (UnixStat.PERM_MASK & 128) != 0 ? Color.INSTANCE.m4328getWhite0d7_KjU() : 0L, (UnixStat.PERM_MASK & 256) != 0 ? Color.INSTANCE.m4317getBlack0d7_KjU() : 0L, (UnixStat.PERM_MASK & 512) != 0 ? Color.INSTANCE.m4317getBlack0d7_KjU() : 0L, (UnixStat.PERM_MASK & 1024) != 0 ? Color.INSTANCE.m4317getBlack0d7_KjU() : 0L, (UnixStat.PERM_MASK & 2048) != 0 ? Color.INSTANCE.m4328getWhite0d7_KjU() : 0L);
        }
    });

    /* JADX INFO: renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m1648lightColors2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, true, null);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m1647darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4290479868L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        return m1646darkColors2qZNXz8(jColor, jColor2, jColor3, (i & 8) != 0 ? jColor3 : j4, (i & 16) != 0 ? ColorKt.Color(4279374354L) : j5, (i & 32) != 0 ? ColorKt.Color(4279374354L) : j6, (i & 64) != 0 ? ColorKt.Color(4291782265L) : j7, (i & 128) != 0 ? Color.INSTANCE.m4317getBlack0d7_KjU() : j8, (i & 256) != 0 ? Color.INSTANCE.m4317getBlack0d7_KjU() : j9, (i & 512) != 0 ? Color.INSTANCE.m4328getWhite0d7_KjU() : j10, (i & 1024) != 0 ? Color.INSTANCE.m4328getWhite0d7_KjU() : j11, (i & 2048) != 0 ? Color.INSTANCE.m4317getBlack0d7_KjU() : j12);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m1646darkColors2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, false, null);
    }

    public static final long getPrimarySurface(Colors $this$primarySurface) {
        return $this$primarySurface.isLight() ? $this$primarySurface.m1627getPrimary0d7_KjU() : $this$primarySurface.m1631getSurface0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1644contentColorFor4WTKRHQ(Colors $this$contentColorFor_u2d4WTKRHQ, long backgroundColor) {
        if (!Color.m4292equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1627getPrimary0d7_KjU()) && !Color.m4292equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1628getPrimaryVariant0d7_KjU())) {
            if (!Color.m4292equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1629getSecondary0d7_KjU()) && !Color.m4292equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1630getSecondaryVariant0d7_KjU())) {
                if (Color.m4292equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1620getBackground0d7_KjU())) {
                    return $this$contentColorFor_u2d4WTKRHQ.m1622getOnBackground0d7_KjU();
                }
                if (Color.m4292equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1631getSurface0d7_KjU())) {
                    return $this$contentColorFor_u2d4WTKRHQ.m1626getOnSurface0d7_KjU();
                }
                return Color.m4292equalsimpl0(backgroundColor, $this$contentColorFor_u2d4WTKRHQ.m1621getError0d7_KjU()) ? $this$contentColorFor_u2d4WTKRHQ.m1623getOnError0d7_KjU() : Color.INSTANCE.m4327getUnspecified0d7_KjU();
            }
            return $this$contentColorFor_u2d4WTKRHQ.m1625getOnSecondary0d7_KjU();
        }
        return $this$contentColorFor_u2d4WTKRHQ.m1624getOnPrimary0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1645contentColorForek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 441849991, "C(contentColorFor)P(0:c#ui.graphics.Color):Colors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, $changed, -1, "androidx.compose.material.contentColorFor (Colors.kt:296)");
        }
        $composer.startReplaceGroup(-161205611);
        ComposerKt.sourceInformation($composer, "*296@11462L6,296@11533L7");
        long $this$takeOrElse_u2dDxMtmZc$iv = m1644contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors($composer, 6), backgroundColor);
        if (!($this$takeOrElse_u2dDxMtmZc$iv != 16)) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $this$takeOrElse_u2dDxMtmZc$iv = ((Color) objConsume).m4301unboximpl();
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return $this$takeOrElse_u2dDxMtmZc$iv;
    }

    public static final void updateColorsFrom(Colors $this$updateColorsFrom, Colors other) {
        $this$updateColorsFrom.m1639setPrimary8_81llA$material_release(other.m1627getPrimary0d7_KjU());
        $this$updateColorsFrom.m1640setPrimaryVariant8_81llA$material_release(other.m1628getPrimaryVariant0d7_KjU());
        $this$updateColorsFrom.m1641setSecondary8_81llA$material_release(other.m1629getSecondary0d7_KjU());
        $this$updateColorsFrom.m1642setSecondaryVariant8_81llA$material_release(other.m1630getSecondaryVariant0d7_KjU());
        $this$updateColorsFrom.m1632setBackground8_81llA$material_release(other.m1620getBackground0d7_KjU());
        $this$updateColorsFrom.m1643setSurface8_81llA$material_release(other.m1631getSurface0d7_KjU());
        $this$updateColorsFrom.m1633setError8_81llA$material_release(other.m1621getError0d7_KjU());
        $this$updateColorsFrom.m1636setOnPrimary8_81llA$material_release(other.m1624getOnPrimary0d7_KjU());
        $this$updateColorsFrom.m1637setOnSecondary8_81llA$material_release(other.m1625getOnSecondary0d7_KjU());
        $this$updateColorsFrom.m1634setOnBackground8_81llA$material_release(other.m1622getOnBackground0d7_KjU());
        $this$updateColorsFrom.m1638setOnSurface8_81llA$material_release(other.m1626getOnSurface0d7_KjU());
        $this$updateColorsFrom.m1635setOnError8_81llA$material_release(other.m1623getOnError0d7_KjU());
        $this$updateColorsFrom.setLight$material_release(other.isLight());
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }
}
