package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: IconButton.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010%\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001eJ\r\u0010'\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010$J\r\u0010)\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010)\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010\u001eJ\r\u0010+\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010$J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101J\r\u00102\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u00102\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001eJ\u001f\u00104\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u000200H\u0007¢\u0006\u0002\u00106J\r\u00107\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u00107\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u0010$J\u001e\u00109\u001a\u00020\n*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001e\u0010=\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001e\u0010@\u001a\u00020\n*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010<J\u001e\u0010B\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\bC\u0010?R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\u00020\u000f*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, m195d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "()V", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "defaultFilledIconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultFilledIconButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "defaultFilledIconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultFilledIconToggleButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3_release", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3_release", "filledIconButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "filledIconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "filledIconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "iconButtonColors", "iconButtonColors-ro_MJ88", "iconToggleButtonColors", "iconToggleButtonColors-5tl4gsc", "outlinedIconButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "outlinedIconToggleButtonBorder", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultIconButtonColors", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3_release", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3_release", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3_release", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1265841879, "C558@26630L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1265841879, $changed, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:558)");
        }
        Shape value = ShapesKt.getValue(FilledIconButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1327125527, "C563@26800L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1327125527, $changed, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:563)");
        }
        Shape value = ShapesKt.getValue(OutlinedIconButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final IconButtonColors iconButtonColors(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1519621781);
        ComposerKt.sourceInformation($composer, "C(iconButtonColors)570@27026L7,571@27069L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1519621781, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:569)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        long contentColor = ((Color) objConsume).m4301unboximpl();
        IconButtonColors colors = m2278defaultIconButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6), contentColor);
        if (Color.m4292equalsimpl0(colors.getContentColor(), contentColor)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return colors;
        }
        IconButtonColors iconButtonColorsM2273copyjRlVdoo = colors.m2273copyjRlVdoo((5 & 1) != 0 ? colors.containerColor : 0L, (5 & 2) != 0 ? colors.contentColor : contentColor, (5 & 4) != 0 ? colors.disabledContainerColor : 0L, (5 & 8) != 0 ? colors.disabledContentColor : Color.m4289copywmQWz5c(contentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(contentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(contentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(contentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(contentColor) : 0.0f));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return iconButtonColorsM2273copyjRlVdoo;
    }

    /* JADX INFO: renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2286iconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 999008085, "C(iconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)594@28047L7,599@28277L11,599@28331L7:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) objConsume).m4301unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        if ((i & 8) != 0) {
            long j = contentColor2;
            disabledContentColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999008085, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:599)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme($composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        IconButtonColors iconButtonColorsM2273copyjRlVdoo = m2278defaultIconButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) objConsume2).m4301unboximpl()).m2273copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconButtonColorsM2273copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3_release, reason: not valid java name */
    public final IconButtonColors m2278defaultIconButtonColors4WTKRHQ$material3_release(ColorScheme $this$defaultIconButtonColors_u2d4WTKRHQ, long localContentColor) {
        IconButtonColors defaultIconButtonColorsCached = $this$defaultIconButtonColors_u2d4WTKRHQ.getDefaultIconButtonColorsCached();
        if (defaultIconButtonColorsCached != null) {
            return defaultIconButtonColorsCached;
        }
        IconButtonColors it = new IconButtonColors(Color.INSTANCE.m4326getTransparent0d7_KjU(), localContentColor, Color.INSTANCE.m4326getTransparent0d7_KjU(), Color.m4289copywmQWz5c(localContentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(localContentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(localContentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(localContentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(localContentColor) : 0.0f), null);
        $this$defaultIconButtonColors_u2d4WTKRHQ.setDefaultIconButtonColorsCached$material3_release(it);
        return it;
    }

    public final IconToggleButtonColors iconToggleButtonColors(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-589987581);
        ComposerKt.sourceInformation($composer, "C(iconToggleButtonColors)628@29397L7,629@29440L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-589987581, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:627)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        long contentColor = ((Color) objConsume).m4301unboximpl();
        IconToggleButtonColors colors = m2279defaultIconToggleButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6), contentColor);
        if (Color.m4292equalsimpl0(colors.getContentColor(), contentColor)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return colors;
        }
        IconToggleButtonColors iconToggleButtonColorsM2296copytNS2XkQ = colors.m2296copytNS2XkQ((53 & 1) != 0 ? colors.containerColor : 0L, (53 & 2) != 0 ? colors.contentColor : contentColor, (53 & 4) != 0 ? colors.disabledContainerColor : 0L, (53 & 8) != 0 ? colors.disabledContentColor : Color.m4289copywmQWz5c(contentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(contentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(contentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(contentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(contentColor) : 0.0f), (53 & 16) != 0 ? colors.checkedContainerColor : 0L, (53 & 32) != 0 ? colors.checkedContentColor : 0L);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return iconToggleButtonColorsM2296copytNS2XkQ;
    }

    /* JADX INFO: renamed from: iconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2287iconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -2020719549, "C(iconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)655@30625L7,661@30967L11,662@31036L7:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) objConsume).m4301unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        if ((i & 8) != 0) {
            long j = contentColor2;
            disabledContentColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        long checkedContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : checkedContainerColor;
        long checkedContentColor2 = (i & 32) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : checkedContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020719549, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:661)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme($composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        IconToggleButtonColors iconToggleButtonColorsM2296copytNS2XkQ = m2279defaultIconToggleButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) objConsume2).m4301unboximpl()).m2296copytNS2XkQ(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconToggleButtonColorsM2296copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultIconToggleButtonColors-4WTKRHQ$material3_release, reason: not valid java name */
    public final IconToggleButtonColors m2279defaultIconToggleButtonColors4WTKRHQ$material3_release(ColorScheme $this$defaultIconToggleButtonColors_u2d4WTKRHQ, long localContentColor) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = $this$defaultIconToggleButtonColors_u2d4WTKRHQ.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors it = new IconToggleButtonColors(Color.INSTANCE.m4326getTransparent0d7_KjU(), localContentColor, Color.INSTANCE.m4326getTransparent0d7_KjU(), Color.m4289copywmQWz5c(localContentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(localContentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(localContentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(localContentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(localContentColor) : 0.0f), Color.INSTANCE.m4326getTransparent0d7_KjU(), ColorSchemeKt.fromToken($this$defaultIconToggleButtonColors_u2d4WTKRHQ, IconButtonTokens.INSTANCE.getSelectedIconColor()), null);
        $this$defaultIconToggleButtonColors_u2d4WTKRHQ.setDefaultIconToggleButtonColorsCached$material3_release(it);
        return it;
    }

    public final IconButtonColors filledIconButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1857395287, "C(filledIconButtonColors)695@32325L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1857395287, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:695)");
        }
        IconButtonColors defaultFilledIconButtonColors$material3_release = getDefaultFilledIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultFilledIconButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: filledIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2282filledIconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -669858473, "C(filledIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)708@32969L31,711@33157L11:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer, $changed & 14) : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-669858473, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:711)");
        }
        IconButtonColors iconButtonColorsM2273copyjRlVdoo = getDefaultFilledIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2273copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconButtonColorsM2273copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledIconButtonColors$material3_release(ColorScheme $this$defaultFilledIconButtonColors) {
        IconButtonColors defaultFilledIconButtonColorsCached = $this$defaultFilledIconButtonColors.getDefaultFilledIconButtonColorsCached();
        if (defaultFilledIconButtonColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultFilledIconButtonColors, FilledIconButtonTokens.INSTANCE.getContainerColor());
            long jM2081contentColorFor4WTKRHQ = ColorSchemeKt.m2081contentColorFor4WTKRHQ($this$defaultFilledIconButtonColors, ColorSchemeKt.fromToken($this$defaultFilledIconButtonColors, FilledIconButtonTokens.INSTANCE.getContainerColor()));
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultFilledIconButtonColors, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken2) : FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken2) : 0.0f);
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultFilledIconButtonColors, FilledIconButtonTokens.INSTANCE.getDisabledColor());
            IconButtonColors it = new IconButtonColors(jFromToken, jM2081contentColorFor4WTKRHQ, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f), null);
            $this$defaultFilledIconButtonColors.setDefaultFilledIconButtonColorsCached$material3_release(it);
            return it;
        }
        return defaultFilledIconButtonColorsCached;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1554706367, "C(filledIconToggleButtonColors)738@34435L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1554706367, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:738)");
        }
        IconToggleButtonColors defaultFilledIconToggleButtonColors$material3_release = getDefaultFilledIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultFilledIconToggleButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: filledIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2283filledIconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1887173701, "C(filledIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)760@35649L38,762@35742L11:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        long checkedContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : checkedContainerColor;
        long checkedContentColor2 = (i & 32) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(checkedContainerColor2, $composer, ($changed >> 12) & 14) : checkedContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1887173701, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:762)");
        }
        IconToggleButtonColors iconToggleButtonColorsM2296copytNS2XkQ = getDefaultFilledIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2296copytNS2XkQ(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconToggleButtonColorsM2296copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3_release(ColorScheme $this$defaultFilledIconToggleButtonColors) {
        IconToggleButtonColors defaultFilledIconToggleButtonColorsCached = $this$defaultFilledIconToggleButtonColors.getDefaultFilledIconToggleButtonColorsCached();
        if (defaultFilledIconToggleButtonColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultFilledIconToggleButtonColors, FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultFilledIconToggleButtonColors, FilledIconButtonTokens.INSTANCE.getToggleUnselectedColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultFilledIconToggleButtonColors, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultFilledIconToggleButtonColors, FilledIconButtonTokens.INSTANCE.getDisabledColor());
            IconToggleButtonColors it = new IconToggleButtonColors(jFromToken, jFromToken2, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken4) : FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken4) : 0.0f), ColorSchemeKt.fromToken($this$defaultFilledIconToggleButtonColors, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.m2081contentColorFor4WTKRHQ($this$defaultFilledIconToggleButtonColors, ColorSchemeKt.fromToken($this$defaultFilledIconToggleButtonColors, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor())), null);
            $this$defaultFilledIconToggleButtonColors.setDefaultFilledIconToggleButtonColorsCached$material3_release(it);
            return it;
        }
        return defaultFilledIconToggleButtonColorsCached;
    }

    public final IconButtonColors filledTonalIconButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1099140437, "C(filledTonalIconButtonColors)796@37552L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1099140437, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:796)");
        }
        IconButtonColors defaultFilledTonalIconButtonColors$material3_release = getDefaultFilledTonalIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultFilledTonalIconButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: filledTonalIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2284filledTonalIconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -18532843, "C(filledTonalIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)810@38218L31,814@38414L11:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer, $changed & 14) : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-18532843, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:814)");
        }
        IconButtonColors iconButtonColorsM2273copyjRlVdoo = getDefaultFilledTonalIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2273copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconButtonColorsM2273copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColors$material3_release(ColorScheme $this$defaultFilledTonalIconButtonColors) {
        IconButtonColors defaultFilledTonalIconButtonColorsCached = $this$defaultFilledTonalIconButtonColors.getDefaultFilledTonalIconButtonColorsCached();
        if (defaultFilledTonalIconButtonColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultFilledTonalIconButtonColors, FilledTonalIconButtonTokens.INSTANCE.getContainerColor());
            long jM2081contentColorFor4WTKRHQ = ColorSchemeKt.m2081contentColorFor4WTKRHQ($this$defaultFilledTonalIconButtonColors, ColorSchemeKt.fromToken($this$defaultFilledTonalIconButtonColors, FilledTonalIconButtonTokens.INSTANCE.getContainerColor()));
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultFilledTonalIconButtonColors, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken2) : FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken2) : 0.0f);
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultFilledTonalIconButtonColors, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor());
            IconButtonColors it = new IconButtonColors(jFromToken, jM2081contentColorFor4WTKRHQ, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f), null);
            $this$defaultFilledTonalIconButtonColors.setDefaultFilledTonalIconButtonColorsCached$material3_release(it);
            return it;
        }
        return defaultFilledTonalIconButtonColorsCached;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 434219587, "C(filledTonalIconToggleButtonColors)843@39804L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(434219587, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:843)");
        }
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColors$material3_release = getDefaultFilledTonalIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultFilledTonalIconToggleButtonColors$material3_release;
    }

    /* JADX INFO: renamed from: filledTonalIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2285filledTonalIconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -19426557, "C(filledTonalIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)859@40670L31,865@40986L11:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        long contentColor2 = (i & 2) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer, $changed & 14) : contentColor;
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContentColor;
        long checkedContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : checkedContainerColor;
        long checkedContentColor2 = (i & 32) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : checkedContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-19426557, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:865)");
        }
        IconToggleButtonColors iconToggleButtonColorsM2296copytNS2XkQ = getDefaultFilledTonalIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2296copytNS2XkQ(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconToggleButtonColorsM2296copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3_release(ColorScheme $this$defaultFilledTonalIconToggleButtonColors) {
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached = $this$defaultFilledTonalIconToggleButtonColors.getDefaultFilledTonalIconToggleButtonColorsCached();
        if (defaultFilledTonalIconToggleButtonColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultFilledTonalIconToggleButtonColors, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor());
            long jM2081contentColorFor4WTKRHQ = ColorSchemeKt.m2081contentColorFor4WTKRHQ($this$defaultFilledTonalIconToggleButtonColors, ColorSchemeKt.fromToken($this$defaultFilledTonalIconToggleButtonColors, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor()));
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultFilledTonalIconToggleButtonColors, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor());
            long jM4289copywmQWz5c = Color.m4289copywmQWz5c(jFromToken2, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken2) : FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken2) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken2) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken2) : 0.0f);
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultFilledTonalIconToggleButtonColors, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor());
            IconToggleButtonColors it = new IconToggleButtonColors(jFromToken, jM2081contentColorFor4WTKRHQ, jM4289copywmQWz5c, Color.m4289copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jFromToken3) : FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), (14 & 2) != 0 ? Color.m4297getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jFromToken3) : 0.0f), ColorSchemeKt.fromToken($this$defaultFilledTonalIconToggleButtonColors, FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken($this$defaultFilledTonalIconToggleButtonColors, FilledTonalIconButtonTokens.INSTANCE.getToggleSelectedColor()), null);
            $this$defaultFilledTonalIconToggleButtonColors.m23xa626b4be(it);
            return it;
        }
        return defaultFilledTonalIconToggleButtonColorsCached;
    }

    public final IconButtonColors outlinedIconButtonColors(Composer $composer, int $changed) {
        $composer.startReplaceGroup(389287465);
        ComposerKt.sourceInformation($composer, "C(outlinedIconButtonColors)902@42796L11,902@42858L7,903@42912L7:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(389287465, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:900)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme($composer, 6);
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        IconButtonColors colors = m2280defaultOutlinedIconButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) objConsume).m4301unboximpl());
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        long contentColor = ((Color) objConsume2).m4301unboximpl();
        if (Color.m4292equalsimpl0(colors.getContentColor(), contentColor)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return colors;
        }
        IconButtonColors iconButtonColorsM2273copyjRlVdoo = colors.m2273copyjRlVdoo((5 & 1) != 0 ? colors.containerColor : 0L, (5 & 2) != 0 ? colors.contentColor : contentColor, (5 & 4) != 0 ? colors.disabledContainerColor : 0L, (5 & 8) != 0 ? colors.disabledContentColor : Color.m4289copywmQWz5c(contentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(contentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(contentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(contentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(contentColor) : 0.0f));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return iconButtonColorsM2273copyjRlVdoo;
    }

    /* JADX INFO: renamed from: outlinedIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2288outlinedIconButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1030517545, "C(outlinedIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)927@43875L7,932@44109L11,933@44184L7:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) objConsume).m4301unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        if ((i & 8) != 0) {
            long j = contentColor2;
            disabledContentColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030517545, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:932)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme($composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        IconButtonColors iconButtonColorsM2273copyjRlVdoo = m2280defaultOutlinedIconButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) objConsume2).m4301unboximpl()).m2273copyjRlVdoo(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconButtonColorsM2273copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconButtonColors-4WTKRHQ$material3_release, reason: not valid java name */
    public final IconButtonColors m2280defaultOutlinedIconButtonColors4WTKRHQ$material3_release(ColorScheme $this$defaultOutlinedIconButtonColors_u2d4WTKRHQ, long localContentColor) {
        IconButtonColors defaultOutlinedIconButtonColorsCached = $this$defaultOutlinedIconButtonColors_u2d4WTKRHQ.getDefaultOutlinedIconButtonColorsCached();
        if (defaultOutlinedIconButtonColorsCached != null) {
            return defaultOutlinedIconButtonColorsCached;
        }
        IconButtonColors it = new IconButtonColors(Color.INSTANCE.m4326getTransparent0d7_KjU(), localContentColor, Color.INSTANCE.m4326getTransparent0d7_KjU(), Color.m4289copywmQWz5c(localContentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(localContentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(localContentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(localContentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(localContentColor) : 0.0f), null);
        $this$defaultOutlinedIconButtonColors_u2d4WTKRHQ.setDefaultOutlinedIconButtonColorsCached$material3_release(it);
        return it;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-779749183);
        ComposerKt.sourceInformation($composer, "C(outlinedIconToggleButtonColors)963@45303L7,964@45346L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-779749183, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:962)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        long contentColor = ((Color) objConsume).m4301unboximpl();
        IconToggleButtonColors colors = m2281defaultOutlinedIconToggleButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6), contentColor);
        if (Color.m4292equalsimpl0(colors.getContentColor(), contentColor)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return colors;
        }
        IconToggleButtonColors iconToggleButtonColorsM2296copytNS2XkQ = colors.m2296copytNS2XkQ((53 & 1) != 0 ? colors.containerColor : 0L, (53 & 2) != 0 ? colors.contentColor : contentColor, (53 & 4) != 0 ? colors.disabledContainerColor : 0L, (53 & 8) != 0 ? colors.disabledContentColor : Color.m4289copywmQWz5c(contentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(contentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(contentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(contentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(contentColor) : 0.0f), (53 & 16) != 0 ? colors.checkedContainerColor : 0L, (53 & 32) != 0 ? colors.checkedContentColor : 0L);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return iconToggleButtonColorsM2296copytNS2XkQ;
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2289outlinedIconToggleButtonColors5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 2130592709, "C(outlinedIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)990@46559L7,995@46841L38,997@46934L11,998@47015L7:IconButton.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : containerColor;
        if ((i & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            contentColor2 = ((Color) objConsume).m4301unboximpl();
        } else {
            contentColor2 = contentColor;
        }
        long disabledContainerColor2 = (i & 4) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : disabledContainerColor;
        if ((i & 8) != 0) {
            long j = contentColor2;
            disabledContentColor2 = Color.m4289copywmQWz5c(j, (14 & 1) != 0 ? Color.m4293getAlphaimpl(j) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(j) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(j) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(j) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        long checkedContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4327getUnspecified0d7_KjU() : checkedContainerColor;
        long checkedContentColor2 = (i & 32) != 0 ? ColorSchemeKt.m2082contentColorForek8zF_U(checkedContainerColor2, $composer, ($changed >> 12) & 14) : checkedContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130592709, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:997)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme($composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = $composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        IconToggleButtonColors iconToggleButtonColorsM2296copytNS2XkQ = m2281defaultOutlinedIconToggleButtonColors4WTKRHQ$material3_release(colorScheme, ((Color) objConsume2).m4301unboximpl()).m2296copytNS2XkQ(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, checkedContainerColor2, checkedContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iconToggleButtonColorsM2296copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release, reason: not valid java name */
    public final IconToggleButtonColors m2281defaultOutlinedIconToggleButtonColors4WTKRHQ$material3_release(ColorScheme $this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ, long localContentColor) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = $this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors it = new IconToggleButtonColors(Color.INSTANCE.m4326getTransparent0d7_KjU(), localContentColor, Color.INSTANCE.m4326getTransparent0d7_KjU(), Color.m4289copywmQWz5c(localContentColor, (14 & 1) != 0 ? Color.m4293getAlphaimpl(localContentColor) : 0.38f, (14 & 2) != 0 ? Color.m4297getRedimpl(localContentColor) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(localContentColor) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(localContentColor) : 0.0f), ColorSchemeKt.fromToken($this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.m2081contentColorFor4WTKRHQ($this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ, ColorSchemeKt.fromToken($this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor())), null);
        $this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ.setDefaultOutlinedIconToggleButtonColorsCached$material3_release(it);
        return it;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean enabled, boolean checked, Composer $composer, int $changed) {
        $composer.startReplaceGroup(1244729690);
        ComposerKt.sourceInformation($composer, "C(outlinedIconToggleButtonBorder)P(1)1040@48689L33:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1244729690, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:1036)");
        }
        if (checked) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonBorder = outlinedIconButtonBorder(enabled, $composer, ($changed & 14) | (($changed >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return borderStrokeOutlinedIconButtonBorder;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean enabled, Composer $composer, int $changed) {
        long color;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -511461558, "C(outlinedIconButtonBorder)1056@49242L108:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511461558, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:1049)");
        }
        if (enabled) {
            $composer.startReplaceGroup(1252625506);
            ComposerKt.sourceInformation($composer, "1051@49065L7");
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            color = ((Color) objConsume).m4301unboximpl();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(1252625586);
            ComposerKt.sourceInformation($composer, "1053@49120L7");
            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentColor2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM4301unboximpl = ((Color) objConsume2).m4301unboximpl();
            color = Color.m4289copywmQWz5c(jM4301unboximpl, (14 & 1) != 0 ? Color.m4293getAlphaimpl(jM4301unboximpl) : 0.12f, (14 & 2) != 0 ? Color.m4297getRedimpl(jM4301unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4296getGreenimpl(jM4301unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4294getBlueimpl(jM4301unboximpl) : 0.0f);
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1252625683, "CC(remember):IconButton.kt#9igjgp");
        boolean invalid$iv = $composer.changed(color);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = BorderStrokeKt.m481BorderStrokecXLIe8U(OutlinedIconButtonTokens.INSTANCE.m3456getUnselectedOutlineWidthD9Ej5fM(), color);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        BorderStroke borderStroke = (BorderStroke) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return borderStroke;
    }
}
