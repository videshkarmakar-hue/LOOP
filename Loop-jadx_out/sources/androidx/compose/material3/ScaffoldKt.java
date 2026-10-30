package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.layout.Measurable;
import androidx.compose.p001ui.layout.MeasureResult;
import androidx.compose.p001ui.layout.MeasureScope;
import androidx.compose.p001ui.layout.Placeable;
import androidx.compose.p001ui.layout.SubcomposeLayoutKt;
import androidx.compose.p001ui.layout.SubcomposeMeasureScope;
import androidx.compose.p001ui.unit.C1979Dp;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a±\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0087\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\b\t2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m195d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScaffoldKt {
    private static final float FabSpacing = C1979Dp.m6801constructorimpl(16);

    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    public static final void m2530ScaffoldTvnljyQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, int floatingActionButtonPosition, long containerColor, long contentColor, WindowInsets contentWindowInsets, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function6, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i2;
        long j;
        Modifier.Companion modifier2;
        long containerColor2;
        long contentColor2;
        Function2<? super Composer, ? super Integer, Unit> function10;
        final WindowInsets contentWindowInsets2;
        Function2<? super Composer, ? super Integer, Unit> function11;
        long containerColor3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function2<? super Composer, ? super Integer, Unit> function13;
        int floatingActionButtonPosition2;
        long contentColor3;
        int $dirty;
        Object value$iv;
        Object value$iv2;
        WindowInsets contentWindowInsets3;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1219521777);
        ComposerKt.sourceInformation($composer2, "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)89@4629L11,90@4679L31,91@4769L19,94@4864L86,98@5022L212,103@5305L314,97@4955L664:Scaffold.kt#uh7d8r");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            function7 = function2;
        } else if (($changed & 48) == 0) {
            function7 = function2;
            $dirty2 |= $composer2.changedInstance(function7) ? 32 : 16;
        } else {
            function7 = function2;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            function8 = function3;
        } else if (($changed & 384) == 0) {
            function8 = function3;
            $dirty2 |= $composer2.changedInstance(function8) ? 256 : 128;
        } else {
            function8 = function3;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            function9 = function4;
        } else if (($changed & 3072) == 0) {
            function9 = function4;
            $dirty2 |= $composer2.changedInstance(function9) ? 2048 : 1024;
        } else {
            function9 = function4;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty2 |= $composer2.changedInstance(function5) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty2 |= $composer2.changed(floatingActionButtonPosition) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                i2 = i8;
                int i9 = $composer2.changed(containerColor) ? 1048576 : 524288;
                $dirty2 |= i9;
            } else {
                i2 = i8;
            }
            $dirty2 |= i9;
        } else {
            i2 = i8;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                j = contentColor;
                int i10 = $composer2.changed(j) ? 8388608 : 4194304;
                $dirty2 |= i10;
            } else {
                j = contentColor;
            }
            $dirty2 |= i10;
        } else {
            j = contentColor;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= ((i & 256) == 0 && $composer2.changed(contentWindowInsets)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function6) ? 536870912 : 268435456;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            function13 = function5;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            containerColor3 = containerColor;
            contentWindowInsets3 = contentWindowInsets;
            function11 = function7;
            function10 = function8;
            function12 = function9;
            contentColor3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i3 != 0 ? Modifier.INSTANCE : modifier;
                Function2<? super Composer, ? super Integer, Unit> function2M2125getLambda1$material3_release = i4 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2125getLambda1$material3_release() : function7;
                Function2<? super Composer, ? super Integer, Unit> function2M2126getLambda2$material3_release = i5 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2126getLambda2$material3_release() : function8;
                Function2<? super Composer, ? super Integer, Unit> function2M2127getLambda3$material3_release = i6 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2127getLambda3$material3_release() : function9;
                Function2<? super Composer, ? super Integer, Unit> function2M2128getLambda4$material3_release = i7 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2128getLambda4$material3_release() : function5;
                int floatingActionButtonPosition3 = i2 != 0 ? FabPosition.INSTANCE.m2247getEndERTFSPs() : floatingActionButtonPosition;
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer2, 6).getBackground();
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorSchemeKt.m2082contentColorForek8zF_U(containerColor2, $composer2, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                } else {
                    contentColor2 = j;
                }
                if ((i & 256) != 0) {
                    function10 = function2M2126getLambda2$material3_release;
                    function11 = function2M2125getLambda1$material3_release;
                    containerColor3 = containerColor2;
                    function12 = function2M2127getLambda3$material3_release;
                    function13 = function2M2128getLambda4$material3_release;
                    floatingActionButtonPosition2 = floatingActionButtonPosition3;
                    contentWindowInsets2 = ScaffoldDefaults.INSTANCE.getContentWindowInsets($composer2, 6);
                    contentColor3 = contentColor2;
                    $dirty = $dirty2 & (-234881025);
                } else {
                    function10 = function2M2126getLambda2$material3_release;
                    contentWindowInsets2 = contentWindowInsets;
                    function11 = function2M2125getLambda1$material3_release;
                    containerColor3 = containerColor2;
                    function12 = function2M2127getLambda3$material3_release;
                    function13 = function2M2128getLambda4$material3_release;
                    floatingActionButtonPosition2 = floatingActionButtonPosition3;
                    contentColor3 = contentColor2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    function13 = function5;
                    floatingActionButtonPosition2 = floatingActionButtonPosition;
                    containerColor3 = containerColor;
                    function11 = function7;
                    function10 = function8;
                    function12 = function9;
                    contentColor3 = j;
                    contentWindowInsets2 = contentWindowInsets;
                    $dirty = $dirty2 & (-234881025);
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    function13 = function5;
                    floatingActionButtonPosition2 = floatingActionButtonPosition;
                    containerColor3 = containerColor;
                    function11 = function7;
                    function10 = function8;
                    function12 = function9;
                    contentColor3 = j;
                    contentWindowInsets2 = contentWindowInsets;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1219521777, $dirty, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -889185465, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = (((234881024 & $dirty) ^ 100663296) > 67108864 && $composer2.changed(contentWindowInsets2)) || ($dirty & 100663296) == 67108864;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MutableWindowInsets(contentWindowInsets2);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableWindowInsets safeInsets = (MutableWindowInsets) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -889185307, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(safeInsets) | ((((234881024 & $dirty) ^ 100663296) > 67108864 && $composer2.changed(contentWindowInsets2)) || (100663296 & $dirty) == 67108864);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets) {
                        invoke2(windowInsets);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WindowInsets consumedWindowInsets) {
                        safeInsets.setInsets(WindowInsetsKt.exclude(contentWindowInsets2, consumedWindowInsets));
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final int i11 = floatingActionButtonPosition2;
            final Function2<? super Composer, ? super Integer, Unit> function14 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function10;
            contentWindowInsets3 = contentWindowInsets2;
            SurfaceKt.m2666SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) value$iv2), null, containerColor3, contentColor3, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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
                    ComposerKt.sourceInformation($composer3, "C104@5315L298:Scaffold.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1979205334, $changed2, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:104)");
                        }
                        ScaffoldKt.m2531ScaffoldLayoutFMILGgc(i11, function14, function6, function15, function16, safeInsets, function17, $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (($dirty >> 12) & 896) | 12582912 | (($dirty >> 12) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function20 = function12;
            final Function2<? super Composer, ? super Integer, Unit> function21 = function13;
            final int i12 = floatingActionButtonPosition2;
            final long j2 = containerColor3;
            final long j3 = contentColor3;
            final WindowInsets windowInsets = contentWindowInsets3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$3
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

                public final void invoke(Composer composer, int i13) {
                    ScaffoldKt.m2530ScaffoldTvnljyQ(modifier4, function18, function19, function20, function21, i12, j2, j3, windowInsets, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m2531ScaffoldLayoutFMILGgc(final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function6, Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)138@6536L6446,138@6519L6463:Scaffold.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(contentWindowInsets) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function6) ? 1048576 : 524288;
        }
        if (($dirty & 599187) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, $dirty, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:137)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -915303803, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | (($dirty & 7168) == 2048) | ((458752 & $dirty) == 131072) | ((57344 & $dirty) == 16384) | (($dirty & 14) == 4) | ((3670016 & $dirty) == 1048576) | (($dirty & 896) == 256);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                i = 0;
                value$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m2533invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2533invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                        Object maxElem$iv;
                        Object maxElem$iv2;
                        Object maxElem$iv3;
                        FabPlacement fabPlacement;
                        Object maxElem$iv4;
                        final int snackbarOffsetFromBottom;
                        Object maxElem$iv5;
                        Object maxElem$iv6;
                        int fabLeftOffset;
                        final int layoutWidth = Constraints.m6744getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6743getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6734copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(constraints) : 0);
                        List<Measurable> listSubcompose = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function2);
                        List target$iv = new ArrayList(listSubcompose.size());
                        int size = listSubcompose.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = listSubcompose.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            target$iv.add(it.mo5644measureBRTryo0(looseConstraints));
                        }
                        final List topBarPlaceables = target$iv;
                        if (!topBarPlaceables.isEmpty()) {
                            maxElem$iv = topBarPlaceables.get(0);
                            Placeable it2 = (Placeable) maxElem$iv;
                            int maxValue$iv = it2.getHeight();
                            int i$iv = 1;
                            int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Object e$iv = topBarPlaceables.get(i$iv);
                                    Placeable it3 = (Placeable) e$iv;
                                    int v$iv = it3.getHeight();
                                    if (maxValue$iv < v$iv) {
                                        maxElem$iv = e$iv;
                                        maxValue$iv = v$iv;
                                    }
                                    if (i$iv == lastIndex) {
                                        break;
                                    }
                                    i$iv++;
                                }
                            }
                        } else {
                            maxElem$iv = null;
                        }
                        Placeable placeable = (Placeable) maxElem$iv;
                        final int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                        List<Measurable> listSubcompose2 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function4);
                        WindowInsets windowInsets = contentWindowInsets;
                        int $i$f$fastMap = 0;
                        List target$iv2 = new ArrayList(listSubcompose2.size());
                        List<Measurable> list = listSubcompose2;
                        int index$iv$iv2 = 0;
                        int size2 = list.size();
                        while (index$iv$iv2 < size2) {
                            Object item$iv$iv2 = list.get(index$iv$iv2);
                            Measurable it4 = (Measurable) item$iv$iv2;
                            List<Measurable> list2 = listSubcompose2;
                            int $i$f$fastMap2 = $i$f$fastMap;
                            int leftInset = windowInsets.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            List<Measurable> list3 = list;
                            int rightInset = windowInsets.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset = windowInsets.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets2 = windowInsets;
                            int i2 = (-leftInset) - rightInset;
                            int leftInset2 = -bottomInset;
                            target$iv2.add(it4.mo5644measureBRTryo0(ConstraintsKt.m6763offsetNN6EwU(looseConstraints, i2, leftInset2)));
                            index$iv$iv2++;
                            listSubcompose2 = list2;
                            $i$f$fastMap = $i$f$fastMap2;
                            list = list3;
                            windowInsets = windowInsets2;
                        }
                        final List snackbarPlaceables = target$iv2;
                        if (!snackbarPlaceables.isEmpty()) {
                            maxElem$iv2 = snackbarPlaceables.get(0);
                            Placeable it5 = (Placeable) maxElem$iv2;
                            int maxValue$iv2 = it5.getHeight();
                            int i$iv2 = 1;
                            int lastIndex2 = CollectionsKt.getLastIndex(snackbarPlaceables);
                            if (1 <= lastIndex2) {
                                while (true) {
                                    Object e$iv2 = snackbarPlaceables.get(i$iv2);
                                    Placeable it6 = (Placeable) e$iv2;
                                    int v$iv2 = it6.getHeight();
                                    if (maxValue$iv2 < v$iv2) {
                                        maxElem$iv2 = e$iv2;
                                        maxValue$iv2 = v$iv2;
                                    }
                                    if (i$iv2 == lastIndex2) {
                                        break;
                                    }
                                    i$iv2++;
                                }
                            }
                        } else {
                            maxElem$iv2 = null;
                        }
                        Placeable placeable2 = (Placeable) maxElem$iv2;
                        int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                        if (!snackbarPlaceables.isEmpty()) {
                            maxElem$iv3 = snackbarPlaceables.get(0);
                            Placeable it7 = (Placeable) maxElem$iv3;
                            int maxValue$iv3 = it7.getWidth();
                            int i$iv3 = 1;
                            int lastIndex3 = CollectionsKt.getLastIndex(snackbarPlaceables);
                            if (1 <= lastIndex3) {
                                while (true) {
                                    Object e$iv3 = snackbarPlaceables.get(i$iv3);
                                    Placeable it8 = (Placeable) e$iv3;
                                    int v$iv3 = it8.getWidth();
                                    if (maxValue$iv3 < v$iv3) {
                                        maxElem$iv3 = e$iv3;
                                        maxValue$iv3 = v$iv3;
                                    }
                                    if (i$iv3 == lastIndex3) {
                                        break;
                                    }
                                    i$iv3++;
                                }
                            }
                        } else {
                            maxElem$iv3 = null;
                        }
                        Placeable placeable3 = (Placeable) maxElem$iv3;
                        final int snackbarWidth = placeable3 != null ? placeable3.getWidth() : 0;
                        List<Measurable> listSubcompose3 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function5);
                        WindowInsets windowInsets3 = contentWindowInsets;
                        int $i$f$fastMapNotNull = 0;
                        List target$iv3 = new ArrayList(listSubcompose3.size());
                        List<Measurable> list4 = listSubcompose3;
                        int index$iv$iv3 = 0;
                        int size3 = list4.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = list4.get(index$iv$iv3);
                            Measurable measurable = (Measurable) item$iv$iv3;
                            List<Measurable> list5 = listSubcompose3;
                            int $i$f$fastMapNotNull2 = $i$f$fastMapNotNull;
                            int leftInset3 = windowInsets3.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            List<Measurable> list6 = list4;
                            int rightInset2 = windowInsets3.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset2 = windowInsets3.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets4 = windowInsets3;
                            int i3 = (-leftInset3) - rightInset2;
                            int leftInset4 = -bottomInset2;
                            Placeable it9 = measurable.mo5644measureBRTryo0(ConstraintsKt.m6763offsetNN6EwU(looseConstraints, i3, leftInset4));
                            if (!((it9.getHeight() == 0 || it9.getWidth() == 0) ? false : true)) {
                                it9 = null;
                            }
                            if (it9 != null) {
                                target$iv3.add(it9);
                            }
                            index$iv$iv3++;
                            listSubcompose3 = list5;
                            $i$f$fastMapNotNull = $i$f$fastMapNotNull2;
                            list4 = list6;
                            windowInsets3 = windowInsets4;
                        }
                        final List fabPlaceables = target$iv3;
                        if (!fabPlaceables.isEmpty()) {
                            if (!fabPlaceables.isEmpty()) {
                                maxElem$iv5 = fabPlaceables.get(0);
                                Placeable it10 = (Placeable) maxElem$iv5;
                                int maxValue$iv4 = it10.getWidth();
                                int i$iv4 = 1;
                                int lastIndex4 = CollectionsKt.getLastIndex(fabPlaceables);
                                if (1 <= lastIndex4) {
                                    while (true) {
                                        Object e$iv4 = fabPlaceables.get(i$iv4);
                                        Placeable it11 = (Placeable) e$iv4;
                                        int v$iv4 = it11.getWidth();
                                        if (maxValue$iv4 < v$iv4) {
                                            maxElem$iv5 = e$iv4;
                                            maxValue$iv4 = v$iv4;
                                        }
                                        if (i$iv4 == lastIndex4) {
                                            break;
                                        }
                                        i$iv4++;
                                    }
                                }
                            } else {
                                maxElem$iv5 = null;
                            }
                            Intrinsics.checkNotNull(maxElem$iv5);
                            int fabWidth = ((Placeable) maxElem$iv5).getWidth();
                            if (!fabPlaceables.isEmpty()) {
                                maxElem$iv6 = fabPlaceables.get(0);
                                Placeable it12 = (Placeable) maxElem$iv6;
                                int maxValue$iv5 = it12.getHeight();
                                int i$iv5 = 1;
                                int lastIndex5 = CollectionsKt.getLastIndex(fabPlaceables);
                                if (1 <= lastIndex5) {
                                    while (true) {
                                        Object e$iv5 = fabPlaceables.get(i$iv5);
                                        Placeable it13 = (Placeable) e$iv5;
                                        int v$iv5 = it13.getHeight();
                                        if (maxValue$iv5 < v$iv5) {
                                            maxElem$iv6 = e$iv5;
                                            maxValue$iv5 = v$iv5;
                                        }
                                        if (i$iv5 == lastIndex5) {
                                            break;
                                        }
                                        i$iv5++;
                                    }
                                }
                            } else {
                                maxElem$iv6 = null;
                            }
                            Intrinsics.checkNotNull(maxElem$iv6);
                            int fabHeight = ((Placeable) maxElem$iv6).getHeight();
                            int i4 = fabPosition;
                            if (FabPosition.m2242equalsimpl0(i4, FabPosition.INSTANCE.m2249getStartERTFSPs())) {
                                fabLeftOffset = $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth;
                            } else {
                                fabLeftOffset = FabPosition.m2242equalsimpl0(i4, FabPosition.INSTANCE.m2247getEndERTFSPs()) ? true : FabPosition.m2242equalsimpl0(i4, FabPosition.INSTANCE.m2248getEndOverlayERTFSPs()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (layoutWidth - $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - fabWidth) / 2;
                            }
                            fabPlacement = new FabPlacement(fabLeftOffset, fabWidth, fabHeight);
                        } else {
                            fabPlacement = null;
                        }
                        final FabPlacement fabPlacement2 = fabPlacement;
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function7 = function6;
                        List<Measurable> listSubcompose4 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-2146438447, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
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
                                ComposerKt.sourceInformation($composer3, "C218@9964L11:Scaffold.kt#uh7d8r");
                                if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2146438447, $changed2, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                }
                                function7.invoke($composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        int $i$f$fastMap3 = 0;
                        List target$iv4 = new ArrayList(listSubcompose4.size());
                        int index$iv$iv4 = 0;
                        int size4 = listSubcompose4.size();
                        while (index$iv$iv4 < size4) {
                            Object item$iv$iv4 = listSubcompose4.get(index$iv$iv4);
                            int $i$f$fastMap4 = $i$f$fastMap3;
                            Measurable it14 = (Measurable) item$iv$iv4;
                            target$iv4.add(it14.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv4++;
                            listSubcompose4 = listSubcompose4;
                            $i$f$fastMap3 = $i$f$fastMap4;
                        }
                        final List bottomBarPlaceables = target$iv4;
                        if (!bottomBarPlaceables.isEmpty()) {
                            maxElem$iv4 = bottomBarPlaceables.get(0);
                            Placeable it15 = (Placeable) maxElem$iv4;
                            int maxValue$iv6 = it15.getHeight();
                            int i$iv6 = 1;
                            int lastIndex6 = CollectionsKt.getLastIndex(bottomBarPlaceables);
                            if (1 <= lastIndex6) {
                                while (true) {
                                    Object e$iv6 = bottomBarPlaceables.get(i$iv6);
                                    Placeable it16 = (Placeable) e$iv6;
                                    int height = it16.getHeight();
                                    if (maxValue$iv6 < height) {
                                        maxElem$iv4 = e$iv6;
                                        maxValue$iv6 = height;
                                    }
                                    if (i$iv6 == lastIndex6) {
                                        break;
                                    }
                                    i$iv6++;
                                }
                            }
                        } else {
                            maxElem$iv4 = null;
                        }
                        Placeable placeable4 = (Placeable) maxElem$iv4;
                        final Integer bottomBarHeight = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                        final Integer fabOffsetFromBottom = fabPlacement2 != null ? Integer.valueOf((bottomBarHeight == null || FabPosition.m2242equalsimpl0(fabPosition, FabPosition.INSTANCE.m2248getEndOverlayERTFSPs())) ? fabPlacement2.getHeight() + $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing) + contentWindowInsets.getBottom($this$SubcomposeLayout) : bottomBarHeight.intValue() + fabPlacement2.getHeight() + $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing)) : null;
                        if (snackbarHeight != 0) {
                            snackbarOffsetFromBottom = snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : contentWindowInsets.getBottom($this$SubcomposeLayout));
                        } else {
                            snackbarOffsetFromBottom = 0;
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets5 = contentWindowInsets;
                        final Function3<PaddingValues, Composer, Integer, Unit> function8 = function3;
                        List<Measurable> listSubcompose5 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1213360416, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
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
                                float top;
                                float bottom;
                                ComposerKt.sourceInformation($composer3, "C259@11767L21:Scaffold.kt#uh7d8r");
                                if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1213360416, $changed2, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:242)");
                                    }
                                    PaddingValues insets = WindowInsetsKt.asPaddingValues(windowInsets5, $this$SubcomposeLayout);
                                    if (topBarPlaceables.isEmpty()) {
                                        top = insets.getTop();
                                    } else {
                                        top = $this$SubcomposeLayout.mo564toDpu2uoSUM(topBarHeight);
                                    }
                                    if (bottomBarPlaceables.isEmpty() || bottomBarHeight == null) {
                                        bottom = insets.getBottom();
                                    } else {
                                        bottom = $this$SubcomposeLayout.mo564toDpu2uoSUM(bottomBarHeight.intValue());
                                    }
                                    PaddingValues innerPadding = PaddingKt.m864PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), top, PaddingKt.calculateEndPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), bottom);
                                    function8.invoke(innerPadding, $composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }));
                        int $i$f$fastMap5 = 0;
                        List target$iv5 = new ArrayList(listSubcompose5.size());
                        int index$iv$iv5 = 0;
                        int size5 = listSubcompose5.size();
                        while (index$iv$iv5 < size5) {
                            Object item$iv$iv5 = listSubcompose5.get(index$iv$iv5);
                            int $i$f$fastMap6 = $i$f$fastMap5;
                            Measurable it17 = (Measurable) item$iv$iv5;
                            target$iv5.add(it17.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv5++;
                            listSubcompose5 = listSubcompose5;
                            $i$f$fastMap5 = $i$f$fastMap6;
                        }
                        final List bodyContentPlaceables = target$iv5;
                        final WindowInsets windowInsets6 = contentWindowInsets;
                        return MeasureScope.CC.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                List<Placeable> list7 = bodyContentPlaceables;
                                int size6 = list7.size();
                                for (int index$iv = 0; index$iv < size6; index$iv++) {
                                    Object item$iv = list7.get(index$iv);
                                    Placeable it18 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default($this$layout, it18, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list8 = topBarPlaceables;
                                int size7 = list8.size();
                                for (int index$iv2 = 0; index$iv2 < size7; index$iv2++) {
                                    Object item$iv2 = list8.get(index$iv2);
                                    Placeable it19 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default($this$layout, it19, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list9 = snackbarPlaceables;
                                int i5 = layoutWidth;
                                int i6 = snackbarWidth;
                                WindowInsets windowInsets7 = windowInsets6;
                                SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                int i7 = layoutHeight;
                                int i8 = snackbarOffsetFromBottom;
                                int size8 = list9.size();
                                for (int index$iv3 = 0; index$iv3 < size8; index$iv3++) {
                                    Object item$iv3 = list9.get(index$iv3);
                                    Placeable it20 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default($this$layout, it20, ((i5 - i6) / 2) + windowInsets7.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), i7 - i8, 0.0f, 4, null);
                                }
                                List<Placeable> list10 = bottomBarPlaceables;
                                int i9 = layoutHeight;
                                Integer num = bottomBarHeight;
                                int size9 = list10.size();
                                for (int index$iv4 = 0; index$iv4 < size9; index$iv4++) {
                                    Object item$iv4 = list10.get(index$iv4);
                                    Placeable it21 = (Placeable) item$iv4;
                                    Placeable.PlacementScope.place$default($this$layout, it21, 0, i9 - (num != null ? num.intValue() : 0), 0.0f, 4, null);
                                }
                                FabPlacement placement = fabPlacement2;
                                if (placement != null) {
                                    List<Placeable> list11 = fabPlaceables;
                                    int i10 = layoutHeight;
                                    Integer num2 = fabOffsetFromBottom;
                                    int size10 = list11.size();
                                    for (int index$iv5 = 0; index$iv5 < size10; index$iv5++) {
                                        Object item$iv5 = list11.get(index$iv5);
                                        Placeable it22 = (Placeable) item$iv5;
                                        int left = placement.getLeft();
                                        Intrinsics.checkNotNull(num2);
                                        Placeable.PlacementScope.place$default($this$layout, it22, left, i10 - num2.intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                i = 0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv, $composer2, i, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
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

                public final void invoke(Composer composer, int i2) {
                    ScaffoldKt.m2531ScaffoldLayoutFMILGgc(fabPosition, function2, function3, function4, function5, contentWindowInsets, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
