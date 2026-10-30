package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.platform.InspectableValueKt;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJD\u0010 \u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J0\u0010&\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001fJ\u0012\u0010(\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010)\u001a\u00020*R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\u00020\t8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u00020\t8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0014\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0016\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020\u0004X\u008a\u0084\u0002"}, m195d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "()V", "ScrollableTabRowEdgeStartPadding", "Landroidx/compose/ui/unit/Dp;", "getScrollableTabRowEdgeStartPadding-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor$annotations", "getContentColor", "primaryContainerColor", "getPrimaryContainerColor", "primaryContentColor", "getPrimaryContentColor", "secondaryContainerColor", "getSecondaryContainerColor", "secondaryContentColor", "getSecondaryContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "PrimaryIndicator", "width", "shape", "Landroidx/compose/ui/graphics/Shape;", "PrimaryIndicator-10LGxhE", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "SecondaryIndicator", "SecondaryIndicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3_release", "currentTabWidth", "indicatorOffset"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float ScrollableTabRowEdgeStartPadding = C1979Dp.m6801constructorimpl(52);

    @Deprecated(message = "Use TabRowDefaults.primaryContainerColor instead", replaceWith = @ReplaceWith(expression = "primaryContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContentColor instead", replaceWith = @ReplaceWith(expression = "primaryContentColor", imports = {}))
    public static /* synthetic */ void getContentColor$annotations() {
    }

    private TabRowDefaults() {
    }

    /* JADX INFO: renamed from: getScrollableTabRowEdgeStartPadding-D9Ej5fM, reason: not valid java name */
    public final float m2715getScrollableTabRowEdgeStartPaddingD9Ej5fM() {
        return ScrollableTabRowEdgeStartPadding;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -2026555673, "C1013@43826L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026555673, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:1013)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getPrimaryContainerColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -2069154037, "C1018@44009L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2069154037, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:1018)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getSecondaryContainerColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1938007129, "C1023@44198L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1938007129, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1023)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getContentColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1163072359, "C1032@44516L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1163072359, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:1032)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getPrimaryContentColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1410362619, "C1037@44701L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1410362619, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1037)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getSecondaryContentColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1166419479, "C1042@44892L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1166419479, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1042)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    @Deprecated(message = "Use SecondaryIndicator instead.", replaceWith = @ReplaceWith(expression = "SecondaryIndicator(modifier, height, color)", imports = {}))
    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    public final void m2712Indicator9IZ8Weo(Modifier modifier, float height, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        long color2;
        Modifier.Companion modifier3;
        float height2;
        Modifier modifier4;
        float height3;
        long color3;
        Composer $composer2 = $composer.startRestartGroup(1454716052);
        ComposerKt.sourceInformation($composer2, "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1063@45554L11,1065@45641L142:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f = height;
        } else if (($changed & 48) == 0) {
            f = height;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = height;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                int i4 = $composer2.changed(color2) ? 256 : 128;
                $dirty |= i4;
            } else {
                color2 = color;
            }
            $dirty |= i4;
        } else {
            color2 = color;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            height3 = f;
            color3 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                height2 = i3 != 0 ? PrimaryNavigationTabTokens.INSTANCE.m3558getActiveIndicatorHeightD9Ej5fM() : f;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    color2 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer2, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                height2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1454716052, $dirty, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1064)");
            }
            BoxKt.Box(BackgroundKt.m454backgroundbw27NRU$default(SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), height2), color2, null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            height3 = height2;
            color3 = color2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final float f2 = height3;
            final long j = color3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$Indicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    this.$tmp0_rcvr.m2712Indicator9IZ8Weo(modifier5, f2, j, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: PrimaryIndicator-10LGxhE, reason: not valid java name */
    public final void m2713PrimaryIndicator10LGxhE(Modifier modifier, float width, float height, long color, Shape shape, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        float height2;
        long color2;
        Shape shape2;
        Modifier.Companion modifier3;
        float width2;
        Modifier modifier4;
        float height3;
        long color3;
        Shape shape3;
        float width3;
        Composer $composer2 = $composer.startRestartGroup(-1895596205);
        ComposerKt.sourceInformation($composer2, "C(PrimaryIndicator)P(2,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1088@46409L5,1091@46503L174:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f = width;
        } else if (($changed & 48) == 0) {
            f = width;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = width;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            height2 = height;
        } else if (($changed & 384) == 0) {
            height2 = height;
            $dirty |= $composer2.changed(height2) ? 256 : 128;
        } else {
            height2 = height;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                color2 = color;
                int i5 = $composer2.changed(color2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                color2 = color;
            }
            $dirty |= i5;
        } else {
            color2 = color;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
            shape2 = shape;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            shape2 = shape;
            $dirty |= $composer2.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            height3 = height2;
            color3 = color2;
            shape3 = shape2;
            width3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                width2 = i3 != 0 ? C1979Dp.m6801constructorimpl(24) : f;
                if (i4 != 0) {
                    height2 = PrimaryNavigationTabTokens.INSTANCE.m3558getActiveIndicatorHeightD9Ej5fM();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    color2 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), $composer2, 6);
                }
                if (i6 != 0) {
                    shape2 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
                width2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1895596205, $dirty, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1090)");
            }
            SpacerKt.Spacer(BackgroundKt.m453backgroundbw27NRU(SizeKt.m910requiredWidth3ABfNKs(SizeKt.m902requiredHeight3ABfNKs(modifier3, height2), width2), color2, shape2), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            height3 = height2;
            color3 = color2;
            shape3 = shape2;
            width3 = width2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final float f2 = width3;
            final float f3 = height3;
            final long j = color3;
            final Shape shape4 = shape3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$PrimaryIndicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    this.$tmp0_rcvr.m2713PrimaryIndicator10LGxhE(modifier5, f2, f3, j, shape4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: SecondaryIndicator-9IZ8Weo, reason: not valid java name */
    public final void m2714SecondaryIndicator9IZ8Weo(Modifier modifier, float height, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        long color2;
        Modifier.Companion modifier3;
        float height2;
        Modifier modifier4;
        float height3;
        long color3;
        Composer $composer2 = $composer.startRestartGroup(-1498258020);
        ComposerKt.sourceInformation($composer2, "C(SecondaryIndicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1111@47194L5,1113@47216L142:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f = height;
        } else if (($changed & 48) == 0) {
            f = height;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = height;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                int i4 = $composer2.changed(color2) ? 256 : 128;
                $dirty |= i4;
            } else {
                color2 = color;
            }
            $dirty |= i4;
        } else {
            color2 = color;
        }
        if (($dirty & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            height3 = f;
            color3 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                height2 = i3 != 0 ? PrimaryNavigationTabTokens.INSTANCE.m3558getActiveIndicatorHeightD9Ej5fM() : f;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    color2 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), $composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                height2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498258020, $dirty, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1112)");
            }
            BoxKt.Box(BackgroundKt.m454backgroundbw27NRU$default(SizeKt.m899height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), height2), color2, null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            height3 = height2;
            color3 = color2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final float f2 = height3;
            final long j = color3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$SecondaryIndicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    this.$tmp0_rcvr.m2714SecondaryIndicator9IZ8Weo(modifier5, f2, j, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2 */
    /* JADX INFO: compiled from: TabRow.kt */
    @Metadata(m194d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m195d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, m196k = 3, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C15442 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ TabPosition $currentTabPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15442(TabPosition tabPosition) {
            super(3);
            this.$currentTabPosition = tabPosition;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        private static final float invoke$lambda$0(State<C1979Dp> state) {
            Object thisObj$iv = state.getValue();
            return ((C1979Dp) thisObj$iv).m6815unboximpl();
        }

        public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
            Object value$iv;
            $composer.startReplaceGroup(-1541271084);
            ComposerKt.sourceInformation($composer, "C1136@48044L165,1140@48241L164,1146@48501L53:TabRow.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1541271084, $changed, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1136)");
            }
            State<C1979Dp> stateM363animateDpAsStateAjpBEmI = AnimateAsStateKt.m363animateDpAsStateAjpBEmI(this.$currentTabPosition.getWidth(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, $composer, 0, 12);
            final State<C1979Dp> stateM363animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m363animateDpAsStateAjpBEmI(this.$currentTabPosition.getLeft(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, $composer, 0, 12);
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default($this$composed, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer, -58881099, "CC(remember):TabRow.kt#9igjgp");
            boolean invalid$iv = $composer.changed(stateM363animateDpAsStateAjpBEmI2);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m6924boximpl(m2716invokeBjo55l4(density));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m2716invokeBjo55l4(Density $this$offset) {
                        return IntOffsetKt.IntOffset($this$offset.mo561roundToPx0680j_4(TabRowDefaults.C15442.invoke$lambda$1(stateM363animateDpAsStateAjpBEmI2)), 0);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifierM918width3ABfNKs = SizeKt.m918width3ABfNKs(OffsetKt.offset(modifierWrapContentSize$default, (Function1) value$iv), invoke$lambda$0(stateM363animateDpAsStateAjpBEmI));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return modifierM918width3ABfNKs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$1(State<C1979Dp> state) {
            Object thisObj$iv = state.getValue();
            return ((C1979Dp) thisObj$iv).m6815unboximpl();
        }
    }

    public final Modifier tabIndicatorOffset(Modifier $this$tabIndicatorOffset, final TabPosition currentTabPosition) {
        return ComposedModifierKt.composed($this$tabIndicatorOffset, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("tabIndicatorOffset");
                $this$null.setValue(currentTabPosition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new C15442(currentTabPosition));
    }
}
