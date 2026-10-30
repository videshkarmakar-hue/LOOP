package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Color;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.IntrinsicMeasureScope;
import androidx.compose.p001ui.layout.LayoutIdKt;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.text.TextLayoutResult;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0099\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m195d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SnackbarKt {
    private static final float ContainerMaxWidth = C1979Dp.m6801constructorimpl(600);
    private static final float HeightToFirstLine = C1979Dp.m6801constructorimpl(30);
    private static final float HorizontalSpacing = C1979Dp.m6801constructorimpl(16);
    private static final float HorizontalSpacingButtonSide = C1979Dp.m6801constructorimpl(8);
    private static final float SeparateButtonExtraY = C1979Dp.m6801constructorimpl(2);
    private static final float SnackbarVerticalPadding = C1979Dp.m6801constructorimpl(6);
    private static final float TextEndExtraSpacing = C1979Dp.m6801constructorimpl(8);
    private static final float LongButtonVerticalOffset = C1979Dp.m6801constructorimpl(12);

    /* JADX INFO: renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    public static final void m2651SnackbareQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionContentColor, long dismissActionContentColor, final Function2<? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Function2<? super Composer, ? super Integer, Unit> function6;
        boolean z;
        Shape shape2;
        int $dirty;
        Modifier.Companion modifier3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        boolean actionOnNewLine2;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        long actionContentColor2;
        long dismissActionContentColor2;
        Modifier modifier4;
        long containerColor3;
        long contentColor3;
        long actionContentColor3;
        long dismissActionContentColor3;
        Function2<? super Composer, ? super Integer, Unit> function9;
        boolean actionOnNewLine3;
        Shape shape4;
        Function2<? super Composer, ? super Integer, Unit> function10;
        int $dirty2;
        Composer $composer2 = $composer.startRestartGroup(-1235788955);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)103@5036L5,104@5088L5,105@5138L12,106@5201L18,107@5277L25,116@5544L1224,110@5348L1420:Snackbar.kt#uh7d8r");
        int $dirty3 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            function5 = function2;
        } else if (($changed & 48) == 0) {
            function5 = function2;
            $dirty3 |= $composer2.changedInstance(function5) ? 32 : 16;
        } else {
            function5 = function2;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            function6 = function3;
        } else if (($changed & 384) == 0) {
            function6 = function3;
            $dirty3 |= $composer2.changedInstance(function6) ? 256 : 128;
        } else {
            function6 = function3;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            z = actionOnNewLine;
        } else if (($changed & 3072) == 0) {
            z = actionOnNewLine;
            $dirty3 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = actionOnNewLine;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i6 = $composer2.changed(shape2) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                $dirty2 = $dirty3;
                int i7 = $composer2.changed(containerColor) ? 131072 : 65536;
                $dirty = $dirty2 | i7;
            } else {
                $dirty2 = $dirty3;
            }
            $dirty = $dirty2 | i7;
        } else {
            $dirty = $dirty3;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= ((i & 64) == 0 && $composer2.changed(contentColor)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(actionContentColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(dismissActionContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 536870912 : 268435456;
        }
        if (($dirty & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            containerColor3 = containerColor;
            contentColor3 = contentColor;
            actionContentColor3 = actionContentColor;
            dismissActionContentColor3 = dismissActionContentColor;
            modifier4 = modifier2;
            function9 = function5;
            function10 = function6;
            actionOnNewLine3 = z;
            shape4 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                function7 = i3 != 0 ? null : function5;
                function8 = i4 != 0 ? null : function6;
                actionOnNewLine2 = i5 != 0 ? false : z;
                if ((i & 16) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty &= -57345;
                } else {
                    shape3 = shape2;
                }
                if ((i & 32) != 0) {
                    containerColor2 = SnackbarDefaults.INSTANCE.getColor($composer2, 6);
                    $dirty &= -458753;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 64) != 0) {
                    contentColor2 = SnackbarDefaults.INSTANCE.getContentColor($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                if ((i & 128) != 0) {
                    actionContentColor2 = SnackbarDefaults.INSTANCE.getActionContentColor($composer2, 6);
                    $dirty &= -29360129;
                } else {
                    actionContentColor2 = actionContentColor;
                }
                if ((i & 256) != 0) {
                    dismissActionContentColor2 = SnackbarDefaults.INSTANCE.getDismissActionContentColor($composer2, 6);
                    $dirty = (-234881025) & $dirty;
                } else {
                    dismissActionContentColor2 = dismissActionContentColor;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    actionContentColor2 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    $dirty &= -234881025;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = containerColor;
                    contentColor2 = contentColor;
                } else {
                    actionContentColor2 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = containerColor;
                    contentColor2 = contentColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1235788955, $dirty, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:109)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function11 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function12 = function8;
            final long j = actionContentColor2;
            final long j2 = dismissActionContentColor2;
            final boolean z2 = actionOnNewLine2;
            Function2<? super Composer, ? super Integer, Unit> function13 = function7;
            Function2<? super Composer, ? super Integer, Unit> function14 = function8;
            SurfaceKt.m2666SurfaceT9BRK9s(modifier3, shape3, containerColor2, contentColor2, 0.0f, SnackbarTokens.INSTANCE.m3602getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C117@5584L10,118@5684L10,119@5809L953,119@5749L1013:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1829663446, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:117)");
                        }
                        TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                        final TextStyle actionTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                        ProvidedValue<TextStyle> providedValueProvides = TextKt.getLocalTextStyle().provides(textStyle);
                        final Function2<Composer, Integer, Unit> function15 = function11;
                        final Function2<Composer, Integer, Unit> function16 = function4;
                        final Function2<Composer, Integer, Unit> function17 = function12;
                        final long j3 = j;
                        final long j4 = j2;
                        final boolean z3 = z2;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C:Snackbar.kt#uh7d8r");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(835891690, $changed3, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:120)");
                                    }
                                    if (function15 == null) {
                                        $composer4.startReplaceGroup(-2104362302);
                                        ComposerKt.sourceInformation($composer4, "121@5864L278");
                                        SnackbarKt.m2650OneRowSnackbarkKq0p4A(function16, null, function17, actionTextStyle, j3, j4, $composer4, 48);
                                        $composer4.endReplaceGroup();
                                    } else if (z3) {
                                        $composer4.startReplaceGroup(-2104361988);
                                        ComposerKt.sourceInformation($composer4, "129@6178L255");
                                        SnackbarKt.m2649NewLineButtonSnackbarkKq0p4A(function16, function15, function17, actionTextStyle, j3, j4, $composer4, 0);
                                        $composer4.endReplaceGroup();
                                    } else {
                                        $composer4.startReplaceGroup(-2104361708);
                                        ComposerKt.sourceInformation($composer4, "137@6458L280");
                                        SnackbarKt.m2650OneRowSnackbarkKq0p4A(function16, function15, function17, actionTextStyle, j3, j4, $composer4, 0);
                                        $composer4.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | 12779520 | (($dirty >> 9) & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 7168), 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            actionContentColor3 = actionContentColor2;
            dismissActionContentColor3 = dismissActionContentColor2;
            function9 = function13;
            actionOnNewLine3 = actionOnNewLine2;
            shape4 = shape3;
            function10 = function14;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function9;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function10;
            final boolean z3 = actionOnNewLine3;
            final Shape shape5 = shape4;
            final long j3 = containerColor3;
            final long j4 = contentColor3;
            final long j5 = actionContentColor3;
            final long j6 = dismissActionContentColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    SnackbarKt.m2651SnackbareQBnUkQ(modifier5, function15, function16, z3, shape5, j3, j4, j5, j6, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Snackbar-sDKtq54, reason: not valid java name */
    public static final void m2652SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionColor, long actionContentColor, long dismissActionContentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Shape shape2;
        long j;
        long j2;
        int $dirty;
        Modifier.Companion modifier3;
        boolean actionOnNewLine2;
        Shape shape3;
        long containerColor2;
        long contentColor2;
        final long actionColor2;
        long actionContentColor2;
        long dismissActionContentColor2;
        long actionContentColor3;
        long actionColor3;
        Modifier modifier4;
        boolean actionOnNewLine3;
        Shape shape4;
        long containerColor3;
        long contentColor3;
        int $dirty2;
        Composer $composer2 = $composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)205@9659L5,206@9711L5,207@9761L12,208@9817L11,209@9879L18,210@9955L25,250@11380L38,240@10968L456:Snackbar.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(snackbarData) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
            z = actionOnNewLine;
        } else if (($changed & 384) == 0) {
            z = actionOnNewLine;
            $dirty3 |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i4 = $composer2.changed(shape2) ? 2048 : 1024;
                $dirty3 |= i4;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            if ((i & 16) == 0) {
                j = containerColor;
                int i5 = $composer2.changed(j) ? 16384 : 8192;
                $dirty3 |= i5;
            } else {
                j = containerColor;
            }
            $dirty3 |= i5;
        } else {
            j = containerColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                j2 = contentColor;
                int i6 = $composer2.changed(j2) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                j2 = contentColor;
            }
            $dirty3 |= i6;
        } else {
            j2 = contentColor;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                $dirty2 = $dirty3;
                int i7 = $composer2.changed(actionColor) ? 1048576 : 524288;
                $dirty = $dirty2 | i7;
            } else {
                $dirty2 = $dirty3;
            }
            $dirty = $dirty2 | i7;
        } else {
            $dirty = $dirty3;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer2.changed(actionContentColor)) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(dismissActionContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty4 = $dirty;
        if (($dirty4 & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            actionColor3 = actionColor;
            actionContentColor3 = actionContentColor;
            dismissActionContentColor2 = dismissActionContentColor;
            modifier4 = modifier2;
            actionOnNewLine3 = z;
            shape4 = shape2;
            containerColor3 = j;
            contentColor3 = j2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                actionOnNewLine2 = i3 != 0 ? false : z;
                if ((i & 8) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty4 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i & 16) != 0) {
                    containerColor2 = SnackbarDefaults.INSTANCE.getColor($composer2, 6);
                    $dirty4 &= -57345;
                } else {
                    containerColor2 = j;
                }
                if ((i & 32) != 0) {
                    contentColor2 = SnackbarDefaults.INSTANCE.getContentColor($composer2, 6);
                    $dirty4 &= -458753;
                } else {
                    contentColor2 = j2;
                }
                if ((i & 64) != 0) {
                    actionColor2 = SnackbarDefaults.INSTANCE.getActionColor($composer2, 6);
                    $dirty4 &= -3670017;
                } else {
                    actionColor2 = actionColor;
                }
                if ((i & 128) != 0) {
                    actionContentColor2 = SnackbarDefaults.INSTANCE.getActionContentColor($composer2, 6);
                    $dirty4 &= -29360129;
                } else {
                    actionContentColor2 = actionContentColor;
                }
                if ((i & 256) != 0) {
                    $dirty4 = (-234881025) & $dirty4;
                    actionContentColor3 = actionContentColor2;
                    dismissActionContentColor2 = SnackbarDefaults.INSTANCE.getDismissActionContentColor($composer2, 6);
                } else {
                    dismissActionContentColor2 = dismissActionContentColor;
                    actionContentColor3 = actionContentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty4 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty4 &= -29360129;
                }
                if ((i & 256) != 0) {
                    actionContentColor3 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    $dirty4 &= -234881025;
                    modifier3 = modifier2;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = j;
                    contentColor2 = j2;
                    actionColor2 = actionColor;
                } else {
                    actionContentColor3 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    modifier3 = modifier2;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = j;
                    contentColor2 = j2;
                    actionColor2 = actionColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274621471, $dirty4, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:211)");
            }
            final String actionLabel = snackbarData.getVisuals().getActionLabel();
            $composer2.startReplaceGroup(1020196999);
            ComposerKt.sourceInformation($composer2, "214@10142L243");
            Function2 actionComposable = actionLabel != null ? ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C216@10208L44,217@10280L32,218@10340L21,215@10156L219:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1378313599, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:215)");
                        }
                        ButtonColors buttonColorsM1970textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1970textButtonColorsro_MJ88(0L, actionColor2, 0L, 0L, $composer3, CpioConstants.C_ISBLK, 13);
                        ComposerKt.sourceInformationMarkerStart($composer3, -2057496735, "CC(remember):Snackbar.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(snackbarData);
                        final SnackbarData snackbarData2 = snackbarData;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    snackbarData2.performAction();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        final String str = actionLabel;
                        ButtonKt.TextButton((Function0) value$iv, null, false, null, buttonColorsM1970textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope $this$TextButton, Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C218@10342L17:Snackbar.kt#uh7d8r");
                                if (($changed3 & 17) == 16 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(521110564, $changed3, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:218)");
                                }
                                TextKt.m2817Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer3, 54), $composer3, 805306368, 494);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54) : null;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1020197391);
            ComposerKt.sourceInformation($composer2, "226@10557L362");
            Function2 dismissActionComposable = snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer3, "C228@10617L26,227@10575L330:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1812633777, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:227)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer3, -2057496398, "CC(remember):Snackbar.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(snackbarData);
                        final SnackbarData snackbarData2 = snackbarData;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    snackbarData2.dismiss();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2133getLambda1$material3_release(), $composer3, ProfileVerifier.CompilationStatus.f245xf2722a21, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54) : null;
            $composer2.endReplaceGroup();
            m2651SnackbareQBnUkQ(PaddingKt.m868padding3ABfNKs(modifier3, C1979Dp.m6801constructorimpl(12)), actionComposable, dismissActionComposable, actionOnNewLine2, shape3, containerColor2, contentColor2, actionContentColor3, dismissActionContentColor2, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C250@11382L34:Snackbar.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266389126, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:250)");
                    }
                    TextKt.m2817Text4IGK_g(snackbarData.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($dirty4 << 3) & 7168) | 805306368 | (($dirty4 << 3) & 57344) | (($dirty4 << 3) & 458752) | (3670016 & ($dirty4 << 3)) | (29360128 & $dirty4) | (234881024 & $dirty4), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor3 = actionColor2;
            modifier4 = modifier3;
            actionOnNewLine3 = actionOnNewLine2;
            shape4 = shape3;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final boolean z2 = actionOnNewLine3;
            final Shape shape5 = shape4;
            final long j3 = containerColor3;
            final long j4 = contentColor3;
            final long j5 = actionColor3;
            final long j6 = actionContentColor3;
            final long j7 = dismissActionContentColor2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    SnackbarKt.m2652SnackbarsDKtq54(snackbarData, modifier5, z2, shape5, j3, j4, j5, j6, j7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m2649NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final TextStyle actionTextStyle, final long actionContentColor, final long dismissActionContentColor, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function5;
        Composer $composer3 = $composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation($composer3, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)263@11699L1173:Snackbar.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function4) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(actionTextStyle) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changed(actionContentColor) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changed(dismissActionContentColor) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, $dirty2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:262)");
            }
            Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m920widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            int $i$f$Column = ((6 >> 3) & 14) | ((6 >> 3) & 112);
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $i$f$Column);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276694042, "C87@4365L9:Column.kt#2w3rfo");
            int i2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u243 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -916591905, "C273@12006L171,278@12187L679:Snackbar.kt#uh7d8r");
            Modifier modifier$iv2 = PaddingKt.m872paddingqDBjuR0$default(AlignmentLineKt.m718paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, HorizontalSpacingButtonSide, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            $composer2 = $composer3;
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor2;
                $composer3.createNode(function0);
            } else {
                function0 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 302366755, "C276@12169L6:Snackbar.kt#uh7d8r");
            function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = PaddingKt.m872paddingqDBjuR0$default($this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd()), 0.0f, 0.0f, function4 == null ? HorizontalSpacingButtonSide : C1979Dp.m6801constructorimpl(0), 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function1 = constructor3;
                $composer3.createNode(function1);
            } else {
                function1 = constructor3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 302366941, "C282@12355L501:Snackbar.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.INSTANCE;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function5 = constructor4;
                $composer3.createNode(function5);
            } else {
                function5 = constructor4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326681257, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 435596308, "C283@12377L208:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(actionContentColor)), TextKt.getLocalTextStyle().provides(actionTextStyle)}, function3, $composer3, $dirty2 & 112);
            $composer3.startReplaceGroup(302367188);
            ComposerKt.sourceInformation($composer3, "289@12651L173");
            if (function4 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(dismissActionContentColor)), function4, $composer3, ProvidedValue.$stable | (($dirty2 >> 3) & 112));
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    SnackbarKt.m2649NewLineButtonSnackbarkKq0p4A(function2, function3, function4, actionTextStyle, actionContentColor, dismissActionContentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m2650OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final TextStyle actionTextStyle, final long actionTextColor, final long dismissActionColor, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function5;
        Function0<ComposeUiNode> function6;
        Composer $composer3 = $composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation($composer3, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)336@14212L3465,311@13230L4447:Snackbar.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function4) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(actionTextStyle) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer3.changed(actionTextColor) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changed(dismissActionColor) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, $dirty2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:307)");
            }
            final String textTag = "text";
            final String actionTag = "action";
            final String dismissActionTag = "dismissAction";
            Modifier modifier$iv = PaddingKt.m872paddingqDBjuR0$default(Modifier.INSTANCE, HorizontalSpacing, 0.0f, function4 == null ? HorizontalSpacingButtonSide : C1979Dp.m6801constructorimpl(0), 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 44739496, "CC(remember):Snackbar.kt#9igjgp");
            MeasurePolicy value$iv = $composer3.rememberedValue();
            if (value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.p001ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo285measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        Object it$iv;
                        Object it$iv2;
                        int containerHeight;
                        int baselineOffset;
                        int textPlaceY;
                        int it;
                        int containerWidth = Math.min(Constraints.m6744getMaxWidthimpl(constraints), $this$Layout.mo561roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
                        String str = actionTag;
                        int index$iv$iv = 0;
                        int size = list.size();
                        while (true) {
                            if (index$iv$iv >= size) {
                                it$iv = null;
                                break;
                            }
                            it$iv = list.get(index$iv$iv);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) it$iv), str)) {
                                break;
                            }
                            index$iv$iv++;
                        }
                        Measurable measurable = (Measurable) it$iv;
                        final Placeable actionButtonPlaceable = measurable != null ? measurable.mo5644measureBRTryo0(constraints) : null;
                        String str2 = dismissActionTag;
                        List<? extends Measurable> list2 = list;
                        int index$iv$iv2 = 0;
                        int size2 = list2.size();
                        while (true) {
                            if (index$iv$iv2 >= size2) {
                                it$iv2 = null;
                                break;
                            }
                            it$iv2 = list2.get(index$iv$iv2);
                            List<? extends Measurable> list3 = list2;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) it$iv2), str2)) {
                                break;
                            }
                            index$iv$iv2++;
                            list2 = list3;
                        }
                        Measurable measurable2 = (Measurable) it$iv2;
                        final Placeable dismissButtonPlaceable = measurable2 != null ? measurable2.mo5644measureBRTryo0(constraints) : null;
                        int actionButtonWidth = actionButtonPlaceable != null ? actionButtonPlaceable.getWidth() : 0;
                        int actionButtonHeight = actionButtonPlaceable != null ? actionButtonPlaceable.getHeight() : 0;
                        int dismissButtonWidth = dismissButtonPlaceable != null ? dismissButtonPlaceable.getWidth() : 0;
                        int dismissButtonHeight = dismissButtonPlaceable != null ? dismissButtonPlaceable.getHeight() : 0;
                        int extraSpacingWidth = dismissButtonWidth == 0 ? $this$Layout.mo561roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0;
                        int textMaxWidth = RangesKt.coerceAtLeast(((containerWidth - actionButtonWidth) - dismissButtonWidth) - extraSpacingWidth, Constraints.m6746getMinWidthimpl(constraints));
                        String str3 = textTag;
                        int size3 = list.size();
                        for (int index$iv$iv3 = 0; index$iv$iv3 < size3; index$iv$iv3++) {
                            Object item$iv$iv = list.get(index$iv$iv3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) item$iv$iv), str3)) {
                                final Placeable textPlaceable = ((Measurable) item$iv$iv).mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : textMaxWidth, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0));
                                int firstTextBaseline = textPlaceable.get(androidx.compose.p001ui.layout.AlignmentLineKt.getFirstBaseline());
                                if (!(firstTextBaseline != Integer.MIN_VALUE)) {
                                    throw new IllegalArgumentException("No baselines for text".toString());
                                }
                                int lastTextBaseline = textPlaceable.get(androidx.compose.p001ui.layout.AlignmentLineKt.getLastBaseline());
                                if (!(lastTextBaseline != Integer.MIN_VALUE)) {
                                    throw new IllegalArgumentException("No baselines for text".toString());
                                }
                                boolean isOneLine = firstTextBaseline == lastTextBaseline;
                                final int dismissButtonPlaceX = containerWidth - dismissButtonWidth;
                                final int actionButtonPlaceX = dismissButtonPlaceX - actionButtonWidth;
                                if (isOneLine) {
                                    int minContainerHeight = $this$Layout.mo561roundToPx0680j_4(SnackbarTokens.INSTANCE.m3604getSingleLineContainerHeightD9Ej5fM());
                                    int contentHeight = Math.max(actionButtonHeight, dismissButtonHeight);
                                    containerHeight = Math.max(minContainerHeight, contentHeight);
                                    int textPlaceY2 = (containerHeight - textPlaceable.getHeight()) / 2;
                                    baselineOffset = (actionButtonPlaceable == null || (it = actionButtonPlaceable.get(androidx.compose.p001ui.layout.AlignmentLineKt.getFirstBaseline())) == Integer.MIN_VALUE) ? 0 : (textPlaceY2 + firstTextBaseline) - it;
                                    textPlaceY = textPlaceY2;
                                } else {
                                    int baselineOffset2 = $this$Layout.mo561roundToPx0680j_4(SnackbarKt.HeightToFirstLine);
                                    int textPlaceY3 = baselineOffset2 - firstTextBaseline;
                                    int minContainerHeight2 = $this$Layout.mo561roundToPx0680j_4(SnackbarTokens.INSTANCE.m3605getTwoLinesContainerHeightD9Ej5fM());
                                    int contentHeight2 = textPlaceY3 + textPlaceable.getHeight();
                                    containerHeight = Math.max(minContainerHeight2, contentHeight2);
                                    int actionButtonPlaceY = actionButtonPlaceable != null ? (containerHeight - actionButtonPlaceable.getHeight()) / 2 : 0;
                                    baselineOffset = actionButtonPlaceY;
                                    textPlaceY = textPlaceY3;
                                }
                                final int dismissButtonPlaceY = dismissButtonPlaceable != null ? (containerHeight - dismissButtonPlaceable.getHeight()) / 2 : 0;
                                final int i = textPlaceY;
                                final int i2 = baselineOffset;
                                int dismissButtonHeight2 = containerHeight;
                                return MeasureScope.CC.layout$default($this$Layout, containerWidth, dismissButtonHeight2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                                        Placeable.PlacementScope.placeRelative$default($this$layout, textPlaceable, 0, i, 0.0f, 4, null);
                                        Placeable placeable = dismissButtonPlaceable;
                                        if (placeable != null) {
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable, dismissButtonPlaceX, dismissButtonPlaceY, 0.0f, 4, null);
                                        }
                                        Placeable placeable2 = actionButtonPlaceable;
                                        if (placeable2 != null) {
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, actionButtonPlaceX, i2, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = ((384 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), setCompositeKeyHash);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -167734255, "C313@13260L86:Snackbar.kt#uh7d8r");
            Modifier modifier$iv2 = PaddingKt.m870paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function1 = constructor2;
                $composer3.createNode(function1);
            } else {
                function1 = constructor2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3795constructorimpl($composer3);
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
            }
            Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 448288512, "C313@13338L6:Snackbar.kt#uh7d8r");
            function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.startReplaceGroup(-167734156);
            ComposerKt.sourceInformation($composer3, "315@13397L295");
            if (function3 != null) {
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function6 = constructor3;
                    $composer3.createNode(function6);
                } else {
                    function6 = constructor3;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 448288627, "C316@13453L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(actionTextColor)), TextKt.getLocalTextStyle().provides(actionTextStyle)}, function3, $composer3, $dirty2 & 112);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(44739003);
            ComposerKt.sourceInformation($composer3, "324@13764L247");
            if (function4 != null) {
                Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "dismissAction");
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv4 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14072L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function5 = constructor4;
                    $composer3.createNode(function5);
                } else {
                    function5 = constructor4;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3795constructorimpl($composer3);
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                }
                Updater.m3802setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                int i7 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 448289001, "C325@13827L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4281boximpl(dismissActionColor)), function4, $composer3, ProvidedValue.$stable | (($dirty2 >> 3) & 112));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    SnackbarKt.m2650OneRowSnackbarkKq0p4A(function2, function3, function4, actionTextStyle, actionTextColor, dismissActionColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
