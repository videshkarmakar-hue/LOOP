package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.p001ui.Alignment;
import androidx.compose.p001ui.ComposedModifierKt;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
import androidx.compose.p001ui.layout.MeasurePolicy;
import androidx.compose.p001ui.node.ComposeUiNode;
import androidx.compose.p001ui.semantics.SemanticsModifierKt;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.window.AndroidDialog_androidKt;
import androidx.compose.p001ui.window.DialogProperties;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aß\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aB\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\u001aB\u0010\u001e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m195d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "content", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BasicAlertDialog", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AndroidAlertDialog_androidKt {
    private static final float ButtonsMainAxisSpacing = C1979Dp.m6801constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = C1979Dp.m6801constructorimpl(12);

    /* JADX INFO: renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    public static final void m1911AlertDialogOix01E0(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Shape shape2;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        long containerColor2;
        long iconContentColor2;
        long titleContentColor2;
        long textContentColor2;
        DialogProperties properties2;
        int $dirty1;
        int $dirty2;
        float tonalElevation2;
        Modifier modifier2;
        float tonalElevation3;
        DialogProperties properties3;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Shape shape3;
        long containerColor3;
        long iconContentColor3;
        long titleContentColor3;
        long textContentColor3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        Composer $composer2 = $composer.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)87@4343L5,88@4398L14,89@4464L16,90@4533L17,91@4602L16,98@4853L1005,94@4739L1119:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty3 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function7 = function5;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            function7 = function5;
            $dirty |= $composer2.changedInstance(function7) ? 131072 : 65536;
        } else {
            function7 = function5;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
            function8 = function6;
        } else if (($changed & 1572864) == 0) {
            function8 = function6;
            $dirty |= $composer2.changedInstance(function8) ? 1048576 : 524288;
        } else {
            function8 = function6;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                shape2 = shape;
                int i7 = $composer2.changed(shape2) ? 8388608 : 4194304;
                $dirty |= i7;
            } else {
                shape2 = shape;
            }
            $dirty |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= ((i & 256) == 0 && $composer2.changed(containerColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & $changed) == 0) {
            $dirty |= ((i & 512) == 0 && $composer2.changed(iconContentColor)) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty3 |= ((i & 1024) == 0 && $composer2.changed(titleContentColor)) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty3 |= ((i & 2048) == 0 && $composer2.changed(textContentColor)) ? 32 : 16;
        }
        int i8 = i & 4096;
        if (i8 != 0) {
            $dirty3 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty3 |= $composer2.changed(tonalElevation) ? 256 : 128;
        }
        int i9 = i & 8192;
        if (i9 != 0) {
            $dirty3 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty3 |= $composer2.changed(properties) ? 2048 : 1024;
        }
        if (($dirty & 306783379) == 306783378 && ($dirty3 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function12 = function3;
            function14 = function4;
            containerColor3 = containerColor;
            iconContentColor3 = iconContentColor;
            titleContentColor3 = titleContentColor;
            textContentColor3 = textContentColor;
            tonalElevation3 = tonalElevation;
            properties3 = properties;
            function13 = function7;
            function11 = function8;
            shape3 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                function9 = i3 != 0 ? null : function3;
                function10 = i4 != 0 ? null : function4;
                if (i5 != 0) {
                    function7 = null;
                }
                if (i6 != 0) {
                    function8 = null;
                }
                Modifier modifier5 = modifier4;
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape($composer2, 6);
                }
                if ((i & 256) != 0) {
                    containerColor2 = AlertDialogDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 512) != 0) {
                    iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor($composer2, 6);
                    $dirty &= -1879048193;
                } else {
                    iconContentColor2 = iconContentColor;
                }
                if ((i & 1024) != 0) {
                    titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor($composer2, 6);
                    $dirty3 &= -15;
                } else {
                    titleContentColor2 = titleContentColor;
                }
                if ((i & 2048) != 0) {
                    textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor($composer2, 6);
                    $dirty3 &= -113;
                } else {
                    textContentColor2 = textContentColor;
                }
                float tonalElevation4 = i8 != 0 ? AlertDialogDefaults.INSTANCE.m1908getTonalElevationD9Ej5fM() : tonalElevation;
                if (i9 != 0) {
                    properties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    $dirty1 = $dirty3;
                    $dirty2 = $dirty;
                    tonalElevation2 = tonalElevation4;
                    modifier2 = modifier5;
                } else {
                    properties2 = properties;
                    $dirty1 = $dirty3;
                    $dirty2 = $dirty;
                    tonalElevation2 = tonalElevation4;
                    modifier2 = modifier5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty3 &= -15;
                }
                if ((i & 2048) != 0) {
                    function9 = function3;
                    function10 = function4;
                    containerColor2 = containerColor;
                    iconContentColor2 = iconContentColor;
                    titleContentColor2 = titleContentColor;
                    textContentColor2 = textContentColor;
                    properties2 = properties;
                    $dirty1 = $dirty3 & (-113);
                    $dirty2 = $dirty;
                    modifier2 = modifier;
                    tonalElevation2 = tonalElevation;
                } else {
                    modifier2 = modifier;
                    function9 = function3;
                    function10 = function4;
                    containerColor2 = containerColor;
                    iconContentColor2 = iconContentColor;
                    titleContentColor2 = titleContentColor;
                    textContentColor2 = textContentColor;
                    properties2 = properties;
                    $dirty1 = $dirty3;
                    $dirty2 = $dirty;
                    tonalElevation2 = tonalElevation;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2081346864, $dirty2, $dirty1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:94)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function15 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function8;
            final Shape shape4 = shape2;
            final long j = containerColor2;
            final float tonalElevation5 = tonalElevation2;
            final long j2 = iconContentColor2;
            final long j3 = titleContentColor2;
            final long j4 = textContentColor2;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function9;
            Function2<Composer, Integer, Unit> function19 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1
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
                    ComposerKt.sourceInformation($composer3, "C100@4897L262,119@5707L5,99@4859L997:AndroidAlertDialog.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(461081686, $changed2, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:99)");
                        }
                        final Function2<Composer, Integer, Unit> function20 = function18;
                        final Function2<Composer, Integer, Unit> function21 = function2;
                        AlertDialogKt.m1909AlertDialogContent4hvqGtA(ComposableLambdaKt.rememberComposableLambda(-3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1
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
                                ComposerKt.sourceInformation($composer4, "C104@5062L87,101@4911L238:AndroidAlertDialog.android.kt#uh7d8r");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-3244296, $changed3, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:101)");
                                    }
                                    float f = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                    float f2 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                    final Function2<Composer, Integer, Unit> function22 = function20;
                                    final Function2<Composer, Integer, Unit> function23 = function21;
                                    AlertDialogKt.m1910AlertDialogFlowRowixp7dh8(f, f2, ComposableLambdaKt.rememberComposableLambda(-909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                        public final void invoke(Composer $composer5, int $changed4) {
                                            ComposerKt.sourceInformation($composer5, "C106@5120L15:AndroidAlertDialog.android.kt#uh7d8r");
                                            if (($changed4 & 3) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-909933713, $changed4, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:105)");
                                                }
                                                Function2<Composer, Integer, Unit> function24 = function22;
                                                $composer5.startReplaceGroup(-1969500567);
                                                ComposerKt.sourceInformation($composer5, "105@5095L8");
                                                if (function24 != null) {
                                                    function24.invoke($composer5, 0);
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                $composer5.endReplaceGroup();
                                                function23.invoke($composer5, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }, $composer4, 54), $composer4, 438);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), null, function15, function16, function17, shape4, j, tonalElevation5, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), $composer3, 6), j2, j3, j4, $composer3, 6, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            };
            Function2<? super Composer, ? super Integer, Unit> function20 = function9;
            BasicAlertDialog(function0, modifier2, properties2, ComposableLambdaKt.rememberComposableLambda(461081686, true, function19, $composer2, 54), $composer2, ($dirty2 & 14) | 3072 | (($dirty2 >> 3) & 112) | (($dirty1 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            tonalElevation3 = tonalElevation5;
            properties3 = properties2;
            function11 = function8;
            shape3 = shape2;
            containerColor3 = containerColor2;
            iconContentColor3 = iconContentColor2;
            titleContentColor3 = titleContentColor2;
            textContentColor3 = textContentColor2;
            function12 = function20;
            modifier3 = modifier2;
            function13 = function7;
            function14 = function10;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function21 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function22 = function14;
            final Function2<? super Composer, ? super Integer, Unit> function23 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function11;
            final Shape shape5 = shape3;
            final long j5 = containerColor3;
            final long j6 = iconContentColor3;
            final long j7 = titleContentColor3;
            final long j8 = textContentColor3;
            final float f = tonalElevation3;
            final DialogProperties dialogProperties = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.2
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

                public final void invoke(Composer composer, int i10) {
                    AndroidAlertDialog_androidKt.m1911AlertDialogOix01E0(function0, function2, modifier6, function21, function22, function23, function24, shape5, j5, j6, j7, j8, f, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void BasicAlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties properties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        DialogProperties dialogProperties;
        final Modifier modifier3;
        DialogProperties properties2;
        Composer $composer2 = $composer.startRestartGroup(-543157267);
        ComposerKt.sourceInformation($composer2, "C(BasicAlertDialog)P(2,1,3)161@7467L360,158@7375L452:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            dialogProperties = properties;
        } else if (($changed & 384) == 0) {
            dialogProperties = properties;
            $dirty |= $composer2.changed(dialogProperties) ? 256 : 128;
        } else {
            dialogProperties = properties;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            properties2 = dialogProperties;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            properties2 = i3 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-543157267, $dirty2, -1, "androidx.compose.material3.BasicAlertDialog (AndroidAlertDialog.android.kt:157)");
            }
            AndroidDialog_androidKt.Dialog(function0, properties2, ComposableLambdaKt.rememberComposableLambda(-777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.BasicAlertDialog.1
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
                    Object value$iv;
                    Function0<ComposeUiNode> function1;
                    ComposerKt.sourceInformation($composer3, "C162@7505L25,166@7695L37,163@7539L282:AndroidAlertDialog.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-777289724, $changed2, -1, "androidx.compose.material3.BasicAlertDialog.<anonymous> (AndroidAlertDialog.android.kt:162)");
                        }
                        Strings.Companion companion = Strings.INSTANCE;
                        final String dialogPaneDescription = Strings_androidKt.m3086getString2EP1pXo(Strings.m3017constructorimpl(C1459R.string.m3c_dialog), $composer3, 0);
                        Modifier modifierM917sizeInqDBjuR0$default = SizeKt.m917sizeInqDBjuR0$default(modifier3, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -874813385, "CC(remember):AndroidAlertDialog.android.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(dialogPaneDescription);
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                    SemanticsPropertiesKt.setPaneTitle($this$semantics, dialogPaneDescription);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv = modifierM917sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv, 1, null));
                        Function2<Composer, Integer, Unit> function3 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                        int $changed$iv$iv = (384 << 3) & 112;
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
                            function1 = constructor;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor;
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
                        int i4 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629260, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i5 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1196659005, "C169@7802L9:AndroidAlertDialog.android.kt#uh7d8r");
                        function3.invoke($composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ($dirty2 & 14) | 384 | (($dirty2 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final DialogProperties dialogProperties2 = properties2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.BasicAlertDialog.2
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

                public final void invoke(Composer composer, int i4) {
                    AndroidAlertDialog_androidKt.BasicAlertDialog(function0, modifier4, dialogProperties2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    public static final void AlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties properties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        DialogProperties dialogProperties;
        Modifier.Companion modifier3;
        DialogProperties properties2;
        Modifier modifier4;
        DialogProperties properties3;
        Composer $composer2 = $composer.startRestartGroup(63450171);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(2,1,3)211@9501L65:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            dialogProperties = properties;
        } else if (($changed & 384) == 0) {
            dialogProperties = properties;
            $dirty |= $composer2.changed(dialogProperties) ? 256 : 128;
        } else {
            dialogProperties = properties;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            properties3 = dialogProperties;
        } else {
            if (i2 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                properties2 = dialogProperties;
            } else {
                properties2 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(63450171, $dirty, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:211)");
            }
            BasicAlertDialog(function0, modifier3, properties2, function2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            properties3 = properties2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            final DialogProperties dialogProperties2 = properties3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.3
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

                public final void invoke(Composer composer, int i4) {
                    AndroidAlertDialog_androidKt.AlertDialog(function0, modifier5, dialogProperties2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
