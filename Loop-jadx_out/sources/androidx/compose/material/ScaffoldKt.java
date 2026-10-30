package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p001ui.Modifier;
import androidx.compose.p001ui.graphics.Shape;
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
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a§\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2 \b\u0002\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u009f\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\u0019\b\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2 \b\u0002\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a¨\u0001\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00192\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b22\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0012¢\u0006\u0002\b2H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a!\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010;\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, m195d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, m196k = 2, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = C1979Dp.m6801constructorimpl(16);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv;
        Object value$iv2;
        ComposerKt.sourceInformationMarkerStart($composer, 1569641925, "C(rememberScaffoldState)71@2725L39,72@2809L32,73@2861L62:Scaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, -1962071215, "CC(remember):Scaffold.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            snackbarHostState = (SnackbarHostState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, $changed, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:73)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1962071163, "CC(remember):Scaffold.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv = new ScaffoldState(drawerState, snackbarHostState);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv2;
        }
        ScaffoldState scaffoldState = (ScaffoldState) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return scaffoldState;
    }

    /* JADX INFO: renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    public static final void m1781Scaffoldu4IkXBM(final WindowInsets contentWindowInsets, Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function7, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function8;
        ScaffoldState scaffoldState2;
        Function2<? super Composer, ? super Integer, Unit> function2M1657getLambda1$material_release;
        Function2<? super Composer, ? super Integer, Unit> function2M1658getLambda2$material_release;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M1659getLambda3$material_release;
        Function2<? super Composer, ? super Integer, Unit> function2M1660getLambda4$material_release;
        int floatingActionButtonPosition2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function9;
        boolean drawerGesturesEnabled2;
        CornerBasedShape drawerShape2;
        float drawerElevation2;
        int $dirty1;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        int i2;
        long drawerScrimColor2;
        long backgroundColor2;
        int $dirty;
        Shape drawerShape3;
        long contentColor2;
        long backgroundColor3;
        int $dirty2;
        Modifier modifier2;
        boolean isFloatingActionButtonDocked2;
        ScaffoldState scaffoldState3;
        float drawerElevation3;
        Shape drawerShape4;
        boolean isFloatingActionButtonDocked3;
        ScaffoldState scaffoldState4;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Modifier modifier3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function11;
        boolean drawerGesturesEnabled3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function13;
        int floatingActionButtonPosition3;
        Function2<? super Composer, ? super Integer, Unit> function14;
        long drawerContentColor3;
        long drawerBackgroundColor3;
        long drawerScrimColor3;
        long backgroundColor4;
        long contentColor3;
        Composer $composer2 = $composer.startRestartGroup(-1288630565);
        ComposerKt.sourceInformation($composer2, "C(Scaffold)P(4,15,16,18,1,17,12,13:c#material.FabPosition,14,6,9,11,8:c#ui.unit.Dp,5:c#ui.graphics.Color,7:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)184@8354L23,193@8864L6,195@8979L6,196@9027L38,197@9112L10,198@9167L6,199@9212L32,202@9320L86,205@9435L948:Scaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(contentWindowInsets) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= ((i & 4) == 0 && $composer2.changed(scaffoldState)) ? 256 : 128;
        }
        int i4 = i & 8;
        int i5 = 1024;
        if (i4 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
            function8 = function5;
        } else if (($changed & 1572864) == 0) {
            function8 = function5;
            $dirty3 |= $composer2.changedInstance(function8) ? 1048576 : 524288;
        } else {
            function8 = function5;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changed(floatingActionButtonPosition) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer2.changed(isFloatingActionButtonDocked) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer2.changedInstance(function6) ? 536870912 : 268435456;
        }
        int i12 = i & 1024;
        if (i12 != 0) {
            $dirty4 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty4 |= $composer2.changed(drawerGesturesEnabled) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty4 |= ((i & 2048) == 0 && $composer2.changed(drawerShape)) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty4 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty4 |= $composer2.changed(drawerElevation) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            if ((i & 8192) == 0 && $composer2.changed(drawerBackgroundColor)) {
                i5 = 2048;
            }
            $dirty4 |= i5;
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty4 |= ((i & 16384) == 0 && $composer2.changed(drawerContentColor)) ? 16384 : 8192;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= ((i & 32768) == 0 && $composer2.changed(drawerScrimColor)) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty4 |= ((i & 65536) == 0 && $composer2.changed(backgroundColor)) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            $dirty4 |= ((i & 131072) == 0 && $composer2.changed(contentColor)) ? 8388608 : 4194304;
        }
        if ((i & 262144) != 0) {
            $dirty4 |= 100663296;
        } else if (($changed1 & 100663296) == 0) {
            $dirty4 |= $composer2.changedInstance(function7) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty3 & 306783379) == 306783378 && (38347923 & $dirty4) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            scaffoldState4 = scaffoldState;
            function10 = function2;
            function12 = function3;
            function13 = function4;
            floatingActionButtonPosition3 = floatingActionButtonPosition;
            isFloatingActionButtonDocked3 = isFloatingActionButtonDocked;
            function11 = function6;
            drawerGesturesEnabled3 = drawerGesturesEnabled;
            drawerShape4 = drawerShape;
            drawerElevation3 = drawerElevation;
            drawerBackgroundColor3 = drawerBackgroundColor;
            drawerContentColor3 = drawerContentColor;
            drawerScrimColor3 = drawerScrimColor;
            backgroundColor4 = backgroundColor;
            contentColor3 = contentColor;
            function14 = function8;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    scaffoldState2 = rememberScaffoldState(null, null, $composer2, 0, 3);
                    $dirty3 &= -897;
                } else {
                    scaffoldState2 = scaffoldState;
                }
                function2M1657getLambda1$material_release = i4 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1657getLambda1$material_release() : function2;
                function2M1658getLambda2$material_release = i6 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1658getLambda2$material_release() : function3;
                function3M1659getLambda3$material_release = i7 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1659getLambda3$material_release() : function4;
                function2M1660getLambda4$material_release = i8 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1660getLambda4$material_release() : function5;
                floatingActionButtonPosition2 = i9 != 0 ? FabPosition.INSTANCE.m1707getEnd5ygKITE() : floatingActionButtonPosition;
                boolean isFloatingActionButtonDocked4 = i10 != 0 ? false : isFloatingActionButtonDocked;
                function9 = i11 != 0 ? null : function6;
                drawerGesturesEnabled2 = i12 != 0 ? true : drawerGesturesEnabled;
                int $dirty5 = $dirty3;
                ScaffoldState scaffoldState5 = scaffoldState2;
                if ((i & 2048) != 0) {
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty4 &= -113;
                } else {
                    drawerShape2 = drawerShape;
                }
                drawerElevation2 = i13 != 0 ? DrawerDefaults.INSTANCE.m1676getElevationD9Ej5fM() : drawerElevation;
                if ((i & 8192) != 0) {
                    $dirty1 = $dirty4 & (-7169);
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                } else {
                    $dirty1 = $dirty4;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                boolean isFloatingActionButtonDocked5 = isFloatingActionButtonDocked4;
                if ((i & 16384) != 0) {
                    drawerContentColor2 = ColorsKt.m1645contentColorForek8zF_U(drawerBackgroundColor2, $composer2, ($dirty1 >> 9) & 14);
                    $dirty1 &= -57345;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((32768 & i) != 0) {
                    i2 = 6;
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer2, 6);
                    $dirty1 &= -458753;
                } else {
                    i2 = 6;
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((i & 65536) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, i2).m1620getBackground0d7_KjU();
                    $dirty1 &= -3670017;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 131072) != 0) {
                    $dirty = $dirty5;
                    drawerShape3 = drawerShape2;
                    $dirty2 = $dirty1 & (-29360129);
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty1 >> 18) & 14);
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    backgroundColor3 = backgroundColor2;
                    modifier2 = modifier4;
                    scaffoldState3 = scaffoldState5;
                } else {
                    $dirty = $dirty5;
                    drawerShape3 = drawerShape2;
                    contentColor2 = contentColor;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty1;
                    modifier2 = modifier4;
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    scaffoldState3 = scaffoldState5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 2048) != 0) {
                    $dirty4 &= -113;
                }
                if ((i & 8192) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty4 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty4 &= -3670017;
                }
                if ((i & 131072) != 0) {
                    $dirty4 &= -29360129;
                }
                function2M1657getLambda1$material_release = function2;
                function2M1658getLambda2$material_release = function3;
                floatingActionButtonPosition2 = floatingActionButtonPosition;
                isFloatingActionButtonDocked2 = isFloatingActionButtonDocked;
                function9 = function6;
                drawerGesturesEnabled2 = drawerGesturesEnabled;
                drawerShape3 = drawerShape;
                drawerElevation2 = drawerElevation;
                drawerBackgroundColor2 = drawerBackgroundColor;
                drawerContentColor2 = drawerContentColor;
                drawerScrimColor2 = drawerScrimColor;
                backgroundColor3 = backgroundColor;
                contentColor2 = contentColor;
                $dirty = $dirty3;
                $dirty2 = $dirty4;
                function2M1660getLambda4$material_release = function8;
                modifier2 = modifier;
                scaffoldState3 = scaffoldState;
                function3M1659getLambda3$material_release = function4;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1288630565, $dirty, $dirty2, "androidx.compose.material.Scaffold (Scaffold.kt:201)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1013847540, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Shape drawerShape5 = drawerShape3;
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MutableWindowInsets(contentWindowInsets);
                $composer2.updateRememberedValue(value$iv);
            }
            final MutableWindowInsets safeInsets = (MutableWindowInsets) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final long j = backgroundColor3;
            final long j2 = contentColor2;
            final boolean z = isFloatingActionButtonDocked2;
            final int i14 = floatingActionButtonPosition2;
            final Function2<? super Composer, ? super Integer, Unit> function15 = function2M1657getLambda1$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function16 = function2M1660getLambda4$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function2M1658getLambda2$material_release;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function18 = function3M1659getLambda3$material_release;
            final ScaffoldState scaffoldState6 = scaffoldState3;
            boolean isFloatingActionButtonDocked6 = isFloatingActionButtonDocked2;
            final Function3 child = ComposableLambdaKt.rememberComposableLambda(-219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier5, Composer composer, Integer num) {
                    invoke(modifier5, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier childModifier, Composer $composer3, int $changed2) {
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer3, "C208@9565L236,214@9890L487,206@9472L905:Scaffold.kt#jmzs0o");
                    int $dirty6 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty6 |= $composer3.changed(childModifier) ? 4 : 2;
                    }
                    int $dirty7 = $dirty6;
                    if (($dirty7 & 19) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-219833176, $dirty7, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:206)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer3, 1257871138, "CC(remember):Scaffold.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changed(safeInsets) | $composer3.changed(contentWindowInsets);
                        final MutableWindowInsets mutableWindowInsets = safeInsets;
                        final WindowInsets windowInsets = contentWindowInsets;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets2) {
                                    invoke2(windowInsets2);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(WindowInsets consumedWindowInsets) {
                                    mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, consumedWindowInsets));
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifierOnConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(childModifier, (Function1) value$iv2);
                        long j3 = j;
                        long j4 = j2;
                        final boolean z2 = z;
                        final int i15 = i14;
                        final Function2<Composer, Integer, Unit> function19 = function15;
                        final Function3<PaddingValues, Composer, Integer, Unit> function20 = function7;
                        final Function2<Composer, Integer, Unit> function21 = function16;
                        final MutableWindowInsets mutableWindowInsets2 = safeInsets;
                        final Function2<Composer, Integer, Unit> function22 = function17;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function23 = function18;
                        final ScaffoldState scaffoldState7 = scaffoldState6;
                        SurfaceKt.m1809SurfaceFjzlyU(modifierOnConsumedWindowInsetsChanged, null, j3, j4, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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
                                ComposerKt.sourceInformation($composer4, "C221@10185L85,215@9904L463:Scaffold.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1772955108, $changed3, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:215)");
                                    }
                                    boolean z3 = z2;
                                    int i16 = i15;
                                    Function2<Composer, Integer, Unit> function24 = function19;
                                    Function3<PaddingValues, Composer, Integer, Unit> function25 = function20;
                                    final Function3<SnackbarHostState, Composer, Integer, Unit> function26 = function23;
                                    final ScaffoldState scaffoldState8 = scaffoldState7;
                                    ScaffoldKt.m1782ScaffoldLayouti1QSOvI(z3, i16, function24, function25, ComposableLambdaKt.rememberComposableLambda(433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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
                                            ComposerKt.sourceInformation($composer5, "C222@10207L45:Scaffold.kt#jmzs0o");
                                            if (($changed4 & 3) == 2 && $composer5.getSkipping()) {
                                                $composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(433906483, $changed4, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:222)");
                                            }
                                            function26.invoke(scaffoldState8.getSnackbarHostState(), $composer5, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, $composer4, 54), function21, mutableWindowInsets2, function22, $composer4, CpioConstants.C_ISBLK);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }, $composer3, 54), $composer3, 1572864, 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54);
            if (function9 != null) {
                $composer2.startReplaceGroup(-1013846434);
                ComposerKt.sourceInformation($composer2, "241@10884L19,231@10426L487");
                DrawerKt.m1679ModalDrawerGs3lGvM(function9, modifier2, scaffoldState3.getDrawerState(), drawerGesturesEnabled2, drawerShape5, drawerElevation2, drawerBackgroundColor2, drawerContentColor2, drawerScrimColor2, ComposableLambdaKt.rememberComposableLambda(-1409196448, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
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
                        ComposerKt.sourceInformation($composer3, "C241@10886L15:Scaffold.kt#jmzs0o");
                        if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1409196448, $changed2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:241)");
                        }
                        child.invoke(Modifier.INSTANCE, $composer3, 54);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer2, 54), $composer2, (($dirty >> 27) & 14) | 805306368 | ($dirty & 112) | (($dirty2 << 9) & 7168) | (($dirty2 << 9) & 57344) | (($dirty2 << 9) & 458752) | (($dirty2 << 9) & 3670016) | (($dirty2 << 9) & 29360128) | (234881024 & ($dirty2 << 9)), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1013845925);
                ComposerKt.sourceInformation($composer2, "244@10935L15");
                child.invoke(modifier2, $composer2, Integer.valueOf((($dirty >> 3) & 14) | 48));
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            drawerElevation3 = drawerElevation2;
            drawerShape4 = drawerShape5;
            isFloatingActionButtonDocked3 = isFloatingActionButtonDocked6;
            scaffoldState4 = scaffoldState3;
            function10 = function2M1657getLambda1$material_release;
            modifier3 = modifier2;
            function11 = function9;
            drawerGesturesEnabled3 = drawerGesturesEnabled2;
            function12 = function2M1658getLambda2$material_release;
            function13 = function3M1659getLambda3$material_release;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            function14 = function2M1660getLambda4$material_release;
            drawerContentColor3 = drawerContentColor2;
            drawerBackgroundColor3 = drawerBackgroundColor2;
            drawerScrimColor3 = drawerScrimColor2;
            backgroundColor4 = backgroundColor3;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ScaffoldState scaffoldState7 = scaffoldState4;
            final Function2<? super Composer, ? super Integer, Unit> function19 = function10;
            final Function2<? super Composer, ? super Integer, Unit> function20 = function12;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function21 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function22 = function14;
            final int i15 = floatingActionButtonPosition3;
            final boolean z2 = isFloatingActionButtonDocked3;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function23 = function11;
            final boolean z3 = drawerGesturesEnabled3;
            final Shape shape = drawerShape4;
            final float f = drawerElevation3;
            final long j3 = drawerBackgroundColor3;
            final long j4 = drawerContentColor3;
            final long j5 = drawerScrimColor3;
            final long j6 = backgroundColor4;
            final long j7 = contentColor3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
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

                public final void invoke(Composer composer, int i16) {
                    ScaffoldKt.m1781Scaffoldu4IkXBM(contentWindowInsets, modifier5, scaffoldState7, function19, function20, function21, function22, i15, z2, function23, z3, shape, f, j3, j4, j5, j6, j7, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    public static final void m1780Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function7, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function8;
        int floatingActionButtonPosition2;
        ScaffoldState scaffoldState2;
        Function2<? super Composer, ? super Integer, Unit> function2M1661getLambda5$material_release;
        Function2<? super Composer, ? super Integer, Unit> function2M1662getLambda6$material_release;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3M1663getLambda7$material_release;
        Function2<? super Composer, ? super Integer, Unit> function2M1664getLambda8$material_release;
        boolean isFloatingActionButtonDocked2;
        boolean drawerGesturesEnabled2;
        CornerBasedShape drawerShape2;
        float drawerElevation2;
        int $dirty1;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        long drawerScrimColor2;
        long backgroundColor2;
        int $dirty;
        Shape drawerShape3;
        long contentColor2;
        long backgroundColor3;
        int $dirty2;
        long drawerContentColor3;
        long drawerBackgroundColor3;
        long drawerScrimColor3;
        Modifier modifier2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function9;
        ScaffoldState scaffoldState3;
        Modifier modifier3;
        ScaffoldState scaffoldState4;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function10;
        Shape drawerShape4;
        boolean drawerGesturesEnabled3;
        float drawerElevation3;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        int floatingActionButtonPosition3;
        boolean isFloatingActionButtonDocked3;
        Composer $composer2 = $composer.startRestartGroup(1037492569);
        ComposerKt.sourceInformation($composer2, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)312@14799L23,321@15309L6,323@15424L6,324@15472L38,325@15557L10,326@15612L6,327@15657L32,330@15748L495:Scaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty4 = $changed1;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= ((i & 2) == 0 && $composer2.changed(scaffoldState)) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= CpioConstants.C_ISBLK;
        } else if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty3 |= $composer2.changedInstance(function4) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f245xf2722a21;
            function8 = function5;
        } else if (($changed & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            function8 = function5;
            $dirty3 |= $composer2.changedInstance(function8) ? 131072 : 65536;
        } else {
            function8 = function5;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 1572864) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty3 |= $composer2.changed(floatingActionButtonPosition2) ? 1048576 : 524288;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changed(isFloatingActionButtonDocked) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer2.changedInstance(function6) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer2.changed(drawerGesturesEnabled) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty4 |= ((i & 1024) == 0 && $composer2.changed(drawerShape)) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty4 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty4 |= $composer2.changed(drawerElevation) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty4 |= ((i & 4096) == 0 && $composer2.changed(drawerBackgroundColor)) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            $dirty4 |= ((i & 8192) == 0 && $composer2.changed(drawerContentColor)) ? 2048 : 1024;
        }
        if (($changed1 & CpioConstants.C_ISBLK) == 0) {
            $dirty4 |= ((i & 16384) == 0 && $composer2.changed(drawerScrimColor)) ? 16384 : 8192;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f245xf2722a21) == 0) {
            $dirty4 |= ((i & 32768) == 0 && $composer2.changed(backgroundColor)) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty4 |= ((i & 65536) == 0 && $composer2.changed(contentColor)) ? 1048576 : 524288;
        }
        if ((i & 131072) != 0) {
            $dirty4 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty4 |= $composer2.changedInstance(function7) ? 8388608 : 4194304;
        }
        if (($dirty3 & 306783379) == 306783378 && (4793491 & $dirty4) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            scaffoldState4 = scaffoldState;
            function11 = function2;
            function12 = function3;
            function13 = function4;
            isFloatingActionButtonDocked3 = isFloatingActionButtonDocked;
            function10 = function6;
            drawerGesturesEnabled3 = drawerGesturesEnabled;
            drawerShape4 = drawerShape;
            drawerElevation3 = drawerElevation;
            drawerBackgroundColor3 = drawerBackgroundColor;
            drawerContentColor3 = drawerContentColor;
            drawerScrimColor3 = drawerScrimColor;
            backgroundColor3 = backgroundColor;
            contentColor2 = contentColor;
            function14 = function8;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            $composer2 = $composer2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 2) != 0) {
                    scaffoldState2 = rememberScaffoldState(null, null, $composer2, 0, 3);
                    $dirty3 &= -113;
                } else {
                    scaffoldState2 = scaffoldState;
                }
                function2M1661getLambda5$material_release = i3 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1661getLambda5$material_release() : function2;
                function2M1662getLambda6$material_release = i4 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1662getLambda6$material_release() : function3;
                function3M1663getLambda7$material_release = i5 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1663getLambda7$material_release() : function4;
                function2M1664getLambda8$material_release = i6 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1664getLambda8$material_release() : function5;
                if (i7 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1707getEnd5ygKITE();
                }
                isFloatingActionButtonDocked2 = i8 != 0 ? false : isFloatingActionButtonDocked;
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function15 = i9 != 0 ? null : function6;
                drawerGesturesEnabled2 = i10 != 0 ? true : drawerGesturesEnabled;
                int $dirty5 = $dirty3;
                ScaffoldState scaffoldState5 = scaffoldState2;
                if ((i & 1024) != 0) {
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getLarge();
                    $dirty4 &= -15;
                } else {
                    drawerShape2 = drawerShape;
                }
                drawerElevation2 = i11 != 0 ? DrawerDefaults.INSTANCE.m1676getElevationD9Ej5fM() : drawerElevation;
                if ((i & 4096) != 0) {
                    $dirty1 = $dirty4 & (-897);
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1631getSurface0d7_KjU();
                } else {
                    $dirty1 = $dirty4;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function16 = function15;
                if ((i & 8192) != 0) {
                    drawerContentColor2 = ColorsKt.m1645contentColorForek8zF_U(drawerBackgroundColor2, $composer2, ($dirty1 >> 6) & 14);
                    $dirty1 &= -7169;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 16384) != 0) {
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer2, 6);
                    $dirty1 &= -57345;
                } else {
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((32768 & i) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1620getBackground0d7_KjU();
                    $dirty1 &= -458753;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 65536) != 0) {
                    $dirty = $dirty5;
                    drawerShape3 = drawerShape2;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty1 & (-3670017);
                    drawerContentColor3 = drawerContentColor2;
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerScrimColor3 = drawerScrimColor2;
                    contentColor2 = ColorsKt.m1645contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty1 >> 15) & 14);
                    modifier2 = modifier4;
                    function9 = function16;
                    scaffoldState3 = scaffoldState5;
                } else {
                    $dirty = $dirty5;
                    drawerShape3 = drawerShape2;
                    contentColor2 = contentColor;
                    backgroundColor3 = backgroundColor2;
                    $dirty2 = $dirty1;
                    drawerContentColor3 = drawerContentColor2;
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerScrimColor3 = drawerScrimColor2;
                    modifier2 = modifier4;
                    function9 = function16;
                    scaffoldState3 = scaffoldState5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty3 &= -113;
                }
                if ((i & 1024) != 0) {
                    $dirty4 &= -15;
                }
                if ((i & 4096) != 0) {
                    $dirty4 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty4 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty4 &= -3670017;
                }
                function2M1661getLambda5$material_release = function2;
                function2M1662getLambda6$material_release = function3;
                isFloatingActionButtonDocked2 = isFloatingActionButtonDocked;
                function9 = function6;
                drawerGesturesEnabled2 = drawerGesturesEnabled;
                drawerShape3 = drawerShape;
                drawerElevation2 = drawerElevation;
                drawerBackgroundColor3 = drawerBackgroundColor;
                drawerContentColor3 = drawerContentColor;
                drawerScrimColor3 = drawerScrimColor;
                backgroundColor3 = backgroundColor;
                contentColor2 = contentColor;
                $dirty = $dirty3;
                $dirty2 = $dirty4;
                function2M1664getLambda8$material_release = function8;
                modifier2 = modifier;
                scaffoldState3 = scaffoldState;
                function3M1663getLambda7$material_release = function4;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037492569, $dirty, $dirty2, "androidx.compose.material.Scaffold (Scaffold.kt:329)");
            }
            m1781Scaffoldu4IkXBM(WindowInsetsKt.m938WindowInsetsa9UjIt4$default(C1979Dp.m6801constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier2, scaffoldState3, function2M1661getLambda5$material_release, function2M1662getLambda6$material_release, function3M1663getLambda7$material_release, function2M1664getLambda8$material_release, floatingActionButtonPosition2, isFloatingActionButtonDocked2, function9, drawerGesturesEnabled2, drawerShape3, drawerElevation2, drawerBackgroundColor3, drawerContentColor3, drawerScrimColor3, backgroundColor3, contentColor2, function7, $composer2, (($dirty << 3) & 112) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (($dirty << 3) & 3670016) | (($dirty << 3) & 29360128) | (($dirty << 3) & 234881024) | (($dirty << 3) & 1879048192), (($dirty >> 27) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896) | (($dirty2 << 3) & 7168) | (($dirty2 << 3) & 57344) | (($dirty2 << 3) & 458752) | (($dirty2 << 3) & 3670016) | (($dirty2 << 3) & 29360128) | (($dirty2 << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            scaffoldState4 = scaffoldState3;
            function10 = function9;
            drawerShape4 = drawerShape3;
            drawerGesturesEnabled3 = drawerGesturesEnabled2;
            drawerElevation3 = drawerElevation2;
            function11 = function2M1661getLambda5$material_release;
            function12 = function2M1662getLambda6$material_release;
            function13 = function3M1663getLambda7$material_release;
            function14 = function2M1664getLambda8$material_release;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            isFloatingActionButtonDocked3 = isFloatingActionButtonDocked2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ScaffoldState scaffoldState6 = scaffoldState4;
            final Function2<? super Composer, ? super Integer, Unit> function17 = function11;
            final Function2<? super Composer, ? super Integer, Unit> function18 = function12;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function19 = function13;
            final Function2<? super Composer, ? super Integer, Unit> function20 = function14;
            final int i12 = floatingActionButtonPosition3;
            final boolean z = isFloatingActionButtonDocked3;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function21 = function10;
            final boolean z2 = drawerGesturesEnabled3;
            final Shape shape = drawerShape4;
            final float f = drawerElevation3;
            final long j = drawerBackgroundColor3;
            final long j2 = drawerContentColor3;
            final long j3 = drawerScrimColor3;
            final long j4 = backgroundColor3;
            final long j5 = contentColor2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$3
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
                    ScaffoldKt.m1780Scaffold27mzLpw(modifier5, scaffoldState6, function17, function18, function19, function20, i12, z, function21, z2, shape, f, j, j2, j3, j4, j5, function7, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1782ScaffoldLayouti1QSOvI(final boolean isFabDocked, final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function6, Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(-468424875);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2)390@17673L6677,390@17656L6694:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isFabDocked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & CpioConstants.C_ISBLK) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function5) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(contentWindowInsets) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function6) ? 8388608 : 4194304;
        }
        if (($dirty & 4793491) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-468424875, $dirty, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:389)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2103098973, "CC(remember):Scaffold.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256) | ((57344 & $dirty) == 16384) | ((3670016 & $dirty) == 1048576) | ((458752 & $dirty) == 131072) | (($dirty & 112) == 32) | (($dirty & 14) == 4) | ((29360128 & $dirty) == 8388608) | (($dirty & 7168) == 2048);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                i = 0;
                value$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1784invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1784invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                        Object maxElem$iv;
                        Object maxElem$iv2;
                        FabPlacement fabPlacement;
                        Object maxElem$iv3;
                        Integer numValueOf;
                        final int snackbarOffsetFromBottom;
                        int height;
                        Object maxElem$iv4;
                        Object maxElem$iv5;
                        int fabLeftOffset;
                        int layoutWidth = Constraints.m6744getMaxWidthimpl(constraints);
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
                        List<Measurable> listSubcompose3 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function5);
                        WindowInsets windowInsets3 = contentWindowInsets;
                        int $i$f$fastMap3 = 0;
                        List target$iv3 = new ArrayList(listSubcompose3.size());
                        List<Measurable> list4 = listSubcompose3;
                        int $i$f$fastForEach = 0;
                        int index$iv$iv3 = 0;
                        int size3 = list4.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = list4.get(index$iv$iv3);
                            int $i$f$fastMap4 = $i$f$fastMap3;
                            Measurable measurable = (Measurable) item$iv$iv3;
                            List<Measurable> list5 = list4;
                            int $i$f$fastForEach2 = $i$f$fastForEach;
                            int leftInset3 = windowInsets3.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int i3 = size3;
                            int rightInset2 = windowInsets3.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset2 = windowInsets3.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets4 = windowInsets3;
                            int i4 = (-leftInset3) - rightInset2;
                            int leftInset4 = -bottomInset2;
                            target$iv3.add(measurable.mo5644measureBRTryo0(ConstraintsKt.m6763offsetNN6EwU(looseConstraints, i4, leftInset4)));
                            index$iv$iv3++;
                            listSubcompose3 = listSubcompose3;
                            $i$f$fastMap3 = $i$f$fastMap4;
                            list4 = list5;
                            $i$f$fastForEach = $i$f$fastForEach2;
                            size3 = i3;
                            windowInsets3 = windowInsets4;
                        }
                        final List fabPlaceables = target$iv3;
                        if (!fabPlaceables.isEmpty()) {
                            if (!fabPlaceables.isEmpty()) {
                                maxElem$iv4 = fabPlaceables.get(0);
                                Placeable it7 = (Placeable) maxElem$iv4;
                                int maxValue$iv3 = it7.getWidth();
                                int i$iv3 = 1;
                                int lastIndex3 = CollectionsKt.getLastIndex(fabPlaceables);
                                if (1 <= lastIndex3) {
                                    while (true) {
                                        Object e$iv3 = fabPlaceables.get(i$iv3);
                                        Placeable it8 = (Placeable) e$iv3;
                                        int v$iv3 = it8.getWidth();
                                        if (maxValue$iv3 < v$iv3) {
                                            maxElem$iv4 = e$iv3;
                                            maxValue$iv3 = v$iv3;
                                        }
                                        if (i$iv3 == lastIndex3) {
                                            break;
                                        }
                                        i$iv3++;
                                    }
                                }
                            } else {
                                maxElem$iv4 = null;
                            }
                            Placeable placeable3 = (Placeable) maxElem$iv4;
                            int fabWidth = placeable3 != null ? placeable3.getWidth() : 0;
                            if (!fabPlaceables.isEmpty()) {
                                maxElem$iv5 = fabPlaceables.get(0);
                                Placeable it9 = (Placeable) maxElem$iv5;
                                int maxValue$iv4 = it9.getHeight();
                                int i$iv4 = 1;
                                int lastIndex4 = CollectionsKt.getLastIndex(fabPlaceables);
                                if (1 <= lastIndex4) {
                                    while (true) {
                                        Object e$iv4 = fabPlaceables.get(i$iv4);
                                        Placeable it10 = (Placeable) e$iv4;
                                        int v$iv4 = it10.getHeight();
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
                            Placeable placeable4 = (Placeable) maxElem$iv5;
                            int fabHeight = placeable4 != null ? placeable4.getHeight() : 0;
                            if (fabWidth == 0 || fabHeight == 0) {
                                fabPlacement = null;
                            } else {
                                int i5 = fabPosition;
                                if (FabPosition.m1702equalsimpl0(i5, FabPosition.INSTANCE.m1708getStart5ygKITE())) {
                                    fabLeftOffset = $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth;
                                } else if (FabPosition.m1702equalsimpl0(i5, FabPosition.INSTANCE.m1707getEnd5ygKITE())) {
                                    fabLeftOffset = $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (layoutWidth - $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                } else {
                                    fabLeftOffset = (layoutWidth - fabWidth) / 2;
                                }
                                fabPlacement = new FabPlacement(isFabDocked, fabLeftOffset, fabWidth, fabHeight);
                            }
                        } else {
                            fabPlacement = null;
                        }
                        final FabPlacement fabPlacement2 = fabPlacement;
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function7 = function6;
                        List<Measurable> listSubcompose4 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(424088350, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
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
                                ComposerKt.sourceInformation($composer3, "C475@21173L132:Scaffold.kt#jmzs0o");
                                if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(424088350, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:475)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(fabPlacement2), function7, $composer3, ProvidedValue.$stable);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }));
                        List target$iv4 = new ArrayList(listSubcompose4.size());
                        int index$iv$iv4 = 0;
                        int size4 = listSubcompose4.size();
                        while (index$iv$iv4 < size4) {
                            Object item$iv$iv4 = listSubcompose4.get(index$iv$iv4);
                            List<Measurable> list6 = listSubcompose4;
                            Measurable it11 = (Measurable) item$iv$iv4;
                            target$iv4.add(it11.mo5644measureBRTryo0(looseConstraints));
                            index$iv$iv4++;
                            listSubcompose4 = list6;
                        }
                        final List bottomBarPlaceables = target$iv4;
                        if (!bottomBarPlaceables.isEmpty()) {
                            maxElem$iv3 = bottomBarPlaceables.get(0);
                            Placeable it12 = (Placeable) maxElem$iv3;
                            int maxValue$iv5 = it12.getHeight();
                            int i$iv5 = 1;
                            int lastIndex5 = CollectionsKt.getLastIndex(bottomBarPlaceables);
                            if (1 <= lastIndex5) {
                                while (true) {
                                    Object e$iv5 = bottomBarPlaceables.get(i$iv5);
                                    Placeable it13 = (Placeable) e$iv5;
                                    int v$iv5 = it13.getHeight();
                                    if (maxValue$iv5 < v$iv5) {
                                        maxElem$iv3 = e$iv5;
                                        maxValue$iv5 = v$iv5;
                                    }
                                    if (i$iv5 == lastIndex5) {
                                        break;
                                    }
                                    i$iv5++;
                                }
                            }
                        } else {
                            maxElem$iv3 = null;
                        }
                        Placeable placeable5 = (Placeable) maxElem$iv3;
                        final Integer bottomBarHeight = placeable5 != null ? Integer.valueOf(placeable5.getHeight()) : null;
                        if (fabPlacement2 != null) {
                            WindowInsets windowInsets5 = contentWindowInsets;
                            boolean z = isFabDocked;
                            if (bottomBarHeight == null) {
                                height = fabPlacement2.getHeight() + $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing) + windowInsets5.getBottom($this$SubcomposeLayout);
                            } else if (z) {
                                height = (fabPlacement2.getHeight() / 2) + bottomBarHeight.intValue();
                            } else {
                                height = $this$SubcomposeLayout.mo561roundToPx0680j_4(ScaffoldKt.FabSpacing) + bottomBarHeight.intValue() + fabPlacement2.getHeight();
                            }
                            numValueOf = Integer.valueOf(height);
                        } else {
                            numValueOf = null;
                        }
                        final Integer fabOffsetFromBottom = numValueOf;
                        if (snackbarHeight != 0) {
                            snackbarOffsetFromBottom = snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : contentWindowInsets.getBottom($this$SubcomposeLayout));
                        } else {
                            snackbarOffsetFromBottom = 0;
                        }
                        int bodyContentHeight = layoutHeight - topBarHeight;
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets6 = contentWindowInsets;
                        final Function3<PaddingValues, Composer, Integer, Unit> function8 = function3;
                        List<Measurable> listSubcompose5 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-570781649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
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
                                float fM6801constructorimpl;
                                float bottom;
                                ComposerKt.sourceInformation($composer3, "C526@23329L21:Scaffold.kt#jmzs0o");
                                if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-570781649, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:509)");
                                    }
                                    PaddingValues insets = WindowInsetsKt.asPaddingValues(windowInsets6, $this$SubcomposeLayout);
                                    if (topBarPlaceables.isEmpty()) {
                                        fM6801constructorimpl = insets.getTop();
                                    } else {
                                        fM6801constructorimpl = C1979Dp.m6801constructorimpl(0);
                                    }
                                    if (bottomBarPlaceables.isEmpty() || bottomBarHeight == null) {
                                        bottom = insets.getBottom();
                                    } else {
                                        bottom = $this$SubcomposeLayout.mo564toDpu2uoSUM(bottomBarHeight.intValue());
                                    }
                                    PaddingValues innerPadding = PaddingKt.m864PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), fM6801constructorimpl, PaddingKt.calculateEndPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), bottom);
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
                        List target$iv5 = new ArrayList(listSubcompose5.size());
                        List<Measurable> list7 = listSubcompose5;
                        int $i$f$fastForEach3 = 0;
                        int index$iv$iv5 = 0;
                        int size5 = list7.size();
                        while (index$iv$iv5 < size5) {
                            Object item$iv$iv5 = list7.get(index$iv$iv5);
                            List<Measurable> list8 = listSubcompose5;
                            Measurable it14 = (Measurable) item$iv$iv5;
                            target$iv5.add(it14.mo5644measureBRTryo0(Constraints.m6734copyZbe2FdA(looseConstraints, (11 & 1) != 0 ? Constraints.m6746getMinWidthimpl(looseConstraints) : 0, (11 & 2) != 0 ? Constraints.m6744getMaxWidthimpl(looseConstraints) : 0, (11 & 4) != 0 ? Constraints.m6745getMinHeightimpl(looseConstraints) : 0, (11 & 8) != 0 ? Constraints.m6743getMaxHeightimpl(looseConstraints) : bodyContentHeight)));
                            index$iv$iv5++;
                            listSubcompose5 = list8;
                            list7 = list7;
                            $i$f$fastForEach3 = $i$f$fastForEach3;
                        }
                        final List bodyContentPlaceables = target$iv5;
                        return MeasureScope.CC.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                List<Placeable> list9 = bodyContentPlaceables;
                                int i6 = topBarHeight;
                                int size6 = list9.size();
                                for (int index$iv = 0; index$iv < size6; index$iv++) {
                                    Object item$iv = list9.get(index$iv);
                                    Placeable it15 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default($this$layout, it15, 0, i6, 0.0f, 4, null);
                                }
                                List<Placeable> list10 = topBarPlaceables;
                                int size7 = list10.size();
                                for (int index$iv2 = 0; index$iv2 < size7; index$iv2++) {
                                    Object item$iv2 = list10.get(index$iv2);
                                    Placeable it16 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default($this$layout, it16, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list11 = snackbarPlaceables;
                                int i7 = layoutHeight;
                                int i8 = snackbarOffsetFromBottom;
                                int size8 = list11.size();
                                for (int index$iv3 = 0; index$iv3 < size8; index$iv3++) {
                                    Object item$iv3 = list11.get(index$iv3);
                                    Placeable it17 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default($this$layout, it17, 0, i7 - i8, 0.0f, 4, null);
                                }
                                List<Placeable> list12 = bottomBarPlaceables;
                                int i9 = layoutHeight;
                                Integer num = bottomBarHeight;
                                int index$iv4 = 0;
                                int size9 = list12.size();
                                while (true) {
                                    int iIntValue = 0;
                                    if (index$iv4 >= size9) {
                                        break;
                                    }
                                    Object item$iv4 = list12.get(index$iv4);
                                    Placeable it18 = (Placeable) item$iv4;
                                    if (num != null) {
                                        iIntValue = num.intValue();
                                    }
                                    Placeable.PlacementScope.place$default($this$layout, it18, 0, i9 - iIntValue, 0.0f, 4, null);
                                    index$iv4++;
                                }
                                List<Placeable> list13 = fabPlaceables;
                                FabPlacement fabPlacement3 = fabPlacement2;
                                int i10 = layoutHeight;
                                Integer num2 = fabOffsetFromBottom;
                                int size10 = list13.size();
                                for (int index$iv5 = 0; index$iv5 < size10; index$iv5++) {
                                    Object item$iv5 = list13.get(index$iv5);
                                    Placeable it19 = (Placeable) item$iv5;
                                    Placeable.PlacementScope.place$default($this$layout, it19, fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i10 - (num2 != null ? num2.intValue() : 0), 0.0f, 4, null);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
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
                    ScaffoldKt.m1782ScaffoldLayouti1QSOvI(isFabDocked, fabPosition, function2, function3, function4, function5, contentWindowInsets, function6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
